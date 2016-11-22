import java.util.Scanner;
import java.util.Vector;
import java.lang.Boolean;  
import java.lang.Object;
import java.util.AbstractCollection;
import java.util.AbstractList;
//import java.sql.Connection;		//pour plus tard
//import java.sql.DriverManager;	//pour plus tard
import java.io.File;				//pour la simulation de bdd

import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileWriter ;

import java.lang.Throwable;
import java.lang.Exception;
import java.io.IOException;
import java.io.FileNotFoundException;







class Liste
{
	private int idliste; 							//id
	private String nomliste; 						//nom
	private int idauthor;							//id auteur
	protected Vector<Question>listequestion;		//vecteur question
	//Connection connection;						// Connection //pour plus tard
	
	/*debut getter setter*/
	
	public int getIdListe()
	{
		return this.idliste;
	}
	
	public String getNomListe()
	{
		return this.nomliste;
	}
	
	public int getIdAuthor()
	{
	return this.idauthor;
	}
	
	public Vector getListeQuestion()
	{
		return this.listequestion;
	}


	
	public void setIdListe(int idliste)
	{
		this.idliste = idliste;
	}
	
	public void setNomListe(String nomliste)
	{
		this.nomliste = nomliste;
	}
	
	public void setIdAuthor(int idauthor)
	{
		this.idauthor = idauthor;
	}
	
	public void setListeQuestion(Vector listequestion)
	{
		this.listequestion = listequestion;
	}
	
	/* fin getter setter*/
	
	/* debut main */
	
	public static void main (String [] arg)      //main de test
	{          
		
	}
	
	/* fin main */
	
	/* debut creation Liste */
	
	public Boolean creatListe()
	{
		return false;
	}
	/* debut creation Liste */
	
	/* debut supression Liste */
	
	public Boolean suprListe()
	{
		return false;
	}	
	
	/* debut supression Liste */
	
	/* debut modication Liste */
	public Boolean modifListeNom(int id)
	{
		System.out.println("entrer le nouveau nom");		//sera normalement modifier a la fusion avec l'interface
		Scanner keyboard = new Scanner(System.in);
		String nom = keyboard.nextLine();
		
	/*lecture ecriture dans un fichier , sera remplacer par une requete sql quand la bdd sera implementé*/
	
		File f = new File ("/liste.txt");
		File f2 = new File ("/listetemp.txt");
		try 
		{
			Scanner scan = new Scanner(f);
			FileWriter fw = new FileWriter (f2);
			
			while (scan.hasNextLine()) 
			{
				String line = scan.nextLine();
				
				String word[]  = line.split("/");
				int y = Integer.parseInt(word[0]);
				
				if (y == id)
				{
					word[1]=nom;
					String nline = word[0]+"/"+word[1]+"/"+word[2];
					fw.write (nline);
        			fw.write ("\r\n");
				}
				else
				{
					fw.write (line);
        			fw.write ("\r\n");
				}
			
				System.out.println(line);
			}
			scan.close();
    		fw.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	/*fin de lecture ecriture*/	
	//commande sql prevue :
	//
	//select * from Liste_Metadata where ID_Liste=id
	//statement.executeQuery( "select * from Liste_Metadata where ID_Liste=id;" );
	//statement.executeUpdate( "INSERT INTO Utilisateur (email, mot_de_passe, nom, date_inscription) VALUES ('jmarc@mail.fr', MD5('lavieestbelle78'), 'jean-marc', NOW());" );
		return false;
	}
	
	public Boolean modifListeAjoutQuestion()
	{
		System.out.println("entrer l'id de la question a rajouter");	//sera normalement modifier a la fusion avec l'interface
		Scanner keyboard = new Scanner(System.in);
		int idq = keyboard.nextInt();
	/*ecriture dans un fichier , sera remplacer par une requete sql quand la bdd sera implementé*/
	
	File f = new File ("/listedata.txt");
	try 
	{
		FileWriter fw = new FileWriter (f);
		String line = String.valueOf(idliste)+"/"+String.valueOf(idq);
		fw.write (line);
        fw.write ("\r\n");
    	fw.close();	
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
		return false;
	} 
	/****************************************************************************************/	
		
	}
	public Boolean modifListeSuppressionQuestion()
	{
		System.out.println("entrer l'id de la question a retirer");	//sera normalement modifier a la fusion avec l'interface
		Scanner keyboard = new Scanner(System.in);
		int idq = keyboard.nextInt();
		return false;
	}
	/* debut modication Liste */
	
}
