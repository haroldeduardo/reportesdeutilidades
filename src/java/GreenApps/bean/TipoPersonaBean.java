
package GreenApps.bean;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import GreenApps.dao.TipoPersonaDao;
import GreenApps.imp.TipoPersonaImp;
import GreenApps.model.TipoPersona;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */

@Named(value = "tipoPersonaBean")
@ManagedBean
@ViewScoped

public class TipoPersonaBean implements Serializable {

    private List<TipoPersona> listaTipoPersonas;
    private TipoPersona tipoPersona;
    
    public TipoPersonaBean() {
    }

    public void setListaProductos(List<TipoPersona> listaTipoPersonas) {
        this.listaTipoPersonas = listaTipoPersonas;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public List<TipoPersona> getListaTipoPersonas() {
        TipoPersonaDao tipDao = new TipoPersonaImp();
        listaTipoPersonas = tipDao.mostrarTipoPersonas();
        return listaTipoPersonas;
    }
    
    public void reportePersonas() throws Exception {
        
        TipoPersonaImp Dao;
        
        try{
            Dao = new TipoPersonaImp();
            listaTipoPersonas = Dao.mostrarTipoPersonas();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}