package com.zeggs.servicio;

import com.zeggs.entidad.GrupoAnimal;
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
public class ServicioGrupoAnimal extends ServicioGenerico {

    @PersistenceContext(unitName = "zeggsPU")
    EntityManager em;

    public List<GrupoAnimal> consultar() {
        try {
            return em.createNamedQuery("ConsultaGrupoAnimal", GrupoAnimal.class)
                    .getResultList();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
