/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.datan.piico.piicows.controller.persistence;

import co.edu.usbbog.datan.piico.piicows.model.Institucion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 305
 */
@Stateless
public class InstitucionFacade extends AbstractFacade<Institucion> {

    @PersistenceContext(unitName = "piico_ws_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstitucionFacade() {
        super(Institucion.class);
    }
    
}
