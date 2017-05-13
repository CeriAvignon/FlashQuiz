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
	private static RemoteServerSocket socket;

	//---------------------------------------------------------------------------
	// * Is connected to server
	//---------------------------------------------------------------------------
	public static Boolean isConnected()
	{
		return (socket != null);
	}

	//---------------------------------------------------------------------------
	// * Connect
	// Etablit la connexion avec un serveur et créer un objet SocketStreams.
	//---------------------------------------------------------------------------
	public static void connect(Integer port)
	{
		if(socket != null) {
			Console.printError("déjà connecté à un serveur!");
			return;
		}
		if(LocalServer.isOpened()) {
			Console.printError("le serveur local est déjà ouvert!");
			return;
		}
		Console.print("Demandé à rejoindre le serveur sur le port " + port + "...");
		try {
			Socket simpleSocket = new Socket("localhost", port);
			socket = new RemoteServerSocket(simpleSocket);
			socket.start();
		} catch (IOException e) {
			// e.getMessage();
			// e.printStackTrace();
			Console.printError("Impossible de se connecter au serveur");
		}
	}

	//---------------------------------------------------------------------------
	// * Close
	//---------------------------------------------------------------------------
	public static void close()
	{
		if(!isConnected()) return;
		if(!socket.isClosed()) socket.close();
		socket = null;
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
		socket.sendRequest(action, object);
	}

	//---------------------------------------------------------------------------
	// * Interpreter
	// Appelle l'action appropriée en fonction du nom de l'action indiquée dans
	// la requête.
	//---------------------------------------------------------------------------
	public static Boolean interpreter(Request request)
	{
		String action = request.getAction();
		Object object = request.getObject();

		switch(action) {
			default:
				return SessionVoter.interpreter(action, object);
		}
	}
}
