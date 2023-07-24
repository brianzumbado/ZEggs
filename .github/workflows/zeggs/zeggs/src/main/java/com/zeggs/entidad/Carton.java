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
@Table(name = "carton")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedQueries({
    @NamedQuery(name = "PorUsuario", query = "SELECT c FROM Carton c WHERE c.idUsuario = :idUsuario")
})
public class Carton implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carton")
    @EqualsAndHashCode.Include
    private Long idCarton;

    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "id_tipo_animal")
    private Long idTipoAnimal;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "fec_registra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistra;

}
