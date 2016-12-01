package Login;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;


public class Login extends JFrame {

	//Création des objets
	
	//Création formulaire
	private JTextField m_tLogin = new JTextField("");
	private JTextField m_tPass = new JTextField("");
	
	//Céation label
	private JLabel m_labelLog = new JLabel("Compte : ");
	private JLabel m_labelPass = new JLabel("Mot de passe : ");

	//Créatiion bouttons
	private JButton m_butQuitter = new JButton ("Quitter");
	private JButton m_butLog = new JButton ("Connexion");
	private JButton m_butSign = new JButton ("Créer un compte...");
	private JButton m_butForg = new JButton ("Mot de passe oublié?");
	
	//Création popup
	JOptionPane m_optionForget = new JOptionPane(), m_optionConf = new JOptionPane();

	//Initialisation de la fenêtre
	public Login(){
	this.setTitle("Animation");
	this.setSize(600, 300);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	
	
	//initialisation des pannels
	
	JPanel panLogo = new JPanel();
	panLogo.setMaximumSize( new Dimension(300, 60) );

	//Position login
	
	JPanel panLabel = new JPanel();
	panLabel.setMaximumSize( new Dimension(0, 30) );
	panLabel.setLayout(new BoxLayout(panLabel, BoxLayout.PAGE_AXIS));
	m_labelLog.setAlignmentX(Component.RIGHT_ALIGNMENT);
	//m_labelLog.setAlignmentY(Component.TOP_ALIGNMENT);
	m_labelPass.setAlignmentX(Component.RIGHT_ALIGNMENT);
	panLabel.add(m_labelLog);
	panLabel.add(m_labelPass);
	
	JPanel panText = new JPanel();
	panText.setPreferredSize(new Dimension(400, 60));
	m_tLogin.setMaximumSize( new Dimension(400, 30) );
	m_tPass.setMaximumSize( new Dimension(400, 30) );
	panText.setLayout(new BoxLayout(panText, BoxLayout.PAGE_AXIS));
	panText.add(m_tLogin);
	panText.add(m_tPass);
	
	JPanel panLog = new JPanel();
	panLog.setPreferredSize(new Dimension(400, 60));
	panLog.setLayout(new BoxLayout(panLog, BoxLayout.LINE_AXIS));
	panLog.add(panLabel);
	panLog.add(panText);
	
	//Position login fin
	
	//Position bouttons
	
	JPanel panMainMenu = new JPanel();
	m_butLog.addActionListener(new BoutonLog());
	m_butQuitter.addActionListener(new BoutonQuit());
	panMainMenu.setLayout(new BoxLayout(panMainMenu, BoxLayout.LINE_AXIS));
	panMainMenu.add(m_butLog);
	panMainMenu.add(m_butQuitter);
	 
	JPanel panSecondMenu = new JPanel();
	m_butSign.addActionListener(new BoutonSign());
	m_butForg.addActionListener(new BoutonForg());
	panSecondMenu.setLayout(new BoxLayout(panSecondMenu, BoxLayout.LINE_AXIS));
	panSecondMenu.add(m_butSign);
	panSecondMenu.add(m_butForg);
	
	JPanel panBut = new JPanel();
	panBut.setLayout(new BoxLayout(panBut, BoxLayout.PAGE_AXIS));
	panBut.add(panSecondMenu);
	panBut.add(panMainMenu);
	
	//Position bouttons Fin
	
	JPanel panPos = new JPanel();
	//Positionnement des panels
	panPos.setLayout(new BoxLayout(panPos, BoxLayout.PAGE_AXIS));
	panPos.add(panLogo);
	panPos.add(panLog);
	panPos.add(panBut);
			
	this.getContentPane().add(panPos);

	this.setVisible(true);
	}
	
	class BoutonLog implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		System.out.println("TEXT : m_tLogin " + m_tLogin.getText());
		System.out.println("TEXT : m_tPass " + m_tPass.getText());
		}
		}
	
	class BoutonQuit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dispose(); 
		}
		}
	
	class BoutonSign implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			SignDialog SD = new SignDialog(null, "Créer un compte", true);
		}
		}
	
	class BoutonForg implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String email = m_optionForget.showInputDialog(null, "Veuillez entrez votre adresse Email pour récupérer votre mot de passe.", JOptionPane.QUESTION_MESSAGE);
			System.out.println("TEXT : email " + email);
			m_optionConf.showMessageDialog(null, "Un message de récupération a été envoyer à cette adresse. ", "Confirmation.", JOptionPane.INFORMATION_MESSAGE);
		}
		}
	}