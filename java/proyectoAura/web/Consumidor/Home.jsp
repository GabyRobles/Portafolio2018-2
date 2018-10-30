<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            <%@include file="../css/style.css" %>
        </style>
        <script src="../js/CarouselHome.js" type="text/javascript"></script>
        <title>Mis Ofertas</title>
    </head>
    <body>
        <%@include file="../Plantillas/NavbarConsumidor.jspf" %>
        <div class="container-fluid" >
            <div class="row">
                <div id="contenedorMenu">
                    <div class="contenedorTituloMenu">
                        <h5 class="tituloMenu">Todas las</h5>
                        <h2 class="subtituloMenu">Categorias</h2>
                    </div>
                    <hr style="width: 73%; margin-left: 25px; border: 1px solid rgb(241, 241, 241);"/>
                    <button class="botonMenu">Recibe tu Descuento</button>
                    <hr style="width: 73%; margin-left: 25px; border: 1px solid rgb(241, 241, 241);"/>
                    <c:forEach items="${categorias}" var="categoria">
                        <a href="#">${categoria.getNombre()}</a><br/>
                    </c:forEach>
                        
                </div>
                <div class="col-md-10 col-sm-12">
                    <div class="tab1">
                        <h2>Categoría X</h2>
                        <%@include file="../Plantillas/Carousels.jspf" %>
                    </div>
                    <div class="tab1">
                        <h2>Categoría X</h2>
                        <%@include file="../Plantillas/Carousels.jspf" %>
                    </div>
                </div>
            </div>      
        </div>
    </body>
</html>
