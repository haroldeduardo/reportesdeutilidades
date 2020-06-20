
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
import GreenApps.auxiliares.reportesDevolucionesCliente;
import GreenApps.dao.PersonaDao;
import GreenApps.dao.ProductoDao;
import GreenApps.imp.DevolucionClienteImp;
import GreenApps.imp.DetalleDevolucionClienteImp;
import GreenApps.imp.PersonaImp;
import GreenApps.imp.ProductoImp;
import GreenApps.model.DevolucionCliente;
import GreenApps.model.DetalleDevolucionCliente;
import GreenApps.model.Empleado;
import GreenApps.model.Persona;
import GreenApps.model.Producto;
import GreenApps.model.TipoTransaccion;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import GreenApps.dao.DetalleDevolucionClienteDao;
import GreenApps.dao.DevolucionClienteDao;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
@Named(value = "devolucionClienteBean")
@ViewScoped
@ManagedBean

public class DevolucionClienteBean implements Serializable {

    Session sessionDevolucionCliente = null;
    Transaction transactionDevolucionCliente = null;

    @ManagedProperty("#{interfaceUsuarioBean}")
    private InterfaceUsuarioBean uBean;

    private Persona persona;
    private Integer identificacionPersona;

    private Producto producto;
    private String codigoProducto;

    private List<DevolucionCliente> listaDevolucionClientes;
    private List<DetalleDevolucionCliente> listaDetalleDevolucionCliente;

    private String unidadesDevueltas;
    private String productoSeleccionado;
    private DevolucionCliente devolucionCliente;

    private String unidadesDevueltasPorCodigo;

    private Long numeroDevolucionCliente;
    private BigDecimal totalDevolucionClienteFactura;
    private float totalDevolucionClienteFacturaDevolucionCliente;

    private Empleado empleado;
    private TipoTransaccion tipoTransaccion;

    private boolean enabled;

    private String fechaSistema;

    private String fechaInicialDevolucionCliente;

    private String fechaFinalDevolucionCliente;

    public DevolucionClienteBean() {

        this.devolucionCliente = new DevolucionCliente();
        this.listaDetalleDevolucionCliente = new ArrayList<>();
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

    public List<DetalleDevolucionCliente> getListaDetalleDevolucionCliente() {
        return listaDetalleDevolucionCliente;
    }

    public void setListaDetalleDevolucionCliente(List<DetalleDevolucionCliente> listaDetalleDevolucionCliente) {
        this.listaDetalleDevolucionCliente = listaDetalleDevolucionCliente;
    }

    public List<DevolucionCliente> getListaDevolucionClientes() {
        DevolucionClienteDao serDao = new DevolucionClienteImp();
        listaDevolucionClientes = serDao.mostrarDevolucionesCliente();
        return listaDevolucionClientes;
    }

    public void setListaDevolucionClientes(List<DevolucionCliente> listaDevolucionClientes) {
        this.listaDevolucionClientes = listaDevolucionClientes;
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

    public DevolucionCliente getDevolucionCliente() {
        return devolucionCliente;
    }

    public void setDevolucionCliente(DevolucionCliente devolucionCliente) {
        this.devolucionCliente = devolucionCliente;
    }

    public String getUnidadesDevueltasPorCodigo() {
        return unidadesDevueltasPorCodigo;
    }

    public void setUnidadesDevueltasPorCodigo(String unidadesDevueltasPorCodigo) {
        this.unidadesDevueltasPorCodigo = unidadesDevueltasPorCodigo;
    }

    public Long getNumeroDevolucionCliente() {
        return numeroDevolucionCliente;
    }

    public void setNumeroDevolucionCliente(Long numeroDevolucionCliente) {
        this.numeroDevolucionCliente = numeroDevolucionCliente;
    }

    public BigDecimal getTotalDevolucionClienteFactura() {
        return totalDevolucionClienteFactura;
    }

    public void setTotalDevolucionClienteFactura(BigDecimal totalDevolucionClienteFactura) {
        this.totalDevolucionClienteFactura = totalDevolucionClienteFactura;
    }

    public float getTotalDevolucionClienteFacturaDevolucionCliente() {
        return totalDevolucionClienteFacturaDevolucionCliente;
    }

    public void setTotalDevolucionClienteFacturaDevolucionCliente(float totalDevolucionClienteFacturaDevolucionCliente) {
        this.totalDevolucionClienteFacturaDevolucionCliente = totalDevolucionClienteFacturaDevolucionCliente;
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

    public String getFechaInicialDevolucionCliente() {
        return fechaInicialDevolucionCliente;
    }

    public void setFechaInicialDevolucionCliente(String fechaInicialDevolucionCliente) {
        this.fechaInicialDevolucionCliente = fechaInicialDevolucionCliente;
    }

    public String getFechaFinalDevolucionCliente() {
        return fechaFinalDevolucionCliente;
    }

    public void setFechaFinalDevolucionCliente(String fechaFinalDevolucionCliente) {
        this.fechaFinalDevolucionCliente = fechaFinalDevolucionCliente;
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
        this.sessionDevolucionCliente = null;
        this.transactionDevolucionCliente = null;

        try {
            this.sessionDevolucionCliente = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionDevolucionCliente = this.sessionDevolucionCliente.beginTransaction();
            this.persona = pDao.obtenerPersonaPorId(this.sessionDevolucionCliente, idPersona);
            this.transactionDevolucionCliente.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Acreedor Agregado"));
        } catch (Exception e) {
            if (this.transactionDevolucionCliente != null) {
                System.out.println(e.getMessage());
                transactionDevolucionCliente.rollback();
            }
        } finally {
            if (this.sessionDevolucionCliente != null) {
                this.sessionDevolucionCliente.close();
            }

        }

    }

    public void agregarDatosPersonaPorIdentificacion() {
        this.sessionDevolucionCliente = null;
        this.transactionDevolucionCliente = null;

        try {
            if (this.identificacionPersona == null) {
                return;
            }
            this.sessionDevolucionCliente = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionDevolucionCliente = this.sessionDevolucionCliente.beginTransaction();
            this.persona = pDao.obtenerPersonaPorIdentificacion(this.sessionDevolucionCliente, this.identificacionPersona);
            if (this.persona != null) {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Acreedor Agregado"));
            } else {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Acreedor Inexistente"));
            }
            this.transactionDevolucionCliente.commit();
        } catch (Exception e) {
            if (this.transactionDevolucionCliente != null) {
                System.out.println(e.getMessage());
                transactionDevolucionCliente.rollback();
            }
        } finally {
            if (this.sessionDevolucionCliente != null) {
                this.sessionDevolucionCliente.close();
            }

        }

    }

    public void solicitarCantidadProducto(String codigoProducto) {
        this.productoSeleccionado = codigoProducto;
    }

    public void agregarDatosProductoPorCodigoProducto() {
        this.sessionDevolucionCliente = null;
        this.transactionDevolucionCliente = null;

        try {

            if (!(this.unidadesDevueltas.matches("[0-9]*")) || this.unidadesDevueltas.equals("0") || this.unidadesDevueltas.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
                this.unidadesDevueltas = "";

            } else {

                this.sessionDevolucionCliente = HibernateUtil.getSessionFactory().openSession();
                ProductoDao pDao = new ProductoImp();
                this.transactionDevolucionCliente = this.sessionDevolucionCliente.beginTransaction();
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionDevolucionCliente, this.productoSeleccionado);

                this.listaDetalleDevolucionCliente.add(new DetalleDevolucionCliente(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), Integer.parseInt(this.unidadesDevueltas), (Float.parseFloat(this.unidadesDevueltas) * this.producto.getValorVentaProducto())));

                this.transactionDevolucionCliente.commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                this.unidadesDevueltas = "";

                this.calcularValorTotalDevolucionCliente();

            }

        } catch (Exception e) {
            if (this.transactionDevolucionCliente != null) {
                System.out.println(e.getMessage());
                transactionDevolucionCliente.rollback();
            }
        } finally {
            if (this.sessionDevolucionCliente != null) {
                this.sessionDevolucionCliente.close();
            }

        }

    }

    public void mostrarDatosCantidadProductoPorCodigo() {
        this.sessionDevolucionCliente = null;
        this.transactionDevolucionCliente = null;

        try {
            if (this.codigoProducto == null) {
                return;
            }
            this.sessionDevolucionCliente = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            this.transactionDevolucionCliente = this.sessionDevolucionCliente.beginTransaction();
            this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionDevolucionCliente, this.codigoProducto);
            if (this.producto != null) {

                RequestContext rc = RequestContext.getCurrentInstance();
                rc.execute("PF('dialogDatosCantidadProductoPorCodigo').show();");

                this.codigoProducto = null;

            } else {
                this.codigoProducto = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Producto Inexistente"));
            }
            this.transactionDevolucionCliente.commit();
        } catch (Exception e) {
            if (this.transactionDevolucionCliente != null) {
                System.out.println(e.getMessage());
                transactionDevolucionCliente.rollback();
            }
        } finally {
            if (this.sessionDevolucionCliente != null) {
                this.sessionDevolucionCliente.close();
            }

        }

    }

    public void agregarDatosProductoPorCodigoProductoRead() {

        if (!(this.unidadesDevueltasPorCodigo.matches("[0-9]*")) || this.unidadesDevueltasPorCodigo.equals("0") || this.unidadesDevueltasPorCodigo.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
            this.unidadesDevueltasPorCodigo = "";

        } else {

            this.listaDetalleDevolucionCliente.add(new DetalleDevolucionCliente(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), Integer.parseInt(this.unidadesDevueltasPorCodigo), (Float.parseFloat(this.unidadesDevueltasPorCodigo) * this.producto.getValorVentaProducto())));

            this.unidadesDevueltasPorCodigo = "";

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

            this.calcularValorTotalDevolucionCliente();

        }

    }

    public void calcularValorTotalDevolucionCliente() {

        this.totalDevolucionClienteFactura = new BigDecimal("0");

        try {
            for (DetalleDevolucionCliente detalleDevolucionClienteTotal : listaDetalleDevolucionCliente) {
                BigDecimal totalDevolucionClientePorProducto = (new BigDecimal(detalleDevolucionClienteTotal.getValorVentaProducto()).multiply(new BigDecimal(detalleDevolucionClienteTotal.getUnidadesDevueltas())));
                detalleDevolucionClienteTotal.setTotalDetalleDevolucionCliente(totalDevolucionClientePorProducto.floatValue());
                totalDevolucionClienteFactura = totalDevolucionClienteFactura.add(totalDevolucionClientePorProducto);
            }
            this.devolucionCliente.setTotalDevolucionCliente(totalDevolucionClienteFactura.floatValue());
            totalDevolucionClienteFacturaDevolucionCliente = (totalDevolucionClienteFactura.floatValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarProducto(String codigoProducto, Integer posicionSeleccionada) {

        try {

            int i = 0;

            for (DetalleDevolucionCliente detalleProducto : this.listaDetalleDevolucionCliente) {
                if (detalleProducto.getCodigoProducto().equals(codigoProducto) && posicionSeleccionada.equals(i)) {
                    this.listaDetalleDevolucionCliente.remove(i);
                    break;
                }
                i++;
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

            this.calcularValorTotalDevolucionCliente();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

        }
    }

    public void onRowEdit(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Modificación Realizada"));
        this.calcularValorTotalDevolucionCliente();
    }

    public void onRowCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Sin Modificacaciones"));

    }

    public void numeracionDevolucionCliente() {
        this.sessionDevolucionCliente = null;
        this.transactionDevolucionCliente = null;

        try {
            this.sessionDevolucionCliente = HibernateUtil.getSessionFactory().openSession();
            this.transactionDevolucionCliente = this.sessionDevolucionCliente.beginTransaction();
            DevolucionClienteDao vDao = new DevolucionClienteImp();
            this.numeroDevolucionCliente = vDao.obtenerTotalRegistrosDevolucionCliente(this.sessionDevolucionCliente);

            if (this.numeroDevolucionCliente <= 0 || this.numeroDevolucionCliente == null) {
                this.numeroDevolucionCliente = Long.valueOf("1");
            } else {
                this.devolucionCliente = vDao.obtenerUltimoRegistroDevolucionCliente(sessionDevolucionCliente);
                this.numeroDevolucionCliente = Long.valueOf(this.devolucionCliente.getIdDevolucionCliente() + 1);
                this.totalDevolucionClienteFactura = new BigDecimal("0");
            }
            this.transactionDevolucionCliente.commit();
        } catch (Exception e) {
            if (this.transactionDevolucionCliente != null) {
                this.transactionDevolucionCliente.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            if (this.sessionDevolucionCliente != null) {
                this.sessionDevolucionCliente.close();
            }
            
        }
    }

    public void limpiarFacturaDevolucionCliente() {
        this.persona = new Persona();
        this.devolucionCliente = new DevolucionCliente();
        this.listaDetalleDevolucionCliente = new ArrayList<>();
        this.numeroDevolucionCliente = null;
        this.totalDevolucionClienteFacturaDevolucionCliente = 0;

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
    
    public void ingresarDevolucionClienteFULL() {

        this.sessionDevolucionCliente = null;
        this.transactionDevolucionCliente = null;

        String idEmpleadoV = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoV));
        this.tipoTransaccion.setIdTipoTransaccion(1); /// aún por definir idTipo de Transacción Contado ó Credito ///
        this.devolucionCliente.setFechaDevolucionCliente(new Date());

        try {
            this.sessionDevolucionCliente = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            DevolucionClienteDao vDao = new DevolucionClienteImp();
            DetalleDevolucionClienteDao dvDao = new DetalleDevolucionClienteImp();

            this.transactionDevolucionCliente = this.sessionDevolucionCliente.beginTransaction();

            this.devolucionCliente.setNumeroDevolucionCliente(Long.toString(this.numeroDevolucionCliente));
            this.devolucionCliente.setIdEmpleado(this.empleado.getIdEmpleado());
            this.devolucionCliente.setIdPersona(this.persona.getIdPersona());
            this.devolucionCliente.setIdTipoTransaccion(this.tipoTransaccion.getIdTipoTransaccion());

            vDao.ingresarDevolucionCliente(this.sessionDevolucionCliente, this.devolucionCliente);

            Object objDevolucionCliente = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numDevolucionCliente");
            
            long numRegistrarDevolucionCliente = ((Number) objDevolucionCliente).longValue();

            this.numeroDevolucionCliente = numRegistrarDevolucionCliente;

            this.devolucionCliente = vDao.obtenerUltimoRegistroDevolucionCliente(this.sessionDevolucionCliente);

            for (DetalleDevolucionCliente detalleDevolucionClienteTotal : listaDetalleDevolucionCliente) {
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionDevolucionCliente, detalleDevolucionClienteTotal.getCodigoProducto());
                detalleDevolucionClienteTotal.setIdDevolucionCliente(this.devolucionCliente.getIdDevolucionCliente());
                detalleDevolucionClienteTotal.setIdProducto(this.producto.getIdProducto());

                dvDao.ingresarDetalleDevolucionCliente(this.sessionDevolucionCliente, detalleDevolucionClienteTotal);
                
            }
            
            this.transactionDevolucionCliente.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "DevolucionCliente Registrada"));

            this.limpiarFacturaDevolucionCliente();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.transactionDevolucionCliente != null) {
                this.transactionDevolucionCliente.rollback();
            }
            
        } finally {
            if (this.sessionDevolucionCliente != null) {
                this.sessionDevolucionCliente.close();
            }
        }
    }

    public void reportesDevolucionClientes() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("+++++ Test Reporte DevolucionClientes +++++");

        String fechaInicial = this.getFechaInicialDevolucionCliente();
        String fechaFinal = this.getFechaFinalDevolucionCliente();

        reportesDevolucionesCliente rReporte = new reportesDevolucionesCliente();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteDevolucionClientes.jasper");

        System.out.println("Fecha Inicial: " + fechaInicial);
        System.out.println("Fecha Final: " + fechaFinal);

        rReporte.getReporte(ruta, fechaInicial, fechaFinal);
        FacesContext.getCurrentInstance().responseComplete();

    }

}
