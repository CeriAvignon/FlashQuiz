package model.class_el;
import model.base.*;
class Question extends QuestionBase
{
	public int idmedia;								
	public Answer[] answer;	
	static boolean mediaExist;// True si la question a un Media
	
	public Question()
	{
		idmedia= -1;
		answer = null;
		MediaExist = false;

	}
	public Question(int idmedia, Answer[] answer, boolean mediaExist) {
		this.idmedia=idmedia;
		this.mediaExist=mediaExist;
		for(int i=0;i<answer.length;i++)
		{
			this.answer[i]=answer[i];
		}
	}

}
