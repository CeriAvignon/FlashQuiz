import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	private static ObjectInputStream inputStream;
	private static ObjectOutputStream outputStream;

	//---------------------------------------------------------------------------
	// * Etablit la connexion et initialise les flots (I/O)
	//---------------------------------------------------------------------------
	public static void connectToServer()
	{
		try {
			socket = new Socket("localhost", 9090);
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream  = new ObjectInputStream(socket.getInputStream());
			Console.print((String) getObject()); // affiche le message de bienvenue du serveur
		} catch (IOException ex) {
			Console.print("Can't connect to server");
		}
	}

	//---------------------------------------------------------------------------
	// * Get object
	//---------------------------------------------------------------------------
	private static Object getObject()
	{
		try {
			Object object = inputStream.readObject();
			return object;
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	//---------------------------------------------------------------------------
	// * Main
	//---------------------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		connectToServer();
	}
}
