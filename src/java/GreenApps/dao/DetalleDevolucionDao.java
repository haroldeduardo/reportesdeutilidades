
package GreenApps.dao;

import GreenApps.model.DetalleDevolucion;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface DetalleDevolucionDao {
    
    public boolean ingresarDetalleDevolucion(Session sessionIngresarDetalleDevolucion, DetalleDevolucion detalleDevolucion) throws Exception;
    
}
