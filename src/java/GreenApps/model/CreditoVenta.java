package GreenApps.model;
// Generated Jun 19, 2020 8:52:51 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * CreditoVenta generated by hbm2java
 */
public class CreditoVenta  implements java.io.Serializable {


     private Integer idCreditoVenta;
     private int idEmpleado;
     private int idPersona;
     private float creditoNuevo;
     private Date fechaAbono;

    public CreditoVenta() {
    }

    public CreditoVenta(int idEmpleado, int idPersona, float creditoNuevo, Date fechaAbono) {
       this.idEmpleado = idEmpleado;
       this.idPersona = idPersona;
       this.creditoNuevo = creditoNuevo;
       this.fechaAbono = fechaAbono;
    }
   
    public Integer getIdCreditoVenta() {
        return this.idCreditoVenta;
    }
    
    public void setIdCreditoVenta(Integer idCreditoVenta) {
        this.idCreditoVenta = idCreditoVenta;
    }
    public int getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public int getIdPersona() {
        return this.idPersona;
    }
    
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    public float getCreditoNuevo() {
        return this.creditoNuevo;
    }
    
    public void setCreditoNuevo(float creditoNuevo) {
        this.creditoNuevo = creditoNuevo;
    }
    public Date getFechaAbono() {
        return this.fechaAbono;
    }
    
    public void setFechaAbono(Date fechaAbono) {
        this.fechaAbono = fechaAbono;
    }




}


