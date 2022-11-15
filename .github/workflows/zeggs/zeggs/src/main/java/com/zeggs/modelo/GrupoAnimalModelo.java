package com.zeggs.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author Brian
 */
@Data
public class GrupoAnimalModelo implements Serializable {
    
    private Long idGrupoAnimal;
    private String dscGrupoAnimal;
    private Long idTipoAnimal;
    private String dscTipoAnimal;
    private String nombreGrupo;
    private Integer cantidadAnimales;
    private Integer cantidadProducto;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;
    private String lugarProcedencia;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistra;

}
