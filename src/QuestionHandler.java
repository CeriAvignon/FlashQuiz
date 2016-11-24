package ques;
import ConnexionJM.java;
import java.sql.*;

public class QuestionHandler {
	
	public void sendQuestion(Question question)
	{
		/****************Récupération de la question ***********************/
		int idQuestion = question.getIdQuestion();
		String contenu = question.getIntitule();
		int typeQuestion = question.getTypeQuestion();
		String mediafile = question.getMediafile();
		int typeMedia = question.getTypeMedia();
		/*******************************************************************/
		
		String query="";
		//PreparedStatement prepare = conn.prepareStatement(query);
		//Statement statement = connexion.createStatement();
		//int retour;
		PreparedStatement prepare;
		Statement statement = cnx.createStatement();
		ResultSet res;
		int id_media;
		if(idQuestion == -1) //La question n'existe pas
		{
			/*************************Requete qui verifie l'existence du media*********************/
			query="SELECT * FROM Media WHERE Contenu_media=?;";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(2,mediafile); 
			res = prepare.executeQuery();
			boolean retour=res.first();
			prepare.close();
			res.close();
			/*************************************************************************************/
			if(!retour)//Le media n'existe pas
			{
				
			/**********************Ajout du media si il n'existe pas******************************/
				query="INSERT INTO Media(TYPE,Contenu_media) VALUES(?,?);";
				prepare.setObject(1,typeMedia);
				prepare.setObject(2,mediafile);
				prepare.executeUpdate();
				prepare.close();
				res.close();
				res.statement.executeQuery("SELECT curval(pg_get_serial_sequence('Media','ID_Media'));");
				id_media = res.getInt("ID_Media");
			/*************************************************************************************/
			}
			
			res = statement.executeQuery( "SELECT ID_Media FROM Media;" );
			res=resultat.next();
			retour = statement.executeUpdate("INSERT INTO Questions(TYPE_Question,Contenu_Question,ID_Media) VALUES(contenu,typeQuestion,idMedia)");
		}
		else //La question existe déjà
		{
			//faire un update
		}
		
		//faire exception pour retour d'id
	}
};
