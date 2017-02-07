package lib.net;

import java.io.*;
import java.net.*;
import controller.RemoteServer;

//=============================================================================
// ▼ RemoteServerSocket
// ----------------------------------------------------------------------------
// Les requêtes reçues seront traitées par le contrôleur 'RemoteServer'.
//=============================================================================
public class RemoteServerSocket extends SocketHandler
{
	//---------------------------------------------------------------------------
	// * Constructeur
	//---------------------------------------------------------------------------
	public RemoteServerSocket(Socket socket)
	{
		super(socket);
	}

	//---------------------------------------------------------------------------
	// * Process Request
	// Les requêtes reçues seront traitées par le contrôleur 'RemoteServer'.
	//---------------------------------------------------------------------------
	public void processRequest(Request request)
	{
		RemoteServer.interpreter(request);
	}
}
