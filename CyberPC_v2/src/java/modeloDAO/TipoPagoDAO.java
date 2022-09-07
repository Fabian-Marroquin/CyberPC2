
package modeloDAO;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoPago;

public class TipoPagoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "select * from TipoPago";
        
        List<TipoPago> listaTipoPago = new ArrayList<TipoPago>();
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                TipoPago ti = new TipoPago();
                
                ti.setCodigoTipoPago(rs.getInt(1));
                ti.setDescripcionTipoPago(rs.getString(2));
                
                listaTipoPago.add(ti);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaTipoPago;
    }
    
    public int agregar(TipoPago ti){
        String sql = "Insert into TipoPago(descripcionTipoPago) values(?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ti.getDescripcionTipoPago());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo agregar el registro");
        }
        return resp;
    }
}
