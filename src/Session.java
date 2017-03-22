import java.util.Date;
public class Session
{
  	private int id;
	/* 
		variable <int> globale privée:	définit via une requête SQL vers l'id de la session
										dépend fortement du groupe BDD
	*/
	private String name;
	// Variable <String> privée:		définit via une chaîne de caractères saisie par l'utilisateur*/
	private int author;
	/* 
		Variable <Int> privée:			définit via une requête SQL vers l'id de l'auteur envoyé par le groupe
										IG, puis récupération de l'information dans la table users.
	*/
	private int list[];
	/* 
		Variable <Int> privée: 			définit durant une session, ou part la création de session.
						
	*/				
	
	private Date debut;
	// Variable <String> privée:		définit par l'utilisateur.
	private Date fin;

	private String password;
	private boolean type;			//obsolete?



	public Session ()		
	{	
		
	}

	/*********************** GETTERS *******************************************/
	
/**
	* idsession attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return idsession attribute value
	*/
	public int getId()
	{
		return this.id;
	}
	
/**
	* session attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return session attribute value
	*/
	public String getName()
	{
		return this.name;
	}
	
/**
	* idauthor attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return idauthor attribute value
	*/
	public int getAuthor()
	{
		return this.author;
	}
	
/**
	* liste vector attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return liste int[] attribute value
	*/
	
	public int[] getList()
	{
		return this.list;
		// Ceci est une liste d'identifiants de listes 
	}

/**
	* datedebut attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return datedebut attribute value
	*/
	public Date getDebut()
	{
		return this.debut;
	}
	
/**
	* datefin attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return datefin attribute value
	*/
	public Date getFin()
	{
		return this.fin;
	}
	
/**
	* password attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return password attribute value
	*/
	public String getPassword()
	{
		return this.password;
	}

/**
	* typesession attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return typesession attribute value
	*/
	
	public boolean getType()
	{
		return this.type;//obsolete?
	}

	/*********************** SETTERS *******************************************/
/**
	* idsession setting
	*
	* @author LE VEVE Mathieu
	* @param idsession = session with the number idsession  (Int)
	*/
	public void setId(int id)
	{
		this.id = id;
	}
	
/**
	* session setting
	*
	* @author LE VEVE Mathieu
	* @param session = name session (String)
	*/
	public void setName(String name)
	{
		this.name = name;
	}
	
/**
	* author setting
	*
	* @author LE VEVE Mathieu
	* @param author = author's session (Int)
	*/
	public void setAuthor(int author)
	{
		this.author = author;
	}
	
/**
	* liste setting
	*
	* @author LE VEVE Mathieu
	* @param liste = Vector<Liste> attributed to the session
	*/
	
	public void setList(int list[])
	{
		this.list = list;
	}
	
/**
	* beginningdate setting
	*
	* @author LE VEVE Mathieu
	* @param datedebut = beginning date session
	*/
	public void setDebut(String debut)
	{
		this.debut = debut;
	}
	
/**
	* closingdate setting
	*
	* @author LE VEVE Mathieu
	* @param datefin = ending date session
	*/
	public void setFin(String fin)
	{
		this.fin = fin;
	}

/**
	* password setting
	*
	* @author LE VEVE Mathieu
	* @param password = encrypted password 
	*/
	public void setPassword(String password)
	{
		this.password = password;
	}
	
/**
	* sessiontype setting
	*
	* @author LE VEVE Mathieu
	* @param typesession = session type
	*/
	public void setType(boolean type)
	{
		this.type = type;//obsolete?
	}
}
