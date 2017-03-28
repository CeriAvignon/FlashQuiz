package model.session;

import java.util.*;
import java.io.Serializable;

/**
 * This class makes VoterAnswer storage easier, using a Map.
 * It associates VoterAnswerList objects with an integer as an id of the user.
 * It allows getting VoterAnswer objects by user id or by question id.
 *
 * @author Julien Boge
 */
public class VotersAnswersList
extends HashMap<Integer, VoterAnswerList>
implements Serializable
{
	/**
	 * Constructs an empty VotersAnswersList using HashMap default constructor.
	 */
	public VotersAnswersList() {
		super();
	}

	/**
	 * Associates a VoterAnswer object to a user id and a question id.
	 *
	 * @param userId       the integer corresponding to the user identifier
	 * @param questionId   the integer corresponding to the question identifier
	 * @param voterAnswer  the VoterAnswer object to be associated
	 */
	public void addAnswer(int userId, int questionId, VoterAnswer voterAnswer)
	{
		if(this.get(userId) == null) {
			VoterAnswerList voterAnswers = new VoterAnswerList();
			this.put(userId, voterAnswers);
		}
		this.get(userId).addAnswer(questionId, voterAnswer);
	}

	/**
	 * Returns the VoterAnswer object associated with the specified user and
	 * question identifiers, or null if there is none.
	 *
	 * @param userId       the integer corresponding to the user identifier
	 * @param questionId   the integer corresponding to the question identifier
	 * @return             the VoterAnswer object associated with the specified
	 *                     userId and questionId, or null if there is none
	 */
	public VoterAnswer getAnswerByVoterAndQuestion(int userId, int questionId)
	{
		VoterAnswerList voterAnswers = getAnswersByVoter(userId);
		if(voterAnswers == null)
			return voterAnswers.getAnswer(questionId);
		return null;
	}

	/**
	 * Returns the VoterAnswerList associated with the specified user identifier
	 * or null if there is none.
	 *
	 * @param userId    the integer corresponding to the user identifier
	 * @return          the VoterAnswerList object associated with the specified
	 *                  userId, or null if there is none
	 */
	public VoterAnswerList getAnswersByVoter(int userId)
	{
		return this.get(userId);
	}

	/**
	 * Returns a VoterAnswerList containing answers corresponding to the
	 * specified question id.
	 *
	 * @param questionId   the integer corresponding to the question identifier
	 * @return             a VoterAnswerList containing the answers corresponding
	 *                     to the specified question id, or null if there is none
	 */
	public VoterAnswerList getAnswersByQuestion(int questionId)
	{
		VoterAnswerList answers = new VoterAnswerList(); // list to be returned

		int voterId;
		VoterAnswer voterAnswer;

		for(Map.Entry<Integer,VoterAnswerList> entry : this.entrySet()) {
			voterId = entry.getKey();
			voterAnswer = entry.getValue().get(questionId);
			if(voterAnswer != null)
				answers.addAnswer(voterId, voterAnswer);
		}

		if(answers.isEmpty())
			return null;

		return answers;
	}
}
