
package modelo;

import java.util.Date;

public class Factura {
    private int codigoFactura;
    private Date fechaFactura;
    private int NIT;
    private int DPIEmpleado;
    private int codigoTipoPago;
    private int codigoSucursal;

    public Factura() {
    }

    public Factura(int codigoFactura, Date fechaFactura, int NIT, int DPIEmpleado, int codigoTipoPago, int codigoSucursal) {
        this.codigoFactura = codigoFactura;
        this.fechaFactura = fechaFactura;
        this.NIT = NIT;
        this.DPIEmpleado = DPIEmpleado;
        this.codigoTipoPago = codigoTipoPago;
        this.codigoSucursal = codigoSucursal;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public int getDPIEmpleado() {
        return DPIEmpleado;
    }

    public void setDPIEmpleado(int DPIEmpleado) {
        this.DPIEmpleado = DPIEmpleado;
    }

    public int getCodigoTipoPago() {
        return codigoTipoPago;
    }

    public void setCodigoTipoPago(int codigoTipoPago) {
        this.codigoTipoPago = codigoTipoPago;
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }
    
    
}
