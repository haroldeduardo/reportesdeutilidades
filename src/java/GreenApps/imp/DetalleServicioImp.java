
package GreenApps.imp;

import java.util.List;
import GreenApps.util.HibernateUtil;
import GreenApps.dao.DetalleServicioDao;
import GreenApps.model.DetalleServicio;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class DetalleServicioImp implements DetalleServicioDao {

    @Override
    public List<DetalleServicio> mostrarDetalleServicios() {

        List<DetalleServicio> listaDetalleServicios = null;
        Session sessionServicio = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionServicio.beginTransaction();
        String hql = "FROM DetalleServicio";

        try {
            listaDetalleServicios = sessionServicio.createQuery(hql).list();
            t.commit();
            sessionServicio.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaDetalleServicios;
    }

    @Override
    public List<DetalleServicio> mostrarDetalleServiciosIdServicio(int idServicio) {
        List<DetalleServicio> listaDetalleServicios = null;
        Session sessionServicio = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionServicio.beginTransaction();
        String hql = "FROM DetalleServicio WHERE idServicio = " + idServicio;

        try {
            listaDetalleServicios = sessionServicio.createQuery(hql).list();
            t.commit();
            sessionServicio.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaDetalleServicios;
    }

    @Override
    public void actualizarDetalleServicio(DetalleServicio detalleServicio) {

        Session sessionDetalleServicio = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionDetalleServicio.beginTransaction();

        try {

            Query query = sessionDetalleServicio.createQuery("UPDATE DetalleServicio SET unidadesVendidas = :unidadesVendidas, totalDetalleServicio =:totalDetalleServicio" + " WHERE idDetalleServicio = :idDetalleServicio");
            query.setParameter("unidadesVendidas", detalleServicio.getUnidadesVendidas());
            query.setParameter("totalDetalleServicio", detalleServicio.getTotalDetalleServicio());
            query.setParameter("idDetalleServicio", detalleServicio.getIdDetalleServicio());
            query.executeUpdate();

            t.commit();
            sessionDetalleServicio.close();
        } catch (Exception e) {
            t.rollback();
        }

    }

    @Override
    public void editarDetalleServicio(DetalleServicio detalleServicio) {
    
        Session sessionDetalleServicio = null;
        try {
            sessionDetalleServicio = HibernateUtil.getSessionFactory().openSession();
            sessionDetalleServicio.beginTransaction();
            sessionDetalleServicio.update(detalleServicio);
            sessionDetalleServicio.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionDetalleServicio.getTransaction().rollback();
        } finally {
            if (sessionDetalleServicio!=null){
                sessionDetalleServicio.close();
            }
        }
    }
    
    @Override
    public void eliminarDetalleServicio(DetalleServicio detalleServicio) {
    
        Session sessionDetalleServicio = null;
        try {
            sessionDetalleServicio = HibernateUtil.getSessionFactory().openSession();
            sessionDetalleServicio.beginTransaction();
            sessionDetalleServicio.delete(detalleServicio);
            sessionDetalleServicio.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionDetalleServicio.getTransaction().rollback();
        } finally {
            if (sessionDetalleServicio!=null){
                sessionDetalleServicio.close();
            }
        }
    }
    
    @Override
    public float totalDetalleServicioIdServicio(int idServicio) {

        float total = 0;
        Session sessionServicio = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionServicio.beginTransaction();
        String hql = "SELECT ds.idServicio, sum(ds.totalDetalleServicio) FROM DetalleServicio ds WHERE idServicio = " + idServicio + "GROUP BY ds.idServicio";

        try {
            List<Object[]> listDatos = sessionServicio.createQuery(hql).list();
            for (Object[] datos : listDatos) {
                total = Float.parseFloat(datos[1].toString());
            }
            t.commit();
            sessionServicio.close();
        } catch (Exception e) {
            t.rollback();
        }

        return total;
    }

    @Override
    public boolean ingresarDetalleServicio(Session sessionIngresarDetalleServicio, DetalleServicio detalleServicio) throws Exception {
        sessionIngresarDetalleServicio.save(detalleServicio);
        return true;
    }

}
