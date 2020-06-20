package GreenApps.model;
// Generated Jun 19, 2020 8:52:51 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * DevolucionProveedor generated by hbm2java
 */
public class DevolucionProveedor  implements java.io.Serializable {


     private Integer idDevolucionProveedor;
     private String numeroDevolucionProveedor;
     private int idEmpleado;
     private int idPersona;
     private float totalDevolucionProveedor;
     private int idTipoTransaccion;
     private Date fechaDevolucionProveedor;

    public DevolucionProveedor() {
    }

    public DevolucionProveedor(String numeroDevolucionProveedor, int idEmpleado, int idPersona, float totalDevolucionProveedor, int idTipoTransaccion, Date fechaDevolucionProveedor) {
       this.numeroDevolucionProveedor = numeroDevolucionProveedor;
       this.idEmpleado = idEmpleado;
       this.idPersona = idPersona;
       this.totalDevolucionProveedor = totalDevolucionProveedor;
       this.idTipoTransaccion = idTipoTransaccion;
       this.fechaDevolucionProveedor = fechaDevolucionProveedor;
    }
   
    public Integer getIdDevolucionProveedor() {
        return this.idDevolucionProveedor;
    }
    
    public void setIdDevolucionProveedor(Integer idDevolucionProveedor) {
        this.idDevolucionProveedor = idDevolucionProveedor;
    }
    public String getNumeroDevolucionProveedor() {
        return this.numeroDevolucionProveedor;
    }
    
    public void setNumeroDevolucionProveedor(String numeroDevolucionProveedor) {
        this.numeroDevolucionProveedor = numeroDevolucionProveedor;
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
    public float getTotalDevolucionProveedor() {
        return this.totalDevolucionProveedor;
    }
    
    public void setTotalDevolucionProveedor(float totalDevolucionProveedor) {
        this.totalDevolucionProveedor = totalDevolucionProveedor;
    }
    public int getIdTipoTransaccion() {
        return this.idTipoTransaccion;
    }
    
    public void setIdTipoTransaccion(int idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }
    public Date getFechaDevolucionProveedor() {
        return this.fechaDevolucionProveedor;
    }
    
    public void setFechaDevolucionProveedor(Date fechaDevolucionProveedor) {
        this.fechaDevolucionProveedor = fechaDevolucionProveedor;
    }




}


