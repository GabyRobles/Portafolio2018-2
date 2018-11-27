<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="/Content/glyphicons.css" rel="stylesheet" />
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png">
        <title>Valoración de Ofertas</title>
        <style>
            <%@include file="../css/style.css" %>
        </style>
    </head>
    <body>
        <%@include file="../Plantillas/NavbarConsumidor.jspf" %>
        <%@include file="../Plantillas/MenuRedirecciones.jspf" %>
        <div class="row">
            <!--Estrellitas-->  
            <div class="col-md-10 col-sm-12">
                <div id="estrellitas">
                    <div class="estrellas">
                        <img class="estrella1" src="https://s3.amazonaws.com/proyectoaura-storage/img/favourites.png"/>
                        <img class="estrella2" src="https://s3.amazonaws.com/proyectoaura-storage/img/favourites.png"/>
                        <img class="estrella3" src="https://s3.amazonaws.com/proyectoaura-storage/img/favourites.png"/>
                        <img class="estrella4" src="https://s3.amazonaws.com/proyectoaura-storage/img/favourites.png"/>
                        <img class="estrella5" src="https://s3.amazonaws.com/proyectoaura-storage/img/favourites.png"/>
                    </div>
                    <h1 class="tituloBienvenido">¡Bienvenido!</h1>
                    <p class="textoBienvenido">Ésta es la página de valoraciones. Para acceder a nuestros 
                    descuentos, valora las ofertas que hayas comprado en cualquiera de nuestras tiendas
                    asociadas. Para ésto, deberas fotografiar la boleta de tu compra, y valorar individualmente
                    las ofertas que hayas comprado en esa boleta. Por cada valoración de oferta que hagas, recibirás
                    10 puntos, los cuales se acumularán para poder ser canjeados por descuentos en nuestras categorías
                    de productos.</p>
                </div>


                <!--Parte seba-->
                <div id="div-form-val">
                    <form action="${pageContext.request.contextPath}/ValoracionServlet/ValoracionOferta" class="needs-validation" id="formValoracion">
                        <div class="agregarImagen">
                            <p class="titulo-control">Agregar Imagen</p>
                            <div class="contenedor-imagen" for="imgInput">
                                <img class="agregarImg" src="https://s3.amazonaws.com/proyectoaura-storage/img/cloud-upload.png">
                                <input type="file" size="30" id="imgInput">
                            </div>
                            <!-- <label for="imgInput">Agregar Imagen</label>
                             <input type="file" class="form-control-file" id="imgInput">-->
                        </div>

                        <div class="grupoValoracion">
                            <div id="div-val">
                                <div id="input-type" class="row">
                                    <div class="col-sm-6">
                                        <label class="radio-inline">
                                            <input name="valoracion" id="input-type-mala" value="1" type="radio"/>Mala
                                        </label>
                                    </div>
                                    <div class="col-sm-6">
                                        <label class="radio-inline">
                                            <input name="valoracion" id="input-type-buena" value="2" type="radio"/>Buena
                                        </label>
                                    </div>
                                    <div class="col-sm-6">
                                        <label class="radio-inline">
                                            <input name="valoracion" id="input-type-excelente" value="3" type="radio" checked/>Excelente
                                        </label>
                                    </div>                                
                                </div>
                            </div>
                            <div class="form-group" id="div-suc">
                                <label for="cbSucursales">Seleccione Sucursal:</label>
                                <select name="cbSucurcales">
                                    <c:forEach items="${sucursales}" var="sucursal">
                                        <option value="${sucursal.getIdSucursal()}">${sucursal.getNombre()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <label for="cbCategoria">Seleccione Categoría:</label>
                                    <select name="cbCategoria">
                                        <c:forEach items="${categorias}" var="categoria">
                                            <option value="${categoria.getCategoria()}">${categoria.getNombre()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col">
                                    <label for="cbOferta">Seleccione Oferta</label>
                                    <select name="cbOferta">
                                        <c:forEach items="${ofertas}" var="oferta">
                                            <option value="${oferta.getOferta()}">${oferta.getNombre()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col">
                                    <a href="#">
                                        <span class="glyphicon glyphicon-ok"></span>
                                    </a>
                                </div>
                                <div class="col">
                                    <a href="#">
                                        <span class="glyphicon glyphicon-remove"></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>                
    </body>    
</html>
