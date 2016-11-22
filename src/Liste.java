import java.util.Scanner;
import java.util.Vector;
//import java.sql.Connection;		//pour plus tard
//import java.sql.DriverManager;	//pour plus tard
import java.io.File;			//pour la simulation de bdd

class Liste
{
	private int idliste; 			//id
	private String nomliste; 		//nom
	private int idauthor;			//id auteur
	protected vector(question);		//vecteur question
	protected int nbrquestion;		// Nombre de questions
	//Connection connection;		// Connection //pour plus tard
	
	/*debut getter setter*/
	
	public int getIdListe()
	{
		return this.idListe;
	}
	
	public String getNomListe()
	{
		return this.nomliste;
	}
	
	public int getIdAuthor()
	{
	return this.idauthor;
	}
	
	public Vector getQuestion()
	{
		return this.question;
	}

	public int getNbrQuestion()
	{
		return this.nbrquestion;
	}
	
	
	public void setIdListe(int idListe)
	{
		this.idListe = idListe;
	}
	
	public void setNomListe(String nomliste)
	{
		this.nomliste = nomliste;
	}
	
	public void setIdAuthor(int idauthor)
	{
		this.idauthor = idauthor;
	}
	
	public void setListe(Vector liste)
	{
		this.liste = liste;
	}
	
	public void setQuestion(Vector question)
	{
		this.question = question;
	}
	
	public void setNbrQuestion(int nbrquestion)
	{
		this.nbrquestion = nbrquestion;
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
