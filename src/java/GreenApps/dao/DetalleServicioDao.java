
package GreenApps.dao;

import java.util.List;
import GreenApps.model.DetalleServicio;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface DetalleServicioDao {
    
    public List<DetalleServicio> mostrarDetalleServicios();
    
    public List<DetalleServicio> mostrarDetalleServiciosIdServicio(int idServicio);
    
    public void actualizarDetalleServicio(DetalleServicio detalleServicio);
    
    public void editarDetalleServicio(DetalleServicio detalleServicio);
    
    public void eliminarDetalleServicio(DetalleServicio detalleServicio);
    
    public float totalDetalleServicioIdServicio(int idServicio);
    
    public boolean ingresarDetalleServicio(Session sessionIngresarDetalleServicio, DetalleServicio detalleServicio) throws Exception;
    
}