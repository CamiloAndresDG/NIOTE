/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segmento.iot.nodos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Andres Sanchez
 */
public class Conexion {

    protected final int PUERTO = 1234; //Puerto para la conexión
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected DataOutputStream salidaCliente; //Flujo de datos de salida
    protected InputStream inputStream;
    protected DataInputStream entradaDatos;
    protected int peticiones;

    //Constructor
    public Conexion() {

    }
}
