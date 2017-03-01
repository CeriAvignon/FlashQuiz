package model;

import java.util.Vector;
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
	 * @see Question#getid()
	 * @see Question#Question(int id, String statement, Vector<Answer> answers,
	 *      String type)
	 */
	public int id;

	/**
	 * The question statement
	 *
	 * @see Question#getStatement()
	 * @see Question#setStatement(String s)
	 * @see Question#Question(int id, String statement, Vector<Answer> answers,
	 *      String type)
	 */
	public String statement;

	/**
	 * Time allocated to the question in seconds (0 if infinite).
	 *
	 * @see Question#getAllocatedTime()
	 * @see Question#setAllocatedTime(int)
	 * @see Session#startQuestionTimer()
	 */
	public int allocatedTime;

	public int type;
	
	//public String title;
	
	public QuestionBase(int id, String title, String statement, int type, int allocatedTime) {
		this.id = id;
		this.title = title;
		this.statement = statement;
		this.type = type;
		this.allocatedTime = allocatedTime;
	}
}
