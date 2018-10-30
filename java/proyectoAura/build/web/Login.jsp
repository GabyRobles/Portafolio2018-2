<%@include file="Plantillas/UsuarioActivo.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
        <link rel="icon" href="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png">
        <style>
            <%@include file="css/style.css" %>
        </style>
    </head>
    <body id="LoginForm">
        <div class="container">
            <div class="login-form">
                <div class="main-div">
                    <div class="panel">
                        <img class="logo" src="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png"/>
                        <h1>Mis Ofertas</h1>
                        <h2>Inicio de sesión de Consumidores</h2>
                        <p>Por favor ingrese su correo y contraseña</p>
                    </div>
                    <form id="Login" action="${pageContext.request.contextPath}/LoginServlet/Consumidor" method="post">
                        <div class="form-group">
                            <input type="email" class="form-control" id="validationDefaultUsername" name="email" placeholder="Correo" aria-describedby="inputGroupPrepend1" required />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="validationDefaultPassword" name="psw" placeholder="Contraseña" aria-describedby="inputGroupPrepend2" required />
                        </div>
                        <div class="links">
                            <a class="olvideContraseña" href="reset.html">¿Olvidaste tu contraseña?</a>
                        </div>
                        <div class="contenedorBotones">
                            <button type="submit" class="btnInicioSesion">Iniciar Sesión</button>
                            <a class="btn btnCrearUsuario" href="${pageContext.request.contextPath}/LoginServlet?action=Registro">Crear Usuario</a>
                        </div>
                    </form>
                    <p class="botto-text"> Sistema AURA</p><br/>
                    <a href="${pageContext.request.contextPath}/LoginServlet?action=LoginT">Sesión Empleado</a>
                </div>
            </div>
        </div>
    </body>
</html>
