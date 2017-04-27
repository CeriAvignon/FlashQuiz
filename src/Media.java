
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
	
	public static void defineMediaInfos() throws Exception {
        	Path path = Paths.get(MediaSource);
        	String MediaTyp = Files.probeContentType(path).substring(0,5);
        	switch (MediaTyp) {
        		case "image" :MediaType=0; break;
        		case "audio" :MediaType=1; break;
        		case "video" :MediaType=2; break;
        	}
		MediaLocation+=MediaTyp+"\\"+UUID.randomUUID().toString()+MediaSource.substring(MediaSource.length()-4);
		 //ex: "..\\flachquiz\\media\\audio\\43971bda-851b-4130-b9f2-f496b1962ccc.mp3"
  	 }
	 public static void uploadMedia()  throws ClassNotFoundException, Exception{
		  File Source=new File(MediaSource);
		  File Destination = new File(Media.MediaLocation);
		  FileInputStream fileInputStream = new FileInputStream(Source);
		  FileOutputStream fileOutputStream = new FileOutputStream(Destination);
		  int bufferSize;
		  byte[] bufffer = new byte[512];
		  while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
		        fileOutputStream.write(bufffer, 0, bufferSize);
		  }  
		  fileInputStream.close();
		  fileOutputStream.close();
	 }
	

	 public static void deleteMedia()  throws ClassNotFoundException, Exception{
	 	Path Location=Paths.get(MediaLocation); 
		Files.delete(Location);
	 }
				

}
