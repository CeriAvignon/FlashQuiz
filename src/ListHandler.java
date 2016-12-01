import ConnexionJM.java;
import Liste.java;
import java.sql.*;
import java.util.Vector;

/**
 	*  @author Renaud Galy
 	*  @version 1.4
 	*  
	*
 	*  Cette classe va servir &agrave; coder toutes les fonctions permettant un 
 	*  acc&egrave;s aux tables Liste_Contenu et Liste_Metadata de la base de 
 	*  donn&eacute;es. La fonction sendList(Liste list) permet de cr&eacute;er une 
 	*  liste de questions et de modifier des listes existantes. 
 	*  Cela n&eacute;cessitera un acc&egrave;s aux tables Liste_Metadata et 
 	*  Liste_Contenu, ainsi qu'un acc&egrave;s &agrave; la classe QuestionHandler, 
 	*  et aux classes du groupe &eacute;dition de liste (EL).De m&ecircme, la fonction 
 	*  getList(int id) va r&eacute;cup&eacute;rer l'id d'une liste dans la table 
 	*  Liste_Metadata et retourner un objet Liste, le groupe &eacute;dition de 
 	*  liste pourra alors afficher la liste d&eacute;sir&eacute;e via l'interface 
 	*  graphique du groupe du m&ecircme nom.
 	* 
 	**/

public class ListHandler 
{
	/**
	 * 
	 * @since 1.4
	 * @param list
	 * 				Une liste de questions.
	 * 
	 **/ 
	public void sendList(List list)
	{
		Question question;
		int idQuestion;
		Connection cnx=connecterDB();

		/** 
		 * 
		 * R&eacute;cup&eacute;ration de la liste de question avec la fonction 
		 * getIdList().
		 * 
		 **/

		int idList = list.getIdList();
		int idAuthor = list.getIdAuthor();
		String listName = list.getListName();
		Vector<Question>listQuestion = list.getListQuestion();

		/** 
		 * 
		 * Cr&eacute;ation d'une requ&ecircte vide qui sera affect&eacute;e selon 
		 * les besoins de la fonction. 
		 * 
		 * */

		String query="";
		PreparedStatement prepare = cnx.prepareStatement();
		Statement statement = connexion.createStatement();
		ResultSet res;

		/**
		 * 
		 *  Cas d'une liste qui n'existe pas (premi&egrave;re v&eacute;rification 
		 *  faite par le groupe Edition de Liste).
		 *  
		 **/

		if(idList == -1)
		{

			/** 
			 * 
			 * Pr&eacute;paration de la requ&ecircte, qui va parcourir la table 
			 * Liste_Metadata. Pour l'instant, il n'y a pas d'ajout ou de 
			 * modification de liste. 
			 * 
			 **/
			
			query = "SELECT FROM Liste_Metadata WHERE Titre_Liste = ?;";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,idList);
			res = prepare.executeQuery();
			
			/**
			 * 
			 * Deuxi&egrave;me v&eacute;rification, pour savoir si la liste est 
			 * d&eacute;jà pr&eacute;sente dans la base de donn&eacute;es. 
			 * Si elle existe, on r&eacute;cup&egrave;re l'ID correspondant &agrave; 
			 * la liste dans la base de donn&eacute;es, sinon il faut se 
			 * r&eacute;ferer &agrave; la ligne if(!row).
			 **/
			
			boolean row = res.first();
			if(row)idList = res.getInt("ID_Liste");
			prepare.close();
			res.close();

			/**
			 *
			 *  Si la liste n'existe pas dans la base de donn&eacute;es
			 *  
			 **/

			if(!row)
			{
				
				
				/**
				 * 
				 *  Ajout des informations de la liste dans la table Liste_Metadata 
				 *  
				 **/
				
				
				query="INSERT INTO Liste_Metadata(ID_Utilisateur,Titre_Liste) VALUES(?,?);";
				prepare = cnx.prepareStatement(query);
				prepare.setObject(1,idAuthor);
				prepare.setObject(2,listName);
				prepare.executeUpdate();
				prepare.close();
				res.close();

				res=statement.executeQuery("SELECT currval(pg_get_serial_sequence('Liste_Metadata','ID_Liste'));");
				idList = res.getInt("ID_Liste");
				statement.close();
				res.close();
			}
			/**
			 * 
			 *  Ajout du contenu de la liste dans la table Liste_Contenu. Ici, on
			 *  appelle en boucle la fonction sendQuestion(Question question) 
			 *  jusqu'&agrave; avoir atteint la fin de la liste de question. 
			 *  Chaque ID de question est ensuite ajout&eacute; dans la table 
			 *  Liste_Contenu avec comme ID_Liste correspondant l'ID de la liste 
			 *  qui la contient. Ainsi, la table contiendra plusieurs fois un 
			 *  m&ecircme ID de liste avec un ID de question diff&eacute;rente 
			 *  &agrave; chaque fois.
			 *  
			 **/
			query="INSERT INTO Liste_Contenu(ID_Liste, ID_Question) VALUES(?,?);";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,idList);

				for(int i = 0; i< listQuestion.size(); i++)
				{
					question = listQuestion[i];
					sendQuestion(question);
					idQuestion = question.getIdQuestion();
					prepare.setObject(2,idQuestion);
					prepare.executeUpdate();
					prepare.close();
					res.close();
				}

		}
	
		/**
		 * 
		 *  Si la liste existe d&eacute;j&agrave;, seule la modification du titre 
		 *  est possible ici (voir sendQuestion(Question question) pour modifier 
		 *  une question donn&eacute;e)
		 * 
		 **/
		
		else
		{
			query="UPDATE Liste_Contenu SET Titre_Liste=? WHERE ID_Liste=? ;";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,idList);
			prepare.executeUpdate();
			prepare.close();
			res.close();
		}
	}
	
}
