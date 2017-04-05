package Desktop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

public class Menu extends JFrame{
	
	//Création des objets
	
	private Font font = new Font("Arial", Font.PLAIN, 18);
	private JLabel m_title = new JLabel("Menu");
	
	//Création bouttons
	private JButton m_butCreat = new JButton ("Créer un nouveau quizz");
	private JButton m_butRep = new JButton ("Répondre à un quizz");
	private JButton m_butStat = new JButton ("Mes statistique");
	private JButton m_butParam = new JButton ("Préférences");
	private JButton m_butDec = new JButton ("Déconnexion");
	private JButton m_butQuit = new JButton ("Quitter");
	
	public Menu()
	{
		//Initialisation de la fenêtre
		this.setTitle("Menu");
		this.setSize(300, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setResizable(false);
		
		//Police
		m_butCreat.setFont(font);
		m_butRep.setFont(font);
		m_butStat.setFont(font);
		m_butParam.setFont(font);
		m_butDec.setFont(font);
		m_butQuit.setFont(font);
		m_butCreat.setBackground(Color.WHITE);
		m_butRep.setBackground(Color.WHITE);
		m_butStat.setBackground(Color.WHITE);
		m_butParam.setBackground(Color.WHITE);
		m_butDec.setBackground(Color.WHITE);
		m_butQuit.setBackground(Color.WHITE);
		m_title.setFont(new Font("Arial", Font.BOLD, 48));
		
		//Action boutons
		m_butCreat.addActionListener(new BoutonCre());
		m_butRep.addActionListener(new BoutonRep());
		m_butStat.addActionListener(new BoutonStat());
		m_butParam.addActionListener(new BoutonParam());
		m_butDec.addActionListener(new BoutonDec());
		m_butQuit.addActionListener(new BoutonQuit());
		
		//Panneau de tête (logo et autre info)
		JPanel m_panHead = new JPanel();
		m_panHead.setMaximumSize( new Dimension(300, 100) );
		this.getContentPane().add(m_panHead);
		//m_panHead.add(m_title);
		
		//Panneau principal
		JPanel m_panMainMenu = new JPanel();
		this.setLayout(new GridLayout(8, 1, 10, 10));
		//m_butLog.addActionListener(new BoutonLog());
		//m_butQuitter.addActionListener(new BoutonQuit());
		m_panMainMenu.setLayout(new BoxLayout(m_panMainMenu, BoxLayout.LINE_AXIS));
		this.getContentPane().add(m_butCreat);
		this.getContentPane().add(m_butRep);
		this.getContentPane().add(m_butStat);
		this.getContentPane().add(m_butParam);
		this.getContentPane().add(m_butDec);
		this.getContentPane().add(m_butQuit);
		
		this.getContentPane().add(m_panMainMenu);
		this.setVisible(true);
	}
	
	//Action des bouttons
	class BoutonCre implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		}
		}
	
	class BoutonRep implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		}
		}
	
	class BoutonStat implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		}
		}
	
	class BoutonParam implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Param m_param = new Param();
			dispose(); 
		}
		}
	
	class BoutonDec implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Login m_login = new Login();
			dispose(); 
		}
		}
	
	class BoutonQuit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0); 
		}
		}

}
