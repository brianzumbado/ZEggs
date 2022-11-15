package com.zeggs.util;

import com.zeggs.entidad.Usuario;
import com.zeggs.servicio.ServicioUsuario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Brian
 */
@Named
public class Utilitario implements Serializable {

    @Inject
    private ServicioUsuario servicioUsuario;
    
    public List<Usuario> cargaUsuarios() {
        return servicioUsuario.consultar();
    }
}
