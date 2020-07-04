
package GreenApps.dao;

import java.util.List;
import GreenApps.model.DevolucionProveedor;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface DevolucionProveedorDao {
    
    public List<DevolucionProveedor> mostrarDevolucionesProveedor();
    
    public DevolucionProveedor obtenerUltimoRegistroDevolucionProveedor( Session sessionUltimoRegistroDevolucionProveedor) throws Exception;
    
    public Long obtenerTotalRegistrosDevolucionProveedor(Session sessionRegistrosDevolucionProveedor);
    
    public long ingresarDevolucionProveedor (Session sessionIngresarDevolucionProveedor, DevolucionProveedor devolucionProveedor) throws Exception;
    
}
