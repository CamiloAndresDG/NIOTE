/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.model;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author Oscar
 */
public class ConcreteServiceMQTT extends AbstractService {

    private String broker;
    private String clientId;
    private int qos;
    private MemoryPersistence persistence;
    private String topic;
    private String content;

    public ConcreteServiceMQTT(Message m) {
        super(m);
        broker = ParameterMQTT.MQTTServer;
        clientId = ParameterMQTT.ClientIdSendMessage;
        qos = ParameterMQTT.qos;
        persistence = new MemoryPersistence();
        topic = ParameterMQTT.defaultTopic;
        content = "";
    }

    @Override
    public void updateService(String value) {
        try {
            //La IP identifica al servidor al que estara asignado el nodo
            broker = getMsg().getNode().getIp();

            //Asignar el topico al que debe estar asignado el mensaje
            topic = getMsg().getNode().getIdSwsn();
            
            content = value;
            MqttClient clientSendMessage = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            //System.out.println("Connecting to broker: " + broker);
            clientSendMessage.connect(connOpts);
            //System.out.println("Connected");

            System.out.println("Publishing message: " + content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            clientSendMessage.publish(topic, message);
            clientSendMessage.disconnect();
            //System.out.println("Disconnected");

            System.out.println("server " + broker + " Message [" + content + "] published on toppic " + topic);

        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

    @Override
    public Message consultService() {
        System.out.println("consultService Not supported yet.");
        return null;
    }

}
