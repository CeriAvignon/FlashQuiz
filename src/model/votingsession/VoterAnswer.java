
package model.votingsession;

import java.io.Serializable;
import model.*;

/**
 * Contain the answer that the user has given to a question, the question and if
 * the user answered to the question or not
 *
 * @author Jean-Loup Gaussen
 *
 */
public class VoterAnswer implements Serializable {
	/**
	 * The question id that the user answered with this answer
	 *
	 * @see Question
	 */
	public int questionId;

	/**
	 * The user answer
	 *
	 */
	public String answer;

	/**
	 * A list that contain the answers
	 *
	 */
	public java.util.List<Integer> answers;

	/**
	 * Constructor of the class VoterAnswer
	 *
	 * @param answer
	 *            An answer
	 * @param questionId
	 *            Id of the question
	 * @param answersId
	 * 			  Id of the answers
	 */
	public VoterAnswer(int questionId, String answer, int[] answersId) {
		this.questionId = questionId;
		this.answer = answer;
		// for(Integer id : voterAnswersId)
		// tab answers.add(getVoterAnswerById(id)); // récupération BDD
	}
}
