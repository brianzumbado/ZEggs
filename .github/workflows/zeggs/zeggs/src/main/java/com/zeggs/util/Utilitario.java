package com.zeggs.util;

import com.zeggs.entidad.GrupoAnimal;
import com.zeggs.entidad.Usuario;
import com.zeggs.servicio.ServicioGrupoAnimal;
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
    @Inject
    private ServicioGrupoAnimal servicioGrupoAnimal;

    public List<Usuario> cargaUsuarios() {
        return servicioUsuario.consultar();
    }

    public List<GrupoAnimal> cargaGrupoAnimal() {
        return servicioGrupoAnimal.consultar();
    }
}
