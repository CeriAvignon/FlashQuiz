import ConnexionJM.java;
import Liste.java;
import java.sql.*;
import java.util.Vector;

/**
 	*  @author Renaud Galy
 	*  @version 1.4
 	*  
 	*  
 	*  Cette classe va servir à coder toutes les fonctions permettant un accès 
 	*  aux tables Liste_Contenu et Liste_Metadata de la base de données. 
 	*  La fonction sendList(Liste list) permet de créer une liste de questions 
 	*  et de modifier des listes existantes. Cela nécessitera un accès aux tables 
 	*  Liste_Metadata et Liste_Contenu, ainsi qu'un accès à la classe QuestionHandler, 
 	*  et aux classes du groupe édition de liste (EL).De même, la fonction 
 	*  getList(int id) va récupérer l'id d'une liste dans la table Liste_Metadata et 
 	*  retourner un objet Liste, le groupe édition de liste pourra alors afficher 
 	*  la liste désirée via l'interface graphique du groupe du même nom.
 	* 
 	**/

public class ListHandler 
{
	/**
	 * 
	 * @since 1.4
	 * @param list
	 * 		Une liste de questions.
	 * 
	 **/ 
	public void sendList(List list)
	{
		Question question;
		int idQuestion;
		Connection cnx=connecterDB();

		/** 
		 * 
		 * Récupération de la liste de question avec la fonction getIdList().
		 * 
		 **/

		int idList = list.getIdList();
		int idAuthor = list.getIdAuthor();
		String listName = list.getListName();
		Vector<Question>listQuestion = list.getListQuestion();

		/** 
		 * 
		 * Création d'une requête vide qui sera affectée selon les besoins de 
		 * la fonction. 
		 * 
		 * */

		String query="";
		PreparedStatement prepare = cnx.prepareStatement();
		Statement statement = connexion.createStatement();
		ResultSet res;

		/**
		 * 
		 *  Cas d'une liste qui n'existe pas (première vérification faite par le
		 *  groupe Edition de Liste)
		 *  
		 **/

		if(idList == -1)
		{

			/** 
			 * 
			 * Préparation de la requête, qui va parcourir la table Liste_Metadata.
			 * Pour l'instant, il n'y a pas d'ajout ou de modification de liste. 
			 * 
			 **/
			
			query = "SELECT FROM Liste_Metadata WHERE Titre_Liste = ?;";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,idList);
			res = prepare.executeQuery();
			
			/**
			 * 
			 * Deuxième vérification, pour savoir si la liste est déjà présente dans
			 * la base de données. Si elle existe, on récupère l'ID correspondant 
			 * à la liste dans la base de données, sinon il faut se réferer à la
			 * ligne if(!row).
			 *
			 **/
			
			boolean row = res.first();
			if(row)idList = res.getInt("ID_Liste");
			prepare.close();
			res.close();

			/**
			 *
			 *  Si la liste n'existe pas dans la base de données
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
			 *  appelle en boucle la fonction sendQuestion(Question question) jusqu'à
			 *  avoir atteint la fin de la liste de question. Chaque ID de question
			 *  est ensuite ajouté dans la table Liste_Contenu avec comme ID_Liste 
			 *  correspondant l'ID de la liste qui la contient. Ainsi, la table 
			 *  contiendra plusieurs fois un même ID de liste avec un ID de question
			 *  différente à chaque fois.
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
		 *  Si la liste existe déjà, seule la modification du titre est possible 
		 *  ici (voir sendQuestion(Question question) pour modifier une 
		 *  question donnée)
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
