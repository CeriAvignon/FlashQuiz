
package SessionData;

import connexionjm.ConnexionJM;
import java.sql.*;
import java.util.Date;
import Session.java;		
import Liste.java;



public class GetSessionsByName
{

	/**
	* <b>Recoupere les ids des sessions par nom.</b>
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
  }
