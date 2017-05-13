package model.base;

import java.io.Serializable;

/**
 * A list is a series of questions.
 *
 * @author Jean-Loup Gaussen, Adrien Sartori
 *
 * @see QuestionBase
 */
public abstract class ListBase implements Serializable {

	/**
	 * The list id.
	 */
	public int id;

	/**
	 * The title of the list.
	 */
	public String name;

	/**
	 * The name of the list creator.
	 */
	public String creator;

}
