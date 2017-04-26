//importer connection bdd
import connexion.Connexion;
import java.sql.*;
//import .java
import model.base.*;
import model.session.*;


/**
	*  @author Sacha Le Doeuff
	*  @version 1.0
	*
	*
	*  xxxxxxx
	**/

public class VoterAnswerHandler {

	/**
	 *
	 * @since x
	 * @param x
	 *
	 **/
	public void setVoterAnswer(int id_question, int id_session, int id_user, String texte)
	{
		Connexion cnx;//=connecterDB();

		/**
		 * Creation d'une requete vide qui sera affectee selon
		 * les besoins de la fonction.
		 * */

		String query="";
		PreparedStatement prepare = cnx.prepareStatement();
		Statement statement = cnx.createStatement();

		/* //fonction au cas ou on ne puisse pas avoir tout les id en entrée //

			query="SELECT * FROM Question WHERE Contenu=?;";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,question);
			res = prepare.executeQuery();
			boolean ret=res.first();
			if(ret)question = res.getInt("ID_Question");
			prepare.close();
			res.close();

			query="SELECT * FROM Session WHERE Name=?;";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,session);
			res = prepare.executeQuery();
			boolean ret=res.first();
			if(ret)session = res.getInt("ID_Session");
			prepare.close();
			res.close();

		*/
		try{
			query="INSERT INTO VoterAnswer(ID_Session, ID_Question, ID_User, Content_FreeAnswer) VALUES(?,?,?,?);";
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_session);
			prepare.setObject(2,id_question);
			prepare.setObject(3,id_user);
			prepare.setObject(4,texte);
			prepare.executeUpdate();
			prepare.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			if(cnx != null)
				cnx.close();
		}
	}

	/*
	* vraiment utile ? + pas sur de l'utilisation d'object et de la  conversion de ResultSet en object
	* possibilité: return un objet de type ResultSet, que les gens mettent dans un type Object
	*/
	public Object[][] getVoterAnswer(int id_question, int id_session, int id_user)
	{
		Connexion cnx;//=connecterDB();

		try{
			PreparedStatement prepare = cnx.prepareStatement();
			Statement statement = cnx.createStatement();
			ResultSet res;
			String query="";

			query="SELECT * FROM VoterAnswer WHERE ID_Session=? AND ID_Question=? AND ID_User=?;";

			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_session);
			prepare.setObject(2,id_question);
			prepare.setObject(3,id_user);
			res = prepare.executeQuery();

			prepare.close();
			res.close();

			Object resultat[][] = res;
			return resultat;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			if(cnx != null)
				cnx.close();
		}
	}

	public Object[][] getVoterAnswersByUser(int id_user)
	{
		Connexion cnx;//=connecterDB();

		try{
			PreparedStatement prepare = cnx.prepareStatement();
			Statement statement = cnx.createStatement();
			ResultSet res;
			String query="";

			query="SELECT * FROM VoterAnswer WHERE ID_User=?;";

			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_user);
			res = prepare.executeQuery();


			prepare.close();
			res.close();

			Object resultat[][]=res;
			return resultat;	//return res; undo prec
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			if(cnx != null)
				cnx.close();
		}
	}

	public Object[][] getVoterAnswersByUserAndSession(int id_user, int id_session)
	{
		Connexion cnx;//=connecterDB();

		try{
			PreparedStatement prepare = cnx.prepareStatement();
			Statement statement = cnx.createStatement();
			ResultSet res;
			String query="";

			query="SELECT * FROM VoterAnswer WHERE ID_User=? AND ID_Session=?;";

			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_user);
			prepare.setObject(2,id_session);
			res = prepare.executeQuery();


			prepare.close();
			res.close();
			// may not be necessary
			Object resultat[][]=res;
			return resultat;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			if(cnx != null)
				cnx.close();
		}
	}
};
