/**
 * 
 * @author J-loup
 *
 */
class Answer {
	/**
	 * The answer
	 */
	private String content;

	/**
	 * True if the answer is a good one, False else
	 */
	private boolean state;

	/**
	 * Getter of the content answer
	 * 
	 * @return the content of the answer
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter of the content answer
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Getter of the state answer
	 * 
	 * @return the state answer
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * Setter of the state answer
	 * 
	 * @param state
	 *            the state answer
	 */
	public void setState(boolean state) {
		this.state = state;
	}

}