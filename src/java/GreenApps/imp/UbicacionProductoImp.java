
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.UbicacionProductoDao;
import GreenApps.model.UbicacionProducto;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class UbicacionProductoImp implements UbicacionProductoDao{
    
    @Override
    public List<UbicacionProducto> mostrarUbicacionProductos(){
        
        List<UbicacionProducto> listaUbicacionProductos=null;
        Session sessionProducto = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionProducto.beginTransaction();
        String hql="FROM UbicacionProducto";
        
        try {
            listaUbicacionProductos = sessionProducto.createQuery(hql).list();
            t.commit();
            sessionProducto.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaUbicacionProductos;
    }

}
