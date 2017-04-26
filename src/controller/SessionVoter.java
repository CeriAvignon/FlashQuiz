package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.Timer;

import lib.display.*;
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
	 * A list of the voter answers, the integer represent the id of the question
	 * answered.
	 * 
	 * @see VoterAnswer
	 */
	private static VoterAnswerList voterAnswers;

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
	 * The question currently asked.
	 * 
	 * @see Question
	 */
	private static Question currQuestion;

	/**
	 * A timer used when a question have a time limit.
	 */
	private static Timer timer;

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
		case "startNextQuestion":
			if (object instanceof List<?>) {
				for (Object tmp : (List<?>) object) {
					if (!(tmp instanceof Integer)) {
						return false;
					}
				}
				List<Integer> id = (List<Integer>) object;
				if (id.size() == 2) {
					SessionVoter.currListId = id.get(0);
					SessionVoter.currQuestionId = id.get(1);
					startQuestion(currListId, currQuestionId);
				} else {
					return false;
				}

			} else {
				return false;
			}

			break;
		case "forceEndQuestion":
			SessionVoter.endQuestion();
			break;
		case "endSession":
			SessionVoter.endSession();
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
	public static void initialize(List<QuestionList> lists) {
		SessionVoter.lists = lists;
		View.voterWaitingNextQuestion();
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
	 * 
	 * @see SessionVoter#lists
	 * @see Question#allocatedTime
	 * @see SessionVoter#setAllocatedTime(int)
	 */
	public static void startQuestion(Integer listId, Integer questionId) {
		currQuestion = lists.get(listId).questions.get(questionId);

		if (currQuestion.allocatedTime != 0) {
			setAllocatedTime(currQuestion.allocatedTime);
		}
		View.voterDisplayQuestion(currQuestion);
	}

	/**
	 * Send the answer of the current question (call setVoterAnswer). Display a
	 * view until the next question come.
	 * 
	 * @param answer
	 *            The answer given by the voter
	 * 
	 * @see VoterAnswer
	 * @see RemoteServer#sendRequest(String, Object)
	 * @see SessionVoter#voterAnswers
	 */
	public static void sendVoterAnswer(VoterAnswer answer) {
		RemoteServer.sendRequest("setVoterAnswer", answer);
		voterAnswers.put(currQuestionId, answer);
		View.voterDisplayQuestionStatistics(currQuestion, answer);
	}

	/**
	 * End the question, stop the timer if needed, display the result to the
	 * voter (if the answer is correct for example). Can be call by
	 * SessionMaster.
	 * 
	 * @see SessionVoter#setAllocatedTime(int)
	 * @see Question#allocatedTime
	 * 
	 */
	public static void endQuestion() {
		if (currQuestion.allocatedTime != 0) {
			setAllocatedTime(0);
		}
		View.voterWaitingNextQuestion();
	}

	/**
	 * Display the stats of the voter for all the question of this session and a
	 * button that allow the voter to left the session. Send the result of the
	 * voter to the data base.
	 */
	public static void endSession() {
		double average = Statistics.calculateVoterPercentageOfCorrectAnswers(lists,voterAnswers);
		View.voterDisplaySessionStatistics(average);
		voterAnswers.save();
	}

	/**
	 * Set a timer. End the question when delay is finished. (Adapted from the
	 * deprecated class QuestionManagement)
	 * 
	 * @param timeLeft
	 *            The left time you want to set
	 * 
	 * @see QuestionManagement#setAllocatedTime(int)
	 */
	public static void setAllocatedTime(int timeLeft) {

		// convert in milliseconds
		int delay = timeLeft * 1000;

		ActionListener timeOutListener = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				endQuestion();
			}
		};

		SessionVoter.timer = new Timer(delay, timeOutListener);
		SessionVoter.timer.setRepeats(false); // happen once
		SessionVoter.timer.start();
	}
}
