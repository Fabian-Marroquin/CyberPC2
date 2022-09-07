
package configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    Connection conexion;

    public Connection Conexion() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBCyberPC_v2?useSSL=false", "root", "Turco20043031");

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("No se pudo establecer la conexión");

        }

        return conexion;

    }
}
