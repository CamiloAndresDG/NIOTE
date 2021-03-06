/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author Camilo Andrés Díaz Gómez.
 * @version 1.0
 * @since April 2020.
 */
public class NotifyErrorJPanel extends javax.swing.JPanel {

    /**
     * Relations
     */
    private Principal principal;

    /**
     * Creates new form NotificarErrorJPanel
     */
    public NotifyErrorJPanel(Principal principal) {
        this.principal = principal;
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

        jPanel2 = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescriptionError = new javax.swing.JTextArea();
        jTextAreaTextDescription = new javax.swing.JTextArea();
        jButtonSend = new javax.swing.JButton();
        jButtonAttachImage = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(27, 27, 27));
        jPanel2.setForeground(new java.awt.Color(33, 33, 33));

        jLabelLogo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/datan/niote/vista/media/LogoNIOTE.png"))); // NOI18N

        jTextAreaDescriptionError.setBackground(new java.awt.Color(45, 45, 45));
        jTextAreaDescriptionError.setColumns(20);
        jTextAreaDescriptionError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextAreaDescriptionError.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaDescriptionError.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescriptionError);

        jTextAreaTextDescription.setEditable(false);
        jTextAreaTextDescription.setBackground(new java.awt.Color(27, 27, 27));
        jTextAreaTextDescription.setColumns(20);
        jTextAreaTextDescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextAreaTextDescription.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaTextDescription.setRows(5);
        jTextAreaTextDescription.setText("¡Hola! Queremos seguir mejorando en el proceso del desarrollo de nuestro emulador NioTe, si llego hasta esta instancia es por que \ntiene alguna recomendación o a encontrado algun error en el uso dado al emulador,  para esto, queremos que describa el error en \nla caja de texto inferior.");

        jButtonSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/datan/niote/vista/media/SendMailx2_24.png"))); // NOI18N
        jButtonSend.setBorder(null);
        jButtonSend.setBorderPainted(false);
        jButtonSend.setContentAreaFilled(false);
        jButtonSend.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonSend.setDefaultCapable(false);
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jButtonAttachImage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAttachImage.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAttachImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/usbbog/datan/niote/vista/media/attach_file_white_18dp.png"))); // NOI18N
        jButtonAttachImage.setText("Adjuntar imagenes");
        jButtonAttachImage.setBorder(null);
        jButtonAttachImage.setBorderPainted(false);
        jButtonAttachImage.setContentAreaFilled(false);
        jButtonAttachImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAttachImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAttachImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonAttachImage)
                                .addGap(71, 71, 71)
                                .addComponent(jButtonSend))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jTextAreaTextDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelLogo)
                .addGap(230, 230, 230))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextAreaTextDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSend)
                    .addComponent(jButtonAttachImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void jButtonAttachImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAttachImageActionPerformed
        try {
            searchImages();
        } catch (IOException ex) {
            Logger.getLogger(NotifyErrorJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAttachImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAttachImage;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescriptionError;
    private javax.swing.JTextArea jTextAreaTextDescription;
    // End of variables declaration//GEN-END:variables

    /**
     * Method to search and bring the images that will be sent through email
     * where the visible errors in the emulator are shown.
     */
    private File[] searchImages() throws IOException {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(true);
            chooser.showOpenDialog(this);
            File[] selectedFiles = chooser.getSelectedFiles();
            for (int i = 0; i < selectedFiles.length; i++) {
                try {
                    if (selectedFiles[i].getName().endsWith("png")
                            || selectedFiles[i].getName().endsWith("jpg")
                            || selectedFiles[i].getName().endsWith("jpeg")
                            || selectedFiles[i].getName().endsWith("gif")
                            || selectedFiles[i].getName().endsWith("pdf")) {
                        return selectedFiles;
                    } else {
                        JOptionPane.showMessageDialog(this, "El archivo " + selectedFiles[i].getName() + " no es una imagen.");
                    }
                } catch (NullPointerException ex2) {
                    System.out.println("No se cargo2");
                }
            }

        } catch (NullPointerException e) {
            System.out.println("No selecciono nada");
        }
        return null;
    }

    /**
     * Method to send the email.
     */
    private void sendEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
