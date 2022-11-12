package com.zeggs.vista;

import com.zeggs.entidad.Usuario;
import com.zeggs.servicio.ServicioUsuario;
import java.io.Serializable;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Brian
 */
@Named
@ViewScoped
public class VistaLogin implements Serializable {

    @Inject
    private ServicioUsuario servicioUsuario;

    @Getter
    @Setter
    @NotNull
    private String usuario;
    @Getter
    @Setter
    @NotNull
    private String clave;

    @PostConstruct
    public void init() {

    }

    public String login() {
        Optional<Usuario> oUsuario = servicioUsuario.obtenerPorNombre(usuario, clave);
        return oUsuario.isPresent() ? "/xhtml/principal?faces-redirect=true" : "";
    }
}
