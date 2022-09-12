package modeloDAO;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    //OPERACIONES DEL CRUD
    
    //MÉTODO DE LISTAR
    
    public List listar(){
        String sql = "select * from cliente";
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setNIT(rs.getInt(1));
                cl.setNombresCliente(rs.getString(2));
                cl.setApellidosCliente(rs.getString(3));
                cl.setDireccionCliente(rs.getString(4));
                cl.setTelefonoCliente(rs.getString(5));
                cl.setEmailCliente(rs.getString(6));
                listaCliente.add(cl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaCliente;
    }
    
    //MÉTODO PARA AGREGAR
    
    public int agregar(Cliente cl){
        String sql = "Insert into cliente (NIT, nombresCliente, apellidosCliente, direccionCliente, telefonoCliente, emailCliente) value(?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getNIT());
            ps.setString(2, cl.getNombresCliente());
            ps.setString(3, cl.getApellidosCliente());
            ps.setString(4, cl.getDireccionCliente());
            ps.setString(5, cl.getTelefonoCliente());
            ps.setString(6, cl.getEmailCliente());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            
        System.out.println("No se puedo agregar el registro");
        }
        return resp;
    }
    
    //METODO BUSCAR POR NIT
    public Cliente listarNIT(int NIT) {
        Cliente cl = new Cliente();
        String sql = "Select * from cliente where NIT =" + NIT;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cl.setNIT(1);
                cl.setNombresCliente(rs.getString(2));
                cl.setApellidosCliente(rs.getString(3));
                cl.setDireccionCliente(rs.getString(4));
                cl.setTelefonoCliente(rs.getString(5));
                cl.setEmailCliente(rs.getString(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cl;
    }

    //METODO PARA EDITAR
    public int actualizar(Cliente cl) {
        String sql = "Update cliente set nombresCliente = ?, apellidosCliente = ?, direccionCliente = ?, telefonoCliente = ?, emailCliente = ? where NIT = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombresCliente());
            ps.setString(2, cl.getApellidosCliente());
            ps.setString(3, cl.getDireccionCliente());
            ps.setString(4, cl.getTelefonoCliente());
            ps.setString(5, cl.getEmailCliente());
            ps.setInt(6, cl.getNIT());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    //METODO PARA ELIMINAR
    public void eliminar(int NIT) {
        String sql = "delete from cliente where NIT = " + NIT;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
