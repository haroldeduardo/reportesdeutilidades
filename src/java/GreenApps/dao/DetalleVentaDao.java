
package GreenApps.dao;

import GreenApps.model.DetalleVenta;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface DetalleVentaDao {
    
    public boolean ingresarDetalleVenta(Session sessionIngresarDetalleVenta, DetalleVenta detalleVenta) throws Exception;
    
    public List<DetalleVenta> mostrarDetalleVentasIdVenta(int idVenta);
    
}