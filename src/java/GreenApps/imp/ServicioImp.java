
package GreenApps.imp;

import java.util.List;
import javax.faces.context.FacesContext;
import GreenApps.model.Servicio;
import org.hibernate.Query;
import org.hibernate.Session;
import GreenApps.util.HibernateUtil;
import org.hibernate.Transaction;
import GreenApps.dao.ServicioDao;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class ServicioImp implements ServicioDao{

    @Override
    public List<Servicio> mostrarServicios(){
        
        List<Servicio> listaServicios=null;
        Session sessionServicio = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionServicio.beginTransaction();
        String hql="FROM Servicio";
        
        try {
            listaServicios = sessionServicio.createQuery(hql).list();
            t.commit();
            sessionServicio.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaServicios;
    }
    
    @Override
    public Servicio obtenerServicioPorIdServicio(int idServicio) throws Exception {
        Session sessionServicio = HibernateUtil.getSessionFactory().openSession();
        String hql="FROM Servicio WHERE idServicio = :idServicio";
        Query q = sessionServicio.createQuery(hql);
        q.setParameter("idServicio", idServicio);
                return (Servicio) q.uniqueResult();
    }
    
    @Override
    public Servicio obtenerUltimoRegistroServicio(Session sessionUltimoRegistroServicio) throws Exception {
        String hql = "FROM Servicio ORDER BY idServicio DESC";
        Query q = sessionUltimoRegistroServicio.createQuery(hql).setMaxResults(1);
        return (Servicio) q.uniqueResult();
    }

    @Override
    public Long obtenerTotalRegistrosServicio(Session sessionRegistrosServicio) {
        String hql = "SELECT COUNT(*) FROM Servicio";
        Query q = sessionRegistrosServicio.createQuery(hql);
        return (Long) q.uniqueResult();
    }

    @Override
    public long ingresarServicio(Session sessionIngresarServicio, Servicio servicio) throws Exception {
        
        Query q =sessionIngresarServicio.createQuery("SELECT COUNT(*) FROM Servicio");
        long num = (Long) q.uniqueResult()+1;
        servicio.setNumeroServicio(String.valueOf(num));
         
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numServicio",num);
        
        sessionIngresarServicio.save(servicio);
        return num;
    }
    
    @Override
    public void actualizarServicio(Servicio servicio) {
    
        Session sessionProducto = null;
        try {
            sessionProducto = HibernateUtil.getSessionFactory().openSession();
            sessionProducto.beginTransaction();
            sessionProducto.update(servicio);
            sessionProducto.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionProducto.getTransaction().rollback();
        } finally {
            if (sessionProducto!=null){
                sessionProducto.close();
            }
        }
    }
    
    @Override
    public void actualizarTotalServicio(int idServicio, float total) {

        Session sessionServicio = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionServicio.beginTransaction();

        try {
            Query query = sessionServicio.createQuery("UPDATE Servicio SET totalServicio = :totalServicio" + " WHERE idServicio = :idServicio");
            query.setParameter("totalServicio", total);
            query.setParameter("idServicio", idServicio);
            query.executeUpdate();

            t.commit();
            sessionServicio.close();
        } catch (Exception e) {
            t.rollback();
        }

    }
    
}