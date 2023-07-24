package com.zeggs.servicio;

import com.zeggs.entidad.RegistroProducto;
import com.zeggs.modelo.RegistroProductoModelo;
import com.zeggs.util.ServicioGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Brian
 */
@Stateless
public class ServicioRegistroProducto extends ServicioGenerico {

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

    public List<RegistroProductoModelo> consultarRegProductoPorDia() {
        try {
            List<RegistroProductoModelo> resultado = new ArrayList<>();

            StringBuilder sqlQuery = new StringBuilder("SELECT ");
            sqlQuery.append("RP.FEC_REGISTRA::DATE as FECHA_REGISTRA, ");
            sqlQuery.append("GA.NOMBRE_GRUPO , SUM(RP.CANTIDAD) AS CANTIDAD ");
            sqlQuery.append("FROM GRUPO_ANIMAL GA ");
            sqlQuery.append("INNER JOIN REGISTRO_PRODUCTO RP ON ");
            sqlQuery.append("GA.ID_GRUPO_ANIMAL = RP.ID_GRUPO_ANIMAL ");
            sqlQuery.append("WHERE RP.FEC_REGISTRA >= NOW()::DATE ");
            sqlQuery.append("GROUP BY (FECHA_REGISTRA, GA.NOMBRE_GRUPO) ");
            sqlQuery.append("ORDER BY FECHA_REGISTRA DESC ");

            List<Object[]> resultadoQuery = em.createNativeQuery(sqlQuery.toString())
                    .getResultList();

            for (Object[] obj : resultadoQuery) {
                RegistroProductoModelo regProd = new RegistroProductoModelo();
                regProd.setFecRegistra(convertirDate(obj[0]));
                regProd.setNombreGrupo(convertirString(obj[1]));
                regProd.setCantidadProducto(convertirLong(obj[2]));
                resultado.add(regProd);
            }

            return resultado;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
