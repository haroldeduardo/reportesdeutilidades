package GreenApps.model;
// Generated May 19, 2020 8:20:55 PM by Hibernate Tools 4.3.1



/**
 * UbicacionProducto generated by hbm2java
 */
public class UbicacionProducto  implements java.io.Serializable {


     private Integer idUbicacionProducto;
     private String descripcionUbicacionPro;

    public UbicacionProducto() {
    }

    public UbicacionProducto(String descripcionUbicacionPro) {
       this.descripcionUbicacionPro = descripcionUbicacionPro;
    }
   
    public Integer getIdUbicacionProducto() {
        return this.idUbicacionProducto;
    }
    
    public void setIdUbicacionProducto(Integer idUbicacionProducto) {
        this.idUbicacionProducto = idUbicacionProducto;
    }
    public String getDescripcionUbicacionPro() {
        return this.descripcionUbicacionPro;
    }
    
    public void setDescripcionUbicacionPro(String descripcionUbicacionPro) {
        this.descripcionUbicacionPro = descripcionUbicacionPro;
    }




}


