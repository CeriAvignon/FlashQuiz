package lib.net;

import java.io.Serializable;

//=============================================================================
// ▼ Request
// ----------------------------------------------------------------------------
// Elle associe une chaîne de caractères correspondant à une action donnée
// d'un contrôleur et un objet (Object).
//=============================================================================
public class Request implements Serializable
{
	private String action;
	private Object object;

	//---------------------------------------------------------------------------
	// * Constructeur
	//---------------------------------------------------------------------------
	public Request(String action, Object object) {
		this.action = action;
		this.object = object;
	}

	//---------------------------------------------------------------------------
	// * Get action
	//---------------------------------------------------------------------------
	public String getAction()
	{
		return action;
	}

	//---------------------------------------------------------------------------
	// * Get object
	//---------------------------------------------------------------------------
	public Object getObject()
	{
		return object;
	}
}
