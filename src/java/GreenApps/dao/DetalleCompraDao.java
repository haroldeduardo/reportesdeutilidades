
package GreenApps.dao;

import GreenApps.model.DetalleCompra;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface DetalleCompraDao {
    
    public boolean ingresarDetalleCompra(Session sessionIngresarDetalleCompra, DetalleCompra detalleCompra) throws Exception;
    
}
