
package model;

import java.util.Vector;
import java.io.Serializable;

/**
 * A list is a series of questions.
 *
 * @author Jean-Loup Gaussen
 *
 * @see Question
 */
public abstract class ListBase implements Serializable {

	/**
	 * The list id.
	 *
	 * @see List#getid()
	 * @see List#List(String, int, int, Vector)
	 */
	public int id;

	/**
	 * The title of the list.
	 *
	 * @see List#getName()
	 * @see List#setName(String)
	 * @see List#List(String, int, int, Vector)
	 */
	public String name;

	/**
	 * The id of the list creator.
	 *
	 * @see List#getidCreator()
	 * @see List#setidCreator(int)
	 * @see List#List(String, int, int, Vector)
	 */
	public String creator;
	
	/**
	 * Constructor
	 */	
	public ListBase(int id, String creator, String name)
	{
		this.id = id;
		this.creator = creator;
		this.name = name;
	}
}
