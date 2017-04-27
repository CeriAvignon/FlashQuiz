public class ActionAnswer
{
		List temp;
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

	public static void initAnswer(int idl)
	{
		ResultSet res = getAnswer(idl);
		res.next();
		temp= new Answer(res.getInt("id"),res.getString("content"),res.getInt("correct"));
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

	public static void deleteAnswer(int id)
	{
		deleteAnswer(id);		
		deleteAnswerInQuestion(id);										
	}
}