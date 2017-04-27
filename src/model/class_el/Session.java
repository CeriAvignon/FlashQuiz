package model.class_el;
import java.util.Date;
import model.base.*;

public class Session extends SessionBase
{	
	public int list[];	

	public Session ()		
	{	
		this.id=0;
		this.author=0;
		this.startingDate= 0;
		this.endingDate= 0;
		this.password="";
		this.type=false;
		this.name="";
		this.list=null;
	}

	public Session (int id, Date startingDate, Date endingDate, String password,boolean type, String name, int list[])		
	{	
		this.id=id;
		this.author=author;
		this.startingDate=startingDate;
		this.endingDate=endingDate;
		this.password=password;
		this.type=type;
		this.name=name;
		for(int i=0;i<list.length;i++)
		{
			this.list[i]=list[i];
		}
	}

}
