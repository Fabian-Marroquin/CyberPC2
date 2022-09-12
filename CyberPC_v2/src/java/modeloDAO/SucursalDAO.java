package modeloDAO;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Sucursal;


public class SucursalDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    //Metodo Listar
    public List Listar(){
        String sql = "select * from Sucursal";
        List<Sucursal> listaSucursal = new ArrayList<Sucursal>();
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Sucursal suc = new Sucursal();
                suc.setCodigoSucursal(rs.getInt(1));
                suc.setNombreSucursal(rs.getString(2));
                suc.setDireccionSucursal(rs.getString(3));
                listaSucursal.add(suc);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaSucursal;
    }
    
    //Metodo agregar
    public int Agregar(Sucursal suc){
        String sql = "insert into Sucursal(nombreSucursal, direccionSucursal) values(?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, suc.getNombreSucursal());
            ps.setString(2, suc.getDireccionSucursal());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se pudo agregar el registro");
        }
        return resp;
    }
}
