# Classe Voter

Les objets Voter sont destinés à être utilisés dans une liste (Vector) afin de gérer les participants à une session du côté de [SessionCreator](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/Liste_classes.md#sessioncreator) et [SessionServer](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/Liste_classes.md#sessionserver).

Un objet Voter pourrait être utilisé de manière unique dans la classe [SessionVoter](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/Liste_classes.md#sessionvoter). On aurait pas besoin de plus que la classe Voter de base (Voter voter).

Les noms de classe (VoterCreator, VoterServer) signifie "l'appartenance" de l'objet Voter au serveur, au créateur de la session... Ils devraient être modifiés pour être plus clair.

## Voter (base)
(classe définissant les propriétés et méthodes communes à toutes les classes filles)

- idendificateur de l'utilisateur dans la base de données
- liste des réponses (Vector\<[VoterAnswer](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/Liste_classes.md#useranswer)\>)
- ...


## VoterCreator

- informations générales utilisateur (nom, prénom, login par exemple. De manière générale, un objet User (classe à définir)?)
- ...


## VoterServer

- de quoi communiquer avec l'appareil du votant
- la liste des réponses à chaque question n'a peut-être pas besoin d'être gardé: ça peut aller directement dans la bdd. L'id du votant est récupérée avec la requête envoyée avec la réponse par le votant.
- un booléen indiquant si le votant a envoyé sa réponse _(fonctions associées: haveAllVotersVoted_)
- ...
