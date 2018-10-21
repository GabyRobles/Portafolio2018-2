<%-- 
    Document   : Ofertas
    Created on : 11-10-2018, 13:40:19
    Author     : nico_
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ofertas</h1>
        <a href="${pageContext.request.contextPath}/OfertaServlet?action=Crear">Nueva Oferta</a>
        <br/>
        <table>
            <thead>
            <th>ID</th>
            <th>Nombre</th>
            <th>Categoria</th>
            <th>Fecha de Inicio</th>
            <th>Fecha de Termino</th>
            <th>Opciones</th>
        </thead>
        <tbody>
            <c:forEach items="${ofertas}" var="oferta">
                <tr>
                    <td>${oferta.getId()}</td>
                    <td>${oferta.getNombre()}</td>
                    <td>${oferta.getTipoOferta()}</td>
                    <td>${oferta.getFechaIni()}</td>
                    <td>${oferta.getFechaTerm()}</td>
                    <td><a href="/OfertaServlet?action=editar&id=${oferta.getId()}">Editar</a>
                        <a href="/OfertaServlet?action=eliminar&id=${oferta.getId()}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
