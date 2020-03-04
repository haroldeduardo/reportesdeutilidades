
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Producto;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface ProductoDao {
    
    public List<Producto> mostrarProductos();
    public void ingresarProducto(Producto producto); 
    public void actualizarProducto(Producto producto);
    public void eliminarProducto(Producto producto);
    
    public Producto obtenerProductoPorCodigoProducto(Session sessionProductoPorCodigoProducto, String codigoProducto) throws Exception;
    
    public boolean validarStockProducto(Session sessionProductoPorCodigoProducto, String codigoProducto, int unidadesRequeridas) throws Exception;
            
}