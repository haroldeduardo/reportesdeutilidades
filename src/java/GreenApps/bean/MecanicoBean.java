
package GreenApps.bean;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import GreenApps.dao.MecanicoDao;
import GreenApps.imp.MecanicoImp;
import GreenApps.model.Ciudad;
import GreenApps.model.Departamento;
import GreenApps.model.Mecanico;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
@Named(value = "mecanicoBean")
@ManagedBean
@ViewScoped

public class MecanicoBean implements Serializable {

    private List<Mecanico> listaMecanicos;
    private Mecanico mecanico = new Mecanico();

    public MecanicoBean() {
    }

    public void setListaMecanicos(List<Mecanico> listaMecanicos) {
        this.listaMecanicos = listaMecanicos;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public List<Mecanico> getListaMecanicos() {
        MecanicoDao mecDao = new MecanicoImp();
        listaMecanicos = mecDao.mostrarMecanicos();
        return listaMecanicos;
    }

    public void nuevoMecanico() {
        mecanico = new Mecanico();
    }

    public void ingresarMecanico() {
        MecanicoDao mecDao = new MecanicoImp();
        mecanico.setNombresMecanico(mecanico.getNombresMecanico().toUpperCase());
        mecanico.setApellidosMecanico(mecanico.getApellidosMecanico().toUpperCase());
        mecanico.setDireccionMecanico(mecanico.getDireccionMecanico().toUpperCase());
        mecanico.setCorreoMecanico(mecanico.getCorreoMecanico().toUpperCase());
        mecDao.ingresarMecanico(mecanico);
    }

    public void actualizarMecanico() {
        MecanicoDao mecDao = new MecanicoImp();
        mecanico.setNombresMecanico(mecanico.getNombresMecanico().toUpperCase());
        mecanico.setApellidosMecanico(mecanico.getApellidosMecanico().toUpperCase());
        mecanico.setDireccionMecanico(mecanico.getDireccionMecanico().toUpperCase());
        mecanico.setCorreoMecanico(mecanico.getCorreoMecanico().toUpperCase());
        mecDao.actualizarMecanico(mecanico);
        mecanico = new Mecanico();
    }

    public void eliminarMecanico() {
        MecanicoDao mecDao = new MecanicoImp();
        mecDao.eliminarMecanico(mecanico);
        mecanico = new Mecanico();
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
