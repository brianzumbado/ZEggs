package com.zeggs.vista;

import com.zeggs.entidad.Usuario;
import com.zeggs.seguridad.AdminSession;
import com.zeggs.seguridad.Constants;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author GBSYS. Diseñado y Desarrollado por: Ing. Herman Barrantes
 */
@Named
@RequestScoped
public class VistaAutenticar {

//    private static final Logger LOG = LoggerFactory.getLogger(VistaAutenticar.class);
    //Servicios
    @Inject
    private AdminSession adminSession;

    public String autenticar(Optional<Usuario> usuario) {
        try {
//            String token = Faces.getRequestParameter("token");
//            Usuario usuario = obtenerUsuario(usr, password);
            adminSession.setUser(usuario.get());
            return "/" + Constants.DEFAULT_INDEX_PAGE;
        } catch (Exception ex) {
//            LOG.error("VistaAutenticar.autenticar()", ex);
//            Messages.addGlobalError("Ocurrió un error al autenticar");
            return "/" + Constants.DEFAULT_LOGIN_PAGE;
        }
    }

    private Usuario obtenerUsuario(String usr, String password) throws Exception {
//        Usuario usuario = servicioToken.getClaimFromToken(token, cla -> Usuario.crear(
//                cla.get(Token.UET, String.class),
//                cla.getSubject(),
//                cla.get(Token.UCE, String.class),
//                cla.get(Token.UPA, String.class),
//                cla.get(Token.USA, String.class),
//                cla.get(Token.UNO, String.class),
//                cla.get(Token.UNI, Long.class),
//                cla.get(Token.UTI, Integer.class),
//                cla.get(Token.USI, String.class),
//                cla.get(Token.UUP, Long.class),
//                EnumModuloSistema.valueOf(cla.get(Token.UMS, String.class)),
//                cla.get(Token.UPR, String.class),
//                new ArrayList<>(),
//                new ArrayList<>()));

//        UsuarioDTO usu = servicioMise.obtenerUsuario(usuario.getCodigoUsuario());
//        SistemaDTO sis = new SistemaDTO();
//        sis.setCodigo(usuario.getSistema());
//        UnidadEjecutoraDTO unidad = new UnidadEjecutoraDTO();
//        unidad.setCodigo(usuario.getUnidadEjecutora());
//        CuentaUsuarioDTO cuenta = new CuentaUsuarioDTO();
//        cuenta.setIndicadorEstado(1);
//        cuenta.setUsuario(usu);
//        cuenta.setSistema(sis);
//        cuenta.setUnidadEjecutora(unidad);
//        List<PerfilDTO> perfilesDto = servicioMise.obtenerPerfiles(cuenta);
//        PerfilDTO perfilDto = perfilesDto
//                .stream()
//                .filter(p -> usuario.getPerfil().equals(p.getDescripcionCorta()))
//                .findAny()
//                .orElse(null);
//        List<String> perfiles = perfilesDto
//                .stream()
//                .map(p -> p.getDescripcionCorta())
//                .collect(Collectors.toList());
//        List<RestriccionDTO> restriccionesDto
//                = servicioMise.obtenerRestriccionesRecurso(sis, perfilDto);
//        List<String> restricciones = restriccionesDto
//                .stream()
//                .filter(r -> r.getIndicadorOpcion().equals(1))
//                .map(r -> r.getRecurso().getNombreProgramacion().trim())
//                .collect(Collectors.toList());
//        return Usuario.crear(
//                usuario.getEstacionTrabajo(),
//                usuario.getCodigoUsuario(),
//                usuario.getCorreoElectronico(),
//                usuario.getPrimerApellido(),
//                usuario.getSegundoApellido(),
//                usuario.getNombre(),
//                usuario.getNumeroIdentificacion(),
//                usuario.getTipoIdentificacion(),
//                usuario.getSistema(),
//                usuario.getUnidadEjecutora(),
//                usuario.getModulo(),
//                usuario.getPerfil(),
//                perfiles,
//                restricciones);
        return null;
    }
}
