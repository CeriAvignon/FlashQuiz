package model.base;

import java.util.Collections;
import java.util.Date;
import java.io.Serializable;

/**
 * A session game
 *
 * @author Adrien Sartori
 */
public abstract class SessionBase implements Serializable {

	/**
	 * A session id
	 */
	public int id;

	/**
	 * A session name
	 */
	public String name;

	/**
	 * The creator name
	 */
	public String author;

	/**
	 * The password for the session
	 */
	public String password;

	/**
	 * The starting date of the session
	 */
	public Date startingDate;
	public Date endingDate;

	/**
	 * True if the order of the question is random, else false
	 */
	public boolean type;
}
