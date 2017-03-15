public class ActionSession
{
  public static void displayInfoSession(int idsession)
	{
		Session A = new Session();
		getSessionById(idsession, A);
		/* 
			@getSessionBYId(int, Session): fonction que doit implémenter BDD (Alexandra) qui renvoie un objet Session (en remplissant A) passé par 
			reference par l'id passé en argument envoyé par IG 
		*/
		System.out.println("\nVoici les informations à propos de la session n° "+ A.getId() +".\n");
		System.out.println("Nom Session: " + A.getNameSession() + ".\n");
		System.out.println("ID Auteur:" + A.getAuthor() + " .\n");
		System.out.println("Date début: " + A.getDebut() + ".\n");
		System.out.println("Date fin: " + A.getFin() + ".\n");
		System.out.println("Type: " + A.getType() + ".\n");
		//System.out.println("Mot de passe: " + getPassword() + ".\n");
	}


	public static boolean findSession(String name)
	{
		int tabid[] = new int[];
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
