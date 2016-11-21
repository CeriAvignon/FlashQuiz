/**
 * questionManagement class
 *
 * @author Delvaux Julien
 */

public class questionManagement {

	/**
	 * The time remaining allocated to the question in seconds.
	 It is set by the creator of the question.
	 If timeLeft reachs 0, it goes to the next question.
	 *
	 * @see questionManagement#isTimeOut()
	 */
	private int timeLeft;

	/**
	 * The button pressed checker
	 *
	 * @see questionManagement#isNextButtonPressed()
	 */
	private int button;

	/**
	 * The admin force next question checker
	 *
	 * @see questionManagement#isAdminForced()
	 */
	private int force;

	/**
	 * questionManagement constructor
	 *
	 * @param time
	 *            An int representing time in seconds allocated to answer the question
	 * @param button
	 *            An int that indicates if the button is pressed (1) or not (0)
	 * @param force
	 *            An int that indicates if the admin forced the next question
	 */
	public questionManagement(int time, int button, int force) {

		this.timeLeft = time;
		this.button   = button;
		this.force    = force;
	}

	/**
	 * Check if the time allocated to the question have expired.
	 *
	 * @return True if time have expired, false otherwise.
	 */
	public boolean isTimeOut() {

		return (timeLeft == 0);
	}

	/**
	 * Check if the button for next question is pressed
	 *
	 * @return A boolean which means that the button has been pressed
	 */
	public boolean isNextButtonPressed() {

		return (button == 1);
	}

	/**
	 * Check if the admin forced the next question
	 *
	 * @return A boolean which means that the admin forced
	 */
	public boolean isAdminForced() {

		return (force == 1);
	}

	/**
	 * global function that checks everythings
	 *
	 * @return A boolean which means that the question is ended
	 */
	public boolean isQuestionEnded() {

		boolean b_time   = isTimeOut();
		boolean b_button = isNextButtonPressed();
		boolean b_force  = isAdminForced();

		return (b_time || b_button || b_force);
	}


	/*public static void main(String[] args) {	// Main test

		finQuestion a = new finQuestion(0, 1);

		System.out.println("Hello world !");
		a.isTimeOut(0);
		a.isNextButtonPressed(1);
	}*/

}
