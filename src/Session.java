//package session;			// Package session liée a EL --> Package \author :@LE VEVE Mathieu
import java.util.Scanner;		// Saisie clavier: Scanner keyboard = new Scanner (...)
import java.util.Vector;		// Création <vector> question / <vector> liste
import java.sql.Connection;		// Connection connection = new Connection (...)
import java.sql.DriverManager;		// Accès pour la BDD
import java.io.File;			// pour la simulation de bdd --> Phases de tests par lecture/ écriture
import javax.swing.*;
import java.util.Calendar;		//Calendrier
import java.awt.event.*;
import java.util.Timer;			// Timer
import java.util.TimerTask;		// Effectuer tâche (evenement) pour timer
//import connexionjm.ConnexionJM;		// Package liée à la BDD --> Package \author :@HUOT AMAURY
/*! 
*	\file Session.java
*	\brief Fichier java Session
*	\author {Le Veve Mathieu}
*	\date xx/10/2016
*	\date 22/11/2016
*	\date 24/11/2016
*
*	\class <Session> Session.java 	Session
*	\brief	Fichier en java qui crée une session, pour le moment avec ses getters/ setters pour créer une session
*	pour le moment sans intéraction avec la BDD. 
*/




public class Session
{
  	private static int idsession;
	/*variable <int> globale privée:	implémentée via une requête SQL vers l'id de la session
						dépend fortement du groupe BDD
	*/
	private String session;
	/* Variable <String> privée:		implémentée via une chaîne de caractères saisie par l'utilisateur*/
	private int idauthor;
	/* Variable <Int> privée:		implémentée via une requête SQL vers l'id de l'auteur*/
	//private Vector<Liste> liste;
	/* Variable <Vector> privée: 		implémentée durant une session, ou part la création de session.
						dépend fortement du groupe TVS.
	*/				
	//private Vector<Question> question;
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
	private String password;
	private boolean typesession;
	//private int nbrquestion;
	
	public Session ()
	{
		//if (l'utilisateur a cliqué sur le bouton de creation)
		//{	
			this.idsession = 0;		// Pour le moment, initialiser quand BDD faite
			this.session = "no name";
			this.idauthor= 0;
			this.datedebut = "no beginning date";
			//this.setIdAuthor(author);			// faire passer le string par l'IG
			this.datefin = "no ending date";
			this.password = "no password";
			this.typesession = false;
		//	this.liste=
		//}
		//	this.question=
		
		//else 
	
	}

		public Session (String session, String password, boolean typesession)
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
	
	/*public Vector<Liste> getListe()
	{
		return this.liste;
	}
	
	public Vector<Question> getQuestion()
	{
		return this.question;
	}*/

	public String getDatedebut()
	{
		return this.datedebut;
	}
	
	public String getDatefin()
	{
		return this.datefin;
	}
	
	public String getPassword()
	{
		return this.password;
	}

	public boolean getTypeSession()
	{
		return this.typesession;
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
	
	/*public void setListe(Vector liste)
	{
		this.liste = liste;
	}
	
	public void setQuestion(Vector question)
	{
		this.question = question;https://coderanch.com/t/392512/java/Geting-Current-Time-Seconds
	}*/
	
	public void setDatedebut(String datedebut)
	{
		this.datedebut = datedebut;
	}
	
	public void setDatefin(String datefin)
	{
		this.datefin = datefin;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	

	public void setTypeSession(boolean typesession)
	{
		this.typesession = typesession;
	}

	public Boolean deleteSession(String name)throws SQLException 
	{
		boolean result=false;
		/*Se connecter a la BD*////		delete la session en cascade;
		ConnectionJM conn=null;		
		try {
		Connection cnx=conn.ConnectionDB();
		 
		PreparedStatement preparedStatement = null;
		String deleteSQL = "DELETE Sessions WHERE ID_Session  =  ?";
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
	
	public boolean modifySession(Session session,String ancien_session)
	{
		boolean result=false;
		ConnectionJM conn=null;		
		try {
		Connection cnx=conn.ConnectionDB();
		 
		PreparedStatement preparedStatement = null;
		String updateSQL = "UPDATE Sessions SET Date_Ouverture=?,Date_Fermeture=?,Titre_Session =?,MotDePasse=? WHERE Titre_Session  =  ?";
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

	public static boolean readingOfKeyboard()
	{
		Scanner keyboard = new Scanner(System.in);
		String tmp = keyboard.nextLine();
		char c = tmp.charAt(0);
		if (c == 'y' || c == 'Y') return true;
		else return false;
	}


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
				String password = keyboard.nextLine();
				Session B = new Session(name, datedebut, datefin, password, true);
				System.out.println("Pour voir les informations de la session, saisissez le mot de passe.");
				password = keyboard.nextLine();
				if (password.equals(B.getPassword())) B.printSession();
				long temps = 2000;                      // délai avant de répéter la tache : 2000 = 2  seconde
        		long startTime = 5000;                 	// délai avant la mise en route (0 demarre immediatement)
        		Timer timer = new Timer();             	// création du timer
        		TimerTask tache = new TimerTask() {    	// création et spécification de la tache à effectuer

               		public void run() {
					Calendar calendar = Calendar.getInstance();
					System.out.println("Nous sommes le " + calendar.get(Calendar.DAY_OF_MONTH) +"/"+ calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR));
					System.out.println("Seconds in current minute = " + calendar.get(Calendar.SECOND));


                	}
       			};
        		timer.scheduleAtFixedRate(tache,startTime,temps);  // ici on lance la mecanique

 
        	}
 
			else
			{
				System.out.println("Veuillez saisir un mot de passe");
				String password = keyboard.nextLine();
				Session B = new Session(name, password, false);
				System.out.println("Pour voir les informations de la session, saisissez le mot de passe.");
				password = keyboard.nextLine();
				if (password.equals(B.getPassword())) B.printSession();
			}
		}

		else System.exit(0);
		/**********Suppression session*********/
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
		/*************Modifier session*****************/
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
		
	}

}


