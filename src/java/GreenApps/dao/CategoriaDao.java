
package GreenApps.dao;

import java.util.List;
import GreenApps.model.Categoria;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public interface CategoriaDao {
    
    public List<Categoria> mostrarCategorias();
    public void ingresarCategoria(Categoria categoria); 
    public void actualizarCategoria(Categoria categoria);
    public void eliminarCategoria(Categoria categoria);
            
}
