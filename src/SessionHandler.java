// package aAjouter;

import java.io.*;		// inclure toutes les classes defini dans java.io package
import java.util.*;		// inclure toutes les utils defini dans defini dans java.util package
import java.sql.*;		// inclure toutes les utils defini dans defini dans java.sql package
import Session.java;		
import Liste.java;		
import Version.java;		// inclure Version.java pour pouvoir se connecter a la bdd

/**
 * <b>La classe SessionHandler.</b>
 * <p>
 * 
 * @author Alexandra MOSHINA 
 *
 */
public class SessionHandler {
/**
* L'ID de la session. Cet ID n'est pas modifiable.
* <p>
*
*@see SessionHandler#sendSession(Session)
*
*/	
private int idsession;
	
/**
* La date du debut de la session.
* <p>
*
*@see SessionHandler#sendSession(Session)
*
*/	
private String datestart;
	
/**
* La date du fin de la session.
* <p>
*
*@see SessionHandler#sendSession(Session)
*
*/
private String dateend;
	
/**
* Le type de la session.
* <p>
*
*@see SessionHandler#sendSession(Session)
*
*/
private boolean typesession;
	
/**
* Le titre de la session.
* <p>
*
*@see SessionHandler#sendSession(Session)
*
*/
private String namesession;
	
/**
* Le mot de passe.
* <p>
*
*@see SessionHandler#sendSession(Session)
*
*/
private String password;
	
/**
* La liste de listes.
* <p>
*
*@see SessionHandler#sendSession(Session)
*
*/
protected Vector<Liste> listeliste;	
	
/**
* <b>Envoie une session vers le serveur pour l'enregistrer.</b>
* <p>
*
* @author Alexandra MOSHINA 
*
* @param s
*	La session à écrire/modifier dans la BDD.
*
* @see idsession
* @see datestart
* @see dateend
* @see typesession
* @see namesession
* @see password
* @see listeliste
*
*/
public void sendSession(Session s) throws SQLException
	{
	
	try {
	Connection cnx=connecterDB(); 						//connection à la BDD 
	
	idsession = s.getIdSession();						//recupere l'id de la session
	datestart = s.getDateDebut();						//recupere la date de debut
	dateend = s.getDateFin();							//recupere la date de debut
	typesession = s.getTypeSession();					//recupere le type de session
	namesession = s.getNomSession();					//recupere le nom de session
	password = s.getPassword();							//recupere le mot de passe
	listeliste = s.getListeListe(); 					//recupere la liste des listes
	
	try {
	String query="";
	Statement statement = cnx.createStatement();
	ResultSet res=null;	
	
		if(idsession == -1) // si session existe pas
		{
			//on insere les donnees dans la BDD
			query = "INSERT INTO Session_Metadata(Opening_Date, Closing_Date, Type, Title, Password) VALUES(?, ?, ?, ?, ?);";
					PreparedStatement prepare =  cnx.prepareStatement(query);
					prepare.setObject(1,datestart);
					prepare.setObject(2,dateend);
					prepare.setObject(3,typesession);
					prepare.setObject(4,namesession);
					prepare.setObject(5,password);
					prepare.executeUpdate();
					prepare.close();
			//on recupere l'id de la session
			res = statement.executeQuery("SELECT currval(pg_get_serial_sequence('Session_Metadata','ID_Session')) as id;");
			s.setIdSession(res.getInt(1));
			
			
			for (Vector l:listeliste) 
			{
				//envoye la liste
				sendListe(l);
				//si la liste s'est bien enregistrée
				if (l.getIdListe() != -1)  
				{
					// Ajouter dans Session_Content
					query = "INSERT INTO Session_Content (ID_Session,ID_Liste) values (?,?));";
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
			query = "UPDATE Session_Metadata SET (Opening_Date=?, Closing_Date=?, Type=?, Title=?, Password=?) WHERE ID_Session=idsession;";
			PreparedStatement prepare = cnx.prepareStatement(query);
			prepare.setObject(1,datestart);
			prepare.setObject(2,dateend);
			prepare.setObject(3,typesession);
			prepare.setObject(4,namesession);
			prepare.setObject(5,password);
			res = statement.executeQuery(query);
			prepare.close();
			res.close();
			
			//supprimer continu Session_Content		
			//suppression 
			res = statement.executeQuery("DELETE FROM Session_Content WHERE ID_Session=idsession;");
			
			res.close();			

			for (Vector l:listeliste) 
			{
				//envoye la liste
				sendListe(l);
				//si la liste s'est bien enregistrée

				if (l.getIdListe() != -1)  
				{
					// Ajouter dans Session_Content
					query = "INSERT INTO Session_Content (ID_Session,ID_Liste) values (?,?));";
					prepare = cnx.prepareStatement(query);
					prepare.setObject(1,idsession);
					prepare.setObject(2,l.getIdListe());
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
		
    } catch (SQLException e) 
	{
    	e.printStackTrace();    
    }		
	
	}
	finally 
	{
		if (connecterDB != null) 
		{
			connecterDB.close();
		}
    }
	
	}
}
