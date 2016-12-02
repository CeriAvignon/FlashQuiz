import java.util.Vector;
import java.util.Collections;

/**
 * Session
 *
 * @author Jean-Loup Gaussen
 */
public class Session {

	/**
	 * The session name, defined by his creator at its creation
	 *
	 * @see Session#getName()
	 * @see Session#setName(String s)
	 * @see Session#Session(String name, String nameCreator, int id)
	 */
	private String name;

	/**
	 * The session creator name
	 *
	 * @see Session#getNameCreator()
	 * @see Session#setNameCreator(String s)
	 * @see Session#Session(String name, String nameCreator, int id)
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
	 * Vecteur des question pas encore voté
	 *
	 */
	private Vector<Integer> questionsUnvoted;

	/**
	 *
	 */
	private Question currQuestion;


	/**
	 * True if questions list sort randomly
	 *
	 * False otherwise
	 *
	 */
	private boolean isQuestionsOrderRandom;

	/**
	 * The current questions series
	 *
	 * @see Series
	 * @see Session#getCurrSeries()
	 * @see Session#setCurrSeries(Series S)
	 */
	private Series currSeries;

	/**
	 * Current Question timer
	 * @see Question#allocatedTime
	 * @see Session#startQuestionTimer
	 * @see Session#getTimeLeft
	 */
	protected Timer timer;

	/**
	 * The session constructor
	 *
	 * @param name
	 *            A string that contain the session name
	 * @param nameCreator
	 *            A string that contain the session creator name
	 * @param id
	 *            An int that contain the session id
	 *
	 * @see Session#name
	 * @see Session#nameCreator
	 * @see Session#id
	 * @see Session#currSeries
	 */
	public Session(String name, String nameCreator, int id,boolean isQuestionsOrderRandom) {
		this.name = name;
		this.nameCreator = nameCreator;
		this.id = id;
		this.currSeries = null;
		this.isQuestionsOrderRandom = isQuestionsOrderRandom;
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
	 * Getter of the session creator name
	 *
	 * @return A string that contain the session creator name
	 *
	 * @see Session#nameCreator
	 */
	public String getNameCreator() {
		return nameCreator;
	}

	/**
	 * Setter of the session creator name
	 *
	 * @param s
	 *            A string that contain the session creator name
	 *
	 * @see Session#nameCreator
	 */
	public void setNameCreator(String s) {
		nameCreator = s;
	}

	/**
	 * Getter of the session id
	 *
	 * @return An int that contain the session id
	 *
	 * @see Session#id
	 */
	public int getid() {
		return id;
	}

	/**
	 * @return the questionsUnvoted
	 */
	public Vector<Integer> getQuestionsUnvoted() {
		return questionsUnvoted;
	}

	/**
	 * @param questionsUnvoted the questionsUnvoted to set
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
	 * @param currQuestion the currQuestion to set
	 */
	public void setCurrQuestion(Question currQuestion) {
		this.currQuestion = currQuestion;
	}

	/**
	 * Getter of the current series
	 *
	 * @return The current series
	 *
	 * @see Session#currSeries
	 */
	public Series getCurrSeries() {
		return currSeries;
	}

	/**
	 * Setter of the current series
	 *
	 * @param S
	 *            A series
	 *
	 * @see Session#currSeries
	 */
	public void setCurrSeries(Series S) {
		currSeries = S;
	}

	/**
	 *
	 * @author Schmidt Gaetan
	 */
	protected void sortUnvotedQuestions()
	{
		for (int i=0; i < currSeries.getQuestions().size(); i++)
		{
			questionsUnvoted.addElement(i);
		}

		if (isQuestionsOrderRandom)
		{
			Collections.shuffle(questionsUnvoted);
		}
	}

	/**
	 *
	 * @author Schmidt Gaetan
	 * @return true if questionsUnvoted in empty
	 */
	protected boolean areAllquestionsVoted ()
	{
		return questionsUnvoted.isEmpty();
	}

	/**
	 * Refresh currQuestion with questionsUnvoted's first element.
	 * Delete questionsUnvoted's first element
	 *
	 * @author Schmidt Gaetan
	 */
	protected void changementQuestion () {
		if (areAllquestionsVoted())
		return;
		currQuestion = currSeries.getQuestions().elementAt(questionsUnvoted.elementAt(0));
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
	protected void startQuestionTimer()
	{
		int delay = currQuestion.getAllocatedTime * 1000; // convert in milliseconds

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
	 * Get time left. Used to calculate the time spent by the voter to answer (statistics).
	 * WIP
	 */
	protected int getTimeLeft()
	{
		return timer.getDelay();
	}
}
