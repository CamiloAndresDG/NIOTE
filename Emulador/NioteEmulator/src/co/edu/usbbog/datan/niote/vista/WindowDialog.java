/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sala3
 */
public class WindowDialog extends JDialog {

    private Principal principal;
    private JPanel jPanel;
    private JFrame jFrameCarga;

    /**
     * Constructor of the WindowDialog class
     *
     * @param jFrame jFrame main where it will be used
     * @param jPanel panel that will Pop-Up
     * @param title from the Pop-Up
     * @param modal
     * @param framework from the Pop-Up
     * @param closedOption of the popup window, in this case use
     * DISPOSE_ON_CLOSE to close when X is clicked
     */
    public WindowDialog(Principal jFrame, JPanel jPanel, String title, boolean modal, boolean framework, int closedOption) {
        super(jFrame, title, modal);

        this.setDefaultCloseOperation(closedOption);
        this.setUndecorated(framework);
        this.principal = jFrame;
        this.jPanel = jPanel;
        this.jPanel.setVisible(true);
        this.add(this.jPanel);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(this.principal);
    }
    
    public WindowDialog(Principal jFrame, JFrame jFrameCarga, String title, boolean modal, boolean framework, int closedOption) {
        super(jFrame, title, modal);

        this.setDefaultCloseOperation(closedOption);
        this.setUndecorated(framework);
        this.principal = jFrame;
        this.jFrameCarga = jFrameCarga;
        this.jFrameCarga.setVisible(true);
//        this.add(this.jFrameCarga);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(this.principal);
    }

}
