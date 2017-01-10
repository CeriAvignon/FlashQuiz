# Architecture Session & classes filles

## Session

Les informations génériques d'une session (cad: communes à tous les types de session) sont:

```
- id de la session (bdd)
- id/nom du créateur
- nom de la session
- la série de questions associée
- ...
```

#### Session_Voter

```
- la liste des réponses aux différentes questions de la série
- les statistiques du votant pour cette session, mises à jour au fil des questions.
Elles sont normalement affichées à la fin.
- ...
```

#### Session_Creator

```
- votants connectés à la session
- réponses (+ statistiques) des votants
- ...
```

#### Session_Server

```
- mot de passe (crypté)
- le créateur de la session (connecté)
- votants connectés et de quoi communiquer avec leurs appareils
- réponses des votants pour chaque question (Vector de Vector de réponses?)
- question courante
- type de session: ordre des questions aléatoire ou défini dans la série
- id des questions répondues (nécessaire si l'ordre est aléatoire)
- ...
```
