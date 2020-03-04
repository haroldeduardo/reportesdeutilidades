
package GreenApps.imp;

import GreenApps.dao.DetalleDevolucionDao;
import GreenApps.model.DetalleDevolucion;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class DetalleDevolucionImp implements DetalleDevolucionDao{

    @Override
    public boolean ingresarDetalleDevolucion(Session sessionIngresarDetalleDevolucion, DetalleDevolucion detalleDevolucion) throws Exception {
        sessionIngresarDetalleDevolucion.save(detalleDevolucion);
        return true; 
    }
    
}