
package GreenApps.imp;

import javax.faces.context.FacesContext;
import GreenApps.model.DevolucionProveedor;
import GreenApps.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import GreenApps.dao.DevolucionProveedorDao;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class DevolucionProveedorImp implements DevolucionProveedorDao{

    @Override
    public List<DevolucionProveedor> mostrarDevolucionesProveedor(){
        
        List<DevolucionProveedor> listaDevolucionProveedores=null;
        Session sessionDevolucionProveedor = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionDevolucionProveedor.beginTransaction();
        String hql="FROM DevolucionProveedor";
        
        try {
            listaDevolucionProveedores = sessionDevolucionProveedor.createQuery(hql).list();
            t.commit();
            sessionDevolucionProveedor.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaDevolucionProveedores;
    }
    
    @Override
    public DevolucionProveedor obtenerUltimoRegistroDevolucionProveedor(Session sessionUltimoRegistroDevolucionProveedor) throws Exception {
        String hql = "FROM DevolucionProveedor ORDER BY idDevolucionProveedor DESC";
        Query q = sessionUltimoRegistroDevolucionProveedor.createQuery(hql).setMaxResults(1);
        return (DevolucionProveedor) q.uniqueResult();
    }

    @Override
    public Long obtenerTotalRegistrosDevolucionProveedor(Session sessionRegistrosDevolucionProveedor) {
        String hql = "SELECT COUNT(*) FROM DevolucionProveedor";
        Query q = sessionRegistrosDevolucionProveedor.createQuery(hql);
        return (Long) q.uniqueResult();
    }

    @Override
    public long ingresarDevolucionProveedor(Session sessionIngresarDevolucionProveedor, DevolucionProveedor devolucionProveedor) throws Exception {
        
        Query q =sessionIngresarDevolucionProveedor.createQuery("SELECT COUNT(*) FROM DevolucionProveedor");
        long num = (Long) q.uniqueResult()+1;
        devolucionProveedor.setNumeroDevolucionProveedor(String.valueOf(num));
         
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numDevolucionProveedor",num);
        
        sessionIngresarDevolucionProveedor.save(devolucionProveedor);
        return num;
    }
    
}

