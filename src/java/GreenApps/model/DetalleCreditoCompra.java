package GreenApps.model;
// Generated Apr 16, 2020 5:17:23 PM by Hibernate Tools 4.3.1



/**
 * DetalleCreditoCompra generated by hbm2java
 */
public class DetalleCreditoCompra  implements java.io.Serializable {


     private Integer idDetalleCreditoCompra;
     private int idCreditoCompra;
     private int idCompra;
     private float creditoCompraActual;
     private float abonoCreditoCompra;

    public DetalleCreditoCompra() {
    }

    public DetalleCreditoCompra(int idCreditoCompra, int idCompra, float creditoCompraActual, float abonoCreditoCompra) {
       this.idCreditoCompra = idCreditoCompra;
       this.idCompra = idCompra;
       this.creditoCompraActual = creditoCompraActual;
       this.abonoCreditoCompra = abonoCreditoCompra;
    }
   
    public Integer getIdDetalleCreditoCompra() {
        return this.idDetalleCreditoCompra;
    }
    
    public void setIdDetalleCreditoCompra(Integer idDetalleCreditoCompra) {
        this.idDetalleCreditoCompra = idDetalleCreditoCompra;
    }
    public int getIdCreditoCompra() {
        return this.idCreditoCompra;
    }
    
    public void setIdCreditoCompra(int idCreditoCompra) {
        this.idCreditoCompra = idCreditoCompra;
    }
    public int getIdCompra() {
        return this.idCompra;
    }
    
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    public float getCreditoCompraActual() {
        return this.creditoCompraActual;
    }
    
    public void setCreditoCompraActual(float creditoCompraActual) {
        this.creditoCompraActual = creditoCompraActual;
    }
    public float getAbonoCreditoCompra() {
        return this.abonoCreditoCompra;
    }
    
    public void setAbonoCreditoCompra(float abonoCreditoCompra) {
        this.abonoCreditoCompra = abonoCreditoCompra;
    }




}


