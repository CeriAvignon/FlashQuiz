# FlashQuiz - Groupe Traitement des votes et des statistiques (TVS)

Ceci est un résumé du travail réalisé, en cours ou prévu du groupe TVS.

Il a pour but d'être utilisé comme une base claire et concise de ce qui a été fait ou reste à faire, à la fois par les membres du groupe, et par les membres des autres groupes.

Pour plus de détails, veuillez vous référer à la documentation (javadoc), voire directement au code ou à nous.


## Présentation

Notre groupe gère le déroulement du vote (c'est-à-dire la session de vote), le traitement des réponses envoyées par les utilisateurs, le calcul et l'envoi des statistiques à la base de données.

Plus précisément, cette composante coordonne les différentes étapes dans la session de vote telles que:
- rejoindre la session (pour un utilisateur)
- définir l'ordre des questions
- passer à la question suivante
- envoyer la réponse de l'utilisateur
- afficher les statistiques entre chaque question et à la fin de la session

Nous nous chargeons également d'attribuer un statut "correct" ou "incorrect" pour une réponse donnée (vérifier la présence d'un mot-clé, vérifier que l'ordre est correctement établi, que la/les bonne(s) réponse(s) a/ont été cochée(s)...)

Enfin, nous traitons les données reçues afin d'en tirer des statistiques individuelles ou générales lors d'une session donnée, ou permettant de comparer des sessions.


[Liste des classes](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/Liste_classes.md)

## TODO

- [ ] Déroulement des sessions
- [ ] Définir les classes Voter
