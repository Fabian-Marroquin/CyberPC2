/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
import modeloDAO.*;

/**
 *
 * @author MAMG.JR
 */
public class Controlador extends HttpServlet {

    Empleado emp = new Empleado();
    EmpleadoDAO empDAO = new EmpleadoDAO();
    
    Factura fac = new Factura();
    FacturaDAO facDAO = new FacturaDAO();
    
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    
    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    
    TipoProducto tipoproducto = new TipoProducto();
    TipoProductoDAO tipoproductoDAO = new TipoProductoDAO();
    
    TipoPago tipPago = new TipoPago();
    TipoPagoDAO tipPagoDAO = new TipoPagoDAO();
    
    DetalleFactura dFac = new DetalleFactura();
    DetalleFacturaDAO dFacDAO = new DetalleFacturaDAO();
    
    Sucursal suc = new Sucursal();
    SucursalDAO sucDAO = new SucursalDAO();

    Marca marca = new Marca();
    MarcaDAO marcaDAO = new MarcaDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {

            request.getRequestDispatcher("Principal.jsp").forward(request, response);

        } else if (menu.equals("Empleado")) {

            switch (accion) {

                case "Listar":

                    List listaEmpleados = empDAO.listar();
                    request.setAttribute("empleados", listaEmpleados);
                    break;

                case "Agregar":

                    int DPIEmpleado = Integer.parseInt(request.getParameter("txtDPIEmpleado"));
                    String nombresEmpleado = request.getParameter("txtNombresEmpleado");
                    String telefonoEmpleado = request.getParameter("txtTelefonoEmpleado");
                    String emailEmpleado = request.getParameter("txtEmailEmpleado");
                    String contrasenaLogin = request.getParameter("txtContrasenaLogin");

                    emp.setDPIEmpleado(DPIEmpleado);
                    emp.setNombresEmpleado(nombresEmpleado);
                    emp.setTelefonoEmpleado(telefonoEmpleado);
                    emp.setEmailEmpleado(emailEmpleado);
                    emp.setContrasenaEmpleado(nombresEmpleado);

                    empDAO.agregar(emp);

                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
            }

            request.getRequestDispatcher("Empleado.jsp").forward(request, response);

        } else if (menu.equals("Home")) {

            request.getRequestDispatcher("PrincipalCarousel.jsp").forward(request, response);

        } else if (menu.equals("Factura")) {
            switch (accion) {
                case "Listar":
                    List listaFacturas = facDAO.listar();
                    request.setAttribute("facturas", listaFacturas);
                    break;
                case "Agregar":
                    try {
                        String fechaFac = request.getParameter("dtFechaFactura");
                        int nit = Integer.parseInt(request.getParameter("txtNIT"));
                        int DPIEmpleado = Integer.parseInt(request.getParameter("txtDPIEmpleado"));
                        int codigoTipoPago = Integer.parseInt(request.getParameter("txtCodigoTipoPago"));
                        int codigoSucursal = Integer.parseInt(request.getParameter("txtCodigoSucursal"));
                        fac.setFechaFactura(new SimpleDateFormat("yyyy-MM-dd").parse(fechaFac));
                        fac.setNIT(nit);
                        fac.setDPIEmpleado(DPIEmpleado);
                        fac.setCodigoTipoPago(codigoTipoPago);
                        fac.setCodigoSucursal(codigoSucursal);
                        facDAO.agregar(fac);
                        request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
            }

            request.getRequestDispatcher("Factura.jsp").forward(request, response);
        } else if (menu.equals("Producto")) {

            switch (accion) {
                case "Listar":
                    List listaProductos = productoDAO.listar();
                    request.setAttribute("productos", listaProductos);

                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtNombreProducto");
                    String stock = request.getParameter("txtStock");
                    String precio = request.getParameter("txtPrecio");
                    String codigoTipoProducto = request.getParameter("txtTipoProducto");
                    String codigoMarca = request.getParameter("txtMarca");
                    producto.setNombreProducto(nombre);
                    producto.setStock(Integer.parseInt(stock));
                    producto.setPrecioUnitario(Double.parseDouble(precio));
                    producto.setCodigoTipoProducto(Integer.parseInt(codigoTipoProducto));
                    producto.setCodigoMarca(Integer.parseInt(codigoMarca));
                    productoDAO.Agregar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;

            }

            request.getRequestDispatcher("Producto.jsp").forward(request, response);

        } else if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List listaCliente = clienteDAO.listar();
                    request.setAttribute("clientes", listaCliente);
                    break;
                case "Agregar":
                    String nit = request.getParameter("txtNIT");
                    String nombres = request.getParameter("txtNombresCliente");
                    String apellidos = request.getParameter("txtApellidosCliente");
                    String direccion = request.getParameter("txtDireccionCliente");
                    String telefono = request.getParameter("txtTelefonoCliente");
                    String email = request.getParameter("txtEmailCliente");
                    cliente.setNIT(Integer.parseInt(nit));
                    cliente.setNombresCliente(nombres);
                    cliente.setApellidosCliente(apellidos);
                    cliente.setDireccionCliente(direccion);
                    cliente.setTelefonoCliente(telefono);
                    cliente.setEmailCliente(email);
                    clienteDAO.agregar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }

        if (menu.equals("TipoProducto")) {
            switch (accion) {
                case "Listar":
                    List listaTipoProductos = tipoproductoDAO.listar();
                    request.setAttribute("tipoProductos", listaTipoProductos);
                    break;

                case "Agregar":
                    String tipoProducto = request.getParameter("txttipoProducto");
                    tipoproducto.setDescripcionTipoProducto(tipoProducto);
                    tipoproductoDAO.agregar(tipoproducto);
                    request.getRequestDispatcher("Controlador?menu=TipoProducto&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("TipoProducto.jsp").forward(request, response);
        } else if (menu.equals("TipoPago")) {
            switch (accion) {

                case "Listar":

                    List listaTipoPago = tipPagoDAO.listar();
                    request.setAttribute("tipos", listaTipoPago);
                    break;
                case "Agregar":

                    String tiposPago = request.getParameter("txtTipoPago");

                    tipPago.setDescripcionTipoPago(tiposPago);
                    tipPagoDAO.agregar(tipPago);
                    request.getRequestDispatcher("Controlador?menu=TipoPago&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("TipoPago.jsp").forward(request, response);
        } else if (menu.equals("DetalleFactura")) {
            switch (accion) {
                case "Listar":
                    List listaDeFactura = dFacDAO.Listar();
                    request.setAttribute("detallesfac", listaDeFactura);
                    break;
                case "Agregar":
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    int codigoFactura = Integer.parseInt(request.getParameter("txtCodigoFactura"));
                    int codigoProducto = Integer.parseInt(request.getParameter("txtCodigoProducto"));
                    dFac.setCantidad(cantidad);
                    dFac.setCodigoFactura(codigoFactura);
                    dFac.setCodigoProducto(codigoProducto);
                    dFacDAO.Agregar(dFac);
                    request.getRequestDispatcher("Controlador?menu=DetalleFactura&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("DetalleFactura.jsp").forward(request, response);
        }else if(menu.equals("Sucursal")){
            switch(accion){
                case "Listar":
                    List listaSucursal = sucDAO.Listar();
                    request.setAttribute("Sucursales", listaSucursal);
                    break;
                    
                case "Agregar":
                    String nombreSucursal = request.getParameter("txtNombreSucursal");
                    String direccionSucursal = request.getParameter("txtDireccionSucursal");
                    suc.setNombreSucursal(nombreSucursal);
                    suc.setDireccionSucursal(direccionSucursal);
                    sucDAO.Agregar(suc);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Sucursal.jsp").forward(request, response);
        }else if(menu.equals("Marca")){
            switch(accion){
                case "Listar":
                        List listaMarca = marcaDAO.Listar();
                        request.setAttribute("marca", listaMarca);
                        break;
                case "Agregar":
                        String descripcion = request.getParameter("txtDescripcion");
                        marca.setDescripcionMarca(descripcion);
                        marcaDAO.Agregar(marca);
                        request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                        break;       
            }
            
            request.getRequestDispatcher("Marca.jsp").forward(request, response);
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
