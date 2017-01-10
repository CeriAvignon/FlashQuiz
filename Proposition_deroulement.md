# Déroulement d'une session

## Session utilisateur

```
- Initialisation de la session (après avoir entré un mot de passe, s'il y a)
- Réception de la série de questions de la part du serveur
- Attente de la connexion des autres participants...
- Démarrage de la session + démarrage timer général (s'il y a)
- Question: [boucle: tant qu'il reste des questions non votées]
	- Réception du numéro de la question de la part du serveur
	- Affichage énoncé + lancement timer question
	- Attente de la confirmation d'envoi de la réponse de l'utilisateur...
	- Envoi de la réponse au serveur
	- [Attente de la fin de la question...]
	- Affiche le résultat (si la réponse envoyée était correcte ou non)
	- Attente du signal du serveur avant le passage à la question suivante
- Affichage des statistiques générales (utilisateur) de la session
- Fin de session
```


## Créateur de la session

```
- Création/Ouverture d'une session associée à une série de questions
- Réception de la série de questions de la part du serveur
- Attente de la connexion de participants...
- Démarrage de la session + démarrage timer général (s'il y a)
- Question: [boucle: tant qu'il reste des questions non votées]
	- Réception du numéro de la question de la part du serveur
	- Affichage énoncé + lancement timer question
	- Attente... (attend la fin du timer, que tous les votants ont envoyé leur réponse, ou que le créateur
	de la session force le passage)
	- Réception des statistiques des participants traitées par le serveur
	- Affichage des statistiques
	- Attente avant le passage à la question suivante
- Affichage des statistiques générales de la session
- Fin de session
```

## Serveur

```
- Ouverture de la session
- Attente de connexion des participants... (avec mdp)
- Démarrage de la session de vote [première question] (n'accepte plus de participants,
n'apparaît plus dans la liste des sessions ouvertes)
- Question: [boucle: tant qu'il reste des questions non votées]
	- Envoi l'id de la question suivante aux participants et au créateur de la session (aléatoire ou défini)
	- Attente de la fin de la question (tous les votants ont envoyé leur réponse, le créateur de la session
	a forcé la fin de question (ici il n'y a pas de timer)) et réception des réponses des votants
	- Pour chaque réponse reçue, vérifie si elle est correcte ou non
	- Mise à jour des statistiques
- Sauvegarde des résultats dans la bdd (ou après chaque question?)
- Envoi des statistiques générales de la session à Session_Creator
- Envoi des statistiques pour la session aux Session_Voter
```

## Notes

Il manque encore l'ajout d'une question en pleine session (ça se passe entre Session_Creator et Session_Server).




public class Session_Voter {
	/**
	 * Start session
	 */
	public void start_session()
	{
		start();
		update();
		terminate();
	}

	/**
	 * Start
	 */
	private void start()
	{
		// Démarrer timer de la session (s'il y a)
	}

	/**
	 * Update
	 *
	 * Gère de la réception de la question/de l'id de la question à l'attente de la prochaine question.
	 */
	private void update()
	{
		while(!isFinished()) {
			getNextQuestion();
			// Affichage de la question
			// Entrée de la réponse
			// Envoi de la réponse au serveur
			// [ Attente de la fin de la question... ]
			// Fin de la question (confirmation de la réponse, temps écoulé, le créateur de la session a forcé...)
			// Attente du serveur...
			// Affiche si la réponse envoyée était correcte ou non (?)
			// Attente du passage à la question suivante... (synchronisé)
		}
	}

	/**
	 * Terminate
	 */
	private void terminate()
	{
		// Attente du serveur...
		// Affichage des statistiques générales du participant (à partir de là, le serveur a fermé la session (sauf s'il reste des trucs à faire))
		// Attente fermeture de la session de la part de l'utilisateur...
	}
}


public class Session_Creator {
	/**
	 * Start session
	 */
	public void start_session()
	{
		start();
		update();
		terminate();
	}

	/**
	 * Start
	 */
	private void start()
	{
		// Démarrer timer de la session (s'il y a)
	}

	/**
	 * Update
	 *
	 * Gère de la réception de la question/de l'id de la question à l'attente de la prochaine question.
	 */
	private void update()
	{
		while(!isFinished()) {
			getNextQuestion();
			// Affichage de la question
			// Démarrage timer de la question (s'il y a)
			// Attente de la fin de la question
			// Fin de la question (temps écoulé, passage forcé...)
			// Attente du serveur...
			// Réception des statistiques traitées par le serveur
			// Affichage des statistiques des participants
			// Attente du passage à la question suivante... (synchronisé)
		}
	}

	/**
	 * Terminate
	 */
	private void terminate()
	{
		// Attente du serveur...
		// Affichage des statistiques générales de la session (à partir de là, le serveur a fermé la session (sauf s'il reste des trucs à faire))
		// Attente fermeture de la session de la part de l'utilisateur
	}
}


public class Session_Server {
	/**
	 * Start session
	 */
	public void start_session()
	{
		start();
		update();
		terminate();
	}

	/**
	 * Start
	 */
	private void start()
	{
		// Ajouts de participants (objet Voter)
		// Attente du démarrage de la session par le créateur de la session...
		// Fermer session: retire la session de la liste des sessions ouvertes
	}

	/**
	 * Update
	 *
	 * Gère de la réception de la question/de l'id de la question à l'attente de la prochaine question.
	 */
	private void update()
	{
		while(!isFinished()) {
			// Envoi l'id de la question suivante aux participants et au créateur de la session (aléatoire ou défini)
			// Réception des réponses des votants... (Attente)
				// Vérification de la réponse (réponse + stats (temps de réponse))
			// Mise à jour des statistiques
			// Envoi des statistiques à Session_Creator
			// Envoi des résultats aux Session_Voter
		}
	}

	/**
	 * Terminate
	 */
	private void terminate()
	{
		// Envoi des statistiques générales de la session à Session_Creator
		// Envoi des statistiques pour la session aux Session_Voter
		// Ecriture des résultats dans la bdd
		// Fermeture session
	}
}
