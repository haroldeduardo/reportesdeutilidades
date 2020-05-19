package GreenApps.model;
// Generated Apr 16, 2020 5:17:23 PM by Hibernate Tools 4.3.1


import GreenApps.util.HibernateUtil;
import java.beans.Transient;
import java.util.Date;
import org.hibernate.Session;

/**
 * Venta generated by hbm2java
 */
public class Venta  implements java.io.Serializable {


     private Integer idVenta;
     private String numeroVenta;
     private int idEmpleado;
     private int idPersona;
     private float totalVenta;
     private Float sumatoria;
     private int idTipoTransaccion;
     private Date fechaVenta;
     private Byte estadoVenta;
     private Float numeracionFactura;

    public Venta() {
    }
    
    @Transient
    public int getIdentificacionPersonaVenta() {

        Session sessionIdentificacionPersona = null;

        try {
            sessionIdentificacionPersona = HibernateUtil.getSessionFactory().openSession();
            Persona p = (Persona) sessionIdentificacionPersona.get(Persona.class, this.idPersona);
            return p.getIdentificacionPersona();
        } catch (Exception e) {

            return 0;

        } finally {
            if (sessionIdentificacionPersona != null) {
                sessionIdentificacionPersona.close();
            }
        }
    }

    @Transient
    public void setIdentificacionPersonaVenta(int identificacionPersona) {

    }

	
    public Venta(String numeroVenta, int idEmpleado, int idPersona, float totalVenta, int idTipoTransaccion, Date fechaVenta) {
        this.numeroVenta = numeroVenta;
        this.idEmpleado = idEmpleado;
        this.idPersona = idPersona;
        this.totalVenta = totalVenta;
        this.idTipoTransaccion = idTipoTransaccion;
        this.fechaVenta = fechaVenta;
    }
    public Venta(String numeroVenta, int idEmpleado, int idPersona, float totalVenta, Float sumatoria, int idTipoTransaccion, Date fechaVenta, Byte estadoVenta, Float numeracionFactura) {
       this.numeroVenta = numeroVenta;
       this.idEmpleado = idEmpleado;
       this.idPersona = idPersona;
       this.totalVenta = totalVenta;
       this.sumatoria = sumatoria;
       this.idTipoTransaccion = idTipoTransaccion;
       this.fechaVenta = fechaVenta;
       this.estadoVenta = estadoVenta;
       this.numeracionFactura = numeracionFactura;
    }
   
    public Integer getIdVenta() {
        return this.idVenta;
    }
    
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public String getNumeroVenta() {
        return this.numeroVenta;
    }
    
    public void setNumeroVenta(String numeroVenta) {
        this.numeroVenta = numeroVenta;
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
    public float getTotalVenta() {
        return this.totalVenta;
    }
    
    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }
    public Float getSumatoria() {
        return this.sumatoria;
    }
    
    public void setSumatoria(Float sumatoria) {
        this.sumatoria = sumatoria;
    }
    public int getIdTipoTransaccion() {
        return this.idTipoTransaccion;
    }
    
    public void setIdTipoTransaccion(int idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }
    public Date getFechaVenta() {
        return this.fechaVenta;
    }
    
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    public Byte getEstadoVenta() {
        return this.estadoVenta;
    }
    
    public void setEstadoVenta(Byte estadoVenta) {
        this.estadoVenta = estadoVenta;
    }
    public Float getNumeracionFactura() {
        return this.numeracionFactura;
    }
    
    public void setNumeracionFactura(Float numeracionFactura) {
        this.numeracionFactura = numeracionFactura;
    }




}


