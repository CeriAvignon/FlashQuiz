import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.*;
import lib.display.*;

//=============================================================================
// ▼ App
// ----------------------------------------------------------------------------
// Etablit une connexion avec le serveur.
//=============================================================================
class App
{
	private static Socket socket;
	private static BufferedReader in;
	private static PrintWriter out;

	//---------------------------------------------------------------------------
	// * Etablit la connexion et initialise les flots (I/O)
	//---------------------------------------------------------------------------
	public static void connectToServer()
	{
		try {
			socket = new Socket("localhost", 9090);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			Console.print(in.readLine()); // affiche le message de bienvenue du serveur
		} catch (IOException ex) {
			Console.print("Can't connect to server");
		}
	}

	//---------------------------------------------------------------------------
	// * Main
	//---------------------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		connectToServer();
	}
}
