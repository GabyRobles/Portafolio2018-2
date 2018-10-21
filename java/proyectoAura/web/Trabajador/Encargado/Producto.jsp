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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Productos</title>
    </head>
    <body>
        <input type="text" placeholder="Buscar" id="buscador"/>
        <input type="button" value="Buscar"/>
        <table>
            <thead>
                <tr>
                    <th>Id Producto</th>
                    <th>Nombre</th>
                    <th>Categoria</th>
                    <th>llegada del lote</th>
                    <th>Fecha de vencimiento</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${productos}" var="producto">
                    <tr>
                        <td>${producto.getIdProducto()}</td>
                        <td>${producto.getNombre()}</td>
                        <td>${producto.getIdCategoria()}</td>
                        <td>${producto.getFechaElab()}</td>
                        <td>${producto.getFechaVen()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
