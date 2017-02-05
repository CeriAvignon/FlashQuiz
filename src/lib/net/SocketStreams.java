package lib.net;

import java.io.*;
import java.net.*;

//=============================================================================
// ▼ SocketStreams
// ----------------------------------------------------------------------------
// Initialise des flots (I/O) à partir d'un socket et permet la réception et
// l'envoi d'objets sur ces flots.
//=============================================================================
public class SocketStreams
{
	private Socket socket;

	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;

	//---------------------------------------------------------------------------
	// * Constructeur
	// Initialise les flots (I/O) à partir d'un socket passé en paramètre.
	//---------------------------------------------------------------------------
	public SocketStreams(Socket socket)
	{
		this.socket = socket;
		try {
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream  = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	//---------------------------------------------------------------------------
	// * Send object
	//---------------------------------------------------------------------------
	public void sendObject(Object object)
	{
		try {
			outputStream.writeObject(object);
			outputStream.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	//---------------------------------------------------------------------------
	// * Get object
	//---------------------------------------------------------------------------
	public Object getObject()
	{
		try {
			Object object = inputStream.readObject();
			return object;
		} catch(IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	//---------------------------------------------------------------------------
	// * Close socket
	//---------------------------------------------------------------------------
	public void closeSocket()
	{
		try {
			socket.close();
		} catch(IOException e) {
			// e.printStackTrace();
		}
	}
}
