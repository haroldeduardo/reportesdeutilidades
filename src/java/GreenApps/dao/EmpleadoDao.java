
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Empleado;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface EmpleadoDao {
    
    public List<Empleado> mostrarEmpleados();
    public void ingresarEmpleado(Empleado empleado); 
    public void actualizarEmpleado(Empleado empleado);
    public void eliminarEmpleado(Empleado empleado);
    
    public Empleado obtenerEmpleadoPorId (Session sessionEmpleadoPorId, Integer idEmpleado) throws Exception;
    
    public Empleado obtenerEmpleadoPorIdentificacion (Session sessionEmpleadoPorIdentificacion, Integer identificacionEmpleado) throws Exception;
            
}
