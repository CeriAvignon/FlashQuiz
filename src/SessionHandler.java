import java.io.*;
import java.util.*;
import ConnexionJM.java;

public class SessionHandler {

private int idsession;
private int idliste;
private String datedebut;
private String datefin;
private boolean typesession;
private String namesession;
private String password;
protected Vector<Liste>listeliste;

public void sendSession(Session s)
	{
	idsession = s.getIdSession();						//recupere l'id de la session
	datedebut = s.getDateDebut();						//recupere la date de debut
	datefin = s.getDateFin();						//recupere la date de debut
	typesession = s.getTypeSession();					//recupere le type de session
	namesession = s.getNomSession();					//recupere le nom de session
	password = s.getPassword();						//recupere le mot de passe
	listeliste = s.getListeListe(); 					//recupere la liste des listes
	
	String query="";
	Statement statement = cnx.createStatement();
	ResultSet res=null;	
	PreparedStatement prepare = cnx.prepareStatement();	
	try
	{
		if(idSession == -1) // si session existe pas
		{
			//on insere les donnees dans la BDD
			query = "INSERT INTO Sessions_Metadata(Date_Ouverture, Date_Fermeture, Type_Session, Titre_Session, MotDePasse) VALUES(?, ?, ?, ?, ?);";
					prepare =  cnx.prepareStatement(query);
					prepare.setObject(1,datedebut);
					prepare.setObject(2,datefin);
					prepare.setObject(3,typesession);
					prepare.setObject(4,namesession);
					prepare.setObject(5,password);
					prepare.executeUpdate();
					prepare.close();
			//on recupere l'id de la session
			res = statement.executeQuery("SELECT currval(pg_get_serial_sequence('Sessions','ID_Session')) as id;");
			s.setIdSession(res.getInt(1));
			for (List l:listeliste) 
			{
				//envoye la liste
				sendListe(l);
				//si la liste s'est bien enregistrée
				if (l.getIdListe() != -1)  
				{
					// Ajouter dans Session_Contenu 
					query = "INSERT INTO Session_Contenu (ID_Session,ID_Liste) values (?,?));";
					prepare =  cnx.prepareStatement(query);
					prepare.setObject(1,s.getIdSession());
					prepare.setObject(2,s.getIdListe());
					prepare.executeUpdate();
					prepare.close();
					res.close();
				}
				else
				{
					System.out.println("ERREUR!");
				}
			}
		}
		else //si session existe
			
			
			
	{
		res = statement.executeQuery( "SELECT * FROM Sessions WHERE ID_Session=idsession;");
	}
		if(res == null)
		{
			System.out.println("ERREUR! Session n'existe pas!");
		}
		else
		{
		//on fait la mise a jour de la BDD
		ret = statement.executeUpdate("UPDATE Sessions SET ;");
			// Supprimer tout dans Session_Contenu WHERE ID_Session = $idsession
			for (List l:listeliste) {
				sendListe(l);
				if (l.getIDLIste != -1)  {
					// Ajouter dans Session_Contenu INSERT (ID_Session,ID_Liste) values ($idsession,$
				}
			}
		}
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		return null;
	}
	}
}
