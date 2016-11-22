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
		idListe = list.getIdListe();									// Récupère l'id de la liste
		idAuthor = list.getIdAuthor();									// Récupère l'id du créateur de la liste
		nomListe = list.getNomListe();									// Récupère le nom de la liste
		listeQuestion = list.getListeQuestion();							// Récupère les questions dans le vecteur listeQuestion de l'objet liste
		int statut;
		Statement statement = connexion.createStatement();						// Création d'une requête
		
		if(idListe == -1)										// S'il s'agit d'une création de liste
		{
			ResultSet res = statement.executeQuery("SELECT FROM Liste_Metadata "
								+ "WHERE Titre_Liste = idListe;");		// Vérifie si le titre de liste est déjà présent dans la BDD
			if(res == null)
			{
		
				statut = statement.executeUpdate("INSERT INTO Liste_Metadata(ID_Utilisateur,"
								+ " Titre_Liste) VALUES(idAuthor, nomListe);");	// Insert l'id utilisateur et le titre de la liste dans la BDD
		
			}
			
			else
			{
				// Retourner une erreur de type "titre déjà existant"
			}
		}
		
		else												// S'il s'agit d'une modification de liste
		{
			
		}
		
		
	}
	
}
