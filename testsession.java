//package session;			// Package session liée a EL --> Package \author :@LE VEVE Mathieu
import java.util.Scanner;		// Saisie clavier: Scanner keyboard = new Scanner (...)
import java.util.Vector;		// Création <vector> question / <vector> liste
import java.sql.Connection;		// Connection connection = new Connection (...)
import java.sql.DriverManager;		// Accès pour la BDD
import java.io.File;			// pour la simulation de bdd --> Phases de tests par lecture/ écriture
//import connexionjm.ConnexionJM;		// Package liée à la BDD --> Package \author :@HUOT AMAURY
import java.lang.*;
/*! 
*	\file testsession.java
*	\brief Fichier java testsession
*	\author {Le Veve Mathieu}
*	\date 22/11/2016
*
*	\brief	Fichier <main> en java qui test la création de session sur console (sans BDD) testée au fur et à mesure 
de l'implémentation.
*/

public class test{

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Voulez vous créer une session? Please y/n");
		String tmp = keyboard.nextLine();
		char c = tmp.charAt(0);
		if (c == 'y' || c == 'Y')
		{
			System.out.println("Veuillez saisir un nom de session");
			String name = keyboard.nextLine();
			System.out.println("Veuillez saisir une date de début de session (format xx/xx/xxxx)");
			String datedebut = keyboard.nextLine();
			System.out.println("Veuillez saisir une date de fin de session (format xx/xx/xxxx)");
			String datefin = keyboard.nextLine();
			Session A = new Session(name, datedebut, datefin);	
			A.printSession();
		}

		else System.exit(0);
	

	}
}
