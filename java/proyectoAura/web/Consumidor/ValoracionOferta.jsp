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
                    <p class="textoBienvenido">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. 
                        Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, 
                        ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, 
                        fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
                        justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. 
                        Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, 
                        consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. 
                        Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi 
                        vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget 
                        condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit 
                        vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. </p>
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
