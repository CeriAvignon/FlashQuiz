package controller;

import java.net.*;
import java.io.IOException;
import lib.display.*;
import lib.net.SocketStreams;

//=============================================================================
// * Contrôleur principal
// ----------------------------------------------------------------------------
//
//=============================================================================
public abstract class MainController
{
	private static SocketStreams server;

	//---------------------------------------------------------------------------
	// * Main
	// Correspond à l'index de l'application.
	//---------------------------------------------------------------------------
	public static void index()
	{
		connectToServer();
		UserInputInterpreter.input();
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
			System.out.println((String) server.getObject()); // affiche le message de bienvenue
		} catch (IOException ex) {
			System.out.println("Can't connect to server");
		}
	}

	//---------------------------------------------------------------------------
	// * Capitalize
	// Envoie la chaîne de caractères. Affiche la réponse du serveur (la chaîne
	// en majuscules).
	//---------------------------------------------------------------------------
	public static void capitalize(String line)
	{
		server.sendRequest("capitalize",(Object) line);
		String s = (String) server.getObject();
		if(s == null) System.exit(0);
		System.out.println(s);
	}
}
