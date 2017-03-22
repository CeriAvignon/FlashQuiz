public class ActionSession
{
  		public Session displayInfoSession(int idsession)
	{
		session = new Session();
		session = getSessionById(idsession);
		return session;
	}

/* gerer ca part des Listes*/
	public boolean findSession(String name)
	{
		int tabid[] = new int[0];
		int id ; 
		existSessionName(name, tabid); 
		/*@existSessionName
			existSessionName: fonction que doit implémenter BDD (ALexandra) qui interroge l'existence d'une session de nom name, qui remplit un 			tableau d'id s'il en existent, ou qui ne remplit rien s'il n'en existe pas !! */

		if (tabid.length == 0)
		// SI aucun element dans le tableau c'est que rien n'a été rempli
		{
			System.out.println("La session " + name + " n'existe pas.");
			return false;
		}

		else {
		// SInon on parcourt le tableau remplit pour en afficher les infos (que gereront IG)
			for (int i = 0; i < tabid.length; i++)
			{
				id = tabid[i];
				displayInfoSession(id);
			}
			return true;
		}
		
	}
}
