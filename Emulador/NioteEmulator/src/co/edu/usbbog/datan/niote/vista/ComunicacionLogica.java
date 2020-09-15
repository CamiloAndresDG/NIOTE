package co.edu.usbbog.datan.niote.vista;

import co.edu.usbbog.datan.niote.recursos.pantallaDeEmulacion.ComponentController;
import javax.swing.DefaultListModel;

/**
 *
 * @author Juan
 */
public class ComunicacionLogica {


    private EmulacionJPanel enulacionJPanel;
    private ComponentController controladorComponnente;

    public ComunicacionLogica() {
        DefaultListModel lista = new DefaultListModel();
        controladorComponnente = new ComponentController(enulacionJPanel, lista);
    }

    public void agregarComponente(String nombre, int id) {
        controladorComponnente.nuevoComponente(nombre, id);
    }

}
