<%-- 
    Document   : PrincipalCarousel
    Created on : 1/09/2022, 10:50:50 PM
    Author     : Aarón Matta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <!-- CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <!-- JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
            <div class="carousel-indicators">
                
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                
            </div>
            
            <div class="carousel-inner">
                
                <div class="carousel-item active">
                    
                  <img src="img/Foto1.jpg" class="d-block w-100" >
                  
                    <!-- 
                    <div class="carousel-caption d-none d-md-block">

                        <h5>First slide label</h5>
                        <p>Some representative placeholder content for the first slide.</p>

                    </div>
                    -->
                  
                </div>
                
                <div class="carousel-item">
                    
                  <img src="img/Foto2.jpg" class="d-block w-100" >
                    
                    <!-- 
                    <div class="carousel-caption d-none d-md-block">

                        <h5>Second slide label</h5>
                        <p>Some representative placeholder content for the second slide.</p>

                    </div>
                    -->

                </div>
                
                <div class="carousel-item">
                    
                  <img src="img/Foto3.jpg" class="d-block w-100" >
                  
                  <!-- 
                  <div class="carousel-caption d-none d-md-block">
                      
                    <h5>Third slide label</h5>
                    <p>Some representative placeholder content for the third slide.</p>
                    
                  </div>
                  -->
                  
                </div>
            </div>
            
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
              
            </button>
            
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
              
            </button>
            
        </div>
        
    </body>
</html>
