<%-- 
    Document   : Factura
    Created on : Sep 6, 2022, 4:59:53 PM
    Author     : MAMG.JR
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <link rel=stylesheet type="text/css" href="css/styleVistas.css">
        <title>Factura</title>
    </head>
    <body style="background: transparent">
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <h2 class="text-center">Facturas</h2>
                    <br>
                    <form action="Controlador?menu=Factura" method="POST">
                        <div class="form-group">
                            <label>Fecha:</label>
                            <input type="date" value="${factura.getFechaFactura()}" name="dtFechaFactura" class="form-control"> 
                        </div>
                        <div class="form-group">
                            <label>NIT:</label>
                            <input type="text" value="${factura.getNIT()}" name="txtNIT" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>DPI Empleado:</label>
                            <input type="text" value="${factura.getDPIEmpleado()}" name="txtDPIEmpleado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Código Tipo de Pago:</label>
                            <input type="text" value="${factura.getCodigoTipoPago()}" name="txtCodigoTipoPago" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Código Sucursal:</label>
                            <input type="text" value="${factura.getCodigoSucursal()}" name="txtCodigoSucursal" class="form-control">
                        </div>
                        <button type="submit" name="accion" value="Agregar" class="bi bi-person-plus-fill btn btn-info"> Agregar</button>
                        <button type="submit" name="accion" value="Actualizar" class="bi bi-person-check-fill btn btn-success"> Actualizar</button>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                    <br>
                        <tr>
                            <td class="table-primary text-center">CÓDIGO</td>
                            <td class="table-primary text-center">FECHA</td>
                            <td class="table-primary text-center">NIT</td>
                            <td class="table-primary text-center">DPIEmpleado</td>
                            <td class="table-primary text-center">PAGO</td>
                            <td class="table-primary text-center">SUCURSAL</td>
                            <td class="table-primary text-center">ACCIONES</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="factura" items="${facturas}">
                        <tr>
                            <td class="text-center table-light">${factura.getCodigoFactura()}</td>
                            <td class="text-center table-light">${factura.getFechaFactura()}</td>
                            <td class="text-center table-light">${factura.getNIT()}</td>
                            <td class="text-center table-light">${factura.getDPIEmpleado()}</td>
                            <td class="text-center table-light">${factura.getCodigoTipoPago()}</td>
                            <td class="text-center table-light">${factura.getCodigoSucursal()}</td>
                            <td class="text-center table-light">
                                <a class="btn btn-warning bi bi-pencil-fill" href="Controlador?menu=Factura&accion=Editar&codigoFa=${factura.getCodigoFactura()}"> Editar</a>
                                <a class="btn btn-danger bi bi-trash-fill" href="Controlador?menu=Factura&accion=Eliminar&codigoFa=${factura.getCodigoFactura()}"> Eliminar</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</html>
