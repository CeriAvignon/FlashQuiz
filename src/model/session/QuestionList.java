
package model.session;

import java.util.*;
import java.io.Serializable;
import model.base.*;

/**
 * A list is a series of questions.
 *
 * @author Jean-Loup Gaussen, Adrien Sartori
 *
 * @see QuestionBase
 * @see ListBase
 */
public class QuestionList extends ListBase implements Serializable {

	/**
	 * A list that contain all the list questions.
	 */
	public Map<Integer, Question> questions;

	/**
	 * QuestionList constructor
	 */
	public QuestionList(){
	}

	/**
	 * The List constructor.
	 *
	 * @param id
	 *            The list id.
	 */
	public QuestionList(int id) {
		//TODO
	}
}
