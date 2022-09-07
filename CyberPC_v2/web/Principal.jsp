<%-- 
    Document   : Principal
    Created on : 31/08/2022, 12:28:22 AM
    Author     : Aarón Matta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <link rel="icon" href="img/SoloLogoPestaña.png">
        <link rel=stylesheet type="text/css" href="css/stylePrincipal.css">
        
        <title>CyberPC</title>
        
    </head>
    
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
            <div class="container">
                
                <a class="navbar-brand" href="#">
                    <img src="img/SoloLogo.png" alt="..." height="36">
                </a>
                
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    
                    <ul class="navbar-nav ms-auto">
                        
                        <li class="nav-item">
                            
                            <a class="nav-link bi bi-house-door-fill" aria-current="page" href="Controlador?menu=Home" target="myFrame"> Home</a>
                            
                        </li>
                        
                        <li class="nav-item">

                            <a class="nav-link bi bi-handbag-fill" href="Controlador?menu=Producto&accion=Listar" target="myFrame"> Producto</a>

                        </li>
                        
                        <li class="nav-item">
                            
                           <a class="nav-link bi bi-bag-plus-fill" href="" target="myFrame"> Tipo Producto</a>
                            
                        </li>
                        
                        <li class="nav-item">
                            
                            <a class="nav-link bi bi-tags-fill" href="" target="myFrame" > Marca</a>
                            
                        </li>
                        
                        <li class="nav-item">
                            
                            <a class="nav-link " href="" target="myFrame"> Sucursal</a>
                            
                        </li>
                        
                        <li class="nav-item">
                            
                            <a class="nav-link bi bi-credit-card-2-back-fill" href="" target="myFrame"> Tipo Pago</a>
                            
                        </li>
                        
                        <li class="nav-item">
                            
                            <a class="nav-link bi bi-file-post-fill" href="Controlador?menu=Factura&accion=Listar" target="myFrame"> Factura</a>
                            
                        </li>
                        
                        <li class="nav-item">
                            
                            <a class="nav-link bi bi-file-text-fill" href="" target="myFrame"> Detalle Factura</a>
                            
                        </li>
                        
                        <li class="nav-item">
                            
                            <a class="nav-link bi bi-person-fill" href="Controlador?menu=Cliente&accion=Listar" target="myFrame" > Cliente</a>
                            
                        </li>
                        
                        <li class="nav-item">
                            
                            <a class="nav-link bi bi-person-check-fill" href="Controlador?menu=Empleado&accion=Listar" target="myFrame" > Empleado</a>
                            
                        </li>
                        
                        <li class="nav-item dropdown">
                            
                            <a class="nav-link dropdown-toggle bi bi-file-person-fill" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                
                                Mi Cuenta
                                
                            </a>
                            
                            <ul class="dropdown-menu dropdown-menu-end text-center" aria-labelledby="navbarDropdown">
                                
                                <li><a class="dropdown-item" href="#"> <img src="img/Logo.png" alt="60" width="60"> </a></li>
                                <li><a class="dropdown-item" href="#"> <a class="dropdown-item" href="#">${empleado.getNombresEmpleado()}</a> </a></li>
                                <li><a class="dropdown-item" href="#"> <a class="dropdown-item" href="#">${empleado.getEmailEmpleado()}</a> </a></li>
                                <li>
                                  <hr class="dropdown-divider">
                                </li>
                                
                                
                                
                                <form action="Validar" method="POST">

                                    <button name="accion" value="Salir" class="dropdown-item bi bi-arrow-right-square-fill" href="#"> Cerrar Sesión</button>

                                </form>
                                
                            </ul>
                        </li>
                        
                    </ul>s
                    
                </div>
                
            </div>
            
        </nav>
    
        <div class="m-4" style="height: 600px">
            
            <iframe src="PrincipalCarousel.jsp" name="myFrame" style="height: 100%; width: 100%;"></iframe>
            
        </div>
    
                                    
        <!-- --------------------------------------------------------------------- PRUEBA ---------------------------------------------------------------------- -->
                                    
        
                        
        <!-- --------------------------------------------------------------------- FIN PRUEBA ---------------------------------------------------------------------- -->
                                    
                                    
                                
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        
    </body>
</html>