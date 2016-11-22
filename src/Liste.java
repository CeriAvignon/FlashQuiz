import java.util.Scanner;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;			//pour la simulation de bdd
import java.util.Scanner; 

class Serie
{
	private int idliste; 			//id
	private String nomliste; 		//nom
	private int iduser;			//id auteur
	protected vector(question);		//vecteur question
	protected int nbrquestion;		// Nombre de questions
	Connection connection;			// Connection
		
	public bool creatListe()
	{
		
	}
	public bool suprListe()
	{
		
	}	
	/* debut modication Liste */
	public bool modifListeNom()
	{
		System.out.println("entrer le nouveau nom");
		Scanner keyboard = new Scanner(System.in);
		String nom = keyboard.nextLine();
		
	}
	public bool modifListeAjoutQuestion()
	{
		
	}
	public bool modifListeSuppressionQuestion()
	{
		
	}
	/* debut modication Liste */
	
}
