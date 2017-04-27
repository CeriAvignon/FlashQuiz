package model.session;

import java.util.*;
import java.io.Serializable;
import model.base.*;

/**
 * A session game
 *
 * @author Adrien Sartori
 */

public class Session extends SessionBase implements Serializable {
	/**
	 * A list that contain all the questions series (lists)
	 */
	public List<QuestionList> lists;

	/**
	 * List of the answers of the voters
	 */
	public VotersAnswersList votersAnswersList;

	/**
	 * Session constructor
	 */
	public Session(){
	}

	/**
	 * Constructor
	 *
	 * @param id
	 *			  The id of the sessiononBase#name
	 */
	public Session(int id)
	{
		//TODO
	}

	public void save() {

		SessionHandler.sendSession(this);
	}


}
