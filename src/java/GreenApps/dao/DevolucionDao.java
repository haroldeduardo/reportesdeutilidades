
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Devolucion;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface DevolucionDao {
    
    public List<Devolucion> mostrarDevoluciones();
    
    public Devolucion obtenerUltimoRegistroDevolucion( Session sessionUltimoRegistroDevolucion) throws Exception;
    
    public Long obtenerTotalRegistrosDevolucion(Session sessionRegistrosDevolucion);
    
    public long ingresarDevolucion (Session sessionIngresarDevolucion, Devolucion devolucion) throws Exception;
    
}
