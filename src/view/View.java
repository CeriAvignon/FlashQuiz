package view;

import model.base.*;
import model.session.*;
import view.android.*;
import view.desktop.*;

/**
 * Class that gather views calls, depending on the platform.
 */
public abstract class View
{
	public enum Platform {android, desktop};
	public static Platform platform;


	// Exemple :
	public static void login() {
		switch(platform) {
			case android:
				System.out.println("Login Android!");
				// Login login = new view.android.Login();
				break;
			case desktop:
				System.out.println("Login Desktop!");
				// Login login = new view.desktop.Login();
				break;
			default:
				// erreur
		}
	}

	//=============================================================================
	// ▼ Session Voter
	// Point de vue votant, en cours de session.
	//=============================================================================

	// Vue intermédiaire en attente de la prochaine question
	public static void voterWaitingNextQuestion()
	{

	}

	// Affiche la question et les champs pour répondre
	public static void voterDisplayQuestion(Question question)
	{

	}

	// Affiche le résultat de la question + correction
	public static void voterDisplayQuestionStatistics(Question question, VoterAnswer voterAnswer)
	{

	}

	// Affiche les statistiques générales pour la session (% bonnes réponses) + bouton quitter session
	public static void voterDisplaySessionStatistics(double average)
	{

	}


	//=============================================================================
	// ▼ Session Master
	// Point de vue chef de session, en cours de session.
	//=============================================================================

	// Affiche la question et le bouton "forcer le passage à la question suivante"
	public static void masterDisplayQuestion(Question question)
	{

	}

	// Affiche les résultats de la question
	// average est le pourcentage de bonnes réponses pour la question + le bouton
	// pour passer à la question suivante.
	// Si vous affichez aussi les résultats individuels, on peut rajouter l'attribut:
	// VoterAnswerList voterAnswerList
	public static void masterDisplayQuestionStatistics(Question question, double average)
	{

	}

	// Affiche les résultats générals pour la session
	// average est le pourcentage de bonnes réponses pour toutes les questions de la session
	public static void masterDisplaySessionStatistics(double average)
	{

	}

	//=============================================================================
	// ▼ User statistics
	// Affiche les statistiques des anciennes sessions.
	//=============================================================================

	// Affiche les statistiques générales pour une session pour un utilisateur
	public static void userDisplayAverageStatistics(Session session, double average)
	{

	}

	// Affiche les statistiques générales pour une session pour tous les utilisateurs
	public static void sessionDisplayAverageStatistics(Session session, double average)
	{

	}
}
