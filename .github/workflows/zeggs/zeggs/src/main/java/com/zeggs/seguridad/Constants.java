package com.zeggs.seguridad;

/**
 * Constantes del proyecto web.
 *
 * @author GBSYS. Diseñado y Desarrollado por: Ing. Herman Barrantes
 * @version 1.0.0
 * @date 30/05/2018 10:52
 */
public class Constants {

    /**
     * Página principal.
     */
    public static final String DEFAULT_INDEX_PAGE = "xhtml/principal.xhtml?faces-redirect=true";

    /**
     * Página de login.
     */
    public static final String DEFAULT_LOGIN_PAGE = "xhtml/login.xhtml?faces-redirect=true";

    /**
     * Página de error.
     */
    public static final String DEFAULT_ERROR_PAGE = "xhtml/error.xhtml?faces-redirect=true";

    /**
     * Página de 404 no encontrado.
     */
    public static final String DEFAULT_NOT_FOUND_PAGE = "xhtml/notfound.xhtml?faces-redirect=true";

    /**
     * Página de acceso denegado.
     */
    public static final String DEFAULT_ACCESS_DENIED_PAGE = "xhtml/access.xhtml?faces-redirect=true";

    /**
     * Página de sesión expirada.
     */
    public static final String DEFAULT_EXPIRED_PAGE = "xhtml/invalidstate.xhtml?faces-redirect=true";

    /**
     * Indica si está desactivado el filtro de seguridad.
     */
    public static final boolean DISABLE_FILTER = false;
    /**
     * Lista separada por coma de recursos a ignorar.
     */
    public static final String IGNORED_RESOURCES = "";

}
