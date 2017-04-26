package view;

import model.base.*;
import model.session.*;
import view.android.*;
import view.desktop.*;
import ig.flash;
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
				loginActivity login = new onCreate(savedInstanceState);
				break;
			case desktop:
				System.out.println("Login Desktop!");
				Login d_login = new Login();
				break;
			default:
				// erreur
		}
		
	public static void menu() {
	switch(platform) {
		case android:
			System.out.println("Menu Android!");
			loginActivity menu = new onCreate(savedInstanceState);
			break;
		case desktop:
			System.out.println("Menu Desktop!");
			Menu d_menu = new Menu();
			break;
		default:
			// erreur
	}
		
	public static void param() {
	switch(platform) {
		case android:
			System.out.println("Param Android!");
			// Penu param = new view.android.Param();
			break;
		case desktop:
			System.out.println("Param Desktop!");
			Param d_param = new Param();
			break;
		default:
			// erreur
	}
		
	public static void recap() {
	switch(platform) {
		case android:
			System.out.println("Android!");
		
			break;
		case desktop:
			Recap recap_final = new Recap();
			break;
		default:
			// erreur
	}
		
	public static void reponse() {
	switch(platform) {
		case android:
			System.out.println("Android!");
		
			break;
		case desktop:
			Reponse reponse = new Reponse();
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
		FinQuestion vue = new onCreate(savedInstanceState);
	}

	// Affiche la question et les champs pour répondre
	public static Answer voterDisplayQuestion(Question question)
	{
		StartSession vue = new onCreate(savedInstanceState,question);
		return vue.Reponse();
	}

	// Affiche le résultat de la question + correction
	public static void voterDisplayQuestionStatistics(Question question, VoterAnswer voterAnswer)
	{

	}

	// Affiche les statistiques générales pour la session (% bonnes réponses) + bouton quitter session
	public static void voterDisplaySessionStatistics(double average)
	{
		RecapAll vue = new onCreate(savedInstanceState,average); 
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
		stat1Activity vue = new onCreate(savedInstanceState,average);
	}

	//=============================================================================
	// ▼ User statistics
	// Affiche les statistiques des anciennes sessions.
	//=============================================================================

	// Affiche les statistiques générales pour une session pour un utilisateur
	public static void userDisplayAverageStatistics(Session session, double average)
	{
		stat1Activity vue = new onCreate(savedInstanceState,average);
	}

	// Affiche les statistiques générales pour une session pour tous les utilisateurs
	public static void sessionDisplayAverageStatistics(Session session, double average)
	{
		stat2Activity vue = new onCreate(savedInstanceState,average);
	}
}
