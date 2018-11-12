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
                    <button class="botonMenu"><a href="${pageContext.request.contextPath}/Consumidor/ValoracionOferta.jsp" > Recibe tu Descuento</a></button>
                    <hr style="width: 73%; margin-left: 25px; border: 1px solid rgb(241, 241, 241);"/>
                    <c:forEach items="${categorias}" var="categoria">
                        <a class="catalogo" href="#">${categoria.getNombre()}</a><br><br>
                    </c:forEach>
                        
                </div>
                <div class="contenedorHome col-md-10 col-sm-12">
                    <c:forEach items="${categorias}" var="categoria">
                        <div class="tab1">
                            <h2><c:out value="${categoria.nombre}" /></h2>
                            <div class="container">
                                <div class="row blog">
                                    <div class="col-md-12">
                                        <div id="blogCarousel" class="carousel slide" data-ride="carousel">
                                            <ol class="carousel-indicators">
                                                <li data-target="#blogCarousel" data-slide-to="0" class="active"></li>
                                                <li data-target="#blogCarousel" data-slide-to="1"></li>
                                            </ol>
                                            <div class="carousel-inner">
                                                <div class="carousel-item active">
                                                    <div class="row">
                                                        <c:forEach items="${categoria.nombre}" var="oferta" begin="0" end="4">
                                                        <div class="col-md-3">
                                                            <a href="#">
                                                                <img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;">
                                                            </a>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <a href="#">
                                                                <img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;">
                                                            </a>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <a href="#">
                                                                <img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;">
                                                            </a>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <a href="#">
                                                                <img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;">
                                                            </a>
                                                        </div>
                                                        </c:forEach>
                                                    </div>
                                                    <!--.row-->
                                                </div>
                                                <!--.item-->

                                                <div class="carousel-item">
                                                    <div class="row">
                                                        <div class="col-md-3">
                                                            <a href="#">
                                                                <img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;">
                                                            </a>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <a href="#">
                                                                <img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;">
                                                            </a>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <a href="#">
                                                                <img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;">
                                                            </a>
                                                        </div>
                                                        <div class="col-md-3">
                                                            <a href="#">
                                                                <img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;">
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <!--.row-->
                                                </div>
                                                <!--.item-->
                                            </div>
                                            <!--.carousel-inner-->
                                        </div>
                                        <!--.Carousel-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>      
        </div>
    </body>
</html>
