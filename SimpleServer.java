import java.io.*;
import java.net.*;
class SimpleServer
{
	public static void main(String args[])
	{
		try
		{
			ServerSocket sock = new ServerSocket(8000);
			Socket newsock = sock.accept();
			DataInputStream inp = new DataInputStream(newsock.getInputStream());
			PrintStream outp = new PrintStream(newsock.getOutputStream());
			outp.println("Hello :: enter QUIT to exit");
			boolean add_data = true;
			while(add_data)
			{
				String line = inp.readLine();
				if(line==null)
				{
					add_data=false;
				}
				else
				{
					outp.println("From server:"+line+"in");
					if(line.trim().equals("QUIT"))
					{
						add_data=false;
					}
					if (line.trim().equals("send")) 
					{
						System.out.println("printed send");
						add_data=false;	
					}
					if(line.trim().equals("SQL"))
					{
						System.out.println("SQL REQUEST SENDED TO THE DATABASE");
						add_data=false;
					}
					if(mine.trim().equals("SHOW")) //show DATABASE
					{
						System.out.println("DATABASE DUMPED")	;
						add_data=false;
					}
				}
			}
			newsock.close();
		}
		catch(IOException e)
		{
			System.out.println("IO error"+e);
		}
	}
}