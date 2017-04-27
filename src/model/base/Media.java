package model.base;

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
	 */
	public int id;

	/**
	 * The file name
	 */
	public String fileName;

	/**
	 * The type of the file
	 */
	public String type;

	/**
	 * The name of the document
	 */
	public String name;

	/**
	 * Constructor of Media
	 */
	public Media() {
	}
}
