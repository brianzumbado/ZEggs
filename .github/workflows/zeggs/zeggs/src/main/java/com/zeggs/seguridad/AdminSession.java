package com.zeggs.seguridad;

import com.zeggs.entidad.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@SessionScoped
public class AdminSession implements Serializable {

    private static final long serialVersionUID = 1L;

    @Produces
    @Named("user")
    @Setter
    @Getter
    private Usuario user;

    /**
     * Indica si el usuario esta logeado o no.
     *
     * @return true si está logeado, false en caso contrario
     */
    public boolean isLoggedIn() {
        return user != null;
    }

    /**
     * avoid multiple redirects when redirecting user back to previous page
     * after session expiration.
     */
    @Getter
    @Setter
    private boolean userRedirected = false;

}
