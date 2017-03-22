package controller;

import model.base.*;
import model.session.*;
/**
 * Statistics
 *
 * Produce statistics from the participation informations and the question's answers.
 *
 * @author Benoît Dorey
 */
public abstract class Statistics {

	/**
	 * Function who calculate percentage with 2 int
	 *
	 * @param x
	 *            Int, numerator: you want the x percentage
	 * @param n
	 *            Int, denominator: total number
	 *
	 * @return Double, it's the percentage of x in n
	 */
	public static double getPercentage(int x, int n) {

		return (x * 100) / n;
	}


	/**
	 * Function for multiple choice
	 *
	 * @param question
	 *            List<Answer>, contains all possible answers
	 * @param voterAnswers
	 *            List<Integer>, contains all the answers chosen by a user
	 *
	 * @return Double array, contains all the percentages for each possible 		 * 		answers
	 */
	public static double[] getPercentageChoices(Question question, java.util.List<VoterAnswer> voterAnswers) {

		int counts[] = new int[question.answers.size()];
		double percents[] = new double[question.answers.size()];
		int totalAnswers = 0;

		for(VoterAnswer voterAnswer : voterAnswers) {
			for(int answerId : voterAnswer.answers) {
				counts[answerId]++;
				totalAnswers++;
			}
		}

		for(int i = 0 ; i < question.answers.size() ; i++) {
			percents[i] = getPercentage(counts[i], totalAnswers);
		}

		return percents;
	}


	/**
	 * Function who calculate an average with percentages
	 *
	 *
	 * @param percents
	 *            Double array, contains percentages
	 *
	 * @return Double, contains an average of all the percentages
	 */
	public static double calculateAverage(double[] percents) {

		double total = 0;

		for (Double percent : percents)
			total += percent;

		return total / percents.length;
	}

	/**
	 * Function who calculate percentage of correct answers
	 *
	 * @param question
	 *            List<Answer>, contains all possible answers
	 * @param voterAnswers
	 *            List<Integer>, contains all the answers chosen by a user
	 *
	 * @return Double, contains percentage of good answers
	 */
	public static double calculatePercentageOfCorrectAnswers(Question question, java.util.List<VoterAnswer> voterAnswers) {

		int correct = 0;

		for(VoterAnswer voterAnswer : voterAnswers ) {
			// if(question.isVoterAnswerCorrect(voterAnswer))
			// 		correct++;
		}

		return getPercentage(correct,voterAnswers.size());
	}
}
