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
                empleado.setFotoPerfil(rs.getString("fotoPerfil"));

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
                emp.setFotoPerfil(rs.getString(6));
                listaEmpleado.add(emp);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return listaEmpleado;

    }
    
    /*-------------------Listar (Convertir Imagen)-------------------*/
    
//    public void listarImagen(int DPIEmpleado, HttpServletResponse response){
//        String sql = "SELECT * FROM Empleado WHERE DPIEmpleado ="+DPIEmpleado;
//        InputStream inputS = null;
//        OutputStream outputS = null;
//        BufferedInputStream bufferInputS = null;
//        BufferedOutputStream bufferOutputS = null;
//        response.setContentType("image/*");
//        try {
//            outputS = response.getOutputStream();
//            con = cn.Conexion();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                inputS = rs.getBinaryStream("fotoPerfil");
//            }
//            bufferInputS = new BufferedInputStream(inputS);
//            bufferOutputS = new BufferedOutputStream(outputS);
//            int i = 0;
//            try {
//                while ((i = bufferInputS.read()) != -1) {
//                    bufferOutputS.write(i);
//                } 
//            }catch (Exception e) {
//                
//            }
//            
//        }catch (Exception e) {
//            
//        }
//    }

    /*--------------------------- AGREGAR ---------------------------*/
    public int agregar(Empleado emp) {

        String sql = "INSERT INTO Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, emailEmpleado, contrasenaLogin, fotoPerfil) VALUES(?,?,?,?,?,?)";

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getDPIEmpleado());
            ps.setString(2, emp.getNombresEmpleado());
            ps.setString(3, emp.getTelefonoEmpleado());
            ps.setString(4, emp.getEmailEmpleado());
            ps.setString(5, emp.getContrasenaEmpleado());
            ps.setString(6, emp.getFotoPerfil());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return resp;

    }
    
    public Empleado listarCodigoEmpleado(int id) {

        Empleado emp = new Empleado();
        String sql = "SELECT * FROM Empleado WHERE DPIEmpleado = " + id;

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                emp.setDPIEmpleado(rs.getInt(1));
                emp.setNombresEmpleado(rs.getString(2));
                emp.setTelefonoEmpleado(rs.getString(3));
                emp.setEmailEmpleado(rs.getString(4));
                emp.setContrasenaEmpleado(rs.getString(5));

            }

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("No se pudo buscar el empleado");

        }

        return emp;

    }

    /*--------------------------- ACTUALIZAR ---------------------------*/
    public int actualizar(Empleado emp) {

        String sql = "UPDATE Empleado set nombresEmpleado = ?, telefonoEmpleado = ?, emailEmpleado = ?, contrasenaLogin = ? where DPIEmpleado = ?";

        System.out.println("-----------------------------------");
        System.out.println(emp.getNombresEmpleado());
        System.out.println("-----------------------------------");
        
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, emp.getNombresEmpleado());
            ps.setString(2, emp.getTelefonoEmpleado());
            ps.setString(3, emp.getEmailEmpleado());
            ps.setString(4, emp.getContrasenaEmpleado());
            ps.setInt(5, emp.getDPIEmpleado());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return resp;

    }

    /*--------------------------- ELIMINAR ---------------------------*/
    public void eliminar(int id) {

        String sql = "DELETE FROM Empleado where DPIEmpleado = " + id;

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
