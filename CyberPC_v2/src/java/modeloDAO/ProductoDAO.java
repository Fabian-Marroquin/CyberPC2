
package modeloDAO;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    //Operaciones del CRUD

    public List listar(){
        String sql = "select * from Producto";
        List<Producto> listaProducto = new ArrayList<>();
        
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    Producto pd = new Producto();
                    pd.setCodigoProducto(rs.getInt(1));
                    pd.setNombreProducto(rs.getString(2));
                    pd.setStock(rs.getInt(3));
                    pd.setPrecioUnitario(rs.getDouble(4));
                    pd.setCodigoTipoProducto(rs.getInt(5));
                    pd.setCodigoMarca(rs.getInt(6));
                    listaProducto.add(pd);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        
        
        return listaProducto;
    }
    //metodo Agregar
    
    public int Agregar(Producto prd){
    
        String sql = "insert into Producto(nombreProducto, stock, precioUnitario, codigoTipoProducto, codigoMarca) values(?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prd.getNombreProducto());
            ps.setInt(2, prd.getStock());
            ps.setDouble(3, prd.getPrecioUnitario());
            ps.setInt(4, prd.getCodigoTipoProducto());
            ps.setInt(5, prd.getCodigoMarca());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se puedo establecer la conexion"+e);
        }
                
                return resp;
    }
    
    public Producto listarCodigoProducto(int id) {
        Producto pro = new Producto();
        String sql = "Select * from Producto where codigoProducto =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setNombreProducto(rs.getString(2));
                pro.setStock(rs.getInt(3));
                pro.setPrecioUnitario(rs.getInt(4));
                pro.setCodigoTipoProducto(rs.getInt(5));
                pro.setCodigoMarca(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pro;
    }

    //metodo para editar
    public int actualizar(Producto prd) {
        String sql = "Update Producto set nombreProducto = ?, stock = ?, precioUnitario = ? where codigoProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prd.getNombreProducto());
            ps.setInt(2, prd.getStock());
            ps.setDouble(3, prd.getPrecioUnitario());
            ps.setInt(4, prd.getCodigoProducto());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }

    // metodo para eliminar
    public void eliminar(int id) {
        String sql = "delete from Producto where codigoProducto = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
