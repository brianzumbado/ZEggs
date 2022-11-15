package com.zeggs.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Brian
 */
@Entity
@Table(name = "grupo_animal")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedQueries({
    @NamedQuery(name = "ConsultaGrupoAnimal", query = "SELECT ga FROM GrupoAnimal ga")
})
public class GrupoAnimal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo_animal")
    @EqualsAndHashCode.Include
    private Long idGrupoAnimal;

    @Column(name = "id_tipo_animal")
    private Long idTipoAnimal;
    @Column(name = "nombre_grupo")
    private String nombreGrupo;
    @Column(name = "cantidad_animales")
    private Integer cantidadAnimales;
    @Column(name = "fec_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;
    @Column(name = "lugar_procedencia")
    private String lugarProcedencia;
    @Column(name = "fec_registra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistra;

}
