
package GreenApps.bean;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import GreenApps.dao.PresentacionProductoDao;
import GreenApps.imp.PresentacionProductoImp;
import GreenApps.model.PresentacionProducto;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */

@Named(value = "presentacionProductoBean")
@ManagedBean
@ViewScoped

public class PresentacionProductoBean implements Serializable {

    private List<PresentacionProducto> listaPresentacionProductos;
    private PresentacionProducto presentacionProducto;
    
    public PresentacionProductoBean() {
    }

    public void setListaProductos(List<PresentacionProducto> listaPresentacionProductos) {
        this.listaPresentacionProductos = listaPresentacionProductos;
    }

    public PresentacionProducto getPresentacionProducto() {
        return presentacionProducto;
    }

    public void setPresentacionProducto(PresentacionProducto presentacionProducto) {
        this.presentacionProducto = presentacionProducto;
    }

    public List<PresentacionProducto> getListaPresentacionProductos() {
        PresentacionProductoDao preDao = new PresentacionProductoImp();
        listaPresentacionProductos = preDao.mostrarPresentacionProductos();
        return listaPresentacionProductos;
    }
    
    public void reportePresentacionesProducto() throws Exception {
        
        PresentacionProductoImp Dao;
        
        try{
            Dao = new PresentacionProductoImp();
            listaPresentacionProductos = Dao.mostrarPresentacionProductos();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}
