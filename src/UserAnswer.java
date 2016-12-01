/**
 * Contain the answer that the user has given to a question, the question and if
 * the user answered to the question or not
 * 
 * @author J-loup
 *
 */
class UserAnswer {
	/**
	 * The question id that the user answered with this answer
	 * 
	 * @see Question
	 * @see UserAnswer#getQuestionId()
	 * @see UserAnswer#setQuestionId(int)
	 */
	private int questionId;

	/**
	 * The user answer
	 * 
	 * @see UserAnswer#getUserAnswer()
	 * @see UserAnswer#setUserAnswer(String)
	 */
	private String userAnswer;

	/**
	 * True if the user answered to the question, false if he didn't or if he
	 * passed
	 * 
	 * @see UserAnswer#isAnswered()
	 * @see UserAnswer#setAnswered(boolean)
	 */
	private boolean answered;

	/**
	 * Getter of the question id
	 * 
	 * @return The question id
	 * 
	 * @see UserAnswer#questionId
	 */
	public int getQuestionId() {
		return questionId;
	}

	/**
	 * Setter of the question id
	 * 
	 * @param questionId
	 * 
	 * @see UserAnswer#questionId
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	/**
	 * Getter of the user answer
	 * 
	 * @return The userAnswer
	 * 
	 * @see UserAnswer#userAnswer
	 */
	public String getUserAnswer() {
		return userAnswer;
	}

	/**
	 * Setter of the user answer
	 * 
	 * @param userAnswer
	 * 
	 * @see UserAnswer#userAnswer
	 */
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	/**
	 * Getter of the answer state : Answered or not
	 * 
	 * @return The answer state
	 * 
	 * @see UserAnswer#answered
	 */
	public boolean isAnswered() {
		return answered;
	}

	/**
	 * Setter of the answer state : Answered or not
	 * 
	 * @param answered
	 * 
	 * @see UserAnswer#answered
	 */
	public void setAnswered(boolean answered) {
		this.answered = answered;
	}
	
	/**
	 * Function who recover the answer of an user.
	 * 
	 * @param string
	 * 
	 * @return UserAnswer
	 * 
	 * @see setUserAnswer
	 */
	public UserAnswer recoverAnswer(String s) {
		a = new UserAnswer;
		a.setUserAnswer(s);
		return a;
	}
	
	/**
	 * Check if it has an answer and set the statement.
	 * 
	 * @param UserAnswer
	 * 
	 * @return UserAnswer
	 * 
	 * @see setAnswered
	 */
	public UserAnswer setIsAnswer(UserAnswer a) {
		if(a.userAnswer == null || a.userAnswer.length() == 0) {
			a.setAnswered(false);
		} 
		else {
			a.setAnswered(true);
		}
		return a;
	}
}
