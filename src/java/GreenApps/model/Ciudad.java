package GreenApps.model;
// Generated Mar 12, 2020 8:33:30 PM by Hibernate Tools 4.3.1



/**
 * Ciudad generated by hbm2java
 */
public class Ciudad  implements java.io.Serializable {


     private Integer idCiudad;
     private String nombreCiudad;

    public Ciudad() {
    }

    public Ciudad(String nombreCiudad) {
       this.nombreCiudad = nombreCiudad;
    }
   
    public Integer getIdCiudad() {
        return this.idCiudad;
    }
    
    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }
    public String getNombreCiudad() {
        return this.nombreCiudad;
    }
    
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }




}


