
package model.base.*;

import java.io.Serializable;

/**
 * A media (image, video) in the statement of a question
 *
 * @see QuestionBase
 * 
 * @author Adrien Sartori
 */
public class Media implements Serializable {
	/*
	 * The id of the media
	 *
	 */
	public int id;
	
	/**
	 * The file name
	 *
	 */
	public String fileName;
	
	/**
	 * The type of the file
	 *
	 */
	public String type;
	
	/**
	 * The name of the document
	 *
	 */
	public String name;
	
	/**
	 * Constructor of Media
	 *
	 * @param id 
	 *			  The id of the media
	 * @param fileName
	 *            The name of the file.
	 * @param type
	 *            The type of the file.
	 * @param name
	 *			  The name of the document
	 * @see Media#id
	 * @see Media#fileName
	 * @see Media#type
	 * @see Media#name
	 * 			
	 */
	public Media(int id, String fileName, String type, String name) {
		this.id = id;
		this.fileName = fileName;
		this.type = type;
		this.name = name;
	}
}
