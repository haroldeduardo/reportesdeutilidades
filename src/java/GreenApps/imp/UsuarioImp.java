
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.UsuarioDao;
import GreenApps.model.Usuario;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class UsuarioImp implements UsuarioDao{

    @Override
    public List<Usuario> mostrarUsuarios(){
        
        List<Usuario> listaUsuarios=null;
        Session sessionUsuario = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionUsuario.beginTransaction();
        String hql="FROM Usuario";
        
        try {
            listaUsuarios = sessionUsuario.createQuery(hql).list();
            t.commit();
            sessionUsuario.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaUsuarios;
    }

    @Override
    public void ingresarUsuario(Usuario usuario) {
        
        Session sessionUsuario = null;
        try {
            sessionUsuario = HibernateUtil.getSessionFactory().openSession();
            sessionUsuario.beginTransaction();
            sessionUsuario.save(usuario);
            sessionUsuario.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionUsuario.getTransaction().rollback();
        } finally {
            if (sessionUsuario!=null) {
                sessionUsuario.close();
            }
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
    
        Session sessionUsuario = null;
        try {
            sessionUsuario = HibernateUtil.getSessionFactory().openSession();
            sessionUsuario.beginTransaction();
            sessionUsuario.update(usuario);
            sessionUsuario.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionUsuario.getTransaction().rollback();
        } finally {
            if (sessionUsuario!=null){
                sessionUsuario.close();
            }
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
    
        Session sessionUsuario = null;
        try {
            sessionUsuario = HibernateUtil.getSessionFactory().openSession();
            sessionUsuario.beginTransaction();
            sessionUsuario.delete(usuario);
            sessionUsuario.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionUsuario.getTransaction().rollback();
        } finally {
            if (sessionUsuario!=null){
                sessionUsuario.close();
            }
        }
    }
    
}