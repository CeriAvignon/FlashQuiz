package model.session;

import java.io.Serializable;
import model.base.*;

/**
 * Contain the answer that the user has given to a question, the question and if
 * the user answered to the question or not
 *
 * @author Jean-Loup Gaussen
 *
 */
public class VoterAnswer implements Serializable {
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
	 * @param answersId
	 * 			  Id of the answers
	 */
	public VoterAnswer(String answer, int[] answersId) {
		this.answer = answer;
		// for(Integer id : voterAnswersId)
		// tab answers.add(getVoterAnswerById(id)); // récupération BDD
	}
}
