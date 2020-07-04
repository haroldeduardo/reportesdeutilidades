
package GreenApps.imp;

import GreenApps.model.DetalleDevolucionProveedor;
import org.hibernate.Session;
import GreenApps.dao.DetalleDevolucionProveedorDao;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class DetalleDevolucionProveedorImp implements DetalleDevolucionProveedorDao{

    @Override
    public boolean ingresarDetalleDevolucionProveedor(Session sessionIngresarDetalleDevolucionProveedor, DetalleDevolucionProveedor detalleDevolucionProveedor) throws Exception {
        sessionIngresarDetalleDevolucionProveedor.save(detalleDevolucionProveedor);
        return true; 
    }
    
}