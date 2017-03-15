
package model.base.*;

import java.io.Serializable;

/**
 * A list is a series of questions.
 *
 * @author Jean-Loup Gaussen
 *
 * @see QuestionBase
 */
public abstract class ListBase implements Serializable {

	/**
	 * The list id.
	 *
	 * @see ListBase#ListBase(int, String, String)
	 */
	public int id;

	/**
	 * The title of the list.
	 *
	 * @see ListBase#ListBase(int, String, String)
	 */
	public String name;

	/**
	 * The name of the list creator.
	 *
	 * @see ListBase#ListBase(int, String, String)
	 */
	public String creator;
	
	/**
	 * Constructor
	 *
	 * @see ListBase#id
	 * @see ListBase#name
	 * @see ListBase#creator
	 */	
	public ListBase(int id, String name, String creator)
	{
		this.id = id;
		this.creator = creator;
		this.name = name;
	}
}
