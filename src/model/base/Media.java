import java.io.*;
import java.nio.file.*;
import java.util.UUID;
package model.base;

public class Media {
	 public static   int mediaType;//Représente le type du media, 0 => image, 1 => audio, 2 si => vidéo 
	 public static   String mediaSource;//la source du Media 
	 public static	  String mediaLocation;// Chemin local dans la base de données

	public static Integer getMediaType() {
		return Media.mediaType;
	}
	public static void setMediaType(int mediaType) {
		Media.mediaType = mediaType;
	}
	public static String getMediaSource() {
		return Media.mediaSource;
	}
	public static void setMediaSource(String mediaSource) {
		Media.mediaSource = mediaSource;
	}
	public static String getMediaLocation() {
		return Media.mediaLocation;
	}
	public static void setMediaLocation(String mediaLocation) {
		Media.mediaLocation = mediaLocation;
	}
	
	
	Media( String mediaSource) {
		Media.mediaType=0;
		Media.mediaSource=mediaSource;
		Media.mediaLocation="..\\flashquiz\\media\\";
	}
	
	 public static void defineMediaInfos() throws Exception {
        	Path path = Paths.get(mediaSource);
        	String mediaTyp = Files.probeContentType(path).substring(0,5);
        	switch (mediaTyp) {
        		case "image" :mediaType=0; break;
        		case "audio" :mediaType=1; break;
        		case "video" :mediaType=2; break;
        	}
		mediaLocation+=mediaTyp+"\\"+UUID.randomUUID().toString()+mediaSource.substring(mediaSource.length()-4);
		 //ex: "..\\flachquiz\\media\\audio\\43971bda-851b-4130-b9f2-f496b1962ccc.mp3"
  	 }
	 public static void uploadMedia()  throws ClassNotFoundException, Exception{
		  File source=new File(mediaSource);
		  File destination = new File(Media.mediaLocation);
		  FileInputStream fileInputStream = new FileInputStream(source);
		  FileOutputStream fileOutputStream = new FileOutputStream(destination);
		  int bufferSize;
		  byte[] bufffer = new byte[512];
		  while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
		        fileOutputStream.write(bufffer, 0, bufferSize);
		  }  
		  fileInputStream.close();
		  fileOutputStream.close();
	 }
	 public static void deleteMedia()  throws ClassNotFoundException, Exception{
		 Path location=Paths.get(mediaLocation); 
		 Files.delete(location);
	 }
	 
}
		



