
package model.votingsession;

import java.io.Serializable;
import java.util.Vector;
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
	 * @see VoterAnswer#getQuestionId()
	 * @see VoterAnswer#setQuestionId(int)
	 */
	public int questionId;

	/**
	 * The user answer
	 *
	 * @see VoterAnswer#getVoterAnswer()
	 * @see VoterAnswer#setVoterAnswer(String)
	 */
	public String answer;

	public Vector<Integer> answers;

	/**
	 * Constructor of the class VoterAnswer
	 *
	 * @param String
	 *            An answer
	 * @param int
	 *            Id of the question
	 *
	 * @see VoterAnswer#setVoterAnswer(String)
	 * @see VoterAnswer#setQuestionId(int)
	 */
	public VoterAnswer(int questionId, String answer, int[] answersId) {
		this.questionId = questionId;
		this.answer = answer;
		
	}

}
