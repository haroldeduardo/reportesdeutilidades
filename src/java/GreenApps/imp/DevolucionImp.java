
package GreenApps.imp;

import javax.faces.context.FacesContext;
import GreenApps.dao.DevolucionDao;
import GreenApps.model.Devolucion;
import GreenApps.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class DevolucionImp implements DevolucionDao{

    @Override
    public List<Devolucion> mostrarDevoluciones(){
        
        List<Devolucion> listaDevoluciones=null;
        Session sessionDevolucion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionDevolucion.beginTransaction();
        String hql="FROM Devolucion";
        
        try {
            listaDevoluciones = sessionDevolucion.createQuery(hql).list();
            t.commit();
            sessionDevolucion.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaDevoluciones;
    }
    
    @Override
    public Devolucion obtenerUltimoRegistroDevolucion(Session sessionUltimoRegistroDevolucion) throws Exception {
        String hql = "FROM Devolucion ORDER BY idDevolucion DESC";
        Query q = sessionUltimoRegistroDevolucion.createQuery(hql).setMaxResults(1);
        return (Devolucion) q.uniqueResult();
    }

    @Override
    public Long obtenerTotalRegistrosDevolucion(Session sessionRegistrosDevolucion) {
        String hql = "SELECT COUNT(*) FROM Devolucion";
        Query q = sessionRegistrosDevolucion.createQuery(hql);
        return (Long) q.uniqueResult();
    }

    @Override
    public long ingresarDevolucion(Session sessionIngresarDevolucion, Devolucion devolucion) throws Exception {
        
        Query q =sessionIngresarDevolucion.createQuery("SELECT COUNT(*) FROM Devolucion");
        long num = (Long) q.uniqueResult()+1;
        devolucion.setNumeroDevolucion(String.valueOf(num));
         
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numDevolucion",num);
        
        sessionIngresarDevolucion.save(devolucion);
        return num;
    }
    
}

