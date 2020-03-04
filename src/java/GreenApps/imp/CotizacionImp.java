
package GreenApps.imp;

import javax.faces.context.FacesContext;
import GreenApps.dao.CotizacionDao;
import GreenApps.model.Cotizacion;
import GreenApps.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class CotizacionImp implements CotizacionDao{

    @Override
    public List<Cotizacion> mostrarCotizaciones(){
        
        List<Cotizacion> listaCotizaciones=null;
        Session sessionCotizacion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionCotizacion.beginTransaction();
        String hql="FROM Cotizacion";
        
        try {
            listaCotizaciones = sessionCotizacion.createQuery(hql).list();
            t.commit();
            sessionCotizacion.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaCotizaciones;
    }
    
    @Override
    public Cotizacion obtenerUltimoRegistroCotizacion(Session sessionUltimoRegistroCotizacion) throws Exception {
        String hql = "FROM Cotizacion ORDER BY idCotizacion DESC";
        Query q = sessionUltimoRegistroCotizacion.createQuery(hql).setMaxResults(1);
        return (Cotizacion) q.uniqueResult();
    }

    @Override
    public Long obtenerTotalRegistrosCotizacion(Session sessionRegistrosCotizacion) {
        String hql = "SELECT COUNT(*) FROM Cotizacion";
        Query q = sessionRegistrosCotizacion.createQuery(hql);
        return (Long) q.uniqueResult();
    }

    @Override
    public long ingresarCotizacion(Session sessionIngresarCotizacion, Cotizacion cotizacion) throws Exception {
        
        Query q =sessionIngresarCotizacion.createQuery("SELECT COUNT(*) FROM Cotizacion");
        long num = (Long) q.uniqueResult()+1;
        cotizacion.setNumeroCotizacion(String.valueOf(num));
         
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numCotizacion",num);
        
        sessionIngresarCotizacion.save(cotizacion);
        return num;
    }
    
}