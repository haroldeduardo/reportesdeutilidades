package GreenApps.model;
// Generated Mar 12, 2020 8:33:30 PM by Hibernate Tools 4.3.1



/**
 * Perfiles generated by hbm2java
 */
public class Perfiles  implements java.io.Serializable {


     private Integer idPerfiles;
     private String codigoPerfil;
     private String nombrePefil;

    public Perfiles() {
    }

    public Perfiles(String codigoPerfil, String nombrePefil) {
       this.codigoPerfil = codigoPerfil;
       this.nombrePefil = nombrePefil;
    }
   
    public Integer getIdPerfiles() {
        return this.idPerfiles;
    }
    
    public void setIdPerfiles(Integer idPerfiles) {
        this.idPerfiles = idPerfiles;
    }
    public String getCodigoPerfil() {
        return this.codigoPerfil;
    }
    
    public void setCodigoPerfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }
    public String getNombrePefil() {
        return this.nombrePefil;
    }
    
    public void setNombrePefil(String nombrePefil) {
        this.nombrePefil = nombrePefil;
    }




}


