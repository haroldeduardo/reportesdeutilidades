
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
import GreenApps.auxiliares.reportesDevolucionesProveedor;
import GreenApps.dao.PersonaDao;
import GreenApps.dao.ProductoDao;
import GreenApps.imp.DevolucionProveedorImp;
import GreenApps.imp.DetalleDevolucionProveedorImp;
import GreenApps.imp.PersonaImp;
import GreenApps.imp.ProductoImp;
import GreenApps.model.DevolucionProveedor;
import GreenApps.model.DetalleDevolucionProveedor;
import GreenApps.model.Empleado;
import GreenApps.model.Persona;
import GreenApps.model.Producto;
import GreenApps.model.TipoTransaccion;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import GreenApps.dao.DetalleDevolucionProveedorDao;
import GreenApps.dao.DevolucionProveedorDao;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
@Named(value = "devolucionProveedorBean")
@ViewScoped
@ManagedBean

public class DevolucionProveedorBean implements Serializable {

    Session sessionDevolucionProveedor = null;
    Transaction transactionDevolucionProveedor = null;

    @ManagedProperty("#{interfaceUsuarioBean}")
    private InterfaceUsuarioBean uBean;

    private Persona persona;
    private Integer identificacionPersona;

    private Producto producto;
    private String codigoProducto;

    private List<DevolucionProveedor> listaDevolucionProveedores;
    private List<DetalleDevolucionProveedor> listaDetalleDevolucionProveedor;

    private String unidadesDevueltas;
    private String productoSeleccionado;
    private DevolucionProveedor devolucionProveedor;

    private String unidadesDevueltasPorCodigo;

    private Long numeroDevolucionProveedor;
    private BigDecimal totalDevolucionProveedorFactura;
    private float totalDevolucionProveedorFacturaDevolucionProveedor;

    private Empleado empleado;
    private TipoTransaccion tipoTransaccion;

    private boolean enabled;

    private String fechaSistema;

    private String fechaInicialDevolucionProveedor;

    private String fechaFinalDevolucionProveedor;

    public DevolucionProveedorBean() {

        this.devolucionProveedor = new DevolucionProveedor();
        this.listaDetalleDevolucionProveedor = new ArrayList<>();
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

    public List<DetalleDevolucionProveedor> getListaDetalleDevolucionProveedor() {
        return listaDetalleDevolucionProveedor;
    }

    public void setListaDetalleDevolucionProveedor(List<DetalleDevolucionProveedor> listaDetalleDevolucionProveedor) {
        this.listaDetalleDevolucionProveedor = listaDetalleDevolucionProveedor;
    }

    public List<DevolucionProveedor> getListaDevolucionProveedores() {
        DevolucionProveedorDao serDao = new DevolucionProveedorImp();
        listaDevolucionProveedores = serDao.mostrarDevolucionesProveedor();
        return listaDevolucionProveedores;
    }

    public void setListaDevolucionProveedores(List<DevolucionProveedor> listaDevolucionProveedores) {
        this.listaDevolucionProveedores = listaDevolucionProveedores;
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

    public DevolucionProveedor getDevolucionProveedor() {
        return devolucionProveedor;
    }

    public void setDevolucionProveedor(DevolucionProveedor devolucionProveedor) {
        this.devolucionProveedor = devolucionProveedor;
    }

    public String getUnidadesDevueltasPorCodigo() {
        return unidadesDevueltasPorCodigo;
    }

    public void setUnidadesDevueltasPorCodigo(String unidadesDevueltasPorCodigo) {
        this.unidadesDevueltasPorCodigo = unidadesDevueltasPorCodigo;
    }

    public Long getNumeroDevolucionProveedor() {
        return numeroDevolucionProveedor;
    }

    public void setNumeroDevolucionProveedor(Long numeroDevolucionProveedor) {
        this.numeroDevolucionProveedor = numeroDevolucionProveedor;
    }

    public BigDecimal getTotalDevolucionProveedorFactura() {
        return totalDevolucionProveedorFactura;
    }

    public void setTotalDevolucionProveedorFactura(BigDecimal totalDevolucionProveedorFactura) {
        this.totalDevolucionProveedorFactura = totalDevolucionProveedorFactura;
    }

    public float getTotalDevolucionProveedorFacturaDevolucionProveedor() {
        return totalDevolucionProveedorFacturaDevolucionProveedor;
    }

    public void setTotalDevolucionProveedorFacturaDevolucionProveedor(float totalDevolucionProveedorFacturaDevolucionProveedor) {
        this.totalDevolucionProveedorFacturaDevolucionProveedor = totalDevolucionProveedorFacturaDevolucionProveedor;
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

    public String getFechaInicialDevolucionProveedor() {
        return fechaInicialDevolucionProveedor;
    }

    public void setFechaInicialDevolucionProveedor(String fechaInicialDevolucionProveedor) {
        this.fechaInicialDevolucionProveedor = fechaInicialDevolucionProveedor;
    }

    public String getFechaFinalDevolucionProveedor() {
        return fechaFinalDevolucionProveedor;
    }

    public void setFechaFinalDevolucionProveedor(String fechaFinalDevolucionProveedor) {
        this.fechaFinalDevolucionProveedor = fechaFinalDevolucionProveedor;
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
        this.sessionDevolucionProveedor = null;
        this.transactionDevolucionProveedor = null;

        try {
            this.sessionDevolucionProveedor = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionDevolucionProveedor = this.sessionDevolucionProveedor.beginTransaction();
            this.persona = pDao.obtenerPersonaPorId(this.sessionDevolucionProveedor, idPersona);
            this.transactionDevolucionProveedor.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Acreedor Agregado"));
        } catch (Exception e) {
            if (this.transactionDevolucionProveedor != null) {
                System.out.println(e.getMessage());
                transactionDevolucionProveedor.rollback();
            }
        } finally {
            if (this.sessionDevolucionProveedor != null) {
                this.sessionDevolucionProveedor.close();
            }

        }

    }

    public void agregarDatosPersonaPorIdentificacion() {
        this.sessionDevolucionProveedor = null;
        this.transactionDevolucionProveedor = null;

        try {
            if (this.identificacionPersona == null) {
                return;
            }
            this.sessionDevolucionProveedor = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionDevolucionProveedor = this.sessionDevolucionProveedor.beginTransaction();
            this.persona = pDao.obtenerPersonaPorIdentificacion(this.sessionDevolucionProveedor, this.identificacionPersona);
            if (this.persona != null) {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Acreedor Agregado"));
            } else {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Acreedor Inexistente"));
            }
            this.transactionDevolucionProveedor.commit();
        } catch (Exception e) {
            if (this.transactionDevolucionProveedor != null) {
                System.out.println(e.getMessage());
                transactionDevolucionProveedor.rollback();
            }
        } finally {
            if (this.sessionDevolucionProveedor != null) {
                this.sessionDevolucionProveedor.close();
            }

        }

    }

    public void solicitarCantidadProducto(String codigoProducto) {
        this.productoSeleccionado = codigoProducto;
    }

    public void agregarDatosProductoPorCodigoProducto() {
        this.sessionDevolucionProveedor = null;
        this.transactionDevolucionProveedor = null;

        try {

            if (!(this.unidadesDevueltas.matches("[0-9]*")) || this.unidadesDevueltas.equals("0") || this.unidadesDevueltas.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
                this.unidadesDevueltas = "";

            } else {

                this.sessionDevolucionProveedor = HibernateUtil.getSessionFactory().openSession();
                ProductoDao pDao = new ProductoImp();
                this.transactionDevolucionProveedor = this.sessionDevolucionProveedor.beginTransaction();
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionDevolucionProveedor, this.productoSeleccionado);

                this.listaDetalleDevolucionProveedor.add(new DetalleDevolucionProveedor(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), Integer.parseInt(this.unidadesDevueltas), (Float.parseFloat(this.unidadesDevueltas) * this.producto.getValorVentaProducto())));

                this.transactionDevolucionProveedor.commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                this.unidadesDevueltas = "";

                this.calcularValorTotalDevolucionProveedor();

            }

        } catch (Exception e) {
            if (this.transactionDevolucionProveedor != null) {
                System.out.println(e.getMessage());
                transactionDevolucionProveedor.rollback();
            }
        } finally {
            if (this.sessionDevolucionProveedor != null) {
                this.sessionDevolucionProveedor.close();
            }

        }

    }

    public void mostrarDatosCantidadProductoPorCodigo() {
        this.sessionDevolucionProveedor = null;
        this.transactionDevolucionProveedor = null;

        try {
            if (this.codigoProducto == null) {
                return;
            }
            this.sessionDevolucionProveedor = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            this.transactionDevolucionProveedor = this.sessionDevolucionProveedor.beginTransaction();
            this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionDevolucionProveedor, this.codigoProducto);
            if (this.producto != null) {

                RequestContext rc = RequestContext.getCurrentInstance();
                rc.execute("PF('dialogDatosCantidadProductoPorCodigo').show();");

                this.codigoProducto = null;

            } else {
                this.codigoProducto = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Producto Inexistente"));
            }
            this.transactionDevolucionProveedor.commit();
        } catch (Exception e) {
            if (this.transactionDevolucionProveedor != null) {
                System.out.println(e.getMessage());
                transactionDevolucionProveedor.rollback();
            }
        } finally {
            if (this.sessionDevolucionProveedor != null) {
                this.sessionDevolucionProveedor.close();
            }

        }

    }

    public void agregarDatosProductoPorCodigoProductoRead() {

        if (!(this.unidadesDevueltasPorCodigo.matches("[0-9]*")) || this.unidadesDevueltasPorCodigo.equals("0") || this.unidadesDevueltasPorCodigo.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
            this.unidadesDevueltasPorCodigo = "";

        } else {

            this.listaDetalleDevolucionProveedor.add(new DetalleDevolucionProveedor(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), Integer.parseInt(this.unidadesDevueltasPorCodigo), (Float.parseFloat(this.unidadesDevueltasPorCodigo) * this.producto.getValorVentaProducto())));

            this.unidadesDevueltasPorCodigo = "";

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

            this.calcularValorTotalDevolucionProveedor();

        }

    }

    public void calcularValorTotalDevolucionProveedor() {

        this.totalDevolucionProveedorFactura = new BigDecimal("0");

        try {
            for (DetalleDevolucionProveedor detalleDevolucionProveedorTotal : listaDetalleDevolucionProveedor) {
                BigDecimal totalDevolucionProveedorPorProducto = (new BigDecimal(detalleDevolucionProveedorTotal.getValorVentaProducto()).multiply(new BigDecimal(detalleDevolucionProveedorTotal.getUnidadesDevueltas())));
                detalleDevolucionProveedorTotal.setTotalDetalleDevolucionProveedor(totalDevolucionProveedorPorProducto.floatValue());
                totalDevolucionProveedorFactura = totalDevolucionProveedorFactura.add(totalDevolucionProveedorPorProducto);
            }
            this.devolucionProveedor.setTotalDevolucionProveedor(totalDevolucionProveedorFactura.floatValue());
            totalDevolucionProveedorFacturaDevolucionProveedor = (totalDevolucionProveedorFactura.floatValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarProducto(String codigoProducto, Integer posicionSeleccionada) {

        try {

            int i = 0;

            for (DetalleDevolucionProveedor detalleProducto : this.listaDetalleDevolucionProveedor) {
                if (detalleProducto.getCodigoProducto().equals(codigoProducto) && posicionSeleccionada.equals(i)) {
                    this.listaDetalleDevolucionProveedor.remove(i);
                    break;
                }
                i++;
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

            this.calcularValorTotalDevolucionProveedor();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

        }
    }

    public void onRowEdit(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Modificación Realizada"));
        this.calcularValorTotalDevolucionProveedor();
    }

    public void onRowCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Sin Modificacaciones"));

    }

    public void numeracionDevolucionProveedor() {
        this.sessionDevolucionProveedor = null;
        this.transactionDevolucionProveedor = null;

        try {
            this.sessionDevolucionProveedor = HibernateUtil.getSessionFactory().openSession();
            this.transactionDevolucionProveedor = this.sessionDevolucionProveedor.beginTransaction();
            DevolucionProveedorDao vDao = new DevolucionProveedorImp();
            this.numeroDevolucionProveedor = vDao.obtenerTotalRegistrosDevolucionProveedor(this.sessionDevolucionProveedor);

            if (this.numeroDevolucionProveedor <= 0 || this.numeroDevolucionProveedor == null) {
                this.numeroDevolucionProveedor = Long.valueOf("1");
            } else {
                this.devolucionProveedor = vDao.obtenerUltimoRegistroDevolucionProveedor(sessionDevolucionProveedor);
                this.numeroDevolucionProveedor = Long.valueOf(this.devolucionProveedor.getIdDevolucionProveedor() + 1);
                this.totalDevolucionProveedorFactura = new BigDecimal("0");
            }
            this.transactionDevolucionProveedor.commit();
        } catch (Exception e) {
            if (this.transactionDevolucionProveedor != null) {
                this.transactionDevolucionProveedor.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            if (this.sessionDevolucionProveedor != null) {
                this.sessionDevolucionProveedor.close();
            }
            
        }
    }

    public void limpiarFacturaDevolucionProveedor() {
        this.persona = new Persona();
        this.devolucionProveedor = new DevolucionProveedor();
        this.listaDetalleDevolucionProveedor = new ArrayList<>();
        this.numeroDevolucionProveedor = null;
        this.totalDevolucionProveedorFacturaDevolucionProveedor = 0;

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
    
    public void ingresarDevolucionProveedorFULL() {

        this.sessionDevolucionProveedor = null;
        this.transactionDevolucionProveedor = null;

        String idEmpleadoV = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoV));
        this.tipoTransaccion.setIdTipoTransaccion(1); /// aún por definir idTipo de Transacción Contado ó Credito ///
        this.devolucionProveedor.setFechaDevolucionProveedor(new Date());

        try {
            this.sessionDevolucionProveedor = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            DevolucionProveedorDao vDao = new DevolucionProveedorImp();
            DetalleDevolucionProveedorDao dvDao = new DetalleDevolucionProveedorImp();

            this.transactionDevolucionProveedor = this.sessionDevolucionProveedor.beginTransaction();

            this.devolucionProveedor.setNumeroDevolucionProveedor(Long.toString(this.numeroDevolucionProveedor));
            this.devolucionProveedor.setIdEmpleado(this.empleado.getIdEmpleado());
            this.devolucionProveedor.setIdPersona(this.persona.getIdPersona());
            this.devolucionProveedor.setIdTipoTransaccion(this.tipoTransaccion.getIdTipoTransaccion());

            vDao.ingresarDevolucionProveedor(this.sessionDevolucionProveedor, this.devolucionProveedor);

            Object objDevolucionProveedor = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numDevolucionProveedor");
            
            long numRegistrarDevolucionProveedor = ((Number) objDevolucionProveedor).longValue();

            this.numeroDevolucionProveedor = numRegistrarDevolucionProveedor;

            this.devolucionProveedor = vDao.obtenerUltimoRegistroDevolucionProveedor(this.sessionDevolucionProveedor);

            for (DetalleDevolucionProveedor detalleDevolucionProveedorTotal : listaDetalleDevolucionProveedor) {
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionDevolucionProveedor, detalleDevolucionProveedorTotal.getCodigoProducto());
                detalleDevolucionProveedorTotal.setIdDevolucionProveedor(this.devolucionProveedor.getIdDevolucionProveedor());
                detalleDevolucionProveedorTotal.setIdProducto(this.producto.getIdProducto());

                dvDao.ingresarDetalleDevolucionProveedor(this.sessionDevolucionProveedor, detalleDevolucionProveedorTotal);
                
            }
            
            this.transactionDevolucionProveedor.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "DevolucionProveedor Registrada"));

            this.limpiarFacturaDevolucionProveedor();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.transactionDevolucionProveedor != null) {
                this.transactionDevolucionProveedor.rollback();
            }
            
        } finally {
            if (this.sessionDevolucionProveedor != null) {
                this.sessionDevolucionProveedor.close();
            }
        }
    }

    public void reportesDevolucionProveedores() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("+++++ Test Reporte DevolucionProveedores +++++");

        String fechaInicial = this.getFechaInicialDevolucionProveedor();
        String fechaFinal = this.getFechaFinalDevolucionProveedor();

        reportesDevolucionesProveedor rReporte = new reportesDevolucionesProveedor();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteDevolucionProveedores.jasper");

        System.out.println("Fecha Inicial: " + fechaInicial);
        System.out.println("Fecha Final: " + fechaFinal);

        rReporte.getReporte(ruta, fechaInicial, fechaFinal);
        FacesContext.getCurrentInstance().responseComplete();

    }

}
