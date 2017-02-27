package model.votingsession;

import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.Timer;
import java.io.Serializable;

/**
 * Session
 *
 * @author Adrien Sartori
 */
 
class Session extends SessionBase implements Serializable {
	
	public Vector<List> lists;
	
	public Session(int id, String name, String creatorName, String password, Date date, boolean rand, int[] listsId)
	{
		super(id, name, creatorName, password, date, rand);
		// for(Integer list : listsId)
			// this.list.add(getList(list)); // ListHandler
	}
	
	public void addList(List l) {
		//TODO
	}

}
