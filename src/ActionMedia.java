public class ActionMedia {
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
