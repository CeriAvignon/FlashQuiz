package projetProg;
/*import ConnexionJM.java;*/
/*import Liste.java;*/
import java.sql.*;
import java.util.Vector;


public class listHandle {
	private String nomListe;
	private int idAuthor;
	private int idListe;
	protected Vector<Question>listeQuestion;
	
	public void sendList(Liste list)
	{
		idListe = list.getIdListe();								//
		idAuthor = list.getIdAuthor();
		nomListe = list.getNomListe();
		listeQuestion = list.getListeQuestion();
		int statut;
		Statement statement = connexion.createStatement();
		
		if(idListe == -1)
		{
			ResultSet res = statement.executeQuery("SELECT FROM Liste_Metadata WHERE Titre_Liste = idListe;");
			if(res == null)
			{
		
				statut = statement.executeUpdate("INSERT INTO Liste_Metadata(ID_Utilisateur, Titre_Liste) VALUES(idAuthor, nomListe);");
		
			}
			
			else
			{
				// Retourner une erreur de type "titre déjà existant"
			}
		}
		
		else
		{
			
		}
		
		
	}
	
}
