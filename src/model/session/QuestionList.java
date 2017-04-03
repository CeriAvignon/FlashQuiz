
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
public class QuestionList extends ListBase implements Serializable {

	/**
	 * A list that contain all the list questions.
	 *
	 * @see Question
	 * @see ListBase#ListBase(int,String, String)
	 */
	public Map<Integer, Question> questions;

	/**
	 * The List constructor.
	 *
	 * @param id
	 *            The list id.
	 * @param name
	 *            The list name.
	 * @param creatorName
	 *            The creator name.
	 * @param questionsID
	 *			  All the id of the questions
	 *
	 * @see List#questions
	 */
	public QuestionList(int id, String name, String creatorName, int[] questionsId) {
		super(id, name, creatorName);
		// for(Integer question : questionsId)
			// questions.add(getQuestion(question)); // QuestionHandler 

	}

}
