package com.zeggs.servicio;

import com.zeggs.entidad.Usuario;
import com.zeggs.util.ServicioGenerico;
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
public class ServicioUsuario extends ServicioGenerico {

    @PersistenceContext(unitName = "zeggsPU")
    EntityManager em;

    public List<Usuario> consultar() {
        try {
            return em.createNamedQuery("ConsultaUsuario", Usuario.class)
                    .getResultList();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Optional<Usuario> obtenerPorNombrePassword(String nombre, String password) {
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
