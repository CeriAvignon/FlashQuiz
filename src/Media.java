
import java.io.*;

public class Media {
		
	Integer MediaType;//0 => image, 1 => audio, 2 si => vidéo 
	String MediaName;//le nom est toujours l'ID de la question plus le format du fichier - ex: 20.png
	String MediaDest;//Représente la location du Media
	Media() {
		this.MediaType=0;
		this.MediaName=null;
		this.MediaDest="..\\flachquiz\\media\\";
	}
	//On détermine le type du Media
	public int DefineMediaType(String ext) {
		String[] image = { "png","jpg","gif","tif","bmp" };
		String[] audio = { "wav","mp3","wma","ogg","flac","aac" };
		String[] video = { "flv","avi","mkv","mp4","mpeg","mov","rmvb","vob","wmv" };
		for(String a : image) {
	           if(ext == a) return 0; 
		}
		for(String a : audio) {
	   	   if(ext == a) return 1;
		}
		for(String a : video) {
		   if(ext == a) return 2;
		}
		return 99;
	}	
	
	public void UploadMedia(int IdQuestion,String MediaSource) throws ClassNotFoundException, Exception{
	   
		String extension=MediaSource.substring(MediaSource.length()-3);
		MediaName=IdQuestion+"."+extension;
		MediaType=DefineMediaType(extension);
		switch (MediaType) {
		  case 0: MediaDest+="img\\"; break;
		  case 1: MediaDest+="audio\\"; break;
		  case 2: MediaDest+="video\\"; break;
		}
	  
		File sourceMedia = new File(MediaSource);
	  	File destinationMedia = new File(MediaDest + MediaName);
	  	FileInputStream fileInputStream = new FileInputStream(sourceMedia);
	  	FileOutputStream fileOutputStream = new FileOutputStream(destinationMedia);
	  	int bufferSize;
	  	byte[] bufffer = new byte[512];
	  	while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
	      	      fileOutputStream.write(bufffer, 0, bufferSize);
	  	}
	  	fileInputStream.close();
	  	fileOutputStream.close();
	}
	
}
		



