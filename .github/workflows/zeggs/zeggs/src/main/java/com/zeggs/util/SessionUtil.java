package com.zeggs.util;

import com.zeggs.entidad.Usuario;
import com.zeggs.seguridad.AdminSession;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Utilidades para el manejo de sesiones
 */
@Named
@RequestScoped
public class SessionUtil {
    
    @Inject
    private AdminSession adminSession;
    
    /**
     * Verifica si el usuario está autenticado
     * @return true si el usuario está autenticado, false en caso contrario
     */
    public boolean isLoggedIn() {
        return adminSession.isLoggedIn();
    }
    
    /**
     * Obtiene el usuario actual de la sesión
     * @return El usuario actual o null si no hay sesión
     */
    public Usuario getCurrentUser() {
        return adminSession.getUser();
    }
    
    /**
     * Cierra la sesión del usuario
     */
    public void logout() {
        adminSession.setUser(null);
        adminSession.setUserRedirected(false);
    }
}