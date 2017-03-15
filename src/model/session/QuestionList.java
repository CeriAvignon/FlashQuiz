
package model.session;

import java.util.List;
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
	public List<Question> questions;

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
	public QuestionList(int id, String name, String creatorName, int[]
			 questionsId) {
		super(id, name, creatorName);
		// for(Integer question : questionsId)
			// questions.add(getQuestion(question)); // QuestionHandler 

	}

	/**
	 * Add a question to the list. Return the new question index inside the list
	 * (normally the size of the questions vector).
	 *
	 * @return The question index inside the list.
	 *
	 * @see List#questions
	 */
	public int addQuestion(Question question) {
		questions.add(question);
		return questions.size();
	}
}
