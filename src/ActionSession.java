//import connexionjm.ConnexionJM;
//import session.Session;
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
*/
	/*public static void submitSession()
	{
		sendSession(session);
		// Alexandra Moshina's function
	}*/

	public void createSession()
	{
		session = new Session();	
	}

	
	public void modifyName(String newname)
	{
		session.setName(newname);
	}

	public void modifyStartingDate(Date newdate)
	{
		session.setDebut(newdate);
	}

	public void modifyEndingDate(Date newdate)
	{
		session.setFin(newdate);
	}
 
	public void modifylist(int[] newlist)
	{
		session.setList(newlist);
	}

	public void modifyPassword(String newpassword)
	{
		session.setPassword(newpassword);
	}
	public void modifyType(boolean type)
	{
		session.setType(type);		
		// on peut imaginer que le type de la session sera envoyé par IG lors d'un clique sur une case : "souhaitez vous une session libre/fermée"
	}
		
}
