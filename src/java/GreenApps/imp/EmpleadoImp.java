
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.EmpleadoDao;
import GreenApps.model.Empleado;
import GreenApps.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class EmpleadoImp implements EmpleadoDao{

    @Override
    public List<Empleado> mostrarEmpleados(){
        
        List<Empleado> listaEmpleados=null;
        Session sessionEmpleado = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionEmpleado.beginTransaction();
        String hql="FROM Empleado";
        
        try {
            listaEmpleados = sessionEmpleado.createQuery(hql).list();
            t.commit();
            sessionEmpleado.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaEmpleados;
    }

    @Override
    public void ingresarEmpleado(Empleado empleado) {
        
        Session sessionEmpleado = null;
        try {
            sessionEmpleado = HibernateUtil.getSessionFactory().openSession();
            sessionEmpleado.beginTransaction();
            sessionEmpleado.save(empleado);
            sessionEmpleado.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionEmpleado.getTransaction().rollback();
        } finally {
            if (sessionEmpleado!=null) {
                sessionEmpleado.close();
            }
        }
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
    
        Session sessionEmpleado = null;
        try {
            sessionEmpleado = HibernateUtil.getSessionFactory().openSession();
            sessionEmpleado.beginTransaction();
            sessionEmpleado.update(empleado);
            sessionEmpleado.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionEmpleado.getTransaction().rollback();
        } finally {
            if (sessionEmpleado!=null){
                sessionEmpleado.close();
            }
        }
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
    
        Session sessionEmpleado = null;
        try {
            sessionEmpleado = HibernateUtil.getSessionFactory().openSession();
            sessionEmpleado.beginTransaction();
            sessionEmpleado.delete(empleado);
            sessionEmpleado.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionEmpleado.getTransaction().rollback();
        } finally {
            if (sessionEmpleado!=null){
                sessionEmpleado.close();
            }
        }
    }
    
    @Override
    public Empleado obtenerEmpleadoPorId (Session sessionEmpleadoPorId, Integer idEmpleado) throws Exception {
        String hql="FROM Empleado WHERE idEmpleado=:idEmpleado";
        Query q = sessionEmpleadoPorId.createQuery(hql);
        q.setParameter("idEmpleado", idEmpleado);
                return (Empleado) q.uniqueResult();
    }
    
    @Override
    public Empleado obtenerEmpleadoPorIdentificacion (Session sessionEmpleadoPorIdentificacion, Integer identificacionEmpleado) throws Exception {
        String hql="FROM Empleado WHERE identificacionEmpleado=:identificacionEmpleado";
        Query q = sessionEmpleadoPorIdentificacion.createQuery(hql);
        q.setParameter("identificacionEmpleado", identificacionEmpleado);
                return (Empleado) q.uniqueResult();
    }
    
}
