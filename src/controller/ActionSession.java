package controller;
//import SessionData.*;
import resbdd.*; // nom_package.nom_class
import model.base.*;

public class ActionSession
{
	Session session;

/**
* @brief Send a session at RES-BDD
*
* @author Mathieu Le Veve
* @param no param
* @return void
*/
	
	public static void submitSession()
	{
		sendSession(session);
		// Alexandra Moshina's function
	}


/**
* @brief Init Session object with an ID session
*
* @author Mathieu Le Veve
* @param ids
*/
	public void initSession(int ids)
	{
		ResultSet res = getSession(ids);
		res.next();

		ResultSet res2 = getListByIdSession(ids);
		int list[];
		int i=0;

		while (res2.next()) 
		{
		    list[i]=res.getInt("ID_List");
		    i++;
		}
		temp = new List(
			res.getInt("ID_Session"),
			res.getInt("ID_User"),
			res.getDate("Opening_Date"),
			res.getDate("Closing_Date"),
			res.getString("Password"),
			res.getBoolean("Type"),
			res.getString("Title"),
			list);
	}

/**
* @brief Create a session when a user click on the IG Button
*
* @author Mathieu Le Veve
* @param no param
* @return void
*/
	public void createSession()
	{
		session = new Session();	
	}

/**
* @brief Alter session name with a new name
*
* @author Mathieu Le Veve
* @param name = Name of the modified object
* @return void
*/	
	public void modifSessionTitle(String name)
	{
		setTitle(name);
	}

/**
* @brief Alter session open date with a new open date
*
* @author Mathieu Le Veve
* @param startingDate = Open date of the modified object
* @return void
*/
	public void modifSessionOpen(Date startingDate)
	{
		setOpen(startingDate);
	}

/**
* @brief Alter session ending date with a new ending date
*
* @author Mathieu Le Veve
* @param endinggDate = ending date of the modified object
* @return void
*/
	public  void modifSessionClose(Date endingDate)
	{
		setClose(endingDate);
	}
	
/**
* @brief Alter session id List(...) with a new id List(...) date
*
* @author Mathieu Le Veve
* @param newlist = new list of id of the modified object
* @return void
*/
	public void modifylist(int[] newlist)
	{
		session.setList(newlist);
	}

/**
* @brief Alter session password with a new password
*
* @author Mathieu Le Veve
* @param password = password of the modified object
* @return void
*/
	public void modifSessionPassword(String password)
	{
		setPassword(password);
	}

/**
* @brief Alter session type with a new type of session
*
* @author Mathieu Le Veve
* @param type = type of the modified object
* @return void
*/
	public void modifSessionType(boolean type)
	{
		setType(type);
	}

/**
* @brief Display Info about the target session by ID
*
* @author Mathieu Le Veve
* @param idsession = Session ID 
* @return Session object
*/
	public Session displayInfoSession(int idsession)
	{
		session = new Session();
		session = getSessionById(idsession);
		//@getSessionById(int id)
		// Alexandra Moshina's function wich return a session by id
		return session;
		// A cet instant, IG affichera chaque element des sessions trouvées par l'id
	}
	
/**
* @brief delete by ID
*
* @author Demogue Bruno
* @param idsession = Session ID 
* @return void
*/
	public void delete(idsession)
	{
		deleteSession(idsession);
		//@deleteSession(int id)
		// Alexandra Moshina's function wich return a session by id
	}

/**
* @brief modify a Session adding List with an id List
*
* @author Demogue Bruno
* @param idsession = Session ID 
* @return boolean
*/
	public boolean modifSessionAddlist(int idl)
	{
		int i;
		while(temp.list[i]!=null)
		{
			i++;
			if(temp.list[i]==idl)
			{
				return false;
			}
		}

		temp.list[i]=idl;
		return true;
	}


/**
* @brief modify a Session deleting List with an id List
*
* @author Demogue Bruno
* @param idsession = Session ID 
* @return void
*/
	public void modifSessionDeleteList(int idl)
	{
		
		int i;
		int j;
		while(temp.list[i]!=null)
		{
			if(temp.list[i]=idl)
			{
				j=i;
			}
		}
		temp.list[j]=temp.list[i-1];
		temp.list[i-1]=null;
	}

/**
* @brief Find session by string name
*
* @author LE VEVE Mathieu
* @param name = Session name to find
* @return boolean
*/
	public boolean findSession(String name)
	{
		int tabid[];
		int id ; 
		tabid = GetSessionsByName(name); 
		/*@GetSessionByName(name)
			GetSessionByName: fonction implémentée par Alexandra Moshina RES-BDD tâche 34*/

		if (tabid.length == 0)
		// SI aucun element dans le tableau c'est que rien n'a été rempli
		{
			System.out.println("La session " + name + " n'existe pas.");
			return false;
		}

		else {
		// SInon on parcourt le tableau remplit pour en afficher les infos (que gereront IG)
			for (int i = 0; i < tabid.length; i++)
			{
				id = tabid[i];
				displayInfoSession(id);
				// Affiche les infos de la session
			}
			return true;
		}
		
	}
}


