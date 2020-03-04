
package GreenApps.imp;

import java.util.List;
import GreenApps.dao.ProductoDao;
import GreenApps.model.Producto;
import GreenApps.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
public class ProductoImp implements ProductoDao{

    @Override
    public List<Producto> mostrarProductos(){
        
        List<Producto> listaProductos=null;
        Session sessionProducto = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessionProducto.beginTransaction();
        String hql="FROM Producto"; /// FROM Producto as p inner join fetch p.Categoria left join fetch p.PresentacionProducto left join fetch p.UbicacionProducto
        
        try {
            listaProductos = sessionProducto.createQuery(hql).list();
            t.commit();
            sessionProducto.close();
        } catch (Exception e) {
            t.rollback();
        }
        return listaProductos;
    }

    @Override
    public void ingresarProducto(Producto producto) {
        
        Session sessionProducto = null;
        try {
            sessionProducto = HibernateUtil.getSessionFactory().openSession();
            sessionProducto.beginTransaction();
            sessionProducto.save(producto);
            sessionProducto.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sessionProducto.getTransaction().rollback();
        } finally {
            if (sessionProducto!=null) {
                sessionProducto.close();
            }
        }
    }

    @Override
    public void actualizarProducto(Producto producto) {
    
        Session sessionProducto = null;
        try {
            sessionProducto = HibernateUtil.getSessionFactory().openSession();
            sessionProducto.beginTransaction();
            sessionProducto.update(producto);
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

    @Override
    public void eliminarProducto(Producto producto) {
    
        Session sessionProducto = null;
        try {
            sessionProducto = HibernateUtil.getSessionFactory().openSession();
            sessionProducto.beginTransaction();
            sessionProducto.delete(producto);
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
    
    @Override
    public Producto obtenerProductoPorCodigoProducto(Session sessionProductoPorCodigoProducto, String codigoProducto) throws Exception {
        String hql="FROM Producto WHERE codigoProducto = :codigoProducto";
        Query q = sessionProductoPorCodigoProducto.createQuery(hql);
        q.setParameter("codigoProducto", codigoProducto);
                return (Producto) q.uniqueResult();
    }
    
    @Override
    public boolean validarStockProducto(Session sessionProductoPorCodigoProducto, String codigoProducto, int unidadesRequeridas) throws Exception {
        String hql="FROM Producto WHERE codigoProducto = :codigoProducto";
        Query q = sessionProductoPorCodigoProducto.createQuery(hql);
        q.setParameter("codigoProducto", codigoProducto);
        
        int stock = ((Producto) q.uniqueResult()).getStockProducto();
        
        return (stock - unidadesRequeridas) >= 0;
    }
    
}