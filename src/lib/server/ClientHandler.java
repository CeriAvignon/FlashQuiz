package lib.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import lib.display.*;

//=============================================================================
// ▼ ClientHandler
// ----------------------------------------------------------------------------
// Créée après l'établissement d'une connexion avec un utilisateur.
// Gère les actions de l'utilisateur.
//=============================================================================
public class ClientHandler extends Thread
{
	private Socket socket;
	private int clientNumber;

	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;

	//---------------------------------------------------------------------------
	// * Constructeur
	// Définit le socket et initialise les flots (I/O).
	//---------------------------------------------------------------------------
	public ClientHandler(Socket socket, int clientNumber)
	{
		super("ClientHandler");
		this.socket       = socket;
		this.clientNumber = clientNumber;

		try {
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream  = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			log(e.getMessage());
		}
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
			sendObject("Bienvenue #" + clientNumber + "!"); // message de bienvenue

			Object receivedObject;
			String userInput;

			while (true) {
				receivedObject = getObject();
				if (receivedObject == null) break;
				userInput = (String) receivedObject;
				log("Reçu: " + userInput);
				sendObject(userInput.toUpperCase());
			}

		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				log("couldn't close a socket, what's going on?");
			}
			log("connexion terminée");
		}
	}

	//---------------------------------------------------------------------------
	// * Send object
	//---------------------------------------------------------------------------
	private void sendObject(Object object)
	{
		try {
			outputStream.writeObject(object);
			outputStream.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	//---------------------------------------------------------------------------
	// * Get object
	//---------------------------------------------------------------------------
	private Object getObject()
	{
		try {
			Object object = inputStream.readObject();
			return object;
		} catch(IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	//---------------------------------------------------------------------------
	// * Log
	// Affiche un message sur la sortie standard du serveur. Indique le numéro
	// du client avant le message.
	//---------------------------------------------------------------------------
	private void log(String message)
	{
		Console.print("#" + clientNumber + " " + message);
	}
}
