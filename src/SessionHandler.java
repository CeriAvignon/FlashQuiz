package SessionData;

import connexionjm.ConnexionJM;
import java.sql.*;
import java.util.Date;
import Session.java;		
import Liste.java;



public class SessionHandler
{

	/**
	* <b>Envoie une session vers le serveur pour l'enregistrer.</b>
	* <p>
	* 
	* @author Alexandra MOSHINA 
	*
	* @param s
	*	La session a ecrire/modifier dans la BDD.
	*
	* @see idsession
	* @see iduser
	* @see datestart
	* @see datefin
	* @see typesession
	* @see namesession
	* @see password
	* @see list
	*
	*/
	
	public void sendSession(Session s) throws SQLException
	{
		
	try {
	Connection cnx=connecterDB(); 						//connection a  la BDD
	
	String query="";
	Statement statement = cnx.createStatement();
	ResultSet res=null;	
	int [] liste = s.getList();
	int idsession = s.getId();
	
		if(idsession == -1) // si session existe pas
		{
			//on insere les donnees dans la BDD
			query = "INSERT INTO Session_Metadata(ID_User, Opening_Date, Closing_Date, Type, Title, Password) VALUES(?, ?, ?, ?, ?, ?);";
					PreparedStatement prepare = cnx.prepareStatement(query);
                   	prepare.setObject(1,s.getAuthor());
					prepare.setObject(2,s.getDebut());
					prepare.setObject(3,s.getFin());
					prepare.setObject(4,s.getType());
					prepare.setObject(5,s.getName());
					prepare.setObject(6,s.getPassword());
					prepare.executeUpdate();
					prepare.close();

			//on recupere l'id de la session
			query = "SELECT currval(pg_get_serial_sequence('Session_Metadata','ID_Session')) as ?;";
			prepare = cnx.prepareStatement(query);
			s.setId(res.getInt(1));
			prepare.executeQuery();
			prepare.close();
			res.close();
			
			
			for (int l:liste) // pour chaque element du tableau
			{
				//envoye la liste
				//sendListe(l);
				
					// Ajouter dans Session_Content
					query = "INSERT INTO Session_Content (ID_Liste) values (?));";
					prepare =  cnx.prepareStatement(query);
					prepare.setObject(1,l);
					prepare.executeUpdate();
					prepare.close();
					res.close();
			}
		}
		else //si session existe
		{	
		//on fait la mise a jour de la BDD
			query = "UPDATE Session_Metadata SET (ID_User=?, Opening_Date=?, Closing_Date=?, Type=?, Title=?, Password=?) WHERE ID_Session=?;";
                PreparedStatement prepare = cnx.prepareStatement(query);
                prepare.setObject(1,s.getAuthor());
                prepare.setObject(2,s.getDebut());
                prepare.setObject(3,s.getFin());
                prepare.setObject(4,s.getType());
                prepare.setObject(5,s.getName());
                prepare.setObject(6,s.getPassword());
                prepare.setInt(7, idsession);
                prepare.executeQuery();
                prepare.close();
			
		//supprimer continu Session_Content		
		//suppression 
		query = "DELETE * FROM Session_Content WHERE ID_Session=?;";
		prepare =  cnx.prepareStatement(query);
		prepare.setInt(1, idsession);
		prepare.executeUpdate();
		prepare.close();		

		for (int l:liste) 
		{
			//envoye la liste
			//sendListe(l);
			
				query = "INSERT INTO Session_Content (ID_Liste) values (?));";
				prepare = cnx.prepareStatement(query);
				prepare.setObject(1,l);
				prepare.executeUpdate();
				prepare.close();
		}	
	}
		
   	} 
    	catch (SQLException e){
    		e.printStackTrace();    
    	}		
	
	finally 
	{
		if (connecterDB != null) 
		{
			connecterDB.close();
		}

	}
}
	

	/**
	* <b>Recoupere une session a  partir de la BDD.</b>
	* <p>
	* 
	* @author Alexandra MOSHINA 
	*
	* @param idsession
	*	L'id de la session Ã  recouperer a  partir de la BDD.
	*
        * @return une session
	*
	*
	*/
	public Session getSession(int idsession) throws SQLException
	{
	
	try {
	Connection cnx=connecterDB(); 						//connection Ã  la BDD 
						
	String query="";
	ResultSet res=null;	
	Session s = new Session();
	
		if(idsession !=1){
			//on recoupere les donnees Ã  partir de la BDD
			query = "SELECT ID_Session, ID_User, Opening_Date, Closing_Date, Type, Title, Password FROM Session_Metadata WHERE ID_Session=?;";
			PreparedStatement prepare = cnx.prepareStatement(query);
			//recupere l'id de la session	
			s.setId(res.getInt(1));
			//recupere l'id de l'utilisateur
			s.setAuthor(res.getInt(2));
			//recupere la date de debut
			s.setDebut(res.getDate(3));
			//recupere la date de fin
			s.setFin(res.getDate(4));
			//recupere le type de session
			s.setType(res.getBoolean(5));
			//recupere le nom de session
			s.setName(res.getString(6));
			//recupere le mot de passe
			s.setPassword(res.getString(7));
			prepare.setInt(8, idsession);
			prepare.executeQuery();
			
			prepare.close();
			
			//on recoupere les ids de la liste Ã  partir de la BDD
			query = "SELECT ID_Liste FROM Session_Content WHERE ID_Session=?;";
			prepare = cnx.prepareStatement(query);
			prepare.setInt(1, idsession);
			res = prepare.executeQuery();
			
			// creation d'un tableau pour stocker les ids de la liste
			int [] idslist = new int[10000000];
			int count = 0;
			// s'il y a des ids on les stocke
		        while (res.next()) {
		        	idslist[count++] = res.getInt(1);
		        }
			// recoupere le tableau des ids du liste
			s.setList(idslist);
			prepare.close();
			res.close();
			
			return s;

		}

   		} catch (SQLException e) 
		{
    			e.printStackTrace();    
    		}		
	}
	
	/**
	* <b>Supprime la session dans la BDD.</b>
	* <p>
	* 
	* @author Alexandra MOSHINA 
	*
	* @param idsession
	*	L'id de la session a  supprimer dans la BDD.
	*
	*
	*/
	public void deleteSession(int idsession) throws SQLException
	{
	
	try {
	//connection a  la BDD 
	Connection cnx=connecterDB(); 					
	String query="";					
		
		if(idsession !=-1){

		// suppression de donnees dans la table Session_Metadata
		query = "DELETE * FROM Session_Metadata WHERE ID_Session=?;";
		PreparedStatement prepare = cnx.prepareStatement(query);
		// ID_Session=idsession 
		prepare.setInt(1, idsession);
		prepare.executeUpdate();
		prepare.close();

		// suppression de donnÃ©es dans la table Session_Content
		query = "DELETE * FROM Session_Content WHERE ID_Session=?;";
		prepare =  cnx.prepareStatement(query);
		prepare.setInt(1, idsession);
		prepare.executeUpdate();
		prepare.close();
		}

    } catch (SQLException e) 
	{
    	e.printStackTrace(); 
    	}		
	

	finally 
	{
		if (connecterDB != null) 
		{
			connecterDB.close();
		}
	}
	}

	/**
	* <b>Recoupere une session Ã  partir de la BDD.</b>
	* <p>
	* 
	* @author Alexandra MOSHINA 
	*
	*
        * @return un tableau d'intiers (IDs des Sessions)
	*
	*
	*/
	public static int [] getAIIIDSession() throws SQLException
	{
		try{
		Connection cnx=connecterDB();
						
		String query="";
		ResultSet res=null;	
	
		query = "SELECT ID_Session FROM Session_Metadata;";
		PreparedStatement prepare = cnx.prepareStatement(query);
		res = prepare.executeQuery();
			
			// creation d'un tableau pour stocker les ids
			int [] ids = new int[10000000];
			int count = 0;
			// s'il y a des ids on les stocke
		        while (res.next()) {
		        	ids[count++] = res.getInt(1);
			}
		return ids;
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	}
	
	/**
	* <b>Recoupere une session Ã  partir de la BDD.</b>
	* <p>
	* 
	* @author Alexandra MOSHINA 
	*
	* @param name
	*	Le nom des Sessions Ã  chercher dans la BDD.
	*
        * @return un tableau d'intiers (IDs des Sessions)
	*
	*
	*/

	public static int [] getSessionsByName(String name) throws SQLException
	{
		try{
		Connection cnx=connecterDB();					
		String query="";
		ResultSet res=null;	
	
		//requette pour recouperer les ids des sessions Ã  partir de la BDD
		query = "SELECT ID_Session FROM Session_Metadata WHERE Title=?;";
		PreparedStatement prepare = cnx.prepareStatement(query);
		prepare.setString(1, name);
		res = prepare.executeQuery();
			
			// creation d'un tableau pour stocker les ids
			int [] ids = new int[10000000];
			int count = 0;
			// s'il y a des ids on les stocke
		        while (res.next()) {
		        	ids[count++] = res.getInt(1);
			}

		return ids;
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	}
	
	/**
	* <b>Recoupere une session Ã  partir de la BDD.</b>
	* <p>
	* 
	* @author Alexandra MOSHINA 
	*
	*
        * @return un tableau d'intiers (IDs des Sessions)
	*
	*
	*/
	public static int [] getAIIIDUser() throws SQLException
	{
		try{
		Connection cnx=connecterDB();
						
		String query="";
		ResultSet res=null;	
	
		query = "SELECT ID_User FROM Session_Metadata;";
		PreparedStatement prepare = cnx.prepareStatement(query);
		res = prepare.executeQuery();

		// creation d'un tableau pour stocker les ids des utilisateurs
		int [] ids = new int[10000000];
		int count = 0;

			// s'il y a des ids on les stocke
		        while (res.next()) {
		        	ids[count++] = res.getInt(1);
			}
		return ids;
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	}
 }	
