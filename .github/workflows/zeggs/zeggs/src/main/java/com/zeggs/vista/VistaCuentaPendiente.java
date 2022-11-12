package com.zeggs.vista;

import com.zeggs.entidad.Carton;
import com.zeggs.servicio.ServicioCarton;
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
public class VistaCuentaPendiente implements Serializable {

    @Inject
    private ServicioCarton servicioCarton;

    @Getter
    @Setter
    private List<Carton> listaCartones;
    @Getter
    @Setter
    private Integer totalSumListaCartones;

    @PostConstruct
    public void init() {
        listaCartones = new ArrayList<>();
        totalSumListaCartones = 0;
        cargarListaCartones();
    }

    public void cargarListaCartones() {
        listaCartones = servicioCarton.consultarPorUsuario(2l);
        for (Carton carton : listaCartones) {
            if (carton.getEstado() != 1) {
                totalSumListaCartones += carton.getPrecio();
            }
        }
    }
}
