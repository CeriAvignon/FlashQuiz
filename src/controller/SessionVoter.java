package controller;

import lib.display.*;
import lib.net.*;

//=============================================================================
// ▼ SessionVoter
// ----------------------------------------------------------------------------
//
//=============================================================================
public abstract class SessionVoter
{
	// private static Session session;
	// private static Vector<VoterAnswer> voterAnswers;

	//---------------------------------------------------------------------------
	// * Interpreter
	// Effectue l'action appropriée sur l'objet envoyé en fonction du nom de
	// l'action.
	//---------------------------------------------------------------------------
	public static Boolean interpreter(String action, Object object)
	{
		switch(action) {
			case "printReceived":
				printReceived((String) object);
				break;
			default:
				return false;
		}
		return true;
	}

	//---------------------------------------------------------------------------
	// * Print received
	//---------------------------------------------------------------------------
	public static void printReceived(String s)
	{
		Console.printAsync(Ansi.GREEN + "Reçu: " + Ansi.RESET + s);
	}

	//---------------------------------------------------------------------------
	// * Capitalize
	// Demande au serveur de renvoyer la chaîne de caractères en majuscules.
	//---------------------------------------------------------------------------
	public static void capitalize(String line)
	{
		RemoteServer.sendRequest("capitalize", line);
	}
}
