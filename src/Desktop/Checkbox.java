/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desktop;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
//import model.base.*;
//import model.session.*;

/**
 *
 * @author geoffrey
 */
public class Checkbox extends javax.swing.JFrame {

    /**
     * Creates new form Checkbox
     */
    public Checkbox() {
    
        initComponents();
        
        //  Question question = new Question(id) ;
      
     
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
        Title_Label = new javax.swing.JLabel();
        Check_3 = new javax.swing.JCheckBox();
        Check_1 = new javax.swing.JCheckBox();
        Check_2 = new javax.swing.JCheckBox();
        Check_4 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        Valider_button = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        Label_time = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Text_Quest = new javax.swing.JTextArea();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setBackground(java.awt.Color.white);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(970, 680));
        setSize(new java.awt.Dimension(970, 680));
        getContentPane().setLayout(null);

        Title_Label.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Title_Label.setText("FlashQuizz - QUESTION");
        getContentPane().add(Title_Label);
        Title_Label.setBounds(320, 20, 280, 20);

        Check_3.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Check_3.setForeground(new java.awt.Color(255, 255, 51));
        Check_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Check_3);
        Check_3.setBounds(150, 300, 28, 30);

        Check_1.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Check_1.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Check_1);
        Check_1.setBounds(150, 200, 30, 30);

        Check_2.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Check_2.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Check_2);
        Check_2.setBounds(150, 250, 28, 30);

        Check_4.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Check_4.setForeground(new java.awt.Color(255, 255, 51));
        Check_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Check_4);
        Check_4.setBounds(150, 350, 30, 30);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 340, 510, 40);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(180, 190, 510, 40);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(180, 240, 510, 40);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(204, 204, 204));
        jTextField4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(180, 290, 510, 40);

        Valider_button.setBackground(java.awt.Color.white);
        Valider_button.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Valider_button.setText("VALIDER");
        Valider_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Valider_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(Valider_button);
        Valider_button.setBounds(790, 570, 150, 50);

        jProgressBar1.setBackground(new java.awt.Color(51, 0, 204));
        jProgressBar1.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBar1.setToolTipText("");
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(90, 600, 310, 20);

        Label_time.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Label_time.setText("TEMPS :");
        getContentPane().add(Label_time);
        Label_time.setBounds(10, 600, 80, 20);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(480, 40, 10, 10);

        jScrollPane2.setBackground(java.awt.Color.lightGray);
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Text_Quest.setEditable(false);
        Text_Quest.setBackground(java.awt.Color.lightGray);
        Text_Quest.setColumns(20);
        Text_Quest.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Text_Quest.setRows(5);
        jScrollPane2.setViewportView(Text_Quest);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 70, 860, 70);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void Check_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_3ActionPerformed

    private void Check_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_4ActionPerformed

    private void Valider_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Valider_buttonActionPerformed

            // TODO add your handling code here:
          
    	Radio next = new Radio();
           next.setVisible(true);
           (this).setVisible(false);
        
         
    }//GEN-LAST:event_Valider_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Check_1;
    private javax.swing.JCheckBox Check_2;
    private javax.swing.JCheckBox Check_3;
    private javax.swing.JCheckBox Check_4;
    private javax.swing.JLabel Label_time;
    private javax.swing.JTextArea Text_Quest;
    private javax.swing.JLabel Title_Label;
    private javax.swing.JButton Valider_button;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

  public void setText_Quest(JTextArea Text_Quest) {
        this.Text_Quest = Text_Quest;
    }
}
