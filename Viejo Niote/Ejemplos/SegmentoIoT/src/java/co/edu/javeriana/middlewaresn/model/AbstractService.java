/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.model;

/**
 *
 * @author Oscar
 */
public abstract class AbstractService {
    
    private Message msg;

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }
        
    public AbstractService(Message m) 
    {
        msg = m;
    }
    
    public abstract void updateService(String value);

    public abstract Message consultService();
    
}
