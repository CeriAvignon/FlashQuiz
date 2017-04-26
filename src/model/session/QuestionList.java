package model.session;

import java.util.*;
import java.io.Serializable;
import model.base.*;

/**
 * A list is a series of questions.
 *
 * @author Jean-Loup Gaussen
 *
 * @see QuestionBase
 * @see ListBase
 */
public class QuestionList extends HashMap<Integer, Question>
		implements Serializable {

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
	 * The List constructor.
	 *
	 * @see List#questions
	 */
	public QuestionList() {
		super();
	}

}
