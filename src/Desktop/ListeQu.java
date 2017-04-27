/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desktop;

/**
 *
 * @author uapv1504060
 */
public class ListeQu {
    String titre;
    String mdp;
    String desc;
    Quest[] rep;
    
    public ListeQu(String t,String m,String d,Quest[] rep){
        titre=t;
        mdp=m;
        desc=d;
        this.rep=rep;
    }
}
