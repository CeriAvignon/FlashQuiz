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

public void sendSession(Session s)
	{
	idsession = s.getIdSession();
	idliste = s.getIdListe();
	datedebut = s.getDateDebut();
	datefin = s.getDateFin();
	typesession = s.getTypeSession();
	namesession = s.getNomSession();	
	
	int ret;	
	Statement statement = connexion.createStatement();
	ResultSet res=null;	
	try{
		if(idSession == -1) // si session n'existe pas
	{
		res = statement.executeQuery( "SELECT * FROM Sessions WHERE Titre_Session=nomSession;");
		if(res == null)
		{
			ret.statement.executeUpdate("INSERT INTO Sessions(ID_Session, ID_Liste, Date_Ouverture, Date_Fermeture, Type_Session, Titre_Session) VALUES(idsession, idliste, datedebut, datefin, typesession, namesession);");
		}
			
		else
		{
			 System.out.println("ERREUR! Session existe deja!");
		}
	}
	else //si session existe
	{
		res = statement.executeQuery( "SELECT * FROM Sessions WHERE Titre_Session=nomsession;");
	}
		if(res == null)
		{
			System.out.println("ERREUR! Session n'existe pas!");
		}
		else
		{
		//update
		}
	} 
	catch (Exception e) 
	{
			        e.printStackTrace();
				return null;
	}
	}
}
