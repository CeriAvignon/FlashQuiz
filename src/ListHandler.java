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
		int idQuestion[];
		Connection cnx=connecterDB();

		/** 
		 * 
		 * R&eacute;cup&eacute;ration de la liste de question avec la fonction 
		 * getIdList().
		 * 
		 **/

		int idList = list.getId();
		int idAuthor = list.getAuthor();
		String listName = list.getName();

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
			
			query = "SELECT * FROM List_Metadata WHERE Title = ?;";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,listName);
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
			if(row)idList = res.getInt("ID_List");
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
				
				
				query="INSERT INTO List_Metadata(ID_User,Title) VALUES(?,?);";
				prepare = cnx.prepareStatement(query);
				prepare.setObject(1,idAuthor);
				prepare.setObject(2,listName);
				prepare.executeUpdate();
				prepare.close();
				res.close();

				res=statement.executeQuery("SELECT currval(pg_get_serial_sequence('List_Metadata','ID_List'));");
				idList = res.getInt("ID_List");
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
			query="INSERT INTO List_Content(ID_List, ID_Question) VALUES(?,?);";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,idList);

				for(int i = 0; i< idQuestion.size(); i++)
				{
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
			query="UPDATE List_Content SET Title=? WHERE ID_List=? ;";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,idList);
			prepare.executeUpdate();
			prepare.close();
			res.close();
		}
	}
	
	public List getList (int idList) throws SQLException
	{
		
		Connection cnx=connecterDB();
		int idQuestion [];
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
			
			/** 
			 * Cr&eacute;ation de la requ&ecirc;te. 
			 **/
			
			query="SELECT * FROM List_Metadata WHERE ID_List=?;";
			/** 
			 * Acc&egrave;es &agrave; la liste gr&acirc;ce à l'id donn&eacute; en argument. 
			 **/
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,idList);
			
			/** 
			 * R&eacute;cup&eacute;ration des informations de la liste contenues dans la table List_Metadata. 
			 **/
			
			res = prepare.executeQuery();
			
			/**
			 *Cr&eacute;ation de l'objet List qui contient les informations de la liste. 
			 **/
			
			List list = new List(res.getInt("Id_List"),res.getInt("ID_User"),res.getInt("Title"));
			
			prepare.close();
			
			/** 
			 * Fin de la requ&ecirc;te. 
			 **/
			
			res.close();
			
			query="SELECT ID_Question FROM List_Content WHERE ID_List=?;";
			prepare = cnx.prepareStatement(query);
			
			/** 
			 * Ici, on va chercher les id des questions appartenant &acute; la liste. 
			 **/
			
			prepare.setObject(1,idList);
			
			res = prepare.executeQuery();
			
			/**
			 * Ici, le r&eacute;sultat de la requ&ecirc;te est un tableau d'id, on peut donc l'affecter &acute; 
			 * un tableau d'entiers. 
			 **/
			
			idQuestion = res;
			
			/** 
			 * Ajout d'un tableau d'id de question &acute; l'objet List.
			 **/
			
			list.setQuestion(idQuestion);
			
			/** 
			 * On renvoie l'objet List. 
			 **/
			
			return list;
			
		}
		
		/**
		 * En cas d'&eacute;chec de la requ&ecric;te. 
		 **/
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	
}
