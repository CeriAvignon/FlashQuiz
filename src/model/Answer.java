
package model;

import java.io.Serializable;

/**
 * The question answer, it can be true, or false in the case of a radio/checkbox
 * question, it's defined by the its creator.
 *
 * @see Question
 *
 * @author Jean-Loup Gaussen
 *
 */
class Answer implements Serializable {
	/**
	 * The answer.
	 *
	 * @see Answer#getContent()
	 * @see Answer#setContent()
	 * @see Answer#Answer(String, boolean)
	 */
	public String content;

	/**
	 * True if the answer is a good one, false else.
	 *
	 * @see Answer#getState()
	 * @see Answer#setState()
	 * @see Answer#Answer(String, boolean)
	 */
	public boolean state;

	public int id;
	
	/**
	 * Constructor of answer.
	 *
	 * @param i 
	 *			  The id of the answer
	 * @param s
	 *            The content of the answer.
	 * @param b
	 *            The state of the answer.
	 * @see Answer#content
	 * @see Answer#state
	 */
	 
	public Answer(int i, String s, boolean b) {
		this.id = i;
		this.content = s;
		this.state = b;
	}

}
