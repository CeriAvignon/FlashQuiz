package ques;
import ConnexionJM.java;
import java.sql.*;

public class QuestionHandler {
	
	public void sendQuestion(Question question)
	{
		int idQuestion = question.getIdQuestion();
		String contenu = question.getIntitule();
		int typeQuestion = question.getTypeQuestion();
		String mediafile = question.getMediafile();
		int typeMedia = question.getTypeMedia();
		
		Statement statement = connexion.createStatement();
		int retour;
		ResultSet res=null;
		if(idQuestion == -1)
		{
			res = statement.executeQuery( "SELECT * FROM Media WHERE Contenu_media=mediafile;" );//COUNT(*)
			if(res == null)
			{
				retour = statement.executeUpdate("INSERT INTO Media(TYPE,Contenu_media) VALUES(typeMedia,mediafile)");
			}
			res = statement.executeQuery( "SELECT ID_Media FROM Media;" );
			retour = statement.executeUpdate("INSERT INTO Questions(TYPE_Question,Contenu_Question,"+ "ID_Media) VALUES(contenu,typeQuestion,)");
		}
		else
		{
			
		}
		
		
	}
};
