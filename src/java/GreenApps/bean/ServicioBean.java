
package GreenApps.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import GreenApps.auxiliares.reporteFacturaServicio;
import GreenApps.auxiliares.reportesServicios;
import GreenApps.dao.DetalleServicioDao;
import GreenApps.dao.MecanicoDao;
import GreenApps.dao.PersonaDao;
import GreenApps.dao.ProductoDao;
import GreenApps.imp.DetalleServicioImp;
import GreenApps.imp.MecanicoImp;
import GreenApps.imp.PersonaImp;
import GreenApps.imp.ProductoImp;
import GreenApps.imp.ServicioImp;
import GreenApps.model.DetalleServicio;
import GreenApps.model.Empleado;
import GreenApps.model.Mecanico;
import GreenApps.model.Moto;
import GreenApps.model.Persona;
import GreenApps.model.Producto;
import GreenApps.model.TipoTransaccion;
import GreenApps.model.Servicio;
import GreenApps.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import GreenApps.dao.ServicioDao;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
@Named(value = "servicioBean")
@ViewScoped

public class ServicioBean implements Serializable {

    Session sessionServicio = null;
    Session sessionProducto = null;

    Transaction transactionServicio = null;
    Transaction transactionProducto = null;

    @ManagedProperty("#{InterfaceUsuarioBean}")
    private InterfaceUsuarioBean uBean;

    private Servicio servicio;
    private DetalleServicio detalleServicio = new DetalleServicio();

    private Empleado empleado;
    private Integer identificacionEmpleado;

    private Persona persona;
    private Integer identificacionPersona;

    private Mecanico mecanico;
    private Integer identificacionMecanico;

    private Producto producto;
    private String codigoProducto;

    private List<Servicio> listaServicios;
    private List<DetalleServicio> listaDetalleServicio;

    private String unidadesVendidas;
    private String productoSeleccionado;

    private String unidadesVendidasPorCodigo;

    private Long numeroServicio;
    private BigDecimal totalServicioFactura;
    private float totalServicioFacturaServicio;

    private TipoTransaccion tipoTransaccion;

    private boolean enabled;

    private String fechaSistema;

    private String fechaInicialServicio;

    private String fechaFinalServicio;

    public ServicioBean() {

        this.servicio = new Servicio();
        this.listaDetalleServicio = new ArrayList<>();
        this.empleado = new Empleado();
        this.persona = new Persona();
        this.mecanico = new Mecanico();
        this.tipoTransaccion = new TipoTransaccion();

    }

    public InterfaceUsuarioBean getuBean() {
        return uBean;
    }

    public void setuBean(InterfaceUsuarioBean uBean) {
        this.uBean = uBean;
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

    public DetalleServicio getDetalleServicio() {
        return detalleServicio;
    }

    public void setDetalleServicio(DetalleServicio detalleServicio) {
        this.detalleServicio = detalleServicio;
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

    public List<DetalleServicio> getListaDetalleServicio() {
        return listaDetalleServicio;
    }

    public void setListaDetalleServicio(List<DetalleServicio> listaDetalleServicio) {
        this.listaDetalleServicio = listaDetalleServicio;
    }

    public List<Servicio> getListaServicios() {
        ServicioDao serDao = new ServicioImp();
        listaServicios = serDao.mostrarServicios();
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public String getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(String unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public String getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(String productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getUnidadesVendidasPorCodigo() {
        return unidadesVendidasPorCodigo;
    }

    public void setUnidadesVendidasPorCodigo(String unidadesVendidasPorCodigo) {
        this.unidadesVendidasPorCodigo = unidadesVendidasPorCodigo;
    }

    public Long getNumeroServicio() {
        return numeroServicio;
    }

    public void setNumeroServicio(Long numeroServicio) {
        this.numeroServicio = numeroServicio;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public Integer getIdentificacionMecanico() {
        return identificacionMecanico;
    }

    public void setIdentificacionMecanico(Integer identificacionMecanico) {
        this.identificacionMecanico = identificacionMecanico;
    }

    public BigDecimal getTotalServicioFactura() {
        return totalServicioFactura;
    }

    public void setTotalServicioFactura(BigDecimal totalServicioFactura) {
        this.totalServicioFactura = totalServicioFactura;
    }

    public float getTotalServicioFacturaServicio() {
        return totalServicioFacturaServicio;
    }

    public void setTotalServicioFacturaServicio(float totalServicioFacturaServicio) {
        this.totalServicioFacturaServicio = totalServicioFacturaServicio;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Integer getIdentificacionEmpleado() {
        return identificacionEmpleado;
    }

    public void setIdentificacionEmpleado(Integer identificacionEmpleado) {
        this.identificacionEmpleado = identificacionEmpleado;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getFechaInicialServicio() {
        return fechaInicialServicio;
    }

    public void setFechaInicialServicio(String fechaInicialServicio) {
        this.fechaInicialServicio = fechaInicialServicio;
    }

    public String getFechaFinalServicio() {
        return fechaFinalServicio;
    }

    public void setFechaFinalServicio(String fechaFinalServicio) {
        this.fechaFinalServicio = fechaFinalServicio;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void enableBoton() {
        enabled = true;
    }

    public void enableModificarServicio() throws Exception {

        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();

        int idServicio = Integer.parseInt(params.get("idServicioi"));
        int estServicio = Integer.parseInt(params.get("estServicioi"));

        //Estado Activo
        if (estServicio == 1) {

            DetalleServicioDao dsd = new DetalleServicioImp();
            this.listaDetalleServicio = dsd.mostrarDetalleServiciosIdServicio(idServicio);

            ServicioDao sd = new ServicioImp();
            this.servicio = sd.obtenerServicioPorIdServicio(idServicio);
            
            this.calcularValorTotalServicio();

            enabled = true;

        } 
        
        //Estado Inactivo
        else {
            
            DetalleServicioDao dsd = new DetalleServicioImp();
            this.listaDetalleServicio = dsd.mostrarDetalleServiciosIdServicio(idServicio);

            ServicioDao sd = new ServicioImp();
            this.servicio = sd.obtenerServicioPorIdServicio(idServicio);
                
            this.calcularValorTotalServicio();

            enabled = false;

        }
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

    public void numeracionServicio() {
        this.sessionServicio = null;
        this.transactionServicio = null;

        try {
            this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
            this.transactionServicio = this.sessionServicio.beginTransaction();
            ServicioDao vDao = new ServicioImp();
            this.numeroServicio = vDao.obtenerTotalRegistrosServicio(this.sessionServicio);

            if (this.numeroServicio <= 0 || this.numeroServicio == null) {
                this.numeroServicio = Long.valueOf("1");
            } else {
                this.servicio = vDao.obtenerUltimoRegistroServicio(sessionServicio);
                this.numeroServicio = Long.valueOf(this.servicio.getIdServicio() + 1);
                this.totalServicioFactura = new BigDecimal("0");
            }
            this.transactionServicio.commit();
        } catch (Exception e) {
            if (this.transactionServicio != null) {
                this.transactionServicio.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }

        }

    }

    public void agregarDatosPersona(Integer idPersona) {
        this.sessionServicio = null;
        this.transactionServicio = null;

        try {
            this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionServicio = this.sessionServicio.beginTransaction();
            this.persona = pDao.obtenerPersonaPorId(this.sessionServicio, idPersona);
            this.transactionServicio.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Comprador Agregado"));
        } catch (Exception e) {
            if (this.transactionServicio != null) {
                System.out.println(e.getMessage());
                transactionServicio.rollback();
            }
        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }

        }

    }

    public void agregarDatosMecanico(Integer idMecanico) {
        this.sessionServicio = null;
        this.transactionServicio = null;

        try {
            this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
            MecanicoDao mDao = new MecanicoImp();
            this.transactionServicio = this.sessionServicio.beginTransaction();
            this.mecanico = mDao.obtenerMecanicoPorId(this.sessionServicio, idMecanico);
            this.transactionServicio.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Mecánico Agregado"));
        } catch (Exception e) {
            if (this.transactionServicio != null) {
                System.out.println(e.getMessage());
                transactionServicio.rollback();
            }
        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }

        }

    }

    public void agregarDatosPersonaPorIdentificacion() {
        this.sessionServicio = null;
        this.transactionServicio = null;

        try {
            if (this.identificacionPersona == null) {
                return;
            }
            this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionServicio = this.sessionServicio.beginTransaction();
            this.persona = pDao.obtenerPersonaPorIdentificacion(this.sessionServicio, this.identificacionPersona);
            if (this.persona != null) {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Comprador Agregado"));
            } else {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Comprador Inexistente"));
            }
            this.transactionServicio.commit();
        } catch (Exception e) {
            if (this.transactionServicio != null) {
                System.out.println(e.getMessage());
                transactionServicio.rollback();
            }
        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }

        }

    }

    public void agregarDatosMecanicoPorIdentificacion() {
        this.sessionServicio = null;
        this.transactionServicio = null;

        try {
            if (this.identificacionMecanico == null) {
                return;
            }
            this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
            MecanicoDao mDao = new MecanicoImp();
            this.transactionServicio = this.sessionServicio.beginTransaction();
            this.mecanico = mDao.obtenerMecanicoPorIdentificacion(this.sessionServicio, this.identificacionMecanico);
            if (this.mecanico != null) {
                this.identificacionMecanico = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Mecanico Agregado"));
            } else {
                this.identificacionMecanico = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Mecanico Inexistente"));
            }
            this.transactionServicio.commit();
        } catch (Exception e) {
            if (this.transactionServicio != null) {
                System.out.println(e.getMessage());
                transactionServicio.rollback();
            }
        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }

        }

    }

    public void solicitarCantidadProducto(String codigoProducto) {
        this.productoSeleccionado = codigoProducto;
    }

    public void agregarDatosProductoPorCodigoProducto() {

        this.sessionServicio = null;
        this.transactionServicio = null;

        this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
        ProductoDao pDao = new ProductoImp();

        try {

            if (!(this.unidadesVendidas.matches("[0-9]*")) || this.unidadesVendidas.equals("0") || this.unidadesVendidas.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
                this.unidadesVendidas = "";

            } else {

                this.transactionServicio = this.sessionServicio.beginTransaction();

                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionServicio, this.productoSeleccionado);

                boolean isValidate = false;

                try {

                    isValidate = pDao.validarStockProducto(this.sessionServicio, this.producto.getCodigoProducto(), Integer.parseInt(this.unidadesVendidas));

                } catch (Exception ex) {

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Warning"));

                }

                if (isValidate) {

                    this.listaDetalleServicio.add(new DetalleServicio(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), this.producto.getIva(), Integer.parseInt(this.unidadesVendidas), (Float.parseFloat(this.unidadesVendidas) * this.producto.getValorVentaProducto())));

                    this.unidadesVendidas = "";

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                    this.calcularValorTotalServicio();

                } else {

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Stock Insuficiente"));

                    this.unidadesVendidas = "";

                }

            }

        } catch (Exception e) {
            if (this.transactionServicio != null) {
                System.out.println(e.getMessage());
                transactionServicio.rollback();
            }
        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }

        }

    }

    public void agregarDatosProductoPorCodigoProductoModificado() {

        this.sessionServicio = null;
        this.transactionServicio = null;

        this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
        ProductoDao pDao = new ProductoImp();
        DetalleServicioDao dsDao = new DetalleServicioImp();

        try {

            if (!(this.unidadesVendidas.matches("[0-9]*")) || this.unidadesVendidas.equals("0") || this.unidadesVendidas.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
                this.unidadesVendidas = "";

            } else {

                this.transactionServicio = this.sessionServicio.beginTransaction();

                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionServicio, this.productoSeleccionado);

                float Total = Integer.parseInt(unidadesVendidas) * this.producto.getValorVentaProducto();

                DetalleServicio nuevoDetalleServicio = new DetalleServicio(this.servicio.getIdServicio(), this.producto.getIdProducto(), this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), this.producto.getIva(), Integer.parseInt(unidadesVendidas), Total);

                boolean isValidate = false;

                try {

                    isValidate = pDao.validarStockProducto(this.sessionServicio, this.producto.getCodigoProducto(), Integer.parseInt(this.unidadesVendidas));

                } catch (Exception ex) {

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Warning"));

                }

                if (isValidate) {

                    this.listaDetalleServicio.add(new DetalleServicio(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), this.producto.getIva(), Integer.parseInt(this.unidadesVendidas), (Float.parseFloat(this.unidadesVendidas) * this.producto.getValorVentaProducto())));

                    this.unidadesVendidas = "";

                    dsDao.ingresarDetalleServicio(this.sessionServicio, nuevoDetalleServicio);

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                    this.calcularValorTotalServicio();

                } else {

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Stock Insuficiente"));

                    this.unidadesVendidas = "";

                }

            }

        } catch (Exception e) {
            if (this.transactionServicio != null) {
                System.out.println(e.getMessage());
                transactionServicio.rollback();
            }
        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }

        }

    }

    public void mostrarDatosCantidadProductoPorCodigo() {

        this.sessionServicio = null;
        this.transactionServicio = null;

        try {
            if (this.codigoProducto == null) {
                return;
            }
            this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            this.transactionServicio = this.sessionServicio.beginTransaction();
            this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionServicio, this.codigoProducto);
            if (this.producto != null) {

                RequestContext rc = RequestContext.getCurrentInstance();
                rc.execute("PF('dialogDatosCantidadProductoPorCodigoRead').show();");

                this.codigoProducto = null;

            } else {
                this.codigoProducto = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Producto Inexistente"));
            }
            this.transactionServicio.commit();
        } catch (Exception e) {
            if (this.transactionServicio != null) {
                System.out.println(e.getMessage());
                transactionServicio.rollback();
            }
        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }

        }

    }

    public void mostrarDatosCantidadProductoModificadoPorCodigo() {

        this.sessionServicio = null;
        this.transactionServicio = null;

        try {
            if (this.codigoProducto == null) {
                return;
            }
            this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            this.transactionServicio = this.sessionServicio.beginTransaction();
            this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionServicio, this.codigoProducto);
            if (this.producto != null) {

                RequestContext rc = RequestContext.getCurrentInstance();
                rc.execute("PF('dialogDatosCantidadProductoModificadoPorCodigoRead').show();");

                this.codigoProducto = null;

            } else {
                this.codigoProducto = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Producto Inexistente"));
            }
            this.transactionServicio.commit();
        } catch (Exception e) {
            if (this.transactionServicio != null) {
                System.out.println(e.getMessage());
                transactionServicio.rollback();
            }
        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }

        }

    }

    public void agregarDatosProductoPorCodigoProductoRead() {

        this.sessionServicio = null;
        this.transactionServicio = null;

        this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
        ProductoDao pDao = new ProductoImp();

        if (!(this.unidadesVendidasPorCodigo.matches("[0-9]*")) || this.unidadesVendidasPorCodigo.equals("0") || this.unidadesVendidasPorCodigo.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
            this.unidadesVendidasPorCodigo = "";

        } else {

            boolean isValidate = false;

            try {

                isValidate = pDao.validarStockProducto(this.sessionServicio, this.producto.getCodigoProducto(), Integer.parseInt(this.unidadesVendidasPorCodigo));

            } catch (Exception ex) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Warning"));

            }

            if (isValidate) {

                this.listaDetalleServicio.add(new DetalleServicio(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), this.producto.getIva(), Integer.parseInt(this.unidadesVendidasPorCodigo), (Float.parseFloat(this.unidadesVendidasPorCodigo) * this.producto.getValorVentaProducto())));

                this.unidadesVendidasPorCodigo = "";

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                this.calcularValorTotalServicio();

            } else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Stock Insuficiente"));

                this.unidadesVendidasPorCodigo = "";

            }
        }

    }

    public void agregarDatosProductoModificadoPorCodigoProductoRead() {

        this.sessionServicio = null;
        this.transactionServicio = null;

        this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
        ProductoDao pDao = new ProductoImp();
        DetalleServicioDao dsDao = new DetalleServicioImp();

        try {

            if (!(this.unidadesVendidasPorCodigo.matches("[0-9]*")) || this.unidadesVendidasPorCodigo.equals("0") || this.unidadesVendidasPorCodigo.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
                this.unidadesVendidasPorCodigo = "";

            } else {

                float Total = Integer.parseInt(unidadesVendidasPorCodigo) * this.producto.getValorVentaProducto();

                DetalleServicio nuevoDetalleServicio = new DetalleServicio(this.servicio.getIdServicio(), this.producto.getIdProducto(), this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), this.producto.getIva(), Integer.parseInt(unidadesVendidasPorCodigo), Total);

                boolean isValidate = false;

                try {

                    isValidate = pDao.validarStockProducto(this.sessionServicio, this.producto.getCodigoProducto(), Integer.parseInt(this.unidadesVendidasPorCodigo));

                } catch (Exception ex) {

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Warning"));

                }

                if (isValidate) {

                    this.listaDetalleServicio.add(new DetalleServicio(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), this.producto.getIva(), Integer.parseInt(this.unidadesVendidasPorCodigo), (Float.parseFloat(this.unidadesVendidasPorCodigo) * this.producto.getValorVentaProducto())));

                    this.unidadesVendidasPorCodigo = "";

                    dsDao.ingresarDetalleServicio(this.sessionServicio, nuevoDetalleServicio);

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                    this.calcularValorTotalServicio();

                } else {

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Stock Insuficiente"));

                    this.unidadesVendidasPorCodigo = "";

                }
            }

        } catch (Exception e) {
            if (this.transactionServicio != null) {
                System.out.println(e.getMessage());
                transactionServicio.rollback();
            }
        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }

        }

    }

    public void calcularValorTotalServicio() {

        this.totalServicioFactura = new BigDecimal("0");

        try {
            for (DetalleServicio detalleServicioTotal : listaDetalleServicio) {
                BigDecimal totalServicioPorProducto = (new BigDecimal(detalleServicioTotal.getValorVentaProducto()).multiply(new BigDecimal(detalleServicioTotal.getUnidadesVendidas())));
                detalleServicioTotal.setTotalDetalleServicio(totalServicioPorProducto.floatValue());
                totalServicioFactura = totalServicioFactura.add(totalServicioPorProducto);
            }
            this.servicio.setTotalServicio(totalServicioFactura.floatValue());
            totalServicioFacturaServicio = (totalServicioFactura.floatValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarProducto(String codigoProducto, Integer posicionSeleccionada) {

        try {

            int i = 0;

            for (DetalleServicio detalleProducto : this.listaDetalleServicio) {

                if (detalleProducto.getCodigoProducto().equals(codigoProducto) && posicionSeleccionada.equals(i)) {
                    this.listaDetalleServicio.remove(i);
                    break;
                }
                i++;
            }

            this.calcularValorTotalServicio();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

        }
    }

    public void onRowEdit(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Modificación Realizada"));
        this.calcularValorTotalServicio();
    }

    public void onRowEditDetalleServicioModificado(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Modificación Realizada"));
        this.calcularValorTotalServicio();
    }

    public void onRowCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Sin Modificacaciones"));

    }

    public void limpiarFacturaServicio() {
        this.persona = new Persona();
        this.servicio = new Servicio();
        this.mecanico = new Mecanico();
        this.listaDetalleServicio = new ArrayList<>();
        this.totalServicioFacturaServicio = 0;
        this.numeroServicio = null;

        this.disableBoton();
    }

    public void limpiarCamposServicio() {
        this.servicio.setPlaca("");
        this.servicio.setObservacionServicio("");

        this.disableBoton();
    }

    public void enableEstadoServicio() {

        this.sessionServicio = null;
        this.transactionServicio = null;

        String EstadoServicioInactivo = "1";

        this.servicio.setEstadoServicio(Byte.valueOf(EstadoServicioInactivo));

    }

    public void disableEstadoServicio() {

        this.sessionServicio = null;
        this.transactionServicio = null;

        String EstadoServicioInactivo = "0";

        this.servicio.setEstadoServicio(Byte.valueOf(EstadoServicioInactivo));

    }

    public void ingresarServicioFULL() {

        this.sessionServicio = null;
        this.transactionServicio = null;

        String idEmpleadoS = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoS));
        this.tipoTransaccion.setIdTipoTransaccion(1); /// aún por definir idTipo de Transacción Contado ó Credito ///
        this.servicio.setFechaServicio(new Date());
        this.disableEstadoServicio();

        try {
            this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            ServicioDao sDao = new ServicioImp();
            DetalleServicioDao dsDao = new DetalleServicioImp();
            servicio.setPlaca(servicio.getPlaca().toUpperCase());
            servicio.setObservacionServicio(servicio.getObservacionServicio().toUpperCase());

            this.transactionServicio = this.sessionServicio.beginTransaction();

            this.servicio.setNumeroServicio(Long.toString(this.numeroServicio));
            this.servicio.setIdEmpleado(this.empleado.getIdEmpleado());
            this.servicio.setIdPersona(this.persona.getIdPersona());
            this.servicio.setIdMecanico(this.mecanico.getIdMecanico());
            this.servicio.setIdTipoTransaccion(this.tipoTransaccion.getIdTipoTransaccion());

            sDao.ingresarServicio(this.sessionServicio, this.servicio);

            Object objServicio = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numServicio");

            long numRegistrarServicio = ((Number) objServicio).longValue();

            this.numeroServicio = numRegistrarServicio;

            this.servicio = sDao.obtenerUltimoRegistroServicio(this.sessionServicio);

            for (DetalleServicio detalleServicioTotal : listaDetalleServicio) {
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionServicio, detalleServicioTotal.getCodigoProducto());
                detalleServicioTotal.setIdServicio(this.servicio.getIdServicio());
                detalleServicioTotal.setIdProducto(this.producto.getIdProducto());

                dsDao.ingresarDetalleServicio(this.sessionServicio, detalleServicioTotal);

            }

            this.transactionServicio.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Servicio Registrado"));

            this.limpiarFacturaServicio();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.transactionServicio != null) {
                this.transactionServicio.rollback();
            }

        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }
        }

    }

    public void editarServicioFULL() {

        this.sessionServicio = null;
        this.transactionServicio = null;

        String idEmpleadoS = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoS));
        this.tipoTransaccion.setIdTipoTransaccion(1); /// aún por definir idTipo de Transacción Contado ó Credito ///
        this.servicio.setFechaServicio(new Date());
        this.enableEstadoServicio();

        try {
            this.sessionServicio = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            ServicioDao sDao = new ServicioImp();
            servicio.setPlaca(servicio.getPlaca().toUpperCase());
            servicio.setObservacionServicio(servicio.getObservacionServicio().toUpperCase());
            DetalleServicioDao dsDao = new DetalleServicioImp();

            this.transactionServicio = this.sessionServicio.beginTransaction();

            this.servicio.setNumeroServicio(Long.toString(this.numeroServicio));
            this.servicio.setIdEmpleado(this.empleado.getIdEmpleado());
            this.servicio.setIdPersona(this.persona.getIdPersona());
            this.servicio.setIdMecanico(this.mecanico.getIdMecanico());
            this.servicio.setIdTipoTransaccion(this.tipoTransaccion.getIdTipoTransaccion());

            sDao.ingresarServicio(this.sessionServicio, this.servicio);

            Object objServicio = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numServicio");

            long numRegistrarServicio = ((Number) objServicio).longValue();

            this.numeroServicio = numRegistrarServicio;

            this.servicio = sDao.obtenerUltimoRegistroServicio(this.sessionServicio);

            for (DetalleServicio detalleServicioTotal : listaDetalleServicio) {
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionServicio, detalleServicioTotal.getCodigoProducto());
                detalleServicioTotal.setIdServicio(this.servicio.getIdServicio());
                detalleServicioTotal.setIdProducto(this.producto.getIdProducto());

                dsDao.ingresarDetalleServicio(this.sessionServicio, detalleServicioTotal);

            }

            this.transactionServicio.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Servicio Registrado"));

            this.limpiarFacturaServicio();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.transactionServicio != null) {
                this.transactionServicio.rollback();
            }

        } finally {
            if (this.sessionServicio != null) {
                this.sessionServicio.close();
            }
        }

    }

    public void guardarServicioModificado() {

        ServicioDao serDao = new ServicioImp();
        servicio.setPlaca(servicio.getPlaca().toUpperCase());
        servicio.setObservacionServicio(servicio.getObservacionServicio().toUpperCase());
        this.disableEstadoServicio();
        serDao.actualizarServicio(servicio);
        servicio = new Servicio();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Servicio Finalizado"));

    }

    public void editarServicioModificado() {

        ServicioDao serDao = new ServicioImp();
        servicio.setPlaca(servicio.getPlaca().toUpperCase());
        servicio.setObservacionServicio(servicio.getObservacionServicio().toUpperCase());
        this.enableEstadoServicio();
        serDao.actualizarServicio(servicio);
        servicio = new Servicio();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Servicio Modificado"));

    }

    public void editarDetalleServicioModificado() {

        DetalleServicioDao dsDao = new DetalleServicioImp();
        dsDao.editarDetalleServicio(detalleServicio);
        detalleServicio = new DetalleServicio();
        this.calcularValorTotalServicio();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Modificado"));

    }

    public void eliminarDetalleServicioModificado() {

        DetalleServicioDao dsDao = new DetalleServicioImp();
        dsDao.eliminarDetalleServicio(detalleServicio);
        detalleServicio = new DetalleServicio();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Eliminado"));

    }
    
    public String getmostrarMoto(Integer id) {

        if (id == null) {
            return "";
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object object = session.get(Moto.class, id);
        if (object == null) {
            return "";
        } else {
            return ((Moto) object).getNombreMoto();
        }

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
    
    public String getmostrarMecanico(Integer id) {

        if (id == null) {
            return "";
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object object = session.get(Mecanico.class, id);
        if (object == null) {
            return "";
        } else {
            return ((Mecanico) object).getNombresMecanico();
        }

    }
    
    public void reporteImpresionFacturaServicio() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String idEmpleadoS = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoS));
        
        System.out.println("+++++ Test Factura Servicio +++++");
        
        int idP = this.persona.getIdentificacionPersona();
        
        int idE = this.empleado.getIdEmpleado();
        
        this.ingresarServicioFULL();

        
        Object objServicio = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numServicio");
        
        int numImprimirServicio = ((Number) objServicio).intValue();

        this.servicio.setIdServicio(numImprimirServicio);

        
        int idS = this.servicio.getIdServicio();
        
        reporteFacturaServicio rFactura = new reporteFacturaServicio();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteFacturaServicio.jasper");

        System.out.println("Comprador: " + idP);
        System.out.println("Vendedor: " + idE);
        System.out.println("Factura: " + idS);

        rFactura.getReporte(ruta, idP, idE, idS);
        FacesContext.getCurrentInstance().responseComplete();

    }

    public void reporteImpresionFacturaServicioModificado(Integer idServicio) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("+++++ Test Factura Servicio +++++");
        
        String idEmpleadoS = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoS));
        
        System.out.println("+++++ Test Factura Servicio +++++"+ " idEmpleadoS: "+idEmpleadoS);
        
        int idP = this.persona.getIdentificacionPersona();
        
        int idE = this.empleado.getIdEmpleado();

        System.out.println("+++++ Test Factura Servicio +++++"+" Persona: "+idP+" Empleado: "+idE);
        
        this.guardarServicioModificado();
        
        this.servicio.setIdServicio(idServicio);
        
        int idS = this.servicio.getIdServicio();

        System.out.println("+++++ Test Factura Servicio +++++"+" Servicio: "+idS);
        
        reporteFacturaServicio rFactura = new reporteFacturaServicio();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteFacturaServicio.jasper");

        System.out.println("Comprador: " + idP);
        System.out.println("Vendedor: " + idE);
        System.out.println("Factura: " + idS);

        rFactura.getReporte(ruta, idP, idE, idS);
        FacesContext.getCurrentInstance().responseComplete();

    }
    
    public void reportesServicios() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("+++++ Test Reporte Servicios +++++");

        String fechaInicial = this.getFechaInicialServicio();
        String fechaFinal = this.getFechaFinalServicio();

        reportesServicios rReporte = new reportesServicios();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteServicios.jasper");

        System.out.println("Fecha Inicial: " + fechaInicial);
        System.out.println("Fecha Final: " + fechaFinal);

        rReporte.getReporte(ruta, fechaInicial, fechaFinal);
        FacesContext.getCurrentInstance().responseComplete();
        
    }
    
}