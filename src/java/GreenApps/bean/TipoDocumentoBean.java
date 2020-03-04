
package GreenApps.bean;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import GreenApps.dao.TipoDocumentoDao;
import GreenApps.imp.TipoDocumentoImp;
import GreenApps.model.TipoDocumento;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */

@Named(value = "tipoDocumentoBean")
@ManagedBean
@ViewScoped

public class TipoDocumentoBean implements Serializable {

    private List<TipoDocumento> listaTipoDocumentos;
    private TipoDocumento tipoDocumento;
    
    public TipoDocumentoBean() {
    }

    public void setListaProductos(List<TipoDocumento> listaTipoDocumentos) {
        this.listaTipoDocumentos = listaTipoDocumentos;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<TipoDocumento> getListaTipoDocumentos() {
        TipoDocumentoDao tipDao = new TipoDocumentoImp();
        listaTipoDocumentos = tipDao.mostrarTipoDocumentos();
        return listaTipoDocumentos;
    }
    
    public void reporteTipoDocumentos() throws Exception {
        
        TipoDocumentoImp Dao;
        
        try{
            Dao = new TipoDocumentoImp();
            listaTipoDocumentos = Dao.mostrarTipoDocumentos();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}
