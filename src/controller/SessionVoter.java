package controller;

import java.util.List;
import java.util.Map;
import lib.display.*;
import model.base.*;
import model.session.*;

/**
 * The voter session is the local session created by the voter when he connects
 * in the master session, it manages the questions changing every time a answer
 * is given by the voter.
 * 
 * @author Jean-Loup
 *
 */
public abstract class SessionVoter {

	/**
	 * The session name, given by the session master.
	 */
	// private static String name;

	/**
	 * A list of the voter answers, the integer represent the id of the voter
	 * answer.
	 */
	private static Map<Integer, VoterAnswer> voterAnswers;

	/**
	 * The list of all the question list the session have.
	 */
	private static List<QuestionList> lists;

	/**
	 * The id of the list which the current question came from.
	 */
	private static Integer currListId;

	/**
	 * The id of the question currently asked.
	 */
	private static Integer currQuestionId;

	/**
	 * The command interpreter, execute an action on an object.
	 * 
	 * @param action
	 *            The action wanted on the object
	 * @param object
	 *            The object on which the action is made
	 * @return True if the action was found, False if not
	 */
	public static Boolean interpreter(String action, Object object) {
		switch (action) {
		case "printReceived":
			printReceived((String) object);
			break;
		case "initialize":
			initialize((List<QuestionList>) object); // %TODO%
			break;
		default:
			return false;
		}
		return true;
	}

	/**
	 * Print the string received from another session.
	 * 
	 * @param s
	 *            The string received
	 */
	public static void printReceived(String s) {
		Console.printAsync(Ansi.GREEN + "Reçu: " + Ansi.RESET + s);
	}

	/**
	 * Send a line to the server to make it capitalise it.
	 * 
	 * @param line
	 *            The line to capitalise
	 */
	public static void capitalize(String line) {
		RemoteServer.sendRequest("capitalize", line);
	}

	/**
	 * Initialise the voter session and display a view until the first question
	 * is launch.
	 * 
	 * @param name
	 *            The session name
	 * @param list
	 *            The question list of the session
	 */
	public static void initialize(/* String name, */ List<QuestionList> lists) {
		SessionVoter.lists = lists;
		// SessionVoter.name = name;

		// display view %TODO%
	}

	/**
	 * Start a question given by id from a list given by id, start the timer if
	 * needed, display a view that match to the question type. Called by
	 * SessionMaster.
	 * 
	 * @param listId
	 *            The id of the list which contain the question
	 * @param questionId
	 *            The id of the question in the list
	 */
	public static void startQuestion(Integer listId, Integer questionId) {
		// %TODO%
	}

	/**
	 * Send the answer of the current question (call setVoterAnswer). Display a
	 * view until the next question come.
	 * 
	 * @param answer
	 *            The answer given by the voter
	 */
	public static void sendAnswer(Answer answer) {
		// %TODO%
	}

	/**
	 * End the question, stop the timer if needed, display the result to the
	 * voter (if the answer is correct). Can be call by SessionMaster.
	 * 
	 */
	public static void endQuestion() {
		// %TODO%
	}

	/**
	 * Display the final stats of the voter for all the question of this session
	 * Send the result of the voter to the data base. Display a view that allow
	 * the voter to left the session.
	 */
	public static void endSession() {
		// %TODO%
	}
}
