package model.class_el;
import model.base.*;

class List extends ListBase
{
	public int question[];								// question

/**
* constructeur vide de liste 
*/
	public List()
	{
		this.id = -1;
		this.name = "";
		this.author = 0;
		this.question=null;
	}

/**
* constructeur de liste
*
* @param id = valeur à atribuer à id
* @param name = valeur à atribuer à name
* @param author = valeur à atribuer à author
* @param listquestion = tableau de valeaur
*/
	public List(int id,String name,int author,int question[])
	{
		this.id = id;
		this.name = name;
		this.author = author;
		for(int i=0;i<question.length;i++)
		{
			this.question[i]=question[i];
		}
	}
}
