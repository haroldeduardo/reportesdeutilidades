
package GreenApps.bean;

import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import GreenApps.imp.InterfaceUsuarioImp;
import GreenApps.model.Usuario;
import org.primefaces.context.RequestContext;
import GreenApps.dao.InterfaceUsuarioDao;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */

@Named(value = "interfaceUsuarioBean")
@SessionScoped

public class InterfaceUsuarioBean implements Serializable {

    private Usuario usuario;
    
    private String username;
     
    private String password;
    
    private int idEmpleado;
    
    public InterfaceUsuarioBean() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
   
    public void loginUsuario(ActionEvent event) {
        
        RequestContext rc = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        
        boolean loggedIn = false;
        String Ruta = "";
        
        InterfaceUsuarioDao uDao = new InterfaceUsuarioImp();
        
        this.usuario = uDao.ingresoSistema(this.usuario);
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", this.usuario.getUserEmp());
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("password", this.usuario.getPassEmp());
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id", this.usuario.getIdEmpleado());                     
       
        if(this.usuario != null) {
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUserEmp());
            
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", this.usuario.getUserEmp());
            Ruta = "/GreenApps-Demo/faces/views/HomePage/HomePage.xhtml";
            
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Accesso Invalido", "Verifique Usuario & Password");
            this.usuario = new Usuario();
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        rc.addCallbackParam("loggedIn", loggedIn);
        rc.addCallbackParam("Ruta", Ruta);
    }
    
    public String finalizarSesion(){
        this.username = null;
        this.password = null;
        
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        return "/indexInterface";  
    }
    
}