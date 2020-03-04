
package GreenApps.imp;

import javax.faces.context.FacesContext;
import GreenApps.dao.CompraDao;
import GreenApps.model.Compra;
import GreenApps.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class CompraImp implements CompraDao{

    @Override
    public List<Compra> mostrarCompras(){
        
        List<Compra> listaCompras=null;
        Session sessionCompra = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionCompra.beginTransaction();
        String hql="FROM Compra";
        
        try {
            listaCompras = sessionCompra.createQuery(hql).list();
            t.commit();
            sessionCompra.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaCompras;
    }
    
    @Override
    public Compra obtenerUltimoRegistroCompra(Session sessionUltimoRegistroCompra) throws Exception {
        String hql = "FROM Compra ORDER BY idCompra DESC";
        Query q = sessionUltimoRegistroCompra.createQuery(hql).setMaxResults(1);
        return (Compra) q.uniqueResult();
    }

    @Override
    public Long obtenerTotalRegistrosCompra(Session sessionRegistrosCompra) {
        String hql = "SELECT COUNT(*) FROM Compra";
        Query q = sessionRegistrosCompra.createQuery(hql);
        return (Long) q.uniqueResult();
    }

    @Override
    public long ingresarCompra(Session sessionIngresarCompra, Compra compra) throws Exception {
        
        Query q =sessionIngresarCompra.createQuery("SELECT COUNT(*) FROM Compra");
        long num = (Long) q.uniqueResult()+1;
        compra.setNumeroCompra(String.valueOf(num));
         
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numCompra",num);
        
        sessionIngresarCompra.save(compra);
        return num;
    }
    
}