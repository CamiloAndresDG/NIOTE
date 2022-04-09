/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Oscar
 */
public class ConcreteServiceSocket extends AbstractService {

    Socket requestSocket;
    ObjectOutputStream out;
    String message;
    String serverName;
    int portNumber;

    public ConcreteServiceSocket(Message m) {
        super(m);
    }

    @Override
    public void updateService(String value) {
        try {
            //La IP identifica al servidor al que estara asignado el nodo
            serverName = getMsg().getNode().getIp();

            //Asignar el puerto por el que se debe enviar le mensaje
            String port = getMsg().getNode().getIdSwsn();
            portNumber = Integer.valueOf(port);

            requestSocket = new Socket(serverName, portNumber);

            //crear bufer de salida
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();

            //enviar mensaje
            out.writeObject(value);
            out.flush();

            System.out.println("Mensaje " + value + "Enviado desde " + serverName + ":" + port);

        } catch (IOException ioException) {
            System.out.println("IOException " + ioException.getMessage());

        } catch (Exception me) {
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());

        } finally {
            //4: Closing connection
            try {
                out.close();
                requestSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Override
    public Message consultService() {
        System.out.println("consultService Not supported yet.");
        return null;
    }

}
