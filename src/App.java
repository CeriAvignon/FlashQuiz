import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import lib.display.*;
import java.util.Scanner;

import lib.net.SocketStreams;

//=============================================================================
// ▼ App
// ----------------------------------------------------------------------------
// Etablit une connexion avec le serveur.
//=============================================================================
class App
{
	private static SocketStreams server;

	//---------------------------------------------------------------------------
	// * Demande à l'utilisateur une chaîne de caractères, l'envoie au serveur
	// et affiche sa réponse (ie la chaîne passée en majuscules).
	// Le programme s'arrête lorsque l'utilisateur entre le caractère 'q'.
	//---------------------------------------------------------------------------
	public static void input()
	{
		Scanner keyboard = new Scanner(System.in);

		Object receivedObject;
		String response;

		String input;
		String[] inputs;

		while(true) {
			// Invite de commande
			System.out.print("> ");
			input = keyboard.nextLine().trim();
			inputs = input.split(" ");

			// Interprète la commande
			switch(inputs[0]) {

				// Quitter
				case "q":
					System.out.println("Bye!");
					return;

				// Défaut
				default:
					// Renvoie la chaîne de caractères en majuscules
					server.sendObject(inputs[0]);
					receivedObject = server.getObject();
					if(receivedObject == null) System.exit(0);
					response = (String) receivedObject;
					System.out.println("Reçu: " + response);
			}
		}
	}

	//---------------------------------------------------------------------------
	// * Etablit la connexion avec le serveur et créer un objet SocketStreams
	// qui initialise les flots (I/O) avec le serveur.
	//---------------------------------------------------------------------------
	public static void connectToServer()
	{
		try {
			Socket socket = new Socket("localhost", 9090);
			server = new SocketStreams(socket);
			Console.print((String) server.getObject()); // affiche le message de bienvenue du serveur
		} catch (IOException ex) {
			Console.print("Can't connect to server");
		}
	}

	//---------------------------------------------------------------------------
	// * Main
	//---------------------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		connectToServer();
		input();
	}
}
