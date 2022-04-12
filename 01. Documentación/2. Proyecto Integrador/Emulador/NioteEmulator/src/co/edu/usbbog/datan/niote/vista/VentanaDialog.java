/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista;

import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author sala3
 */
public class VentanaDialog extends JDialog {

    private Principal principal;
    private JPanel jPanel;

    /**
     * Constructor de la clase VentanaDialog
     *
     * @param principal jFrame principal donde sera usado
     * @param jPanel al que se le hara la ventana emergente
     * @param titulo de la ventana emergente
     * @param modal
     * @param marco de la ventana emergente
     * @param opcionDeCerrado de la ventana emergente, en este caso se usa
     * DISPOSE_ON_CLOSE para que se cierre al dar click en X
     */
    public VentanaDialog(Principal principal, JPanel jPanel, String titulo, boolean modal, boolean marco, int opcionDeCerrado) {
        super(principal, titulo, modal);

        this.setDefaultCloseOperation(opcionDeCerrado);
        this.setUndecorated(marco);
        this.principal = principal;
        this.jPanel = jPanel;
        this.jPanel.setVisible(true);
        this.add(this.jPanel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(this.principal);
    }

}
