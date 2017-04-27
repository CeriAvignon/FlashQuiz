import connexion.Connexion;
import java.sql.*;
import model.base.*;
import model.session.*;


/**
	*  @author Sacha Le Doeuff
	*  @version 1.0
	*  Kit de fonction qui permet de recuperer les reponses des utilisateurs
	*  pour faire les statistiques (fonctions utilisees par le groupe TVS)
	**/

public class VoterAnswerHandler {

	/**
	 *	<b> enregistrement d'une nouvelle reponse d'un utilisateur sur une des question d'une session. </b>
	 * 	
	 *  @param id_question, id_session, id_user, texte
	 *		les different elements qui composent la table VoterAnswer
	 *	
	 **/
	public void setVoterAnswer(int id_question, int id_session, int id_user, String texte)
	{
		Connexion cnx;					//on ouvre une connexion

		String query="";				//requete vide
		PreparedStatement prepare = cnx.prepareStatement();			//prends la requete pour la modifier puis l'envoyer

		//si besoin de complexifier la requete
		//Statement statement = cnx.createStatement();

		try{
			query="INSERT INTO VoterAnswer(ID_Session, ID_Question, ID_User, Content_FreeAnswer) VALUES(?,?,?,?);";
			//on remplace les valeur manquante de la requete, puis on envoi la requete
			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_session);
			prepare.setObject(2,id_question);
			prepare.setObject(3,id_user);
			prepare.setObject(4,texte);
			prepare.executeUpdate();
			prepare.close();
		}
		catch(SQLException e){
			//En cas d'erreur
			e.printStackTrace();
		}
		finally{
			if(cnx != null)
				cnx.close();
		}
	}

	/**
	 *	<b> récupération d'une reponse d'un utilisateur sur une des question d'une session. </b>
	 * 	
	 *  @param id_question, id_session, id_user
	 *		les different elements qui identifient une réponse bien précise
	 *	
	 **/
	public Object[][] getVoterAnswer(int id_question, int id_session, int id_user)
	{
		Connexion cnx;

		try{
			PreparedStatement prepare = cnx.prepareStatement();
			ResultSet res;
			String query="";	//La ou on met le resultat de la requete

			query="SELECT * FROM VoterAnswer WHERE ID_Session=? AND ID_Question=? AND ID_User=?;";

			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_session);
			prepare.setObject(2,id_question);
			prepare.setObject(3,id_user);
			res = prepare.executeQuery();

			prepare.close();
			res.close();

			Object resultat[][] = res;
			return resultat;			//retour de la requete
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
	
	
	
	/**
	 *	<b> récupération des reponses de tout les users sur une des question d'une session. </b>
	 * 	
	 *  @param id_question, id_session
	 *		les different elements qui identifient une question et une session
	 *	
	 **/
	public Object[][] getAllVoterAnswer(int id_question, int id_session)
	{
		Connexion cnx;

		try{
			PreparedStatement prepare = cnx.prepareStatement();
			ResultSet res;
			String query="";	//La ou on met le resultat de la requete

			query="SELECT * FROM VoterAnswer WHERE ID_Session=? AND ID_Question=?;";

			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_session);
			prepare.setObject(2,id_question);
			res = prepare.executeQuery();

			prepare.close();
			res.close();

			Object resultat[][] = res;
			return resultat;			//retour de la requete
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
	
	
	/**
	 *	<b> récupération des reponses de tout les users sur toute les questions d'une session. </b>
	 * 	
	 *  @param id_question, id_session
	 *		les different elements qui identifient une question et une session
	 *	
	 **/
	public Object[][] getEveryVoterAnswer(int id_session)
	{
		Connexion cnx;

		try{
			PreparedStatement prepare = cnx.prepareStatement();
			ResultSet res;
			String query="";	//La ou on met le resultat de la requete

			query="SELECT * FROM VoterAnswer WHERE ID_Session=?;";

			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_session);
			res = prepare.executeQuery();

			prepare.close();
			res.close();

			Object resultat[][] = res;
			return resultat;			//retour de la requete
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
	
	

	/**
	 *	<b> récupération des réponses d'un utilisateur sur toute les questions auquel il a répondu </b>
	 * 	
	 *  @param id_user
	 *		l'id de l'utilisateur dont onv eut les réponses
	 *	
	 **/
	public Object[][] getVoterAnswersByUser(int id_user)
	{
		Connexion cnx;

		try{
			PreparedStatement prepare = cnx.prepareStatement();
			ResultSet res;
			String query="";

			query="SELECT * FROM VoterAnswer WHERE ID_User=?;";

			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_user);
			res = prepare.executeQuery();


			prepare.close();
			res.close();

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

	/**
	 *	<b> récupération des réponses d'un utilisateur sur toute les questions auquel il a répondu d'une session </b>
	 * 	
	 *  @param id_user, id_session
	 *		l'id de l'utilisateur dont on veut les réponses et de la session voulue
	 *	
	 **/
	public Object[][] getVoterAnswersByUserAndSession(int id_user, int id_session)
	{
		Connexion cnx;

		try{
			PreparedStatement prepare = cnx.prepareStatement();
			ResultSet res;
			String query="";

			query="SELECT * FROM VoterAnswer WHERE ID_User=? AND ID_Session=?;";

			prepare = cnx.prepareStatement(query);
			prepare.setObject(1,id_user);
			prepare.setObject(2,id_session);
			res = prepare.executeQuery();


			prepare.close();
			res.close();
			
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
