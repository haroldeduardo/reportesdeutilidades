
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
import GreenApps.auxiliares.reporteFacturaCompra;
import GreenApps.auxiliares.reportesCompras;
import GreenApps.dao.CompraDao;
import GreenApps.dao.PersonaDao;
import GreenApps.dao.ProductoDao;
import GreenApps.dao.DetalleCompraDao;
import GreenApps.imp.CompraImp;
import GreenApps.imp.DetalleCompraImp;
import GreenApps.imp.PersonaImp;
import GreenApps.imp.ProductoImp;
import GreenApps.model.Compra;
import GreenApps.model.DetalleCompra;
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
@Named(value = "compraBean")
@ViewScoped
@ManagedBean

public class CompraBean implements Serializable {

    Session sessionCompra = null;
    Transaction transactionCompra = null;

    @ManagedProperty("#{interfaceUsuarioBean}")
    private InterfaceUsuarioBean uBean;

    private Persona persona;
    private Integer identificacionPersona;

    private Producto producto;
    private String codigoProducto;

    private List<Compra> listaCompras;
    private List<DetalleCompra> listaDetalleCompra;

    private String unidadesCompradas;
    private String productoSeleccionado;
    private Compra compra;

    private String unidadesCompradasPorCodigo;

    private Long numeroCompra;
    private BigDecimal totalCompraFactura;
    private float totalCompraFacturaCompra;

    private Empleado empleado;
    private TipoTransaccion tipoTransaccion;

    private boolean enabled;

    private String fechaSistema;

    private String fechaInicialCompra;

    private String fechaFinalCompra;

    public CompraBean() {

        this.compra = new Compra();
        this.listaDetalleCompra = new ArrayList<>();
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

    public List<DetalleCompra> getListaDetalleCompra() {
        return listaDetalleCompra;
    }

    public void setListaDetalleCompra(List<DetalleCompra> listaDetalleCompra) {
        this.listaDetalleCompra = listaDetalleCompra;
    }

    public List<Compra> getListaCompras() {
        CompraDao serDao = new CompraImp();
        listaCompras = serDao.mostrarCompras();
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }
    
    public String getUnidadesCompradas() {
        return unidadesCompradas;
    }

    public void setUnidadesCompradas(String unidadesCompradas) {
        this.unidadesCompradas = unidadesCompradas;
    }

    public String getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(String productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public String getUnidadesCompradasPorCodigo() {
        return unidadesCompradasPorCodigo;
    }

    public void setUnidadesCompradasPorCodigo(String unidadesCompradasPorCodigo) {
        this.unidadesCompradasPorCodigo = unidadesCompradasPorCodigo;
    }

    public Long getNumeroCompra() {
        return numeroCompra;
    }

    public void setNumeroCompra(Long numeroCompra) {
        this.numeroCompra = numeroCompra;
    }

    public BigDecimal getTotalCompraFactura() {
        return totalCompraFactura;
    }

    public void setTotalCompraFactura(BigDecimal totalCompraFactura) {
        this.totalCompraFactura = totalCompraFactura;
    }

    public float getTotalCompraFacturaCompra() {
        return totalCompraFacturaCompra;
    }

    public void setTotalCompraFacturaCompra(float totalCompraFacturaCompra) {
        this.totalCompraFacturaCompra = totalCompraFacturaCompra;
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

    public String getFechaInicialCompra() {
        return fechaInicialCompra;
    }

    public void setFechaInicialCompra(String fechaInicialCompra) {
        this.fechaInicialCompra = fechaInicialCompra;
    }

    public String getFechaFinalCompra() {
        return fechaFinalCompra;
    }

    public void setFechaFinalCompra(String fechaFinalCompra) {
        this.fechaFinalCompra = fechaFinalCompra;
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

    public void numeracionCompra() {
        this.sessionCompra = null;
        this.transactionCompra = null;

        try {
            this.sessionCompra = HibernateUtil.getSessionFactory().openSession();
            this.transactionCompra = this.sessionCompra.beginTransaction();
            CompraDao vDao = new CompraImp();
            this.numeroCompra = vDao.obtenerTotalRegistrosCompra(this.sessionCompra);

            if (this.numeroCompra <= 0 || this.numeroCompra == null) {
                this.numeroCompra = Long.valueOf("1");
            } else {
                this.compra = vDao.obtenerUltimoRegistroCompra(sessionCompra);
                this.numeroCompra = Long.valueOf(this.compra.getIdCompra() + 1);
                this.totalCompraFactura = new BigDecimal("0");
            }
            this.transactionCompra.commit();
        } catch (Exception e) {
            if (this.transactionCompra != null) {
                this.transactionCompra.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            if (this.sessionCompra != null) {
                this.sessionCompra.close();
            }
            
        }
    }
    
    public void agregarDatosPersona(Integer idPersona) {
        this.sessionCompra = null;
        this.transactionCompra = null;

        try {
            this.sessionCompra = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionCompra = this.sessionCompra.beginTransaction();
            this.persona = pDao.obtenerPersonaPorId(this.sessionCompra, idPersona);
            this.transactionCompra.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Proveedor Agregado"));
        } catch (Exception e) {
            if (this.transactionCompra != null) {
                System.out.println(e.getMessage());
                transactionCompra.rollback();
            }
        } finally {
            if (this.sessionCompra != null) {
                this.sessionCompra.close();
            }

        }

    }

    public void agregarDatosPersonaPorIdentificacion() {
        this.sessionCompra = null;
        this.transactionCompra = null;

        try {
            if (this.identificacionPersona == null) {
                return;
            }
            this.sessionCompra = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionCompra = this.sessionCompra.beginTransaction();
            this.persona = pDao.obtenerPersonaPorIdentificacion(this.sessionCompra, this.identificacionPersona);
            if (this.persona != null) {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Proveedor Agregado"));
            } else {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Proveedor Inexistente"));
            }
            this.transactionCompra.commit();
        } catch (Exception e) {
            if (this.transactionCompra != null) {
                System.out.println(e.getMessage());
                transactionCompra.rollback();
            }
        } finally {
            if (this.sessionCompra != null) {
                this.sessionCompra.close();
            }

        }

    }

    public void solicitarCantidadProducto(String codigoProducto) {
        this.productoSeleccionado = codigoProducto;
    }

    public void agregarDatosProductoPorCodigoProducto() {
       
        this.sessionCompra = null;
        this.transactionCompra = null;

        try {

            if (!(this.unidadesCompradas.matches("[0-9]*")) || this.unidadesCompradas.equals("0") || this.unidadesCompradas.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
                this.unidadesCompradas = "";

            } else {

                this.sessionCompra = HibernateUtil.getSessionFactory().openSession();
                ProductoDao pDao = new ProductoImp();
                this.transactionCompra = this.sessionCompra.beginTransaction();
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionCompra, this.productoSeleccionado);

                this.listaDetalleCompra.add(new DetalleCompra(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorCompraProducto(), this.producto.getValorVentaProducto(), Integer.parseInt(this.unidadesCompradas), (Float.parseFloat(this.unidadesCompradas) * this.producto.getValorCompraProducto())));

                this.transactionCompra.commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                this.unidadesCompradas = "";

                this.calcularValorTotalCompra();

            }

        } catch (Exception e) {
            if (this.transactionCompra != null) {
                System.out.println(e.getMessage());
                transactionCompra.rollback();
            }
        } finally {
            if (this.sessionCompra != null) {
                this.sessionCompra.close();
            }

        }

    }

    public void mostrarDatosCantidadProductoPorCodigo() {
        this.sessionCompra = null;
        this.transactionCompra = null;

        try {
            if (this.codigoProducto == null) {
                return;
            }
            this.sessionCompra = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            this.transactionCompra = this.sessionCompra.beginTransaction();
            this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionCompra, this.codigoProducto);
            if (this.producto != null) {

                RequestContext rc = RequestContext.getCurrentInstance();
                rc.execute("PF('dialogDatosCantidadProductoPorCodigoRead').show();");

                this.codigoProducto = null;

            } else {
                this.codigoProducto = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Producto Inexistente"));
            }
            this.transactionCompra.commit();
        } catch (Exception e) {
            if (this.transactionCompra != null) {
                System.out.println(e.getMessage());
                transactionCompra.rollback();
            }
        } finally {
            if (this.sessionCompra != null) {
                this.sessionCompra.close();
            }

        }

    }

    public void agregarDatosProductoPorCodigoProductoRead() {

        if (!(this.unidadesCompradasPorCodigo.matches("[0-9]*")) || this.unidadesCompradasPorCodigo.equals("0") || this.unidadesCompradasPorCodigo.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
            this.unidadesCompradasPorCodigo = "";

        } else {

            this.listaDetalleCompra.add(new DetalleCompra(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorCompraProducto(), this.producto.getValorVentaProducto(), Integer.parseInt(this.unidadesCompradasPorCodigo), (Float.parseFloat(this.unidadesCompradasPorCodigo) * this.producto.getValorCompraProducto())));

            this.unidadesCompradasPorCodigo = "";

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

            this.calcularValorTotalCompra();

        }

    }

    public void calcularValorTotalCompra() {

        this.totalCompraFactura = new BigDecimal("0");

        try {
            for (DetalleCompra detalleCompraTotal : listaDetalleCompra) {
                BigDecimal totalCompraPorProducto = (new BigDecimal(detalleCompraTotal.getValorCompraProducto()).multiply(new BigDecimal(detalleCompraTotal.getUnidadesCompradas())));
                detalleCompraTotal.setTotalDetalleCompra(totalCompraPorProducto.floatValue());
                totalCompraFactura = totalCompraFactura.add(totalCompraPorProducto);
            }
            this.compra.setTotalCompra(totalCompraFactura.floatValue());
            totalCompraFacturaCompra = (totalCompraFactura.floatValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarProducto(String codigoProducto, Integer posicionSeleccionada) {

        try {

            int i = 0;

            for (DetalleCompra detalleProducto : this.listaDetalleCompra) {
                if (detalleProducto.getCodigoProducto().equals(codigoProducto) && posicionSeleccionada.equals(i)) {
                    this.listaDetalleCompra.remove(i);
                    break;
                }
                i++;
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

            this.calcularValorTotalCompra();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

        }
    }

    public void onRowEdit(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Modificación Realizada"));
        this.calcularValorTotalCompra();
    }

    public void onRowCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Sin Modificacaciones"));

    }

    public void limpiarFacturaCompra() {
        this.persona = new Persona();
        this.compra = new Compra();
        this.listaDetalleCompra = new ArrayList<>();
        this.numeroCompra = null;
        this.totalCompraFacturaCompra = 0;

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
    
        public void ingresarCompraFULL() {

        this.sessionCompra = null;
        this.transactionCompra = null;

        String idEmpleadoC = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoC));
        this.tipoTransaccion.setIdTipoTransaccion(1); /// aún por definir idTipo de Transacción Contado ó Credito ///
        this.compra.setFechaCompra(new Date());

        try {
            this.sessionCompra = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            CompraDao cDao = new CompraImp();
            DetalleCompraDao dcDao = new DetalleCompraImp();

            this.transactionCompra = this.sessionCompra.beginTransaction();

            this.compra.setNumeroCompra(Long.toString(this.numeroCompra));
            this.compra.setIdEmpleado(this.empleado.getIdEmpleado());
            this.compra.setIdPersona(this.persona.getIdPersona());
            this.compra.setIdTipoTransaccion(this.tipoTransaccion.getIdTipoTransaccion());

            cDao.ingresarCompra(this.sessionCompra, this.compra);

            Object objCompra = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numCompra");
            
            long numRegistrarCompra = ((Number) objCompra).longValue();

            this.numeroCompra = numRegistrarCompra;

            this.compra = cDao.obtenerUltimoRegistroCompra(this.sessionCompra);

            for (DetalleCompra detalleCompraTotal : listaDetalleCompra) {
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionCompra, detalleCompraTotal.getCodigoProducto());
                detalleCompraTotal.setIdCompra(this.compra.getIdCompra());
                detalleCompraTotal.setIdProducto(this.producto.getIdProducto());

                dcDao.ingresarDetalleCompra(this.sessionCompra, detalleCompraTotal);
                
            }
            
            this.transactionCompra.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Compra Registrada"));

            this.limpiarFacturaCompra();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.transactionCompra != null) {
                this.transactionCompra.rollback();
            }
            
        } finally {
            if (this.sessionCompra != null) {
                this.sessionCompra.close();
            }
        }
    }

    public void reporteImpresionFacturaCompra() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String idEmpleadoC = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoC));
        System.out.println("+++++ Test Factura Compra +++++");
        int idP = this.persona.getIdentificacionPersona();
        int idE = this.empleado.getIdEmpleado();

        this.ingresarCompraFULL();

        Object objCompra = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numCompra");
        
        int numImprimirCompra = ((Number) objCompra).intValue();

        this.compra.setIdCompra(numImprimirCompra);

        int idC = this.compra.getIdCompra();

        reporteFacturaCompra rFactura = new reporteFacturaCompra();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteFacturaCompra.jasper");

        System.out.println("Comprador: " + idP);
        System.out.println("Vendedor: " + idE);
        System.out.println("Factura: " + idC);

        rFactura.getReporte(ruta, idP, idE, idC);
        FacesContext.getCurrentInstance().responseComplete();

    }

    public void reportesCompras() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("+++++ Test Reporte Compras +++++");

        String fechaInicial = this.getFechaInicialCompra();
        String fechaFinal = this.getFechaFinalCompra();

        reportesCompras rReporte = new reportesCompras();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteCompras.jasper");

        System.out.println("Fecha Inicial: " + fechaInicial);
        System.out.println("Fecha Final: " + fechaFinal);

        rReporte.getReporte(ruta, fechaInicial, fechaFinal);
        FacesContext.getCurrentInstance().responseComplete();

    }

}
