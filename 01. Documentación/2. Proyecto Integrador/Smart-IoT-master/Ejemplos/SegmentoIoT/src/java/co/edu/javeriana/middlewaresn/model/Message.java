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
public class Message {
    
    private Service service;
    private ServiceNode node;
    private String value;
    
    public Message(Service s, ServiceNode n)
    {
        service = s;
        node = n;
    }

    public Service getService() {
        return service;
    }

    public ServiceNode getNode() {
        return node;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
