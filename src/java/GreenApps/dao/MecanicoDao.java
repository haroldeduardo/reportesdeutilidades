
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Mecanico;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface MecanicoDao {
    
    public List<Mecanico> mostrarMecanicos();
    public void ingresarMecanico(Mecanico mecanico); 
    public void actualizarMecanico(Mecanico mecanico);
    public void eliminarMecanico(Mecanico mecanico);
    
    public Mecanico obtenerMecanicoPorId (Session sessionMecanicoPorId, Integer idMecanico) throws Exception;
    
    public Mecanico obtenerMecanicoPorIdentificacion (Session sessionMecanicoPorIdentificacion, Integer identificacionMecanico) throws Exception;
    
}
