<%-- 
    Document   : Home
    Created on : 08-10-2018, 14:50:21
    Author     : nico_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Consumidor</title>
        <link rel="shortcut icon" href="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png">
        <style>
            <%@include file="../../css/gerenteStyle.css" %>
        </style>
    </head>
    <body>
         <div class="row">
                <div class="col-sm-2">
                    <%@include file="../../Plantillas/MenuGerente.jspf" %>
                </div>
                <div class="col-sm-10 ">
                    <%@include file="../../Plantillas/NavbarGerente.jspf" %>
                        <h1 class="tituloInforme">Generar Informe </h1>
                        <div id="ContenedorInforme">
                            <div class="conenedorFechas">
                                <h5>Desde</h5>
                                <div class="contenedorFechaDesde" >contenedor</div> 
                                <h5 class="txtHasta">Hasta</h5>
                                <div class="contenedorFechaHasta" >contenedor2</div> 
                            </div>
                            <div class="contenedorBtn">
                                <button class="btnGenerarInforme" >Generar</button>
                            </div>
                        </div>
                </div>
            </div>
    </body>
</html>
