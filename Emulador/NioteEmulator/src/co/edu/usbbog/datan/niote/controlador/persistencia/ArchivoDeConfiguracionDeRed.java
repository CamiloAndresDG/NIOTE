/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.persistencia;

import co.edu.usbbog.datan.niote.controlador.logica.GestionActuadores;
import co.edu.usbbog.datan.niote.controlador.logica.GestionNodos;
import co.edu.usbbog.datan.niote.controlador.logica.GestionPuertasDeEnlace;
import co.edu.usbbog.datan.niote.controlador.logica.GestionRed;
import co.edu.usbbog.datan.niote.controlador.logica.GestionSensores;
import co.edu.usbbog.datan.niote.modelo.Red;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Clase para guardar una red en un archivo, y cargar la red nuevamente junto a
 * sus componentes.
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class ArchivoDeConfiguracionDeRed implements Serializable {

    /**
     * ruta de directorios donde está el archivo .niote
     */
    private String ruta;
    /**
     * nombre del archivo con extensión .niote
     */
    private String nombreArchivo;
    /**
     * carpeta que se crean en la ruta
     */
    private File carpeta;
    /**
     * archivo que se crea
     */
    private File archivo;
    /**
     * Flujo para leer el archivo
     */
    private FileInputStream flujoEntrada; //imput al 
    /**
     * Flujo para leer objetos desde un archivo
     */
    private ObjectInputStream lector;
    /**
     * Flujo para escribir un archivo
     */
    private FileOutputStream flujoSalida;
    /**
     * Flujo para escribir objetos a un archivo
     */
    private ObjectOutputStream escritor;
    /**
     * Objeto que se va a leer o escribir en el archivo
     */
    private GestionRed gestionRed;

    /**
     * Constructora genérica
     */
    public ArchivoDeConfiguracionDeRed() {
    }

    /**
     * Constructor para guardar
     *
     * @param ruta ruta donde se dejará el archivo
     * @param nombreArchivo nombre del archivo
     * @param gestionRed objeto que se va a guardar
     */
    public ArchivoDeConfiguracionDeRed(String ruta, String nombreArchivo, GestionRed gestionRed) {
        this.ruta = darRuta(ruta);
        this.nombreArchivo = darNombreArchivo(nombreArchivo);
        this.gestionRed = gestionRed;
        crearArchivo();
        guardarRed();
    }

    /**
     * constructora para leer
     *
     * @param ruta ruta donde está el archivo
     * @param nombreArchivo nombre del archivo con extensión .niote
     */
    public ArchivoDeConfiguracionDeRed(String ruta, String nombreArchivo) {
        this.ruta = darRuta(ruta);
        this.nombreArchivo = darNombreArchivo(nombreArchivo);
        this.gestionRed = cargarGestionRed();
    }

    /**
     * Crea y verifica que el archivo exista
     */
    private void crearArchivo() {
        archivo = new File(this.ruta + this.nombreArchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                System.err.print("no se guardó la red");
                //JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");
            }
        }
    }

    /**
     * Crea y verifica que la ruta exista
     *
     * @param ruta
     */
    private void crearCarpeta(String ruta) {
        carpeta = new File(ruta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }

    /**
     * Verifica que el nombre del archivo tenga la extensión .niote
     *
     * @param nombreArchivo nombre que el usuario da al archivo
     * @return nombre del archivo con la extensión .niote
     */
    private String darNombreArchivo(String nombreArchivo) {
        String[] arch = nombreArchivo.split("\\.");
        if (arch.length <= 0) {
            return nombreArchivo + ".niote";
        } else {
            String ext = arch[arch.length - 1];
            if (ext.equals("niote")) {
                return nombreArchivo;
            } else {
                return nombreArchivo + ".niote";
            }
        }
    }

    /**
     * verifica que la ruta termine en \
     *
     * @param ruta ruta que da el usuario
     * @return ruta con \ al final
     */
    private String darRuta(String ruta) {
        System.out.println("Falta");
        System.out.println(ruta);
        File direc = new File(ruta);
        String[] rut = ruta.split("\\\\");
        for (int i = 0; i < rut.length; i++) {
            System.out.println(rut[i]);
        }
        if (direc.exists()) {
        } else {
            crearCarpeta(ruta);
        }
        if (rut.length <= 0) {

            return ruta + "\\";
        } else {
            String ext = rut[rut.length - 1];
            if (ext.equals("\\")) {
                return ruta;
            } else {
                return ruta + "\\";
            }
        }
    }

    /**
     * Carga los datos del objeto Red que tiene la GestionRed
     *
     * @return null si no existe, Objeto Red
     */
    public Red cargarRed() {
        return this.gestionRed.getRed();
    }

    /**
     * Carga los datos del objeto GestionNodos que tiene la GestionRed
     *
     * @return null si no existe, Objeto GestionNodos
     */
    public GestionNodos cargarNodos() {
        return this.gestionRed.getGestionNodo();
    }

    /**
     * Carga los datos del objeto GestionPuertasDeEnlace que tiene la GestionRed
     *
     * @return null si no existe, Objeto GestionPuertasDeEnlace
     */
    public GestionPuertasDeEnlace cargarPuertasDeEnlace() {
        return this.gestionRed.getGestionPuertaDeEnlace();
    }

    /**
     * Carga los datos del objeto GestionActuadores que tiene la GestionRed
     *
     * @return null si no existe, Objeto GestionActuadores
     */
    public GestionActuadores cargarActuadores() {
        return this.gestionRed.getGestionActuadores();
    }

    /**
     * Carga los datos del objeto GestionSensores que tiene la GestionRed
     *
     * @return null si no existe, Objeto GestionSensores
     */
    public GestionSensores cargarSensores() {
        return this.gestionRed.getGestionSensores();
    }

    /**
     * Método que guarda una Gestión red a un archivo con extensión .niote
     */
    public void guardarRed() {
        try {
            archivo = new File(this.ruta + this.nombreArchivo);
            flujoSalida = new FileOutputStream(archivo, false); // Para agregar y no sobreescribir
            escritor = new ObjectOutputStream(flujoSalida); // sele envia el flijo de salida
            escritor.writeObject(gestionRed);
            escritor.close();
            flujoSalida.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(ArchivoPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que carga una Gestion red desde un archivo previamente guardado
     * con extensión .niote
     *
     * @return null, si el archivo no existe o se dañó el archivo, un objeto
     * GestionRed con la configuración previa
     */
    private GestionRed cargarGestionRed() {
        GestionRed gr = null;
        try {
            archivo = new File(this.ruta + this.nombreArchivo);
            flujoEntrada = new FileInputStream(archivo);
            Object aux = null;
            lector = new ObjectInputStream(flujoEntrada);
            aux = lector.readObject();
            if (aux != null) {
                gr = (GestionRed) aux;
            }
            lector.close();
            flujoEntrada.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ArchivoDeConfiguracionDeRed.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(ArchivoDeConfiguracionDeRed.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } //Logger.getLogger(ArchivoDeConfiguracionDeRed.class.getName()).log(Level.SEVERE, null, ex);
        finally {
            return gr;
        }
    }

}
