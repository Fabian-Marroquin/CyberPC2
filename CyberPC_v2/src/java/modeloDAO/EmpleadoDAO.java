package modeloDAO;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    /*--------------------------- VALIDAR (LOGIN) ---------------------------*/

    public Empleado validar(String emailEmpleado, String contrasenaLogin) {
        
        Empleado empleado = new Empleado();
        
        String sql = "SELECT * FROM Empleado WHERE emailEmpleado = ? and contrasenaLogin = ?";
        
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emailEmpleado);
            ps.setString(2, contrasenaLogin);
            rs = ps.executeQuery();

            while (rs.next()) {

                empleado.setDPIEmpleado(rs.getInt("DPIEmpleado"));
                empleado.setNombresEmpleado(rs.getString("nombresEmpleado"));
                empleado.setTelefonoEmpleado(rs.getString("telefonoEmpleado"));
                empleado.setEmailEmpleado(rs.getString("emailEmpleado"));
                empleado.setContrasenaEmpleado(rs.getString("contrasenaLogin"));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return empleado; //EMPLEADO ENCONTRADO

    }

    /*--------------------------- C R U D ---------------------------*/
    
    /*--------------------------- LISTAR ---------------------------*/
    
    public List listar() {

        String sql = "SELECT * FROM Empleado";
        List<Empleado> listaEmpleado = new ArrayList<Empleado>();

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Empleado emp = new Empleado();
                emp.setDPIEmpleado(rs.getInt(1));
                emp.setNombresEmpleado(rs.getString(2));
                emp.setTelefonoEmpleado(rs.getString(3));
                emp.setEmailEmpleado(rs.getString(4));
                emp.setContrasenaEmpleado(rs.getString(5));
                listaEmpleado.add(emp);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return listaEmpleado;

    }

    /*--------------------------- AGREGAR ---------------------------*/
    public int agregar(Empleado emp) {

        String sql = "INSERT INTO Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin) VALUES(?,?,?,?,?)";

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getDPIEmpleado());
            ps.setString(2, emp.getNombresEmpleado());
            ps.setString(3, emp.getTelefonoEmpleado());
            ps.setString(4, emp.getEmailEmpleado());
            ps.setString(5, emp.getContrasenaEmpleado());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return resp;

    }

}
