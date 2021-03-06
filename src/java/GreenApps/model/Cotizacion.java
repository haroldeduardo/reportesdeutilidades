package GreenApps.model;
// Generated Mar 15, 2020 9:43:40 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Cotizacion generated by hbm2java
 */
public class Cotizacion  implements java.io.Serializable {


     private Integer idCotizacion;
     private String numeroCotizacion;
     private int idEmpleado;
     private int idPersona;
     private float totalCotizacion;
     private float totalDescuentoVenta;
     private Date fechaCotizacion;
     private Byte estadoCotizacion;

    public Cotizacion() {
    }
    
    public Cotizacion(String numeroCotizacion, int idEmpleado, int idPersona, float totalCotizacion, float totalDescuentoVenta, Date fechaCotizacion, Byte estadoCotizacion) {
       this.numeroCotizacion = numeroCotizacion;
       this.idEmpleado = idEmpleado;
       this.idPersona = idPersona;
       this.totalCotizacion = totalCotizacion;
       this.totalDescuentoVenta = totalDescuentoVenta;
       this.fechaCotizacion = fechaCotizacion;
       this.estadoCotizacion = estadoCotizacion;
    }
   
    public Integer getIdCotizacion() {
        return this.idCotizacion;
    }
    
    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }
    public String getNumeroCotizacion() {
        return this.numeroCotizacion;
    }
    
    public void setNumeroCotizacion(String numeroCotizacion) {
        this.numeroCotizacion = numeroCotizacion;
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
    public float getTotalCotizacion() {
        return this.totalCotizacion;
    }
    
    public void setTotalCotizacion(float totalCotizacion) {
        this.totalCotizacion = totalCotizacion;
    }
    public float getTotalDescuentoVenta() {
        return this.totalDescuentoVenta;
    }
    
    public void setTotalDescuentoVenta(float totalDescuentoVenta) {
        this.totalDescuentoVenta = totalDescuentoVenta;
    }
    public Date getFechaCotizacion() {
        return this.fechaCotizacion;
    }
    
    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }
    public Byte getEstadoCotizacion() {
        return this.estadoCotizacion;
    }
    
    public void setEstadoCotizacion(Byte estadoCotizacion) {
        this.estadoCotizacion = estadoCotizacion;
    }

}


