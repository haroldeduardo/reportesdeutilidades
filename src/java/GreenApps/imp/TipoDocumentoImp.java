
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.TipoDocumentoDao;
import GreenApps.model.TipoDocumento;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class TipoDocumentoImp implements TipoDocumentoDao{
    
    @Override
    public List<TipoDocumento> mostrarTipoDocumentos(){
        
        List<TipoDocumento> listaTipoDocumentos=null;
        Session sessionProducto = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionProducto.beginTransaction();
        String hql="FROM TipoDocumento";
        
        try {
            listaTipoDocumentos = sessionProducto.createQuery(hql).list();
            t.commit();
            sessionProducto.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaTipoDocumentos;
    }

}