package controller;
import model.base.*;
import resbdd.*; 
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
		temp= new Answer(res.idq,res.id,res.content,res.state);
	}

/**
* Fonction de modification du nom d'une liste
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
*/

	public static void modifContent(String content)
	{
		this.content = content;
	}

/**
* Fonction de modification de l'état d'une liste
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
*/

	public static void modifCorrect(Boolean correct)
	{
		this.state = state;
	}

	public static void deleteAnswer(int id)
	{
		deleteAnswer(id);		
		deleteAnswerInQuestion(id);										
	}
}
