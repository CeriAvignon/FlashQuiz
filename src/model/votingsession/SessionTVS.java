package model.votingsession;

import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.Timer;
import java.util.Date;
import java.io.Serializable;
import model.*;

/**
 * Session
 *
 * @author Adrien Sartori
 */
 
public class SessionTVS extends SessionBase implements Serializable {
	
	public List<ListTVS> lists;
	
	public SessionTVS(int id, String name, String creatorName, String password, Date date, boolean rand, int[] listsId)
	{
		super(id, name, creatorName, password, date, rand);
		// for(Integer list : listsId)
			// this.list.add(getList(list)); // ListHandler
	}
	
	public void addList(List l) {
		//TODO
	}

}
