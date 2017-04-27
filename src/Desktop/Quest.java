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
public class Quest {
    String titre;
    int timer;
    int type;
    Reponse[] rep;
    
    public Quest(String t,int i,int ty,Reponse[] rep){
        titre=t;
        timer=i;
        type=ty;
        rep=rep;
    }
}
