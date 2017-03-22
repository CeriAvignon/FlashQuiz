class Answer
{
	private int id; 									
	private String content; 							
	private boolean correct;

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
* getter de l'atribut content
*
* @return retourne la valeur de l'atribut content
*/
	public String getContent()
	{
		return this.content;
	}
	/**
* getter de l'atribut correct
*
* @return retourne la valeur de l'atribut correct
*/
	public boolean getCorrect()
	{
		return this.correct;
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
* setter de l'atribut content
*
* @param content = valeur à atribuer à content
*/
	public void setContent(String content)
	{
		this.content= content;
	}
/**
* setter de l'atribut correct
*
* @param correct = valeur à atribuer à correct
*/
	public void setCorrect(int correct)
	{
		this.correct = correct;
	}	
}