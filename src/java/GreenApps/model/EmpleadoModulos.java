package GreenApps.model;
// Generated Mar 15, 2020 9:43:40 PM by Hibernate Tools 4.3.1



/**
 * EmpleadoModulos generated by hbm2java
 */
public class EmpleadoModulos  implements java.io.Serializable {


     private Integer idEmpleadoModulos;
     private int perfilesIdPerfiles;
     private int modulosIdModulos;

    public EmpleadoModulos() {
    }

    public EmpleadoModulos(int perfilesIdPerfiles, int modulosIdModulos) {
       this.perfilesIdPerfiles = perfilesIdPerfiles;
       this.modulosIdModulos = modulosIdModulos;
    }
   
    public Integer getIdEmpleadoModulos() {
        return this.idEmpleadoModulos;
    }
    
    public void setIdEmpleadoModulos(Integer idEmpleadoModulos) {
        this.idEmpleadoModulos = idEmpleadoModulos;
    }
    public int getPerfilesIdPerfiles() {
        return this.perfilesIdPerfiles;
    }
    
    public void setPerfilesIdPerfiles(int perfilesIdPerfiles) {
        this.perfilesIdPerfiles = perfilesIdPerfiles;
    }
    public int getModulosIdModulos() {
        return this.modulosIdModulos;
    }
    
    public void setModulosIdModulos(int modulosIdModulos) {
        this.modulosIdModulos = modulosIdModulos;
    }




}


