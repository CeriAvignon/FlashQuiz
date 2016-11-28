import ConnexionJM.java;
import Liste.java;
import java.sql.*;
import java.util.Vector;


public class ListHandler {
	
	public void sendList(Liste list)
	{
		Question question;
		int idQuestion;
		Connection cnxt=connecterDB();
		
		/*Récupération de la liste de question.*/
		
		int idListe = list.getIdListe();
		int idAuthor = list.getIdAuthor();
		String nomListe = list.getNomListe();
		Vector<Question>listeQuestion = list.getListeQuestion();
		
		/* Création de la requête */
		
		String query="";
		PreparedStatement prepare = cnx.prepareStatement();
		Statement statement = connexion.createStatement();
		ResultSet res;
		
		/* Si la liste n'existe pas */ 
		
		if(idListe == -1)
		{
			
			/* Préparation de la requête */
			query = "SELECT FROM Liste_Metadata WHERE Titre_Liste = ?;";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,idListe); 
			res = prepare.executeQuery();
			boolean row = res.first();
			if(row)idListe = res.getInt("ID_Liste");
			prepare.close();
			res.close();
			
		/*  */
			
			if(!row)
			{
				query="INSERT INTO Liste_Metadata(ID_Utilisateur,Titre_Liste) VALUES(?,?);";
				prepare = cnx.prepareStatement(query);
				prepare.setObject(1,idAuthor);
				prepare.setObject(2,nomListe);
				prepare.executeUpdate();
				prepare.close();
				res.close();
				
				res=statement.executeQuery("SELECT currval(pg_get_serial_sequence('Liste_Metadata','ID_Liste'));");
				idListe = res.getInt("ID_Liste");
				statement.close();
				res.close();
			}
			
			query="INSERT INTO Liste_Contenu(ID_Liste, ID_Question) VALUES(?,?);";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,idListe);
			for(int i = 0; i< listeQuestion.size(), i++)
			{
				question = listeQuestion[i];
				sendQuestion(question);
				idQuestion = question.getIdQuestion();
				prepare.setObject(2,idQuestion);
				prepare.executeUpdate();
				prepare.close();
				res.close();
			}
	
		}
		
		else
		{
			
		}
	}
