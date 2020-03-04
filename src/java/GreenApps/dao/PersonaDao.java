
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Persona;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface PersonaDao {
    
    public List<Persona> mostrarPersonas();
    public void ingresarPersona(Persona persona); 
    public void actualizarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
    
    public Persona obtenerPersonaPorId (Session sessionPersonaPorId, Integer idPersona) throws Exception;
    
    public Persona obtenerPersonaPorIdentificacion (Session sessionPersonaPorIdentificacion, Integer identificacionPersona) throws Exception;
            
}

