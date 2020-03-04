
package GreenApps.bean;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import GreenApps.dao.DepartamentoDao;
import GreenApps.imp.DepartamentoImp;
import GreenApps.model.Departamento;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */

@Named(value = "departamentoBean")
@ManagedBean
@ViewScoped

public class DepartamentoBean implements Serializable {

    private List<Departamento> listaDepartamentos;
    private Departamento departamento;
    
    public DepartamentoBean() {
    }

    public void setListaProductos(List<Departamento> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getListaDepartamentos() {
        DepartamentoDao depDao = new DepartamentoImp();
        listaDepartamentos = depDao.mostrarDepartamentos();
        return listaDepartamentos;
    }
    
    public void reporteDepartamentos() throws Exception {
        
        DepartamentoImp Dao;
        
        try{
            Dao = new DepartamentoImp();
            listaDepartamentos = Dao.mostrarDepartamentos();
        }
        catch(Exception e){
        throw e;
        }
    }
    
}