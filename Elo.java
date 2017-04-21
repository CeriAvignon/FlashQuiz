/*
	Le classement devrait se faire avec un nombre de points attribués à chaque joueurs. Ils partiraient tous avec la même base de points (ex 1000 pts de départ), pour chaque question une valeur de difficulté est attribué (selon une échelle à définir, exemple 1 facile, ... 5 difficile) selon la difficulté et la vitesse de réponse l'utilisateur gagne un certain nombre de points (exemple question à 5 de difficulté répondu en 5 secondes on utilisera un algorithme du genre :
	int calculDePoints(int difficulte,int temps)
	{
		int dif = (100 + difficulte) / 100;
		int temp = (100 + temps) / 100;
		this.points = dif * temp * this.points;
		return points;
	}
*/
