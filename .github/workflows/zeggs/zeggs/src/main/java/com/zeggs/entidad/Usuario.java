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
@Table(name = "usuario")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedQueries({
    @NamedQuery(name = "ConsultaUsuario", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "PorNombrePassword", query = "SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password")
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @EqualsAndHashCode.Include
    private Long idUsuario;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "fec_registra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistra;
    @Column(name = "rol")
    private Boolean rol;

}
