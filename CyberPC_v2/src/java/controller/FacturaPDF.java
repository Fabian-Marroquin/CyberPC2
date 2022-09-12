
package controller;

import configuration.Conexion;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JRDesignViewer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import reportesFac.Reporte;

public class FacturaPDF extends HttpServlet {
    
    Reporte urlReporte = new Reporte();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream outputS = response.getOutputStream();
        try{
            Conexion con = new Conexion();
            String url = urlReporte.rutaReporte();
            String urlprueba = urlReporte.rutaGuardarImagenes();
            String urlImagenReporte = urlReporte.rutaImagenReporte();
            File reporteFile = new File(url);
            
            System.out.println(url);
            System.out.println("--------------");
            System.out.println(urlprueba);
            System.out.println("------------------");

            Map<String, Object> parametros = new HashMap<>();

            String codFac = request.getParameter("codigoFac");
            int co = Integer.parseInt(codFac);
            String fondoAgua = String.valueOf(urlImagenReporte+"SoloLogoPestaña.png");
            String lgo = String.valueOf(urlImagenReporte+"Logo.png");
            
            
            parametros.put("codFac", co);
            parametros.put("imgMarcaAgua", fondoAgua);
            parametros.put("imgLogo", lgo);

            System.out.println(reporteFile.getPath());

            byte[] bytes = JasperRunManager.runReportToPdf(reporteFile.getPath(), parametros, con.Conexion());
            response.setContentLength(bytes.length);
            outputS.write(bytes, 0, bytes.length);

            outputS.flush();
            outputS.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
