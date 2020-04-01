package GreenApps.model;
// Generated Mar 15, 2020 9:43:40 PM by Hibernate Tools 4.3.1



/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private Integer idEmpleado;
     private int identificacionEmpleado;
     private String nombresEmpleado;
     private String apellidosEmpleado;
     private int idDepartamento;
     private int idCiudad;
     private String direccionEmpleado;
     private String telefonoEmpleado;
     private String correoEmpleado;

    public Empleado() {
    }

    public Empleado(int identificacionEmpleado, String nombresEmpleado, String apellidosEmpleado, int idDepartamento, int idCiudad, String direccionEmpleado, String telefonoEmpleado, String correoEmpleado) {
       this.identificacionEmpleado = identificacionEmpleado;
       this.nombresEmpleado = nombresEmpleado;
       this.apellidosEmpleado = apellidosEmpleado;
       this.idDepartamento = idDepartamento;
       this.idCiudad = idCiudad;
       this.direccionEmpleado = direccionEmpleado;
       this.telefonoEmpleado = telefonoEmpleado;
       this.correoEmpleado = correoEmpleado;
    }
   
    public Integer getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public int getIdentificacionEmpleado() {
        return this.identificacionEmpleado;
    }
    
    public void setIdentificacionEmpleado(int identificacionEmpleado) {
        this.identificacionEmpleado = identificacionEmpleado;
    }
    public String getNombresEmpleado() {
        return this.nombresEmpleado;
    }
    
    public void setNombresEmpleado(String nombresEmpleado) {
        this.nombresEmpleado = nombresEmpleado;
    }
    public String getApellidosEmpleado() {
        return this.apellidosEmpleado;
    }
    
    public void setApellidosEmpleado(String apellidosEmpleado) {
        this.apellidosEmpleado = apellidosEmpleado;
    }
    public int getIdDepartamento() {
        return this.idDepartamento;
    }
    
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    public int getIdCiudad() {
        return this.idCiudad;
    }
    
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    public String getDireccionEmpleado() {
        return this.direccionEmpleado;
    }
    
    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }
    public String getTelefonoEmpleado() {
        return this.telefonoEmpleado;
    }
    
    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }
    public String getCorreoEmpleado() {
        return this.correoEmpleado;
    }
    
    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }




}


