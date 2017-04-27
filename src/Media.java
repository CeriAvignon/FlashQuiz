
import java.io.*;
import java.nio.file.*;
import java.util.UUID;

class Media
{
	private int id; 
	static   Integer MediaType;//Représente le type du media, 0 => image, 1 => audio, 2 si => vidéo 
	static   String MediaSource;//la source du Media 
	static	  String MediaLocation;// Chemin local dans la base de données

	/**
* getter de l'atribut id
*
* @return retourne la valeur de l'atribut id
*/
	public int getId()
	{
		return this.id;
	}


/**
* setter de l'atribut id
*
* @param id = valeur à atribuer à id
*/
	public void setId(int id)
	{
		this.id = id;
	}
	public static Integer getMediaType() {
		return MediaType;
	}
	public static void setMediaType(Integer mediaType) {
		MediaType = mediaType;
	}
	public static String getMediaSource() {
		return MediaSource;
	}
	public static void setMediaSource(String mediaSource) {
		MediaSource = mediaSource;
	}
	public static String getMediaLocation() {
		return MediaLocation;
	}
	public static void setMediaLocation(String mediaLocation) {
		MediaLocation = mediaLocation;
	}
	
	//Constructeur
	Media( String MediaSource) {
		Media.MediaType=0;
		Media.MediaSource=MediaSource;
		Media.MediaLocation="..\\flachquiz\\media\\";
	}

		 public static void deleteMedia()  throws ClassNotFoundException, Exception{
		 Path Location=Paths.get(MediaLocation); 
		 Files.delete(Location);
	 }
				

}
