class Question
{
	private int id; 									//
	private Media media;								
	private Answer[] answer;	
	
  	static int type;
	static String Content;
	static boolean MediaExist;// True si la question a un Media
	
	Question(int QuestType, String QuestConten, boolean MediaExist) {
		Question.type=QuestType;
		Question.Content=QuestConten;
		Question.MediaExist=MediaExist;
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
* getter de l'atribut type
*
* @return retourne la valeur de l'atribut type
*/
	public int getType()
	{
		return type;
	}
	/**
* getter de l'atribut media
*
* @return retourne l'objet Media
*/
	public Media getMedia()
	{
		return this.media;
	}
	/**
* getter de l'atribut answer
*
* @return retourne l'objet Answer
*/
	public Answer getAnswer()
	{
		return this.answer;
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
* setter de l'atribut type
*
* @param type = valeur à atribuer à type
*/
	public void setType(int type)
	{
		Question.type = type;
	}	


	/**
* setter de l'atribut media
*
* @param type = valeur à atribuer à type
*/
	public void setMedia(Media media)
	{
		this.media=media;
	}
	/**
* getter de l'atribut answer
*
* @param type = valeur à atribuer à type
*/
	public void setAnswer(Answer answer)
	{
		this.answer=answer;
	}
	
	public static String getContent() {
		return Content;
	}
	
	public static void setContent(String content) {
		Content = content;
	}
	
	public static boolean isMediaExist() {
		return MediaExist;
	}
	
	public static void setMediaExist(boolean mediaExist) {
		MediaExist = mediaExist;
	}

}
