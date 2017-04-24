package SessionData;

import connexionjm.ConnexionJM;
import java.sql.*;
import java.util.Date;
import Session.java;		
import Liste.java;



public class GetAIIIDSession
{
/**
	* <b>Recoupere une session a  partir de la BDD.</b>
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
  }
