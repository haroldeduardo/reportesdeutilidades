
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Cotizacion;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface CotizacionDao {
    
    public List<Cotizacion> mostrarCotizaciones();
    
    public Cotizacion obtenerUltimoRegistroCotizacion( Session sessionUltimoRegistroCotizacion) throws Exception;
    
    public Long obtenerTotalRegistrosCotizacion(Session sessionRegistrosCotizacion);
    
    public long ingresarCotizacion (Session sessionIngresarCotizacion, Cotizacion cotizacion) throws Exception;
    
}
