<%-- 
    Document   : Home
    Created on : 08-10-2018, 14:50:03
    Author     : nico_
--%>

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
                <div class="col-md-2 col-sm-12" >
                    <div style="border-right: solid 1px; box-shadow: 8px 0px 5px grey; ">
                        <h5>todas las</h5>
                        <h2>categorias</h2>
                        <hr style="border: 1px solid gray; "/>
                        <button class="btn-lg btn-warning" style="border-radius: 7px">recibe tu descuento</button>
                        <hr style="border: 1px solid gray; "/>
                        <c:forEach items="${categorias}" var="categoria">
                            <a href="#">${categoria.getNombre()}</a><br/>
                        </c:forEach>
                    </div>

                </div>
                <div class="col-md-10 col-sm-12">
                    <h1>Bienvenido a home de consumidor</h1>
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
            </div>
        </div>
    </body>
</html>
