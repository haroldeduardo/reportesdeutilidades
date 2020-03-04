
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Usuario;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface UsuarioDao {
    
    public List<Usuario> mostrarUsuarios();
    public void ingresarUsuario(Usuario usuario); 
    public void actualizarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    
}
