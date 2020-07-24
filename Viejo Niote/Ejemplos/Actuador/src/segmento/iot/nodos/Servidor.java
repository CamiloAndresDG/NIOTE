/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segmento.iot.nodos;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres Sanchez
 */
public class Servidor extends Conexion {
    ControlGpioLed controlGpioLed;

    public Servidor() {
        try {
            ss = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
            mensajeServidor = "";
            peticiones = 0;
            controlGpioLed = new ControlGpioLed();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            controlGpioLed.teminar();
            System.exit(0);
        }
    }//Se usa el constructor para servidor de Conexion
    //Método para iniciar el servidor

    public void iniciarServidor() {
        try {
            JOptionPane.showMessageDialog(null, "El servidor se esta escuchando en el puerto: " + PUERTO, "SISTEMA EN ESPERA", JOptionPane.INFORMATION_MESSAGE);
            //cs = ss.accept();
            while (true) {
                System.out.println("Esperando... peticion: " + peticiones);
                cs = ss.accept(); // espera una conexión de un cliente
                System.out.println("Cliente en línea");
                recibirDatos();
                cs.close();
                peticiones++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            cerrarTodo();
        }
    }

    public void recibirDatos() {
        try {
            inputStream = cs.getInputStream();
            entradaDatos = new DataInputStream(inputStream);
            mensajeServidor = entradaDatos.readUTF();
            System.out.println(mensajeServidor);
            if (mensajeServidor.equals("Encender")) {
                controlGpioLed.encender();
            } else if (mensajeServidor.equals("Apagar")) {
                controlGpioLed.apagar();
            }else{
                System.out.println("No se reconoce orden");
            }
            
        } catch (IOException ex) {
            System.out.println("Error recibir sockets " + ex.getMessage());
            cerrarTodo();
        }
    }

    public void cerrarTodo() {
        try {
            salidaCliente.close();
            entradaDatos.close();
            ss.close();
            cs.close();
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Error cerrar sockets " + ex.getMessage());
        }
    }
}
