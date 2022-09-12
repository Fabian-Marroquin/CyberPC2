
package reportesFac;

import java.io.InputStream;

public class Reporte {
    public String rutaReporte(){
        String url = String.valueOf(Reporte.class.getResource("FacturaCyberPC.jasper"));
        // C:\Users\Compu Fire\Desktop\New folder (2)\CyberPC_v2\src\java\modeloDAO
        // C:/Users/Compu%20Fire/Desktop/New%20folder%20(2)/CyberPC_v2/build/web/WEB-INF/classes/modeloDAO/FacturaCyberPC.jasper
        // C:\Users\CompuFire\Desktop\Newfolder(2)\CyberPC_v2\build\web\WEB-INF\classes\modeloDAO\FacturaCyberPC.jasper
        url = url.replace("file:/","");
        url = url.replace("%20", " ");
        url = url.replace("build", "src");
        url = url.replace("web/WEB-INF/classes", "java");
        System.out.println("----------------------------------------------");
        System.out.println("Esta puede ser la URL ----- "+url);
        System.out.println("----------------------------------------------");
        return url;
    }
    
    public String rutaGuardarImagenes(){
        String urlWeb = String.valueOf(Reporte.class.getResource("FacturaCyberPC.jasper"));
        urlWeb = urlWeb.replace("file:/", "");
        urlWeb = urlWeb.replace("%20", " ");
        urlWeb = urlWeb.replace("build/", "");
        urlWeb = urlWeb.replace("WEB-INF/classes/reportesFac/FacturaCyberPC.jasper", "img/fotosPerfil/");
        
        //C:/Users/Compu Fire/Desktop/New folder (2)/CyberPC_v2/web/WEB-INF/classes/reportesFac/FacturaCyberPC.jasper
        //C:/Users/Compu Fire/Desktop/New folder (2)/CyberPC_v2/src/java/reportesFac/FacturaCyberPC.jasper
        
        
        return urlWeb;
    }
    
    //C:\Users\Compu Fire\Desktop\New folder (2)\CyberPC_v2\web\img\fotosPerfil
    //C:/Users/Compu Fire/Desktop/New folder (2)/CyberPC_v2/web/img/fotosPerfil
    
    public String rutaImagenReporte(){
        String urlWeb = String.valueOf(Reporte.class.getResource("FacturaCyberPC.jasper"));
        urlWeb = urlWeb.replace("file:/", "");
        urlWeb = urlWeb.replace("%20", " ");
        urlWeb = urlWeb.replace("build/", "");
        urlWeb = urlWeb.replace("WEB-INF/classes/reportesFac/FacturaCyberPC.jasper", "img/");

        //C:/Users/Compu Fire/Desktop/New folder (2)/CyberPC_v2/web/WEB-INF/classes/reportesFac/FacturaCyberPC.jasper
        //C:/Users/Compu Fire/Desktop/New folder (2)/CyberPC_v2/src/java/reportesFac/FacturaCyberPC.jasper
        return urlWeb;
    }
}
