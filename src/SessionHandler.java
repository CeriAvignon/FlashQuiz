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
	datedebut = s.getDateDebut();						// recupere la date de debut
	datefin = s.getDateFin();						// recupere la date de debut
	typesession = s.getTypeSession();					//recupere le type de session
	namesession = s.getNomSession();					// recupere le nom de session
	password = s.getPassword();						//recupere le mot de passe
	listeliste = list.getListeListe(); 					//recupere la liste des listes
	
	int ret;								//cree une requette
	Statement statement = connexion.createStatement();
	ResultSet res=null;	
	try{
		if(idSession == -1) // si s existe pas
	{
			//on insere les donnees dans la BDD
			ret.statement.executeUpdate("INSERT INTO Sessions(ID_Session, Date_Ouverture, Date_Fermeture, Type_Session, Titre_Session) VALUES($idsession, $datedebut, $datefin, $typesession, $namesession);");
	}
	else //si session existe
	{
		res = statement.executeQuery( "SELECT * FROM Sessions WHERE ID_Session=$idsession;");
	}
		if(res == null)
		{
			System.out.println("ERREUR! Session n'existe pas!");
		}
		else
		{
		//on fait la mise a jour de la BDD
		ret.statement.executeUpdate("UPDATE Sessions SET ;");
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
