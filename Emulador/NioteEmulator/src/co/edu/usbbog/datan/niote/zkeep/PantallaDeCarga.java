/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.zkeep;

import co.edu.usbbog.datan.niote.controlador.logica.ValidacionesSistema;
import co.edu.usbbog.datan.niote.vista.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Camilo
 */
public class PantallaDeCarga extends javax.swing.JFrame {

    Principal principal;
    ValidacionesSistema vSystem;

    private int auxiliar = 0;
    private boolean realizado = false;
    hilo ejecutar = new hilo();
    boolean decision;

    /**
     * Creates new form welcome
     */
    public PantallaDeCarga() {
        initComponents();
        vSystem = new ValidacionesSistema();
       
        this.setResizable(false);
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCarga = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();
        jLabelProgreso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCarga.setBackground(new java.awt.Color(27, 27, 27));
        jPanelCarga.setForeground(new java.awt.Color(33, 33, 33));

        jLabelLogo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/datan/niote/vista/media/LogoNIOTE.png"))); // NOI18N

        jProgressBar.setForeground(new java.awt.Color(204, 0, 0));

        jLabelProgreso.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelCargaLayout = new javax.swing.GroupLayout(jPanelCarga);
        jPanelCarga.setLayout(jPanelCargaLayout);
        jPanelCargaLayout.setHorizontalGroup(
            jPanelCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCargaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelProgreso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCargaLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanelCargaLayout.setVerticalGroup(
            jPanelCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCargaLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabelProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanelCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (realizado == false) {
            realizado = true;
            jProgressBar.setMaximum(49);
            jProgressBar.setMinimum(0);
            jProgressBar.setStringPainted(true);
            ejecutar.start();
        }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(PantallaDeCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaDeCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaDeCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaDeCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new PantallaDeCarga().setVisible(true);
            }
        });
    }

    private class hilo extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    auxiliar++;
                    jProgressBar.setValue(auxiliar);
                    repaint();
                    switch (auxiliar) {
                        case 3:
                            jLabelProgreso.setText("Cargando programa...");
                            break;
                        case 20:
                            jLabelProgreso.setText("Leyendo preferencias");
                            break;
                        case 48:
                            jLabelProgreso.setText("Carga finalizada");
                            break;
                        case 50:
                            vSystem.setValidacionPantalla(true);
                            inicioPrincipal();
                            //    Principal principal = new Principal();
                            //  principal.setVisible(true);
                            //             System.out.println("s");
//                            principal.setLocationRelativeTo(PantallaDeCarga.this);
                            //dispose();
                            break;
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaDeCarga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void inicioPrincipal() {
            Principal p = new Principal();
            p.setVisible(true);
            p.pack();
            p.setLocationRelativeTo(null);
            p.setExtendedState(JFrame.MAXIMIZED_BOTH);

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelProgreso;
    private javax.swing.JPanel jPanelCarga;
    private javax.swing.JProgressBar jProgressBar;
    // End of variables declaration//GEN-END:variables
}