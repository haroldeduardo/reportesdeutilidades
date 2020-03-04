
package GreenApps.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import GreenApps.auxiliares.reportesDevoluciones;
import GreenApps.dao.DevolucionDao;
import GreenApps.dao.PersonaDao;
import GreenApps.dao.ProductoDao;
import GreenApps.dao.DetalleDevolucionDao;
import GreenApps.imp.DevolucionImp;
import GreenApps.imp.DetalleDevolucionImp;
import GreenApps.imp.PersonaImp;
import GreenApps.imp.ProductoImp;
import GreenApps.model.Devolucion;
import GreenApps.model.DetalleDevolucion;
import GreenApps.model.Empleado;
import GreenApps.model.Persona;
import GreenApps.model.Producto;
import GreenApps.model.TipoTransaccion;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
@Named(value = "devolucionBean")
@ViewScoped
@ManagedBean

public class DevolucionBean implements Serializable {

    Session sessionDevolucion = null;
    Transaction transactionDevolucion = null;

    @ManagedProperty("#{interfaceUsuarioBean}")
    private InterfaceUsuarioBean uBean;

    private Persona persona;
    private Integer identificacionPersona;

    private Producto producto;
    private String codigoProducto;

    private List<Devolucion> listaDevoluciones;
    private List<DetalleDevolucion> listaDetalleDevolucion;

    private String unidadesDevueltas;
    private String productoSeleccionado;
    private Devolucion devolucion;

    private String unidadesDevueltasPorCodigo;

    private Long numeroDevolucion;
    private BigDecimal totalDevolucionFactura;
    private float totalDevolucionFacturaDevolucion;

    private Empleado empleado;
    private TipoTransaccion tipoTransaccion;

    private boolean enabled;

    private String fechaSistema;

    private String fechaInicialDevolucion;

    private String fechaFinalDevolucion;

    public DevolucionBean() {

        this.devolucion = new Devolucion();
        this.listaDetalleDevolucion = new ArrayList<>();
        this.empleado = new Empleado();
        this.persona = new Persona();
        this.tipoTransaccion = new TipoTransaccion();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getIdentificacionPersona() {
        return identificacionPersona;
    }

    public void setIdentificacionPersona(Integer identificacionPersona) {
        this.identificacionPersona = identificacionPersona;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public List<DetalleDevolucion> getListaDetalleDevolucion() {
        return listaDetalleDevolucion;
    }

    public void setListaDetalleDevolucion(List<DetalleDevolucion> listaDetalleDevolucion) {
        this.listaDetalleDevolucion = listaDetalleDevolucion;
    }

    public List<Devolucion> getListaDevoluciones() {
        DevolucionDao serDao = new DevolucionImp();
        listaDevoluciones = serDao.mostrarDevoluciones();
        return listaDevoluciones;
    }

    public void setListaDevoluciones(List<Devolucion> listaDevoluciones) {
        this.listaDevoluciones = listaDevoluciones;
    }
    
    public String getUnidadesDevueltas() {
        return unidadesDevueltas;
    }

    public void setUnidadesDevueltas(String unidadesDevueltas) {
        this.unidadesDevueltas = unidadesDevueltas;
    }

    public String getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(String productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public Devolucion getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }

    public String getUnidadesDevueltasPorCodigo() {
        return unidadesDevueltasPorCodigo;
    }

    public void setUnidadesDevueltasPorCodigo(String unidadesDevueltasPorCodigo) {
        this.unidadesDevueltasPorCodigo = unidadesDevueltasPorCodigo;
    }

    public Long getNumeroDevolucion() {
        return numeroDevolucion;
    }

    public void setNumeroDevolucion(Long numeroDevolucion) {
        this.numeroDevolucion = numeroDevolucion;
    }

    public BigDecimal getTotalDevolucionFactura() {
        return totalDevolucionFactura;
    }

    public void setTotalDevolucionFactura(BigDecimal totalDevolucionFactura) {
        this.totalDevolucionFactura = totalDevolucionFactura;
    }

    public float getTotalDevolucionFacturaDevolucion() {
        return totalDevolucionFacturaDevolucion;
    }

    public void setTotalDevolucionFacturaDevolucion(float totalDevolucionFacturaDevolucion) {
        this.totalDevolucionFacturaDevolucion = totalDevolucionFacturaDevolucion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getFechaInicialDevolucion() {
        return fechaInicialDevolucion;
    }

    public void setFechaInicialDevolucion(String fechaInicialDevolucion) {
        this.fechaInicialDevolucion = fechaInicialDevolucion;
    }

    public String getFechaFinalDevolucion() {
        return fechaFinalDevolucion;
    }

    public void setFechaFinalDevolucion(String fechaFinalDevolucion) {
        this.fechaFinalDevolucion = fechaFinalDevolucion;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void enableBoton() {
        enabled = true;
    }

    public void disableBoton() {
        enabled = false;
    }

    public String getFechaSistema() {

        Calendar dateS = new GregorianCalendar();

        int ano = dateS.get(Calendar.YEAR);
        int mes = dateS.get(Calendar.MONTH);
        int dia = dateS.get(Calendar.DAY_OF_MONTH);

        this.fechaSistema = ((dia) + "/" + (mes + 1) + "/" + ano);

        return fechaSistema;
    }

    public InterfaceUsuarioBean getuBean() {
        return uBean;
    }

    public void setuBean(InterfaceUsuarioBean uBean) {
        this.uBean = uBean;
    }

    public void agregarDatosPersona(Integer idPersona) {
        this.sessionDevolucion = null;
        this.transactionDevolucion = null;

        try {
            this.sessionDevolucion = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionDevolucion = this.sessionDevolucion.beginTransaction();
            this.persona = pDao.obtenerPersonaPorId(this.sessionDevolucion, idPersona);
            this.transactionDevolucion.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Acreedor Agregado"));
        } catch (Exception e) {
            if (this.transactionDevolucion != null) {
                System.out.println(e.getMessage());
                transactionDevolucion.rollback();
            }
        } finally {
            if (this.sessionDevolucion != null) {
                this.sessionDevolucion.close();
            }

        }

    }

    public void agregarDatosPersonaPorIdentificacion() {
        this.sessionDevolucion = null;
        this.transactionDevolucion = null;

        try {
            if (this.identificacionPersona == null) {
                return;
            }
            this.sessionDevolucion = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionDevolucion = this.sessionDevolucion.beginTransaction();
            this.persona = pDao.obtenerPersonaPorIdentificacion(this.sessionDevolucion, this.identificacionPersona);
            if (this.persona != null) {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Acreedor Agregado"));
            } else {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Acreedor Inexistente"));
            }
            this.transactionDevolucion.commit();
        } catch (Exception e) {
            if (this.transactionDevolucion != null) {
                System.out.println(e.getMessage());
                transactionDevolucion.rollback();
            }
        } finally {
            if (this.sessionDevolucion != null) {
                this.sessionDevolucion.close();
            }

        }

    }

    public void solicitarCantidadProducto(String codigoProducto) {
        this.productoSeleccionado = codigoProducto;
    }

    public void agregarDatosProductoPorCodigoProducto() {
        this.sessionDevolucion = null;
        this.transactionDevolucion = null;

        try {

            if (!(this.unidadesDevueltas.matches("[0-9]*")) || this.unidadesDevueltas.equals("0") || this.unidadesDevueltas.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
                this.unidadesDevueltas = "";

            } else {

                this.sessionDevolucion = HibernateUtil.getSessionFactory().openSession();
                ProductoDao pDao = new ProductoImp();
                this.transactionDevolucion = this.sessionDevolucion.beginTransaction();
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionDevolucion, this.productoSeleccionado);

                this.listaDetalleDevolucion.add(new DetalleDevolucion(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), Integer.parseInt(this.unidadesDevueltas), (Float.parseFloat(this.unidadesDevueltas) * this.producto.getValorVentaProducto())));

                this.transactionDevolucion.commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                this.unidadesDevueltas = "";

                this.calcularValorTotalDevolucion();

            }

        } catch (Exception e) {
            if (this.transactionDevolucion != null) {
                System.out.println(e.getMessage());
                transactionDevolucion.rollback();
            }
        } finally {
            if (this.sessionDevolucion != null) {
                this.sessionDevolucion.close();
            }

        }

    }

    public void mostrarDatosCantidadProductoPorCodigo() {
        this.sessionDevolucion = null;
        this.transactionDevolucion = null;

        try {
            if (this.codigoProducto == null) {
                return;
            }
            this.sessionDevolucion = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            this.transactionDevolucion = this.sessionDevolucion.beginTransaction();
            this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionDevolucion, this.codigoProducto);
            if (this.producto != null) {

                RequestContext rc = RequestContext.getCurrentInstance();
                rc.execute("PF('dialogDatosCantidadProductoPorCodigo').show();");

                this.codigoProducto = null;

            } else {
                this.codigoProducto = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Producto Inexistente"));
            }
            this.transactionDevolucion.commit();
        } catch (Exception e) {
            if (this.transactionDevolucion != null) {
                System.out.println(e.getMessage());
                transactionDevolucion.rollback();
            }
        } finally {
            if (this.sessionDevolucion != null) {
                this.sessionDevolucion.close();
            }

        }

    }

    public void agregarDatosProductoPorCodigoProductoRead() {

        if (!(this.unidadesDevueltasPorCodigo.matches("[0-9]*")) || this.unidadesDevueltasPorCodigo.equals("0") || this.unidadesDevueltasPorCodigo.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
            this.unidadesDevueltasPorCodigo = "";

        } else {

            this.listaDetalleDevolucion.add(new DetalleDevolucion(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), Integer.parseInt(this.unidadesDevueltasPorCodigo), (Float.parseFloat(this.unidadesDevueltasPorCodigo) * this.producto.getValorVentaProducto())));

            this.unidadesDevueltasPorCodigo = "";

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

            this.calcularValorTotalDevolucion();

        }

    }

    public void calcularValorTotalDevolucion() {

        this.totalDevolucionFactura = new BigDecimal("0");

        try {
            for (DetalleDevolucion detalleDevolucionTotal : listaDetalleDevolucion) {
                BigDecimal totalDevolucionPorProducto = (new BigDecimal(detalleDevolucionTotal.getValorVentaProducto()).multiply(new BigDecimal(detalleDevolucionTotal.getUnidadesDevueltas())));
                detalleDevolucionTotal.setTotalDetalleDevolucion(totalDevolucionPorProducto.floatValue());
                totalDevolucionFactura = totalDevolucionFactura.add(totalDevolucionPorProducto);
            }
            this.devolucion.setTotalDevolucion(totalDevolucionFactura.floatValue());
            totalDevolucionFacturaDevolucion = (totalDevolucionFactura.floatValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarProducto(String codigoProducto, Integer posicionSeleccionada) {

        try {

            int i = 0;

            for (DetalleDevolucion detalleProducto : this.listaDetalleDevolucion) {
                if (detalleProducto.getCodigoProducto().equals(codigoProducto) && posicionSeleccionada.equals(i)) {
                    this.listaDetalleDevolucion.remove(i);
                    break;
                }
                i++;
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

            this.calcularValorTotalDevolucion();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

        }
    }

    public void onRowEdit(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Modificación Realizada"));
        this.calcularValorTotalDevolucion();
    }

    public void onRowCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Sin Modificacaciones"));

    }

    public void numeracionDevolucion() {
        this.sessionDevolucion = null;
        this.transactionDevolucion = null;

        try {
            this.sessionDevolucion = HibernateUtil.getSessionFactory().openSession();
            this.transactionDevolucion = this.sessionDevolucion.beginTransaction();
            DevolucionDao vDao = new DevolucionImp();
            this.numeroDevolucion = vDao.obtenerTotalRegistrosDevolucion(this.sessionDevolucion);

            if (this.numeroDevolucion <= 0 || this.numeroDevolucion == null) {
                this.numeroDevolucion = Long.valueOf("1");
            } else {
                this.devolucion = vDao.obtenerUltimoRegistroDevolucion(sessionDevolucion);
                this.numeroDevolucion = Long.valueOf(this.devolucion.getIdDevolucion() + 1);
                this.totalDevolucionFactura = new BigDecimal("0");
            }
            this.transactionDevolucion.commit();
        } catch (Exception e) {
            if (this.transactionDevolucion != null) {
                this.transactionDevolucion.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            if (this.sessionDevolucion != null) {
                this.sessionDevolucion.close();
            }
            
        }
    }

    public void limpiarFacturaDevolucion() {
        this.persona = new Persona();
        this.devolucion = new Devolucion();
        this.listaDetalleDevolucion = new ArrayList<>();
        this.numeroDevolucion = null;
        this.totalDevolucionFacturaDevolucion = 0;

        this.disableBoton();
    }

    public int getmostrarPersona(Integer id) {

        if (id == null) {
            return 0;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object object = session.get(Persona.class, id);
        if (object == null) {
            return 0;
        } else {
            return ((Persona) object).getIdentificacionPersona();
        }

    }
    
    public void ingresarDevolucionFULL() {

        this.sessionDevolucion = null;
        this.transactionDevolucion = null;

        String idEmpleadoV = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoV));
        this.tipoTransaccion.setIdTipoTransaccion(1); /// aún por definir idTipo de Transacción Contado ó Credito ///
        this.devolucion.setFechaDevolucion(new Date());

        try {
            this.sessionDevolucion = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            DevolucionDao vDao = new DevolucionImp();
            DetalleDevolucionDao dvDao = new DetalleDevolucionImp();

            this.transactionDevolucion = this.sessionDevolucion.beginTransaction();

            this.devolucion.setNumeroDevolucion(Long.toString(this.numeroDevolucion));
            this.devolucion.setIdEmpleado(this.empleado.getIdEmpleado());
            this.devolucion.setIdPersona(this.persona.getIdPersona());
            this.devolucion.setIdTipoTransaccion(this.tipoTransaccion.getIdTipoTransaccion());

            vDao.ingresarDevolucion(this.sessionDevolucion, this.devolucion);

            Object objDevolucion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numDevolucion");
            
            long numRegistrarDevolucion = ((Number) objDevolucion).longValue();

            this.numeroDevolucion = numRegistrarDevolucion;

            this.devolucion = vDao.obtenerUltimoRegistroDevolucion(this.sessionDevolucion);

            for (DetalleDevolucion detalleDevolucionTotal : listaDetalleDevolucion) {
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionDevolucion, detalleDevolucionTotal.getCodigoProducto());
                detalleDevolucionTotal.setIdDevolucion(this.devolucion.getIdDevolucion());
                detalleDevolucionTotal.setIdProducto(this.producto.getIdProducto());

                dvDao.ingresarDetalleDevolucion(this.sessionDevolucion, detalleDevolucionTotal);
                
            }
            
            this.transactionDevolucion.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Devolucion Registrada"));

            this.limpiarFacturaDevolucion();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.transactionDevolucion != null) {
                this.transactionDevolucion.rollback();
            }
            
        } finally {
            if (this.sessionDevolucion != null) {
                this.sessionDevolucion.close();
            }
        }
    }

    public void reportesDevoluciones() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("+++++ Test Reporte Devoluciones +++++");

        String fechaInicial = this.getFechaInicialDevolucion();
        String fechaFinal = this.getFechaFinalDevolucion();

        reportesDevoluciones rReporte = new reportesDevoluciones();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteDevoluciones.jasper");

        System.out.println("Fecha Inicial: " + fechaInicial);
        System.out.println("Fecha Final: " + fechaFinal);

        rReporte.getReporte(ruta, fechaInicial, fechaFinal);
        FacesContext.getCurrentInstance().responseComplete();

    }

}
