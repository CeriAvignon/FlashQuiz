
public class ActionMedia {

		public Media MediaInsert(String MediaSource) throws ClassNotFoundException, Exception{
		    Media media=new Media(MediaSource);
			  Media.DefineMediaInfos();
			  Media.InsertMedia();
		    return media;
		}
		public Media MediaDelete(String MediaLocation) throws ClassNotFoundException, Exception {
			  Media media = new Media();
			  Media.MediaLocation=MediaLocation;
			  Media.DeleteMedia();
			  return media;
		}
	
}
