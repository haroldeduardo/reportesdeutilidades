package GreenApps.model;
// Generated Apr 16, 2020 5:17:23 PM by Hibernate Tools 4.3.1



/**
 * Mecanico generated by hbm2java
 */
public class Mecanico  implements java.io.Serializable {


     private Integer idMecanico;
     private int identificacionMecanico;
     private String nombresMecanico;
     private String apellidosMecanico;
     private int idDepartamento;
     private int idCiudad;
     private String direccionMecanico;
     private String telefonoMecanico;
     private String correoMecanico;

    public Mecanico() {
    }

    public Mecanico(int identificacionMecanico, String nombresMecanico, String apellidosMecanico, int idDepartamento, int idCiudad, String direccionMecanico, String telefonoMecanico, String correoMecanico) {
       this.identificacionMecanico = identificacionMecanico;
       this.nombresMecanico = nombresMecanico;
       this.apellidosMecanico = apellidosMecanico;
       this.idDepartamento = idDepartamento;
       this.idCiudad = idCiudad;
       this.direccionMecanico = direccionMecanico;
       this.telefonoMecanico = telefonoMecanico;
       this.correoMecanico = correoMecanico;
    }
   
    public Integer getIdMecanico() {
        return this.idMecanico;
    }
    
    public void setIdMecanico(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }
    public int getIdentificacionMecanico() {
        return this.identificacionMecanico;
    }
    
    public void setIdentificacionMecanico(int identificacionMecanico) {
        this.identificacionMecanico = identificacionMecanico;
    }
    public String getNombresMecanico() {
        return this.nombresMecanico;
    }
    
    public void setNombresMecanico(String nombresMecanico) {
        this.nombresMecanico = nombresMecanico;
    }
    public String getApellidosMecanico() {
        return this.apellidosMecanico;
    }
    
    public void setApellidosMecanico(String apellidosMecanico) {
        this.apellidosMecanico = apellidosMecanico;
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
    public String getDireccionMecanico() {
        return this.direccionMecanico;
    }
    
    public void setDireccionMecanico(String direccionMecanico) {
        this.direccionMecanico = direccionMecanico;
    }
    public String getTelefonoMecanico() {
        return this.telefonoMecanico;
    }
    
    public void setTelefonoMecanico(String telefonoMecanico) {
        this.telefonoMecanico = telefonoMecanico;
    }
    public String getCorreoMecanico() {
        return this.correoMecanico;
    }
    
    public void setCorreoMecanico(String correoMecanico) {
        this.correoMecanico = correoMecanico;
    }




}


