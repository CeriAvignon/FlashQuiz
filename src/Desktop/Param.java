package Desktop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Desktop.Login.BoutonForg;
import Desktop.Login.BoutonLog;
import Desktop.Login.BoutonQuit;
import Desktop.Login.BoutonSign;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;


public class Param extends JFrame 
{
	//Création des objets
	private Font font = new Font("Arial", Font.BOLD, 12);

	
	//Création formulaire
	private JTextField m_tLogin = new JTextField("");
	private JPasswordField m_tPass = new  JPasswordField("");
	private JPasswordField m_tConfPass = new  JPasswordField("");
	private JTextField m_tPrenom = new JTextField("");
	private JTextField m_tNom = new JTextField("");
	private JComboBox m_lang = new JComboBox();
	
	//Création label
	JLabel m_labelLang = new JLabel("Langue : ");
	JLabel m_labelLog = new JLabel("Compte : ");
	JLabel m_labelPass = new JLabel("Mot de passe : ");
	JLabel m_labelConfPass = new JLabel("Confirmer le mot de passe : ");
	JLabel m_labelPrenom = new JLabel("Prénom : ");
	JLabel m_labelNom = new JLabel("Nom : ");

	//Création bouttons
	private JButton m_butApp = new JButton ("Appliquer");
	private JButton m_butRet = new JButton ("Retour");

	
	public Param()
	{
		
		
		//Initialisation de la fenêtre
		this.setTitle("Parametre");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		//Police
		m_tLogin.setFont(font);
		m_tPass.setFont(font);
		m_tConfPass.setFont(font);
		m_tPrenom.setFont(font);
		m_labelLang.setFont(font);
		m_labelLog.setFont(font);
		m_labelPass.setFont(font);
		m_labelConfPass.setFont(font);
		m_labelPrenom.setFont(font);
		m_labelNom.setFont(font);
		m_butApp.setFont(font);
		m_butRet.setFont(font);
		m_butApp.setBackground(Color.WHITE);
		m_butRet.setBackground(Color.WHITE);
		m_tLogin.setBackground(Color.GRAY);
		m_tPass.setBackground(Color.GRAY);
		m_tConfPass.setBackground(Color.GRAY);
		m_tPrenom.setBackground(Color.GRAY);
		m_tNom.setBackground(Color.GRAY);
		
		
		//Action boutons
		m_butApp.addActionListener(new BoutonApp());
		m_butRet.addActionListener(new BoutonRet());
		
		//Panneau de tête (logo et autre info)
		JPanel m_panHead = new JPanel();
		m_panHead.setMaximumSize( new Dimension(400, 100) );

		
		//******************** Menu primaire **************************
		
		JPanel m_panLogin = new JPanel();
	    m_panLogin.setSize( new Dimension(300, 60) );
	    m_tLogin.setMaximumSize( new Dimension(300, 30) );
	    m_panLogin.setLayout(new BoxLayout(m_panLogin, BoxLayout.PAGE_AXIS));
	    m_panLogin.add(m_labelLog);
	    m_panLogin.add(m_tLogin);
	    
	    JPanel m_panPass = new JPanel();
	    m_panPass.setMaximumSize( new Dimension(300, 60) );
	    m_tPass.setMaximumSize( new Dimension(300, 30) );
	    m_panPass.setLayout(new BoxLayout(m_panPass, BoxLayout.PAGE_AXIS));
	    m_panPass.add(m_labelPass);
	    m_panPass.add(m_tPass);
	    
	    JPanel m_panConfPass = new JPanel();
	    m_panConfPass.setMaximumSize( new Dimension(300, 60) );
	    m_tConfPass.setMaximumSize( new Dimension(300, 30) );
	    m_panConfPass.setLayout(new BoxLayout(m_panConfPass, BoxLayout.PAGE_AXIS));
	    m_panConfPass.add(m_labelConfPass);
	    m_panConfPass.add(m_tConfPass);
	    
	    JPanel m_panPrenom = new JPanel();
	    m_panPrenom.setMaximumSize( new Dimension(300, 60) );
	    m_tPrenom.setMaximumSize( new Dimension(300, 30) );
	    m_panPrenom.setLayout(new BoxLayout(m_panPrenom, BoxLayout.PAGE_AXIS));
	    m_panPrenom.add(m_labelPrenom);
	    m_panPrenom.add(m_tPrenom);
	    
	    JPanel m_panNom = new JPanel();
	    m_panNom.setMaximumSize( new Dimension(300, 60) );
	    m_tNom.setMaximumSize( new Dimension(300, 30) );
	    m_panNom.setLayout(new BoxLayout(m_panNom, BoxLayout.PAGE_AXIS));
	    m_panNom.add(m_labelNom);
	    m_panNom.add(m_tNom);
		
		//Panneau info primaire
		JPanel m_panMain = new JPanel();
		m_panMain.setLayout(new BoxLayout(m_panMain, BoxLayout.LINE_AXIS));
		m_panMain.setLayout(new BoxLayout(m_panMain, BoxLayout.PAGE_AXIS));
		m_panMain.add(m_panLogin);
		m_panMain.add(m_panPass);
		m_panMain.add(m_panConfPass);
	    m_panMain.add(m_panPrenom);
	    m_panMain.add(m_panNom);
	    
	    //************************* Menu Secondaire  *****************************
	    
	    JPanel m_panSecond = new JPanel();
	    m_panSecond.setMaximumSize( new Dimension(250, 300) );
	    m_lang.setMaximumSize( new Dimension(200, 30) );
	    m_lang.addItem("Français");	    
	    m_panSecond.setLayout(new BoxLayout(m_panSecond, BoxLayout.PAGE_AXIS));
	    m_panSecond.add(m_labelLang);
	    m_panSecond.add(m_lang);
	    
		
		//************************* Menu  *****************************
										
		//Panneau menu
		JPanel m_panMenu = new JPanel();
		m_panMenu.setLayout(new BoxLayout(m_panMenu, BoxLayout.LINE_AXIS));
		m_panMenu.add(m_panMain);
		m_panMenu.add(m_panSecond);
		
		
		//************************* Bouton ****************************
		
		
		JPanel m_panButton = new JPanel();
		m_panButton.setLayout(new BoxLayout(m_panButton, BoxLayout.LINE_AXIS));
		m_panButton.add(m_butApp);
		m_panButton.add(m_butRet);
		
		//******************** Positionnement *************************
		JPanel m_panPos = new JPanel();
		//Positionnement des panels
		m_panPos.setLayout(new BoxLayout(m_panPos, BoxLayout.PAGE_AXIS));
		m_panPos.add(m_panHead);
		m_panPos.add(m_panMenu);
		m_panPos.add(m_panButton);
		
		this.getContentPane().add(m_panPos);
		
		/*m_panHead.setBackground(Color.RED);
		m_panMain.setBackground(Color.BLUE);
		m_panSecond.setBackground(Color.YELLOW);*/
		
		this.setVisible(true);
	}
	
	//Action des bouttons
	class BoutonApp implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//update_identification(new user(m_tLogin, m_tPass, m_tPrenom, m_tNom));
			Menu m_menu = new Menu();
			dispose(); 
		}
		}
	
	class BoutonRet implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Menu m_menu = new Menu();
			dispose(); 
		}
		}
		
}