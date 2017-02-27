package model;

import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.Timer;
import java.io.Serializable;

abstract class SessionBase implements Serializable {

	public int id;
	
	public String name;
	
	public String creatorName;
	
	public String password;
	
	public Date startingDate;
	
	public boolean isQuestionOrderRandom;
	
	public SessionBase(int id, String name, String creatorName, String password, Date date, boolean rand)
	{
		this.id = id;
		this.name = name;
		this.creatorName = creatorName;
		this.password = password;
		this.date = date;
		this.isQuestionOrderRandom = rand;
	}
}
