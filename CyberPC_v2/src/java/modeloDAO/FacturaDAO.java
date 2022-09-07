
package modeloDAO;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Factura;


public class FacturaDAO {
    Conexion conSQL = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    //Metodo Listar
    public List listar() {
        String sql = "SELECT * FROM Factura";
        List<Factura> listaFactura = new ArrayList<Factura>();
        try {
            con = conSQL.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura fac = new Factura();
                fac.setCodigoFactura(rs.getInt(1));
                fac.setFechaFactura(rs.getDate(2));
                fac.setNIT(rs.getInt(3));
                fac.setDPIEmpleado(rs.getInt(4));
                fac.setCodigoTipoPago(rs.getInt(5));
                fac.setCodigoSucursal(rs.getInt(6));
                listaFactura.add(fac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaFactura;
    }

    //Metodo Agregar
    public int agregar(Factura fac) {
        String sql = "INSERT INTO Factura(fechaFactura, NIT, DPIEmpleado,codigoTipoPago,codigoSucursal) VALUES (?,?,?,?,?)";
        try {
            con = conSQL.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(fac.getFechaFactura().getTime()));
            ps.setInt(2, fac.getNIT());
            ps.setInt(3, fac.getDPIEmpleado());
            ps.setInt(4, fac.getCodigoTipoPago());
            ps.setInt(5, fac.getCodigoSucursal());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }
}
