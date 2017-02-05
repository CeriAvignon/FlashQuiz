package controller;

import java.net.Socket;
import java.io.IOException;
import lib.display.*;
import lib.net.*;

//=============================================================================
// ▼ RemoteServer
// ----------------------------------------------------------------------------
// Etablit une connexion avec un serveur.
// Définit les actions qui envoient des requêtes au serveur et réagissent
// aux réponses de celui-ci.
//=============================================================================
public abstract class RemoteServer
{
	private static RemoteServerSocket server;

	//---------------------------------------------------------------------------
	// * Is connected to server
	//---------------------------------------------------------------------------
	public static Boolean isConnected()
	{
		return (server != null);
	}

	//---------------------------------------------------------------------------
	// * Connect
	// Etablit la connexion avec un serveur et créer un objet SocketStreams.
	//---------------------------------------------------------------------------
	public static void connect(Integer port)
	{
		if(server != null) {
			Console.printError("déjà connecté à un serveur!");
			return;
		}
		if(LocalServer.isOpened()) {
			Console.printError("le serveur local est déjà ouvert!");
			return;
		}
		Console.print("Demandé à rejoindre le serveur sur le port " + port + "...");
		try {
			Socket socket = new Socket("localhost", port);
			server        = new RemoteServerSocket(socket);
			server.start();
		} catch (IOException e) {
			// e.getMessage();
			// e.printStackTrace();
			Console.print("Impossible de se connecter au serveur");
		}
	}

	//---------------------------------------------------------------------------
	// * Close
	//---------------------------------------------------------------------------
	public static void close()
	{
		if(!isConnected()) return;
		server.close();
		Console.print("Déconnexion du serveur!");
		server = null;
	}

	//---------------------------------------------------------------------------
	// * Check remote server
	//---------------------------------------------------------------------------
	public static Boolean checkIsConnected()
	{
		if(!isConnected()) {
			Console.printError("Vous devez être connecté à un serveur");
			return false;
		}
		return true;
	}

	//---------------------------------------------------------------------------
	// * Send request
	//---------------------------------------------------------------------------
	public static void sendRequest(String action, Object object)
	{
		if(!checkIsConnected()) return;
		server.sendRequest(action,object);
	}

	//---------------------------------------------------------------------------
	// * Print received
	//---------------------------------------------------------------------------
	public static void printReceived(String s)
	{
		Console.printAsync(Ansi.GREEN + "Reçu: " + Ansi.RESET + s);
	}

	//---------------------------------------------------------------------------
	// * Capitalize
	// Demande au serveur de renvoyer la chaîne de caractères en majuscules.
	//---------------------------------------------------------------------------
	public static void capitalize(String line)
	{
		if(!checkIsConnected()) return;
		server.sendRequest("capitalize", line);
	}

	//===========================================================================
	// ▼ Requêtes
	// --------------------------------------------------------------------------
	// Traite les requêtes envoyées par le serveur.
	//===========================================================================

	//---------------------------------------------------------------------------
	// * Interpreter
	// Appelle l'action appropriée en fonction du nom de l'action indiquée dans
	// la requête.
	//---------------------------------------------------------------------------
	public static void interpreter(Request request)
	{
		String action = request.getAction();
		Object object = request.getObject();

		switch(action) {
			case "printReceived":
				printReceived((String) object);
				break;
		}
	}
}
