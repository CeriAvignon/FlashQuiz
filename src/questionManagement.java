/**
 * questionManagement class
 *
 * @author Delvaux Julien
 */

public class questionManagement {

	/**
	 * The timeleft, if 1 = timesOut, else timesUp
	 *
	 * @see questionManagement#isTimeOut()
	 */
	private int time;
	
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
	 *            An int that contains the time
	 * @param button
	 *            An int that indicates if the button is pressed (1) or not (0)
	 * @param force
	 *            An int that indicates if the admin forced the next question
	 */
	public questionManagement(int time, int button, int force) {

		this.time = time;
		this.button = button;
		this.force = force;
	}

	/**
	 * Check if the time is ended
	 *
	 * @return An boolean which means that the time expired
	 */
	public boolean isTimeOut() {

		if(time == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Check if the button for next question is pressed
	 *
	 * @return An boolean which means that the button has been pressed
	 */
	public boolean isNextButtonPressed() {

		if(button == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Check if the admin forced the next question
	 *
	 * @return An boolean which means that the admin forced
	 */
	public boolean isAdminForced() {

		if(force == 1) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * global function that checks everythings
	 *
	 * @return An boolean which means that the question is ended
	 */
	public boolean isQuestionEnded() {

		boolean b_time = isTimeOut();
		boolean b_button = isNextButtonPressed();
		boolean b_force = isAdminForced();

		if(b_time || b_button || b_force) {
			return true;
		}else {
			return false;
		}

	}


	/*public static void main(String[] args) {	// Main test

		finQuestion a = new finQuestion(0, 1);

		System.out.println("Hello world !");
		a.isTimeOut(0);
		a.isNextButtonPressed(1);
	}*/

}