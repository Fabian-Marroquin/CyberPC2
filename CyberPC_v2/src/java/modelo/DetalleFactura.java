
package modelo;

public class DetalleFactura {
    private int codigoDetalleFactura;
    private int cantidad;
    private int codigoFactura;
    private int codigoProducto;

    public DetalleFactura() {
    }

    public DetalleFactura(int codigoDetalleFactura, int cantidad, int codigoFactura, int codigoProducto) {
        this.codigoDetalleFactura = codigoDetalleFactura;
        this.cantidad = cantidad;
        this.codigoFactura = codigoFactura;
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoDetalleFactura() {
        return codigoDetalleFactura;
    }

    public void setCodigoDetalleFactura(int codigoDetalleFactura) {
        this.codigoDetalleFactura = codigoDetalleFactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
}
