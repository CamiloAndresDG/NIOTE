/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.model;

import co.edu.javeriana.middlewaresn.entities.Service;
import co.edu.javeriana.middlewaresn.entities.ServiceNode;

/**
 *
 * @author Oscar
 */
public class ManagerService {
    
    private AbstractService networkSensor;
    
    public ManagerService(Service s, ServiceNode sn) 
    {
        Message msg = new Message(s, sn);
        
        if (sn.getProtocolType().getProtocolTypeId().equals(NodeType.MQTT.ordinal())) 
        {
            networkSensor = new ConcreteServiceMQTT(msg);
        } 
        else if (sn.getProtocolType().getProtocolTypeId().equals(NodeType.UDP.ordinal())) 
        {
            networkSensor = new ConcreteServiceSocket(msg);
        }
        else if (sn.getProtocolType().getProtocolTypeId().equals(NodeType.CoAP.ordinal())) 
        {
            networkSensor = new ConcreteServiceCoAP(msg);
        }
        else  
        {
            networkSensor = new ConcreteServiceMQTT(msg);
        }
    }
    
    public void sendMessage(String menssage) 
    {
        networkSensor.updateService(menssage);
    }
    
    public String consultService() 
    {
        Message msg = networkSensor.consultService();
        return msg.getValue();
    }
    
}
