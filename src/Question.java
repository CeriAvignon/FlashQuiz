
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

	public class Question
	{
		//*********************Variable & Methode pour Ajout Question**************
		static Integer filetype;//Représente le type du media, Prend 0 dans la BDD si le fichier et une image et 1 si c'est une vidéo 
    		static String filename;//Représente le nom du fichier, le nom est toujours l'ID de la question plus le type du fichier - ex: 20.png
		static Integer IdQ;
		static Integer IdM;
	
		Question() {
			filename=null;
			filetype=null;
		}
	
                //Méthode pour définir les ID à utiliser l'or de l'insertion des nouvelles lignes dans les tables Question, Reponse et Media.
		public void DefineLastId() throws ClassNotFoundException, SQLException{
			int idq=0,idm=0;
			PreparedStatement st1 = con.prepareStatement("select max(q.ID_Question), max(m.ID_Media) from Question q, Media m;");
			ResultSet result1 = st1.executeQuery();
     			while(result1.next()) {
  	 			idq=result1.getInt(1);
  	 			idm=result1.getInt(2);
    			}
     			IdQ=idq+1;
     			IdM=idm+1;
		}
		//Méthode permettant de récupérer les informations sur la question et les insérer dans la table Question.
		//la méthode prend en arguments l'id de la nouvelle ligne, le contenu de la question, le type, l'id Media, 
		//l'argument med permet de savoir si la question possèdera un media, 
		//si non la colonne idMedia dans la table question prendra la valeur 0 si oui elle prendra la valeur de l'idMedia.
		public void InsertQuestion(int IdQuestion,String QuestConten, String QuestType,int IdMedia,Boolean med)throws ClassNotFoundException, SQLException {
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
		
		//Méthode permettant de traiter les réponses par rapport au type de la question et les insérer.
		//La méthode prend en argument l'id de la question, le nombre de réponses qu'aura la question.
		//la réponses si la question a une seule réponse sinon la variable « reponse » aura une valeur null.
		//un tableau de réponses si la question a plusieurs réponses sinon le tableau sera vide.
		public void InsertReponse(int IdQuestion,int NbrR,String reponse,String [][]Reponse) throws ClassNotFoundException, SQLException{
			boolean correct=true;
			Integer IdReponse=0;
			PreparedStatement st4 =con.prepareStatement("Insert into Reponses values(?,?,?,?);");
			st4.setInt(2, IdQuestion);
			for(int j=0;j<NbrR;j++) {
				if(NbrR==1) {
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
		//Méthode permettant l'Upload d'un fichier dans un dossier "..\\flachquiz\\media\\" où on trouve un dossier "img" pour les Images et "vdo" pour les vidéos.
		//Pour l'instant il manque l'upload de vidéo.
		//La méthode prend en arguments l'id de la question et l'url qui permettra de lire le fichier à utiliser.
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
    			f = new File("..\\flachquiz\\media\\img\\"+filename);  
    			ImageIO.write(image, extension, f);
    			filetype=0;
		}
		//Méthode permettant l'upload des informations concernant les medias
		//La méthode prend en arguments l'id du media, le type, et le nom
		public void InserMediaDb(int IdMedia,int filetype, String filename) throws ClassNotFoundException, SQLException {
			PreparedStatement st5 = con.prepareStatement("Insert into Media values(?,?,?);");
			st5.setInt(1, IdMedia);
			st5.setInt(2, filetype);
			st5.setString(3, filename);
			st5.executeUpdate();
		}
		
		//*********************Variable & Methode pour Modifier & Supprimer Question**************
		static Connexion ab = Connexion.getInst();

	public static void modifiertype(int question, String type) {
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
	public static void modifierMedia(int question, int media) {
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
	public static void modifierContenu(int question, String contenu) {
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

	public static void modifierReponse(int question, ArrayList<String> rep, String RepV) {
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
					pr.setInt(2, question);
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
    public static void ModifierQuestion(int quest,String type, ArrayList<String> rep, String RepV,String Contenu,int media){
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
    public static void SupprimerQuestion(int quest){
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

				
	}
