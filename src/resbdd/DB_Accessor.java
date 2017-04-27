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
* Simplificateur d'accès BDD.
*/
public class DB_Accessor {
	/**
	* L'adresse de la BDD.
	*/
	private static String url = "";
	/**
	* Le nom d'utilisateur à utiliser pour accéder à la BDD
	*/
	private static String user = "";
	/***
	* Le mot de passe de l'utilisateur
	*/
	private static String password = "";
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
			connection = DriverManager.getConnection("jdbc:postgresql://pedago.univ-avignon.fr/flashquiz", "flashquiz", "FiBZJ2DA");
			statement = connection.createStatement();
			PreparedStatement prepare = connection.prepareStatement(query);
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
	public static int doExec(String query, String[] arguments) {
		Connexion connection;
		Statement statement;
		int result;
		try {
			connection = conneterDB();
			statement = connection.createStatement();
			PreparedStatement prepare = connection.prepareStatement(query);
			{
				int i = 1;
				for(String argument : arguments) {
					prepare.setObject(i,datestart);
					i++;
				}
				prepare.executeUpdate();
				prepare.close();
			}
			result = statement.executeUpdate(query);
			return result;
		}
		catch (SQLException e) {
			return null;
		} finally {
			if (statement != null) {statement.close();}
			if (connection != null) {connection.close();}
		}
	}
}

