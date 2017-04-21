package model.session;

import java.util.*;
import java.io.Serializable;
import model.base.*;

/**
 * Contain the answer that the user has given to a question, the question and if
 * the user answered to the question or not
 *
 * @author Jean-Loup Gaussen, Adrien Sartori
 */
public class VoterAnswer implements Serializable {
	/**
	 * The user content
	 */
	public String content;

	/**
	 * A list that contain the answers
	 */
	public int[] answersId;

	/**
	 * VoterAnswer constructor
	 */
	public VoterAnswer(){
	}

	/**
	 * Constructor of the class VoterAnswer
	 */
	public VoterAnswer(int id) {
		//TODO
	}
}
