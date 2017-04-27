package controller;
import model.base.*;
import resbdd.*; // nom_package.nom_class
public class ActionQuestion
{

	Question temp;

	public static void submitQuestion()      						
	{         	
		sendQuestion(temp);
	}

	public static void initQuestion(int idq)
	{
		temp = getQuestion(idq);
	}

	public static void modifQuestionStatement(String statement)
	{
		this.statement = statement;
	}
	

	public static boolean modifListAddAnswer(int ida)
	{
		int i;
		while(temp.answer[i]!=null)
		{
			i++;
			if(temp.answer[i]==ida)
			{
				return false;
			}
		}

		temp.answer[i]=ida;
		return true;
	}
	public static void modifQuestionDeleteAnswer(int ida)
	{
		
		int i;
		int j;
		while(temp.answer[i]!=null)
		{
			if(temp.answer[i]=ida)
			{
				j=i;
			}
		}
		temp.answer[j]=temp.answer[i-1];
		temp.answer[i-1]=null;
	}


	public static void SupressionQuestion(idq)

	{	
		SupressionListQuestion(idq);		
		SupressionQuestion(idq);				
	}

}













