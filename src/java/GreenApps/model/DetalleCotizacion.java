package GreenApps.model;
// Generated Mar 15, 2020 9:43:40 PM by Hibernate Tools 4.3.1



/**
 * DetalleCotizacion generated by hbm2java
 */
public class DetalleCotizacion  implements java.io.Serializable {


     private Integer idDetalleCotizacion;
     private int idCotizacion;
     private int idProducto;
     private String codigoProducto;
     private String nombreProducto;
     private float valorVentaProducto;
     private boolean iva;
     private int unidadesCotizadas;
     private float totalDetalleCotizacion;

    public DetalleCotizacion() {
    }

    public DetalleCotizacion(int idCotizacion, int idProducto, String codigoProducto, String nombreProducto, float valorVentaProducto, boolean iva, int unidadesCotizadas, float totalDetalleCotizacion) {
       this.idCotizacion = idCotizacion;
       this.idProducto = idProducto;
       this.codigoProducto = codigoProducto;
       this.nombreProducto = nombreProducto;
       this.valorVentaProducto = valorVentaProducto;
       this.iva = iva;
       this.unidadesCotizadas = unidadesCotizadas;
       this.totalDetalleCotizacion = totalDetalleCotizacion;
    }
   
    public Integer getIdDetalleCotizacion() {
        return this.idDetalleCotizacion;
    }
    
    public void setIdDetalleCotizacion(Integer idDetalleCotizacion) {
        this.idDetalleCotizacion = idDetalleCotizacion;
    }
    public int getIdCotizacion() {
        return this.idCotizacion;
    }
    
    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
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
    public boolean isIva() {
        return this.iva;
    }
    
    public void setIva(boolean iva) {
        this.iva = iva;
    }
    public int getUnidadesCotizadas() {
        return this.unidadesCotizadas;
    }
    
    public void setUnidadesCotizadas(int unidadesCotizadas) {
        this.unidadesCotizadas = unidadesCotizadas;
    }
    public float getTotalDetalleCotizacion() {
        return this.totalDetalleCotizacion;
    }
    
    public void setTotalDetalleCotizacion(float totalDetalleCotizacion) {
        this.totalDetalleCotizacion = totalDetalleCotizacion;
    }




}


