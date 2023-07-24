package com.zeggs.vista;

import com.zeggs.entidad.Usuario;
import com.zeggs.seguridad.AdminSession;
import com.zeggs.seguridad.Constants;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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
public class VistaPrincipal implements Serializable {
    
    @Getter
    @Setter
    private Usuario usuario;
    
    @Inject
    private AdminSession user;

    @PostConstruct
    public void init() {
        usuario = user.getUser();
    }
    
    public String logout() {
        user = null;
        return "/" + Constants.DEFAULT_LOGIN_PAGE;
    }
}
