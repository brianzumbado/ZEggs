package com.zeggs.servicio;

import com.zeggs.entidad.GrupoAnimal;
import com.zeggs.entidad.Usuario;
import com.zeggs.modelo.GrupoAnimalModelo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Brian
 */
@Stateless
public class ServicioGrupoAnimal {

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
    
    /**
     * Analizar como hacer la pantalla XHTML para ver si seria util o no este query
     * @return 
     */
    public List<GrupoAnimalModelo> consultarGrupoAnimalTipoProducto() {
        try {
            return em.createNativeQuery("select ga.,rp.cantidad, rp.fec_registra as fec_registra_producto from grupo_animal ga "
                    + "inner join registro_producto rp on ga.id_grupo_animal = rp.id_grupo_animal", GrupoAnimalModelo.class)
                    .getResultList();
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
