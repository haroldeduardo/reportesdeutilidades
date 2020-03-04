
package GreenApps.bean;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import GreenApps.dao.MotoDao;
import GreenApps.imp.MotoImp;
import GreenApps.model.Moto;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */

@Named(value = "motoBean")
@ManagedBean
@ViewScoped

public class MotoBean implements Serializable {

    private List<Moto> listaMotos;
    private Moto moto;
    
    public MotoBean() {
    }

    public void setListaMotos(List<Moto> listaMotos) {
        this.listaMotos = listaMotos;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public List<Moto> getListaMotos() {
        MotoDao motDao = new MotoImp();
        listaMotos = motDao.mostrarMotos();
        return listaMotos;
    }
    
    public void nuevaMoto(){
        moto = new Moto();
    }
    
    public void ingresarMoto(){
        MotoDao motDao = new MotoImp();
        moto.setNombreMoto(moto.getNombreMoto().toUpperCase());
        motDao.ingresarMoto(moto);
    }
    
    public void actualizarMoto(){
        MotoDao motDao = new MotoImp();
        moto.setNombreMoto(moto.getNombreMoto().toUpperCase());
        motDao.actualizarMoto(moto);
        moto = new Moto();
    }
    
    public void eliminarMoto(){
        MotoDao motDao = new MotoImp();
        motDao.eliminarMoto(moto);
        moto = new Moto();
    }
    
    public void reporteMotos() throws Exception {
        
        MotoImp Dao;
        
        try{
            Dao = new MotoImp();
            listaMotos = Dao.mostrarMotos();
        }
        catch(Exception e){
        throw e;
        }
    }
        
}
