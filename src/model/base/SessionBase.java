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
	protected int id;

	/**
	 * A session name
	 */
	protected String name;

	/**
	 * The creator name
	 */
	protected String author;

	/**
	 * The password for the session
	 */
	protected String password;

	/**
	 * The starting date of the session
	 */
	protected Date startingDate;
	protected Date endingDate;

	/**
	 * True if the order of the question is random, else false
	 */
	protected boolean type;
}
