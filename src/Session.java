package Session
import java.util.Date;

public class Session
{
  	private int id;
	private int author;	
	private Date open;
	private Date close;
	private boolean type;	
	private String password;
	private String title;	
	private int list[];	

	public Session ()		
	{	
		this.id=0;
		this.author=0;
		this.open.setTime(0);
		this.close.setTime(0);
		this.password="";
		this.type=false;
		this.title="";
		this.list=null;
	}

	public Session (int id,int author,Date open, Date close, String password,boolean type, String title, int list[])		
	{	
		this.id=id;
		this.author=author;
		this.open=open;
		this.close=close;
		this.password=password;
		this.type=type;
		this.title=title;
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
		return this.title;
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
		return this.open;
	}
	
	public Date getClose()
	{
		return this.close;
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
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setAuthor(int author)
	{
		this.author = author;
	}
	
	public void setList(int list[])
	{
		this.list = list;
	}
	
	public void setOpen(Date open)
	{
		this.open = open;
	}
	
	public void setClose(Date close)
	{
		this.close = close;
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