# Liste des classes

Les différentes classes sont présentées, accompagnées de la liste de leurs attributs et de leurs fonctions, ainsi que des tâches restantes à réaliser.

Accessibilité      | Classe                            | Explication
-------------------|-----------------------------------|-------------------------------------------------
publique           | [Answer](#answer)                 | une réponse à une question
publique           | [Question](#question)             | une question
publique           | [List](#list)                     | la liste des questions
publique abstraite | [Session](#session)               | la session de vote (base)
publique           | [SessionVoter](#sessionvoter)     | la session de vote du pdv votant
publique           | [SessionCreator](#sessioncreator) | la session de vote du pdv créateur de la session
publique           | [SessionServer](#sessionserver)   | la session de vote gérée par le serveur
publique           | [UserAnswer](#useranswer)         | une réponse à une question d'un votant
publique           | [Voter](#voter)                   | un votant

***

# Answer

[Code](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/src/Answer.java)

Une réponse est définie par le créateur de la série de questions. Elle correspond soit à une/la réponse correcte à une question, soit aux réponses proposées dans le cas d'une question à choix multiples.

La classe __Answer__ est utilisée dans la classe [Question](#question), qui contient un vecteur de réponses (Vector\<Answer\>).

La classe __Answer__ ne doit pas être confondue avec la classe [UserAnswer](#useranswer), qui définit une réponse effectivement envoyée par un utilisateur lors d'une session de vote.


### Attributs
Visibilité | Type    | Nom     | Explication
-----------|---------|---------|-----------------------------------------
privé      | int     | id      | l'identificateur dans la base de données
privé      | String  | content | la réponse
privé      | boolean | state   | indique si la réponse est vrai ou fausse


### Fonctions

__Accesseurs et mutateurs__

Visibilité | Retourne | Nom        | Paramètres     | Explication
-----------|----------|------------|----------------|------------
publique   | int      | getId      |                | Accesseur
publique   | String   | getContent |                | Accesseur
publique   | boolean  | getState   |                | Accesseur
publique   | void     | setId      | int id         | Mutateur
publique   | void     | setContent | String content | Mutateur
publique   | void     | setState   | boolean state  | Mutateur


### TODO
- [x] A priori, cette classe est terminée


***


# Question

[Code](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/src/Question.java)

Une question, avec un type (parmi "Free", "Radio", "Checkbox", "Number", "OrdoredList"), un énoncé, une liste de [réponses](#answer) possibles et/ou correctes, ainsi qu'un temps maximal alloué.

### Attributs
Visibilité | Type                        | Nom                | Explication
-----------|-----------------------------|--------------------|-----------------------------------------------------------------
privé      | int                         | id                 | l'identificateur dans la base de données
privé      | String                      | statement          | l'énoncé de la question
privé      | String type                 | type               | le type de la question
privé      | vector\<[Answer](#answer)\> | answers            | la liste de réponses possibles et/ou correctes
privé      | int                         | allocatedTime      | le temps maximal alloué en secondes pour répondre à la question


### Fonctions

__Accesseurs et mutateurs__

Visibilité | Retourne         | Nom              | Paramètres       | Explication
-----------|------------------|------------------|------------------|------------
publique   | int              | getId            |                  | Accesseur
publique   | String           | getStatement     |                  | Accesseur
publique   | String           | getType          |                  | Accesseur
publique   | int              | getAnswersNumber |                  | Accesseur
publique   | [Answer](#answer)           | getAnswerAt      | int index        | Accesseur
publique   | Vector\<[Answer](#answer)\> | getAnswers       |                  | Accesseur
publique   | int              | getAllocatedTime |                  | Accesseur
publique   | void             | setId            | int id           | Mutateur
publique   | void             | setStatement     | String statement | Mutateur
publique   | void             | setType          | String type      | Mutateur
publique   | void             | setAnswers       | Vector\<Answer\> | Mutateur
publique   | void             | setAllocatedTime | int time         | Mutateur


### TODO
- [x] A priori, cette classe est terminée


***


# List

[Code](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/src/List.java)

La série de questions.


### Attributs
Visibilité | Type               | Nom                   | Explication
-----------|--------------------|-----------------------|-----------------------------------------------
privé      | int                | id                    | l'identificateur dans la base de données
privé      | String             | name                  | le nom de la série
privé      | User               | creator               | le créateur de la série
privé      | Vector\<[Question](#question)\> | questions | la liste des questions
privé      | boolean            | isQuestionOrderRandom | indique si l'ordre des questions est aléatoire


### Fonctions

__Accesseurs et mutateurs__

Visibilité | Retourne         | Nom                      | Paramètres       | Explication
-----------|------------------|--------------------------|------------------|------------
publique   | int              | getId                    |                  | Accesseur
publique   | String           | getName                  |                  | Accesseur
publique   | User             | getCreator               |                  | Accesseur
publique   | int              | getQuestionsNumber       |                  | Accesseur
publique   | [Question](#question)           | getQuestionAt | int index    | Accesseur
publique   | Vector\<[Question](#question)\> | getQuestions  |              | Accesseur
publique   | int              | isQuestionOrderRandom    |                  | Accesseur
publique   | void             | setId                    | int id           | Mutateur
publique   | void             | setName                  | String name      | Mutateur
publique   | void             | setCreator               | User creator     | Mutateur
publique   | void             | setQuestions             | Vector\<[Question](#question)\> | Mutateur
publique   | void             | setIsQuestionOrderRandom | boolean isRandom | Mutateur

### TODO
- [x] Renommer Series en List pour s'accorder avec RES-BDD et EL
- [ ] Peut-être que le nom de la série et le nom de son créateur ne sont pas nécessaires ?


***


# Session

[Proposition d'architecture pour les classes Session](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/Proposition_architecture_sessions.md)

[Proposition de déroulement pour chaque type de session](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/Proposition_deroulement.md)

La classe Session a pour but d'initialiser et gérer la session de vote (passer d'une étape à l'autre, etc.).

Nous avons dégagé trois aspects, trois points de vue, lors de la session de vote, à savoir:
- le votant
- le créateur de la session
- le serveur

Pour modéliser cettre structure, la session est donc découpée en une classe mère abstraite [Session](#session-base), ainsi que trois classes filles [SessionVoter](#sessionvoter), [SessionCreator](#sessioncreator) et [SessionServer](#sessionserver) qui seront utilisées respectivement sur les appareils des votants, du créateur et sur le serveur.


### Session (base)

[Code](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/src/Session.java)

Cette classe __abstraite__ regroupe les attributs et fonctions partagés par les trois autres types de sessions.

#### Attributs
Visibilité | Type                  | Nom              | Explication
-----------|-----------------------|------------------|---------------------------------------------
protégé    | int                   | id               | l'identificateur dans la base de données
protégé    | String                | name             | le nom de la session
protégé    | String                | nameCreator      | le nom du créateur de la session
protégé    | [List](#list)         | list             | la liste des questions
protégé    | [Question](#question) | currQuestion     | la question en cours

#### Fonctions
__Accesseurs et mutateurs__


### SessionVoter

Cette classe définit le déroulement de la session du point de vue du votant. Cela signifie qu'un objet SessionVoter tourne sur l'appareil du votant lorsqu'il participe à un quiz.

#### Attributs
Visibilité | Type | Nom     | Explication
-----------|------|---------|---------------------------------------------------
privé      | int  | idVoter | l'identificateur du votant dans la base de données

#### Fonctions
__Accesseurs et mutateurs__


### SessionCreator

Cette classe définit le déroulement de la session du point de vue du créateur de la dite session. Cela signifie qu'un objet SessionCreator tourne sur l'appareil du créateur lorsqu'il ouvre une session.

#### Attributs
Visibilité | Type                   | Nom              | Explication
-----------|------------------------|------------------|--------------------------------------------
privé      | vector\<int\>          | unvotedQuestions | la liste des index des questions non votées
privé      | vector\<[VoterCreator](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/Proposition_classe_voter.md#votercreator)\> | voters           | les votants participant à la session

#### Fonctions
__Accesseurs et mutateurs__


### SessionServer

Cette classe gère le comportement du serveur lors de la session de vote.

C'est elle qui communique avec les appareils des votants et du créateur de la session.

#### Attributs
Visibilité | Type                  | Nom              | Explication
-----------|-----------------------|------------------|--------------------------------------------
privé      | vector\<int\>         | unvotedQuestions | la liste des index des questions non votées
privé      | Creator               | creator          | le créateur de la session
privé      | vector\<[VoterServer](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/Proposition_classe_voter.md#voterserver)\> | voters           | les votants participant à la session

#### Fonctions
__Accesseurs et mutateurs__

## TODO
- [ ] Déroulement des trois sessions


***


# UserAnswer

[Code](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/src/UserAnswer.java)

La réponse d'un votant à une question lors d'une session.

### Attributs
Visibilité | Type    | Nom        | Explication
-----------|---------|------------|-----------------------------
privé      | int     | questionId | l'identificateur de la question correspondante
privé      | String  | answer     | la réponse du votant
privé      | boolean | answered   | indique si la question a bien été répondue (?)


### Fonctions
__Accesseurs et mutateurs__


### TODO
- [ ] renommer _'userAnswer'_ en _'answer'_
- [ ] l'attribut answered est probablement inutile: le serveur sait quelles questions ont été passé, et sait donc quelles questions ont été répondues ou non... (pas clair)
- [ ] une fonction du style isCorrect() permettant de vérifier si la réponse du votant est correcte

Une table sera nécessaire dans la base de données pour enregistrer les réponses des utilisateurs. Quelque chose qui ressemblerait à ça:
```sql
TABLE UserAnswer :
    INT ID_Question
    INT ID_User
    Int ID_Session
    TEXT Content
```


***


# Voter

[Proposition de structure pour les classes Voter](https://github.com/CeriAvignon/FlashQuiz/blob/TVS/Proposition_classe_voter.md)

