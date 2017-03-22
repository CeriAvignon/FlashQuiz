public class ActionList
{
	List temp;
/**
* Fonction de modification globale, elle envoie l'objet a la bdd
*
* @author BrunoDemogue
*/
	public static void submitList()      						
	{         	
		sendList(temp);
	}

/**
* Fonction d'initialistaion de liste
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
*/

	public static void initListe(int idl)
	{
		ResultSet res = getList(idl);
		res.next();

		ResultSet res2 = getQuestionByIdListe(idl);
		int question[];
		int i=0;

		while (res2.next()) 
		{
		    question[i]=res.getInt("ID_Question");
		    i++;
		}
		temp = new List(res.getInt("ID_List"),res.getString("Title"),res.getInt("ID_User"),question);
	}


	
/**
* Fonction de modification du nom d'une liste
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
*/

	public static void modifListName(String name)
	{
		setName(name);
	}
	
	

/**
* Fonction d'ajout de question a une liste 
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
*/
	public static boolean modifListAddQuestion(int idq)
	{
		int i;
		while(temp.question[i]!=null)
		{
			i++;
			if(temp.question[i]==idq)
			{
				return false;
			}
		}

		temp.question[i]=idq;
		return true;
	}

/**
* Fonction de supression de question d'une liste 
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
*/
	public static void modifListDeleteQuestion(int idq)
	{
		
		int i;
		int j;
		while(temp.question[i]!=null)
		{
			if(temp.question[i]=idq)
			{
				j=i;
			}
		}
		temp.listquestion[j]=temp.listquestion[i-1];
		temp.listquestion[i-1]=null;
	}

	public static void Supressionliste(idl)
	{
		SupressionSessionList(idl);			// fonction bdd qui reçoie un  id de liste et supprime le lien entre les Session et cette liste
		SupressionQuestionList(idl);		// fonction bdd qui reçoie un  id de liste et supprime le lien entre les question et cette liste
		SupressionListe(idl);				// supression de la liste dans la bdd
	}
}