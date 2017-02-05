package lib.server;

import java.net.*;
import lib.net.*;
import lib.display.*;
import controller.LocalServer;

//=============================================================================
// ▼ ClientHandler
// ----------------------------------------------------------------------------
// Créée après l'établissement d'une connexion avec un utilisateur.
// Gère les actions de l'utilisateur.
//=============================================================================
public class ClientHandler extends Thread
{
	private int clientId;
	private SocketStreams socket;

	//---------------------------------------------------------------------------
	// * Constructeur
	// Définit le numéro client et créer un objet SocketStreams qui établit des
	// flots (I/O) avec le client.
	//---------------------------------------------------------------------------
	public ClientHandler(Socket socket)
	{
		super("ClientHandler");
		this.socket = new SocketStreams(socket);
		this.clientId = Clients.add(this);
		log("nouvelle connexion établie");
	}

	//---------------------------------------------------------------------------
	// * Run
	//---------------------------------------------------------------------------
	public void run()
	{
		sendRequest("printReceived","Bienvenue #" + clientId + "!"; // message de bienvenue
		Request request;

		while (true) {
			request = socket.getRequest();
			if(request == null) break;
			LocalServer.interpreter(this,request);
		}

		close();
	}

	//---------------------------------------------------------------------------
	// * Send request to client
	//---------------------------------------------------------------------------
	public void sendRequest(String action, Object object)
	{
		socket.sendRequest(action,object);
	}

	//---------------------------------------------------------------------------
	// * Close
	//---------------------------------------------------------------------------
	public void close()
	{
		socket.closeSocket();
		Clients.remove(clientId);
		log("connexion terminée");
	}

	//---------------------------------------------------------------------------
	// * Log
	// Affiche un message sur la sortie standard. Indique le numéro du client
	// avant le message.
	//---------------------------------------------------------------------------
	protected void log(String message)
	{
		Console.printAsync(Ansi.BLUE + "#" + clientId + Ansi.RESET + " " + message);
	}
}
