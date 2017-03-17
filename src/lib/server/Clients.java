package lib.server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lib.display.*;
import lib.net.*;

//=============================================================================
// ▼ Clients
// ----------------------------------------------------------------------------
// Gère la liste des clients connectés.
//=============================================================================
public abstract class Clients
{
	private static Integer clientsNumber = 0; // nombre de clients qui se sont connectés
	private static Map<Integer,ClientHandler> clients =
		new ConcurrentHashMap<Integer,ClientHandler>(); // liste des clients connectés

	//---------------------------------------------------------------------------
	// * Add client
	//---------------------------------------------------------------------------
	public static Integer add(ClientHandler client)
	{
		clients.put(clientsNumber,client);
		return clientsNumber++;
	}

	//---------------------------------------------------------------------------
	// * Remove client
	//---------------------------------------------------------------------------
	public static void remove(Integer id)
	{
		clients.remove(id);
	}

	//---------------------------------------------------------------------------
	// * Close client
	//---------------------------------------------------------------------------
	public static void close(Integer id)
	{
		clients.get(id).close();
	}

	//---------------------------------------------------------------------------
	// * Close all clients
	//---------------------------------------------------------------------------
	public static void closeAll()
	{
		// Console.print("Déconnexion de tous les clients");
		for(Integer id : clients.keySet())
			close(id);
	}

	//---------------------------------------------------------------------------
	// * Send request to client
	//---------------------------------------------------------------------------
	public static void sendRequestToClient(Integer id, String action, Object object)
	{
		if(!clients.containsKey(id)) return;
		clients.get(id).sendRequest(action,object);
	}

	//---------------------------------------------------------------------------
	// * Send request to all clients
	//---------------------------------------------------------------------------
	public static void sendRequestToAll(String action, Object object)
	{
		Integer id;

		for(Map.Entry<Integer,ClientHandler> entry : clients.entrySet()) {
			id = entry.getKey();
			sendRequestToClient(id,action,object);
		}
	}

	//---------------------------------------------------------------------------
	// * Display clients
	// Affiche la liste des clients connectés.
	//---------------------------------------------------------------------------
	public static void display()
	{
		System.out.println("Liste des clients connectés");
		System.out.println(clients.entrySet().toString());
	}
}
