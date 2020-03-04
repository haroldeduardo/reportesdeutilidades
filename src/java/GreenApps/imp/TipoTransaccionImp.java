
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.TipoTransaccionDao;
import GreenApps.model.TipoTransaccion;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class TipoTransaccionImp implements TipoTransaccionDao{
    
    @Override
    public List<TipoTransaccion> mostrarTipoTransacciones(){
        
        List<TipoTransaccion> listaTipoTransacciones=null;
        Session sessionProducto = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionProducto.beginTransaction();
        String hql="FROM TipoTransaccion";
        
        try {
            listaTipoTransacciones = sessionProducto.createQuery(hql).list();
            t.commit();
            sessionProducto.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaTipoTransacciones;
    }

}