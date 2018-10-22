<%-- 
    Document   : Login
    Created on : 08-10-2018, 14:50:28
    Author     : nico_
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
        <style>
            <%@include file="css/style.css" %>
        </style>
    </head>
    <body id="LoginForm">
        <div class="container">
            <div class="login-form">
                <div class="main-div">
                    <div class="panel">
                        <img class="logo" src="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png" height="100"/>
                        <h1>Mis Ofertas</h1>
                        <h2>Inicio de sesión de Consumidores</h2>
                        <p>Por favor ingrese su correo y contraseña</p>
                    </div>
                    <form id="Login" action="${pageContext.request.contextPath}/LoginServlet/Consumidor" method="post">
                        <div class="form-group">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Correo Electrónico">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="psw" name="psw" placeholder="Contraseña">
                        </div>
                        <div class="links">
                            <a href="reset.html">¿Olvidaste tu contraseña?</a>
                            <a href="${pageContext.request.contextPath}/LoginServlet?action=Registro"> Crear Usuario </a>
                        </div>
                        <button type="submit" class="btn btn-primary">Iniciar Sesión.</button>
                    </form><br/>
                    <p class="botto-text"> Sistema AURA</p><br/>
                    <a href="${pageContext.request.contextPath}/LoginServlet?action=LoginT">Sesión Empleado</a>
                </div>
            </div>
        </div>
    </body>
    <footer>
    </footer>
</html>
