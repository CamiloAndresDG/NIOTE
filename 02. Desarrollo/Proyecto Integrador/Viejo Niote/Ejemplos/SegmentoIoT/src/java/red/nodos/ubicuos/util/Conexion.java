/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.nodos.ubicuos.util;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Andres Sanchez
 */
public class Conexion {

    protected final int PUERTO = 1234; //Puerto para la conexión
    protected final String HOST = "192.168.0.109"; //Host para la conexión
    protected Socket cs; //Socket del cliente
    protected DataOutputStream salidaServidor; //Flujo de datos de salida
    //Constructor

    public Conexion() {

    }
}
