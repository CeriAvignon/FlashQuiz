package lib.server;

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
	private int clientNumber;
	private SocketStreams socket;

	//---------------------------------------------------------------------------
	// * Constructeur
	// Définit le numéro client et créer un objet SocketStreams qui établit des
	// flots (I/O) avec le client.
	//---------------------------------------------------------------------------
	public ClientHandler(Socket socket, int clientNumber)
	{
		super("ClientHandler");
		this.socket = new SocketStreams(socket);
		this.clientNumber = clientNumber;
		log("nouvelle connexion établie");
	}

	//---------------------------------------------------------------------------
	// * Run
	//---------------------------------------------------------------------------
	public void run()
	{
		try {
		sendRequest("printReceived","Bienvenue #" + clientId + "!"; // message de bienvenue
		Request request;

			while (true) {
				request = socket.getRequest();
				if(request == null) break;

				if(request.getAction().equals("capitalize"))
					capitalize((String) request.getObject());
			}

		} finally {
			socket.closeSocket();
			log("connexion terminée");
		}
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
		Console.print("#" + clientNumber + " " + message);
	}
}
