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
	*  La fonction getQuestion(int id_question) permet de r&eacute;cup&eacute;rer un objet question dans la base de donn&eacute;es
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
		 * Cr&eacute;ation d'une requ&ecirc;te vide qui sera affect&eacute;e selon 
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

	public Question getQuestion(int id_question) throws SQLException
	{
		Connection cnx=connecterDB();
		
		try{
			PreparedStatement prepare = cnx.prepareStatement();
			Statement statement = cnx.createStatement();
			ResultSet res;
			
			/** 
			 *	Requete qui r&eacute;cup&egrave;re toute les infos n&eacute;c&eacute;ssaire &agrave; un objet question 
			 * 
			 */
			
			query="SELECT * FROM Question Join Media Using(ID_Media) Join Answer Using(ID_Answer) WHERE ID_Question=?;";
			
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_question);
			
			res = prepare.executeQuery();
			
			/**
			 * Formatage du retour de la requete 
			 */
			
			Media media = new Media(res.getInt("ID_Media"),res.getInt("Media.Type"),res.getInt("Media.Content"));
			Answer answer = new Answer(res.getInt("ID_Answer"),res.getInt("Answer.Content"),res.getBoolean(Correct));
			Question question = new Question(res.getInt("ID_Question"),res.getInt("Question.Type"),res.getString("Question.Content"),media,answer);
			
			prepare.close();
			res.close();
			
			return question;
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void deleteQuestion (int idQuestion)
	{
	
	Connection cnx=connecterDB();
	
	/** 
	 * 
	 * R&eacute;cup&eacute;ration de la liste de question avec la fonction 
	 * getIdList().
	 * 
	 **/

	try{
		PreparedStatement prepare = cnx.prepareStatement();
		Statement statement = cnx.createStatement();
		ResultSet res;
		
		string query="SELECT * FROM Question WHERE Contenu_media=?;";
		prepare = cnx.prepareStatement(query);
		prepare.setObject(1,idQuestion); 
		res = prepare.executeQuery();
		int id_media = res.getInt("ID_Media");
		prepare.close();
		res.close();
		
		query="DELETE * FROM Media WHERE idQuestion=?;";
		
		prepare = cnx.prepareStatement(query);
		prepare.setObject(1,id_media);
		
		res = prepare.executeQuery();
		
		
		prepare.close();
		res.close();
		
		query="DELETE * FROM Question WHERE idQuestion=?;";
		prepare = cnx.prepareStatement(query);
		prepare.setObject(1,idQuestion);
		
		res = prepare.executeQuery();
	
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}

}
public static void ListIdQuestion ()
{
	PreparedStatement prepare = cnx.prepareStatement();
	Statement statement = cnx.createStatement();
	ResultSet res;
		
	string query="SELECT * FROM Question;";
	prepare = cnx.prepareStatement(query);
	prepare.setObject(1,idQuestion); 
	res = prepare.executeQuery();
	
	prepare.close();
	res.close();
}
	
};
