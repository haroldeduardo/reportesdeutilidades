
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.PresentacionProductoDao;
import GreenApps.model.PresentacionProducto;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class PresentacionProductoImp implements PresentacionProductoDao{
    
    @Override
    public List<PresentacionProducto> mostrarPresentacionProductos(){
        
        List<PresentacionProducto> listaPresentacionProductos=null;
        Session sessionProducto = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionProducto.beginTransaction();
        String hql="FROM PresentacionProducto";
        
        try {
            listaPresentacionProductos = sessionProducto.createQuery(hql).list();
            t.commit();
            sessionProducto.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaPresentacionProductos;
    }

}
