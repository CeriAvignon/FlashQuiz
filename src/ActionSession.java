package Session
import SessionData.*;
// A VOIR AVEC AMAURY
import res-bdd.SessionHandler; // nom_package.nom_class
import Session.java;

public class ActionSession
{
	Session session;

/**
* Send a session at RES-BDD
*
* @author Mathieu Le Veve
* @param no param
*/
	public static void submitSession()
	{
		sendSession(session);
		// Alexandra Moshina's function
	}



/**
* Fonction d'initialistaion de session, reçu de la bdd
*
* @author BrunoDemogue
* @param ids=id de la session a charger
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


	public void createSession()
	{
		session = new Session();	
	}

	
	public void modifSessionTitle(String title)
	{
		setTitle(title);
	}

	public void modifSessionOpen(Date open)
	{
		setOpen(open);
	}

	public  void modifSessionClose(Date close)
	{
		setClose(close);
	}

	public void modifylist(int[] newlist)
	{
		session.setList(newlist);
	}

	public void modifSessionPassword(String password)
	{
		setPassword(password);
	}

	public void modifSessionType(boolean type)
	{
		setType(type);
	}

	public Session displayInfoSession(int idsession)
	{
		session = new Session();
		session = getSessionById(idsession);

		return session;
	}

	public void delete(idsession)
	{
		deleteSession(idsession);
	}



/**
* Fonction d'ajout de liste 
*
* @author BrunoDemogue
* @param idl=id de la liste a ajouter
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
		// Pourquoi ne pas set la session + submit pour que la BDD soit mise à jour ?
		return true;
	}



/**
* Fonction de retrait de liste 
*
* @author BrunoDemogue
* @param idl=id de la liste a retirer
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
		/* Pb de decrementation là ??? */
		}
		temp.list[j]=temp.list[i-1];
		temp.list[i-1]=null;
	}

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
			}
			return true;
		}
		
	}
}


