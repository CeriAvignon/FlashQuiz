public class ActionAnswer
{
	Answer temp;
/**
* Fonction de modification globale
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
*/
	public static void submitAnswer()      						
	{         	
		sendAnswer(temp);
	}

/**
* Fonction d'initialistaion de liste
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
*/
	public static void createAnswer()
	{
		temp = new Answer();	
	}

/**
* Fonction d'initialistaion de liste
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
*/

	public static void initAnswer(int idq,int idr)
	{
		ResultSet res = getAnswer(idr);
		res.next();
		temp= new Answer(res.getInt("idq"),res.getInt("idr"),res.getString("content"),res.getInt("correct"));
	}

/**
* Fonction de modification du nom d'une liste
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
*/

	public static void modifContent(String content)
	{
		setContent(content);
	}

/**
* Fonction de modification du nom d'une liste
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
*/

	public static void modifCorrect(Boolean correct)
	{
		setCorrect(correct);
	}

	public static void deleteAnswer(int idr)
	{
		deleteAnswer(idr);											
	}
}
