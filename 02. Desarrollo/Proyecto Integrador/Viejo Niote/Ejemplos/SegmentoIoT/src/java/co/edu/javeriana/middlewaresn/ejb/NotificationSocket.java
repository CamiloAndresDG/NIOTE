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
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Oscar
 */
@Singleton
@Startup
public class NotificationSocket {

    @EJB
    private co.edu.javeriana.middlewaresn.ejb.ServiceNodeFacade ejbNodeFacade;

    @EJB
    private co.edu.javeriana.middlewaresn.ejb.ServiceNodeValueFacade ejbNodeValueFacade;

    ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;

    private ServiceNodeFacade getFacadeNode() {
        return ejbNodeFacade;
    }

    private ServiceNodeValueFacade getFacadeNodeValue() {
        return ejbNodeValueFacade;
    }

    @PostConstruct
    public void start() {

        try {

            List<String> list = getListeningPort();
            String hostSendMessage;
            int port;

            if (list != null && list.size() > 0) {

                hostSendMessage = list.get(0);
                port = Integer.parseInt(list.get(1));

                //Inicia el hilo que escucha los mensaje spor el socket parametrizado
                Runnable runnable = new NotificationManagerSockect(getFacadeNode(), getFacadeNodeValue(), port);
                Thread thread = new Thread(runnable);
                thread.start();

            }

        } catch (Exception ex) {
            System.out.println("ERROR " + NotificationSocket.class.getName() + Level.SEVERE + ex.getMessage());
            Logger.getLogger(NotificationSocket.class.getName()).log(Level.SEVERE, null, ex);
            //ex.printStackTrace();
        }
    }

    @PreDestroy
    public void stop() {
        try {
            providerSocket.close();
        } catch (IOException ex) {
            System.out.println(NotificationSocket.class.getName() + " " + Level.SEVERE + " " + ex.getMessage());
        }
    }

    public List<String> getListeningPort() {

        List<ServiceNode> serviceNodes = getFacadeNode().getAllServiceNode();
        List<String> configList = new ArrayList<String>();
        String server = null;
        String port = null;

        for (ServiceNode node : serviceNodes) {
            if (node.getProtocolType().getProtocolTypeId().equals(NodeType.UDP.ordinal())) {
                server = node.getIp();
                port = node.getIdSwsn();
            }
        }
        if (server != null) {
            configList.add(server);
            configList.add(port);
        }
        return configList;
    }

}
