package controller;

import java.net.*;
import java.io.IOException;
import lib.display.*;
import lib.server.Server;

//=============================================================================
// * Contrôleur principal
// ----------------------------------------------------------------------------
//
//=============================================================================
public abstract class MainController
{
	//---------------------------------------------------------------------------
	// * Main
	// Correspond à l'index de l'application.
	//---------------------------------------------------------------------------
	public static void index()
	{
		Console.print(Ansi.BLUE + "\nBonjour!" + Ansi.RESET);
		UserInputInterpreter.input();
		terminate();
	}

	//---------------------------------------------------------------------------
	// * Terminate
	//---------------------------------------------------------------------------
	public static void terminate()
	{
		Console.print("A la prochaine!\n");
		LocalServer.close();
		RemoteServer.close();
	}
}
