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
 * 
 * 
 */

public class Texte extends javax.swing.JFrame {

    ListeQu lq;
    /**
     * Creates new form Texte
     */
    public Texte(ListeQu lq) {
        initComponents();
        this.lq=lq;
        Quest qu = this.lq.rep[0] ;
      
     
        int i = 1;
         
      //  for (Answer a : question.answers ){
            
           Text_Quest.setText(qu.titre);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Text_Quest = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(970, 680));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("FlashQuizz - QUESTION");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 10, 467, 51);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(138, 229, 664, 195);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Rédiger votre réponse dans l'emplacement ci-dessous :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(105, 183, 470, 28);

        jButton1.setBackground(java.awt.Color.white);
        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setText("VALIDER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(790, 550, 150, 70);

        jProgressBar1.setBackground(new java.awt.Color(51, 0, 204));
        jProgressBar1.setForeground(new java.awt.Color(0, 255, 0));
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(100, 600, 310, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("TEMPS :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 600, 80, 20);

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
        jScrollPane2.setBounds(60, 70, 860, 70);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    		new RechercheQuestionnaire(this.lq).setVisible(true);
			dispose();
           (this).setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Text_Quest;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

 public void setText_Quest(JTextArea Text_Quest) {
        this.Text_Quest = Text_Quest;
    }

}