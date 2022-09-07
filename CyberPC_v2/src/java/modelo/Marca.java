
package modelo;

public class Marca {
    private int codigoMarca;
    private String descripcionMarca;

    public Marca() {
    }

    public Marca(int codigoMarca, String descripcionMarca) {
        this.codigoMarca = codigoMarca;
        this.descripcionMarca = descripcionMarca;
    }

    public int getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(int codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getDescripcionMarca() {
        return descripcionMarca;
    }

    public void setDescripcionMarca(String descripcionMarca) {
        this.descripcionMarca = descripcionMarca;
    }
    
}
