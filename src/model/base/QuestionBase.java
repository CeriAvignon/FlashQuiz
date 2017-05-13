package model.base;

import java.io.Serializable;

/**
 * A question contain a statement, one or more answers to this statement, a type
 * (checkbox, radio, free) and the time given to answer to the question (less than 0 if
 * infinite).
 *
 * @author Jean-Loup Gaussen, Adrien Sartori
 */
public abstract class QuestionBase implements Serializable {

	/**
	 * The question id.
	 */
	public int id;

	/**
	 * The question statement
	 */
	public String statement;

	/**
	 * The type of the question
	 */
	public int type;

	/**
	 * Time allocated to the question in seconds (0 if infinite).
	 */
	public int allocatedTime;
}
