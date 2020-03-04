
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.MecanicoDao;
import GreenApps.model.Mecanico;
import GreenApps.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class MecanicoImp implements MecanicoDao{

    @Override
    public List<Mecanico> mostrarMecanicos(){
        
        List<Mecanico> listaMecanicos=null;
        Session sessionMecanico = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionMecanico.beginTransaction();
        String hql="FROM Mecanico";
        
        try {
            listaMecanicos = sessionMecanico.createQuery(hql).list();
            t.commit();
            sessionMecanico.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaMecanicos;
    }

    @Override
    public void ingresarMecanico(Mecanico mecanico) {
        
        Session sessionMecanico = null;
        try {
            sessionMecanico = HibernateUtil.getSessionFactory().openSession();
            sessionMecanico.beginTransaction();
            sessionMecanico.save(mecanico);
            sessionMecanico.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionMecanico.getTransaction().rollback();
        } finally {
            if (sessionMecanico!=null) {
                sessionMecanico.close();
            }
        }
    }

    @Override
    public void actualizarMecanico(Mecanico mecanico) {
    
        Session sessionMecanico = null;
        try {
            sessionMecanico = HibernateUtil.getSessionFactory().openSession();
            sessionMecanico.beginTransaction();
            sessionMecanico.update(mecanico);
            sessionMecanico.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionMecanico.getTransaction().rollback();
        } finally {
            if (sessionMecanico!=null){
                sessionMecanico.close();
            }
        }
    }

    @Override
    public void eliminarMecanico(Mecanico mecanico) {
    
        Session sessionMecanico = null;
        try {
            sessionMecanico = HibernateUtil.getSessionFactory().openSession();
            sessionMecanico.beginTransaction();
            sessionMecanico.delete(mecanico);
            sessionMecanico.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionMecanico.getTransaction().rollback();
        } finally {
            if (sessionMecanico!=null){
                sessionMecanico.close();
            }
        }
    }
    
    @Override
    public Mecanico obtenerMecanicoPorId (Session sessionMecanicoPorId, Integer idMecanico) throws Exception {
        String hql="FROM Mecanico WHERE idMecanico=:idMecanico";
        Query q = sessionMecanicoPorId.createQuery(hql);
        q.setParameter("idMecanico", idMecanico);
                return (Mecanico) q.uniqueResult();
    }
    
    @Override
    public Mecanico obtenerMecanicoPorIdentificacion (Session sessionMecanicoPorIdentificacion, Integer identificacionMecanico) throws Exception {
        String hql="FROM Mecanico WHERE identificacionMecanico=:identificacionMecanico";
        Query q = sessionMecanicoPorIdentificacion.createQuery(hql);
        q.setParameter("identificacionMecanico", identificacionMecanico);
                return (Mecanico) q.uniqueResult();
    }
    
}