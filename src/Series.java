import java.util.Vector;

/**
 * Series
 *
 * @author Jean-Loup Gaussen
 */
class Series {

	/**
	 * The series name, defined by his creator at its creation
	 *
	 * @see Series#getName()
	 * @see Series#setName(String s)
	 * @see Series#Series(String name, String nameCreator, int id)
	 */
	private String name;

	/**
	 * The series creator name
	 *
	 * @see Series#getNameCreator()
	 * @see Series#setNameCreator(String s)
	 * @see Series#Series(String name, String nameCreator, int id)
	 */
	private String nameCreator;

	/**
	 * The session id, unique and can't be changed
	 *
	 * @see Session#getid()
	 * @see Session#Session(String name, String nameCreator, int id)
	 */
	private int id;

	/**
	 * A vector that contain all the series questions
	 *
	 * @see Series#getQuestions()
	 * @see Series#setQuestion(Vector<Question>)
	 */
	private Vector<Question> questions;

	/**
	 * Series constructor
	 *
	 * @param name
	 *            A String that contain the Series name
	 * @param nameCreator
	 *            A String that contain the Series creator name
	 * @param id
	 *            An int that contain the Series id
	 *
	 * @see Series#name
	 * @see Series#nameCreator
	 * @see Series#id
	 * @see Series#questions
	 */
	public Series(String name, String nameCreator, int id,
			Vector<Question> questions) {
		this.name = name;
		this.nameCreator = nameCreator;
		this.id = id;
		this.questions = questions;

	}

	/**
	 * Getter of the series name
	 *
	 * @return A string that contain the series name
	 *
	 * @see Session#name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the series name
	 *
	 * @param s
	 *            A string that contain the series name
	 *
	 * @see Session#name
	 */
	public void setName(String s) {
		name = s;
	}

	/**
	 * Getter of the series creator name
	 *
	 * @return A string that contain the series creator name
	 *
	 * @see Session#nameCreator
	 */
	public String getNameCreator() {
		return nameCreator;
	}

	/**
	 * Setter of the series creator name
	 *
	 * @param s
	 *            A string that contain the series creator name
	 *
	 * @see Session#nameCreator
	 */
	public void setNameCreator(String s) {
		nameCreator = s;
	}

	/**
	 * Getter of the series id
	 *
	 * @return An int that contain the series id
	 *
	 * @see Session#id
	 */
	public int getid() {
		return id;
	}

	/**
	 * Getter of the series questions
	 *
	 * @return A questions vector that contain the series questions
	 *
	 * @see Session#questions
	 */
	public Vector<Question> getQuestions() {
		return questions;
	}

	/**
	 * Setter of the series questions
	 *
	 * @param Q
	 *            A questions vector that contain the series questions
	 *
	 * @see Session#questions
	 */
	public void setQuestions(Vector<Question> Q) {
		questions = Q;
	}
}
