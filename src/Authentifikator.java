
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

class DB_Accessor {
	private static String url;
	private static String user;
	private static String password;
	public static ResultSet doQuery(String query) {
		Connexion connection;
		Statement statement;
		ResultSet result;
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();
			PreparedStatement prepare =  connection.prepareStatement(query);
			{
				prepare.setObject(1,datestart);
				prepare.setObject(2,dateend);
				prepare.setObject(3,typesession);
				prepare.setObject(4,namesession);
				prepare.setObject(5,password);
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

class QueryHandler() {
	public static int sendAuth(String login, String password) {
		String[] arguments = {login, password};
		ResultSet result = DB_Accessor.doQuery("SELECT COUNT(*) as valid FROM User_FQ WHERE id = ? AND password = ?;",arguments);
		return (result.getInt('VALID') < 1);
	}
	public static int getAuth(String login, String password) {
		return sendAuth(login,password);
	}
}

class Authentifikator {
	public static void maint(String[] args) {

	}
}