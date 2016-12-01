package Login;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.BoxLayout;
import javax.swing.JDialog;

public class SignDialog extends JDialog {

public SignDialog(JFrame parent, String title, boolean modal){
	super(parent, title, modal);
	
	JTextField tLogin = new JTextField("");
	JTextField tPass = new JTextField("");
	JTextField tConfPass = new JTextField("");
	JTextField tPrenom = new JTextField("");
	JTextField tNom = new JTextField("");
	JLabel labelLog = new JLabel("Compte : ");
	JLabel labelPass = new JLabel("Mot de passe : ");
	JLabel labelConfPass = new JLabel("Confirmer le mot de passe : ");
	JLabel labelPrenom = new JLabel("Prénom : ");
	JLabel labelNom = new JLabel("Nom : ");
	
	JButton butReturn = new JButton ("Retour");
	JButton butSend = new JButton ("Envoyer");
	
	this.setSize(400, 400);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	
    Font police = new Font("Arial", Font.CENTER_BASELINE, 10);
    
    
    //initialisation des pannels
    
    JPanel panLogo = new JPanel();
    panLogo.setMaximumSize( new Dimension(400, 60) );
    
    JPanel panLogin = new JPanel();
    panLogin.setMaximumSize( new Dimension(400, 60) );
    tLogin.setFont(police);
    tLogin.setMaximumSize( new Dimension(400, 30) );
    panLogin.setLayout(new BoxLayout(panLogin, BoxLayout.PAGE_AXIS));
    panLogin.add(labelLog);
    panLogin.add(tLogin);
    
    JPanel panPass = new JPanel();
    panPass.setMaximumSize( new Dimension(400, 60) );
    tPass.setFont(police);
    tPass.setMaximumSize( new Dimension(400, 30) );
    panPass.setLayout(new BoxLayout(panPass, BoxLayout.PAGE_AXIS));
    panPass.add(labelPass);
    panPass.add(tPass);
    
    JPanel panConfPass = new JPanel();
    panConfPass.setMaximumSize( new Dimension(400, 60) );
    tConfPass.setFont(police);
    tConfPass.setMaximumSize( new Dimension(400, 30) );
    panConfPass.setLayout(new BoxLayout(panConfPass, BoxLayout.PAGE_AXIS));
    panConfPass.add(labelConfPass);
    panConfPass.add(tConfPass);
    
    JPanel panPrenom = new JPanel();
    panPrenom.setMaximumSize( new Dimension(400, 60) );
    tPrenom.setFont(police);
    tPrenom.setMaximumSize( new Dimension(400, 30) );
    panPrenom.setLayout(new BoxLayout(panPrenom, BoxLayout.PAGE_AXIS));
    panPrenom.add(labelPrenom);
    panPrenom.add(tPrenom);
    
    JPanel panNom = new JPanel();
    panNom.setMaximumSize( new Dimension(400, 60) );
    tNom.setFont(police);
    tNom.setMaximumSize( new Dimension(400, 30) );
    panNom.setLayout(new BoxLayout(panNom, BoxLayout.PAGE_AXIS));
    panNom.add(labelNom);
    panNom.add(tNom);
    
    
    
    //PanBut
    
    JPanel panMainMenu = new JPanel();
    butSend.addActionListener(new BoutonSend());
    butReturn.addActionListener(new BoutonQuit());
    panMainMenu.setLayout(new BoxLayout(panMainMenu, BoxLayout.LINE_AXIS));
    panMainMenu.add(butSend);
    panMainMenu.add(butReturn);
    
    //Fin panBut
    
    JPanel panPos = new JPanel();
    //Positionnement des panels
    panPos.setLayout(new BoxLayout(panPos, BoxLayout.PAGE_AXIS));
    panPos.add(panLogo);
    panPos.add(panLogin);
    panPos.add(panPass);
    panPos.add(panConfPass);
    panPos.add(panPrenom);
    panPos.add(panNom);
    panPos.add(panMainMenu);
    //panPos.add(panMainMenu);
		
    this.getContentPane().add(panPos);
	
	this.setVisible(true);
	
	}

	class BoutonSend implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	      //System.out.println("TEXT : tLogin " + tLogin.getText());
	      //System.out.println("TEXT : tPass " + tPass.getText());
	      //System.out.println("TEXT : tLogin " + tConfPass.getText());
	      //System.out.println("TEXT : tPass " + tPrenom.getText());
	      //System.out.println("TEXT : tLogin " + tNom.getText());
	    }
	  }
  
  class BoutonQuit implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	dispose(); 
	    }
	  
    
  }
}