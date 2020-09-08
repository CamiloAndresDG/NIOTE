/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import co.edu.usbbog.datan.niote.modelo.Red;
import co.edu.usbbog.datan.niote.vista.Main;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class Emulador extends Thread{

    private Main principal;
    private Red red;

    public Emulador(Main principal) {
        this.principal = principal;
    }

    public void show() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        this.red = this.principal.getGestionRed().getRed();
        int i = 0;
        while (true) {
            try {
                System.err.println("Hola soy red " + red.getId() + " saludo No. " + i);
                i++;
                Thread.sleep(11000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Emulador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
