
import ConnexionJM.java;
public class QuestionHandler {
	
	public void sendQuestion(Question question)
	{
		int idQuestion = question.getIdQuestion();
		String contenu = question.getIntitule();
		int typeQuestion = question.getTypeQuestion();
		string mediafile = question.getMediafile();
		int typeMedia = question.getTypeMedia();
		//int idauthor = question.getIdAuthor();
		
		Statement statement = connexion.createStatement();
		if(idQuestion == -1)
		{
			ResultSet res = statement.executeQuery( "SELECT COUNT(*) FROM Media WHERE Contenu_media=mediafile;" );
			if()
			
			int retour = statement.executeUpdate("INSERT INTO Questions(ID_Question,TYPE_Question,Contenu_Question,ID_Media) VALUES()");
		}
		else
		{
			
		}
		
		//int ret = statement.executeUpdate("");
	}
}
