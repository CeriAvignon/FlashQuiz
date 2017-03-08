class List
{
	private int id; 									// id
	private String name; 								// nom
	private int author;									// id auteur
	private int question[];								// question

/**
* constructeur vide de liste 
*
*/
	public Question()
	{
		this.id=0;
		this.name="";
		this.author=0;
		this.question=NULL;
	}

/**
* constructeur de liste
*
* @param id = valeur à atribuer à id
* @param name = valeur à atribuer à name
* @param author = valeur à atribuer à author
* @param listquestion = tableau de valeaur
*/
	public Question(int id,String name,int author,int question[])
	{
		this.id=id;
		this.namelist=name;
		this.author=author;
		for(int i=0;i<question.lenght;i++)
		{
			this.question[i]=question[i];
		}
	}

/**
* getter de l'atribut id
*
* @return retourne la valeur de l'atribut id
*/
	public int getId()
	{
		return this.id;
	}
/**
* getter de l'atribut name
*
* @return retourne la valeur de l'atribut name
*/
	public String getName()
	{
		return this.name;
	}
/**
* getter de l'atribut author
*
* @return retourne la valeur de l'atribut author
*/
	public int getAuthor()
	{
	return this.author;
	}	
/**
* getter de l'atribut question
*
* @return retourne la valeur de l'atribut question
*/
	public int[] getQuestion()
	{
		return this.question;
	}
/**
* setter de l'atribut id
*
* @param id = valeur à atribuer à id
*/
	public void setId(int id)
	{
		this.id = id;
	}
/**
* setter de l'atribut name
*
* @param name = valeur à atribuer à name 
*/
	public void setName(String name)
	{
		this.name= name;
	}	
/**
* setter de l'atribut author
*
* @param author = valeur à atribuer à author
*/
	public void setAuthor(int author)
	{
		this.author = author;
	}	
/**
* setter de l'atribut list
*
* @param question = tableau de valeur à atribuer à question
*/
	public void setQuestion(int question [])
	{
		int i=0;
		while(question[i]!=NULL)
		{
			this.question[i] = question[i];
			i++
		}
	}
}
