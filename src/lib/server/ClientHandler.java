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
// Les requêtes reçues seront traitées par le contrôleur 'LocalServer'.
//=============================================================================
public class ClientHandler extends SocketHandler
{
	private int clientId;

	//---------------------------------------------------------------------------
	// * Constructeur
	// Définit le numéro client et créer un objet SocketStreams qui établit des
	// flots (I/O) avec le client.
	//---------------------------------------------------------------------------
	public ClientHandler(Socket socket)
	{
		super(socket);
		this.clientId = Clients.add(this);
		log("nouvelle connexion établie");
		sendRequest("printReceived","Bienvenue #" + clientId + "!"); // message de bienvenue
	}

	//---------------------------------------------------------------------------
	// * Process Request
	// Les requêtes reçues seront traitées par le contrôleur 'LocalServer'.
	//---------------------------------------------------------------------------
	public void processRequest(Request request)
	{
		LocalServer.interpreter(this,request);
	}

	//---------------------------------------------------------------------------
	// * Close
	//---------------------------------------------------------------------------
	public void close()
	{
		super.close();
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
