/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desktop;

/**
 *
 * @author geoffrey
 */
class variable {
    
    public static int var = 1;
  
    
}

public class Page1 extends javax.swing.JFrame {


    public Page1() {
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

        PanelG = new javax.swing.JPanel();
        Radio_Button = new javax.swing.JButton();
        Texte_Button = new javax.swing.JButton();
        Reponse_Button = new javax.swing.JButton();
        PanelCentre = new javax.swing.JPanel();
        Jpanel = new javax.swing.JPanel();
        Demo_Button = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Radio_Button.setText("Radio");
        Radio_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radio_ButtonActionPerformed(evt);
            }
        });

        Texte_Button.setText("Texte");
        Texte_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texte_ButtonActionPerformed(evt);
            }
        });

        Reponse_Button.setText("Réponse");
        Reponse_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reponse_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelGLayout = new javax.swing.GroupLayout(PanelG);
        PanelG.setLayout(PanelGLayout);
        PanelGLayout.setHorizontalGroup(
            PanelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Radio_Button)
                    .addComponent(Texte_Button)
                    .addComponent(Reponse_Button))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        PanelGLayout.setVerticalGroup(
            PanelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(Radio_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(Texte_Button)
                .addGap(27, 27, 27)
                .addComponent(Reponse_Button)
                .addGap(230, 230, 230))
        );

        getContentPane().add(PanelG, java.awt.BorderLayout.LINE_START);

        Demo_Button.setText("START DEMO");
        Demo_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Demo_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(Demo_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(411, 411, 411))
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(Demo_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelCentreLayout = new javax.swing.GroupLayout(PanelCentre);
        PanelCentre.setLayout(PanelCentreLayout);
        PanelCentreLayout.setHorizontalGroup(
            PanelCentreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelCentreLayout.setVerticalGroup(
            PanelCentreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(PanelCentre, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Demo_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Demo_ButtonActionPerformed
        // TODO add your handling code here:
         Checkbox appelfenetre = new Checkbox();
           appelfenetre.setVisible(true);
           
        
        
    }//GEN-LAST:event_Demo_ButtonActionPerformed

    private void Radio_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radio_ButtonActionPerformed
        // TODO add your handling code here:
          Radio appelfenetre = new Radio();
           appelfenetre.setVisible(true);
           
    }//GEN-LAST:event_Radio_ButtonActionPerformed

    private void Texte_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texte_ButtonActionPerformed
        // TODO add your handling code here:
          Texte appelfenetre = new Texte();
           appelfenetre.setVisible(true);
       
    }//GEN-LAST:event_Texte_ButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void Reponse_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reponse_ButtonActionPerformed
        // TODO add your handling code here:
        Reponse next = new Reponse();
        next.setVisible(true);
    }//GEN-LAST:event_Reponse_ButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Page1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Page1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Page1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Page1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Page1().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Demo_Button;
    private javax.swing.JPanel Jpanel;
    private javax.swing.JPanel PanelCentre;
    private javax.swing.JPanel PanelG;
    private javax.swing.JButton Radio_Button;
    private javax.swing.JButton Reponse_Button;
    private javax.swing.JButton Texte_Button;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables

   
}
