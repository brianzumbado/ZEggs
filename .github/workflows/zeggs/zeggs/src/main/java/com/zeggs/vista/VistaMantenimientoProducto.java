package com.zeggs.vista;

import com.zeggs.entidad.GrupoAnimal;
import com.zeggs.entidad.RegistroProducto;
import com.zeggs.servicio.ServicioRegistroProducto;
import com.zeggs.util.Message;
import com.zeggs.util.Utilitario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
    @Inject
    private Message msj;

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
            if (productoNuevo.getIdGrupoAnimal() != null) {
                servicioRegProducto.agregarPorGrupo(productoNuevo);
                msj.addMessage(FacesMessage.SEVERITY_INFO, "Guardado Exitoso", null);
                limpiar();
            }
        } catch (Exception ex) {
            msj.addMessage(FacesMessage.SEVERITY_ERROR, "Ocurrió un Error", null);
        }
    }

    public void cargaGruposAnimales() {
        listaGrupoAnimal = utilitario.cargaGrupoAnimal();
    }
    
    public void limpiar(){
        productoNuevo = new RegistroProducto();
    }

}
