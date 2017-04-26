import model.base*;

class List extend ListBase
{
	public int question[];								// question

/**
* constructeur vide de liste 
*/
	public List()
	{
		super();
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
		super(id,name,author);
		for(int i=0;i<question.lenght;i++)
		{
			this.question[i]=question[i];
		}
	}
}
