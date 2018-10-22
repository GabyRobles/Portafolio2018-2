<%-- 
    Document   : Home
    Created on : 08-10-2018, 14:50:14
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
        <title>Home de Encargado</title>
        <style>
            <%@include file="../../css/trabajadorStyle.css" %>
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3">
                    <%@include file="../../Plantillas/MenuTrabajador.jspf" %>
                </div>
                <div class="col-sm-9 col-sm-offset-1">
                    <%@include file="../../Plantillas/NavbarTrabajador.jspf" %>
                    <h1>Bienvenido a Home de Encargado</h1>
                </div>
            </div>
        </div>
    </body>
</html>
