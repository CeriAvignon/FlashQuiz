public class ActionQuestion
{
      Question questionCreat(int QuestType, String QuestConten, boolean MediaExist) throws ClassNotFoundException, Exception {
		     Question quest=new Question (QuestType,QuestConten,MediaExist);
		     return quest;
	  }
  
}
