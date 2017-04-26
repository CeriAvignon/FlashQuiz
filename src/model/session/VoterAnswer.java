package model.session;

import java.util.*;
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
	 * The user content
	 *
	 */
	public String content;

	/**
	 * A list that contain the answers
	 *
	 */
	public List<Integer> answersId;

	/**
	 * Constructor of the class VoterAnswer
	 *
	 * @param content
	 *            An answer
	 * @param answersId
	 * 	      Id of the answers
	 */
	public VoterAnswer(String content, List<Integer> answersId) {
		this.content = content;
		this.answersId = answersId;
	}

	/**
	 * Constructor of the class VoterAnswer
	 *
	 * @param content
	 *            An answer
	 * @param answersId
	 * 	      Id of the answers
	 */
	public VoterAnswer(String content, int[] answersId) {
		this.content = content;
		// for(Integer id : voterAnswersId)
		// tab answers.add(getVoterAnswerById(id)); // récupération BDD
	}

	/**
	 * Constructor of the class VoterAnswer
	 *
	 * @param content
	 *            An answer
	 */
	public VoterAnswer(String content) {
		this.content = content;
	}
}
