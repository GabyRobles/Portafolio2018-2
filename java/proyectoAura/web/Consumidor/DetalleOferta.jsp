<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="../js/CarouselHome.js" type="text/javascript"></script>
        <title>Mis Ofertas</title>
        <link rel="shortcut icon" href="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png">
        <style>
            <%@include file="../css/style.css" %>
        </style>
    </head>
    <body>
        <%@include file="../Plantillas/NavbarConsumidor.jspf" %>
        <div class="container-fluid" >
            <div class="row">
                <%@include file="../Plantillas/MenuRedirecciones.jspf"%>
                <img src="${oferta.imagen}" alt="Image" style="max-width:100%;">
                <h2><c:out value="${oferta.nombre}" /></h2>
                <h2><c:out value="${oferta.tipoOferta}" /></h2>
                <h2>precio=<c:out value="${oferta.precioOferta}" /></h2>
                <h2>fecha de termino=<c:out value="${oferta.fechaTerm}" /></h2>
            </div>
            </div>
        </body>
    </html>

