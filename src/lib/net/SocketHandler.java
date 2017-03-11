package lib.net;

import java.io.*;
import java.net.*;

//=============================================================================
// ▼ SocketHandler
// ----------------------------------------------------------------------------
// Initialise des flots (I/O) à partir d'un socket et permet la réception et
// l'envoi d'objets et de requêtes sur ces flots.
// Gère de manière asynchrone la réception de requêtes.
//=============================================================================
public abstract class SocketHandler extends Thread
{
	private Socket socket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;

	//---------------------------------------------------------------------------
	// * Constructeur
	// Initialise les flots (I/O) à partir d'un socket passé en paramètre.
	//---------------------------------------------------------------------------
	public SocketHandler(Socket socket)
	{
		super("SocketHandler");
		this.socket = socket;
		try {
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream  = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	//---------------------------------------------------------------------------
	// * Run
	//---------------------------------------------------------------------------
	public void run()
	{
		Request request;

		while (true) {
			request = getRequest();
			if(request == null) break;
			processRequest(request);
		}

		close();
	}

	//---------------------------------------------------------------------------
	// * Process Request
	//---------------------------------------------------------------------------
	public abstract void processRequest(Request request);

	//---------------------------------------------------------------------------
	// * Send object
	//---------------------------------------------------------------------------
	private void sendObject(Object object)
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
	private Object getObject()
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
	// * Send request
	// Crée et envoie un objet Request.
	//---------------------------------------------------------------------------
	public void sendRequest(String action, Object object)
	{
		sendObject(new Request(action,object));
	}

	//---------------------------------------------------------------------------
	// * Get object
	// Récupère et retourne un objet Request.
	//---------------------------------------------------------------------------
	public Request getRequest()
	{
		return (Request) getObject();
	}

	//---------------------------------------------------------------------------
	// * Is closed?
	//---------------------------------------------------------------------------
	public Boolean isClosed()
	{
		return socket.isClosed();
	}

	//---------------------------------------------------------------------------
	// * Close
	//---------------------------------------------------------------------------
	public void close()
	{
		try {
			if(isClosed()) return;
			socket.close();
		} catch(IOException e) {
			// e.printStackTrace();
		}
	}
}
