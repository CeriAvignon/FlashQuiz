
package votingsession;

import java.awt.event.*;
import javax.swing.Timer;

/**
 * QuestionManagement class
 *
 * @author Delvaux and Boge Julien
 */
class QuestionManagement {

	/**
	 * The time remaining allocated to the question in seconds. It is set by the
	 * creator of the question. If timeLeft reachs 0, it goes to the next
	 * question.
	 *
	 * @see questionManagement#isTimeOut()
	 */
	// private int timeLeft;

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

	// private ActionListener timeOutListener;

	/**
	 * %TODO%
	 */
	private Timer timer;

	/**
	 * QuestionManagement constructor
	 *
	 * @param time
	 *            An int representing time in seconds allocated to answer the
	 *            question
	 * @param button
	 *            An int that indicates if the button is pressed (1) or not (0)
	 * @param force
	 *            An int that indicates if the admin forced the next question
	 */
	public QuestionManagement(int time, int button, int force) {
		// this.timeLeft = time;
		setAllocatedTime(time);
		this.button = button;
		this.force = force;
	}

	/**
	 * Set a timer. Do something when delay is finished (here it prints text).
	 *
	 * @param timeLeft
	 *            The left time you want to set
	 */
	public void setAllocatedTime(int timeLeft) {

		int delay = timeLeft * 1000; // convert in milliseconds

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
	 * Check if the time allocated to the question have expired.
	 *
	 * @return True if time have expired, false otherwise.
	 */
	public boolean isTimeOut() {

		// return (timeLeft == 0);
		return false;
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
	 * Global function that checks everything
	 *
	 * @return A boolean which means that the question is ended
	 */
	public boolean isQuestionEnded() {

		boolean b_time = isTimeOut();
		boolean b_button = isNextButtonPressed();
		boolean b_force = isAdminForced();

		return (b_time || b_button || b_force);
	}

	// Documentation Timer:
	// https://docs.oracle.com/javase/8/docs/api/javax/swing/Timer.html
	// http://docs.oracle.com/javase/tutorial/uiswing/misc/timer.html
	// http://stackoverflow.com/questions/2258066/java-run-a-function-after-a-specific-number-of-seconds
	/**
	 * Main (test) Wait 10 seconds & set timer to 5 seconds.
	 */
	public static void main(String[] args) {

		int timeLeft = 5; // time in seconds allocated to the question
		int button = 0; // ??
		int force = 0; // ??

		int wait = 10000; // in milliseconds

		QuestionManagement question = new QuestionManagement(timeLeft, button,
				force);

		System.out.println("Hello world!");

		// Wait
		try {
			Thread.sleep(wait);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		System.out.println("Finished!");
	}
}
