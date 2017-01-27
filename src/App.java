import java.io.*;
import java.net.*;

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
			in     = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out    = new PrintWriter(socket.getOutputStream(),true);
			System.out.println(in.readLine()); // affiche le message de bienvenue du serveur
		} catch (IOException ex) {
			System.out.println("Can't connect to server");
		}
	}

	//---------------------------------------------------------------------------
	// * Main
	//---------------------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		connectToServer();
	}
}
