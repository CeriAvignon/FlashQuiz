//importer connection bdd
import java.sql.*;
//import Question.java


/**
	*  @author Benjamin Rock
	*  @version 1.4
	*  
*
	*  Cette classe va servir &agrave; coder toutes les fonctions permettant un 
	*  acc&egrave;s aux questions 
	*  La fonction sendQuestion(Question question) permet de cr&eacute;er une 
	*  questions ou de modifier une question existante. 
	**/

public class QuestionHandler {
	
	/**
	 * 
	 * @since 1.4
	 * @param list
	 * 				Une question.
	 * 
	 **/ 
	
	public void sendQuestion(Question question)
	{
		Connection cnx=connecterDB();
		/** 
		 * 
		 * R&eacute;cup&eacute;ration de la question 
		 * 
		 **/
		int questionId = question.getQuestionId();
		String content = question.getTitle();
		int questionType = question.getQuestionType();
		String mediafile = question.getMediafile();
		int mediaType = question.getmediaType();
		
		/** 
		 * 
		 * Cr&eacute;ation d'une requ&ecircte vide qui sera affect&eacute;e selon 
		 * les besoins de la fonction. 
		 * 
		 * */
		
		String query="";
		PreparedStatement prepare = cnx.prepareStatement();
		Statement statement = cnx.createStatement();
		ResultSet res;
		int media_id;
		
		/**
		 *  Si la question n'existe pas
		 */
		if(questionId == -1) //La question n'existe pas
		{
			/**
			 * Requete qui verifie l'existence du media
			 */
			
			query="SELECT * FROM Media WHERE Contenu_media=?;";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,mediafile); 
			res = prepare.executeQuery();
			boolean ret=res.first();
			if(ret)id_media = res.getInt("ID_Media");
			prepare.close();
			res.close();
			
			if(!ret)//Le media n'existe pas
			{
				/**
				 * Ajout du media si il n'existe pas
				 */
				
				query="INSERT INTO Media(TYPE,Contenu_media) VALUES(?,?);";
				prepare = cnx.prepareStatement(query);
				prepare.setObject(1,typeMedia);
				prepare.setObject(2,mediafile);
				prepare.executeUpdate();
				prepare.close();
				res.close();
				/**
				 * **recup de l'id du media 
				 * */
				res=statement.executeQuery("SELECT currval(pg_get_serial_sequence('Media','ID_Media'));");
				media_id = res.getInt("ID_Media");
				statement.close();
				res.close();
			
			}
			/**
			 * insertion de la question
			 * */
			query="INSERT INTO Questions(TYPE_Question,Contenu_Question,ID_Media) VALUES(?,?,?);";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,contenu);
			prepare.setObject(2,typeQuestion);
			prepare.setObject(3,id_media);
			prepare.executeUpdate();
			prepare.close();
			res.close();
			/**
			 * recup de l'id de la question
			 * */
			res=statement.executeQuery("SELECT currval(pg_get_serial_sequence('Questions','ID_Question'));");
			int question_id = res.getInt("ID_Question");
			statement.close();
			res.close();
			question.setIdQuestion(question_id);
		
		}
		/**
		 * La question existe déjà
		 */
		else 
		{
			/**
			 * Mise à jour de la question
			 * */
			query="UPDATE Questions SET TYPE_Question=?,Contenu_Question=?,ID_Media=? WHERE ID_Question=? ;";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,contenu);
			prepare.setObject(2,typeQuestion);
			prepare.setObject(3,id_media);
			prepare.setObject(4,idQuestion);
			prepare.executeUpdate();
			prepare.close();
			res.close();
		}
	}

	public Question getQuestion(int id_question)
	{
		Connection cnx=connecterDB();
		
		try{
			PreparedStatement prepare = cnx.prepareStatement();
			Statement statement = cnx.createStatement();
			ResultSet res;
			
			query="SELECT * FROM Question WHERE ID_Question=?;";
			
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_question);
			
			res = prepare.executeQuery();
			
			Question question = new Question(res.getInt("ID_Question"),res.getInt("Type"),res.getInt("Content"),res.getInt("ID_Media"))
			
			prepare.close();
			res.close();
			
			return question;
		}
		catch(exception e)
		{
			
		}
	}
	
};
