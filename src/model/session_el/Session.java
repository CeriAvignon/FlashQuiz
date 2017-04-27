package model.session_el;
import java.util.Date;
import model.base.*;

public class Session extends SessionBase
{	
	private int list[];	

	public Session ()		
	{	
		this.id=0;
		this.author=0;
		this.startingDate.setTime(0);
		this.endingDate.setTime(0);
		this.password="";
		this.type=false;
		this.name="";
		this.list=null;
	}

	public Session (int id, Date startingDate, Date endingDate, String password,boolean type, String name, int list[])		
	{	
		this.id=id;
		this.author=0;
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

	public int getId()
	{
		return this.id;
	}

	public String getTitle()
	{
		return this.name;
	}
	
	public int getAuthor()
	{
		return this.author;
	}
	
	public int[] getList()
	{
		return this.list;
	}

	public Date getOpen()
	{
		return this.startingDate;
	}
	
	public Date getClose()
	{
		return this.endingDate;
	}

	public String getPassword()
	{
		return this.password;
	}

	public boolean getType()
	{
		return this.type;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setTitle(String name)
	{
		this.name = name;
	}
	
	public void setAuthor(int author)
	{
		this.author = author;
	}
	
	public void setList(int list[])
	{
		this.list = list;
	}
	
	public void setOpen(Date startingDate)
	{
		this.startingDate = startingDate;
	}
	
	public void setClose(Date endingDate)
	{
		this.endingDate = endingDate;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setType(boolean type)
	{
		this.type = type;
	}
}
