
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

	public class Question
	{
		//*********************Variable & Methode pour Ajout Question**************
		static Connection con;
		static Integer filetype;
    		static String filename;
	
	
		Question() {
			filename=null;
			filetype=null;
		}
	
		public void dataBaseConnexion()throws ClassNotFoundException, SQLException {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/flashquiz";
			String user = "postgres";
			String passwd = "***********";
			con = DriverManager.getConnection(url, user, passwd);
		}

		public int DefineLastIdQuestion() throws ClassNotFoundException, SQLException{
			int res1=0;
			PreparedStatement st1 = con.prepareStatement("select max(ID_Question) from Question;");
			ResultSet result1 = st1.executeQuery();
     			while(result1.next()) {
  	 			res1=result1.getInt(1);
     			}
     			return res1+1;
		}

		public int DefineLastIdMedia() throws ClassNotFoundException, SQLException{
			int res2=0;
			PreparedStatement st2 = con.prepareStatement("select max(ID_Media) from Media;");
			ResultSet result2 = st2.executeQuery();
     			while(result2.next()) {
  	 			res2=result2.getInt(1);
    			}
			return res2+1;
		}

		public void InsertQuestion(int IdQuestion,String QuestConten, String QuestType,int IdMedia,String filelink)throws ClassNotFoundException, SQLException {
			PreparedStatement st3 = con.prepareStatement("Insert into Question values(?,?,?,?);");
			st3.setInt(1, IdQuestion);
			st3.setString(2, QuestType);
			st3.setString(3, QuestConten);
			if(filelink==null) {
				st3.setInt(4,0);
			}
			else {
				st3.setInt(4, IdMedia);
			}
			st3.executeUpdate();	
		}

		public void InsertReponse(int IdQuestion,int NbrQ,String reponse,String [][]Reponse) throws ClassNotFoundException, SQLException{
			boolean correct=true;
			Integer IdReponse=0;
			PreparedStatement st4 =con.prepareStatement("Insert into Reponses values(?,?,?,?);");
			st4.setInt(2, IdQuestion);
			for(int j=0;j<NbrQ;j++) {
				if(NbrQ==1) {
					st4.setString(3, reponse);
				}
				else{
					st4.setString(3, Reponse[j][0]);
					Reponse[j][1].toLowerCase();
					correct = Boolean.valueOf(Reponse[j][1]).booleanValue() ;
				}
				st4.setBoolean(4, correct);
				st4.setInt(1, IdReponse);
				st4.executeUpdate();
				IdReponse++;
			}
		}
		
		public void InsertMediaFile(int IdQuestion,String filelink) throws ClassNotFoundException, Exception{
			BufferedImage image = null;
    			File f = null;
    			String extension=null;
    			//********* file reading 
    			int width = 963;    
    			int height = 640;   
    			extension=filelink.substring(filelink.length()-3);
    			f = new File(filelink);
    			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    			image = ImageIO.read(f);
    			//********* file writing
    			filename=IdQuestion+"."+extension;
    			f = new File("..\\flachquiz\\src\\media\\"+filename);  
    			ImageIO.write(image, extension, f);
    			filetype=0;
		}
		
		public void InserMediaDb(int IdMedia,int filetype, String filename) throws ClassNotFoundException, SQLException {
			PreparedStatement st5 = con.prepareStatement("Insert into Media values(?,?,?);");
			st5.setInt(1, IdMedia);
			st5.setInt(2, filetype);
			st5.setString(3, filename);
			st5.executeUpdate();
		}
		
		//*********************Variable & Methode pour Modifier & Supprimer Question**************
		static Connexion ab = Connexion.getInst();

	public static void modifiertype(String question, String type) {
		String requete = null;

		try {
			requete = "UPDATE question SET type = '" + type + "'" + "WHERE id_question = '" + question + "'";
			Statement state = ab.a().createStatement();
			state.executeUpdate(requete);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Modification non effectué", "ALERTE", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	public static void modifierMedia(String question, String media) {
		String requete = null;

		try {
			requete = "UPDATE question SET id_media = '" + media + "'" + "WHERE id_question = '" + question + "'";
			Statement state = ab.a().createStatement();
			state.executeUpdate(requete);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Modification non effectué", "ALERTE", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	public static void modifierContenu(String question, String contenu) {
		String requete = null;

		try {
			requete = "UPDATE question SET contenu = '" + contenu + "'" + "WHERE id_question = '" + question + "'";
			Statement state = ab.a().createStatement();
			state.executeUpdate(requete);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Modification non effectué", "ALERTE", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public static void modifierReponse(String question, ArrayList<String> rep, String RepV) {
		String requete = null;
		int max = max();

		try {
			requete = "DELETE FROM reponses " + "WHERE Id_quest =" + question;
			Statement state = ab.a().createStatement();
			state.executeUpdate(requete);

			for (int i = 0; i < rep.size(); i++) {
				String correcte = "false";
				String contenu = rep.get(i).toString();
				if (contenu.equals(RepV)) {
					correcte = "true";
				}
				try {

					PreparedStatement pr = (PreparedStatement) ab.a()
							.prepareStatement("INSERT INTO reponses VALUES(?,?,?,?)");
					pr.setInt(1, max + i + 1);
					pr.setString(2, question);
					pr.setString(3, contenu);
					pr.setString(4, correcte);

					pr.execute();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Modification non effectué", "ALERTE", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public static int max() {
		int maxID = 0;
		Statement s2;
		try {
			s2 = ab.a().createStatement();
			s2.execute("SELECT MAX(Id_rep) FROM reponses");
			ResultSet rs2 = s2.getResultSet(); //
			if (rs2.next()) {
				maxID = rs2.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxID;

	}
    public static void ModifierQuestion(String quest,String type, ArrayList<String> rep, String RepV,String Contenu,String media){
    	if(type!=null){
    		modifiertype(quest,type);
    		
    	}
    	if(rep!=null && RepV!=null){
    		modifierReponse(quest, rep, RepV); 
    	}
    	if(Contenu !=null){
    		modifierContenu(quest,Contenu);
    	}
    	if(media !=null){
    		modifierMedia(quest,media);
    	}
    	
    	
    }
    public static void SupprimerQuestion(String quest){
    	String requete = null;
    	try {
    		
    	
			requete = "DELETE FROM reponses " + "WHERE Id_quest =" + quest;
			Statement state = ab.a().createStatement();
			state.executeUpdate(requete);
    	}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Modification non effectué", "ALERTE", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
    	try {
    		
        	
			requete = "DELETE FROM question " + "WHERE Id_question =" + quest;
			Statement state = ab.a().createStatement();
			state.executeUpdate(requete);
    	}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Modification non effectué", "ALERTE", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
    	
    }

				//***************************** Main() ***************************
		
		public static void main(String[] args) throws ClassNotFoundException, Exception {
			Question NewQuestion= new Question();
			Scanner sc = new Scanner(System.in);
			//**************DATA BASE CONNEXION***************
	 		NewQuestion.DataBaseConnexion();
			//************************************************
    			int IdQ=NewQuestion.DefineLastIdQuestion();
    			int IdM=NewQuestion.DefineLastIdMedia();
			//************************************************
			System.out.println("\nEnoncé de question: ");
			String QConten= sc.nextLine();
			System.out.println("\n1.Radio:          2.Text libre:          3.TextBox:");
			System.out.println("\nType de question : ");
			Integer QTyp= sc.nextInt();
			String QType=null;
			//*****************************************
			switch (QTyp) {
				case 1 :QType="Radio";	        	break;
				case 2 :QType="Text libre";		    break;
				case 3 :QType="TextBox";			break;
			}
			//******************************************
	 		String rep=null;
	 		String [][] Rep=null;;
	 		Integer NbrQ=1;
			if(QType.equals("Text libre")) {
        			System.out.println("\nCorrect Answer : ");
        			rep= sc.next();;
			}
			else if (QType.equals("Radio") || QType.equals("TextBox")) {
				System.out.println("\nNombre de reponses proposées: ");
		 		NbrQ= sc.nextInt();
		 		Rep=new String[NbrQ][2];
				for(int i=1;i<=NbrQ;i++) {
		   			System.out.println("\nRéponse "+i+" : ");
		    			Rep[i-1][0]= sc.next();
		    			System.out.println("\nIs it True or False ?");
		    			Rep[i-1][1]=sc.next();
				}
			}
			//******************************************
    			NewQuestion.InsertReponse(IdQ,NbrQ,rep,Rep);
			//******************************************
			System.out.println("Voulez-vous ajouter une Image? ");
			String res=sc.next();
			res.toLowerCase();
			String filelink=null;
			if(res.equals("oui")) {
		 		filelink="E:\\images\\New folder\\new.png"; //Reste à définir
				NewQuestion.InsertMediaFile(IdQ,filelink);
				NewQuestion.InserMediaDb(IdM,NewQuestion.filetype,NewQuestion.filename);
			}
 			sc.close();
			//*****************************************
	  		NewQuestion.InsertQuestion(IdQ,QConten,QType,IdM,filelink);
		}
	}
