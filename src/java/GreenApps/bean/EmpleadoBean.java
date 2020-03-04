
package GreenApps.bean;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import GreenApps.dao.EmpleadoDao;
import GreenApps.imp.EmpleadoImp;
import GreenApps.model.Departamento;
import GreenApps.model.Ciudad;
import GreenApps.model.Empleado;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
@Named(value = "empleadoBean")
@ManagedBean
@ViewScoped

public class EmpleadoBean implements Serializable {

    private List<Empleado> listaEmpleados;
    private Empleado empleado = new Empleado();

    public EmpleadoBean() {
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getListaEmpleados() {
        EmpleadoDao empDao = new EmpleadoImp();
        listaEmpleados = empDao.mostrarEmpleados();
        return listaEmpleados;
    }

    public void nuevoEmpleado() {
        empleado = new Empleado();
    }

    public void ingresarEmpleado() {
        EmpleadoDao empDao = new EmpleadoImp();
        empleado.setNombresEmpleado(empleado.getNombresEmpleado().toUpperCase());
        empleado.setApellidosEmpleado(empleado.getApellidosEmpleado().toUpperCase());
        empleado.setDireccionEmpleado(empleado.getDireccionEmpleado().toUpperCase());
        empleado.setCorreoEmpleado(empleado.getCorreoEmpleado().toUpperCase());
        empDao.ingresarEmpleado(empleado);
    }

    public void actualizarEmpleado() {
        EmpleadoDao empDao = new EmpleadoImp();
        empleado.setNombresEmpleado(empleado.getNombresEmpleado().toUpperCase());
        empleado.setApellidosEmpleado(empleado.getApellidosEmpleado().toUpperCase());
        empleado.setDireccionEmpleado(empleado.getDireccionEmpleado().toUpperCase());
        empleado.setCorreoEmpleado(empleado.getCorreoEmpleado().toUpperCase());
        empDao.actualizarEmpleado(empleado);
        empleado = new Empleado();
    }

    public void eliminarEmpleado() {
        EmpleadoDao empDao = new EmpleadoImp();
        empDao.eliminarEmpleado(empleado);
        empleado = new Empleado();
    }

    public String getmostrarCiudad(Integer id) {

        if (id == null) {
            return "";
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object object = session.get(Ciudad.class, id);
        if (object == null) {
            return "";
        } else {
            return ((Ciudad) object).getNombreCiudad();
        }

    }

    public String getmostrarDepartamento(Integer id) {

        if (id == null) {
            return "";
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object object = session.get(Departamento.class, id);
        if (object == null) {
            return "";
        } else {
            return ((Departamento) object).getNombreDepartamento();
        }

    }

}
