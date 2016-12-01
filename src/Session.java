//package session;			// Package session liée a EL --> Package @author LE VEVE Mathieu
import java.util.Scanner;		// Saisie clavier: Scanner keyboard = new Scanner (...)
import java.util.Vector;		// Création <vector> question / <vector> liste
import java.sql.Connection;		// Connection connection = new Connection (...)
import java.sql.DriverManager;		// Accès pour la BDD
import javax.swing.*;
import java.util.Calendar;		//Calendrier
import java.awt.event.*;
import java.util.Timer;			// Timer
import java.util.TimerTask;		// Effectuer tâche (evenement) pour timer
import java.io.File; 			//pour la simulation de bdd
import java.io.FileWriter;		// écriture dans un fichier
import java.lang.Throwable;
import java.lang.Exception;		// relever des exceptions
import java.io.IOException;		// relever exception IO
import java.io.FileNotFoundException;
import connexionjm.ConnexionJM;	 	//Package liée à la BDD --> Package @author HUOT AMAURY

/** 
	*	\file Session.java
	*	\brief Fichier java Session
	*	\author {Le Veve Mathieu, Ezzahidi Meryem}
	*	\date xx/10/2016
	*	\date 22/11/2016
	*	\date 24/11/2016
	*	\date 30/11/2016
	*	\class <Session> Session.java 	Session
	*	\brief	Fichier en java qui crée une session, pour le moment avec ses getters/ setters pour créer une session
	*	pour le moment sans intéraction avec la BDD. 
	*/




public class Session
{
  	private static int idsession;
	/* variable <int> globale privée:	implémentée via une requête SQL vers l'id de la session
						dépend fortement du groupe BDD
	*/
	private String session;
	// Variable <String> privée:		implémentée via une chaîne de caractères saisie par l'utilisateur*/
	private int idauthor;
	// Variable <Int> privée:		implémentée via une requête SQL vers l'id de l'auteur
	private Vector<Liste> liste;
	/* Variable <Vector> privée: 		implémentée durant une session, ou part la création de session.
						dépend fortement du groupe TVS.
	*/				
	private Vector<Question> question;
	/* Variable <Vector> privée: 		implémentée durant une session, ou part la création de question.
						dépend fortement du groupe TVS.
	*/
	private String datedebut;
	// Variable <String> privée:		implémentée par l'utilisateur.
	private String datefin;
	/* Variable <String> privée:		implémentée par l'utilisateur.
	
/**
        * @see ConnexionJM
	*/
	/*
	private Connection connection;
	Variable <Connection> privée: 	Objet implémenté par un accès BDD sql 
	A implementer plus tard 
	*/
	private String password;
	private boolean typesession;
	//private int nbrquestion;
	
	/*********************** Constructors *******************************************/

	public Session ()
/**
	* parameters-free Constructor
	* @author Le Veve Mathieu
	* @description
		Constructeur vide initialisée lorsque l'utilisateur créera une session sans paramètres
	 sans lui associer de questions, sans lui associer de listes.
	*/
	{	
		this.idsession = 0;		// Pour le moment, initialiser quand BDD faite
		this.session = "no name";
		this.idauthor= 0;
		this.datedebut = "no beginning date";
		//this.setIdAuthor(author);			// faire passer le string par l'IG
		this.datefin = "no ending date";
		this.password = "no password";
		this.typesession = false;
		//this.liste=;
		//this.question=;
	}

	public Session (String session, String password, boolean typesession)
/**
	* @author Le Veve Mathieu
	* @parameters 	session = name session	(String)
			password = password session (String)
			typesession = session type (Boolean)
	* @description
		Constructeur avec 3 arguments, pour définir une session libre (avec mot de passe),
		sans gestion du timer.
	*/
	{
		setIdSession(this.idsession);		// Pour le moment, initialiser quand BDD faite
		setNomSession(session);
		setDatedebut(datedebut);
		setDatefin(datefin);
		//setIdAuthor(author);			// faire passer le string par l'IG
		setPassword(password);
		setTypeSession(typesession);
	}
	
	public Session (String session, String datedebut, String datefin, String password, boolean typesession)
/**
	* @author Le Veve Mathieu
	* @parameters 	session = name session	(String)
			datedebut = beginning date session (String)
			datefin = ending date session (String)
			password = password session (String)
			typesession = session type (Boolean)
	* @description
		Constructeur avec 5 arguments, pour définir une session sous contraintes, avec gestion du timer
	*/
	{
		setIdSession(this.idsession);		// Pour le moment, initialiser quand BDD faite
		setNomSession(session);
		setDatedebut(datedebut);
		setDatefin(datefin);
		//setIdAuthor(author);			// faire passer le string par l'IG
		setPassword(password);
		setTypeSession(typesession);
	}
	
	/*********************** GETTERS *******************************************/
	
/**
	* idsession attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return idsession attribute value
	*/
	public int getIdSession()
	{
		return this.idsession;
	}
	
/**
	* session attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return session attribute value
	*/
	public String getNomSession()
	{
		return this.session;
	}
	
/**
	* idauthor attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return idauthor attribute value
	*/
	public int getIdAuthor()
	{
		return this.idauthor;
	}
	
/**
	* liste vector attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return liste vector <Liste> attribute value
	*/
	
	/*public Vector<Liste> getListe()
	{
		return this.liste;
	}
	*/
	
/**
	* question vector attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return question vector <Question> attribute value
	*/
	
	/*
	public Vector<Question> getQuestion()
	{
		return this.question;
	}*/

/**
	* datedebut attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return datedebut attribute value
	*/
	public String getDatedebut()
	{
		return this.datedebut;
	}
	
/**
	* datefin attribute getter
	*
	* @author LE VEVE Mathieu
	* @return return datefin attribute value
	*/
	public String getDatefin()
	{
		return this.datefin;
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
	
	public boolean getTypeSession()
	{
		return this.typesession;
	}
	/*********************** SETTERS *******************************************/
/**
	* idsession setting
	*
	* @author LE VEVE Mathieu
	* @param idsession = session with the number idsession  (Int)
	*/
	public void setIdSession(int idsession)
	{
		this.idsession = idsession;
	}
	
/**
	* session setting
	*
	* @author LE VEVE Mathieu
	* @param session = name session (String)
	*/
	public void setNomSession(String session)
	{
		this.session = session;
	}
	
/**
	* author setting
	*
	* @author LE VEVE Mathieu
	* @param author = author's session (Int)
	*/
	public void setIdAuthor(int author)
	{
		this.idauthor = author;
	}
	
/**
	* liste setting
	*
	* @author LE VEVE Mathieu
	* @param liste = Vector<Liste> attributed to the session
	*/
	/*
	public void setListe(Vector liste)
	{
		this.liste = liste;
	}
	*/
	
/**
	* question setting
	*
	* @author LE VEVE Mathieu
	* @param question = Vector<Question> attributed to the session (or to the Liste) 
	*/
	/*
	public void setQuestion(Vector question)
	{
		this.question = question;
		//https://coderanch.com/t/392512/java/Geting-Current-Time-Seconds
	}*/
	
/**
	* datedebut setting
	*
	* @author LE VEVE Mathieu
	* @param datedebut = beginning date session
	*/
	public void setDatedebut(String datedebut)
	{
		this.datedebut = datedebut;
	}
	
/**
	* datefin setting
	*
	* @author LE VEVE Mathieu
	* @param datefin = ending date session
	*/
	public void setDatefin(String datefin)
	{
		this.datefin = datefin;
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
	* typesession setting
	*
	* @author LE VEVE Mathieu
	* @param typesession = session type
	*/
	public void setTypeSession(boolean typesession)
	{
		this.typesession = typesession;
	}

	/*********************** Methods *******************************************/
/**
	* Fonction de suppression de session
	* @author Ezzahidi Meryem
	* @param name= session name (String)
	* @return retourne false en cas d'erreur, true si tout s'est bien deroulé
	*/

	public Boolean deleteSession(String name)throws SQLException 
	{
		boolean result=false;
		/*Se connecter a la BD*////		delete la session en cascade;
		ConnectionJM conn=null;		
		try {
		Connection cnx=conn.ConnectionDB();
		 
		PreparedStatement preparedStatement = null;
		String deleteSQL = "DELETE Sessions WHERE idsession  =  ?";
		preparedStatement = cnx.prepareStatement(deleteSQL);
		preparedStatement.setString(1, name);
		int rowsDeleted = preparedStatement.executeUpdate();
			if (rowsDeleted > 0) {
				result=true;
    				System.out.println("Session was deleted successfully!");
				}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
				
		return result;
			 
		///return false;
	}
	
/**
	* Fonction de suppression de session
	* @author Ezzahidi Meryem
	* @return retourne false en cas d'erreur, true si tout s'est bien deroulé
	*/
	public Boolean modifySession(Session session,String ancien_session)
	{
		boolean result=false;
		ConnectionJM conn=null;		
		try {
		Connection cnx=conn.ConnectionDB();
		 
		PreparedStatement preparedStatement = null;
		String updateSQL = "UPDATE Sessions SET datedebut=?,datefin=?,session =?,password=? WHERE session  =  ?";
		preparedStatement = cnx.prepareStatement(updateSQL);
		preparedStatement.setString(1, session.getDatedebut());
		preparedStatement.setString(2,session.getDatefin());
		preparedStatement.setBoolean(3,session.getTypeSession());
		preparedStatement.setString(4,session.getNomSession());
		preparedStatement.setString(5,session.getPassword());
		preparedStatement.setString(6,ancien_session);
		int rowsUpdate = preparedStatement.executeUpdate();
			if (rowsUpdate > 0) {
				result=true;
    				System.out.println("Session was updated successfully!");
				}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
	}

/**
	* attributes session printing
	* @name printSession()
	* @author Le Veve Mathieu
	* @param no param
	* @return (void) no return
	* @description :
		this function permits to print information about a target session
	*/
	public void printSession()
	{
		System.out.println("\nVoici les informations à propos de la session n° "+ getIdSession()+".\n");
		System.out.println("ID Session: " + getIdSession() + ".\n");
		System.out.println("Nom Session: " + getNomSession() + ".\n");
		//System.out.println("ID Auteur:" + getIdAuthor() + " .\n");
		System.out.println("Date début: " + getDatedebut() + ".\n");
		System.out.println("Date fin: " + getDatefin() + ".\n");
		System.out.println("Type: " + getTypeSession() + ".\n");
		System.out.println("Mot de passe: " + getPassword() + ".\n");
	}

/**
	* Keyboard checking
	* @name readingOfKeyboard()
	* @author Le Veve Mathieu
	* @param no param
	* @return (boolean) return true if correct, false if incorrect
	* @description :
		this function permits to check IOstream
	*/
	public static boolean readingOfKeyboard()
	{
		Scanner keyboard = new Scanner(System.in);
		String tmp = keyboard.nextLine();
		char c = tmp.charAt(0);
		try
		{
			if (c == 'y' || c == 'Y') return true;
			else if(c == 'n' || c == 'N') return false;
			else throw new IOException("Aucune saisie valide");
		}
		catch(IOException e)
		{
			System.out.println ("Erreur lors de la verification : " + e.getMessage());
		}
		return false;
	}

/**
	* encrypted password
	* @name encrypt(String password)
	* @author Le Veve Mathieu
	* @param password : chosen password by user
	* @return (String) return encrypted password
	* @description :
		this function permits to encrypt a password's session.
	*/
	public static String encrypt(String password)
	{
		String encryption= "";				//chaîne vide   	
		for (int i=0; i<password.length();i++)  	// longueur du password saisi
	    	{
	       		int c=password.charAt(i)^48; 		// modification de chaque caractère 
	       		encryption=encryption+(char)c;		// reconstitution du mot de passe	
	    	}
	   	return encryption;				// return (String) password
	}
/**
	* Testing timer
	* @name timer()
	* @author Le Veve Mathieu
	* @param no param
	* @return (void) no return
	* @description :
		this function permits to test a timer with a printing calendar as screening result
	*/
	public void timer()
	{
		long temps = 2000;              // délai avant de répéter la tache : 2000 = 2  seconde
        	long startTime = 5000;          // délai avant la mise en route (0 demarre immediatement)
        	Timer timer = new Timer();      // création du timer
        	TimerTask tache = new TimerTask() 
        	{    				// création et spécification de la tache à effectuer
            		public void run() 
            		{	
				Calendar calendar = Calendar.getInstance();
				System.out.println("Nous sommes le " + calendar.get(Calendar.DAY_OF_MONTH) +"/"+ calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR));
				System.out.println("Seconds in current minute = " + calendar.get(Calendar.SECOND));
				this.cancel();

              		}
   		};
        	timer.scheduleAtFixedRate(tache,startTime,temps);  // ici on lance la mecanique
      	}

/**
	* Writing information about session to file
	* @name writeToFile(Session B)
	* @author Le Veve Mathieu
	* @param Session B = Target session to write 
	* @return (void) no return
	* @description
		This function writes information B-session to the new file (xxxx."txt").
	*/
    	private static void writeToFile(Session B)
    	{
    		File fichier = new File("bdd.txt");
		String[] data ={B.getNomSession(), B.getDatedebut(), B.getDatefin(), B.getPassword()};
		try
		{
			FileWriter writer = new FileWriter(fichier);
			for (String donnees : data)
    			{
        			writer.write (String.valueOf (donnees));
       				writer.write ("\r\n");
   			}
			writer.close();
		}
		catch (IOException e)
		{
    			System.out.println ("Erreur lors de la lecture : " + e.getMessage());
		}
    	}

	/********** Main Test to create session *********
/** 
		@author Le veve Mathieu
	*/
	public static void main(String[] args)
	{
		System.out.println("Voulez vous créer une session? Please y/n");
		if (readingOfKeyboard() == true)
		{
			Session A = new Session();
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Veuillez saisir un nom de session");
			String name = keyboard.nextLine();
			System.out.println("Voulez vous une session avec fermeture (présence de dates) ? (y/n)");
			if (readingOfKeyboard() == true)
			{
				System.out.println("Veuillez saisir une date de début de session (format xx/xx/xxxx)");
				String datedebut = keyboard.nextLine();
				System.out.println("Veuillez saisir une date de fin de session (format xx/xx/xxxx)");
				String datefin = keyboard.nextLine();
				System.out.println("Veuillez saisir un mot de passe");
				String password = encrypt(keyboard.nextLine());
				Session B = new Session(name, datedebut, datefin, password, true);
				System.out.println("Pour voir les informations de la session, saisissez le mot de passe.");
				password = encrypt(keyboard.nextLine());				
				if (password.equals(B.getPassword())) B.printSession();
				// Il faut ajouter une liste à une session 
				// Fonction qui va créer un vector <List> et l'initialiser 
				writeToFile(B);
 
        		}
 
			else
			{
				System.out.println("Veuillez saisir un mot de passe");
				String password = encrypt(keyboard.nextLine());
				Session B = new Session(name, password, false);
				System.out.println("Pour voir les informations de la session, saisissez le mot de passe.");
				password = encrypt(keyboard.nextLine());				
				if (password.equals(B.getPassword())) B.printSession();
				writeToFile(B);
			}
		}

		else System.exit(0);
	}
	/********** Main Test to Delete session*********
	* 
		@author Ezzahidi Meryem
	
	public static void main(String[] args)
	{
		Session s=new Session()
		System.out.println("Voulez-vous supprimer une session?(y/n)");
			if (readingOfKeyboard() == true)
			{
				System.out.println("Veuillez saisir le nom de la session?");	
				Scanner keyboard = new Scanner(System.in);			
				String name = keyboard.nextLine();				
				boolean result=s.deleteSession(name);
				if(result)
					System.out.println("La session"+name+"est supprimée");
				else
					System.out.println("erreur de suppression");
			}
			else System.exit(0);
	}
	
	************* Main Test to Modify session*****************
	* 
		@author Ezzahidi Meryem
	
	public static void main(String[] args)
	{
		System.out.println("Voulez-vous modifier une session?(y/n)");
		if (readingOfKeyboard() == true)
		{
			System.out.println("Veuillez saisir le nom de la session a modifié?");	
			Scanner keyboard = new Scanner(System.in);			
			String ancien_name = keyboard.nextLine();
			System.out.println("Veuillez saisir le  nouveau nom de la session ");
			String nv_name = keyboard.nextLine();
			System.out.println("Veuillez saisir une nouvelle date de début de session (format xx/xx/xxxx)");
			String nv_datedebut = keyboard.nextLine();
			System.out.println("Veuillez saisir une nouvelle date de fin de session (format xx/xx/xxxx)");
			String nv_datefin = keyboard.nextLine();
			System.out.println("Veuillez saisir le nouveau un mot de passe");
			String nv_password = keyboard.nextLine();				
			Session b = new Session(nv_name, nv_datedebut, nv_datefin, nv_password, true);
			boolean result=s.modifySession(b,ancien_name);
			if(result)
				System.out.println("La session"+ancien_name+"est modifiée");
			else
				System.out.println("erreur de modification");
				
		}
		else System.exit(0);
	
	}*/		
