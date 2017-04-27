package model.base;

import java.io.Serializable;

/**
 * The question answer, it can be true, or false in the case of a radio/checkbox
 * question, it's defined by the its creator.
 *
 * @see QuestionBase
 *
 * @author Jean-Loup Gaussen, Adrien Sartori
 *
 */
public class Answer implements Serializable {
	/**
	 * The id of the answer
	 *
	 * @see Answer#Answer(int,String, boolean)
	 */
	public int id;

	/**
	 * The answer.
	 *
	 * @see Answer#Answer(int,String, boolean)
	 */
	public String content;

	/**
	 * True if the answer is a good one, false else.
	 *
	 * @see Answer#Answer(int,String, boolean)
	 */
	public boolean state;

	/**
	 * Constructor of answer.
	 */
	public Answer() {
		AnswerHandler.sendAnswer(this);
	}
}
