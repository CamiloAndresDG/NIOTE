/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.niote.controlador.logica;

import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JOptionPane;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Clase para verificar si existe el Broker mosquito y configurar los protocolos
 * TCP/IP y MQTT
 *
 * @author Andrés Sánchez, Juan Ochoa, Sebastian Villanueva.
 */
public class ValidacionesSistema {

    /*
    Paso en el que va
    */
    String paso;
    Boolean validacionPantalla=false;
    /**
     * Método constructor genérico
     */
    public ValidacionesSistema() {
    }

    /**
     * Método que verifica si está disponible las conexiones para
     * Cliente/Servidor y Publicador/Suscriptor
     *
     * @return true si está preparado, false si no están las dos conexiones
     */
    public boolean estaConfiguradoElSistema() {
        return (configuracionMQTT() && configuracionTCPIP());
    }

    /**
     * validación de conexión Publicador/Suscriptor mediante Broker MQTT
     * instalado local en el puerto 1883
     *
     * @return true si está instalado y habilitado el broker, false si falla la
     * conexión al broker MQTT
     */
    private boolean configuracionMQTT() {
        String topic = "prueba/neiote";
        int qos = 2;
        String broker = "tcp://localhost:1883";
        String clientId = "prueba";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            String content = "Hola";
            connOpts.setCleanSession(true);
            sampleClient.connect(connOpts);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            sampleClient.disconnect();
            return true;
        } catch (MqttException me) {
            JOptionPane.showMessageDialog(null, "Ha fallado el emulador al inciar Razon: Error en el MQTT ");
            paso="Configurando MQTT";
            return false;
        }
    }

    /**
     * Validación de conexión Cliente/Servidor mediante Sockets TCP/IP
     * instalados en los puertos 9998 y 9999
     *
     * @return true si están habilitados los puertos TCP/IP, false si falla la
     * conexión a alguno de los puertos TCP/IP
     */
    private boolean configuracionTCPIP() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(9999);
            if (serverSocket.getLocalPort() == -1) {
                return false;
            }
            serverSocket.close();
            serverSocket = new ServerSocket(9998);
            if (serverSocket.getLocalPort() == -1) {
                return false;
            }
            serverSocket.close();
            return true;

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ha fallado el emulador al inciar Razon: Error en el TCPIP");
            paso="Configurando TCPIP";
            return false;
        }
    }

    public String getPaso() {
        return paso;
    }

    public void setPaso(String paso) {
        this.paso = paso;
    }

    public Boolean getValidacionPantalla() {
        return validacionPantalla;
    }

    public void setValidacionPantalla(Boolean validacion) {
        this.validacionPantalla = validacion;
    }

}
