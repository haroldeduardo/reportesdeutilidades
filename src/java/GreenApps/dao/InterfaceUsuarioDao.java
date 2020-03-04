
package GreenApps.dao;

import GreenApps.model.Usuario;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface InterfaceUsuarioDao {
    
    public Usuario obtenerInformacionPorUsuario(Usuario usuario);
    
    public Usuario ingresoSistema(Usuario usuario);
    
}
