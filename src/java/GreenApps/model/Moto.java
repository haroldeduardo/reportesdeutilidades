package GreenApps.model;
// Generated May 19, 2020 8:20:55 PM by Hibernate Tools 4.3.1



/**
 * Moto generated by hbm2java
 */
public class Moto  implements java.io.Serializable {


     private Integer idMoto;
     private String nombreMoto;

    public Moto() {
    }

    public Moto(String nombreMoto) {
       this.nombreMoto = nombreMoto;
    }
   
    public Integer getIdMoto() {
        return this.idMoto;
    }
    
    public void setIdMoto(Integer idMoto) {
        this.idMoto = idMoto;
    }
    public String getNombreMoto() {
        return this.nombreMoto;
    }
    
    public void setNombreMoto(String nombreMoto) {
        this.nombreMoto = nombreMoto;
    }




}


