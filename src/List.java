import java.util.Vector;

/**
 * A list is a series of questions made by a user
 *
 * @author Jean-Loup Gaussen
 * 
 * @see Question
 */
class List {

	/**
	 * The title of the list
	 *
	 * @see List#getName()
	 * @see List#setName(String)
	 * @see List#List(String, String, int)
	 */
	private String name;

	/**
	 * The id of the list creator.
	 *
	 * @see List#getidCreator()
	 * @see List#setidCreator(int)
	 * @see List#List(String, int, int)
	 */
	private int idCreator;

	/**
	 * The list id, unique and can't be changed.
	 *
	 * @see List#getid()
	 * @see List#List(String, int, int, Vector)
	 */
	private int id;

	/**
	 * A vector that contain all the list questions.
	 *
	 * @see Question
	 * @see List#getQuestions()
	 * @see List#setQuestions(Vector)
	 * @see List#getQuestionsSize()
	 * @see List#getQuestionAt(int)
	 */
	private Vector<Question> questions;

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
	public List(String name, int idCreator, int id, Vector<Question> questions) {
		this.name = name;
		this.idCreator = idCreator;
		this.id = id;
		this.questions = questions;

	}

	/**
	 * Getter of the list name.
	 *
	 * @return The List name.
	 *
	 * @see Session#name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the list name.
	 *
	 * @param s
	 *            The list name.
	 *
	 * @see Session#name
	 */
	public void setName(String s) {
		name = s;
	}

	/**
	 * Getter of the id of the list creator.
	 *
	 * @return The id of the list creator
	 *
	 * @see Session#idCreator
	 */
	public int getIdCreator() {
		return idCreator;
	}

	/**
	 * Setter of the id of the list creator.
	 *
	 * @param id
	 *            The id of the list creator.
	 *
	 * @see Session#idCreator
	 */
	public void setIdCreator(int id) {
		idCreator = id;
	}

	/**
	 * Getter of the list id.
	 *
	 * @return The list id.
	 *
	 * @see List#id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter of the list questions.
	 *
	 * @return The list questions.
	 *
	 * @see Session#questions
	 */
	public Vector<Question> getQuestions() {
		return questions;
	}

	/**
	 * Setter of the list questions.
	 *
	 * @param Q
	 *           The list questions.
	 *
	 * @see Session#questions
	 */
	public void setQuestions(Vector<Question> Q) {
		questions = Q;
	}
	
	/**
	 * Get the number of questions in the list.
	 *
	 * @return The number of questions in the List.
	 *
	 * @see List#questions
	 */
	public int getQuestionsSize() {
		return questions.size();
	}

	/**
	 * Get a question at the specified index inside the questions vector.
	 *
	 * @param index
	 *            The index of the question
	 * @return A question.
	 *
	 * @see List#questions
	 */
	public Question getQuestionAt(int index) {
		if (getQuestionsSize() < index) {
			return null;
		}
		return questions.get(index);
	}
}
