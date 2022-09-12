
package modelo;

public class Empleado {
    private int DPIEmpleado;
    private String nombresEmpleado;
    private String telefonoEmpleado;
    private String emailEmpleado;
    private String contrasenaEmpleado;
    private String fotoPerfil;

    public Empleado() {
    }

    public Empleado(int DPIEmpleado, String nombresEmpleado, String telefonoEmpleado, String emailEmpleado, String contrasenaEmpleado, String fotoPerfil) {
        this.DPIEmpleado = DPIEmpleado;
        this.nombresEmpleado = nombresEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.emailEmpleado = emailEmpleado;
        this.contrasenaEmpleado = contrasenaEmpleado;
        this.fotoPerfil = fotoPerfil;
    }

    public int getDPIEmpleado() {
        return DPIEmpleado;
    }

    public void setDPIEmpleado(int DPIEmpleado) {
        this.DPIEmpleado = DPIEmpleado;
    }

    public String getNombresEmpleado() {
        return nombresEmpleado;
    }

    public void setNombresEmpleado(String nombresEmpleado) {
        this.nombresEmpleado = nombresEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getEmailEmpleado() {
        return emailEmpleado;
    }

    public void setEmailEmpleado(String emailEmpleado) {
        this.emailEmpleado = emailEmpleado;
    }

    public String getContrasenaEmpleado() {
        return contrasenaEmpleado;
    }

    public void setContrasenaEmpleado(String contrasenaEmpleado) {
        this.contrasenaEmpleado = contrasenaEmpleado;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
    
}
