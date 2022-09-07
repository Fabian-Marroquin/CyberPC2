
package modelo;

public class TipoProducto {
    private int codigoTipoProducto;
    private String descripcionTipoProducto;

    public TipoProducto() {
    }

    public TipoProducto(int codigoTipoProducto, String descripcionTipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
        this.descripcionTipoProducto = descripcionTipoProducto;
    }

    public int getCodigoTipoProducto() {
        return codigoTipoProducto;
    }

    public void setCodigoTipoProducto(int codigoTipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
    }

    public String getDescripcionTipoProducto() {
        return descripcionTipoProducto;
    }

    public void setDescripcionTipoProducto(String descripcionTipoProducto) {
        this.descripcionTipoProducto = descripcionTipoProducto;
    }
    
}
