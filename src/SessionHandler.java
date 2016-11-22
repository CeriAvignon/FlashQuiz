import java.io.*;
import java.util.*;
import ConnexionJM.java;

public class SessionHandler {

private int idSession;
private int idListe;
private String dateOpen;
private String dateClose;
private boolean typeSession;
private String nameSession;

public void sendSession(Session s)
	{
	idSession = s.getIdSession();
	idListe = s.getIdListe();
	dateOpen = s.getDateOpen();
	dateClose = s.getDateClose();
	typeSession = s.getTypeSession();
	nameSession = s.getNameSession();	
		




	}
}
