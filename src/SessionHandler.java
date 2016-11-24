import java.io.*;
import java.util.*;
import java.sql.*;
package ques;
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
	Connection cnx=connecterDB(); //connection ?
	
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
			res = statement.executeQuery("SELECT currval(pg_get_serial_sequence('Sessions_Metadata','ID_Session')) as id;");
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
		//on fait la mise a jour de la BDD
			query = "UPDATE Sessions SET (Date_Ouverture=?, Date_Fermeture=?, Type_Session=?, Titre_Session=?, MotDePasse=?) WHERE ID_Session=?;"
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,s.datedebut());
			prepare.setObject(2,s.datefin());
			prepare.setObject(3,typesession);
			prepare.setObject(4,namesession);
			prepare.setObject(5,password);
			res = statement.executeQuery(query);
			prepare.close();
			res.close();
			
			//supprimer continu Sesseion_contenu		
			//suppression 
			res = statement.executeQuery("DELETE FROM Session_Contenu WHERE ID_Session=idsession ;");
			
			res.close();			

			for (List l:listeliste) 
			{
				//envoye la liste
				sendListe(l);
				//si la liste s'est bien enregistrée

				if (l.getIdListe() != -1)  
				{
					// Ajouter dans Session_Contenu 
					query = "INSERT INTO Session_Contenu (ID_Session,ID_Liste) values (?,?));";
					prepare = cnx.prepareStatement(query);
					prepare.setObject(1,idsession);
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



		}
 
	catch (Exception e) 
	{
		e.printStackTrace();
		return null;
	}
	}
}
