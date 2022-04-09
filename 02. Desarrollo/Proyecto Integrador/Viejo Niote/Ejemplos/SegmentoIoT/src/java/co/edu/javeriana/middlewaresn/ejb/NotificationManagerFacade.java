/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.ejb;

import co.edu.javeriana.middlewaresn.entities.Service;
import co.edu.javeriana.middlewaresn.entities.ServiceNode;
import co.edu.javeriana.middlewaresn.entities.ServiceNodeValue;
import co.edu.javeriana.middlewaresn.model.ManagerService;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oscar
 */
@Stateless
public class NotificationManagerFacade extends AbstractFacade<ServiceNodeValue> {
    @PersistenceContext(unitName = "SegmentoIoTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificationManagerFacade() {
        super(ServiceNodeValue.class);
    }
    
    public void SendMessage(Service s, ServiceNode sn, String message)
    {
        ManagerService ms = new ManagerService(s, sn);
        ms.sendMessage(message);
    }
    
}
