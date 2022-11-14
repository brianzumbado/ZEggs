package com.zeggs.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "usuario_rol")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedQueries({
    @NamedQuery(name = "PorIdUsuarioIdRol", query = "SELECT ur FROM UsuarioRol ur WHERE ur.idUsuario = :idUsuario AND ur.idRol = :idRol")
})
public class UsuarioRol implements Serializable {

    @Id
    @Column(name = "id_usuario")
    @EqualsAndHashCode.Include
    private Long idUsuario;
    @Id
    @Column(name = "id_rol")
    @EqualsAndHashCode.Include
    private Long idRol;

    @Column(name = "fec_registra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistra;

}
