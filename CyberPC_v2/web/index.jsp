<%-- 
    Document   : index
    Created on : Sep 6, 2022, 4:41:25 PM
    Author     : MAMG.JR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <link rel="icon" href="img/SoloLogoPestaña.png">
        <link rel=stylesheet type="text/css" href="css/styleIndex.css">
        
        <title>Iniciar Sesión</title>

    </head>

    <body>

        <div class="container mt-4 col-lg-3" style="background-color: white; border-radius: 10px;">

            <main class="form-signin w-100 m-auto">

                <form action="Validar" method="POST">

                    <div class="text-center">

                        <img class="mb-4 rounded" src="img/Logo.png" alt="" width="200" height="225">

                    </div>

                    <br>

                    <h1 class="h3 mb-3 fw-normal text-center">Iniciar Sesión</h1>

                    <div class="form-floating">

                        <input type="text" name="txtUsuario" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">Usuario</label>

                    </div>

                    <div class="form-floating">

                        <input type="password" name="txtContrasena" class="form-control" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword">Contraseña</label>

                    </div>

                    <br>

                    <div class="text-center">
                        
                        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block" style="width: 100%; margin: 0 auto; height: 45px">
                        
                    </div>

                </form>

                <!--
                <div class="form-floating text-center">
                    
                    <a class="" href="Controlador?menu=RegistrarUsuario&accion=Registrar">Crear Cuenta</a>
                    
                </div>
                -->

            </main>

        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

    </body>

</html>