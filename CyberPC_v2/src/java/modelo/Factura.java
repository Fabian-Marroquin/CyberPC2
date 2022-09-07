
package modelo;

import java.util.Date;

public class Factura {
    private int codigoFactura;
    private Date fechaFactura;
    private int NIT;
    private int DPIEmpleado;

    public Factura() {
    }

    public Factura(int codigoFactura, Date fechaFactura, int NIT, int DPIEmpleado) {
        this.codigoFactura = codigoFactura;
        this.fechaFactura = fechaFactura;
        this.NIT = NIT;
        this.DPIEmpleado = DPIEmpleado;
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
    
}
