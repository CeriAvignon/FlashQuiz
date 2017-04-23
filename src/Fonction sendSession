import connexionjm.ConnexionJM;
import java.sql.*;
import java.util.Date;
import Session.java;		
import Liste.java;



public class Session
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
	int [] liste=s.getList();
	
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
			s.setIdSession(res.getInt(1));
			prepare.executeQuery();
			prepare.close();
			res.close();
			
			
			for (int l:liste) // pour chaque element du tableau
			{
				//envoye la liste
				//sendListe(l);
				//si la liste s'est bien enregistrÃ©e
				if (l.getIdListe() != -1)  
				{
					// Ajouter dans Session_Content
					query = "INSERT INTO Session_Content (ID_Liste) values (?));";
					prepare =  cnx.prepareStatement(query);
					prepare.setObject(1,s.getIdListe());
					prepare.executeUpdate();
					prepare.close();
					res.close();
				}
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
			//si la liste s'est bien enregistrÃ©e

			if (l.getIdListe() != -1)  
			{
				query = "INSERT INTO Session_Content (ID_Liste) values (?));";
				prepare = cnx.prepareStatement(query);
				prepare.setObject(1,l.getIdListe());
				prepare.executeUpdate();
				prepare.close();
			}
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
	
}
