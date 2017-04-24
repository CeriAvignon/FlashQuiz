package Session;

import connexionjm.ConnexionJM;
import java.sql.*;
import java.util.Date;
import Session.java;		
import Liste.java;



public DeleteSession
{
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

}
