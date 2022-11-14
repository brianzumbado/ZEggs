package com.zeggs.vista;

import com.zeggs.entidad.Carton;
import com.zeggs.servicio.ServicioCarton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Brian
 */
@Named
@ViewScoped
public class VistaMantenimientoCarton implements Serializable {

    @Inject
    private ServicioCarton servicioCarton;

    @Getter
    @Setter
    private Carton cartonNuevo = new Carton();

    @PostConstruct
    public void init() {
    }
    
    public void agregarCarton(){
        cartonNuevo.setFecRegistra(new Date());
        servicioCarton.agregarPorUsuario(cartonNuevo);
    }
}
