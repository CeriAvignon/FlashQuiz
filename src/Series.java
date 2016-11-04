import java.util.Vector;

/**
 * Series
 *
 * @author Jean-Loup Gaussen
 */
class Series {

	/**
	 * The series name, it's defined by his creator, at its creation
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
	 * The session id, a (random?) unique number that cannot be changed
	 *
	 * @see Session#getid()
	 * @see Session#Session(String name, String nameCreator, int id)
	 */
	private int id;

	/**
	 * A vector that contain all the questions series
	 *
	 * @see Series#getQuestions()
	 */
	private Vector<Question> questions;

	/**
	 * Series constructor
	 *
	 * @param name
	 *            The Series name
	 * @param nameCreator
	 *            The Series creator name
	 * @param id
	 *            The Series id
	 *
	 * @see Series#name
	 * @see Series#nameCreator
	 * @see Series#id
	 * @see Series#questions
	 */
	public Series(String name, String nameCreator, int id, Vector<Question> questions) {
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
	 *            The series name
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
	 *            The series creator name
	 *
	 * @see Session#nameCreator
	 */
	public void setNameCreator(String s) {
		nameCreator = s;
	}

	/**
	 * Getter of the series id
	 *
	 * @return A int that contain the series id
	 *
	 * @see Session#id
	 */
	public int getid() {
		return id;
	}

	/**
	 * Getter of the series questions
	 *
	 * @return A vector that contain the series questions
	 *
	 * @see Session#questions
	 */
	public Vector<Question> getQuestions() {
		return questions;
	}
}
