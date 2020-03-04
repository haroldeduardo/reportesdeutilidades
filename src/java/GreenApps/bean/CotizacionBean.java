
package GreenApps.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import GreenApps.auxiliares.reporteFacturaCotizacion;
import GreenApps.auxiliares.reportesCotizaciones;
import GreenApps.dao.CotizacionDao;
import GreenApps.dao.PersonaDao;
import GreenApps.dao.ProductoDao;
import GreenApps.dao.DetalleCotizacionDao;
import GreenApps.imp.CotizacionImp;
import GreenApps.imp.DetalleCotizacionImp;
import GreenApps.imp.PersonaImp;
import GreenApps.imp.ProductoImp;
import GreenApps.model.Cotizacion;
import GreenApps.model.DetalleCotizacion;
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
@Named(value = "cotizacionBean")
@ViewScoped
@ManagedBean

public class CotizacionBean implements Serializable {

    Session sessionCotizacion = null;
    Session sessionProducto = null;
    Transaction transactionCotizacion = null;
    Transaction transactionProducto = null;

    @ManagedProperty("#{InterfaceUsuarioBean}")
    private InterfaceUsuarioBean uBean;

    private Persona persona;
    private Integer identificacionPersona;

    private Producto producto;
    private String codigoProducto;

    private List<Cotizacion> listaCotizaciones;
    private List<DetalleCotizacion> listaDetalleCotizacion;

    private String unidadesCotizadas;
    private String productoSeleccionado;
    private Cotizacion cotizacion;

    private String unidadesCotizadasPorCodigo;

    private Long numeroCotizacion;
    private BigDecimal totalCotizacionFactura;
    private float totalCotizacionFacturaCotizacion;

    private Empleado empleado;
    private TipoTransaccion tipoTransaccion;

    private boolean enabled;

    private String fechaSistema;

    private String fechaInicialCotizacion;

    private String fechaFinalCotizacion;

    public CotizacionBean() {
        this.cotizacion = new Cotizacion();
        this.listaDetalleCotizacion = new ArrayList<>();
        this.empleado = new Empleado();
        this.persona = new Persona();
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

    public List<DetalleCotizacion> getListaDetalleCotizacion() {
        return listaDetalleCotizacion;
    }

    public List<Cotizacion> getListaCotizaciones() {
        CotizacionDao serDao = new CotizacionImp();
        listaCotizaciones = serDao.mostrarCotizaciones();
        return listaCotizaciones;
    }

    public void setListaCotizaciones(List<Cotizacion> listaCotizaciones) {
        this.listaCotizaciones = listaCotizaciones;
    }
    
    public void setListaDetalleCotizacion(List<DetalleCotizacion> listaDetalleCotizacion) {
        this.listaDetalleCotizacion = listaDetalleCotizacion;
    }

    public String getUnidadesCotizadas() {
        return unidadesCotizadas;
    }

    public void setUnidadesCotizadas(String unidadesCotizadas) {
        this.unidadesCotizadas = unidadesCotizadas;
    }

    public String getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(String productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public String getUnidadesCotizadasPorCodigo() {
        return unidadesCotizadasPorCodigo;
    }

    public void setUnidadesCotizadasPorCodigo(String unidadesCotizadasPorCodigo) {
        this.unidadesCotizadasPorCodigo = unidadesCotizadasPorCodigo;
    }

    public Long getNumeroCotizacion() {
        return numeroCotizacion;
    }

    public void setNumeroCotizacion(Long numeroCotizacion) {
        this.numeroCotizacion = numeroCotizacion;
    }

    public BigDecimal getTotalCotizacionFactura() {
        return totalCotizacionFactura;
    }

    public void setTotalCotizacionFactura(BigDecimal totalCotizacionFactura) {
        this.totalCotizacionFactura = totalCotizacionFactura;
    }

    public float getTotalCotizacionFacturaCotizacion() {
        return totalCotizacionFacturaCotizacion;
    }

    public void setTotalCotizacionFacturaCotizacion(float totalCotizacionFacturaCotizacion) {
        this.totalCotizacionFacturaCotizacion = totalCotizacionFacturaCotizacion;
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

    public String getFechaInicialCotizacion() {
        return fechaInicialCotizacion;
    }

    public void setFechaInicialCotizacion(String fechaInicialCotizacion) {
        this.fechaInicialCotizacion = fechaInicialCotizacion;
    }

    public String getFechaFinalCotizacion() {
        return fechaFinalCotizacion;
    }

    public void setFechaFinalCotizacion(String fechaFinalCotizacion) {
        this.fechaFinalCotizacion = fechaFinalCotizacion;
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

    public void agregarDatosPersona(Integer idPersona) {
        this.sessionCotizacion = null;
        this.transactionCotizacion = null;

        try {
            this.sessionCotizacion = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionCotizacion = this.sessionCotizacion.beginTransaction();
            this.persona = pDao.obtenerPersonaPorId(this.sessionCotizacion, idPersona);
            this.transactionCotizacion.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cotizaciondor Agregado"));
        } catch (Exception e) {
            if (this.transactionCotizacion != null) {
                System.out.println(e.getMessage());
                transactionCotizacion.rollback();
            }
        } finally {
            if (this.sessionCotizacion != null) {
                this.sessionCotizacion.close();
            }

        }

    }

    public void agregarDatosPersonaPorIdentificacion() {
        this.sessionCotizacion = null;
        this.transactionCotizacion = null;

        try {
            if (this.identificacionPersona == null) {
                return;
            }
            this.sessionCotizacion = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionCotizacion = this.sessionCotizacion.beginTransaction();
            this.persona = pDao.obtenerPersonaPorIdentificacion(this.sessionCotizacion, this.identificacionPersona);
            if (this.persona != null) {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cotizaciondor Agregado"));
            } else {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Cotizaciondor Inexistente"));
            }
            this.transactionCotizacion.commit();
        } catch (Exception e) {
            if (this.transactionCotizacion != null) {
                System.out.println(e.getMessage());
                transactionCotizacion.rollback();
            }
        } finally {
            if (this.sessionCotizacion != null) {
                this.sessionCotizacion.close();
            }

        }

    }

    public void solicitarCantidadProducto(String codigoProducto) {
        this.productoSeleccionado = codigoProducto;
    }

    public void agregarDatosProductoPorCodigoProducto() {
        this.sessionCotizacion = null;
        this.transactionCotizacion = null;

        this.sessionCotizacion = HibernateUtil.getSessionFactory().openSession();
        ProductoDao pDao = new ProductoImp();

        try {

            if (!(this.unidadesCotizadas.matches("[0-9]*")) || this.unidadesCotizadas.equals("0") || this.unidadesCotizadas.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
                this.unidadesCotizadas = "";

            } else {

                this.transactionCotizacion = this.sessionCotizacion.beginTransaction();

                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionCotizacion, this.productoSeleccionado);

                boolean isValidate = false;

                try {

                    isValidate = pDao.validarStockProducto(this.sessionCotizacion, this.producto.getCodigoProducto(), Integer.parseInt(this.unidadesCotizadas));

                } catch (Exception ex) {

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Warning"));

                }

                if (isValidate) {

                    this.listaDetalleCotizacion.add(new DetalleCotizacion(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), this.producto.getIva(), Integer.parseInt(this.unidadesCotizadas), (Float.parseFloat(this.unidadesCotizadas) * this.producto.getValorVentaProducto())));

                    this.unidadesCotizadas = "";

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                    this.calcularValorTotalCotizacion();

                } else {

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Stock Insuficiente"));

                    this.unidadesCotizadas = "";

                }

            }

        } catch (Exception e) {
            if (this.transactionCotizacion != null) {
                System.out.println(e.getMessage());
                transactionCotizacion.rollback();
            }
        } finally {
            if (this.sessionCotizacion != null) {
                this.sessionCotizacion.close();
            }

        }

    }

    public void mostrarDatosCantidadProductoPorCodigo() {
        this.sessionCotizacion = null;
        this.transactionCotizacion = null;

        try {
            if (this.codigoProducto == null) {
                return;
            }
            this.sessionCotizacion = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            this.transactionCotizacion = this.sessionCotizacion.beginTransaction();
            this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionCotizacion, this.codigoProducto);
            if (this.producto != null) {

                RequestContext rc = RequestContext.getCurrentInstance();
                rc.execute("PF('dialogDatosCantidadProductoPorCodigo').show();");

                this.codigoProducto = null;

            } else {
                this.codigoProducto = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Producto Inexistente"));
            }
            this.transactionCotizacion.commit();
        } catch (Exception e) {
            if (this.transactionCotizacion != null) {
                System.out.println(e.getMessage());
                transactionCotizacion.rollback();
            }
        } finally {
            if (this.sessionCotizacion != null) {
                this.sessionCotizacion.close();
            }

        }

    }
    
    public void agregarDatosProductoPorCodigoProductoRead() {
        this.sessionCotizacion = null;
        this.transactionCotizacion = null;

        this.sessionCotizacion = HibernateUtil.getSessionFactory().openSession();
        ProductoDao pDao = new ProductoImp();

        if (!(this.unidadesCotizadasPorCodigo.matches("[0-9]*")) || this.unidadesCotizadasPorCodigo.equals("0") || this.unidadesCotizadasPorCodigo.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
            this.unidadesCotizadasPorCodigo = "";

        } else {

            boolean isValidate = false;

            try {
                isValidate = pDao.validarStockProducto(this.sessionCotizacion, this.producto.getCodigoProducto(), Integer.parseInt(this.unidadesCotizadasPorCodigo));
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Warning"));
            }

            if (isValidate) {
                this.listaDetalleCotizacion.add(new DetalleCotizacion(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), this.producto.getIva(), Integer.parseInt(this.unidadesCotizadasPorCodigo), (Float.parseFloat(this.unidadesCotizadasPorCodigo) * this.producto.getValorVentaProducto())));

                this.unidadesCotizadasPorCodigo = "";

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                this.calcularValorTotalCotizacion();

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Stock Insuficiente"));

                this.unidadesCotizadasPorCodigo = "";
            }
        }

    }

    public void calcularValorTotalCotizacion() {

        this.totalCotizacionFactura = new BigDecimal("0");

        try {
            for (DetalleCotizacion detalleCotizacionTotal : listaDetalleCotizacion) {
                BigDecimal totalCotizacionPorProducto = (new BigDecimal(detalleCotizacionTotal.getValorVentaProducto()).multiply(new BigDecimal(detalleCotizacionTotal.getUnidadesCotizadas())));
                detalleCotizacionTotal.setTotalDetalleCotizacion(totalCotizacionPorProducto.floatValue());
                totalCotizacionFactura = totalCotizacionFactura.add(totalCotizacionPorProducto);
            }
            this.cotizacion.setTotalCotizacion(totalCotizacionFactura.floatValue());
            totalCotizacionFacturaCotizacion = (totalCotizacionFactura.floatValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarProducto(String codigoProducto, Integer posicionSeleccionada) {

        try {

            int i = 0;

            for (DetalleCotizacion detalleProducto : this.listaDetalleCotizacion) {
                if (detalleProducto.getCodigoProducto().equals(codigoProducto) && posicionSeleccionada.equals(i)) {
                    this.listaDetalleCotizacion.remove(i);
                    break;
                }
                i++;
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

            this.calcularValorTotalCotizacion();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

        }
    }

    public void onRowEdit(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Modificación Realizada"));
        this.calcularValorTotalCotizacion();
    }

    public void onRowCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Sin Modificacaciones"));

    }

    public void numeracionCotizacion() {
        this.sessionCotizacion = null;
        this.transactionCotizacion = null;

        try {
            this.sessionCotizacion = HibernateUtil.getSessionFactory().openSession();
            this.transactionCotizacion = this.sessionCotizacion.beginTransaction();
            CotizacionDao vDao = new CotizacionImp();
            this.numeroCotizacion = vDao.obtenerTotalRegistrosCotizacion(this.sessionCotizacion);

            if (this.numeroCotizacion <= 0 || this.numeroCotizacion == null) {
                this.numeroCotizacion = Long.valueOf("1");
            } else {
                this.cotizacion = vDao.obtenerUltimoRegistroCotizacion(sessionCotizacion);
                this.numeroCotizacion = Long.valueOf(this.cotizacion.getIdCotizacion() + 1);
                this.totalCotizacionFactura = new BigDecimal("0");
            }
            this.transactionCotizacion.commit();
        } catch (Exception e) {
            if (this.transactionCotizacion != null) {
                this.transactionCotizacion.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            if (this.sessionCotizacion != null) {
                this.sessionCotizacion.close();
            }
            
        }
    }

    public void limpiarFacturaCotizacion() {
        this.persona = new Persona();
        this.cotizacion = new Cotizacion();
        this.listaDetalleCotizacion = new ArrayList<>();
        this.numeroCotizacion = null;
        this.totalCotizacionFacturaCotizacion = 0;

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
    
    public void ingresarCotizacionFULL() {

        this.sessionCotizacion = null;
        this.transactionCotizacion = null;

        String idEmpleadoV = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoV));
        this.tipoTransaccion.setIdTipoTransaccion(1); /// aún por definir idTipo de Transacción Contado ó Credito ///
        this.cotizacion.setFechaCotizacion(new Date());

        try {
            this.sessionCotizacion = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            CotizacionDao vDao = new CotizacionImp();
            DetalleCotizacionDao dvDao = new DetalleCotizacionImp();

            this.transactionCotizacion = this.sessionCotizacion.beginTransaction();

            this.cotizacion.setNumeroCotizacion(Long.toString(this.numeroCotizacion));
            this.cotizacion.setIdEmpleado(this.empleado.getIdEmpleado());
            this.cotizacion.setIdPersona(this.persona.getIdPersona());

            vDao.ingresarCotizacion(this.sessionCotizacion, this.cotizacion);

            Object objCotizacion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numCotizacion");
            
            long numRegistrarCotizacion = ((Number) objCotizacion).longValue();

            this.numeroCotizacion = numRegistrarCotizacion;

            this.cotizacion = vDao.obtenerUltimoRegistroCotizacion(this.sessionCotizacion);

            for (DetalleCotizacion detalleCotizacionTotal : listaDetalleCotizacion) {
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionCotizacion, detalleCotizacionTotal.getCodigoProducto());
                detalleCotizacionTotal.setIdCotizacion(this.cotizacion.getIdCotizacion());
                detalleCotizacionTotal.setIdProducto(this.producto.getIdProducto());

                dvDao.ingresarDetalleCotizacion(this.sessionCotizacion, detalleCotizacionTotal);
                
            }
            
            this.transactionCotizacion.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cotizacion Registrada"));

            this.limpiarFacturaCotizacion();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.transactionCotizacion != null) {
                this.transactionCotizacion.rollback();
            }
            
        } finally {
            if (this.sessionCotizacion != null) {
                this.sessionCotizacion.close();
            }
        }
    }

    public void reporteImpresionFacturaCotizacion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String idEmpleadoV = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoV));
        System.out.println("+++++ Test Factura Cotizacion +++++");
        int idP = this.persona.getIdentificacionPersona();
        int idE = this.empleado.getIdEmpleado();

        this.ingresarCotizacionFULL();

        Object objCotizacion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numCotizacion");
        
        int numImprimirCotizacion = ((Number) objCotizacion).intValue();

        this.cotizacion.setIdCotizacion(numImprimirCotizacion);

        int idC = this.cotizacion.getIdCotizacion();

        reporteFacturaCotizacion rFactura = new reporteFacturaCotizacion();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteFacturaCotizacion.jasper");

        System.out.println("Cotizaciondor: " + idP);
        System.out.println("Vendedor: " + idE);
        System.out.println("Factura: " + idC);

        rFactura.getReporte(ruta, idP, idE, idC);
        FacesContext.getCurrentInstance().responseComplete();

    }

    public void reportesCotizaciones() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("+++++ Test Reporte Cotizaciones +++++");

        String fechaInicial = this.getFechaInicialCotizacion();
        String fechaFinal = this.getFechaFinalCotizacion();

        reportesCotizaciones rReporte = new reportesCotizaciones();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteCotizaciones.jasper");

        System.out.println("Fecha Inicial: " + fechaInicial);
        System.out.println("Fecha Final: " + fechaFinal);

        rReporte.getReporte(ruta, fechaInicial, fechaFinal);
        FacesContext.getCurrentInstance().responseComplete();

    }

}
