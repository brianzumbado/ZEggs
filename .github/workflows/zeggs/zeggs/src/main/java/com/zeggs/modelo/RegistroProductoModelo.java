package com.zeggs.modelo;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Brian
 */
@Getter
@Setter
public class RegistroProductoModelo implements Serializable {

    private Long idGrupoAnimal;
    private Long idRegProducto;
    private String dscGrupoAnimal;
    private Long idTipoAnimal;
    private String dscTipoAnimal;
    private String nombreGrupo;
    private Integer cantidadAnimales;
    private Long cantidadProducto;
    private Date fecIngreso;
    private String lugarProcedencia;
    private Date fecRegistra;

}
