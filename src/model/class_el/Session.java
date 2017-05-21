package model.class_el;
import java.util.Date;
import model.base.*;

// Cette classe est une extend de SessionBase du package model.base.Session
public class Session extends SessionBase
{	
	public int list[];	
/**
* constructeur vide de liste
* @author: LE VEVE Mathieu
* @brief: construit un objet vide, instancié lors d'un click sur un bouton
*/
	public Session ()		
	{	
		this.id=0;
		this.author=0;
		this.startingDate= 0;
		this.endingDate= 0;
		this.password="";
		this.type=false;
		this.name="";
		this.list=null;
	}
/**
* constructeur d'une session
* @author: LE VEVE Mathieu
* @brief : constructeur d'une session paramétrable
* @param id = valeur à attribuer à id d'une session
* @param startingDate = date de début paramétrable d'une session
* @param endingDate = date de fin paramétrable d'une session
* @param password = mot de passe à paramétrer pour limiter l'accès (paramètre session non libre)
* @param type =  différencie session libre/ fermée
* @param name = nom d'une session
* @param list = liste d'identifiants de questionnaires (listes de question ou id d'objet List()]
*/
	public Session (int id, Date startingDate, Date endingDate, String password,boolean type, String name, int list[])		
	{	
		this.id=id;
		this.author=author;
		this.startingDate=startingDate;
		this.endingDate=endingDate;
		this.password=password;
		this.type=type;
		this.name=name;
		for(int i=0;i<list.length;i++)
		{
			this.list[i]=list[i];
		}
	}

}
