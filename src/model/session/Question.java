package model.session;

import java.util.*;
import java.io.Serializable;
import model.base.*;

/**
 * A question contain a statement, one or more answers to this statement, a type
 * (checkbox, radio, free) and the time given to answer to the question (less than 0 if
 * infinite).
 *
 * @see QuestionBase
 *
 * @author Jean-Loup Gaussen, Adrien Sartori
 */
public class Question extends QuestionBase implements Serializable {
	/**
	 * Defined answers for the question.
	 */
	public Answer[] answers;
	
	/**
	 * Question constructor
	 */
	public Question(){
	}
	
	/**
	 * Constructor
	 */
	public Question(int id) {
		//TODO
	}
}
