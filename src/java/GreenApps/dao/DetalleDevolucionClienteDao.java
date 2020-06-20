
package GreenApps.dao;

import GreenApps.model.DetalleDevolucionCliente;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface DetalleDevolucionClienteDao {
    
    public boolean ingresarDetalleDevolucionCliente(Session sessionIngresarDetalleDevolucionCliente, DetalleDevolucionCliente detalleDevolucionCliente) throws Exception;
    
}
