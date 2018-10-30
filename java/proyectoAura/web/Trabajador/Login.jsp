<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../Plantillas/UsuarioActivo.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
        <link rel="shortcut icon" href="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png">
        <style>
            <%@include file="../css/trabajadorStyle.css" %>
        </style>
    </head>
    <body>
        <div class="main">
            <div class="row">
                <div class="col-md-6" >
                    <img class="imagenGerente" src="https://s3.amazonaws.com/proyectoaura-storage/img/loginGerente.png"/> 
                </div>
                <div class="col-md-6">
                    <div class="loginGerente">
                        <img class="logo" src="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png"/>
                        <h1>Mis Ofertas</h1>
                        <form action="${pageContext.request.contextPath}/LoginServlet/Trabajador" method="post" class="formulario" class="needs-validation" novalidate>
                            <center>
                                <div class="form-group">
                                    <input class="form-control is-valid" type="email" placeholder="nombre@ejemplo.com" id="validationDefaultUsername" name="email" aria-describedby="inputGroupPrepend1" required/>
                                </div>
                                <div class="form-group">
                                    <input class="form-control is-valid" type="password" placeholder="Contraseña" id="validationDefaultPassword" name="psw" aria-describedby="inputGroupPrepend2" required/>
                                </div>
                                <button type="submit" class="btnInicioSesion">Iniciar Sesión</button>
                            </center>
                        </form>
                            <p><span class="label label-danger"> <c:out value="${error}"></c:out></span></p>
                    </div>
                </div>
            </div>
        </div>   
    </body>
</html>
