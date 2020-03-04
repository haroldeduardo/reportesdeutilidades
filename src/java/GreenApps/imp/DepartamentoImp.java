
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.DepartamentoDao;
import GreenApps.model.Departamento;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class DepartamentoImp implements DepartamentoDao{

    @Override
    public List<Departamento> mostrarDepartamentos() {
        
        List<Departamento> listaDepartamentos=null;
        Session sessionProducto = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionProducto.beginTransaction();
        String hql="FROM Departamento";
        
        try {
            listaDepartamentos = sessionProducto.createQuery(hql).list();
            t.commit();
            sessionProducto.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaDepartamentos;
    }
    
}
