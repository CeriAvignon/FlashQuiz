/**
 * The question answer, it can be true, or false in the case of a radio/checkbox
 * question, it's defined by the its creator.
 * 
 * @see Question
 * 
 * @author Jean-Loup Gaussen
 *
 */
class Answer {
	/**
	 * The answer.
	 * 
	 * @see Answer#getContent()
	 * @see Answer#setContent()
	 * @see Answer#Answer(String, boolean)
	 */
	private String content;

	/**
	 * True if the answer is a good one, false else.
	 * 
	 * @see Answer#getState()
	 * @see Answer#setState()
	 * @see Answer#Answer(String, boolean)
	 */
	private boolean state;

	/**
	 * Constructor of answer.
	 * 
	 * @param s
	 *            The content of the answer.
	 * @param b
	 *            The state of the answer.
	 * @see Answer#content
	 * @see Answer#state
	 */
	public Answer(String s, boolean b) {
		this.content = s;
		this.state = b;
	}

	/**
	 * Getter of the content answer.
	 * 
	 * @return The content of the answer.
	 * 
	 * @see Answer#content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter of the content answer.
	 * 
	 * @param content
	 *            The content of the answer.
	 * @see Answer#content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Getter of the state answer
	 * 
	 * @return The state of the answer.
	 * 
	 * @see Answer#state
	 */
	public boolean getState() {
		return state;
	}

	/**
	 * Setter of the state answer.
	 * 
	 * @param state
	 *            The state of the answer.
	 * @see Answer#state
	 */
	public void setState(boolean state) {
		this.state = state;
	}

}