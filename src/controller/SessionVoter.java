package controller;

import java.util.List;
import java.util.Map;

import javax.swing.Timer;

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
 * @see SessionMaster
 *
 */
public abstract class SessionVoter {

	/**
	 * The session name, given by the session master.
	 */
	// private static String name;

	/**
	 * A list of the voter answers, the integer represent the id of the question
	 * answered.
	 * 
	 * @see VoterAnswer
	 */
	private static Map<Integer, VoterAnswer> voterAnswers;

	/**
	 * The list of all the question list the session have.
	 * 
	 * @see QuestionList
	 */
	private static List<QuestionList> lists;

	/**
	 * The id of the list which the current question came from.
	 * 
	 * @see QuestionList
	 */
	private static Integer currListId;

	/**
	 * The id of the question currently asked.
	 * 
	 * @see Question
	 */
	private static Integer currQuestionId;

	/**
	 * A timer used when a question have a time limit.
	 */
	private Timer timer;

	/**
	 * The command interpreter, execute an action on an object. Mostly used when
	 * the session master need to make the voter session to do something.
	 * 
	 * @param action
	 *            The action wanted on the object
	 * @param object
	 *            The object on which the action is made
	 * @return True if the action was found, False if not
	 * 
	 * @see SessionVoter#initialize(List)
	 * @see SessionVoter#startQuestion(Integer, Integer)
	 */
	@SuppressWarnings("unchecked")
	public static Boolean interpreter(String action, Object object) {
		switch (action) {
		case "printReceived":
			printReceived((String) object);
			break;
		case "initialize":
			// Check if the object is a List
			if (object instanceof List<?>) {
				// Check if every elements of this list is a QuestionList
				for (Object tmp : (List<?>) object) {
					if (!(tmp instanceof QuestionList)) {
						return false;
					}
				}
				initialize((List<QuestionList>) object);
			} else {
				return false;
			}
			break;
		case "startQuestion":
			if (object instanceof List<?>) {
				for (Object tmp : (List<?>) object) {
					if (!(tmp instanceof Integer)) {
						return false;
					}
				}
				List<Integer> id = (List<Integer>) object;
				if (id.size() == 2) {
					currListId = id.get(0);
					currQuestionId = id.get(1);
					startQuestion(currListId, currQuestionId);
				} else {
					return false;
				}

			} else {
				return false;
			}

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
	 * 
	 * @see Ansi
	 */
	public static void printReceived(String s) {
		Console.printAsync(Ansi.GREEN + "Reçu: " + Ansi.RESET + s);
	}

	/**
	 * Send a line to the server to make it capitalise it.
	 * 
	 * @param line
	 *            The line to capitalise
	 * 
	 * @see RemoteServer
	 * @see RemoteServer#sendRequest(String, Object)
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
	 * 
	 * @see QuestionList
	 * @see SessionVoter#lists
	 */
	public static void initialize(/* String name, */ List<QuestionList> lists) {
		SessionVoter.lists = lists;
		// SessionVoter.name = name;

		// display_waiting_view (IG) %TODO%
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
		// getList(listId); (BDD) %TODO%
		// getQuestion(questionId); (BDD) %TODO%

		// display_question_view(); (IG) %TODO%

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
