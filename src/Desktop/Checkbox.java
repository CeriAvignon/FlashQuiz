/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashquizz.Panels;

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
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        Label_time = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(970, 680));
        setMinimumSize(new java.awt.Dimension(970, 680));
        setSize(new java.awt.Dimension(970, 680));
        getContentPane().setLayout(null);

        Title_Label.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        Title_Label.setText("FlashQuizz - QUESTION");
        getContentPane().add(Title_Label);
        Title_Label.setBounds(310, 10, 340, 40);

        Check_3.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Check_3.setForeground(new java.awt.Color(255, 255, 51));
        Check_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Check_3);
        Check_3.setBounds(150, 380, 28, 30);

        Check_1.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Check_1.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Check_1);
        Check_1.setBounds(150, 160, 30, 30);

        Check_2.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Check_2.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Check_2);
        Check_2.setBounds(150, 270, 28, 30);

        Check_4.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Check_4.setForeground(new java.awt.Color(255, 255, 51));
        Check_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Check_4);
        Check_4.setBounds(150, 500, 30, 30);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jTextField1.setText("RUSSIE");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 480, 510, 60);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jTextField2.setText("FRANCE");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(180, 140, 510, 60);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jTextField3.setText("BRESIL");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(180, 250, 510, 60);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(204, 204, 204));
        jTextField4.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jTextField4.setText("U.S.A");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(180, 360, 510, 60);

        Valider_button.setBackground(new java.awt.Color(255, 255, 51));
        Valider_button.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        Valider_button.setText("VALIDER");
        Valider_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Valider_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(Valider_button);
        Valider_button.setBounds(790, 550, 150, 70);

        jTextField5.setText("jTextField5");
        getContentPane().add(jTextField5);
        jTextField5.setBounds(540, 160, 80, 26);

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(204, 204, 204));
        jTextField6.setFont(new java.awt.Font("Lucida Sans Typewriter", 2, 18)); // NOI18N
        jTextField6.setText("Quel est le plus grand pays du monde ?");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6);
        jTextField6.setBounds(10, 60, 930, 70);

        jProgressBar1.setBackground(new java.awt.Color(51, 0, 204));
        jProgressBar1.setForeground(new java.awt.Color(0, 255, 0));
        jProgressBar1.setValue(60);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(70, 600, 310, 20);

        Label_time.setForeground(new java.awt.Color(255, 255, 255));
        Label_time.setText("TEMPS :");
        getContentPane().add(Label_time);
        Label_time.setBounds(10, 600, 70, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flashquizz/Panels/bg.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 970, 650);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(480, 40, 10, 10);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(30, 20, 900, 50);
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

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void Check_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_3ActionPerformed

    private void Check_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Check_4ActionPerformed

    private void Valider_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Valider_buttonActionPerformed

            // TODO add your handling code here:
          
            Reponse next = new Reponse();
           next.setVisible(true);
           (this).setVisible(false);
        
         
    }//GEN-LAST:event_Valider_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Check_1;
    private javax.swing.JCheckBox Check_2;
    private javax.swing.JCheckBox Check_3;
    private javax.swing.JCheckBox Check_4;
    private javax.swing.JLabel Label_time;
    private javax.swing.JLabel Title_Label;
    private javax.swing.JButton Valider_button;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}