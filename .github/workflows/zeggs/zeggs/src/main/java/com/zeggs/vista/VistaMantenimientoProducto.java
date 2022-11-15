package com.zeggs.vista;

import com.zeggs.entidad.Carton;
import com.zeggs.entidad.GrupoAnimal;
import com.zeggs.entidad.RegistroProducto;
import com.zeggs.entidad.Usuario;
import com.zeggs.servicio.ServicioCarton;
import com.zeggs.servicio.ServicioRegistroProducto;
import com.zeggs.util.Utilitario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class VistaMantenimientoProducto implements Serializable {

    @Inject
    private ServicioRegistroProducto servicioRegProducto;
    @Inject
    private Utilitario utilitario;

    @Getter
    @Setter
    @NotNull
    private RegistroProducto productoNuevo = new RegistroProducto();
    @Getter
    @Setter
    private List<GrupoAnimal> listaGrupoAnimal = new ArrayList<>();

    @PostConstruct
    public void init() {
        cargaGruposAnimales();
    }

    public void agregarProducto() {
        try {
            productoNuevo.setFecRegistra(new Date());
            if (productoNuevo.getIdGrupoAnimal() != null) {
                servicioRegProducto.agregarPorGrupo(productoNuevo);
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../xhtml/principal.xhtml");
                FacesContext.getCurrentInstance().responseComplete();
            } else {
                //msj de error
            }
        } catch (Exception ex) {
            //msj error
        }
    }

    public void cargaGruposAnimales() {
        listaGrupoAnimal = utilitario.cargaGrupoAnimal();
    }

}
