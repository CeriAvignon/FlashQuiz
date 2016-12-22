import java.util.Vector;

/**
 * A question contain a statement, one or more answers to this statement, a type
 * (checkbox, radio, free) and the time given to answer to the question (<0 if
 * infinite).
 *
 * @author Jean-Loup Gaussen
 */
public class Question {

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
	 * Time allocated to the question in seconds.
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
	public Question(int id, String statement, Vector<Answer> answers, Type type) {
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
	 * Get allocated time.
	 *
	 * @return The number of seconds allocated to the question.
	 * @see Question#allocatedTime
	 */
	public int getAllocatedTime() {
		return allocatedTime;
	}

	/**
	 * Set allocated time.
	 *
	 * @see Question#allocatedTime
	 */
	public void setAllocatedTime(int allocatedTime) {
		this.allocatedTime = allocatedTime;
	}
}
