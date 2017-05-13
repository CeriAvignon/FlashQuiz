package model.session;

import java.util.*;
import java.io.Serializable;

/**
 * This class makes VoterAnswer storage easier, using a Map. It associates
 * VoterAnswer objects with a number.
 *
 * @author Julien Boge
 */
public class VoterAnswerList extends HashMap<Integer, VoterAnswer>
		implements Serializable {
	/**
	 * Constructs an empty VoterAnswerList using HashMap default constructor.
	 */
	public VoterAnswerList() {
		super();
	}

	/**
	 * Associates the specified VoterAnswer object with the specified id. Alias
	 * for the put method from the Map class.
	 *
	 * @param id
	 *            the integer to which the VoterAnswer will be associated
	 * @param voterAnswer
	 *            the VoterAnswer object to be associated
	 * @see Map#put
	 */
	public void addAnswer(int id, VoterAnswer voterAnswer) {
		this.put(id, voterAnswer);
	}

	/**
	 * Returns the VoterAnswer object to which the specified id is mapped, or
	 * null if map contains no mapping for this id. Alias for the get method
	 * from the Map class.
	 *
	 * @param id
	 *            the integer corresponding to the desired answer
	 * @return the desired VoterAnswer object, or null if there is none
	 * @see Map#get
	 */
	public VoterAnswer getAnswer(int id) {
		return this.get(id);
	}

	public void save() {
		for (Map.Entry<Integer, VoterAnswer> entry : this.entrySet()) {
			entry.getValue().save();
		}
	}
}
