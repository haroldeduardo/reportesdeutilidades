
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Moto;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface MotoDao {
    
    public List<Moto> mostrarMotos();
    public void ingresarMoto(Moto moto); 
    public void actualizarMoto(Moto moto);
    public void eliminarMoto(Moto moto);
            
}
