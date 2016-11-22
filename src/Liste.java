import java.util.Scanner;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;			//pour la simulation de bdd

class Liste
{
	private int idliste; 			//id
	private String nomliste; 		//nom
	private int iduser;			//id auteur
	protected vector(question);		//vecteur question
	protected int nbrquestion;		// Nombre de questions
	Connection connection;			// Connection
	
	/*debut getter setter*/
	
	
	public int getIdSession()
	{
		return this.idsession;
	}
	
	public String getSession()
	{
		return this.session;
	}
	
	public int getIdAuthor()
	{
	return this.idauthor;
	}
	
	public Vector getListe()
	{
		return this.liste;
	}
	
	public Vector getQuestion()
	{
		return this.question;
	}

	public string getDatedebut()
	{
		return this.datedebut;
	}
	
	public string getDatefin()
	{
		return this.datefin;
	}
	/* fin getter setter*/
	
	/* debut main */
	
	public static void main (String [] arg)      //main de test
	{          
		
	}
	
	/* fin main */
	
	/* debut creation Liste */
	
	public bool creatListe()
	{
		
	}
	/* debut creation Liste */
	
	/* debut supression Liste */
	
	public bool suprListe()
	{
		
	}	
	
	/* debut supression Liste */
	
	/* debut modication Liste */
	public bool modifListeNom(int id)
	{
		System.out.println("entrer le nouveau nom");		//sera normalement modifier a la fusion avec l'interface
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
