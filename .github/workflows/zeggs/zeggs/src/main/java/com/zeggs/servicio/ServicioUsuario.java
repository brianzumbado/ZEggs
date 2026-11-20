package com.zeggs.servicio;

import com.zeggs.entidad.Usuario;
import com.zeggs.exception.BusinessException;
import com.zeggs.util.ServicioGenerico;
import com.zeggs.util.PasswordUtil;
import com.zeggs.util.ValidationUtil;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 *
 * @author Brian
 */
@Stateless
public class ServicioUsuario extends ServicioGenerico {

    @PersistenceContext(unitName = "zeggsPU")
    EntityManager em;
    
    @Inject
    private Validator validator;

    public Optional<Usuario> obtenerPorNombrePassword(String nombre, String password) throws BusinessException {
        try {
            TypedQuery<Usuario> query = em.createNamedQuery("PorNombrePassword", Usuario.class)
                    .setParameter("username", nombre);
            
            // Usar getSingleResult() en lugar de getResultList() para mejor rendimiento
            Usuario usuario = query.getSingleResult();
            
            // Verificar contraseña
            if (usuario != null && PasswordUtil.verifyPassword(password, usuario.getPassword())) {
                return Optional.of(usuario);
            }
            
            return Optional.empty();
        } catch (Exception ex) {
            // Manejo más específico de excepciones
            if (ex.getMessage().contains("No entity found")) {
                return Optional.empty();
            }
            throw new BusinessException("Error al buscar usuario", ex);
        }
    }
    
    public void guardar(Usuario usuario) throws BusinessException {
        // Validar el objeto
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Usuario> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            throw new BusinessException(sb.toString());
        }
        
        // Guardar el usuario
        em.persist(usuario);
    }
}
