import connexionjm.ConnexionJM;
import java.util.Date;
//package Session


public class ActionSession
{
	private Session session;

/**
* Send a session at RES-BDD
*
* @author Mathieu Le Veve
* @param no param
* @description function to submit a Session Object called by us, sended to RES-BDD group.
*/
	public static void submitSession()
	{
		sendSession(session);
		// Alexandra Moshina's function
	}

/**
	* @author Le Veve Mathieu
	* @param no param
	* @description function to create new session called by IG group
*/
	public static void CreateSession()
	{
		session = new Session();	
	}

/**
	* @author Le Veve Mathieu
	* @param newname String New session name chose by user 
	* @description function to set new session name called by IG group
*/
	
	public static void modifyName(String newname)
	{
		session.setName(newname);
	}

	/**
	* @author Le Veve Mathieu
	* @param newdate Date Object New starting date for private session chose by user 
	* @description function to set new starting Date called by IG group
*/
	public static void modifyStartingDate(Date newdate)
	{
		session.setDebut(newdate);
	}

	/**
	* @author Le Veve Mathieu
	* @param newdate Date Object New ending date for private session chose by user 
	* @description function to set new ending Date called by IG group
*/
	public static void modifyEndingDate(Date newdate)
	{
		session.setFin(newdate);
	}

	/**
	* @author Le Veve Mathieu
	* @param newlist int[] Object New list of ID list selected by user 
	* @description function to set new list of id list called by IG group
*/
	public static void modifylist(int[] newlist)
	{
		session.setList(newlist);
	}

	/**
	* @author Le Veve Mathieu
	* @param newpassword String Object New password choose by user 
	* @description function to set new session password called by IG group
*/
	public static void modifyPassword(String newpassword)
	{
		session.setPassword(newpassword);
	}
	
	/**
	* @author Le Veve Mathieu
	* @param type Boolean   the session type alters the session mode, and it selected by user 
	* @description function to set new session type  called by IG group after the form submission
*/
	public static void modifyType(Boolean type)
	{
		session.setType(type);		
		// on peut imaginer que le type de la session sera envoyé par IG lors d'un clique sur une case : "souhaitez vous une session libre/fermée"
	}
}
