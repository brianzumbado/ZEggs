package com.zeggs.vista;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
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
public class VistaPrincipal implements Serializable {

    @Getter
    @Setter
    @NotNull
    private String usuario;

    @PostConstruct
    public void init() {

    }
}
