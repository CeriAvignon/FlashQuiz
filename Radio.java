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
public class Radio extends javax.swing.JFrame {

    /**
     * Creates new form Radio
     */
    public Radio() {
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
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        Label_Title = new javax.swing.JLabel();
        Radio_4 = new javax.swing.JRadioButton();
        Radio_1 = new javax.swing.JRadioButton();
        Radio_2 = new javax.swing.JRadioButton();
        Radio_3 = new javax.swing.JRadioButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        Valider_Button = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        Label_Time = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setMaximumSize(new java.awt.Dimension(970, 680));
        setMinimumSize(new java.awt.Dimension(970, 680));
        setSize(new java.awt.Dimension(970, 680));
        getContentPane().setLayout(null);

        Label_Title.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        Label_Title.setText("FlashQuizz - QUESTION");
        getContentPane().add(Label_Title);
        Label_Title.setBounds(300, 10, 310, 51);

        Radio_4.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Radio_4.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Radio_4);
        Radio_4.setBounds(150, 510, 28, 23);

        Radio_1.setBackground(new java.awt.Color(255, 255, 255));
        Radio_1.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Radio_1.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Radio_1);
        Radio_1.setBounds(150, 180, 30, 23);

        Radio_2.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Radio_2.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Radio_2);
        Radio_2.setBounds(150, 290, 30, 23);

        Radio_3.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        Radio_3.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(Radio_3);
        Radio_3.setBounds(150, 400, 28, 23);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(204, 204, 204));
        jTextField5.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jTextField5.setText("U.S.A");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(180, 490, 510, 60);

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(204, 204, 204));
        jTextField6.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jTextField6.setText("BRESIL");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6);
        jTextField6.setBounds(180, 160, 510, 60);

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(204, 204, 204));
        jTextField7.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jTextField7.setText("RUSSIE");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField7);
        jTextField7.setBounds(180, 270, 510, 60);

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(204, 204, 204));
        jTextField8.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jTextField8.setText("FRANCE");
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField8);
        jTextField8.setBounds(180, 380, 510, 60);

        Valider_Button.setBackground(new java.awt.Color(255, 255, 51));
        Valider_Button.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
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
        jProgressBar1.setValue(60);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(70, 600, 310, 20);

        Label_Time.setForeground(new java.awt.Color(255, 255, 255));
        Label_Time.setText("TEMPS :");
        getContentPane().add(Label_Time);
        Label_Time.setBounds(10, 600, 70, 20);

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(204, 204, 204));
        jTextField9.setFont(new java.awt.Font("Lucida Sans Typewriter", 2, 18)); // NOI18N
        jTextField9.setText("Quel est le plus grand pays du monde ?");
        getContentPane().add(jTextField9);
        jTextField9.setBounds(10, 60, 930, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flashquizz/Panels/bg.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 960, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void Valider_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Valider_ButtonActionPerformed
        // TODO add your handling code here:
         
        
            Reponse next = new Reponse();
           next.setVisible(true);
           (this).setVisible(false);
    }//GEN-LAST:event_Valider_ButtonActionPerformed

 public static void main(String args[]) {

      
                new Radio().setVisible(true);
              
    
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_Time;
    private javax.swing.JLabel Label_Title;
    private javax.swing.JRadioButton Radio_1;
    private javax.swing.JRadioButton Radio_2;
    private javax.swing.JRadioButton Radio_3;
    private javax.swing.JRadioButton Radio_4;
    private javax.swing.JButton Valider_Button;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
