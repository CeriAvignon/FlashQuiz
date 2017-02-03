# WIP - Proposition pour les packages de l'application

ça devrait fonctionner __exactement__ comme l'application de conception web... (Non je n'étais pas parti pour le recopier ^^)


```cpp
src
├─── Client.java                    // Application PC
├─── Android.java                   // Application Android
│
├─── controller
│    ├─── Edit.java                 // EL
│    ├─── General.java              // Authentification, recherche session, stat utilisateur, sessions organisées
│    ├─── MainController.java
│    ├─── SessionMaster.java        // TVS
│    └─── SessionVoter.java         // TVS
│
│
├─── lib
│    ├─── Ansi.java                 // Couleurs pour rendre les tests plus amusants :)
│    │
│    └─── net
│         ├─── ClientHandler.java
│         ├─── Clients.java
│         ├─── DB.java              // RES-BDD
│         ├─── Request.java
│         ├─── Server.java
│         └─── SocketStreams.java
│
├─── model                          // Commun à EL et TVS
│    ├─── Answer.java
│    ├─── List.java
│    ├─── Media.java
│    ├─── Question.java
│    ├─── SessionBase.java
│    ├─── Session.java
│    ├─── User.java
│    ├─── UserAnswer.java
│    │
│    ├─── AnswerTable.java          // RES-BDD
│    ├─── ListTable.java
│    ├─── QuestionTable.java
│    ├─── SessionTable.java
│    ├─── UserAnswerTable.java
│    ├─── UserTable.java
│    └─── ...
│
├─── view-android                   // IG
│    └─── ...
└─── view-desktop                   // IG
     └─── ...
```

Ce qu'il reste à faire par groupe (a priori):

__IG__
- évidemment, les vues restantes
- nous fournir un exemple de code permettant:
	- d'appeler vos vues et de leur envoyer un/des objet(s) dont vous afficherez les informations
	- de mettre à jour les informations d'une vue

__EL et/ou TVS__
- s'accorder sur les modèles
- toute la partie contrôleur:
	- générale ie authentification, recherche de session ouverte, afficher stat, etc. (dans General.java) (__EL ou TVS__)
	- édition de liste (Edit.java) (__EL__)
	- déroulement de session: SessionMaster et SessionVoter (SessionServer a été intégrée à SessionMaster) (__TVS__)

__RES-BDD__
- les requêtes SQL qui vont avec les modèles
- la connexion à une bdd externe
- la connexion PC/Android
