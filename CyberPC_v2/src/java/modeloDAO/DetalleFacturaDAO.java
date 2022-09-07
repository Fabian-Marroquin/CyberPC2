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
                df.setCodigoFactura(rs.getInt(3));
                df.setCodigoProducto(rs.getInt(4));
                listaDetalleFactura.add(df);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaDetalleFactura;
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
    
}