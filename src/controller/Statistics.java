package controller;


import java.util.*;
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
	private static double getPercentage(int x, int n) {

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
	 * @return Double array, contains all the percentages for each possible answers
	 */
	private static double[] getPercentageChoices(Question question, VoterAnswerList voterAnswers) {

		int counts[] = new int[question.answers.size()];
		double percents[] = new double[question.answers.size()];
		int totalAnswers = 0;

		for(Map.Entry<Integer, VoterAnswer> entry : voterAnswers.entrySet()) {
			int userId = entry.getKey();
			VoterAnswer voterAnswer = entry.getValue();

			for(int answerId : voterAnswer.answersId) {
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
	private static double calculateAverage(double[] percents) {

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
	private static double calculatePercentageOfCorrectAnswers(Question question, VoterAnswerList voterAnswers) {

		int correct = 0;

		for(Map.Entry<Integer, VoterAnswer> entry : voterAnswers.entrySet()) {
			int userId = entry.getKey();
			VoterAnswer voterAnswer = entry.getValue();

			// if(question.isVoterAnswerCorrect(voterAnswer))
			// 	correct++;
		}

			

		return getPercentage(correct,voterAnswers.size());
	}


/*
	DDD	IIIII
	D DD     I	   
	D  D     I        
	D DD	  I        
	DDD    IIIII     
*/


	/**
	 * Function who display the right view after each question
	 *
	 * @param question
	 *            List<Answer>, contains all possible answers
	 * @param voterAnswerList
	 *            List<Integer>, contains all the answers chosen by a user
	 *
	 * @return void, return nothing because it just display a view
	 */
	public static void displayQuestionStat(Question question, VoterAnswerList voterAnswerList)
	{
		if(question.type == 1 || question.type == 2)
		{
			
			double percents[] = getPercentageChoices(question, voterAnswerList);
			// Afficher la vu correspondante à getPercentageChoices
			// View.displayQuestionStat(percents);
		}
		else 
		{
			double percents = calculatePercentageOfCorrectAnswers(question, voterAnswerList);
			// Afficher la vu correspondate à calculatePercentageOfCorrectAnswers
			// View.displayQuestionStat(percents);
		}
	}


	/**
	 * Function who display the right view at the end of the session
	 *
	 * @param percentages
	 *            double[], contains all the percentages
	 *
	 * @return void, return nothing because it just display the view
	 */
	public static void displaySessionStatAverage(double[] percentages)
	{
		double ave = calculateAverage(percentages);
		// Afficher la vu correspondate à average
		// View.displayAverageStat(ave);		
	}	



	/**
	 * Function who call the display after the DB
	 *
	 * @param idQuestion
	 *            int, the question id
	 *
 	 * @param idSession
	 *            int, the session id
	 *
	 * @return void, return nothing because it just call the display function
	 */
	public static void displayQuestionStat(int idQuestion, int idSession)
	{
		// Fonction de récupération de (VoterAnswerList voterAnswerList, Question question) dans la bdd
		// voterAnswerList = getvoterAnswerList(idSession, idQuestion);
		// question = getQuestion(idSession, idQuestion);
		// displayQuestionStat(voterAnswerList, question);	
	}

	/**
	 * Function who call the display after the DB for average
	 *
 	 * @param idSession
	 *            int, the session id
	 *
	 * @return void, return nothing because it just call the display function
	 */
	public static void displaySessionStatAverage(int idSession)
	{
		// Fonction de récupération de (VoterAnswerList voterAnswerList, Question question) dans la bdd
		// double percentages[] = getPercentagesSession(idSession);

		// displaySessionStatAverage(percentages);	
	}	


	/**
	 * Function who call the display after the DB for user's average
	 *
	 * @param idSession
	 *            int, the session id
	 *
 	 * @param idUser
	 *            int, the user id
	 *
	 * @return void, return nothing because it just call DB and call the view
	 */
	public static void displayUserStatAverage(int idSession, int idUser)
	{
		// Fonction de récupération de (VoterAnswerList voterAnswerList, Question question) dans la bdd
		// double percentage = getPercentagesUser(idSession, idUser);

		// Afficher la vu correspondate à average pour un user
		// View.displayAverageStat(percentage);
			
	}
}
