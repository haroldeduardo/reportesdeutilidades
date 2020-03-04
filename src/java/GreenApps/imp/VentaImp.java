
package GreenApps.imp;

import javax.faces.context.FacesContext;
import GreenApps.dao.VentaDao;
import GreenApps.model.Venta;
import GreenApps.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class VentaImp implements VentaDao{

    @Override
    public List<Venta> mostrarVentas(){
        
        List<Venta> listaVentas=null;
        Session sessionVenta = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionVenta.beginTransaction();
        String hql="FROM Venta";
        
        try {
            listaVentas = sessionVenta.createQuery(hql).list();
            t.commit();
            sessionVenta.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaVentas;
    }
    
    @Override
    public Venta obtenerVentaPorIdVenta(int idVenta) throws Exception {
        Session sessionVenta = HibernateUtil.getSessionFactory().openSession();
        String hql="FROM Venta WHERE idVenta = :idVenta";
        Query q = sessionVenta.createQuery(hql);
        q.setParameter("idVenta", idVenta);
                return (Venta) q.uniqueResult();
    }
    
    @Override
    public Venta obtenerUltimoRegistroVenta(Session sessionUltimoRegistroVenta) throws Exception {
        String hql = "FROM Venta ORDER BY idVenta DESC";
        Query q = sessionUltimoRegistroVenta.createQuery(hql).setMaxResults(1);
        return (Venta) q.uniqueResult();
    }

    @Override
    public Long obtenerTotalRegistrosVenta(Session sessionRegistrosVenta) {
        String hql = "SELECT COUNT(*) FROM Venta";
        Query q = sessionRegistrosVenta.createQuery(hql);
        return (Long) q.uniqueResult();
    }

    @Override
    public long ingresarVenta(Session sessionIngresarVenta, Venta venta) throws Exception {
        
        Query q =sessionIngresarVenta.createQuery("SELECT COUNT(*) FROM Venta");
        long num = (Long) q.uniqueResult()+1;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ;
        venta.setNumeroVenta(String.valueOf(num));
         
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numVenta",num);
        
        sessionIngresarVenta.save(venta);
        return num;
    }
    
    @Override
    public void imprimirVenta(Venta venta) {
    
        Session sessionProducto = null;
        try {
            sessionProducto = HibernateUtil.getSessionFactory().openSession();
            sessionProducto.beginTransaction();
            sessionProducto.update(venta);
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
    
}