package com.zeggs.vista;

import com.zeggs.entidad.Usuario;
import com.zeggs.exception.BusinessException;
import com.zeggs.seguridad.Constants;
import com.zeggs.servicio.ServicioUsuario;
import com.zeggs.util.ValidationUtil;
import java.io.Serializable;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
    @Inject
    private VistaAutenticar autenticar;
    @Inject
    private FacesContext facesContext;

    @Getter
    @Setter
    private String usuario;
    
    @Getter
    @Setter
    private String clave;

    @PostConstruct
    public void init() {

    }

    public String login() {
        // Validar entrada
        if (usuario == null || usuario.trim().isEmpty()) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Error de autenticación", "El nombre de usuario es obligatorio"));
            return null;
        }
        
        if (clave == null || clave.trim().isEmpty()) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Error de autenticación", "La contraseña es obligatoria"));
            return null;
        }
        
        // Normalizar el nombre de usuario
        usuario = ValidationUtil.normalizeUsername(usuario);
        
        try {
            Optional<Usuario> oUsuario = servicioUsuario.obtenerPorNombrePassword(usuario, clave);
            if (oUsuario.isPresent()) {
                return autenticar.autenticar(oUsuario.get());
            } else {
                // Mostrar mensaje de error más descriptivo
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error de autenticación", "Nombre de usuario o contraseña incorrectos"));
                return null;
            }
        } catch (BusinessException ex) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Error de autenticación", "Ocurrió un error al intentar iniciar sesión"));
            return null;
        }
    }
}
