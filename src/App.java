import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import lib.display.*;
import java.util.Scanner;

//=============================================================================
// ▼ App
// ----------------------------------------------------------------------------
// Etablit une connexion avec le serveur.
//=============================================================================
class App
{
	private static Socket socket;
	private static ObjectInputStream inputStream;
	private static ObjectOutputStream outputStream;

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
					sendObject(inputs[0]);
					receivedObject = getObject();
					if(receivedObject == null) System.exit(0);
					response = (String) receivedObject;
					System.out.println("Reçu: " + response);
			}
		}
	}

	//---------------------------------------------------------------------------
	// * Etablit la connexion et initialise les flots (I/O)
	//---------------------------------------------------------------------------
	public static void connectToServer()
	{
		try {
			socket = new Socket("localhost", 9090);
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream  = new ObjectInputStream(socket.getInputStream());
			Console.print((String) getObject()); // affiche le message de bienvenue du serveur
		} catch (IOException ex) {
			Console.print("Can't connect to server");
		}
	}

	//---------------------------------------------------------------------------
	// * Get object
	//---------------------------------------------------------------------------
	private static Object getObject()
	{
		try {
			Object object = inputStream.readObject();
			return object;
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	//---------------------------------------------------------------------------
	// * Send object
	//---------------------------------------------------------------------------
	private static void sendObject(Object object)
	{
		try {
			outputStream.writeObject(object);
			outputStream.flush();
		} catch(IOException e) {
			e.printStackTrace();
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
