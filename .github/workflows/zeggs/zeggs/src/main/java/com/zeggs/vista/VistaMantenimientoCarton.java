package com.zeggs.vista;

import com.zeggs.entidad.Carton;
import com.zeggs.entidad.Usuario;
import com.zeggs.servicio.ServicioCarton;
import com.zeggs.util.Utilitario;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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
    private Utilitario utilitario;

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
        try {                       
            cartonNuevo.setFecRegistra(new Date());
            if ((cartonNuevo.getIdUsuario() != null)
                    && (cartonNuevo.getEstado() != null)) {
                servicioCarton.agregarPorUsuario(cartonNuevo);
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../xhtml/principal.xhtml");
                FacesContext.getCurrentInstance().responseComplete();
            } else {
                //msj de error
            }
        } catch (Exception ex) {
            //msj error
        }
    }

    public void cargaUsuarios() {
        listaUsuario = utilitario.cargaUsuarios();
    }

}
