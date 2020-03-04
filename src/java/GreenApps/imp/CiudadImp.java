
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.CiudadDao;
import GreenApps.model.Ciudad;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class CiudadImp implements CiudadDao{

        @Override
    public List<Ciudad> mostrarCiudades() {
        
        List<Ciudad> listaCiudades=null;
        Session sessionProducto = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionProducto.beginTransaction();
        String hql="FROM Ciudad";
        
        try {
            listaCiudades = sessionProducto.createQuery(hql).list();
            t.commit();
            sessionProducto.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaCiudades;
    }
    
}
