
package votingsession;

import java.util.Vector;

/**
 * A question contain a statement, one or more answers to this statement, a type
 * (checkbox, radio, free) and the time given to answer to the question (<0 if
 * infinite).
 *
 * @author Jean-Loup Gaussen
 */
class Question {

	/**
	 * The question id.
	 *
	 * @see Question#getid()
	 * @see Question#Question(int id, String statement, Vector<Answer> answers,
	 *      String type)
	 */
	private int id;

	/**
	 * The question statement
	 *
	 * @see Question#getStatement()
	 * @see Question#setStatement(String s)
	 * @see Question#Question(int id, String statement, Vector<Answer> answers,
	 *      String type)
	 */
	private String statement;

	/**
	 * The question answers, a vector that contain all the correct answers if
	 * its type is "Free" or 1 (or more) correct answer(s) and wrong answers if
	 * its type is "Radio" or "Checkbox"
	 *
	 * @see Question#getAnswers()
	 * @see Question#setAnswers(Vector<Answer> S)
	 * @see Question#Question(int id, String statement, Vector<Answer> answers,
	 *      String type)
	 * @see Question#type
	 */
	private Vector<Answer> answers;

	/**
	 * Enumerator that contain all the question type
	 */
	public enum Type {
		FREE, RADIO, CHECKBOX;
	}

	/**
	 * The question type ("Type.FREE","Type.RADIO","Type.CHECKBOX")
	 *
	 * @see Question#Type
	 * @see Question#getType()
	 * @see Question#setType(Type type)
	 * @see Question#Question(int id, String statement, Vector<Answer> answers,
	 *      Type type)
	 */
	private Type type;

	/**
	 * Time allocated to the question in seconds (0 if infinite).
	 *
	 * @see Question#getAllocatedTime()
	 * @see Question#setAllocatedTime(int)
	 * @see Session#startQuestionTimer()
	 */
	private int allocatedTime;

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
	public Question(int id, String statement, Vector<Answer> answers,
			Type type) {
		this.id = id;
		this.statement = statement;
		this.answers = answers;
		this.type = type;
	}

	/**
	 * Getter of the question id
	 *
	 * @return An int that contain the question id
	 *
	 * @see Question#id
	 */
	public int getid() {
		return id;
	}

	/**
	 * Getter of the question statement
	 *
	 * @return A string that contain the question statement
	 *
	 * @see Question#statement
	 */
	public String getStatement() {
		return statement;
	}

	/**
	 * Setter of the question statement
	 *
	 * @param s
	 *            A string that contain the question statement
	 *
	 * @see Question#statement
	 */
	public void setStatement(String s) {
		statement = s;
	}

	/**
	 * Get answers number.
	 *
	 * @return The number of answers inside the answers vector.
	 * @see Question#answers
	 * @see Answer
	 */
	public int getAnswersNumber() {
		return answers.size();
	}

	/**
	 * Get the Answer it the specified position inside the answers vector.
	 *
	 * @return An Answer object
	 * @see Question#answers
	 */
	public Answer getAnswerAt(int index) {
		if (getAnswersNumber() < index)
			return null;
		return answers.get(index);
	}

	/**
	 * Getter of the question statement
	 *
	 * @return A string vector that contain the question statement
	 *
	 * @see Question#statement
	 */
	public Vector<Answer> getAnswers() {
		return answers;
	}

	/**
	 * Setter of the question statement
	 *
	 * @param S
	 *            A string that contain the question statement
	 *
	 * @see Question#statement
	 */
	public void setAnswers(Vector<Answer> S) {
		answers = S;
	}

	/**
	 * Getter of the question type
	 *
	 * @return A string that contain the question type
	 *
	 * @see Question#type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Setter of the question statement
	 *
	 * @param s
	 *            A string that contain the question statement
	 *
	 * @see Question#statement
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * Getter of the allocated time for the question.
	 *
	 * @return The number of seconds allocated to the question.
	 *
	 * @see Question#allocatedTime
	 */
	public int getAllocatedTime() {
		return allocatedTime;
	}

	/**
	 * Setter of the allocated time for the question.
	 *
	 * @param allocatedTime
	 *            The new allocated time you want to set.
	 *
	 * @see Question#allocatedTime
	 */
	public void setAllocatedTime(int allocatedTime) {
		this.allocatedTime = allocatedTime;
	}

	/**
	 * Verify if the user's answer is correct
	 *
	 * @param userAns
	 *            The user's answer
	 */
	public boolean verifyAnswer(UserAnswer userAns) {

		// Get the default answers
		Vector<Answer> definedAnswers = new Vector<Answer>();
		definedAnswers = getAnswers();

		// Get the user's answer
		String ans = userAns.getUserAnswer();

		// Get the question's type
		Type type = getType();

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
	}
}
