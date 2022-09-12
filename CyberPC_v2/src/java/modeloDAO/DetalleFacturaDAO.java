package modeloDAO;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.DetalleFactura;

/**
 *
 * @author dennis perez
 */
public class DetalleFacturaDAO {
    Conexion cn = new Conexion();
    Connection con;
    
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List Listar(){
        String sql = "select * from detalleFactura";
        List<DetalleFactura> listaDetalleFactura = new ArrayList<DetalleFactura>();
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                DetalleFactura df = new DetalleFactura();
                
                df.setCodigoDetalleFactura(rs.getInt(1));
                df.setCantidad(rs.getInt(2));
                df.setSubtotal(rs.getDouble(3));
                df.setCodigoFactura(rs.getInt(4));
                df.setCodigoProducto(rs.getInt(5));
                listaDetalleFactura.add(df);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaDetalleFactura;
    }
    
    //Listar por codigoFactura
    public List detallePorFactura(int codigoFactura){
        List<DetalleFactura> listaDetalleFactura = new ArrayList<DetalleFactura>();
        String sql = "SELECT * FROM DetalleFactura WHERE codigoFactura ="+codigoFactura;
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetalleFactura df = new DetalleFactura();

                df.setCodigoDetalleFactura(rs.getInt(1));
                df.setCantidad(rs.getInt(2));
                df.setSubtotal(rs.getDouble(3));
                df.setCodigoFactura(rs.getInt(4));
                df.setCodigoProducto(rs.getInt(5));
                listaDetalleFactura.add(df);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaDetalleFactura;
    }
    
    //Agregar Sub-total con precioUnitario extraidos de Producto
    public int AgregarConSubtotal(DetalleFactura df, double precioUnitario){
        String sql = "INSERT INTO DetalleFactura (cantidad, subtotal, codigoFactura, codigoProducto) VALUES (?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, df.getCantidad());
            ps.setDouble(2,df.getCantidad()*precioUnitario);
            ps.setInt(3, df.getCodigoFactura());
            ps.setInt(4, df.getCodigoProducto());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return resp;
    }
    
    //metodo para saber le total de la factura
    public double totalFactura(int codigoFactura){
        double total=0;
        String sql = "SELECT sum(subtotal) FROM DetalleFactura WHERE codigoFactura="+codigoFactura;
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                total = rs.getDouble(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return total;
    }
    
    public int Agregar(DetalleFactura df){
        String sql = "insert into DetalleFactura (cantidad, codigoFactura, codigoProducto) values (?,?,?)";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, df.getCantidad());
            ps.setInt(2, df.getCodigoFactura());
            ps.setInt(3, df.getCodigoProducto());
            ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo agregar el registro por"+e);
        }   
        return resp;
    }
    
    //Buscar detealleFactura
    public DetalleFactura buscarDetalle(int id){
        String sql = "SELECT * FROM DetalleFactura WHERE codigoDetalleFactura="+id;
        DetalleFactura df = new DetalleFactura();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                df.setCodigoDetalleFactura(rs.getInt(1));
                df.setCantidad(rs.getInt(2));
                df.setSubtotal(rs.getDouble(3));
                df.setCodigoFactura(rs.getInt(4));
                df.setCodigoProducto(rs.getInt(5));
                
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return df;
    }
    
    public int actualizar(DetalleFactura df, double precioUnitario){
        String sql = "Update DetalleFactura set cantidad = ?, subtotal = ? where codigoDetalleFactura = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, df.getCantidad());
            ps.setDouble(2, df.getCantidad()*precioUnitario);
            ps.setInt(3, df.getCodigoDetalleFactura());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int cod){
        String sql = "DELETE FROM DetalleFactura WHERE codigoDetalleFactura="+cod;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}