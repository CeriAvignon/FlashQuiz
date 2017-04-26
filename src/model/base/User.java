package model.base;

import java.io.Serializable;

/**
 * User contain all the general information on an user, the id, the first name, the name and the login.
 *
 * @author Adrien Sartori
 */
public class User implements Serializable {
	/**
	 * Contain the id of the user.
	 *
	 */
	public int id;
	 
	 /**
	  * Contain the first name of the user.
	  *
	  */
	public String firstName;
	 
	 /**
	  * Contain the name of the user.
	  *
	  */
	public String name;
	 
	 /**
	  * Contain the login of the user.
	  *
	  */
	public String login;
	 
	 /**
	  * Constructor of the class User.
	  */
	public User() {
	} 
}
