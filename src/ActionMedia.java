
public class ActionMedia {

		public Media mediaUpload(String MediaSource) throws ClassNotFoundException, Exception{
		          Media media=new Media(MediaSource);
			  Media.defineMediaInfos();
			  Media.uploadMedia();
		          return media;
		}
		public Media mediaDelete(String MediaLocation) throws ClassNotFoundException, Exception {
			  Media media = new Media();
			  Media.MediaLocation=MediaLocation;
			  Media.deleteMedia();
			  return media;
		}
	
}
