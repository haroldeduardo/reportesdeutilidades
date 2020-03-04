
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Compra;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface CompraDao {
    
    public List<Compra> mostrarCompras();
    
    public Compra obtenerUltimoRegistroCompra (Session sessionUltimoRegistroCompra) throws Exception;
    
    public Long obtenerTotalRegistrosCompra (Session sessionRegistrosCompra);
    
    public long ingresarCompra (Session sessionIngresarCompra, Compra compra) throws Exception;
    
}
