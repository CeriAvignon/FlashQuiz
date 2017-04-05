import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
/*
   @author Amaury Huot
*/
public class ConnexionJav 
{
   public static void Connexion(String s) //prend une string en argument qui se trouve être la commande à exécuter,:void:
   {
       Connection c = null;//connection object
       Statement stmt = null;//statement object (handle query)
       try {
       Class.forName("org.postgresql.Driver");//call jdbc dll
         c = DriverManager.getConnection("jdbc:postgresql://pedago.univ-avignon.fr/flashquiz", "flashquiz", "FiBZJ2DA");//logs
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");//check message

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery(s);
 
         rs.close(); //once the query is executed , close
         stmt.close();//statement erase
         c.close();//close connection
       } catch ( Exception e ) { //gestion erreur
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);//rage quit
       }
       System.out.println("Operation done successfully");//if the operation went right display this message 
   }
   public static void main(String args[])
     {
        /*
         Basic main to execute the connexion function
         get a user input as string
        */
        String str;
        str="";
        Scanner sc = new Scanner(System.in);
        str=sc.nextLine();
        Connexion(str);
     }
}
