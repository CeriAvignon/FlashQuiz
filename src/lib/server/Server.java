package lib.server;

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
public class Server extends Thread
{
	private ServerSocket listener;
	private boolean listening;

	private Integer clientsNumber;

	//---------------------------------------------------------------------------
	// * Constructor
	//---------------------------------------------------------------------------
	public Server(Integer port) throws IOException, UnknownHostException
	{
		setListener(port);
	}

	//---------------------------------------------------------------------------
	// * Set listener
	//---------------------------------------------------------------------------
	private void setListener(Integer port) throws IOException, UnknownHostException
	{
		listener = new ServerSocket(port, 0, InetAddress.getByName(null));
	}

	//---------------------------------------------------------------------------
	// * Listen
	// Créer un nouveau socket et un nouvel objet ClientHandler à chaque fois
	// qu'un client essaie de se connecter. Attribue à ce client un numéro.
	//---------------------------------------------------------------------------
	public void run()
	{
		listening = true;
		Socket socket;
		ClientHandler client;

		Console.printAsync(Ansi.GREEN + "Serveur démarré!" + Ansi.RESET);

		while(listening) {
			socket = listener.accept();
			client = new ClientHandler(socket,clientsNumber++);
			client.start();
		}
	}

	//---------------------------------------------------------------------------
	// * Close
	// Cesse "l'écoute" et ferme toutes les connexions en cours.
	//---------------------------------------------------------------------------
	public void close()
	{
		stopListening();
		Clients.closeAll();
	}

	//---------------------------------------------------------------------------
	// * Stop listening
	// Cesse d'établir de nouvelles connexions.
	//---------------------------------------------------------------------------
	public void stopListening()
	{
		listening = false;
		try {
			listener.close();
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
