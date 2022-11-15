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
@Table(name = "registro_producto")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedQueries({
    @NamedQuery(name = "PorGrupoAnimal", query = "SELECT p FROM RegistroProducto p WHERE p.idGrupoAnimal = :idGrupoAnimal")
})
public class RegistroProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_producto")
    @EqualsAndHashCode.Include
    private Long idRegistroProducto;

    @Column(name = "id_grupo_animal")
    private Long idGrupoAnimal;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "fec_registra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistra;

}
