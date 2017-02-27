
package model;

import java.io.Serializable;

public class Media implements Serializable {

	public int id;
	
	public String fileName;
	
	public String type;
	
	public String name;
	
	public Media(int id, String fileName, String type, String name) {
		this.id = id;
		this.fileName = fileName;
		this.type = type;
		this.name = name;
	}
}
