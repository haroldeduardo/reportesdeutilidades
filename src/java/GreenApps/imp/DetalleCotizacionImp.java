
package GreenApps.imp;

import GreenApps.dao.DetalleCotizacionDao;
import GreenApps.model.DetalleCotizacion;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class DetalleCotizacionImp implements DetalleCotizacionDao{

    @Override
    public boolean ingresarDetalleCotizacion(Session sessionIngresarDetalleCotizacion, DetalleCotizacion detalleCotizacion) throws Exception {
        sessionIngresarDetalleCotizacion.save(detalleCotizacion);
        return true; 
    }
    
}