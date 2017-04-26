package controller;

import lib.server.*;
import lib.net.*;
import lib.display.*;
import model.base.*;
import model.session.*;
import java.util.*;

//=============================================================================
// ▼ SessionMaster
// ----------------------------------------------------------------------------
//
//=============================================================================
public abstract class SessionMaster
{

	private static String name; // nom de la session
	private static String password; // mot de passe pour accéder à la session
	private static Boolean questionOrderIsRandom;

	private static VotersAnswersList votersAnswers; //
	private static List<Integer> questionsUnvoted; // liste des index des questions de la liste courante encore non votées
	private static List<Double> scores;
	private static List<QuestionList> lists; // liste des listes de questions

	private static Integer currListId;
	private static Integer currQuestionId;




	//---------------------------------------------------------------------------
	// * Interpreter
	// Effectue l'action appropriée sur l'objet envoyé en fonction du nom de
	// l'action.
	//---------------------------------------------------------------------------
	public static Boolean interpreter(ClientHandler client, String action, Object object)
	{
		switch(action) {
			case "capitalize":
				capitalize(client, (String) object);
				break;

			case "setVoterAnswer":
				setVoterAnswer(client, (VoterAnswer)object);
				break;

			default:
				return false;
		}
		return true;
	}

	//---------------------------------------------------------------------------
	// * Capitalize
	// Renvoie la chaîne de caractères envoyée par le client en majuscules.
	//---------------------------------------------------------------------------
	private static void capitalize(ClientHandler client, String message)
	{
		if(!LocalServer.checkIsOpened()) return;
		client.sendRequest("printReceived",message.toUpperCase());
	}

	//---------------------------------------------------------------------------
	// * Send message to all
	// Envoie un message à tous les clients connectés.
	//---------------------------------------------------------------------------
	public static void sendMessageToAll(String message)
	{
		if(!LocalServer.checkIsOpened()) return;
		Clients.sendRequestToAll("printReceived", message);
	}

	//---------------------------------------------------------------------------
	// * initialize
	// définis tout les attributs majeurs lor sde la création de la session
	//---------------------------------------------------------------------------
	public static void initialize(String name, String password, int[] idList, Boolean questionOrderIsRandom) {

		SessionMaster.name = name;
		SessionMaster.password = password;
		SessionMaster.questionOrderIsRandom = questionOrderIsRandom;
		SessionMaster.scores = new ArrayList<Double>();

		LocalServer.open(9090);

	}

	//---------------------------------------------------------------------------
	// * Start
	// Demarrage du questionnaire, plus de clients acceptées.
	//---------------------------------------------------------------------------
	public static void start() {

		LocalServer.stopListening();
		SessionMaster.currListId = -1;

		startNextQuestion();
	}

	//---------------------------------------------------------------------------
	// * startNextQuestion
	// Passe a la question suivante.
	//---------------------------------------------------------------------------
	public static void startNextQuestion() {

		// Si il reste des questions non répondues, vide au commencement d'une liste
	    if(!questionsUnvoted.isEmpty()) {
	        int currQuestionId = questionsUnvoted.get(0);

	        int[] listIdAndQuestionId = new int[2];
	        listIdAndQuestionId[0] = currListId;
	        listIdAndQuestionId[1] = currQuestionId;

	        questionsUnvoted.remove(currQuestionId);
	        Question nextQuestion = lists.get(currListId).questions.get(currQuestionId);

	        LocalServer.sendRequestToAll("startQuestion", listIdAndQuestionId);
	        // appeler la vue en envoyant nextQuestion
	    } else { // si on était à la dernière question de la liste courante

	        if(currListId == lists.size() - 1) // si on était à la dernière liste
	            endSession();
	        else {

	            currListId++; // on passe à la liste suivante
	            for(int questionId : lists.get(currListId).questions.keySet())
	                questionsUnvoted.add(questionId);
	            if(questionOrderIsRandom)
	                Collections.shuffle(questionsUnvoted);
	        }
		}
	
	}

	//---------------------------------------------------------------------------
	// * setVoterAnwer
	// Récupere les réponses entrées pas le client pour la question courante.
	//---------------------------------------------------------------------------
	public static void setVoterAnswer(ClientHandler client, VoterAnswer answer) {

		// votersAnswers.addAnswer(userId, currQuestionId);
		if(votersAnswers.getAnswersByQuestion(currQuestionId).size() == votersAnswers.size())
			endQuestion();
	}


	//---------------------------------------------------------------------------
	// * forceEndQuestion
	// Force la fin de question par admin.
	//---------------------------------------------------------------------------
	public static void forceEndQuestion() {
		// Envoi un signal a tout les clients disant de passer a la question suivante
		LocalServer.sendRequestToAll("forceEndQuestion", null);
	}


	//---------------------------------------------------------------------------
	// * endQuestion
	// Affiche les stats globales de la question.
	//---------------------------------------------------------------------------
	public static void endQuestion() {

		LocalServer.sendRequestToAll("forceEndQuestion", null);
		Statistics.displayQuestionStats(votersAnswers.getAnswersByQuestion(currQuestionId), lists.get(currListId).questions.get(currQuestionId));
		// %TODO% -> Afficher close session via IG function
	}


	//---------------------------------------------------------------------------
	// * endSession
	// Envoie tout les résultats à la BDD et affiche les stats.
	//---------------------------------------------------------------------------
	public static void endSession() {
		
		Statistics.displaySessionStatAverage(votersAnswers);
		LocalServer.sendRequestToAll("endSession", null);
		// %TODO% -> enoyer stat a la BDD

	}



}
