<%-- 
    Document   : Home
    Created on : 08-10-2018, 14:50:14
    Author     : nico_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido a Home de Encargado</h1>
        <a href="${pageContext.request.contextPath}/ProductoServlet?action=Listar">Listar Productos</a>
        <a href="${pageContext.request.contextPath}/OfertaServlet?action=Listar">Listar Ofertas</a>
    </body>
</html>