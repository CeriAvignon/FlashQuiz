
import java.io.*;
import java.nio.file.*;
import java.util.UUID;


public class Media {
	 static   Integer MediaType;//Représente le type du media, 0 => image, 1 => audio, 2 si => vidéo 
	 static   String MediaSource;
	 static	  String MediaLocation;// Chemin local

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
	
	
	Media( String MediaSource) {
		Media.MediaType=0;
		Media.MediaSource=MediaSource;
		Media.MediaLocation="..\\flachquiz\\media\\";
	}
	
	 public static void DefineMediaInfos() throws Exception {
        	Path path = Paths.get(MediaSource);
        	String MediaTyp = Files.probeContentType(path).substring(0,5);
        	switch (MediaTyp) {
        		case "image" :MediaType=0; break;
        		case "audio" :MediaType=1; break;
        		case "video" :MediaType=2; break;
        	}
		MediaLocation+=MediaTyp+"\\"+UUID.randomUUID().toString()+MediaSource.substring(MediaSource.length()-4);
  	 }
	 public static void InsertMedia()  throws ClassNotFoundException, Exception{
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
	 public static void DeleteMedia()  throws ClassNotFoundException, Exception{
		 Path Location=Paths.get(MediaLocation); 
		 Files.delete(Location);
	 }
	 
}
		



