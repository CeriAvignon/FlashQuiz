class ActionDeleteList
{
/**
* Fonction de supression de question d'une liste 
*
* @author BrunoDemogue
* @param idl= id de la liste a suprimer
*/


public static void Supressionliste(idl)
	{
		SupressionSessionList(idl);			// fonction bdd qui reçoie un  id de liste et supprime le lien entre les Session et cette liste
		SupressionQuestionList(idl);		// fonction bdd qui reçoie un  id de liste et supprime le lien entre les question et cette liste
		SupressionListe(idl);				// supression de la liste dans la bdd
	}
}
