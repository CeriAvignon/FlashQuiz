package controller;

import lib.server.*;
import lib.net.*;
import lib.display.*;

//=============================================================================
// ▼ SessionMaster
// ----------------------------------------------------------------------------
//
//=============================================================================
public abstract class SessionMaster
{
	// private static Session session;
	// private static Vector<Vector<VoterAnswer>> votersAnswers;

	//---------------------------------------------------------------------------
	// * Interpreter
	// Effectue l'action appropriée sur l'objet envoyé en fonction du nom de
	// l'action.
	//---------------------------------------------------------------------------
	public static Boolean interpreter(ClientHandler client, String action, Object object)
	{
		switch(action) {
			case "capitalize":
				capitalize(client, (String) object);
				break;
			default:
				return false;
		}
		return true;
	}

	//---------------------------------------------------------------------------
	// * Capitalize
	// Renvoie la chaîne de caractères envoyée par le client en majuscules.
	//---------------------------------------------------------------------------
	private static void capitalize(ClientHandler client, String message)
	{
		if(!LocalServer.checkIsOpened()) return;
		client.sendRequest("printReceived",message.toUpperCase());
	}

	//---------------------------------------------------------------------------
	// * Send message to all
	// Envoie un message à tous les clients connectés.
	//---------------------------------------------------------------------------
	public static void sendMessageToAll(String message)
	{
		if(!LocalServer.checkIsOpened()) return;
		Clients.sendRequestToAll("printReceived", message);
	}
}
