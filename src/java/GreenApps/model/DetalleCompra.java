package GreenApps.model;
// Generated Jan 18, 2020 10:18:03 PM by Hibernate Tools 4.3.1



/**
 * DetalleCompra generated by hbm2java
 */
public class DetalleCompra  implements java.io.Serializable {


     private Integer idDetalleCompra;
     private int idCompra;
     private int idProducto;
     private String codigoProducto;
     private String nombreProducto;
     private float valorCompraProducto;
     private float valorVentaProducto;
     private int unidadesCompradas;
     private float totalDetalleCompra;

    public DetalleCompra() {
    }

    public DetalleCompra(int idCompra, int idProducto, String codigoProducto, String nombreProducto, float valorCompraProducto, float valorVentaProducto, int unidadesCompradas, float totalDetalleCompra) {
       this.idCompra = idCompra;
       this.idProducto = idProducto;
       this.codigoProducto = codigoProducto;
       this.nombreProducto = nombreProducto;
       this.valorCompraProducto = valorCompraProducto;
       this.valorVentaProducto = valorVentaProducto;
       this.unidadesCompradas = unidadesCompradas;
       this.totalDetalleCompra = totalDetalleCompra;
    }
   
    public Integer getIdDetalleCompra() {
        return this.idDetalleCompra;
    }
    
    public void setIdDetalleCompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }
    public int getIdCompra() {
        return this.idCompra;
    }
    
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
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
    public float getValorCompraProducto() {
        return this.valorCompraProducto;
    }
    
    public void setValorCompraProducto(float valorCompraProducto) {
        this.valorCompraProducto = valorCompraProducto;
    }
    public float getValorVentaProducto() {
        return this.valorVentaProducto;
    }
    
    public void setValorVentaProducto(float valorVentaProducto) {
        this.valorVentaProducto = valorVentaProducto;
    }
    public int getUnidadesCompradas() {
        return this.unidadesCompradas;
    }
    
    public void setUnidadesCompradas(int unidadesCompradas) {
        this.unidadesCompradas = unidadesCompradas;
    }
    public float getTotalDetalleCompra() {
        return this.totalDetalleCompra;
    }
    
    public void setTotalDetalleCompra(float totalDetalleCompra) {
        this.totalDetalleCompra = totalDetalleCompra;
    }




}


