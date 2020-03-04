
package GreenApps.dao;

import GreenApps.model.DetalleCotizacion;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface DetalleCotizacionDao {
    
    public boolean ingresarDetalleCotizacion(Session sessionIngresarDetalleCotizacion, DetalleCotizacion detalleCotizacion) throws Exception;
    
}