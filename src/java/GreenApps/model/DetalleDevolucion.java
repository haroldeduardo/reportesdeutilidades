package GreenApps.model;
// Generated Mar 15, 2020 9:43:40 PM by Hibernate Tools 4.3.1



/**
 * DetalleDevolucion generated by hbm2java
 */
public class DetalleDevolucion  implements java.io.Serializable {


     private Integer idDetalleDevolucion;
     private int idDevolucion;
     private int idProducto;
     private String codigoProducto;
     private String nombreProducto;
     private float valorVentaProducto;
     private int unidadesDevueltas;
     private float totalDetalleDevolucion;

    public DetalleDevolucion() {
    }

    public DetalleDevolucion(int idDevolucion, int idProducto, String codigoProducto, String nombreProducto, float valorVentaProducto, int unidadesDevueltas, float totalDetalleDevolucion) {
       this.idDevolucion = idDevolucion;
       this.idProducto = idProducto;
       this.codigoProducto = codigoProducto;
       this.nombreProducto = nombreProducto;
       this.valorVentaProducto = valorVentaProducto;
       this.unidadesDevueltas = unidadesDevueltas;
       this.totalDetalleDevolucion = totalDetalleDevolucion;
    }
   
    public Integer getIdDetalleDevolucion() {
        return this.idDetalleDevolucion;
    }
    
    public void setIdDetalleDevolucion(Integer idDetalleDevolucion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
    }
    public int getIdDevolucion() {
        return this.idDevolucion;
    }
    
    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }
    public int getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getCodigoProducto() {
        return this.codigoProducto;
    }
    
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    public String getNombreProducto() {
        return this.nombreProducto;
    }
    
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public float getValorVentaProducto() {
        return this.valorVentaProducto;
    }
    
    public void setValorVentaProducto(float valorVentaProducto) {
        this.valorVentaProducto = valorVentaProducto;
    }
    public int getUnidadesDevueltas() {
        return this.unidadesDevueltas;
    }
    
    public void setUnidadesDevueltas(int unidadesDevueltas) {
        this.unidadesDevueltas = unidadesDevueltas;
    }
    public float getTotalDetalleDevolucion() {
        return this.totalDetalleDevolucion;
    }
    
    public void setTotalDetalleDevolucion(float totalDetalleDevolucion) {
        this.totalDetalleDevolucion = totalDetalleDevolucion;
    }




}


