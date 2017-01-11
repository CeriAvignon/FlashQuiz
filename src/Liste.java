import java.util.Scanner;
import java.util.Vector;
import java.lang.Boolean;  
import java.lang.Object;
import java.util.AbstractCollection;
import java.util.AbstractList;

import java.io.File;				//pour la simulation de bdd

import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileWriter ;

import java.lang.Throwable;
import java.lang.Exception;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


class Liste
{
	private int idliste; 							//id
	private String nomliste; 						//nom
	private int idauthor;							//id auteur
	protected Vector<Question>listequestion;		//vecteur question
	static Connection con;
	static Integer IdQuestion;
	static Integer IdListe;
	static String TitreListe;
	static Integer IdUser;
	
	/**
* getter de l'atribut idliste
*
* @author BrunoDemogue
* @return retourne la valeur de l'atribut idliste
*/
	
	public int getIdListe()
	{
		return this.idliste;
	}
	
/**
* getter de l'atribut nomliste
*
* @author BrunoDemogue
* @return retourne la valeur de l'atribut nomliste
*/
	public String getNomListe()
	{
		return this.nomliste;
	}
	
/**
* getter de l'atribut idauthor
*
* @author BrunoDemogue
* @return retourne la valeur de l'atribut idauthor
*/

	public int getIdAuthor()
	{
	return this.idauthor;
	}
		
/**
* getter de l'atribut listequestion
*
* @author BrunoDemogue
* @return retourne la valeur de l'atribut listequestion
*/
	public Vector getListeQuestion()
	{
		return this.listequestion;
	}
	
/**
* setter de l'atribut idliste
*
* @author BrunoDemogue
* @param idliste = valeur a atribuer
*/
	public void setIdListe(int idliste)
	{
		this.idliste = idliste;
	}
	
/**
* setter de l'atribut nomliste
*
* @author BrunoDemogue
* @param nomliste = valeur a atribuer
*/

	public void setNomListe(String nomliste)
	{
		this.nomliste = nomliste;
	}
		
/**
* setter de l'atribut idauthor
*
* @author BrunoDemogue
* @param idauthor = valeur a atribuer
*/
	public void setIdAuthor(int idauthor)
	{
		this.idauthor = idauthor;
	}
		
/**
* setter de l'atribut listequestion
*
* @author BrunoDemogue
* @param idauthor = valeur a atribuer
*/
	public void setListeQuestion(Vector listequestion)
	{
		this.listequestion = listequestion;
	}
/**
* Main de test des fonction de modification de liste
*
* @author BrunoDemogu
*/
	public static void main (String [] arg)     
	{          
		
		modifListeAjoutQuestion(2);
		modifListeAjoutQuestion(6);
		modifListeAjoutQuestion(10);
		
		modifListeNom(2);
		modifListeNom(6);
		modifListeNom(10);

		modifListeSuppressionQuestion(2);
		modifListeSuppressionQuestion(6);
		modifListeSuppressionQuestion(10);	
	}
	
	public Boolean creatListe()
	{
		return false;
	}
	
	public Boolean suprListe()
	{
		return false;
	}	
	
	/**
* Fonction de modification du nom d'une liste
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
* @return retourne false en cas d'erreur, true si tout c'est bien deroulé
*/

	public static Boolean modifListeNom(int idl)
	{
		System.out.println("entrer le nouveau nom de la liste "+idl);	
		Scanner keyboard = new Scanner(System.in);
		String nom = keyboard.nextLine();
		
		File f = new File ("Liste.txt");
		File f2 = new File ("Listetemp.txt");
		try 
		{
			Scanner scan = new Scanner(f);
			try
			{
				FileWriter fw = new FileWriter (f2);
  				while (scan.hasNextLine()) 
				{
					String line = scan.nextLine();
				
					String word[]  = line.split("/");
					int y = Integer.parseInt(word[0]);
				
					if (y == idl)
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
			
				}
				scan.close();
    			fw.close();
    		}
			catch(IOException e)
			{
  				e.printStackTrace();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 

		try 
		{
			Scanner scan = new Scanner(f2);
			try
			{
				FileWriter fw = new FileWriter (f);
  				while (scan.hasNextLine()) 
				{
					String line = scan.nextLine();
					fw.write (line);
        			fw.write ("\r\n");
				}
				scan.close();
    			fw.close();
    		}
			catch(IOException e)
			{
  				e.printStackTrace();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
	
		return false;
	}
	
	

/**
* Fonction d'ajout de question a une liste 
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
* @return retourne false en cas d'erreur, true si tout c'est bien deroulé
*/
	public static Boolean modifListeAjoutQuestion(int idl)
	{
		System.out.println("entrer l'id de la question a rajouter a la liste "+idl);
		Scanner keyboard = new Scanner(System.in);
		int idq = keyboard.nextInt();

	
		File f = new File ("listedata.txt");
		try 
		{
			FileWriter fw = new FileWriter (f,true);
			String line = String.valueOf(idl)+"/"+String.valueOf(idq);
			fw.write (line);
  	      	fw.write ("\r\n");
  		  	fw.close();	
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
	
		
			return false;
	}

/**
* Fonction de supression de question d'une liste 
*
* @author BrunoDemogue
* @param idl= id de la liste a modifier
* @return retourne false en cas d'erreur, true si tout c'est bien deroulé
*/
	public static Boolean modifListeSuppressionQuestion(int idl)
	{
		System.out.println("entrer l'id de la question a retirer de la liste "+idl);
		Scanner keyboard = new Scanner(System.in);
		int idq = keyboard.nextInt();

		File f = new File ("listedata.txt");
		File f2 = new File ("listedatatemp.txt");
		try 
		{
			Scanner scan = new Scanner(f);
			try
			{
				FileWriter fw = new FileWriter (f2);
  				while (scan.hasNextLine()) 
				{
					String line = scan.nextLine();
					String word[]  = line.split("/");
					int y = Integer.parseInt(word[0]);
					int y2 = Integer.parseInt(word[1]);
					if (y == idl)
					{
						if (y2 == idq)
						{
						}
						else
						{
							fw.write (line);
        					fw.write ("\r\n");
        				}
					}
					else
					{
						fw.write (line);
        				fw.write ("\r\n");
					}
				}
				scan.close();
    			fw.close();
    		}
			catch(IOException e)
			{
  				e.printStackTrace();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		try 
		{
			Scanner scan = new Scanner(f2);
			try
			{
				FileWriter fw = new FileWriter (f);
  				while (scan.hasNextLine()) 
				{
					String line = scan.nextLine();
					fw.write (line);
        			fw.write ("\r\n");
				}
				scan.close();
    			fw.close();
    		}
			catch(IOException e)
			{
  				e.printStackTrace();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		return false;
	}
	
}
//******************************************************
static Connection con;
	static Integer IdQuestion;
	static Integer IdListe;
	static String TitreListe;
	static Integer IdUser;

	void Liste() {
		this.IdListe=0;
		this.IdQuestion=0;
		this.IdUser=999;
		this.TitreListe=null;
		}
	void Liste(int a, int b, String c)  {
		this.IdListe=a;
		this.IdUser=b;
		this.TitreListe=c;
		}
	void Liste(int a) {
		this.IdQuestion=a;
	 	}
	public void dataBaseConnexion()throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/quiz";
		String user = "postgres";
		String passwd = "*********";
		con = DriverManager.getConnection(url, user, passwd);
		}
public Integer defineLastIdListe() throws ClassNotFoundException, SQLException{
		int idList=0;
		PreparedStatement statement = con.prepareStatement("select max(IdListe) from  ListMetadata;");
		ResultSet resultset = statement.executeQuery(); 
		while(resultset.next()) {
	  	 IdList=resultset.getInt(1);
		}
		return IdListe=IdList+1;
		}
	public void insertListMetadata() throws ClassNotFoundException, SQLException{
		PreparedStatement statement2 = con.prepareStatement("Insert into ListMetadata values(?,?,?);");
		statement2.setInt(1, IdListe);
		statement2.setInt(2, IdUser);
		statement2.setString(3,TitreListe);
		statement2.executeUpdate();
		}
	public void insertListContent() throws ClassNotFoundException, SQLException{
		PreparedStatement statement3 = con.prepareStatement("Insert into ListContent values(?,?);");
		statement3.setInt(1, IdListe);
		statement3.setInt(2, IdQuestion);
		statement3.executeUpdate();
		}
			//**********************Main*********************
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Liste NewListe= new Liste();
	NewListe.dataBaseConnexion();
    int LId=NewListe.defineLastIdListe();
    
        Scanner scanner = new Scanner(System.in);
	System.out.println("\nTitre de la Liste: ");
	String TitreL= scanner.nextLine();
	NewListe.Liste(Lid,999,TitreL);
	NewListe.insertListMetadata();
	
	System.out.println("\nVoulez vous ajouter des questions à cette liste ?");
	String reponse= scanner.next();
	
	if(reponse.equals("oui")) {
		System.out.println("\nCombien de question : ");
		Integer nbr=scanner.nextInt();
		for(int i=0;i<nbr;i++) {
		System.out.println("\nID de la question : ");
		Integer IdQ=scanner.nextInt();
		NewListe.Liste(IdQ);
		NewListe.insertListContent();
		}
	}
}
}
