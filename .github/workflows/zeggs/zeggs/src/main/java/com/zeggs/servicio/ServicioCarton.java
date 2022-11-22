package com.zeggs.servicio;

import com.zeggs.entidad.Carton;
import com.zeggs.util.ServicioGenerico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Brian
 */
@Stateless
public class ServicioCarton extends ServicioGenerico {

    @PersistenceContext(unitName = "zeggsPU")
    EntityManager em;

    public List<Carton> consultarPorUsuario(Long idUsuario) {
        try {
            return em.createNamedQuery("PorUsuario", Carton.class)
                    .setParameter("idUsuario", idUsuario)
                    .getResultList();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void agregarPorUsuario(Carton carton) {
        try {
            em.persist(carton);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
