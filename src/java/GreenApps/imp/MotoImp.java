
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.MotoDao;
import GreenApps.model.Moto;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class MotoImp implements MotoDao{

    @Override
    public List<Moto> mostrarMotos(){
        
        List<Moto> listaMotos=null;
        Session sessionMoto = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionMoto.beginTransaction();
        String hql="FROM Moto";
        
        try {
            listaMotos = sessionMoto.createQuery(hql).list();
            t.commit();
            sessionMoto.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaMotos;
    }

    @Override
    public void ingresarMoto(Moto moto) {
        
        Session sessionMoto = null;
        try {
            sessionMoto = HibernateUtil.getSessionFactory().openSession();
            sessionMoto.beginTransaction();
            sessionMoto.save(moto);
            sessionMoto.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionMoto.getTransaction().rollback();
        } finally {
            if (sessionMoto!=null) {
                sessionMoto.close();
            }
        }
    }

    @Override
    public void actualizarMoto(Moto moto) {
    
        Session sessionMoto = null;
        try {
            sessionMoto = HibernateUtil.getSessionFactory().openSession();
            sessionMoto.beginTransaction();
            sessionMoto.update(moto);
            sessionMoto.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionMoto.getTransaction().rollback();
        } finally {
            if (sessionMoto!=null){
                sessionMoto.close();
            }
        }
    }

    @Override
    public void eliminarMoto(Moto moto) {
    
        Session sessionMoto = null;
        try {
            sessionMoto = HibernateUtil.getSessionFactory().openSession();
            sessionMoto.beginTransaction();
            sessionMoto.delete(moto);
            sessionMoto.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionMoto.getTransaction().rollback();
        } finally {
            if (sessionMoto!=null){
                sessionMoto.close();
            }
        }
    }
    
}
