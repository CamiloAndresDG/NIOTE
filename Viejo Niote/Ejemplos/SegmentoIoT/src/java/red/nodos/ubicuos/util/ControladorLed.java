/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.nodos.ubicuos.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

/**
 *
 * @author Andres Sanchez
 */
public class ControladorLed extends Conexion {

    public ControladorLed() {
    } //Se usa el constructor para cliente de Conexion
    //Método para iniciar el cliente y encender bombillo

    public boolean encender() {
        try {
            iniciarConexion();
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            //Se escribe en el servidor usando su flujo de datos
            salidaServidor.writeUTF("Encender");
            terminarConexion();
            return true;
        } catch (ConnectException e ) {
            System.out.println(e.getMessage());
            return false;
        } catch (IOException | NullPointerException e ) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //Método para iniciar el cliente y encender bombillo
    public boolean apagar() {
        try {
            iniciarConexion();
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            //Se escribe en el servidor usando su flujo de datos
            salidaServidor.writeUTF("Apagar");
            terminarConexion();
            return true;
        } catch (ConnectException e ) {
            System.out.println(e.getMessage());
            return false;
        } catch (IOException | NullPointerException e ) {
            System.out.println(e.getMessage());
            return false;
        }        
    }

    public void iniciarConexion() throws ConnectException, IOException {
        cs = new Socket(HOST, PUERTO); //Socket para el cliente en localhost en puerto 1234
    }

    public void terminarConexion() throws IOException {
        cs.close();//Fin de la conexión
    }
}
