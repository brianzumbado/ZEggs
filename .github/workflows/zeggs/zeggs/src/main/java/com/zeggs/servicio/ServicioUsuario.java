package com.zeggs.servicio;

import com.zeggs.entidad.Usuario;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Brian
 */
@Stateless
public class ServicioUsuario {

    @PersistenceContext(unitName = "zeggsPU")
    EntityManager em;

    public List<Usuario> consultar() {
        try {
            return em.createNamedQuery("ConsultaTodos", Usuario.class)
                    .getResultList();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Optional<Usuario> obtenerPorNombre(String nombre, String password) {
        try {
            List<Usuario> resultado = em.createNamedQuery("PorNombrePassword", Usuario.class)
                    .setParameter("username", nombre)
                    .setParameter("password", password)
                    .getResultList();
            return resultado.isEmpty() ? Optional.empty() : Optional.of(resultado.get(0));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
