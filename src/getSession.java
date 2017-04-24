package Session;

import connexionjm.ConnexionJM;
import java.sql.*;
import java.util.Date;
import Session.java;		
import Liste.java;



public getSession
{
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
	

}
