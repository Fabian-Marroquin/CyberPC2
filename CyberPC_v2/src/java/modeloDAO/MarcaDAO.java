package modeloDAO;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Marca;

public class MarcaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List Listar() {
        String sql = "select * from  Marca";
        List<Marca> listaMarca = new ArrayList<Marca>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Marca mc = new Marca();
                mc.setCodigoMarca(rs.getInt(1));
                mc.setDescripcionMarca(rs.getString(2));
                listaMarca.add(mc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMarca;
    }

//MÉTODO PARA AGREGAR
    public int Agregar(Marca mar) {
        String sql = "insert into Marca (descripcionMarca) values (?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, mar.getDescripcionMarca());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo agregar el registro por:"+e);
        }
        return resp;
    }

}