/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.ejb;

import co.edu.javeriana.middlewaresn.entities.ServiceNode;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Oscar
 */
@Stateless
public class ServiceNodeFacade extends AbstractFacade<ServiceNode> {
    @PersistenceContext(unitName = "SegmentoIoTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceNodeFacade() {
        super(ServiceNode.class);
    }
 
    public List<ServiceNode> getAllServiceNode() {
        TypedQuery<ServiceNode> queryAllServicesNodes;
        queryAllServicesNodes = getEntityManager().createNamedQuery("ServiceNode.findAll", ServiceNode.class);
        List<ServiceNode> serviceNodes = queryAllServicesNodes.getResultList();
        return serviceNodes;
    }

}
