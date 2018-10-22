<% if (session.getAttribute("usuario") != null) {
    response.sendRedirect("Encargado/Home.jsp");
} %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
    </head>
    <body>
        <h1>Mis Ofertas</h1>
        <form action="${pageContext.request.contextPath}/LoginServlet/Trabajador" method="post">
            <input type="email" placeholder="Correo" id="email" name="email"/><br/>
            <input type="password" placeholder="Contraseña" id="psw" name="psw"/><br/>
            <a>olvide mi contraseña</a><br/>
            <input type="submit" value="Iniciar Sesión"/>
    </body>
</html>
