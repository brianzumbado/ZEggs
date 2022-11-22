package com.zeggs.vista;

import com.zeggs.entidad.Carton;
import com.zeggs.entidad.Usuario;
import com.zeggs.servicio.ServicioCarton;
import com.zeggs.util.Utilitario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Brian
 */
@Named
@ViewScoped
public class VistaConsultaPendiente implements Serializable {

    @Inject
    private ServicioCarton servicioCarton;
    @Inject
    private Utilitario utilitario;

    @Getter
    @Setter
    private List<Carton> listaCartones;
    @Getter
    @Setter
    private Integer totalSumListaCartones;
    @Getter
    @Setter
    private Long idUsuario = 0l;
    @Getter
    @Setter
    private List<Usuario> listaUsuario = new ArrayList<>();

    @PostConstruct
    public void init() {
        listaCartones = new ArrayList<>();
        cargaUsuarios();
        cargarListaCartones();
    }

    public void cargarListaCartones() {
        listaCartones = servicioCarton.consultarPorUsuario(idUsuario);
        totalSumListaCartones = 0;
        for (Carton carton : listaCartones) {
            if (carton.getEstado() != 1) {
                totalSumListaCartones += carton.getPrecio();
            }
        }
    }

    public void cargaUsuarios() {
        listaUsuario = utilitario.cargaUsuarios();
    }
}
