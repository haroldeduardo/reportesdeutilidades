package GreenApps.model;
// Generated Jan 18, 2020 10:18:03 PM by Hibernate Tools 4.3.1



/**
 * Categoria generated by hbm2java
 */
public class Categoria  implements java.io.Serializable {


     private Integer idCategoria;
     private String nombreCategoria;
     private String descripcionCategoria;

    public Categoria() {
    }

    public Categoria(String nombreCategoria, String descripcionCategoria) {
       this.nombreCategoria = nombreCategoria;
       this.descripcionCategoria = descripcionCategoria;
    }
   
    public Integer getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    public String getNombreCategoria() {
        return this.nombreCategoria;
    }
    
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    public String getDescripcionCategoria() {
        return this.descripcionCategoria;
    }
    
    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }




}


