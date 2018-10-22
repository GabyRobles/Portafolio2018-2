<%-- 
    Document   : Producto
    Created on : 11-10-2018, 13:40:02
    Author     : BR0KK
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Productos</title>
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
                    <h1>Productos</h1>
                    <div class="form-inline">
                        <input class="form-control" type="text" placeholder="Buscar" id="buscador"/>
                        <input class="btn btn-primary" type="button" value="Buscar"/>
                    </div><br/>
                    <table class="table table-bordered table-hover">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Id Producto</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Categoria</th>
                                <th scope="col">llegada del lote</th>
                                <th scope="col">Fecha de vencimiento</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${productos}" var="producto">
                                <tr>
                                    <td scope="row">${producto.getIdProducto()}</td>
                                    <td scope="row">${producto.getNombre()}</td>
                                    <td scope="row">${producto.getIdCategoria().getNombre()}</td>
                                    <td scope="row">${producto.getFechaElab()}</td>
                                    <td scope="row">${producto.getFechaVen()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </body>
</html>
