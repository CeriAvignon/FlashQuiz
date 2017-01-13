/**
 * StatSession
 *
 * Produce statistics from the question's answers.
 *
 * @author Benoît Dorey
 */
public class statSession {

	/**
	 * Function for multiple choice
	 *
	 * @param prop
	 *            String array that contain all the propositions for the
	 *            question
	 * @param resTrue
	 *            String array that contain all the right answers for this
	 *            question, like ['A','A','B',...]
	 * @param resFalse
	 *            String array that contain all the wrong answers for this
	 *            question, like ['C','D','D',...]
	 * @return Double array that contain all the statistics values of the
	 *         question, like A% = Res[0];
	 */

	// Fonction pour choix multiples
	//
	// Sert à sortir des statistiques plus précise pour une question de type
	// choix multiples, cependant, si cette question se trouve
	// dans une session de plusieurs questions de différents type alors on
	// préférera la deuxième fonction qui sort le pourcentage de
	// réponses vraies et fausses pour avoir des stats sur la véracité ou non
	// des réponses. Bonne réponse à la session = X% et mauvaise
	// réponses à la session = Y%
	//
	public static double[] statMult(String[] prop, String[] resTrue,
			String[] resFalse) {
		// Total de réponses
		double total = resTrue.length + resFalse.length;
		// Nombre de proposition à la question
		int nbrProp = prop.length;
		// Tableau contenant les statistiques demandées
		double Res[] = new double[nbrProp];
		/*
		 * // Tableau qui contient "true" ou "false" en fonction des prop
		 * boolean TF[] = new boolean[nbrProp];
		 * 
		 * for (int i=0;i<nbrProp;i++) { for(int j=0;j<resTrue.length;j++) {
		 * if (prop[i] == resTrue[j]) { TF[i] = true; break; r} else TF[i] =
		 * false; break; } }
		 */

		// Tableau qui contient la population pour chaque variable proposition
		double NBR[] = new double[nbrProp];

		// Boucle de remplissage de NBR depuis les propositions justes
		for (int i = 0; i < nbrProp; i++) {
			for (int j = 0; j < resTrue.length; j++) {
				if (prop[i] == resTrue[j]) {
					NBR[i]++;
				}
			}
		}

		// Boucle de remplissage de NBR depuis les propositions fausses
		for (int i = 0; i < nbrProp; i++) {
			for (int j = 0; j < resFalse.length; j++) {
				if (prop[i] == resFalse[j]) {
					NBR[i]++;
				}
			}
		}

		// Boucle de remplissage de Res, calcul des pourcentages
		for (int i = 0; i < nbrProp; i++) {
			Res[i] = (NBR[i] * 100) / total;
		}

		// Tableau des pourcentages
		return Res;
	}

	/**
	 * Function who calculate statistic of the session (all type of question
	 * together)
	 *
	 * @param resTrue
	 *            Int array that contain the number of good answer for this
	 *            session
	 * @param resFalse
	 *            Int array that contain the number of bad answer for this
	 *            session
	 * @return Double array that contain statistics values for good and bad
	 *         answers, like: Res[0] = 45 and Res[1] = 55; so 45% true and 55%
	 *         false
	 */
	// Fonction pour les tests autres que choix multiples
	public static double[] statResult(int resTrue, int resFalse) {
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
	// statResult demande le nombre de bonne réponses et de mauvaises
	//
	// statMult demande le tableau de string contenant les propositions
	// et les tableaux des bonnes réponses et mauvais réponses
	// en réalité dans ce cas là, la dissociation des bonnes et mauvaises
	// réponses est inutile car on peut s'arrêter à " réponse A 25% etc..."
	// Mais je l'ai fait au cas ou des notions plus complexe de vraies ou
	// arriveraient après
	//
	public static void main(String[] args) {
		// Test fonction statResult
		double[] Res = statResult(45641, 12737);

		System.out.println("Res[0] = " + Res[0] + "\nRes[1] = " + Res[1]);

		// Test fonction statMult
		String[] prop = { "A", "B", "C", "D" };
		String[] resTrue = { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
				"B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B",
				"B", "B", "B", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D",
				"D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D" };
		String[] resFalse = { "A", "A", "A", "C", "C", "A", "C", "C", "C", "A",
				"C", "C", "A", "C", "C", "C", "A", "C", "C", "A", "C", "C", "C",
				"A", "C", "C", "A", "C", "C", "C", "A", "C", "C", "A", "C" };
		double[] Res2 = statMult(prop, resTrue, resFalse);

		for (int i = 0; i < Res2.length; i++) {
			System.out.println("Res2[" + i + "] = " + Res2[i]);
		}

	}
}
