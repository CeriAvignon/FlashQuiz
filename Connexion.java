import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ConnexionJav 
{
   public static void Connexion(String s) //prend une string en argument qui se trouve être la commande
   {
       Connection c = null;
       Statement stmt = null;
       try {
       Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection("jdbc:postgresql://pedago.univ-avignon.fr/flashquiz", "flashquiz", "FiBZJ2DA");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery(s);
 
         rs.close();
         stmt.close();
         c.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
       }
       System.out.println("Operation done successfully");
   }
   public static void main(String args[])
     {
         
        String str;
        str="";
        Scanner sc = new Scanner(System.in);
        str=sc.nextLine();
        Connexion(str);
     }
}
