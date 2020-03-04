
package GreenApps.imp;

import GreenApps.dao.DetalleVentaDao;
import GreenApps.model.DetalleVenta;
import GreenApps.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class DetalleVentaImp implements DetalleVentaDao{

    @Override
    public boolean ingresarDetalleVenta(Session sessionIngresarDetalleVenta, DetalleVenta detalleVenta) throws Exception {
        sessionIngresarDetalleVenta.save(detalleVenta);
        return true; 
    }
    
    @Override
    public List<DetalleVenta> mostrarDetalleVentasIdVenta(int idVenta) {
        List<DetalleVenta> listaDetalleVentas = null;
        Session sessionVenta = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionVenta.beginTransaction();
        String hql = "FROM DetalleVenta WHERE idVenta = " + idVenta;

        try {
            listaDetalleVentas = sessionVenta.createQuery(hql).list();
            t.commit();
            sessionVenta.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaDetalleVentas;
    }
    
}