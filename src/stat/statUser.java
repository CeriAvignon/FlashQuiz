
package stat;

/**
 * StatUser
 *
 * Produce statistics from the question's answers.
 *
 * @author Benoît Dorey
 */
public class statUser {

	/**
	 * Function who calculate statistic of the User for more than one session
	 *
	 *
	 * @param sessionNumber
	 *            Int who is the number of session for the User
	 * @param StatTrue
	 *            Double array that contain all of the User's true stat for each
	 *            session like: StatTrue[20,70,90] for 20%, 70% and 90% true
	 *            answers in 3 sessions
	 * @return Double array that contain statistics values for good and bad
	 *         answers, like: Res[0] = 45 and Res[1] = 55; so 45% true and 55%
	 *         false
	 */
	// Fonction pour calculer le pourcentage de réussite de l'utilisateur sur
	// une certain nombre de session
	public static double[] statResultUserGeneral(int sessionNumber,
			double[] StatTrue) {

		// Tableau avec le pourcentage de juste et de faux
		double Res[] = { 0, 0 };

		for (int i = 0; i < sessionNumber; i++) {
			Res[0] = Res[0] + StatTrue[i];
		}
		Res[0] = Res[0] / sessionNumber;

		Res[1] = 100 - Res[0];

		// Tableau des pourcentages
		return Res;
	}

	/**********
	 * /********** /********** /********** /**********
	 *
	 *
	 * /** Function who calculate statistic of the User for one session
	 *
	 *
	 * @param resTrue
	 *            Int array that contain the number of good answer for the User
	 *            in the session
	 * @param resFalse
	 *            Int array that contain the number of bad answer for the User
	 *            in the session
	 * @return Double array that contain statistics values for good and bad
	 *         answers, like: Res[0] = 45 and Res[1] = 55; so 45% true and 55%
	 *         false
	 */
	// Fonction pour calculer le pourcentage de réussite de l'utilisateur sur
	// une session
	public static double[] statResultUser(int resTrue, int resFalse) {
		// Total des votes
		double total = resTrue + resFalse;
		// Tableau avec le pourcentage de juste et de faux
		double Res[] = { 0, 0 };

		// Pourcentage de réponses vraies
		Res[0] = (resTrue * 100) / total;
		// pourcentages de réponses fausses
		Res[1] = (resFalse * 100) / total;

		// Tableau des pourcentages
		return Res;
	}

	/**
	 * Main, to test function
	 */
	// Main de test des deux fonctions et de présentation des entrées
	//
	// statResultUser demande le nombre de bonne réponses et de mauvaises sur
	// une session
	// afin de calculer les pourcentages de bonnes réponses et de mauvaises sur
	// ce même sondage.
	//
	// statResultUserGeneral demande le nombre de sondage auquel a répondu
	// l'utilisateur et
	// les pourcentages de réussites à ces sondages.
	//
	//
	public static void main(String[] args) {
		// Test fonction statResultUser
		double[] Res = statResultUser(45641, 12737);

		System.out
				.println("Res[0] = " + Res[0] + "% \nRes[1] = " + Res[1] + "%");

		// Test fonction statResultUserGeneral
		double[] StatTrue = { 56.9, 36.3, 60.3, 25.2 };

		double[] Res2 = statResultUserGeneral(4, StatTrue);

		System.out.println(
				"Res2[0] = " + Res2[0] + "% \nRes2[1] = " + Res2[1] + "%");
	}
}
