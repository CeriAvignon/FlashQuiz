package lib.display;

import controller.MainController;

//=============================================================================
// ▼ Console
// ----------------------------------------------------------------------------
// Fonctions d'affichage pour la console.
//=============================================================================
public abstract class Console
{
	//---------------------------------------------------------------------------
	// * Command prompt
	//---------------------------------------------------------------------------
	public static void commandPrompt()
	{
		System.out.print("\r" + Ansi.GREEN + "λ " + Ansi.RESET);
	}

	//---------------------------------------------------------------------------
	// * Clear previous line
	//---------------------------------------------------------------------------
	public static void clearPreviousLine()
	{
		System.out.print("\r"); // Erase line content
		// System.out.print(String.format("\033[%dA",1)); // Move up
		// System.out.print("\r"); // Erase line content
	}

	//---------------------------------------------------------------------------
	// * Print
	//---------------------------------------------------------------------------
	public static void print(String message)
	{
		System.out.println(message);
	}

	//---------------------------------------------------------------------------
	// * Print error
	//---------------------------------------------------------------------------
	public static void printError(String message)
	{
		print(Ansi.RED + "Erreur: " + Ansi.RESET + message);
	}

	//---------------------------------------------------------------------------
	// * Print before prompt command
	//---------------------------------------------------------------------------
	public static void printAsync(String message)
	{
		clearPreviousLine();
		print(message);
		if(MainController.running) commandPrompt();
	}
}
