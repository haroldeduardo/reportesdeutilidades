package GreenApps.model;
// Generated May 19, 2020 8:20:55 PM by Hibernate Tools 4.3.1



/**
 * EmpleadoRoles generated by hbm2java
 */
public class EmpleadoRoles  implements java.io.Serializable {


     private Integer idEmpleadoRoles;
     private int idEmpelado;
     private int idRoles;

    public EmpleadoRoles() {
    }

    public EmpleadoRoles(int idEmpelado, int idRoles) {
       this.idEmpelado = idEmpelado;
       this.idRoles = idRoles;
    }
   
    public Integer getIdEmpleadoRoles() {
        return this.idEmpleadoRoles;
    }
    
    public void setIdEmpleadoRoles(Integer idEmpleadoRoles) {
        this.idEmpleadoRoles = idEmpleadoRoles;
    }
    public int getIdEmpelado() {
        return this.idEmpelado;
    }
    
    public void setIdEmpelado(int idEmpelado) {
        this.idEmpelado = idEmpelado;
    }
    public int getIdRoles() {
        return this.idRoles;
    }
    
    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }




}


