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
				System.out.println("Bye!");
				return false;

			// Défaut
			default:
				MainController.capitalize(input.replaceFirst("capitalize ",""));
		}
		return true;
	}
}
