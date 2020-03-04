
package GreenApps.bean;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import GreenApps.dao.UsuarioDao;
import GreenApps.imp.UsuarioImp;
import GreenApps.model.Usuario;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */

@Named(value = "usuarioBean")
@ManagedBean
@ViewScoped

public class UsuarioBean implements Serializable {

    private List<Usuario> listaUsuarios;
    private Usuario usuario = new Usuario();
    
    public UsuarioBean() {
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        UsuarioDao usuDao = new UsuarioImp();
        listaUsuarios = usuDao.mostrarUsuarios();
        return listaUsuarios;
    }
    
    public void nuevoUsuario(){
        usuario = new Usuario();
    }
    
    public void ingresarUsuario(){
        UsuarioDao usuDao = new UsuarioImp();
        usuDao.ingresarUsuario(usuario);
    }
    
    public void actualizarUsuario(){
        UsuarioDao usuDao = new UsuarioImp();
        usuDao.actualizarUsuario(usuario);
        usuario = new Usuario();
    }
    
    public void eliminarUsuario(){
        UsuarioDao usuDao = new UsuarioImp();
        usuDao.eliminarUsuario(usuario);
        usuario = new Usuario();
    }
    
    public void reporteUsuarios() throws Exception {
        
        UsuarioImp Dao;
        
        try{
            Dao = new UsuarioImp();
            listaUsuarios = Dao.mostrarUsuarios();
        }
        catch(Exception e){
        throw e;
        }
    }
        
}