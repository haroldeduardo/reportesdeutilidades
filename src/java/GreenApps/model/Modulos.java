package GreenApps.model;
// Generated Apr 16, 2020 5:17:23 PM by Hibernate Tools 4.3.1



/**
 * Modulos generated by hbm2java
 */
public class Modulos  implements java.io.Serializable {


     private Integer idModulos;
     private String codigoModulo;
     private String nombreModulo;

    public Modulos() {
    }

    public Modulos(String codigoModulo, String nombreModulo) {
       this.codigoModulo = codigoModulo;
       this.nombreModulo = nombreModulo;
    }
   
    public Integer getIdModulos() {
        return this.idModulos;
    }
    
    public void setIdModulos(Integer idModulos) {
        this.idModulos = idModulos;
    }
    public String getCodigoModulo() {
        return this.codigoModulo;
    }
    
    public void setCodigoModulo(String codigoModulo) {
        this.codigoModulo = codigoModulo;
    }
    public String getNombreModulo() {
        return this.nombreModulo;
    }
    
    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }




}


