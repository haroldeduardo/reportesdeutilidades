
package GreenApps.imp;

import javax.faces.context.FacesContext;
import GreenApps.model.DevolucionCliente;
import GreenApps.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import GreenApps.dao.DevolucionClienteDao;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class DevolucionClienteImp implements DevolucionClienteDao{

    @Override
    public List<DevolucionCliente> mostrarDevolucionesCliente(){
        
        List<DevolucionCliente> listaDevolucionClientes=null;
        Session sessionDevolucionCliente = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionDevolucionCliente.beginTransaction();
        String hql="FROM DevolucionCliente";
        
        try {
            listaDevolucionClientes = sessionDevolucionCliente.createQuery(hql).list();
            t.commit();
            sessionDevolucionCliente.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaDevolucionClientes;
    }
    
    @Override
    public DevolucionCliente obtenerUltimoRegistroDevolucionCliente(Session sessionUltimoRegistroDevolucionCliente) throws Exception {
        String hql = "FROM DevolucionCliente ORDER BY idDevolucionCliente DESC";
        Query q = sessionUltimoRegistroDevolucionCliente.createQuery(hql).setMaxResults(1);
        return (DevolucionCliente) q.uniqueResult();
    }

    @Override
    public Long obtenerTotalRegistrosDevolucionCliente(Session sessionRegistrosDevolucionCliente) {
        String hql = "SELECT COUNT(*) FROM DevolucionCliente";
        Query q = sessionRegistrosDevolucionCliente.createQuery(hql);
        return (Long) q.uniqueResult();
    }

    @Override
    public long ingresarDevolucionCliente(Session sessionIngresarDevolucionCliente, DevolucionCliente devolucionCliente) throws Exception {
        
        Query q =sessionIngresarDevolucionCliente.createQuery("SELECT COUNT(*) FROM DevolucionCliente");
        long num = (Long) q.uniqueResult()+1;
        devolucionCliente.setNumeroDevolucionCliente(String.valueOf(num));
         
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numDevolucionCliente",num);
        
        sessionIngresarDevolucionCliente.save(devolucionCliente);
        return num;
    }
    
}

