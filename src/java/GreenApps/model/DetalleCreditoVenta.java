package GreenApps.model;
// Generated Apr 16, 2020 5:17:23 PM by Hibernate Tools 4.3.1



/**
 * DetalleCreditoVenta generated by hbm2java
 */
public class DetalleCreditoVenta  implements java.io.Serializable {


     private Integer idDetalleCreditoVenta;
     private int idCreditoVenta;
     private int idVenta;
     private float creditoVentaActual;
     private float abonoCreditoVenta;

    public DetalleCreditoVenta() {
    }

    public DetalleCreditoVenta(int idCreditoVenta, int idVenta, float creditoVentaActual, float abonoCreditoVenta) {
       this.idCreditoVenta = idCreditoVenta;
       this.idVenta = idVenta;
       this.creditoVentaActual = creditoVentaActual;
       this.abonoCreditoVenta = abonoCreditoVenta;
    }
   
    public Integer getIdDetalleCreditoVenta() {
        return this.idDetalleCreditoVenta;
    }
    
    public void setIdDetalleCreditoVenta(Integer idDetalleCreditoVenta) {
        this.idDetalleCreditoVenta = idDetalleCreditoVenta;
    }
    public int getIdCreditoVenta() {
        return this.idCreditoVenta;
    }
    
    public void setIdCreditoVenta(int idCreditoVenta) {
        this.idCreditoVenta = idCreditoVenta;
    }
    public int getIdVenta() {
        return this.idVenta;
    }
    
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    public float getCreditoVentaActual() {
        return this.creditoVentaActual;
    }
    
    public void setCreditoVentaActual(float creditoVentaActual) {
        this.creditoVentaActual = creditoVentaActual;
    }
    public float getAbonoCreditoVenta() {
        return this.abonoCreditoVenta;
    }
    
    public void setAbonoCreditoVenta(float abonoCreditoVenta) {
        this.abonoCreditoVenta = abonoCreditoVenta;
    }




}


