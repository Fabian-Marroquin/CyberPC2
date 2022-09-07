
package modelo;

public class TipoPago {
    private int codigoTipoPago;
    private String descripcionTipoPago;

    public TipoPago() {
    }

    public TipoPago(int codigoTipoPago, String descripcionTipoPago) {
        this.codigoTipoPago = codigoTipoPago;
        this.descripcionTipoPago = descripcionTipoPago;
    }

    public int getCodigoTipoPago() {
        return codigoTipoPago;
    }

    public void setCodigoTipoPago(int codigoTipoPago) {
        this.codigoTipoPago = codigoTipoPago;
    }

    public String getDescripcionTipoPago() {
        return descripcionTipoPago;
    }

    public void setDescripcionTipoPago(String descripcionTipoPago) {
        this.descripcionTipoPago = descripcionTipoPago;
    }
    
}
