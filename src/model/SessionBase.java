package model;

import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.Timer;
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
	 *
	 */
	public int id;
	
	/**
	 * A session name
	 *
	 */
	public String name;
	
	/**
	 * The creator name
	 *
	 */
	public String creatorName;
	
	/**
	 * The password for the session
	 *
	 */
	public String password;
	
	/**
	 * The starting date of the session
	 *
	 */
	public Date startingDate;
	
	/**
	 * True if the order of the question is random, else false
	 *
	 */
	public boolean isQuestionOrderRandom;
	
	/**
	 * Constructor
	 *
	  * @param id 
	 *			  The id of the session.
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
	 * @see SessionBase#id
	 * @see SessionBase#name
	 * @see SessionBase#creatorName
	 * @see SessionBase#password
	 * @see SessionBase#startingDate
	 * @see SessionBase#isQuestionRandom
	 */
	public SessionBase(int id, String name, String creatorName, String password, Date date, boolean rand)
	{
		this.id = id;
		this.name = name;
		this.creatorName = creatorName;
		this.password = password;
		this.startingDate = date;
		this.isQuestionOrderRandom = rand;
	}
}
