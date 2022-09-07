
package modelo;

public class Sucursal {
    private int codigoSucursal;
    private String nombreSucursal;
    private String direccionSucursal;

    public Sucursal() {
    }

    public Sucursal(int codigoSucursal, String nombreSucursal, String direccionSucursal) {
        this.codigoSucursal = codigoSucursal;
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }
    
}
