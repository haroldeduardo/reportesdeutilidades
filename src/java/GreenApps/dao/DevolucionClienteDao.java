
package GreenApps.dao;

import java.util.List;
import GreenApps.model.DevolucionCliente;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface DevolucionClienteDao {
    
    public List<DevolucionCliente> mostrarDevolucionesCliente();
    
    public DevolucionCliente obtenerUltimoRegistroDevolucionCliente( Session sessionUltimoRegistroDevolucionCliente) throws Exception;
    
    public Long obtenerTotalRegistrosDevolucionCliente(Session sessionRegistrosDevolucionCliente);
    
    public long ingresarDevolucionCliente (Session sessionIngresarDevolucionCliente, DevolucionCliente devolucionCliente) throws Exception;
    
}
