public class ActionMedia
{
    //Recupere le chemin du media dans la base de données (BD)
		public Media mediaDelete(String MediaLocation) throws ClassNotFoundException, Exception {
			  Media media = new Media();
			  Media.MediaLocation=MediaLocation;
			  Media.deleteMedia();
			  return media;
		}
}
