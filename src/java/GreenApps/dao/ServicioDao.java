
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Servicio;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface ServicioDao {
    
    public List<Servicio> mostrarServicios();
    
    public Servicio obtenerServicioPorIdServicio(int idServicio) throws Exception;
    
    public Servicio obtenerUltimoRegistroServicio(Session sessionUltimoRegistroServicio) throws Exception;
    
    public Long obtenerTotalRegistrosServicio(Session sessionRegistrosServicio);
    
    public long ingresarServicio (Session sessionIngresarServicio, Servicio servicio) throws Exception;
    
    public void actualizarServicio(Servicio servicio);
    
    public void actualizarTotalServicio(int idServicio, float total);
    
}