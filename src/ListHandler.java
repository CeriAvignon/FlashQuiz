import ConnexionJM.java;
import Liste.java;
import java.sql.*;
import java.util.Vector;


public class ListHandler {
	private String nomListe;
	private int idAuthor;
	private int idListe;
	protected Vector<Question>listeQuestion;
	
	public void sendList(Liste list)
	{
		Connection connect=connecterDB();
		idListe = list.getIdListe();															// Récupère l'id de la liste
		idAuthor = list.getIdAuthor();															// Récupère l'id du créateur de la liste
		nomListe = list.getNomListe();															// Récupère le nom de la liste
		listeQuestion = list.getListeQuestion();												// Récupère les questions dans le vecteur listeQuestion de l'objet liste
		int statut;
		
		String query="";
		PreparedStatement prepare = connect.prepareStatement();
		Statement statement = connexion.createStatement();										// Création d'une requête
		ResultSet res;
		
		if(idListe == -1)																		// S'il s'agit d'une création de liste
		{
			query = "SELECT FROM Liste_Metadata WHERE Titre_Liste = ?;";						// Vérifie si le titre de liste est déjà présent dans la BDD
			prepare = connect.prepareStatement(query);
			prepare.setObject(1,idListe); 
			res = prepare.executeQuery();
			boolean row = res.first();
			if(row)idListe = res.getInt("ID_Liste");
			prepare.close();
			res.close();
			
			if(!row)
			{
				
			}
	
}
