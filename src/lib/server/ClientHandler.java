package lib.server;

import java.io.*;
import java.net.*;

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

	private BufferedReader in;
	private PrintWriter out;

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
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			log(e.getMessage());
		}
		System.out.println("Nouvelle connexion établie avec #" + clientNumber);
	}

	//---------------------------------------------------------------------------
	// * Run
	// Reçoit une chaîne de caractères envoyée par le client et la renvoie en
	// majuscules.
	//---------------------------------------------------------------------------
	public void run()
	{
		try {
			// Send a welcome message to the client.
			out.println("Bienvenue #" + clientNumber + "!");
			while (true) {
				String input = in.readLine();
				if (input == null || input.equals(".")) {
					break;
				}
				out.println(input.toUpperCase());
			}
		} catch (IOException e) {
			log("Error handling client " + e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				log("Couldn't close a socket, what's going on?");
			}
			log("Connexion #" + clientNumber + " terminée");
		}
	}

	//---------------------------------------------------------------------------
	// * Log
	// Affiche un message sur la sortie standard du serveur.
	//---------------------------------------------------------------------------
	private void log(String message)
	{
			System.out.println(message);
	}
}
