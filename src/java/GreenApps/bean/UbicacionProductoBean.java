
package GreenApps.bean;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import GreenApps.dao.UbicacionProductoDao;
import GreenApps.imp.UbicacionProductoImp;
import GreenApps.model.UbicacionProducto;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */

@Named(value = "ubicacionProductoBean")
@ManagedBean
@ViewScoped

public class UbicacionProductoBean implements Serializable {

    private List<UbicacionProducto> listaUbicacionProductos;
    private UbicacionProducto ubicacionProducto;
    
    public UbicacionProductoBean() {
    }

    public void setListaProductos(List<UbicacionProducto> listaUbicacionProductos) {
        this.listaUbicacionProductos = listaUbicacionProductos;
    }

    public UbicacionProducto getUbicacionProducto() {
        return ubicacionProducto;
    }

    public void setUbicacionProducto(UbicacionProducto ubicacionProducto) {
        this.ubicacionProducto = ubicacionProducto;
    }

    public List<UbicacionProducto> getListaUbicacionProductos() {
        UbicacionProductoDao ubiDao = new UbicacionProductoImp();
        listaUbicacionProductos = ubiDao.mostrarUbicacionProductos();
        return listaUbicacionProductos;
    }
    
    public void reporteUbicacionesProducto() throws Exception {
        
        UbicacionProductoImp Dao;
        
        try{
            Dao = new UbicacionProductoImp();
            listaUbicacionProductos = Dao.mostrarUbicacionProductos();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}
