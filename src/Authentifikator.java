
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
import java.util.logging.Logger

/**
* Simplificateur d'accès BDD.
*
*
*/
class DB_Accessor {
	/**
	* L'adresse de la BDD.
	*/
	private static String url;
	/**
	* Le nom d'utilisateur à utiliser pour accéder à la BDD
	*/
	private static String user;
	/***
	* Le mot de passe de l'utilisateur
	*/
	private static String password;
	/**
	* Méthode générique permettant de formatter, exécuter et retourner le résultat d'une requête.
	*
	* @param query La requête avec les champs à remplacer
	* @param arguments Les arguments à insérer, DANS L'ORDRE, dans les champs non pré-remplis
	*/
	public static ResultSet doQuery(String query, String[] arguments) {
		Connexion connection;
		Statement statement;
		ResultSet result;
		try {
			connection = conneterDB();
			statement = connection.createStatement();
			PreparedStatement prepare =  connection.prepareStatement(query);
			{
				int i = 1;
				for(String argument : arguments) {
					prepare.setObject(i,datestart);
					i++;
				}
				prepare.executeUpdate();
				prepare.close();
			}
			result = statement.executeQuery(query);
			return result;
		}
		catch (SQLException e) {
			return null;
		} finally {
			if (result != null) {result.close();}
			if (statement != null) {statement.close();}
			if (connection != null) {connection.close();}
		}
	}
}

/**
* Wrap pour englober les accès BDD.
*
*
*/

class QueryHandler() {
	/**
	* Vérifie auprès de la base de donnée que les identifiants sont corrects.
	*
	* @param login Identité sous laquelle se connecter
	* @param pass Mot de passe relatif au compte
	*/
	public static int sendAuth(String login, String pass) {
		String[] arguments = {login, pass};
		ResultSet result = DB_Accessor.doQuery("SELECT COUNT(*) as valid FROM User_FQ WHERE login = ? AND password = ?;",arguments);
		return (result.getInt('VALID') == 0);
	}
	/**
	* Réponse au ping ponctuel envoyé par l'application pour vérifier que la connexion est valide
	*
	* @param username Le nom d'utilisateur sous lequel l'application pense être connectée
	* @param password Le mot de passe supposément associé à cet utilisateur
	*/
	public static int getAuth(String username, String password) {
		String query = "select count(*) as VERIFIED FROM User_FQ WHERE login = ? AND password = ?;";
		String[] params = {username, password};
		ResultSet pinganswer = DB_Accessor.doQuery(query,params);
		return (pinganswer.getInt('VERIFIED') < 1);
	}
}
/**
* Pure classe de test
*
*
*/
class Authentifikator {
	/**
	* 
	*
	*
	*/
	public static void main(String[] args) {

	}
}