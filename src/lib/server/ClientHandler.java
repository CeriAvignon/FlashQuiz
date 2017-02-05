package lib.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import lib.display.*;

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

			Object receivedObject;
			String userInput;

			while (true) {
				receivedObject = socket.getObject();
				if (receivedObject == null) break;
				userInput = (String) receivedObject;
				log("Reçu: " + userInput);
				socket.sendObject(userInput.toUpperCase());
			}

		} finally {
			socket.closeSocket();
			log("connexion terminée");
		}
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
