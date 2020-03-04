
package GreenApps.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import GreenApps.auxiliares.reporteProductos;
import GreenApps.dao.ProductoDao;
import GreenApps.imp.ProductoImp;
import GreenApps.model.Categoria;
import GreenApps.model.PresentacionProducto;
import GreenApps.model.Producto;
import GreenApps.model.UbicacionProducto;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
@Named(value = "productoBean")
@ManagedBean
@ViewScoped

public class ProductoBean implements Serializable {

    private List<Producto> listaProductos;
    private Producto producto = new Producto();

    public ProductoBean() {
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProductos() { /// MÉTODO init & post-CONSTRUCT
        ProductoDao proDao = new ProductoImp();
        listaProductos = proDao.mostrarProductos();
        return listaProductos;
    }

    public void nuevoProducto() {
        producto = new Producto();
    }

    public void ingresarProducto() {
        ProductoDao proDao = new ProductoImp();
        producto.setCodigoProducto(producto.getCodigoProducto().toUpperCase());
        producto.setNombreProducto(producto.getNombreProducto().toUpperCase());
        producto.setDescripcionProducto(producto.getDescripcionProducto().toUpperCase());
        proDao.ingresarProducto(producto);
    }

    public void actualizarProducto() {
        ProductoDao proDao = new ProductoImp();
        producto.setCodigoProducto(producto.getCodigoProducto().toUpperCase());
        producto.setNombreProducto(producto.getNombreProducto().toUpperCase());
        producto.setDescripcionProducto(producto.getDescripcionProducto().toUpperCase());
        proDao.actualizarProducto(producto);
        producto = new Producto();
    }

    public void eliminarProducto() {
        ProductoDao proDao = new ProductoImp();
        proDao.eliminarProducto(producto);
        producto = new Producto();
    }

    public void reporteImpresionProductos() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        this.producto.setIdProducto(1);
        /*this.empleado.setIdEmpleado(uBean.getUsuario().getIdEmpleado());*/
        System.out.println("+++++ Test Reporte Productos +++++");
        int idP = this.producto.getIdProducto();

        reporteProductos rProductos = new reporteProductos();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteProductos.jasper");

        System.out.println("Producto: " + idP);

        rProductos.getReporte(ruta, idP);
        FacesContext.getCurrentInstance().responseComplete();

    }

    public String getmostrarCategoria(Integer id) {

        if (id == null) {
            return "";
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object object = session.get(Categoria.class, id);
        if (object == null) {
            return "";
        } else {
            return ((Categoria) object).getNombreCategoria();
        }

    }

    public String getmostrarPresentacionProducto(Integer id) {

        if (id == null) {
            return "";
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object object = session.get(PresentacionProducto.class, id);
        if (object == null) {
            return "";
        } else {
            return ((PresentacionProducto) object).getDescripcionPresentacionPro();
        }

    }

    public String getmostrarUbicacionProducto(Integer id) {

        if (id == null) {
            return "";
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object object = session.get(UbicacionProducto.class, id);
        if (object == null) {
            return "";
        } else {
            return ((UbicacionProducto) object).getDescripcionUbicacionPro();
        }

    }

}
