/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desktop;

import java.awt.Component;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
//import model.base.*;
//import model.session.*;


/**
 *
 * @author geoffrey
 */
public class Radio extends javax.swing.JFrame {

    ListeQu lqt;
    /**
     * Creates new form Radio
     */
    public Radio(ListeQu lq) {
        initComponents();
	
        this.lqt=lq;
	ButtonGroup groupe = new ButtonGroup() ;
        groupe.add(Radio_1);
        groupe.add(Radio_2);
        groupe.add(Radio_3);
        groupe.add(Radio_4);
	    
        //  Question question = new Question(id) ;
        Quest qu=lqt.rep[0];
        
        Text_Quest.setText(qu.titre); 
        
        if(qu.rep[0]!=null){
            Rep_1.setText(qu.rep[0].titre);
        }
            if(qu.rep[1]!=null){
            Rep_2.setText(qu.rep[1].titre);
        }
        if(qu.rep[0]!=null){
            Rep_3.setText(qu.rep[2].titre);
        }
        if(qu.rep[0]!=null){
            Rep_4.setText(qu.rep[3].titre);
        } 
        int i = 1;
         
      //  for (Answer a : question.answers ){
            
            
        //  rep_1.setText(a.content);
          i++;
        
      //  }  
      //  Text_Quest.setText(question.statement);
      //  Text_Quest.setText("Question :" +question.statement);
      
       // Rep_1.setText("La reponse 1");
        
         
       // Rep_2.setText("");
        
         
       // Rep_3.setText("");
        
     
       // Rep_4.setText("");
        
       jProgressBar1 = new JProgressBar();
       jProgressBar1.setMaximum(qu.timer);
     //  jProgressBar1.setValue(question.allocatedTime);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        Label_Title = new javax.swing.JLabel();
        Radio_4 = new javax.swing.JRadioButton();
        Radio_1 = new javax.swing.JRadioButton();
        Radio_2 = new javax.swing.JRadioButton();
        Radio_3 = new javax.swing.JRadioButton();
        Rep_4 = new javax.swing.JTextField();
        Rep_1 = new javax.swing.JTextField();
        Rep_2 = new javax.swing.JTextField();
        Rep_3 = new javax.swing.JTextField();
        Valider_Button = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        Label_Time = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Text_Quest = new javax.swing.JTextArea();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setBackground(java.awt.Color.white);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(970, 680));
        setMinimumSize(new java.awt.Dimension(970, 680));
        setSize(new java.awt.Dimension(970, 680));
        getContentPane().setLayout(null);

        Label_Title.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Label_Title.setText("FlashQuizz - QUESTION");
        getContentPane().add(Label_Title);
        Label_Title.setBounds(300, 10, 310, 51);

        Radio_4.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Radio_4.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Radio_4);
        Radio_4.setBounds(150, 320, 28, 23);

        Radio_1.setBackground(new java.awt.Color(255, 255, 255));
        Radio_1.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Radio_1.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Radio_1);
        Radio_1.setBounds(150, 170, 30, 23);

        Radio_2.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Radio_2.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Radio_2);
        Radio_2.setBounds(150, 220, 30, 23);

        Radio_3.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Radio_3.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Radio_3);
        Radio_3.setBounds(150, 270, 28, 23);

        Rep_4.setEditable(false);
        Rep_4.setBackground(new java.awt.Color(204, 204, 204));
        Rep_4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Rep_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rep_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Rep_4);
        Rep_4.setBounds(180, 320, 510, 30);

        Rep_1.setEditable(false);
        Rep_1.setBackground(new java.awt.Color(204, 204, 204));
        Rep_1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Rep_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rep_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Rep_1);
        Rep_1.setBounds(180, 170, 510, 30);

        Rep_2.setEditable(false);
        Rep_2.setBackground(new java.awt.Color(204, 204, 204));
        Rep_2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Rep_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rep_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Rep_2);
        Rep_2.setBounds(180, 220, 510, 30);

        Rep_3.setEditable(false);
        Rep_3.setBackground(new java.awt.Color(204, 204, 204));
        Rep_3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Rep_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rep_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Rep_3);
        Rep_3.setBounds(180, 270, 510, 30);

        Valider_Button.setBackground(java.awt.Color.white);
        Valider_Button.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Valider_Button.setText("VALIDER");
        Valider_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Valider_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Valider_Button);
        Valider_Button.setBounds(790, 550, 150, 70);

        jProgressBar1.setBackground(new java.awt.Color(51, 0, 204));
        jProgressBar1.setForeground(new java.awt.Color(0, 255, 0));
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(90, 600, 310, 20);

        Label_Time.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Label_Time.setText("TEMPS :");
        getContentPane().add(Label_Time);
        Label_Time.setBounds(10, 600, 90, 20);

        jScrollPane1.setBackground(java.awt.Color.lightGray);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Text_Quest.setEditable(false);
        Text_Quest.setBackground(java.awt.Color.lightGray);
        Text_Quest.setColumns(20);
        Text_Quest.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Text_Quest.setRows(5);
        jScrollPane1.setViewportView(Text_Quest);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 70, 860, 70);
    }// </editor-fold>//GEN-END:initComponents

    private void Rep_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rep_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rep_4ActionPerformed

    private void Rep_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rep_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rep_1ActionPerformed

    private void Rep_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rep_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rep_2ActionPerformed

    private void Rep_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rep_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rep_3ActionPerformed

    private void Valider_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Valider_ButtonActionPerformed
        // TODO add your handling code here:
         
        
    	new RechercheQuestionnaire(this.lqt).setVisible(true);
		dispose();
           (this).setVisible(false);
    }//GEN-LAST:event_Valider_ButtonActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_Time;
    private javax.swing.JLabel Label_Title;
    private javax.swing.JRadioButton Radio_1;
    private javax.swing.JRadioButton Radio_2;
    private javax.swing.JRadioButton Radio_3;
    private javax.swing.JRadioButton Radio_4;
    private javax.swing.JTextField Rep_1;
    private javax.swing.JTextField Rep_2;
    private javax.swing.JTextField Rep_3;
    private javax.swing.JTextField Rep_4;
    private javax.swing.JTextArea Text_Quest;
    private javax.swing.JButton Valider_Button;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void setText_Quest(JTextArea Text_Quest) {
        this.Text_Quest = Text_Quest;
    }
    
   
}