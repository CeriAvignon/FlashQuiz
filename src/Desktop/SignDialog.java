package Desktop;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.BoxLayout;
import javax.swing.JDialog;

public class SignDialog extends JDialog {
	
	private Font font = new Font("Arial", Font.BOLD, 12);
	
	JTextField m_tLogin = new JTextField("");
	JPasswordField m_tPass = new  JPasswordField("");
	JPasswordField m_tConfPass = new  JPasswordField("");
	JTextField m_tPrenom = new JTextField("");
	JTextField m_tNom = new JTextField("");
	
	//Création des popup
	JOptionPane m_optionForget = new JOptionPane(), m_optionConf = new JOptionPane();

public SignDialog(JFrame parent, String title, boolean modal){
	super(parent, title, modal);
	
	//Création des labels
	JLabel m_labelLog = new JLabel("Compte : ");
	JLabel m_labelPass = new JLabel("Mot de passe : ");
	JLabel m_labelConfPass = new JLabel("Confirmer le mot de passe : ");
	JLabel m_labelPrenom = new JLabel("Prénom : ");
	JLabel m_labelNom = new JLabel("Nom : ");
		
	//Création des boutons
	JButton m_butReturn = new JButton ("Retour");
	JButton m_butSend = new JButton ("Envoyer");
	
	//Action des boutons
    m_butSend.addActionListener(new BoutonSend());
    m_butReturn.addActionListener(new BoutonQuit());
	
	this.setSize(400, 400);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	
	//Police
	m_labelLog.setFont(font);
	m_labelPass.setFont(font);
	m_labelConfPass.setFont(font);
	m_labelNom.setFont(font);
	m_tNom.setFont(font);
	m_tLogin.setFont(font);
	m_tPass.setFont(font);
	m_tConfPass.setFont(font);
	m_tPrenom.setFont(font);
	m_tNom.setBackground(Color.GRAY);
	m_tLogin.setBackground(Color.GRAY);
	m_tPass.setBackground(Color.GRAY);
	m_tConfPass.setBackground(Color.GRAY);
	m_tPrenom.setBackground(Color.GRAY);
	m_butReturn.setFont(font);
	m_butSend.setFont(font);
	m_butReturn.setBackground(Color.WHITE);
	m_butSend.setBackground(Color.WHITE);
    
    //initialisation des pannels
    
    JPanel m_panHead = new JPanel();
    m_panHead.setMaximumSize( new Dimension(600, 60) );
    
    JPanel m_panLogin = new JPanel();
    m_panLogin.setMaximumSize( new Dimension(400, 60) );
    m_tLogin.setMaximumSize( new Dimension(400, 30) );
    m_panLogin.setLayout(new BoxLayout(m_panLogin, BoxLayout.PAGE_AXIS));
    m_panLogin.add(m_labelLog);
    m_panLogin.add(m_tLogin);
    
    JPanel m_panPass = new JPanel();
    m_panPass.setMaximumSize( new Dimension(400, 60) );
    m_tPass.setMaximumSize( new Dimension(400, 30) );
    m_panPass.setLayout(new BoxLayout(m_panPass, BoxLayout.PAGE_AXIS));
    m_panPass.add(m_labelPass);
    m_panPass.add(m_tPass);
    
    JPanel m_panConfPass = new JPanel();
    m_panConfPass.setMaximumSize( new Dimension(400, 60) );
    m_tConfPass.setMaximumSize( new Dimension(400, 30) );
    m_panConfPass.setLayout(new BoxLayout(m_panConfPass, BoxLayout.PAGE_AXIS));
    m_panConfPass.add(m_labelConfPass);
    m_panConfPass.add(m_tConfPass);
    
    JPanel m_panPrenom = new JPanel();
    m_panPrenom.setMaximumSize( new Dimension(400, 60) );
    m_tPrenom.setMaximumSize( new Dimension(400, 30) );
    m_panPrenom.setLayout(new BoxLayout(m_panPrenom, BoxLayout.PAGE_AXIS));
    m_panPrenom.add(m_labelPrenom);
    m_panPrenom.add(m_tPrenom);
    
    JPanel m_panNom = new JPanel();
    m_panNom.setMaximumSize( new Dimension(400, 60) );
    m_tNom.setMaximumSize( new Dimension(400, 30) );
    m_panNom.setLayout(new BoxLayout(m_panNom, BoxLayout.PAGE_AXIS));
    m_panNom.add(m_labelNom);
    m_panNom.add(m_tNom);
    
    
    
    //Pannel du menu
    
    JPanel m_panMainMenu = new JPanel();
    m_panMainMenu.setLayout(new BoxLayout(m_panMainMenu, BoxLayout.LINE_AXIS));
    m_panMainMenu.add(m_butSend);
    m_panMainMenu.add(m_butReturn);
    
    //Fin Pannel du menu
    
    JPanel m_panPos = new JPanel();
    //Pannel des buttons
    m_panPos.setLayout(new BoxLayout(m_panPos, BoxLayout.PAGE_AXIS));
    m_panPos.add(m_panHead);
    m_panPos.add(m_panLogin);
    m_panPos.add(m_panPass);
    m_panPos.add(m_panConfPass);
    m_panPos.add(m_panPrenom);
    m_panPos.add(m_panNom);
    m_panPos.add(m_panMainMenu);
    
	//Test de couleur des panels
	//m_panHead.setBackground(Color.ORANGE);
	//m_panLogin.setBackground(Color.RED);
	//m_panPass.setBackground(Color.BLUE);
	//m_panConfPass.setBackground(Color.PINK);
	//m_panPrenom.setBackground(Color.GREEN);
	//m_panNom.setBackground(Color.YELLOW);
	//m_panPos.setBackground(Color.BLACK);
		
    this.getContentPane().add(m_panPos);
	
	this.setVisible(true);
	
	}


	class BoutonSend implements ActionListener{

		public void actionPerformed(ActionEvent e) {
	    	//Vérification
	      String Login = m_tLogin.getText().trim();
	      String Password =  m_tPass.getText();
	      String strConfPass = m_tConfPass.getText();
	      String First_Name = m_tPrenom.getText().trim();
	      String Last_Name = m_tNom.getText().trim();
	      
	      
	      //Gestion des erreurs
	      if(!Password.equals(strConfPass))
	      {
	    	  JOptionPane.showMessageDialog(null, "Le mot de passe et la vérification doivent être semblable ", "Ok.", JOptionPane.ERROR_MESSAGE);
	      }
	      else if(Login.equals("") || Password.equals("") || strConfPass.equals("") || First_Name.equals("") || Last_Name.equals(""))
	      {
	    	  JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplit", "Ok.", JOptionPane.ERROR_MESSAGE);
	      }
	      else if(Login.equals("") || Password.equals("") || strConfPass.equals("") || First_Name.equals("") || Last_Name.equals(""))
	      {
	    	  JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplit", "Ok.", JOptionPane.ERROR_MESSAGE);
	      }
	      
	      //Si pas d'erreur
	      else	
	      {
	    	  System.out.println("TEXT : m_tLogin " + Login); 
		      System.out.println("TEXT : m_tPass " + Password);
		      //System.out.println("TEXT : m_tConfPass " + strConfPass);
		      System.out.println("TEXT : m_tPrenom " + First_Name);
		      System.out.println("TEXT : m_tNom " + Last_Name);
	    	  dispose(); 
	      }
	    }
	  }
  
  class BoutonQuit implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	dispose(); 
	    }
	  
    
  }
}
