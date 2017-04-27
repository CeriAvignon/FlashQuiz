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
 * @author Jean-Loup Gaussen, Adrien Sartori
 */
public class Question extends QuestionBase implements Serializable {
	/**
	 * Defined answers for the question.
	 */
	public Answer[] answers;

	/**
	 * Question constructor
	 */
	public Question(){
	}

	/**
	 * Constructor
	 */
	public Question(int id) {
		Question tmp = getQuestion(id);
		this.id = tmp.id;
		this.statement = tmp.statement;
		this.type = tmp.type;
		this.allocatedTime = tmp.allocatedTime;
		this.answers = tmp.answers;
	}

	/**
	 * Verify if the user's answer is correct
	 *
	 * @param voterAnswer  The user's answer
	 * @return true if voterAnswer is correct, false otherwise
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


	public void save() {

		QuestionHandler.sendQuestion(this);
	}

}
