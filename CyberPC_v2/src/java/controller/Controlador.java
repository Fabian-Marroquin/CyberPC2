/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.*;
import modeloDAO.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import reportesFac.Reporte;

/**
 *
 * @author MAMG.JR
 */

public class Controlador extends HttpServlet {
    
    int codFac;

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
    
    int codF = 0;
    int coDf;
    int DPI = 0;
    int NIT = 0;
    int codTipoProducto = 0;
    int codProducto = 0;
    int codSucursal = 0;
    int codMarc = 0;
    int codPago = 0;
    
    // Constructor para llamar encontrar url
    Reporte rep = new Reporte();
    
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
                    String url = rep.rutaGuardarImagenes();
                    
                    ArrayList<String> lista = new ArrayList<>();
                    try {
                        FileItemFactory file = new DiskFileItemFactory();
                        ServletFileUpload fileUpload = new ServletFileUpload(file);
                        List items = fileUpload.parseRequest(request);
                        for (int i = 0; i < items.size(); i++) {
                            FileItem fileItem = (FileItem) items.get(i);
                            if (!fileItem.isFormField()) {
                                File f = new File(url + fileItem.getName());
                                fileItem.write(f);
                                emp.setFotoPerfil("./img/fotosPerfil/" + fileItem.getName());
                            } else {
                                lista.add(fileItem.getString());
                            }
                        }
                        int DPIEmpleado = Integer.parseInt(lista.get(0));
                        emp.setDPIEmpleado(DPIEmpleado);
                        emp.setNombresEmpleado(lista.get(1));
                        emp.setTelefonoEmpleado(lista.get(2));
                        emp.setEmailEmpleado(lista.get(3));
                        emp.setContrasenaEmpleado(lista.get(4));
                        empDAO.agregar(emp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

//                    int DPIEmpleado = Integer.parseInt(request.getParameter("txtDPIEmpleado"));
//                    String nombresEmpleado = request.getParameter("txtNombresEmpleado");
//                    String telefonoEmpleado = request.getParameter("txtTelefonoEmpleado");
//                    String emailEmpleado = request.getParameter("txtEmailEmpleado");
//                    String contrasenaLogin = request.getParameter("txtContrasenaLogin");
//                    
//
//                    emp.setDPIEmpleado(DPIEmpleado);
//                    emp.setNombresEmpleado(nombresEmpleado);
//                    emp.setTelefonoEmpleado(telefonoEmpleado);
//                    emp.setEmailEmpleado(emailEmpleado);
//                    emp.setContrasenaEmpleado(contrasenaLogin);
//                    
//
//                    empDAO.agregar(emp);
//
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                    case "Editar":

                    DPI = Integer.parseInt(request.getParameter("DPIEmpleado"));
                    Empleado e = empDAO.listarCodigoEmpleado(DPI);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String url2 = rep.rutaGuardarImagenes();
//
                    ArrayList<String> lista2 = new ArrayList<>();
                    try {
                        FileItemFactory file = new DiskFileItemFactory();
                        ServletFileUpload fileUpload = new ServletFileUpload(file);
                        List items = fileUpload.parseRequest(request);
                        for (int i = 0; i < items.size(); i++) {
                            FileItem fileItem = (FileItem) items.get(i);
                            
                            if (!fileItem.isFormField()) {
                                if (fileItem.getSize() != 0) {
                                    File f = new File(url2 + fileItem.getName());
                                    fileItem.write(f);
                                    emp.setFotoPerfil("./img/fotosPerfil/" + fileItem.getName());
                                }else {
                                    File f2 = new File(url2 + "41AmiQKMPdL.jpg");
                                    fileItem.write(f2);
                                }
                                
                            } else {
                                lista2.add(fileItem.getString());
                            }
                        }
                        
                        int DPIEmpleado = Integer.parseInt(lista2.get(0));
                        emp.setDPIEmpleado(DPIEmpleado);
                        emp.setNombresEmpleado(lista2.get(1));
                        emp.setTelefonoEmpleado(lista2.get(2));
                        emp.setEmailEmpleado(lista2.get(3));
                        emp.setContrasenaEmpleado(lista2.get(4));
                        empDAO.actualizar(emp);
                        
//                        String nombresEmp = request.getParameter("txtNombresEmpleado");
//                        String telefonoEmp = request.getParameter("txtTelefonoEmpleado");
//                        String emailEmp = request.getParameter("txtEmailEmpleado");
//                        String contrasenaEmp = request.getParameter("txtContrasenaLogin");
//
//                        emp.setNombresEmpleado(nombresEmp);
//                        emp.setTelefonoEmpleado(telefonoEmp);
//                        emp.setEmailEmpleado(emailEmp);
//                        emp.setContrasenaEmpleado(contrasenaEmp);
//                        emp.setDPIEmpleado(DPI);
//                        empDAO.actualizar(emp);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
//                    File archivo = new File(request.getParameter(url2))
//                    String nombresEmp = request.getParameter("txtNombresEmpleado");
//                    String telefonoEmp = request.getParameter("txtTelefonoEmpleado");
//                    String emailEmp = request.getParameter("txtEmailEmpleado");
//                    String contrasenaEmp = request.getParameter("txtContrasenaLogin");
//
//                    emp.setNombresEmpleado(nombresEmp);
//                    emp.setTelefonoEmpleado(telefonoEmp);
//                    emp.setEmailEmpleado(emailEmp);
//                    emp.setContrasenaEmpleado(contrasenaEmp);
//                    emp.setDPIEmpleado(DPI);
//                    empDAO.actualizar(emp);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":

                    DPI = Integer.parseInt(request.getParameter("DPIEmpleado"));
                    empDAO.eliminar(DPI);
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
                case "Editar":
                        codF = Integer.parseInt(request.getParameter("codigoFa"));
                        fac = facDAO.buscarCodigoFactura(codF);
                        request.setAttribute("factura", fac);
                        request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                        try {
                            String feFa = request.getParameter("dtFechaFactura");
                            fac.setFechaFactura(new SimpleDateFormat("yyyy-MM-dd").parse(feFa));
                            fac.setCodigoFactura(codF);
                            facDAO.actualizar(fac);
                            request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    break;
                case "Eliminar":
                    codF = Integer.parseInt(request.getParameter("codigoFa"));
                    facDAO.eliminar(codF);
                    request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
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
                case "Editar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    Producto p = productoDAO.listarCodigoProducto(codProducto);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String nombreP = request.getParameter("txtNombreProducto");
                    String stockP = request.getParameter("txtStock");
                    String precioP = request.getParameter("txtPrecio");
                    
                    System.out.println(codProducto);

                    producto.setNombreProducto(nombreP);
                    producto.setStock(Integer.parseInt(stockP));
                    producto.setPrecioUnitario(Double.parseDouble(precioP));

                    producto.setCodigoProducto(codProducto);
                    productoDAO.actualizar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    productoDAO.eliminar(codProducto);
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
                case "Editar":
                    NIT = Integer.parseInt(request.getParameter("NIT"));
                    Cliente c = clienteDAO.listarNIT(NIT);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String nombresCli = request.getParameter("txtNombresCliente");
                    String apellidosCli = request.getParameter("txtApellidosCliente");
                    String direccionCli = request.getParameter("txtDireccionCliente");
                    String telefonoCli = request.getParameter("txtTelefonoCliente");
                    String emailCli = request.getParameter("txtEmailCliente");
                    cliente.setNombresCliente(nombresCli);
                    cliente.setApellidosCliente(apellidosCli);
                    cliente.setDireccionCliente(direccionCli);
                    cliente.setTelefonoCliente(telefonoCli);
                    cliente.setEmailCliente(emailCli);
                    cliente.setNIT(NIT);
                    clienteDAO.actualizar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    NIT = Integer.parseInt(request.getParameter("NIT"));
                    clienteDAO.eliminar(NIT);
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
                case "Editar":
                    codTipoProducto = Integer.parseInt(request.getParameter("codigoTipoProducto"));
                    TipoProducto e = tipoproductoDAO.listarCodigoTipoProducto(codTipoProducto);
                    request.setAttribute("tipoproducto", e);
                    request.getRequestDispatcher("Controlador?menu=TipoProducto&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String descripcionTp = request.getParameter("txttipoProducto");

                    tipoproducto.setDescripcionTipoProducto(descripcionTp);

                    tipoproducto.setCodigoTipoProducto(codTipoProducto);
                    tipoproductoDAO.actualizar(tipoproducto);
                    request.getRequestDispatcher("Controlador?menu=TipoProducto&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    codTipoProducto = Integer.parseInt(request.getParameter("codigoTipoProducto"));
                    tipoproductoDAO.eliminar(codTipoProducto);
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
                case "Editar":
                    codPago = Integer.parseInt(request.getParameter("codigoTipoPago"));
                    TipoPago t = tipPagoDAO.listarCodigoPago(codPago);
                    request.setAttribute("tiposPago", t);
                    request.getRequestDispatcher("Controlador?menu=TipoPago&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String desPago = request.getParameter("txtTipoPago");
                    tipPago.setDescripcionTipoPago(desPago);
                    tipPago.setCodigoTipoPago(codPago);
                    tipPagoDAO.actualizar(tipPago);
                    request.getRequestDispatcher("Controlador?menu=TipoPago&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    codPago = Integer.parseInt(request.getParameter("codigoTipoPago"));
                    tipPagoDAO.eliminar(codPago);
                    request.getRequestDispatcher("Controlador?menu=TipoPago&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("TipoPago.jsp").forward(request, response);
        } else if (menu.equals("DetalleFactura")) {
            switch (accion) {
                case "Imprimir":
                    
                    break;
                case "Listar":
                    List listaDeFactura = dFacDAO.detallePorFactura(codFac);
                    double total = dFacDAO.totalFactura(codFac);
                    total = Math.round(total*100.0)/100.0;
                    request.setAttribute("total", total);
                    request.setAttribute("detallesfac", listaDeFactura);
                    if (codFac == 0) {
                        
                    } else {
                        request.setAttribute("fac", fac);
                    }
                    break;
                case "Agregar":
//                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
//                    int codigoFactura = Integer.parseInt(request.getParameter("txtCodigoFactura"));
//                    int codigoProducto = Integer.parseInt(request.getParameter("txtCodigoProducto"));
//                    dFac.setCantidad(cantidad);
//                    dFac.setCodigoFactura(codigoFactura);
//                    dFac.setCodigoProducto(codigoProducto);
//                    dFacDAO.Agregar(dFac);
                    
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    int codigoFactura = Integer.parseInt(request.getParameter("txtCodigoFactura"));
                    int codigoProducto = Integer.parseInt(request.getParameter("txtCodigoProducto"));
                    producto = productoDAO.listarCodigoProducto(codigoProducto);
                    
                    dFac.setCantidad(cantidad);
                    dFac.setCodigoFactura(codigoFactura);
                    dFac.setCodigoProducto(codigoProducto);
                    dFacDAO.AgregarConSubtotal(dFac, producto.getPrecioUnitario());
                    if (codFac == 0) {
                        
                    }else{
                        request.setAttribute("fac", fac);
                    }
                    
                    request.getRequestDispatcher("Controlador?menu=DetalleFactura&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                        coDf = Integer.parseInt(request.getParameter("codigoDFactura"));
                        dFac = dFacDAO.buscarDetalle(coDf);
                        request.setAttribute("Dfac", dFac);
                        request.getRequestDispatcher("Controlador?menu=DetalleFactura&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                        int can = Integer.parseInt(request.getParameter("txtCantidad"));
                        int codigoProduct  = Integer.parseInt(request.getParameter("txtCodigoProducto"));
                        producto = productoDAO.listarCodigoProducto(codigoProduct);
                        dFac.setCantidad(can);
                        dFacDAO.actualizar(dFac, producto.getPrecioUnitario());
                        request.getRequestDispatcher("Controlador?menu=DetalleFactura&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                        int cODf = Integer.parseInt(request.getParameter("codigoDFactura"));
                        dFacDAO.eliminar(cODf);
                        request.getRequestDispatcher("Controlador?menu=DetalleFactura&accion=Listar").forward(request, response);
                    break;
                case "Verificacion":
                    
                    String codigoFac = request.getParameter("txtCodigoFactura");
                    
                    if (codigoFac.isEmpty()) {
                        codFac = 0;
                    } else {
                        codFac = Integer.parseInt(request.getParameter("txtCodigoFactura"));
                    }
                    
                    fac = facDAO.buscarCodigoFactura(codFac);
                    
                    if (codFac != fac.getCodigoFactura()) {
                        dFac.setCodigoFactura(codFac);
                        request.setAttribute("Dfac", dFac);
                        request.setAttribute("mesajeFactura", "No existe el número de Factura");
                        request.setAttribute("color1", "red");
                    } else if (codFac == 0) {

                    } else {
                        dFac.setCodigoFactura(codFac);
                        request.setAttribute("Dfac", dFac);
                        request.setAttribute("mesajeFactura", "Existe el número de Factura");
                        request.setAttribute("color1", "greenyellow");
                    }
                    
                    String codigoPro = request.getParameter("txtCodigoProducto");
                    int codPro;
                    if (codigoPro.isEmpty()) {
                        codPro = 0;
                    } else {
                        codPro = Integer.parseInt(request.getParameter("txtCodigoProducto"));
                    }
                    
                    producto = productoDAO.listarCodigoProducto(codPro);
                    request.setAttribute("pro", producto);
                    
                    if (codPro != producto.getCodigoProducto()) {
                        dFac.setCodigoProducto(codPro);
                        request.setAttribute("Dfac", dFac);
                        request.setAttribute("mensajeProducto", "No existe el Producto");
                        request.setAttribute("color", "red");
                    } else if (codPro == 0) {

                    } else {
                        dFac.setCodigoProducto(codPro);
                        request.setAttribute("Dfac", dFac);
                        request.setAttribute("mensajeProducto", "Existe el número el producto");
                        request.setAttribute("color", "greenyellow");
                    }
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
                    
                case "Editar":
                    codSucursal = Integer.parseInt(request.getParameter("codigoSucursal"));
                    Sucursal sur = sucDAO.listarCodigoSucursal(codSucursal);
                    request.setAttribute("sucursal", sur);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String nombreSuc = request.getParameter("txtNombreSucursal");
                    String direccionSuc = request.getParameter("txtDireccionSucursal");
                    suc.setNombreSucursal(nombreSuc);
                    suc.setDireccionSucursal(direccionSuc);
                    suc.setCodigoSucursal(codSucursal);
                    sucDAO.Actualizar(suc);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    codSucursal = Integer.parseInt(request.getParameter("codigoSucursal"));
                    sucDAO.Eliminar(codSucursal);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;    
            }
            request.getRequestDispatcher("Sucursal.jsp").forward(request, response);
        }else if(menu.equals("Marca")){
            switch(accion){
                case "Listar":
                        List listaMarca = marcaDAO.Listar();
                        request.setAttribute("marcas", listaMarca);
                        break;
                case "Agregar":
                        String descripcion = request.getParameter("txtDescripcion");
                        marca.setDescripcionMarca(descripcion);
                        marcaDAO.Agregar(marca);
                        request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                        break;
                case "Editar":
                    codMarc = Integer.parseInt(request.getParameter("codigoMarca"));
                    marca = marcaDAO.listarCodigoMarca(codMarc);
                    request.setAttribute("marca", marca);
                    request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    //int cOmAr = Integer.parseInt(request.getParameter("codigoMarca"));
                    String descMarc = request.getParameter("txtDescripcion");
                    marca.setCodigoMarca(codMarc);
                    marca.setDescripcionMarca(descMarc);
                    marcaDAO.actualizar(marca);
                    request.getRequestDispatcher("Controlador?menu=Marca&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int coMaR = Integer.parseInt(request.getParameter("codigoMarca"));
                    marcaDAO.eliminar(coMaR);
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
