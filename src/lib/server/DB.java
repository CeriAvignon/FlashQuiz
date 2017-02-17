package lib.server;

// TODO RES-BDD

//=============================================================================
// ▼ DB
// ----------------------------------------------------------------------------
// Etablit une connexion avec la bdd.
// Si ça se trouve, cette classe peut être abstraite (non instanciable).
// Ainsi, on n'établit qu'une seule connexion quand on lance le serveur, et
// on l'utilise à chaque fois qu'il y en a besoin.
// TODO:
// - il faut trouver un moyen pour n'autoriser qu'une seule action sur la bdd
// à la fois (qu'une seule fonction sur l'objet connexion).
//=============================================================================
public class DB
{
	// private static Type connexion; // Je sais pas le type ^^

	//---------------------------------------------------------------------------
	// * Connect
	// Initialise la connexion avec la bdd.
	//---------------------------------------------------------------------------
	// public static initialize()
	// {
		// Votre connexion à la bdd
	// }

	/*===========================================================================
	* ▼ CONCERNANT VOS CLASSES "OBJECTHANDLER"
	* ---------------------------------------------------------------------------
	* Dans vos classes ObjectHandler, passez vos fonctions sendObject en statique
	* pour qu'on puisse les appeler d'ici. Ainsi on aura pas à instancier d'objet.
	*
	* Pour rester dans la même logique, vous pouvez d'ailleurs les renommer
	* save(Object object).
	*
	* Par exemple:
	*
	* class QuestionHandler {
	*   public static void save(Question question)
	*   {
	* 		// Le contenu de votre fonction
	*   }
	* }
	===========================================================================*/

	//---------------------------------------------------------------------------
	// * Save List
	//---------------------------------------------------------------------------
	// public static saveList(List list)
	// {
	// 	ListHandler.saveList(list);
	// }

	//---------------------------------------------------------------------------
	// * Save question
	//---------------------------------------------------------------------------
	// public static saveList(Question question)
	// {
	// 	QuestionHandler.saveQuestion(question);
	// }

	// etc.
}
