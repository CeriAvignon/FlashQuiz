package model.session;

import java.util.*;
import java.io.Serializable;
import model.base.*;

/**
 * A question contain a statement, one or more answers to this statement, a type
 * (checkbox, radio, free) and the time given to answer to the question (less than 0 if
 * infinite).
 *
 * @see QuestionBase
 *
 * @author Jean-Loup Gaussen
 */
public class Question extends QuestionBase implements Serializable {
	/**
	 * A list that contain the answers
	 *
	 * @see Answer
	 */
	public List<Answer> answers;

	/**
	 * Question constructor
	 *
	 * @param id
	 *        An int that contain the question id
	 * @param statement
	 *        A string that contain the question statement
	 * @param type
	 *        A string that contain the question type (Free,Radio,Checkbox)
	 * @param allocatedTime
	 *			  Time allocated to the question
	 * @param answersId
	 *        A list that contain the answers id
	 */
	public Question(int id, String statement, int type, int allocatedTime, int[] answersId) {
		super(id, statement, type, allocatedTime);
		// for(Integer answer : answersId)
		// this.answers.add(getAnswer(answer));
		// AnswerHandler
	}

	/**
	 * Question constructor
	 *
	 * @param id
	 *         An int that contain the question id
	 * @param statement
	 *         A string that contain the question statement
	 * @param type
	 *         A string that contain the question type (Free,Radio,Checkbox)
	 * @param allocatedTime
	 *			  Time allocated to the question
	 * @param answersId
	 *         A list that contain the answers id
	 */
	public Question(int id, String statement, int type, int allocatedTime, List<Answer> answers) {
		super(id, statement, type, allocatedTime);
		this.answers = answers;
	}

	/**
	 * Verify if the user's answer is correct
	 *
	 * @param voterAnswer  The user's answer
	 * @return true if voterAnswer is correct, false ortherwise
	 */
	public boolean isVoterAnswerCorrect(VoterAnswer voterAnswer) {

		switch(type) {

			case 0: // free
				// vérifie qu'au moins une des réponses (Answer) correspond à l'entrée
				// du votant
				if(voterAnswer.content.isEmpty()) {
					return false;
				}
				for(Answer answer : answers) {
					if(voterAnswer.content.toLowerCase().contains(answer.content.toLowerCase())) {
						return true;
					}
				}
				return false;

			case 1: // radio
			case 2: // checkbox
				System.out.println("checkbox or radio!");
				if(voterAnswer.answersId == null || voterAnswer.answersId.isEmpty()) {
					return false;
				}
				// vérifie que toutes les réponses justes ont été choisies
				for(int id = 0 ; id < answers.size() ; id++ ) {
					if(answers.get(id).state) {
						if(!voterAnswer.answersId.contains(id)) {
							return false;
						}
					}
				}
				// vérifie que seules réponses justes ont été choisies
				for(Integer id : voterAnswer.answersId) {
					if(!answers.get(id).state) {
						return false;
					}
				}
				return true;

			default:
				System.out.println("Erreur: type de question inconnu ("+ type + ")");
		}
		return false;
	}
}
