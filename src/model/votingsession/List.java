
package model.votingsession;

import java.util.Vector;
import java.io.Serializable;
import model.*;

/**
 * A list is a series of questions.
 *
 * @author Jean-Loup Gaussen
 *
 * @see Question
 */
public class List extends ListBase implements Serializable {

	/**
	 * A vector that contain all the list questions.
	 *
	 * @see Question
	 * @see List#getQuestions()
	 * @see List#setQuestions(Vector)
	 * @see List#getQuestionsSize()
	 * @see List#getQuestionAt(int)
	 * @see List#List(String, int, int, Vector)
	 */
	public Vector<Question> questions;

	/**
	 * The List constructor.
	 *
	 * @param name
	 *            The list name.
	 * @param idCreator
	 *            The creator id.
	 * @param id
	 *            The list id.
	 *
	 * @see List#name
	 * @see List#idCreator
	 * @see List#id
	 * @see List#questions
	 */
	public List(int id, String name, String creatorName, int[]
			 questionsId) {
		super(id, name, creatorName);
		// for(Integer question : questionsId)
			// this.questions.add(getQuestion(question)); // QuestionHandler 

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
		this.questions.add(question);
		return questions.size();
	}
}
