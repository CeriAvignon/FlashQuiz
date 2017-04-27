package controller;
import model.base.*;
import resbdd.*; // nom_package.nom_class
public class ActionMedia {

	int nbr_media = 0;
	Media media[] = new Media[2];

	public void initialiser_media() {
		media[0] = new Media();
		media[0].id = 0;
		media[0].contenu = "url1";
		media[0].type = "video";
		nbr_media++;
		media[1] = new Media();
		media[1].id = 1;
		media[1].contenu = "url";
		media[1].type = "image";
		nbr_media++;

	}

	public void Afficher() {
		for (int i = 0; i < 2; i++) {

			System.out.println("----la " + i + " Media");
			System.out.println(" id :" + media[i].id + " \n contenu :" + media[i].contenu
					+ " \n type :" + media[i].type);

			System.out.println("******************************************");
		}
	}

	public void modifierMedia(int id, String Contenu, String type) {
		if (type != null) {
			media[id].setType(type);
		} else {
			System.out.println("!!!!!!!!!!!!alert!!!!!!!!");
			System.out.println("le type n'est pas modifier");
		}

		if (Contenu != null) {
			media[id].setContenu(Contenu);
		} else {
			System.out.println("!!!!!!!!!!!!alert!!!!!!!!");
			System.out.println("le contenu n'est pas modifier");

		}

	}

	public ActionMedia() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		ActionMedia modi=new ActionMedia();
        modi.initialiser_media();
        modi.Afficher();
        modi.modifierMedia(0,"nouveau-url","image.jpg" );
        System.out.println("--------------------------------------------------------------");
        modi.Afficher();
	}
	
	
		public static void main(String[] args) {
		ActionMedia modi=new ActionMedia();
        modi.initialiser_media();
        modi.Afficher();
        modi.modifierMedia(0,"nouveau-url","image.jpg" );
        System.out.println("--------------------------------------------------------------");
        modi.Afficher(); 
	  }

            	//Recupere le chemin du media pour l'Upload (Interface graphique)
		public Media mediaUpload(String MediaSource) throws ClassNotFoundException, Exception{
		    Media media=new Media(MediaSource);
			  Media.defineMediaInfos();
			  Media.uploadMedia();
		    return media;
		}
		//Recupere le chemin du media dans la base de données (BD)
		public Media mediaDelete(String MediaLocation) throws ClassNotFoundException, Exception {
			  Media media = new Media();
			  Media.MediaLocation=MediaLocation;
			  Media.deleteMedia();
			  return media;
		}
	
}
