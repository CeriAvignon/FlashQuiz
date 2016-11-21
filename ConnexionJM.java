package connexionjm;
import java.sql.*;
public class ConnexionJM {

    public static void main(String[] args) 
    {
       try
       {
         Connection cnx=connecterDB();
         Statement st;
         ResultSet rst;
         st.cnx=createStatement();
         rst=st.executeQuery("SELECT *FROM");
         
         while(rst.next())
         {
             System.out.print(rst.getInt("id")); //getINt car id = int et id = namecolonne
             System.out.print(rst.getX("X"));//recup data bdd à voir selon la bdd      
         }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    public static Connection connecterDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            String url="jdbc:mysql://localhost:5631";
            String username="root";
            String password="root";
            Connection cnx=DriverManager.getConnection(url,username,password);
            System.out.println("Connexion etablished");
            return cnx;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
