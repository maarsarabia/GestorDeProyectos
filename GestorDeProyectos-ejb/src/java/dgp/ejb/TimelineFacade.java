/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgp.ejb;

import dgp.entity.Timeline;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sistema
 */
@Stateless
public class TimelineFacade extends AbstractFacade<Timeline> {

    @PersistenceContext(unitName = "GestorDeProyectos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TimelineFacade() {
        super(Timeline.class);
    }
    
}
