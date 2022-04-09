/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segmento.iot.nodos;

import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author Andres Sanchez
 */
public class Temperatura {

    public void getTemperatura() {
        W1Master master = new W1Master();
        List<W1Device> w1Devices = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);
        for (W1Device device : w1Devices) {
            //this line is enought if you want to read the temperature
            String temperatura = ((TemperatureSensor) device).getTemperature()+"";
            System.out.println("Temperatura: " + temperatura);
            enviarMensajeMosquitto(temperatura);
            //returns the temperature as double rounded to one decimal place after the point

            /*try {
                System.out.println("1-Wire ID: " + device.getId() + " value: " + device.getValue());
                //returns the ID of the Sensor and the  full text of the virtual file
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }
    
    public void enviarMensajeMosquitto(String content){
        String topic        = "mqtt/temp";
        int qos             = 2;
        //String broker       = "tcp://iot.eclipse.org:1883";
        String broker       = "tcp://192.168.0.103:1883";
        String clientId     = "SensorTem";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            
            
            if (sampleClient.isConnected()) {
                
            }else{
                connOpts.setCleanSession(true);
                System.out.println("Connecting to broker: "+broker);
                sampleClient.connect(connOpts);
            }            
            System.out.println("Connected");
            System.out.println("Publishing message: "+content);
            
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            //sampleClient.disconnect();
            //System.out.println("Disconnected");
            //System.exit(0);
            
            
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        Temperatura t = new Temperatura();
        while (true) {            
            try {
                t.getTemperatura();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }

}
