package controller;

import java.util.Scanner;
import lib.display.*;

//=============================================================================
// * UserInputInterpreter
// ----------------------------------------------------------------------------
// Appelle les actions appropriées en fonction des commande entrées par
// l'utilisateur. A priori, cette classe ne devrait servir que pour les phases
// de tests.
//=============================================================================
public abstract class UserInputInterpreter
{
	//---------------------------------------------------------------------------
	// * Invite de commandes
	//---------------------------------------------------------------------------
	public static void input()
	{
		Scanner keyboard = new Scanner(System.in);
		String userInput;

		do {
			Console.commandPrompt();
			userInput = keyboard.nextLine().trim();
		} while(interpreter(userInput));
	}

	//---------------------------------------------------------------------------
	// * Interprète la commande de l'utilisateur
	// 'q', quitte l'invite de commande.
	//---------------------------------------------------------------------------
	public static Boolean interpreter(String input)
	{
		String[] inputs = input.split(" ");

		// Interprète la commande
		switch(inputs[0]) {

			// Quitter
			case "q":
				return false;

			// Gestion du serveur
			case "os":
				LocalServer.open(9090);
				break;
			case "js":
				RemoteServer.connect(9090);
				break;
			case "open-server":
				LocalServer.open(Integer.parseInt(inputs[1]));
				break;
			case "join-server":
				RemoteServer.connect(Integer.parseInt(inputs[1]));
				break;
			case "close-server":
				LocalServer.close();
				break;
			case "quit-server":
				RemoteServer.close();
				break;

			// Actions sur le serveur
			case "send-to-all":
				LocalServer.sendMessageToAll(input.replaceFirst("send-message-to-all",""));
				break;
			case "capitalize":
				RemoteServer.capitalize(input.replaceFirst("capitalize ",""));
				break;

			default:

		}
		return true;
	}
}
