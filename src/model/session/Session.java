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
	 *
	 */
	public List<QuestionList> lists;
	
	/**
	 * Constructor
	 *
	 * @param id
	 *			  The id of the session
	* @param name
	 *            The name of the session.
	 * @param creatorName
	 *            The name of the creator.
	 * @param password
	 *			  The password of the session.
	 * @param date
	 * 			  The starting date of the session.
	 *
	 * @param rand
	 * 			  True if the order of the question is random, else false.
	 * @param listsId
	 * 			  A table that contain all the id of the lists
	 * @see SessionBase#id
	 * @see SessionBase#name
	 * @see SessionBase#creatorName
	 * @see SessionBase#password
	 * @see SessionBase#startingDate
	 * @see SessionBase#isQuestionRandom
	 * @see Session#lists
	 */
	public Session(int id, String name, String creatorName, String password, Date date, boolean rand, int[] listsId)
	{
		super(id, name, creatorName, password, date, rand);
		// for(Integer list : listsId)
			// this.list.add(getList(list)); // ListHandler
	}
	
	public void addList(List l) {
		//TODO
	}

}
