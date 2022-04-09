/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.ejb;

import co.edu.javeriana.middlewaresn.entities.ServiceNode;
import co.edu.javeriana.middlewaresn.entities.ServiceNodeValue;
import co.edu.javeriana.middlewaresn.model.NodeType;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Oscar
 */
public class NotificationThreadSockect implements Runnable {

    private Socket connection;
    private int ID;
    private ServiceNodeFacade ejbNode;
    private ServiceNodeValueFacade ejbNodeValue;

    @EJB
    private co.edu.javeriana.middlewaresn.ejb.ServiceNodeFacade ejbNodeFacade;

    @EJB
    private co.edu.javeriana.middlewaresn.ejb.ServiceNodeValueFacade ejbNodeValueFacade;

    NotificationThreadSockect(ServiceNodeFacade ejbNode, ServiceNodeValueFacade ejbNodeValue, Socket s, int i) {
        this.ejbNode = ejbNode;
        this.ejbNodeValue = ejbNodeValue;
        //this.ejbNodeFacade = ejbNode;
        //this.ejbNodeValueFacade = ejbNodeValue;
        this.connection = s;
        this.ID = i;
    }

    private ServiceNodeFacade getFacadeNode() {
        return ejbNodeFacade;
    }

    private ServiceNodeValueFacade getFacadeNodeValue() {
        return ejbNodeValueFacade;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in;
            String message;
            String hostName;
            int portNumber;

            //1. get Input streams
            in = new ObjectInputStream(connection.getInputStream());
            hostName = connection.getInetAddress().getHostName();
            portNumber = connection.getLocalPort();
            System.out.println("Connection " + Integer.valueOf(ID) + " received from " + hostName);

            //2. Recibe communicate via the input streams
            try {
                message = (String) in.readObject();
                System.out.println("Connection received from " + hostName + " - menssage " + message);
                if (message != null && message.length() > 0) {
                    saveMessage(hostName, portNumber, message);
                }
            } catch (ClassNotFoundException classnot) {
                System.err.println("Data received in unknown format " + classnot.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public void saveMessage(String serverName, int portNumber, String message) {

        String port = String.valueOf(portNumber);
        System.out.println("LLego mensaje servidor " + serverName + ":" + port + " - mensaje " + message);

        try {
            //Consultar los servicios a los que pertenece el nodo
            //para persistir el valor recibido desde el socket
            System.out.println("Paso 1 ");
            //List<ServiceNode> serviceNodes = getFacadeNode().getAllServiceNode();
            List<ServiceNode> serviceNodes = ejbNode.getAllServiceNode();
            System.out.println("Paso 1.5 ");
            for (ServiceNode node : serviceNodes) {
                if (node.getProtocolType().getProtocolTypeId().equals(NodeType.UDP.ordinal())) {
                    System.out.println("Paso 2 IP=" + node.getIp() + " - Port=" + node.getIdSwsn());
                    //if (node.getIp().equals(serverName)
                    //        && node.getIdSwsn().equals(port)) {
                        System.out.println("Paso 3 ");
                        ServiceNodeValue snv = new ServiceNodeValue();
                        snv.setServiceNode(node);
                        snv.setDate(new Date());
                        snv.setValue(message.toString());
                        System.out.println("Paso 4 ");
                        //getFacadeNodeValue().edit(snv);
                        ejbNodeValue.edit(snv);
                        System.out.println("Paso Final ");
                    //}
                }
            }
        } catch (Exception ex) {
            System.out.println("Error al persistir el mensaje " + ex.getMessage());
            ex.getStackTrace();
        }

    }

}
