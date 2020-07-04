
package GreenApps.dao;

import GreenApps.model.DetalleDevolucionProveedor;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface DetalleDevolucionProveedorDao {
    
    public boolean ingresarDetalleDevolucionProveedor(Session sessionIngresarDetalleDevolucionProveedor, DetalleDevolucionProveedor detalleDevolucionProveedor) throws Exception;
    
}
