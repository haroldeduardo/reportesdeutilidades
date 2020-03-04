
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
import GreenApps.auxiliares.reporteFacturaVenta;
import GreenApps.auxiliares.reportesVentas;
import GreenApps.dao.VentaDao;
import GreenApps.dao.PersonaDao;
import GreenApps.dao.ProductoDao;
import GreenApps.dao.DetalleVentaDao;
import GreenApps.imp.VentaImp;
import GreenApps.imp.DetalleVentaImp;
import GreenApps.imp.PersonaImp;
import GreenApps.imp.ProductoImp;
import GreenApps.model.Venta;
import GreenApps.model.DetalleVenta;
import GreenApps.model.Empleado;
import GreenApps.model.Persona;
import GreenApps.model.Producto;
import GreenApps.model.TipoTransaccion;
import GreenApps.util.HibernateUtil;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author csrsto <csrsto | GreenApps>
 */
@Named(value = "ventaBean")
@ViewScoped
@ManagedBean

public class VentaBean implements Serializable {

    Session sessionVenta = null;
    Session sessionProducto = null;
    Transaction transactionVenta = null;
    Transaction transactionProducto = null;

    @ManagedProperty("#{InterfaceUsuarioBean}")
    private InterfaceUsuarioBean uBean;

    private Persona persona;
    private Integer identificacionPersona;

    private Producto producto;
    private String codigoProducto;

    private List<Venta> listaVentas;
    private List<DetalleVenta> listaDetalleVenta;

    private String unidadesVendidas;
    private String productoSeleccionado;
    private Venta venta;

    private String unidadesVendidasPorCodigo;

    private Long numeroVenta;
    private BigDecimal totalVentaFactura;
    private float totalVentaFacturaVenta;

    private Empleado empleado;
    private TipoTransaccion tipoTransaccion;

    private boolean enabled;

    private String fechaSistema;

    private String fechaInicialVenta;

    private String fechaFinalVenta;

    public VentaBean() {
        
        this.venta = new Venta();
        this.listaDetalleVenta = new ArrayList<>();
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

    public List<DetalleVenta> getListaDetalleVenta() {
        return listaDetalleVenta;
    }

    public void setListaDetalleVenta(List<DetalleVenta> listaDetalleVenta) {
        this.listaDetalleVenta = listaDetalleVenta;
    }

    public List<Venta> getListaVentas() {
        VentaDao serDao = new VentaImp();
        listaVentas = serDao.mostrarVentas();
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getUnidadesVendidasPorCodigo() {
        return unidadesVendidasPorCodigo;
    }

    public void setUnidadesVendidasPorCodigo(String unidadesVendidasPorCodigo) {
        this.unidadesVendidasPorCodigo = unidadesVendidasPorCodigo;
    }

    public Long getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(Long numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public BigDecimal getTotalVentaFactura() {
        return totalVentaFactura;
    }

    public void setTotalVentaFactura(BigDecimal totalVentaFactura) {
        this.totalVentaFactura = totalVentaFactura;
    }

    public float getTotalVentaFacturaVenta() {
        return totalVentaFacturaVenta;
    }

    public void setTotalVentaFacturaVenta(float totalVentaFacturaVenta) {
        this.totalVentaFacturaVenta = totalVentaFacturaVenta;
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

    public String getFechaInicialVenta() {
        return fechaInicialVenta;
    }

    public void setFechaInicialVenta(String fechaInicialVenta) {
        this.fechaInicialVenta = fechaInicialVenta;
    }

    public String getFechaFinalVenta() {
        return fechaFinalVenta;
    }

    public void setFechaFinalVenta(String fechaFinalVenta) {
        this.fechaFinalVenta = fechaFinalVenta;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void enableBoton() {
        enabled = true;
    }
    
    public void enableModificarVenta() throws Exception {

        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();

        int idVenta = Integer.parseInt(params.get("idVentai"));
        int estVenta = Integer.parseInt(params.get("estVentai"));

        //Estado Activo
        if (estVenta == 1) {

            DetalleVentaDao dvd = new DetalleVentaImp();
            this.listaDetalleVenta = dvd.mostrarDetalleVentasIdVenta(idVenta);

            VentaDao vd = new VentaImp();
            this.venta = vd.obtenerVentaPorIdVenta(idVenta);
            
            this.calcularValorTotalVenta();

            enabled = true;

        } 
        
        //Estado Inactivo
        else {
            
            DetalleVentaDao dvd = new DetalleVentaImp();
            this.listaDetalleVenta = dvd.mostrarDetalleVentasIdVenta(idVenta);

            VentaDao vd = new VentaImp();
            this.venta = vd.obtenerVentaPorIdVenta(idVenta);
                
            this.calcularValorTotalVenta();

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

    public void numeracionVenta() {
        this.sessionVenta = null;
        this.transactionVenta = null;

        try {
            this.sessionVenta = HibernateUtil.getSessionFactory().openSession();
            this.transactionVenta = this.sessionVenta.beginTransaction();
            VentaDao vDao = new VentaImp();
            this.numeroVenta = vDao.obtenerTotalRegistrosVenta(this.sessionVenta);

            if (this.numeroVenta <= 0 || this.numeroVenta == null) {
                this.numeroVenta = Long.valueOf("1");
            } else {
                this.venta = vDao.obtenerUltimoRegistroVenta(sessionVenta);
                this.numeroVenta = Long.valueOf(this.venta.getIdVenta() + 1);
                this.totalVentaFactura = new BigDecimal("0");
            }
            this.transactionVenta.commit();
        } catch (Exception e) {
            if (this.transactionVenta != null) {
                this.transactionVenta.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            if (this.sessionVenta != null) {
                this.sessionVenta.close();
            }
            
        }
    }

    public void agregarDatosPersona(Integer idPersona) {
        this.sessionVenta = null;
        this.transactionVenta = null;

        try {
            this.sessionVenta = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionVenta = this.sessionVenta.beginTransaction();
            this.persona = pDao.obtenerPersonaPorId(this.sessionVenta, idPersona);
            this.transactionVenta.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Comprador Agregado"));
        } catch (Exception e) {
            if (this.transactionVenta != null) {
                System.out.println(e.getMessage());
                transactionVenta.rollback();
            }
        } finally {
            if (this.sessionVenta != null) {
                this.sessionVenta.close();
            }

        }

    }

    public void agregarDatosPersonaPorIdentificacion() {
        this.sessionVenta = null;
        this.transactionVenta = null;

        try {
            if (this.identificacionPersona == null) {
                return;
            }
            this.sessionVenta = HibernateUtil.getSessionFactory().openSession();
            PersonaDao pDao = new PersonaImp();
            this.transactionVenta = this.sessionVenta.beginTransaction();
            this.persona = pDao.obtenerPersonaPorIdentificacion(this.sessionVenta, this.identificacionPersona);
            if (this.persona != null) {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Comprador Agregado"));
            } else {
                this.identificacionPersona = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Comprador Inexistente"));
            }
            this.transactionVenta.commit();
        } catch (Exception e) {
            if (this.transactionVenta != null) {
                System.out.println(e.getMessage());
                transactionVenta.rollback();
            }
        } finally {
            if (this.sessionVenta != null) {
                this.sessionVenta.close();
            }

        }

    }

    public void solicitarCantidadProducto(String codigoProducto) {
        this.productoSeleccionado = codigoProducto;
    }

    public void agregarDatosProductoPorCodigoProducto() {

        this.sessionVenta = null;
        this.transactionVenta = null;

        this.sessionVenta = HibernateUtil.getSessionFactory().openSession();
        ProductoDao pDao = new ProductoImp();

        try {

            if (!(this.unidadesVendidas.matches("[0-9]*")) || this.unidadesVendidas.equals("0") || this.unidadesVendidas.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
                this.unidadesVendidas = "";

            } else {

                this.transactionVenta = this.sessionVenta.beginTransaction();

                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionVenta, this.productoSeleccionado);

                boolean isValidate = false;

                try {

                    isValidate = pDao.validarStockProducto(this.sessionVenta, this.producto.getCodigoProducto(), Integer.parseInt(this.unidadesVendidas));

                } catch (Exception ex) {

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Warning"));

                }

                if (isValidate) {

                    this.listaDetalleVenta.add(new DetalleVenta(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), this.producto.getIva(), Integer.parseInt(this.unidadesVendidas), (Float.parseFloat(this.unidadesVendidas) * this.producto.getValorVentaProducto())));

                    this.unidadesVendidas = "";

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                    this.calcularValorTotalVenta();

                } else {

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Stock Insuficiente"));

                    this.unidadesVendidas = "";

                }

            }

        } catch (Exception e) {
            if (this.transactionVenta != null) {
                System.out.println(e.getMessage());
                transactionVenta.rollback();
            }
        } finally {
            if (this.sessionVenta != null) {
                this.sessionVenta.close();
            }

        }

    }

    public void mostrarDatosCantidadProductoPorCodigo() {
        this.sessionVenta = null;
        this.transactionVenta = null;

        try {
            if (this.codigoProducto == null) {
                return;
            }
            this.sessionVenta = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            this.transactionVenta = this.sessionVenta.beginTransaction();
            this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionVenta, this.codigoProducto);
            if (this.producto != null) {

                RequestContext rc = RequestContext.getCurrentInstance();
                rc.execute("PF('dialogDatosCantidadProductoPorCodigoRead').show();");

                this.codigoProducto = null;

            } else {
                this.codigoProducto = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Producto Inexistente"));
            }
            this.transactionVenta.commit();
        } catch (Exception e) {
            if (this.transactionVenta != null) {
                System.out.println(e.getMessage());
                transactionVenta.rollback();
            }
        } finally {
            if (this.sessionVenta != null) {
                this.sessionVenta.close();
            }

        }

    }

    public void agregarDatosProductoPorCodigoProductoRead() {

        this.sessionVenta = null;
        this.transactionVenta = null;

        this.sessionVenta = HibernateUtil.getSessionFactory().openSession();
        ProductoDao pDao = new ProductoImp();

        if (!(this.unidadesVendidasPorCodigo.matches("[0-9]*")) || this.unidadesVendidasPorCodigo.equals("0") || this.unidadesVendidasPorCodigo.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Valor Incorrecto"));
            this.unidadesVendidasPorCodigo = "";

        } else {

            boolean isValidate = false;

            try {

                isValidate = pDao.validarStockProducto(this.sessionVenta, this.producto.getCodigoProducto(), Integer.parseInt(this.unidadesVendidasPorCodigo));

            } catch (Exception ex) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Warning"));

            }

            if (isValidate) {

                this.listaDetalleVenta.add(new DetalleVenta(0, 0, this.producto.getCodigoProducto(), this.producto.getNombreProducto(), this.producto.getValorVentaProducto(), this.producto.getIva(), Integer.parseInt(this.unidadesVendidasPorCodigo), (Float.parseFloat(this.unidadesVendidasPorCodigo) * this.producto.getValorVentaProducto())));

                this.unidadesVendidasPorCodigo = "";

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Producto Agregado"));

                this.calcularValorTotalVenta();

            } else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Stock Insuficiente"));

                this.unidadesVendidasPorCodigo = "";

            }
        }

    }

    public void calcularValorTotalVenta() {

        this.totalVentaFactura = new BigDecimal("0");

        try {
            for (DetalleVenta detalleVentaTotal : listaDetalleVenta) {
                BigDecimal totalVentaPorProducto = (new BigDecimal(detalleVentaTotal.getValorVentaProducto()).multiply(new BigDecimal(detalleVentaTotal.getUnidadesVendidas())));
                detalleVentaTotal.setTotalDetalleVenta(totalVentaPorProducto.floatValue());
                totalVentaFactura = totalVentaFactura.add(totalVentaPorProducto);
            }
            this.venta.setTotalVenta(totalVentaFactura.floatValue());
            totalVentaFacturaVenta = (totalVentaFactura.floatValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarProducto(String codigoProducto, Integer posicionSeleccionada) {

        try {

            int i = 0;

            for (DetalleVenta detalleProducto : this.listaDetalleVenta) {
                if (detalleProducto.getCodigoProducto().equals(codigoProducto) && posicionSeleccionada.equals(i)) {
                    this.listaDetalleVenta.remove(i);
                    break;
                }
                i++;
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

            this.calcularValorTotalVenta();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Producto Eliminado"));

        }
    }

    public void onRowEdit(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Modificación Realizada"));
        this.calcularValorTotalVenta();
    }

    public void onRowCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Sin Modificacaciones"));

    }

    public void limpiarFacturaVenta() {
        this.persona = new Persona();
        this.venta = new Venta();
        this.listaDetalleVenta = new ArrayList<>();
        this.numeroVenta = null;
        this.totalVentaFacturaVenta = 0;

        this.disableBoton();
    }

    public void enableEstadoVenta() {

        this.sessionVenta = null;
        this.transactionVenta = null;

        String EstadoVentaInactivo = "1";

        this.venta.setEstadoVenta(Byte.valueOf(EstadoVentaInactivo));

    }

    public void disableEstadoVenta() {

        this.sessionVenta = null;
        this.transactionVenta = null;

        String EstadoVentaInactivo = "0";

        this.venta.setEstadoVenta(Byte.valueOf(EstadoVentaInactivo));

    }
    
    public void imprimirVentaModificada() {

        VentaDao venDao = new VentaImp();
        this.disableEstadoVenta();
        venDao.imprimirVenta(venta);
        venta = new Venta();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Venta Finalizada"));

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
    
    public void ingresarVentaFULL() {

        this.sessionVenta = null;
        this.transactionVenta = null;

        String idEmpleadoV = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoV));
        this.tipoTransaccion.setIdTipoTransaccion(1); /// aún por definir idTipo de Transacción Contado ó Credito ///
        this.venta.setFechaVenta(new Date());

        try {
            this.sessionVenta = HibernateUtil.getSessionFactory().openSession();
            ProductoDao pDao = new ProductoImp();
            VentaDao vDao = new VentaImp();
            DetalleVentaDao dvDao = new DetalleVentaImp();

            this.transactionVenta = this.sessionVenta.beginTransaction();

            this.venta.setNumeroVenta(Long.toString(this.numeroVenta));
            this.venta.setIdEmpleado(this.empleado.getIdEmpleado());
            this.venta.setIdPersona(this.persona.getIdPersona());
            this.venta.setIdTipoTransaccion(this.tipoTransaccion.getIdTipoTransaccion());

            vDao.ingresarVenta(this.sessionVenta, this.venta);

            Object objVenta = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numVenta");
            
            long numRegistrarVenta = ((Number) objVenta).longValue();

            this.numeroVenta = numRegistrarVenta;

            this.venta = vDao.obtenerUltimoRegistroVenta(this.sessionVenta);

            for (DetalleVenta detalleVentaTotal : listaDetalleVenta) {
                this.producto = pDao.obtenerProductoPorCodigoProducto(this.sessionVenta, detalleVentaTotal.getCodigoProducto());
                detalleVentaTotal.setIdVenta(this.venta.getIdVenta());
                detalleVentaTotal.setIdProducto(this.producto.getIdProducto());

                dvDao.ingresarDetalleVenta(this.sessionVenta, detalleVentaTotal);
                
            }
            
            this.transactionVenta.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Venta Registrada"));

            this.limpiarFacturaVenta();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.transactionVenta != null) {
                this.transactionVenta.rollback();
            }
            
        } finally {
            if (this.sessionVenta != null) {
                this.sessionVenta.close();
            }
        }
    }

    public void reporteImpresionFacturaVenta() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String idEmpleadoV = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoV));
        System.out.println("+++++ Test Factura Venta +++++");
        int idP = this.persona.getIdentificacionPersona();
        int idE = this.empleado.getIdEmpleado();

        this.ingresarVentaFULL();

        Object objVenta = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numVenta");
        
        int numImprimirVenta = ((Number) objVenta).intValue();

        this.venta.setIdVenta(numImprimirVenta);

        int idV = this.venta.getIdVenta();

        reporteFacturaVenta rFactura = new reporteFacturaVenta();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteFacturaVenta.jasper");

        System.out.println("Comprador: " + idP);
        System.out.println("Vendedor: " + idE);
        System.out.println("Factura: " + idV);

        rFactura.getReporte(ruta, idP, idE, idV);
        FacesContext.getCurrentInstance().responseComplete();

    }
    
    public void reporteImpresionFacturaVentaImpresa(Integer idVenta) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("+++++ Test Factura Venta +++++");
        
        String idEmpleadoV = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id").toString();

        this.empleado.setIdEmpleado(Integer.parseInt(idEmpleadoV));
        
        System.out.println("+++++ Test Factura Venta +++++"+ " idEmpleadoV: "+idEmpleadoV);
        
        int idP = this.persona.getIdentificacionPersona();
        
        int idE = this.empleado.getIdEmpleado();

        System.out.println("+++++ Test Factura Venta +++++"+" Persona: "+idP+" Empleado: "+idE);
        
        this.imprimirVentaModificada();
        
        this.venta.setIdVenta(idVenta);
        
        int idV = this.venta.getIdVenta();

        System.out.println("+++++ Test Factura Venta +++++"+" Venta: "+idV);
        
        reporteFacturaVenta rFactura = new reporteFacturaVenta();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteFacturaVenta.jasper");

        System.out.println("Comprador: " + idP);
        System.out.println("Vendedor: " + idE);
        System.out.println("Factura: " + idV);

        rFactura.getReporte(ruta, idP, idE, idV);
        FacesContext.getCurrentInstance().responseComplete();

    }
    
    public void reportesVentas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("+++++ Test Reporte Ventas +++++");

        String fechaInicial = this.getFechaInicialVenta();
        String fechaFinal = this.getFechaFinalVenta();

        reportesVentas rReporte = new reportesVentas();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/reporteVentas.jasper");

        System.out.println("Fecha Inicial: " + fechaInicial);
        System.out.println("Fecha Final: " + fechaFinal);

        rReporte.getReporte(ruta, fechaInicial, fechaFinal);
        FacesContext.getCurrentInstance().responseComplete();

    }

}