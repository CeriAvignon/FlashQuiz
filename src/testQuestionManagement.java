/**
 * testQuestionManagement class
 *
 * @author Boge Julien
 */

// Documentation Timer:
// https://docs.oracle.com/javase/8/docs/api/javax/swing/Timer.html
// http://docs.oracle.com/javase/tutorial/uiswing/misc/timer.html
// http://stackoverflow.com/questions/2258066/java-run-a-function-after-a-specific-number-of-seconds

public class testQuestionManagement {

	/**
	 * Main
	 */
	public static void main(String[] args) {

		int timeLeft = 5; // time in seconds allocated to the question
		int button   = 0; // ??
		int force    = 0; // ??

		int wait = 10000; // in milliseconds

		QuestionManagement question = new QuestionManagement(timeLeft,button,force);

		System.out.println("Hello world!");

		// Wait
		try {
			Thread.sleep(wait);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

	}
}
