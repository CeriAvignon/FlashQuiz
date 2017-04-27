package resbdd;


import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Vector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Wrap pour englober les accès BDD.
*/

public class QueryHandler() {
	/**
	* Vérifie auprès de la base de donnée que les identifiants sont corrects.
	*
	* @param login Identité sous laquelle se connecter
	* @param pass Mot de passe relatif au compte
	*/
	public static int sendAuth(User user) {
		String[] arguments = {user.username, user.password};
		ResultSet result = DB_Accessor.doQuery("SELECT COUNT(*) as valid FROM User_FQ WHERE login = ? AND password = ?;",arguments);
		return (result.getInt('VALID') == 0);
	}
	/**
	* Réponse au ping ponctuel envoyé par l'application pour vérifier que la connexion est valide
	*
	* @param username Le nom d'utilisateur sous lequel l'application pense être connectée
	* @param password Le mot de passe supposément associé à cet utilisateur
	*/
	public static int getAuth(User user) {
		String query = "select count(*) as VERIFIED FROM User_FQ WHERE login = ? AND password = ?;";
		String[] params = {user.username, user.password};
		ResultSet pinganswer = DB_Accessor.doQuery(query,params);
		return (pinganswer.getInt('VERIFIED') < 1);
	}
	/**
	* Suppression d'une session de connexion
	*
	*/
	public static int deleteAuth(User user) 
        {
		String query = "DELETE FROM User_FQ_Connected WHERE login = ?;";
		String[] params = {user.username};
		int result = DB_Accessor.doQuery(query,params);
		return (result == 0);
	}
	/**
	* Réponse à la requête d'obtention de tous les id utilisateur
	*
	* @return Retourne les ids de tous les utilisateurs
	*/
	public static int[] getAllID() {
		String query = "SELECT ID_User as id FROM User_FQ;";
		String[] params = {};
		ResultSet result = DB_Accessor.doQuery(query,params);
		Array array = result.getArray('is_nullable');
		int[] ids = array.getArray();
		return ids;
	}

	public static int createUser(User user) {
		String[] arguments = {user.username, user.password};
		int result = DB_Accessor.doQuery("INSERT INTO User_FQ (login, password) VALUES (?,?);",arguments);
		return (result == 0);
	}
	
	public static int deleteUser(User user) {
		String[] arguments = {user.username, user.password};
		int result = DB_Accessor.doQuery("DELETE FROM User_FQ WHERE login = ? AND password = ?;",arguments);
		return (result == 0);
	}

	public static int[] getAllUsers() {
		String query = "SELECT * FROM User_FQ;";
		String[] params = {};
		ResultSet result = DB_Accessor.doQuery(query,params);
		Array array = result.getArray('is_nullable');
		int[] logins = array.getArray();
		return logins;
	}
	public static String[] getUser(int id)
	String[] user=new String[];

	Connection cnx=connecterDB();

	try{
		
	PreparedStatement prepare = cnx.prepareStatement();
	Statement statement = cnx.createStatement();
	ResultSet res;
		
	string query="SELECT * FROM User_FQ WHERE ID_User=?;";
	prepare = cnx.prepareStatement(query);
	prepare.setObject(1,id);
	res = prepare.executeQuery();
	
	user[0]=res.getString("First_Name");
	user[1]=getString("Last_Name");
	user[2]=getString("Login");
	user[3]=getString("Password");
	prepare.close();
	res.close();
	return user;
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}
/**
* Pure classe de test
*
*
*/
class Authentifikator {
	/**
	* Juste un main pour les tests au besoin
	*
	*
	*/
	public static void main(String[] args) {

	}
}

