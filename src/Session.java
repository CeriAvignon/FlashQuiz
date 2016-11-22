//package session;			// Package session liée a EL --> Package \author :@LE VEVE Mathieu
import java.util.Scanner;		// Saisie clavier: Scanner keyboard = new Scanner (...)
import java.util.Vector;		// Création <vector> question / <vector> liste
import java.sql.Connection;		// Connection connection = new Connection (...)
import java.sql.DriverManager;		// Accès pour la BDD
import java.io.File;			// pour la simulation de bdd --> Phases de tests par lecture/ écriture
//import connexionjm.ConnexionJM;		// Package liée à la BDD --> Package \author :@HUOT AMAURY
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
	/*variable <int> globale privée:	implémentée via une requête SQL vers l'id de la session
						dépend fortement du groupe BDD
	*/
	private String session;
	/* Variable <String> privée:		implémentée via une chaîne de caractères saisie par l'utilisateur*/
	private int idauthor;
	/* Variable <Int> privée:		implémentée via une requête SQL vers l'id de l'auteur*/
	private Vector<Liste> liste;
	/* Variable <Vector> privée: 		implémentée durant une session, ou part la création de session.
						dépend fortement du groupe TVS.
	*/				
	private Vector<Question> question;
	/* Variable <Vector> privée: 		implémentée durant une session, ou part la création de question.
						dépend fortement du groupe TVS.
	*/
	private String datedebut;
	/* Variable <String> privée:		implémentée par l'utilisateur.*/
	private String datefin;
	/* Variable <String> privée:		implémentée par l'utilisateur.*/
	//private Connection connection;
	/* Variable <Connection> privée: 	Objet implémenté par un accès BDD sql 
	A implementer plus tard 
	*/
	
	public boolean createSession(String session, String datedebut, String datefin)
	// \param\
	{
		//if (l'utilisateur a cliqué sur le bouton de creation)
		//{	
			setIdSession(this.idsession);		// Pour le moment, initialiser quand BDD faite
			setNomSession(session);
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
	
	public String getNomSession()
	{
		return this.session;
	}
	
	public int getIdAuthor()
	{
		return this.idauthor;
	}
	
	public Vector<Liste> getListe()
	{
		return this.liste;
	}
	
	public Vector<Question> getQuestion()
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
	
	public void setNomSession(String session)
	{
		this.session = session;
	}
	
	public void setIdAuthor(int author)
	{
		this.idauthor = author;
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
