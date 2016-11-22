
/*! 
*	\file Session.java
*	\brief Fichier java Session
*	\author {Le Veve Mathieu}
*	\date xx/10/2016
*	\date 22/11/2016
*
*	\class <Session> Session.java 	Session
*	\brief	Fichier en java qui crée une session, pour le moment avec ses getters/ setters pour créer une session
*	pour le moment sans intéraction avec la BDD. 
*/

class Session
{
  	private int static idsession = 1;
	private string session;
	private int idauthor;
	private Vector liste;
	private Vector question;
	private string datedebut;
	private string datefin;

	/*public bool deleteSession()
	{
		if (Evenement choisi par l'utilisateur pour valider la suppression cible une session)
			{
				delete la session en cascade;
				return true;
			} 
		return false;
	}*/
	
	/*public bool modifySession()
	{
		
	}*/

}
