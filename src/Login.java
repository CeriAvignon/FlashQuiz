package Login;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

import Menu.Menu;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;


public class Login extends JFrame 
{

	//Création des objets
	
	//Création formulaire
	private JTextField m_tLogin = new JTextField("");
	private  JPasswordField m_tPass = new  JPasswordField("");
	
	//Céation label
	private JLabel m_labelLog = new JLabel("Compte : ");
	private JLabel m_labelPass = new JLabel("Mot de passe : ");

	//Création bouttons
	private JButton m_butQuitter = new JButton ("Quitter");
	private JButton m_butLog = new JButton ("Connexion");
	private JButton m_butSign = new JButton ("Créer un compte...");
	private JButton m_butForg = new JButton ("Mot de passe oublié?");
	
	//Création popup
	JOptionPane m_optionForget = new JOptionPane(), m_optionConf = new JOptionPane();

	public Login()
	{
		
		
		//Initialisation de la fenêtre
		this.setTitle("Login");
		this.setSize(600, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	
		//Action boutons
		m_butLog.addActionListener(new BoutonLog());
		m_butQuitter.addActionListener(new BoutonQuit());
		m_butSign.addActionListener(new BoutonSign());
		m_butForg.addActionListener(new BoutonForg());
	
		//initialisation des pannels
		
		//Panneau de tête (logo et autre info)
		JPanel m_panHead = new JPanel();
		m_panHead.setMaximumSize( new Dimension(400, 100) );
	
		
		//Position login
		JPanel m_panLabel = new JPanel();
		m_panLabel.setMaximumSize( new Dimension(0, 30) );
		m_panLabel.setLayout(new BoxLayout(m_panLabel, BoxLayout.PAGE_AXIS));
		m_labelLog.setAlignmentX(Component.RIGHT_ALIGNMENT);
		//m_labelLog.setAlignmentY(Component.TOP_ALIGNMENT);
		m_labelPass.setAlignmentX(Component.RIGHT_ALIGNMENT);
		m_panLabel.add(m_labelLog);
		m_panLabel.add(m_labelPass);
		
		JPanel m_panText = new JPanel();
		m_panText.setPreferredSize(new Dimension(400, 60));
		m_tLogin.setMaximumSize( new Dimension(400, 30) );
		m_tPass.setMaximumSize( new Dimension(400, 30) );
		m_panText.setLayout(new BoxLayout(m_panText, BoxLayout.PAGE_AXIS));
		m_panText.add(m_tLogin);
		m_panText.add(m_tPass);
		
		JPanel m_panLog = new JPanel();
		m_panLog.setPreferredSize(new Dimension(400, 60));
		m_panLog.setLayout(new BoxLayout(m_panLog, BoxLayout.LINE_AXIS));
		m_panLog.add(m_panLabel);
		m_panLog.add(m_panText);
		
		//Position login fin
		
		//Position boutons
		
		JPanel m_panMainMenu = new JPanel();
		m_panMainMenu.setLayout(new BoxLayout(m_panMainMenu, BoxLayout.LINE_AXIS));
		m_panMainMenu.add(m_butLog);
		m_panMainMenu.add(m_butQuitter);
		 
		JPanel m_panSecondMenu = new JPanel();
		
		m_panSecondMenu.setLayout(new BoxLayout(m_panSecondMenu, BoxLayout.LINE_AXIS));
		m_panSecondMenu.add(m_butSign);
		m_panSecondMenu.add(m_butForg);
		
		JPanel m_panBut = new JPanel();
		m_panBut.setLayout(new BoxLayout(m_panBut, BoxLayout.PAGE_AXIS));
		m_panBut.add(m_panSecondMenu);
		m_panBut.add(m_panMainMenu);
		
		//Position bouttons Fin
		
		JPanel m_panPos = new JPanel();
		//Positionnement des panels
		m_panPos.setLayout(new BoxLayout(m_panPos, BoxLayout.PAGE_AXIS));
		m_panPos.add(m_panHead);
		m_panPos.add(m_panLog);
		m_panPos.add(m_panBut);
		
		//Test de couleur des panels
		//m_panHead.setBackground(Color.ORANGE);
		//m_panLabel.setBackground(Color.RED);
		//m_panText.setBackground(Color.BLUE);
		//m_panLog.setBackground(Color.PINK);
		//m_panBut.setBackground(Color.GREEN);
		//m_panPos.setBackground(Color.YELLOW);
				
		this.getContentPane().add(m_panPos);
	
		this.setVisible(true);
	}
		
	//Action des bouttons
	class BoutonLog implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		System.out.println("TEXT : m_tLogin " + m_tLogin.getText());
		System.out.println("TEXT : m_tPass " + m_tPass.getText());
		Menu m_menu = new Menu();
		dispose(); 
		}
		}
	
	class BoutonQuit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0); 
		}
		}
	
	class BoutonSign implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			SignDialog m_SD = new SignDialog(null, "Créer un compte", true);
		}
		}
	
	class BoutonForg implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String email = JOptionPane.showInputDialog(null, "Veuillez entrez votre adresse Email pour récupérer votre mot de passe.", JOptionPane.QUESTION_MESSAGE);
			System.out.println("TEXT : email " + email);
			JOptionPane.showMessageDialog(null, "Un message de récupération a été envoyer à cette adresse. ", "Confirmation.", JOptionPane.INFORMATION_MESSAGE);
		}
		}
}