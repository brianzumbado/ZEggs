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
import com.zeggs.validator.NotBlank;
import com.zeggs.validator.Size;
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
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String nombre;
    
    @Column(name = "apellido1")
    @NotBlank(message = "El primer apellido es obligatorio")
    @Size(max = 100, message = "El primer apellido no puede exceder los 100 caracteres")
    private String apellido1;
    
    @Column(name = "apellido2")
    @Size(max = 100, message = "El segundo apellido no puede exceder los 100 caracteres")
    private String apellido2;
    
    @Column(name = "username")
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(max = 50, message = "El nombre de usuario no puede exceder los 50 caracteres")
    private String username;
    
    @Column(name = "password")
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(max = 100, message = "La contraseña no puede exceder los 100 caracteres")
    private String password;
    
    @Column(name = "fec_registra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistra;
    
    /**
     * Obtiene la fecha de registro formateada
     * @return Fecha de registro como cadena
     */
    public String getFecRegistraFormatted() {
        if (fecRegistra != null) {
            return com.zeggs.util.DateUtil.formatDate(fecRegistra);
        }
        return null;
    }
}
    @Column(name = "rol")
    private Boolean rol;

}
