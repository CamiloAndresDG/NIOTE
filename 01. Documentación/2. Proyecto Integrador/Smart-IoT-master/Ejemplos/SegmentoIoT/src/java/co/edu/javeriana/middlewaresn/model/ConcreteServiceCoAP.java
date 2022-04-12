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
public class ConcreteServiceCoAP extends AbstractService {

    public ConcreteServiceCoAP(Message m) {
        super(m);
    }

    @Override
    public void updateService(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message consultService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
