
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Encargado</title>
        <link rel="shortcut icon" href="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png">
        <style>
            <%@include file="../../css/trabajadorStyle.css" %>
        </style>
    </head>
    <body>
        
            <div class="row">
                <div class="col-sm-2">
                    <%@include file="../../Plantillas/MenuTrabajador.jspf" %>
                </div>
                <div class="col-sm-10 ">
                    <%@include file="../../Plantillas/NavbarTrabajador.jspf" %>
                    <center class="centroHome">
                    <img class="logo" src="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png"/>
                    <h1 class="tituloEncargado">Bienvenido Encargado </h1>
                    <p class="subtituloEncargado">En esta plataforma puede administrar las ofertas y visualizar los productos existentes</p>
                    <a href="${pageContext.request.contextPath}/ProductoServlet?action=Listar"><button class="btnlistar">Lista de Productos</button></a>
                    <a href="${pageContext.request.contextPath}/OfertaServlet?action=Listar"><button class="btnlistaoferta">  Lista de ofertas</button></a> 
                    </center>
                </div>
            </div>
        
    </body>
</html>
