import java.net.*;
import java.io.IOException;
import lib.server.ClientHandler;
import lib.display.*;

//=============================================================================
// ▼ Server
// ----------------------------------------------------------------------------
// Créer un nouvel objet ClientHandler pour chaque client connecté.
// Fonctionne en local pour les tests.
//=============================================================================
public class Server
{
	private ServerSocket listener;
	private boolean listening;

	private Integer clientsNumber;

	//---------------------------------------------------------------------------
	// * Constructor
	//---------------------------------------------------------------------------
	public Server()
	{
		setListener();
		clientsNumber = 0;
	}

	//---------------------------------------------------------------------------
	// * Set listner
	//---------------------------------------------------------------------------
	private void setListener()
	{
		try {
			listener = new ServerSocket(9090, 0, InetAddress.getByName(null));
		} catch (IOException e) {
			System.err.println("Could not listen on port: 9090");
			System.exit(1);
		}
	}

	//---------------------------------------------------------------------------
	// * Listen
	// Créer un nouveau socket et un nouvel objet ClientHandler à chaque fois
	// qu'un client essaie de se connecter. Attribue à ce client un numéro.
	//---------------------------------------------------------------------------
	public void listen() throws IOException
	{
		listening = true;
		while(listening) {
			Socket clientSocket = listener.accept();
			ClientHandler client = new ClientHandler(clientSocket,clientsNumber++);
			client.start();
		}
		listener.close();
	}

	//---------------------------------------------------------------------------
	// * Main
	//---------------------------------------------------------------------------
	public static void main(String[] args) throws IOException
	{
		Server server = new Server();

		Console.print("Serveur démarré!");
		Console.print("================\n");

		server.listen();
	}
}
