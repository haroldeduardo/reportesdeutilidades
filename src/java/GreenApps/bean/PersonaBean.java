
package GreenApps.bean;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import GreenApps.dao.PersonaDao;
import GreenApps.imp.PersonaImp;
import GreenApps.model.Ciudad;
import GreenApps.model.Departamento;
import GreenApps.model.Persona;
import GreenApps.model.TipoPersona;
import GreenApps.model.TipoDocumento;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
@Named(value = "personaBean")
@ManagedBean
@ViewScoped

public class PersonaBean implements Serializable {

    private List<Persona> listaPersonas;
    private Persona persona = new Persona();

    public PersonaBean() {
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListaPersonas() {
        PersonaDao perDao = new PersonaImp();
        listaPersonas = perDao.mostrarPersonas();
        return listaPersonas;
    }

    public void nuevaPersona() {
        persona = new Persona();
    }

    public void ingresarPersona() {
        PersonaDao perDao = new PersonaImp();
        persona.setNombresPersona(persona.getNombresPersona().toUpperCase());
        persona.setApellidosPersona(persona.getApellidosPersona().toUpperCase());
        persona.setDireccionPersona(persona.getDireccionPersona().toUpperCase());
        persona.setCorreoPersona(persona.getCorreoPersona().toUpperCase());
        perDao.ingresarPersona(persona);
    }

    public void actualizarPersona() {
        PersonaDao perDao = new PersonaImp();
        persona.setNombresPersona(persona.getNombresPersona().toUpperCase());
        persona.setApellidosPersona(persona.getApellidosPersona().toUpperCase());
        persona.setDireccionPersona(persona.getDireccionPersona().toUpperCase());
        persona.setCorreoPersona(persona.getCorreoPersona().toUpperCase());
        perDao.actualizarPersona(persona);
        persona = new Persona();
    }

    public void eliminarPersona() {
        PersonaDao perDao = new PersonaImp();
        perDao.eliminarPersona(persona);
        persona = new Persona();
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

    public String getmostrarTipoPersona(Integer id) {

        if (id == null) {
            return "";
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object object = session.get(TipoPersona.class, id);
        if (object == null) {
            return "";
        } else {
            return ((TipoPersona) object).getDescripcionPersona();
        }

    }

    public String getmostrarTipoDocumento(Integer id) {

        if (id == null) {
            return "";
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object object = session.get(TipoDocumento.class, id);
        if (object == null) {
            return "";
        } else {
            return ((TipoDocumento) object).getDescripcionDocumento();
        }

    }

}
