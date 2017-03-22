public class ActionSession
{
	Session temp;
/**
* Fonction de modification globale, elle envoie l'objet a la bdd
*
* @author BrunoDemogue
*/
	public void submitSession()      						
	{         	
		sendSession(temp);
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

/**
* Fonction de modification de la date d'ouverture
*
* @author BrunoDemogue
* @param open=nouvelle date d'ouverture a atribuer
*/
	public  void modifSessionOpen(Date open)
	{
		setOpen(open);
	}

/**
* Fonction de modification de la date de fermeture
*
* @author BrunoDemogue
* @param close=nouvelle date de fermeture a atribuer
*/
	public  void modifSessionClose(Date close)
	{
		setClose(close);
	}
	
/**
* Fonction de modification du MDP
*
* @author BrunoDemogue
* @param password=nouveau mot de passe a atribuer
*/
	public  void modifSessionPassword(String password)
	{
		setPassword(password);
	}
	
/**
* Fonction de modification du type
*
* @author BrunoDemogue
* @param type=nouveau type a atribuer
*/
	public  void modifSessionType(boolean type)
	{
		setType(type);
	}
	
/**
* Fonction de modification du titre 
*
* @author BrunoDemogue
* @param title=nouveau titre a attribuer
*/
	public  void modifSessionTitle(String title)
	{
		setTitle(title);
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
		return true;
	}
	
/**
* Fonction de retrait de liste 
*
* @author BrunoDemogue
* @param idl=id de la liste a retirer
*/
	public  void modifSessionDeleteList(int idl)
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

}
