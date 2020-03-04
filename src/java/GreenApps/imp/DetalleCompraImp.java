
package GreenApps.imp;

import GreenApps.dao.DetalleCompraDao;
import GreenApps.model.DetalleCompra;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class DetalleCompraImp implements DetalleCompraDao{

    @Override
    public boolean ingresarDetalleCompra(Session sessionIngresarDetalleCompra, DetalleCompra detalleCompra) throws Exception {
        sessionIngresarDetalleCompra.save(detalleCompra);
        return true; 
    }
    
}
