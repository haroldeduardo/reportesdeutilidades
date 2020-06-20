
package GreenApps.imp;

import GreenApps.model.DetalleDevolucionCliente;
import org.hibernate.Session;
import GreenApps.dao.DetalleDevolucionClienteDao;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class DetalleDevolucionClienteImp implements DetalleDevolucionClienteDao{

    @Override
    public boolean ingresarDetalleDevolucionCliente(Session sessionIngresarDetalleDevolucionCliente, DetalleDevolucionCliente detalleDevolucionCliente) throws Exception {
        sessionIngresarDetalleDevolucionCliente.save(detalleDevolucionCliente);
        return true; 
    }
    
}