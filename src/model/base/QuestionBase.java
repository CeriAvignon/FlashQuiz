package model.base;

import java.io.Serializable;

/**
 * A question contain a statement, one or more answers to this statement, a type
 * (checkbox, radio, free) and the time given to answer to the question (<0 if
 * infinite).
 *
 * @author Jean-Loup Gaussen
 */
public abstract class QuestionBase implements Serializable {

	/**
	 * The question id.
	 *
	 * @see QuestionBase#QuestionBase(int id, int type, String statement,
	 *      int allocatedTime)
	 */
	public int id;

	/**
	 * The question statement
	 *
	 * @see Question#Question(int id, String statement, Vector<Answer> answers,
	 *      String type)
	 */
	public String statement;

	/**
	 * Time allocated to the question in seconds (0 if infinite).
	 *
	 */
	public int allocatedTime;

	/**
	 * The type of the question
	 *
	 */
	public int type;

	/**
	 * Constructor
	 *
	 * @param id
	 *			  The id of the question
	 * @param statement
	 *            The statement of the question.
	 * @param type
	 *            The type of the question.
	 * @param allocatedTime
	 * 			  Time allocated to the question
	 * @see QuestionBase#id
	 * @see QuestionBase#statement
	 * @see QuestionBase#type
	 * @see QuestionBase#allocatedTime
	 */
	public QuestionBase(int id, String statement, int type, int allocatedTime) {
		this.id = id;
		this.statement = statement;
		this.type = type;
		this.allocatedTime = allocatedTime;
	}
}
