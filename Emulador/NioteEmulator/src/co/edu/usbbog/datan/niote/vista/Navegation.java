/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.vista;

import co.edu.usbbog.datan.niote.controlador.logica.ValidacionesSistema;
import co.edu.usbbog.datan.niote.recursos.pantallaPrincipal.ProjectTreeJPanel;
import co.edu.usbbog.datan.niote.recursos.pantallaPrincipal.PaletaNodosIoTJPanel;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Camilo y Roberth
 */
public class Navegation {
    
    WindowDialog ventanaDialog;

    Main principal;
    ChargingScreenJFrame jP;
//    PantallaDeCargaJPanel pantallaDeCargaJPanel;

    CreateProjectJPanel crearProyectoJPanel;
    EmulationJPanel emulacionJPanel;
    AddIoTNodeJPanel agregarNodoIoTJPanel;
    PaletaNodosIoTJPanel paletaSensoresJPanel;
    ProjectTreeJPanel arbolProyectosJPanel;
    ReportErrorJPanel notificarErrorJPanel;
    AboutUsJPanel sobreNosotrosJPanel;
    private ValidacionesSistema validacionesSistema;

    private Dimension dim;

    
    /**
     * Method to open projects
     */
    public void openProjects() {
//Falta leer el archivo y guardarlo en una estructura de datos 
//Draw and drop  Arrastrar y soltar
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(principal);
        File archivoSeleccionado = chooser.getSelectedFile();
        String ruta = null;
        try {
            String tipodeArchivo = Files.probeContentType(archivoSeleccionado.toPath());
            if (tipodeArchivo.equals(".niote")) {
                principal.cargarRed(ruta, ".niote");
                System.out.println("Se cargo");
            } else {

            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se cargo");
//REVISAR
        } catch (NullPointerException ex2) {
            System.out.println("No se cargo2");
        }
        /* if (archivoSeleccionado!=null) {
            ruta.setText(archivoSeleccionado.getAbsolutePath());
        }*/
        String archivo;
        //  jTreeProjects.add(archivo);
    }
    
    public void searchNewImagenAndPutOnJLabel(JLabel jLabelUbicacion) {
        JFileChooser searchWindow = new JFileChooser();
        searchWindow.setDialogTitle("Buscar imagen");
        File image=searchWindow.getSelectedFile();
        if (searchWindow.showOpenDialog(principal) == JFileChooser.APPROVE_OPTION) {
            rsscalelabel.RSScaleLabel.setScaleLabel(jLabelUbicacion, searchWindow.getSelectedFile().toString());
        }
    }
    
    public File searchNewImagen() {
        JFileChooser searchWindow = new JFileChooser();
        searchWindow.setDialogTitle("Buscar imagen");
        File image=searchWindow.getSelectedFile();
//        if (searchWindow.showOpenDialog(principal) == JFileChooser.APPROVE_OPTION) {
//            rsscalelabel.RSScaleLabel.setScaleLabel(jLabelUbicacion, searchWindow.getSelectedFile().toString());
//        }
return image;
    }
    
    /*
    Navigation for Pop-Ups
     */
   /* protected void chargingScreen() {
        jP = new ChargingScreenJFrame();
        ventanaDialog = new WindowDialog(principal, jP, "Creacion de nuevo proyecto", false, false, DISPOSE_ON_CLOSE);
    }*/

    protected void goCreateProject() {
        crearProyectoJPanel = new CreateProjectJPanel(principal);
        ventanaDialog = new WindowDialog(principal, crearProyectoJPanel, "Creacion de nuevo proyecto", false, false, DISPOSE_ON_CLOSE);
    }

    public void goAddNewNode() {
        agregarNodoIoTJPanel = new AddIoTNodeJPanel(principal);
        ventanaDialog = new WindowDialog(principal, agregarNodoIoTJPanel, "Agregar nuevo nodo", false, false, DISPOSE_ON_CLOSE);
    }

    /* private void irAPantallaDeCarga() {
        pantallaDeCargaJPanel = new PantallaDeCargaJPanel(this);
        ventanaDialog = new WindowDialog(this, pantallaDeCargaJPanel, "Pantalla de carga", false, false, DISPOSE_ON_CLOSE);
    }*/
    protected void goAboutUs() {
        sobreNosotrosJPanel = new AboutUsJPanel(principal);
        ventanaDialog = new WindowDialog(principal, sobreNosotrosJPanel, "Información sobre nosotros", false, false, DISPOSE_ON_CLOSE);
    }

    protected void goReportError() {
        notificarErrorJPanel = new ReportErrorJPanel(principal);
        ventanaDialog = new WindowDialog(principal, notificarErrorJPanel, "Notificar error", false, false, DISPOSE_ON_CLOSE);
    }

    protected void cerrarVentana() {
        ventanaDialog.dispose();
        ventanaDialog = null;
        //  irAHome();
    }

    

    
    
}
