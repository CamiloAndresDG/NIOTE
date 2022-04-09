/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.ejb;

import co.edu.javeriana.middlewaresn.entities.ServiceNode;
import co.edu.javeriana.middlewaresn.entities.ServiceNodeValue;
import co.edu.javeriana.middlewaresn.model.NodeType;
import co.edu.javeriana.middlewaresn.model.ParameterMQTT;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import red.nodos.ubicuos.ServiciosSensor;

/**
 *
 * @author Oscar
 */
@Singleton
@Startup
public class NotificationMQTT implements MqttCallback {

    @EJB
    private co.edu.javeriana.middlewaresn.ejb.ServiceNodeFacade ejbNodeFacade;

    @EJB
    private co.edu.javeriana.middlewaresn.ejb.ServiceNodeValueFacade ejbNodeValueFacade;

    private static String status;
    static MqttClient client;
    


    private ServiceNodeFacade getFacadeNode() {
        return ejbNodeFacade;
    }

    private ServiceNodeValueFacade getFacadeNodeValue() {
        return ejbNodeValueFacade;
    }

    @PostConstruct
    public void start() {
        System.out.println("inicio MQTT");
        try {

            ParameterMQTT parMQTT = new ParameterMQTT();
            List<String> list = getListeningTopic();
            String server = "";

            if (list != null && list.size() > 0) {

                server = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                String[] arr = new String[list.size()];
                list.toArray(arr);

                client = new MqttClient(server, parMQTT.ClientIdListener, new MemoryPersistence());
                client.connect();
                client.setCallback(this);
                client.subscribe(arr);
            }
            
             MqttMessage message = new MqttMessage();
             message.setPayload("Mensaje de prueba desde el servidor:!!".getBytes());
             client.publish(parMQTT.defaultTopic, message);
             
            status = "Ready";

        } catch (MqttException ex) {
            System.out.println("ERROR " + NotificationMQTT.class.getName() + Level.SEVERE + ex.getMessage());
            Logger.getLogger(NotificationMQTT.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("metodo connectionLost Ocurrio un error al recuperar los mensajes en el bean NotificationMQTT - causa:" + cause.getMessage());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        //System.out.println("LLego mensaje Topico " + topic + " mensaje " + message.toString());
        
        
        //aqui envia a utilidad o ami
        String textMessage = message.toString();

        try {
            //Consultar los servicios a los que pertenece el nodo
            //para persistir el valor recibido desde el brokey MQTT

            List<ServiceNode> serviceNodes = getFacadeNode().getAllServiceNode();
            for (ServiceNode node : serviceNodes) {
                if (node.getProtocolType().getProtocolTypeId().equals(NodeType.MQTT.ordinal())) {
                    if (node.getIdSwsn().equals(topic)) {
                        ServiceNodeValue snv = new ServiceNodeValue();
                        snv.setServiceNode(node);
                        snv.setDate(new Date());
                        snv.setValue(textMessage);
                        ServiciosSensor.enviarEvetosTemperatura(topic, textMessage);
                        getFacadeNodeValue().edit(snv);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error al persistir el mensaje " + ex.getMessage());
            ex.getStackTrace();
        }

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("mensaje completamente entregado deliveryComplete " + token.toString());
    }

    public List<String> getListeningTopic() {

        List<ServiceNode> serviceNodes = getFacadeNode().getAllServiceNode();
        List<String> topicsList = new ArrayList<String>();
        String server = null;

        for (ServiceNode node : serviceNodes) {
            if (node.getProtocolType().getProtocolTypeId().equals(NodeType.MQTT.ordinal())) {
                server = node.getIp();
                topicsList.add(node.getIdSwsn());
            }
        }
        if (server != null) {
            topicsList.add(server);
        }

        return topicsList;
    }

}
