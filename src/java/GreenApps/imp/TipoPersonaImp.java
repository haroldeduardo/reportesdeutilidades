
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.TipoPersonaDao;
import GreenApps.model.TipoPersona;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class TipoPersonaImp implements TipoPersonaDao{
    
    @Override
    public List<TipoPersona> mostrarTipoPersonas(){
        
        List<TipoPersona> listaTipoPersonas=null;
        Session sessionProducto = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionProducto.beginTransaction();
        String hql="FROM TipoPersona";
        
        try {
            listaTipoPersonas = sessionProducto.createQuery(hql).list();
            t.commit();
            sessionProducto.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaTipoPersonas;
    }

}