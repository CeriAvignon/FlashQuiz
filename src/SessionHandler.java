import java.io.*;
import java.util.*;
import ConnexionJM.java;

public class SessionHandler {

private int idSession;
private int idListe;
private String dateOpen;
private String dateClose;
private boolean typeSession;
private String nameSession;

public void sendSession(Session s)
	{
	idSession = s.getIdSession();
	idListe = s.getIdListe();
	dateOpen = s.getDateOpen();
	dateClose = s.getDateClose();
	typeSession = s.getTypeSession();
	nameSession = s.getNameSession();	
	
	int ret;	
	Statement statement = connexion.createStatement();
	ResultSet res=null;	
		if(idSession == -1) // si session n'existe pas
	{
		res = statement.executeQuery( "SELECT * FROM Sessions WHERE Titre_Session=nameSession;");
		if(res == null)
		{
			ret.statement.executeUpdate("INSERT INTO Sessions(ID_Session, ID_Liste, Date_Ouverture, Date_Fermeture, Type_Session, Titre_Session) VALUES(idSession, idListe, dateOpen, dateClose, typeSession, nameSession);");
		}
			
		else
		{
			 System.out.println("ERREUR! Session existe deja!");
		}
	}
	else //si session existe
	{
		res = statement.executeQuery( "SELECT * FROM Sessions WHERE Titre_Session=nameSession;");
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
}
