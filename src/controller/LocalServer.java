package controller;

import lib.display.*;
import lib.net.Request;
import lib.server.*;

//=============================================================================
// ▼ LocalServer
// ----------------------------------------------------------------------------
// Initialise et gère un serveur.
// Définit les actions en réponse aux requêtes d'un client.
//=============================================================================
public abstract class LocalServer
{
	private static Server server;

	//---------------------------------------------------------------------------
	// * Is server opened
	//---------------------------------------------------------------------------
	public static Boolean isOpened()
	{
		return (server != null);
	}

	//---------------------------------------------------------------------------
	// * Open
	// Initialise et démarre le serveur.
	//---------------------------------------------------------------------------
	public static void open(Integer port)
	{
		if(isOpened()) {
			Console.printError("le serveur est déjà ouvert!");
			return;
		}
		if(RemoteServer.isConnected()) {
			Console.printError("déjà connecté à un autre serveur!");
			return;
		}
		Console.print("Demandé à démarrer un serveur sur le port " + port + "...");
		try {
			server = new Server(port);
			server.start();
		} catch(Exception e) {
			Console.printError("impossible d'ouvrir le serveur (port déjà utilisé?)");
		}
	}

	//---------------------------------------------------------------------------
	// * Stop
	//---------------------------------------------------------------------------
	public static void close()
	{
		if(!isOpened()) return;
		server.close();
		server = null;
	}

	//---------------------------------------------------------------------------
	// * Check remote server
	//---------------------------------------------------------------------------
	public static Boolean checkIsOpened()
	{
		if(!isOpened()) {
			Console.printError("Le serveur n'est pas ouvert");
			return false;
		}
		return true;
	}

	//---------------------------------------------------------------------------
	// * Send request to client
	//---------------------------------------------------------------------------
	public void sendRequest(ClientHandler client, String action, Object object)
	{
		if(!checkIsOpened()) return;
		client.sendRequest(action, object);
	}

	//---------------------------------------------------------------------------
	// * Send request to all clients
	//---------------------------------------------------------------------------
	public void sendRequestToAll(String action, Object object)
	{
		if(!checkIsOpened()) return;
		Clients.sendRequestToAll(action, object);
	}

	//---------------------------------------------------------------------------
	// * Interpreter
	// Appelle l'action appropriée en fonction du nom de l'action indiquée dans
	// la requête.
	//---------------------------------------------------------------------------
	public static Boolean interpreter(ClientHandler client, Request request)
	{
		String action = request.getAction();
		Object object = request.getObject();

		switch(action) {
			default:
				return SessionMaster.interpreter(client, action, object);
		}
	}
}
