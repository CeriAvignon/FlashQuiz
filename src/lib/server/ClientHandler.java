package lib.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import lib.display.*;

import lib.net.Request;
import lib.net.SocketStreams;

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
	// Reçoit une chaîne de caractères envoyée par le client et la renvoie en
	// majuscules.
	//---------------------------------------------------------------------------
	public void run()
	{
		try {
			socket.sendObject("Bienvenue #" + clientNumber + "!"); // message de bienvenue

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
	// * Capitalize
	// Renvoie la chaîne de caractères en majuscules.
	//---------------------------------------------------------------------------
	public void capitalize(String line)
	{
		socket.sendObject(line.toUpperCase());
	}

	//---------------------------------------------------------------------------
	// * Log
	// Affiche un message sur la sortie standard du serveur. Indique le numéro
	// du client avant le message.
	//---------------------------------------------------------------------------
	protected void log(String message)
	{
		Console.print("#" + clientNumber + " " + message);
	}
}
