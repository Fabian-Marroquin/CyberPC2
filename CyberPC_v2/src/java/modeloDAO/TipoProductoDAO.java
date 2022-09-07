
package modeloDAO;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoProducto;

public class TipoProductoDAO {
    Conexion cn = new Conexion(); 
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    //operaciones del crud
    //metodo de listar
    
        public List listar(){
        String sql = "select * from tipoProducto";
        List<TipoProducto> listaTipoProducto = new ArrayList<TipoProducto>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                TipoProducto tp = new TipoProducto();
                tp.setCodigoTipoProducto(rs.getInt(1));
                tp.setDescripcionTipoProducto(rs.getString(2));
                listaTipoProducto.add(tp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaTipoProducto;
    }
        
        //metodo para agregar       
        public int agregar(TipoProducto tp){
            String sql = "Insert into tipoproducto(tipoProducto) values (?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tp.getDescripcionTipoProducto());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se puedo agregar el registro");
        }
        return resp;
    }
        
        public TipoProducto listarCodigoTipoProducto (int id){
            TipoProducto tps = new TipoProducto();
            String sql = "Select * from tipoproducto where codigoTipoProducto ="+id;     
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tps.setDescripcionTipoProducto(rs.getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tps;
    }
}
