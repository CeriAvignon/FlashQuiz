import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.Timer;

/**
 * Session
 *
 * @author Jean-Loup Gaussen
 */
public class Session {

	/**
	 * The session name, defined by its creator at its creation
	 *
	 * @see Session#getName()
	 * @see Session#setName(String)
	 * @see Session#Session(String, String, int)
	 */
	private String name;

	/**
	 * The session creator id
	 *
	 * @see Session#getNameCreator()
	 * @see Session#setNameCreator(id)
	 * @see Session#Session(String, int, int)
	 */
	private int idCreator;

	/**
	 * The session id, unique and can't be changed
	 *
	 * @see Session#getid()
	 * @see Session#Session(String, int, int)
	 */
	private int id;

	/**
	 * A list of all the questions that haven't been used yet
	 *
	 * @see Question
	 */
	private Vector<Integer> questionsUnvoted;

	/**
	 * The question that is currently answered
	 *
	 * @see Question
	 */
	private Question currQuestion;

	/**
	 *
	 */
	private List currList;

	/**
	 * State if the questions need to be randomly sorted
	 *
	 * @see Question
	 */
	private boolean isQuestionsOrderRandom;

	/**
	 * Current Question timer
	 *
	 * @see Question#allocatedTime
	 * @see Session#startQuestionTimer()
	 * @see Session#getTimeLeft()
	 */
	protected Timer timer;

	/**
	 * The session constructor
	 *
	 * @param name
	 *            The session name
	 * @param idCreator
	 *            The session creator id
	 * @param id
	 *            The session id
	 *
	 * @see Session#name
	 * @see Session#nameCreator
	 * @see Session#id
	 * @see Session#currList
	 */
	public Session(String name, int idCreator, int id, boolean isQuestionsOrderRandom) {
		this.name = name;
		this.idCreator = idCreator;
		this.id = id;
		this.currList = null;
		this.isQuestionsOrderRandom = isQuestionsOrderRandom;
		addUnvotedQuestions();
		sortUnvotedQuestions();
	}

	/**
	 * Getter of the session name
	 *
	 * @return A string that contain the session name
	 *
	 * @see Session#name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the session name
	 *
	 * @param s
	 *            A string that contain the session name
	 *
	 * @see Session#name
	 */
	public void setName(String s) {
		name = s;
	}

	/**
	 * Getter of the session creator id
	 *
	 * @return The session creator id
	 *
	 * @see Session#nameCreator
	 */
	public int getIdCreator() {
		return idCreator;
	}

	/**
	 * Setter of the session creator id
	 *
	 * @param s
	 *            The session creator id
	 *
	 * @see Session#idCreator
	 */
	public void setIdCreator(int id) {
		idCreator = id;
	}

	/**
	 * Getter of the session id
	 *
	 * @return The session id
	 *
	 * @see Session#id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter of questionsUnvoted
	 *
	 * @return A list of all the questions that haven't been used yet
	 *
	 * @see questionsUnvoted
	 */
	public Vector<Integer> getQuestionsUnvoted() {
		return questionsUnvoted;
	}

	/**
	 * Setter of questionsUnvoted
	 *
	 * @param questionsUnvoted
	 *            A list of all the questions that haven't been used yet
	 */
	public void setQuestionsUnvoted(Vector<Integer> questionsUnvoted) {
		this.questionsUnvoted = questionsUnvoted;
	}

	/**
	 * @return the currQuestion
	 */
	public Question getCurrQuestion() {
		return currQuestion;
	}

	/**
	 * @param currQuestion
	 *            the currQuestion to set
	 */
	public void setCurrQuestion(Question currQuestion) {
		this.currQuestion = currQuestion;
	}

	/**
	 * Getter of the current series
	 *
	 * @return The current series
	 *
	 * @see Session#currList
	 */
	public List getCurrList() {
		return currList;
	}

	/**
	 * Setter of the current series
	 *
	 * @param S
	 *            A series
	 *
	 * @see Session#currList
	 */
	public void setCurrList(List S) {
		currList = S;
	}

	/**
	 * Add a question to the current list. Then add its index to the
	 * unvotedQuestions vector, before sorting the vector.
	 * 
	 * @return %TODO%
	 */
	public void addQuestion(Question question) {
		int newQuestionIndex = this.currList.addQuestion(question);
		questionsUnvoted.add(newQuestionIndex);
		sortUnvotedQuestions();
	}

	/**
	 * Add the current list to the unvotedQuestions vector.
	 *
	 */
	protected void addUnvotedQuestions() {
		// questionsUnvoted.addAll(currList); %TODO%
	}

	/**
	 * Sort the unvoted questions vector if isQuestionsOrderRandom is true.
	 *
	 * @author Schmidt Gaetan
	 */
	protected void sortUnvotedQuestions() {
		if (isQuestionsOrderRandom)
			Collections.shuffle(questionsUnvoted);
	}

	/**
	 *
	 * @author Schmidt Gaetan
	 * @return True if the questionsUnvoted vector is empty.
	 */
	protected boolean areAllquestionsVoted() {
		return questionsUnvoted.isEmpty();
	}

	/**
	 * Refresh currQuestion with questionsUnvoted's first element. Delete the
	 * questionsUnvoted's first element.
	 *
	 * @author Schmidt Gaetan
	 */
	protected void changementQuestion() {
		if (areAllquestionsVoted())
			return;
		currQuestion = currList.getQuestions().elementAt(questionsUnvoted.elementAt(0));
		questionsUnvoted.remove(0);
		// Affichage de la question
		startQuestionTimer();
	}

	/**
	 * Start the question timer.
	 *
	 * @see Question#allocatedTime
	 * @see Question#getAllocatedTime
	 */
	protected void startQuestionTimer() {
		int delay = currQuestion.getAllocatedTime() * 1000; // convert in
															// milliseconds

		ActionListener timeOutListener = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.out.println("Time left!");
			}
		};

		this.timer = new Timer(delay, timeOutListener);
		this.timer.setRepeats(false); // happen once
		this.timer.start();
	}

	/**
	 * Get time left. Used to calculate the time spent by the voter to answer
	 * (statistics). WIP
	 */
	protected int getTimeLeft() {
		return timer.getDelay();
	}
}
