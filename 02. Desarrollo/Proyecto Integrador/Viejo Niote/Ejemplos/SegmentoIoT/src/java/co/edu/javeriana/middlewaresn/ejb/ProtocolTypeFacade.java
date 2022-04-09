/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.ejb;

import co.edu.javeriana.middlewaresn.entities.ProtocolType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oscar
 */
@Stateless
public class ProtocolTypeFacade extends AbstractFacade<ProtocolType> {
    @PersistenceContext(unitName = "SegmentoIoTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProtocolTypeFacade() {
        super(ProtocolType.class);
    }
    
}
