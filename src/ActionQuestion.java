public class ActionQuestion
{
  
  
    int nbr_media=0;
  
  
  
                  /*  Tâche de modification d'une question est basé sur la modification sur chaque attribut du question  
                      le problème rencontré c'est lors d'une modification d'un type les nombres de réponses peut être augmenté
                      ou diminuer par exemple de changer un type radio (on peut avoir qu'une réponse correcte) vers chekbox (on peut 
                      avoir plus qu'une réponse correcte ) pour cela j'ai choisit de travailler avec deux listes l'une qui contient que
                      l'ensemble des réponses (rep) et l'autre qui contient les réponses vrais (repV) et vice versa pour chaque type
                      de question .
                  
                  */  
    public void modifierQuestion(int quest, String type, ArrayList<String> rep,ArrayList<String> repV, String Contenu, Integer id)
    {
		
			if (type != null) {
                question[quest].setType(type);;
			}
			else {
				System.out.println("alert!!");
       				System.out.println("le type n'est pas modifier");
			}
			if (rep != null &&repV!=null ) {
				question[quest].setReponse(rep);
				question[quest].setReponseVrai(repV);;
			}
			else{
				System.out.println("alert!!");
				System.out.println("les reponses  n'est pas modifier");

			}
			if (Contenu != null) {
				question[quest].setContenu(Contenu);;
			}
			else{
				System.out.println("alert!!");
				System.out.println("le contenu n'est pas modifier");

			}
			if (id != null && id>=0 && id<nbr_media) {
			   question[quest].setMedia(id);;
				
			}
			else{
				System.out.println("alert!!");
				System.out.println("media n'est pas modifier");

			}

  
  
  
  
  
  
  
}
