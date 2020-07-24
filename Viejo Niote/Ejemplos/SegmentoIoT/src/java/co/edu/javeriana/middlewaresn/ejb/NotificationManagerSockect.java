/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.ejb;

import java.net.ServerSocket;
import java.net.Socket;
import javax.ejb.EJB;
    
/**
 *
 * @author Oscar
 */
public class NotificationManagerSockect implements Runnable {

    private int portNumber;
    private ServiceNodeFacade ejbNodeFacade;
    private ServiceNodeValueFacade ejbNodeValueFacade;

    NotificationManagerSockect(ServiceNodeFacade ejbNodeFacade,ServiceNodeValueFacade ejbNodeValue, int port) {
        this.ejbNodeFacade = ejbNodeFacade;
        this.ejbNodeValueFacade = ejbNodeValue;
        this.portNumber = port;
    }

    @Override
    public void run() {
        int count = 0;

        try {
            ServerSocket serSocket = new ServerSocket(portNumber);
            //timeout de 10 segundos
            //serSocket.setSoTimeout(10000);

            System.out.println("NotificationManagerSockect Initialized");
            while (true) {
                Socket connection = serSocket.accept();
                Runnable runnable = new NotificationThreadSockect(ejbNodeFacade, ejbNodeValueFacade, connection, ++count);
                Thread thread = new Thread(runnable);
                thread.start();
            }
        } catch (Exception e) {
            System.out.print("ERROR");
            System.out.print(e.getMessage());
        }
    }
}
