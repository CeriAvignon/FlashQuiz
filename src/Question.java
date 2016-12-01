
import java.sql.Connection;//
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

	public class Question
	{
		//*********************Variable & Methode pour Ajout Question**************
		static Integer NbrQ=1;
		static Connection con;
		static Integer IdQuestion;
		static String QuestConten;
		static String QuestType;
		static Integer IdMedia;
		static Integer IdReponse;
		static String reponse;
		static String [][] Reponse;
		static boolean correct;
	
	
	
		void Question() {
			this.IdQuestion=0;
			this.QuestConten=null;
			this.QuestType=null;
			this.IdMedia=0;
			this.IdReponse=0;
			this.reponse=null;
			this.Reponse=new String[0][0];
			this.correct=true;
		}
	
		void Question(int a,String b,String c,int d) {
			this.IdQuestion=a;
			this.QuestConten=b;
			this.QuestType=c;
			this.IdMedia=d;
			this.IdReponse=0;
			this.correct=true;
		}
	
		void Question(String [][]tab){
			this.Reponse = (String[][]) tab.clone();
		}
	
		void Question(String r){
			this.reponse=r;
		}
	
		public void dataBaseConnexion()throws ClassNotFoundException, SQLException {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/quiz";
			String user = "postgres";
			String passwd = "DutDaiDutDai00";
			con = DriverManager.getConnection(url, user, passwd);
		}

		public Integer defineLastIdQuestion() throws ClassNotFoundException, SQLException{
			int res2=0;
			PreparedStatement st2 = con.prepareStatement("select max(ID_Question) from Question;");
			ResultSet result2 = st2.executeQuery();
     			while(result2.next()) {
  	 			res2=result2.getInt(1);
    		 	}
     			return IdQuestion=res2+1;
		}

		public Integer defineLastIdMedia() throws ClassNotFoundException, SQLException{
			int res3=0;
			PreparedStatement st3 = con.prepareStatement("select max(ID_Media) from Media;");
			ResultSet result3 = st3.executeQuery();
    			 while(result3.next()) {
  	 			res3=result3.getInt(1);
     			}
			return IdMedia=res3+1;
		}

		public void insertQuestion()throws ClassNotFoundException, SQLException {
	
			PreparedStatement st1 = con.prepareStatement("Insert into Question values(?,?,?,?);");
			st1.setInt(1, IdQuestion);
			st1.setString(2, QuestType);
			st1.setString(3, QuestConten);
			st1.setInt(4, IdMedia);
			st1.executeUpdate();
		
		}

		public void insertReponse() throws ClassNotFoundException, SQLException{

			PreparedStatement st6 =con.prepareStatement("Insert into Reponses values(?,?,?,?);");
			st6.setInt(2, IdQuestion);
			
			for(int j=0;j<NbrQ;j++) {
				if(NbrQ==1) {
				st6.setString(3, reponse);
				}
				else{
			
			st6.setString(3, Reponse[j][0]);
			Reponse[j][1].toLowerCase();
			correct = Boolean.valueOf(Reponse[j][1]).booleanValue() ;
			}
			st6.setBoolean(4, correct);
			st6.setInt(1, IdReponse);
			st6.executeUpdate();
			IdReponse++;
			}
		
	
		}
	//***************************** Main() ***************************	
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Question NewQuestion= new Question();
			Scanner sc = new Scanner(System.in);
	
	
			System.out.println("\nEnoncé de question: ");
			String QConten= sc.nextLine();
			System.out.println("\n1.Radio:          2.Text libre:          3.TextBox:");
			System.out.println("\nType de question : ");
			Integer QTyp= sc.nextInt();
			String QType=null;
			//*****************************************
			switch (QTyp) {
				case 1 :QType="Radio";	        	break;
				case 2 :QType="Text libre";		break;
				case 3 :QType="TextBox";		break;
			}
			//******************************************
	 		String rep=null;
			if(QType.equals("Text libre")) {
        			System.out.println("\nCorrect Answer : ");
        			rep= sc.next();
        			NewQuestion.Question(rep);
			}
	
	
			if (QType.equals("Radio") || QType.equals("TextBox")) {

				System.out.println("\nNombre de reponses proposées: ");
				NbrQ= sc.nextInt();
		 		String [][] Rep=new String[NbrQ][2];
				for(int i=1;i<=NbrQ;i++) {
		    			System.out.println("\nRéponse "+i+" : ");
		    			Rep[i-1][0]= sc.next();
		    			System.out.println("\nIs it True or False ?");
		    			Rep[i-1][1]=sc.next();
				}
	  		NewQuestion.Question(Rep);
			}
		
			//**************DATA BASE CONNEXION***************
	 		 NewQuestion.DataBaseConnexion();
			//************************************************
      			int Q_id=NewQuestion.defineLastIdQuestion();
      			int M_id=NewQuestion.defineLastIdMedia();
	 		NewQuestion.question(Q_id,QConten,QType,M_id);
	  		NewQuestion.insertQuestion();
	  		NewQuestion.insertReponse();
		}

	}
