
package model.votingsession;

import java.util.Vector;
import java.io.Serializable;
import model.*;

/**
 * A question contain a statement, one or more answers to this statement, a type
 * (checkbox, radio, free) and the time given to answer to the question (<0 if
 * infinite).
 *
 * @author Jean-Loup Gaussen
 */
public class Question extends QuestionBase implements Serializable {

	public Vector<Answer> answers;
	
	/**
	 * Question constructor
	 *
	 * @param id
	 *            An int that contain the question id
	 * @param statement
	 *            A string that contain the question statement
	 * @param answers
	 *            A vector that contain the question answers
	 * @param type
	 *            A string that contain the question type (Free,Radio,Checkbox)
	 *
	 * @see Question#id
	 * @see Question#statement
	 * @see Question#answers
	 * @see Question#type
	 */
	public Question(int id, String title, String statement, String type, int allocatedTime, int[] answersId) {
		super(id, title, statement, type, allocatedTime);
		// for(Integer answer : answersId)
			// this.answers.add(getAnswer(answer)); // AnswerHandler 
	}

	public void addAnswer(Answer ans)
	{
		//TODO
	}	

	/**
	 * Verify if the user's answer is correct
	 *
	 * @param userAns
	 *            The user's answer
	 */
	/*public boolean verifyAnswer(VoterAnswer voterAns) {

		// Get the default answers
		Vector<Answer> definedAnswers = new Vector<Answer>();
		definedAnswers = getAnswers();

		// Get the user's answer
		String ans = voterAns.getUserAnswer();

		// Get the question's type
		//Type type = getType();

		if (type.toString() == "FREE") {

			for (int i = 0; i <= definedAnswers.size(); i++) {
				String test = definedAnswers.get(i).getContent();

				if (ans.toLowerCase().contains(test.toLowerCase())) {
					return true;
				}
			}

		} else if (type.toString() == "RADIO") {

			for (int i = 0; i <= definedAnswers.size(); i++) {
				if (definedAnswers.get(i).getState()) {
					if (definedAnswers.get(i).getContent() == ans) {
						return true;
					}
				}
			}
		} else if (type.toString() == "CHECKBOX") {

			int cpt = 0; // Counts correct answer
			int cpt2 = 0; // Counts user's correct answers

			// Counts the number of correct answers
			for (int i = 0; i < definedAnswers.size(); i++) {
				if (definedAnswers.get(i).getState())
					cpt++;
			}

			// Split the user's answers
			String[] delimited = new String[cpt];
			delimited = ans.split(",");

			// Counts the number of user's correct answers
			for (int i = 0; i < definedAnswers.size(); i++) {
				for (int j = 0; j < delimited.length; j++) {
					if (delimited[i] == definedAnswers.get(i).getContent())
						cpt2++;
				}
			}
			if (cpt == cpt2) {
				return true;
			}
		}
		return false;
	}*/
}
