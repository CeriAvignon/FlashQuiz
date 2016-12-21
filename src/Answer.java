/**
 * The question answer, it can be true, or false in the case of a radio/checkbox
 * question, it's defined by the its creator.
 * 
 * @see Question
 * 
 * @author J-loup
 *
 */
class Answer {
	/**
	 * The answer
	 * 
	 * @see Answer#getContent()
	 * @see Answer#setContent()
	 */
	private String content;

	/**
	 * True if the answer is a good one, False else
	 * 
	 * @see Answer#getState()
	 * @see Answer#setState()
	 */
	private boolean state;

	/**
	 * Getter of the content answer
	 * 
	 * @return the content of the answer
	 * 
	 * @see Answer#content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter of the content answer
	 * 
	 * @param content
	 * 
	 * @see Answer#content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Getter of the state answer
	 * 
	 * @return the state answer
	 * 
	 * @see Answer#state
	 */
	public boolean getState() {
		return state;
	}

	/**
	 * Setter of the state answer
	 * 
	 * @param state
	 * 
	 * @see Answer#state
	 */
	public void setState(boolean state) {
		this.state = state;
	}

}