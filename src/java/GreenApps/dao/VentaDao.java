
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Venta;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface VentaDao {
    
    public List<Venta> mostrarVentas();
    
    public Venta obtenerVentaPorIdVenta(int idVenta) throws Exception;
    
    public Venta obtenerUltimoRegistroVenta (Session sessionUltimoRegistroVenta) throws Exception;
    
    public Long obtenerTotalRegistrosVenta (Session sessionRegistrosVenta);
    
    public long ingresarVenta (Session sessionIngresarVenta, Venta venta) throws Exception;
    
    public void imprimirVenta(Venta venta);
    
}
