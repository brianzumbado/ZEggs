package com.zeggs.servicio;

import com.zeggs.entidad.Carton;
import com.zeggs.entidad.RegistroProducto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Brian
 */
@Stateless
public class ServicioRegistroProducto {

    @PersistenceContext(unitName = "zeggsPU")
    EntityManager em;

    public List<RegistroProducto> consultarPorUsuario(Long idGrupoAnimal) {
        try {
            return em.createNamedQuery("PorGrupoAnimal", RegistroProducto.class)
                    .setParameter("idGrupoAnimal", idGrupoAnimal)
                    .getResultList();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void agregarPorGrupo(RegistroProducto producto) {
        try {
            em.persist(producto);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
