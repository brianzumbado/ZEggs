package com.zeggs.vista;

import com.zeggs.entidad.Carton;
import com.zeggs.entidad.Usuario;
import com.zeggs.servicio.ServicioCarton;
import com.zeggs.servicio.ServicioUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class VistaMantenimientoCarton implements Serializable {

    @Inject
    private ServicioCarton servicioCarton;
    @Inject
    private ServicioUsuario servicioUsuario;

    @Getter
    @Setter
    @NotNull
    private Carton cartonNuevo = new Carton();
    @Getter
    @Setter
    private List<Usuario> listaUsuario = new ArrayList<>();

    @PostConstruct
    public void init() {
        cargaUsuarios();
    }

    public void agregarCarton() {
        cartonNuevo.setFecRegistra(new Date());
        servicioCarton.agregarPorUsuario(cartonNuevo);
    }

    public void cargaUsuarios() {
        listaUsuario = servicioUsuario.consultar();
    }

}
