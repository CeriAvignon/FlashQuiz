package model.class_el;

class Answer 
	public int idq; 
	public int id; 
	public string content; 
	public boolean state; 

	public Answer()
	{
		idq = 0;
		id=0;
		content = "";
		state = 0;
	}

	public Answer(int idq, int id, string content, boolean state) 
	{
		this.idq =idq;
		this.id=id;
		this.content = content;
		this.state = state;
	}
}
