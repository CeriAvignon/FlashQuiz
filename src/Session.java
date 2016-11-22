
/*! 
*	\file Session.java
*	\brief Fichier java Session
*	\author {Le Veve Mathieu}
*	\date xx/10/2016
*	\date 22/11/2016
*
*	\class <Session> Session.java 	Session
*	\brief	Fichier en java qui crée une session, pour le moment avec ses getters/ setters pour créer une session
*	pour le moment sans intéraction avec la BDD. 
*/

class Session
{
  	private int static idsession = 1;
	private String session;
	private int idauthor;
	private Vector liste;
	private Vector question;
	private String datedebut;
	private String datefin;

		
	
	public bool createSession(String session, String datedebut, String datefin)
	// \param\
	{
		//if (l'utilisateur a cliqué sur le bouton de creation)
		//{	
			setIdSession(this.idsession);		// Pour le moment, initialiser quand BDD faite
			setSession(session);
			setDatedebut(datedebut);
			setDatefin(datefin);
			setIdAuthor(author);			// faire passer le string par l'IG
			
			
		//}
		
		//else 
		
		
	}
	
	/*********************** GETTERS *******************************************/
	public int getIdSession()
	{
		return this.idsession;
	}
	
	public String getSession()
	{
		return this.session;
	}
	
	public int getIdAuthor()
	{
		return this.idAuthor;
	}
	
	public Vector getListe()
	{
		return this.liste;
	}
	
	public Vector getQuestion()
	{
		return this.question;
	}

	public string getDatedebut()
	{
		return this.datedebut;
	}
	
	public string getDatefin()
	{
		return this.datefin;
	}
	
	
	/*********************** SETTERS *******************************************/
	public void setIdSession(int idsession)
	{
		this.idsession = idsession;
	}
	
	public void setSession(String session)
	{
		this.session = session;
	}
	
	public void setIdAuthor(int author)
	{
		this.idAuthor = author;
	}
	
	public void setListe(Vector liste)
	{
		this.liste = liste;
	}
	
	public void setQuestion(Vector question)
	{
		this.question = question;
	}
	
	public void setDatedebut(String datedebut)
	{
		this.datedebut = datedebut;
	}
	
	public void setDatefin(String datefin)
	{
		this.datefin = datefin;
	}
	
	/*public bool deleteSession()
	{
		if (Evenement choisi par l'utilisateur pour valider la suppression cible une session)
			{
				delete la session en cascade;
				return true;
			} 
		return false;
	}*/
	
	/*public bool modifySession()
	{
		
	}*/

}
