<%-- 
    Document   : Registro
    Created on : 11-10-2018, 14:49:29
    Author     : nico_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Usuario</title>
        <style>
            <%@include file="css/style.css" %>
        </style>
    </head>
    <body id="LoginForm">
        <div class="container">
            <div class="login-form">
                <div class="main-div">
                    <div class="panel">
                        <h2>Mis Ofertas</h2>
                    </div>
                    <form id="Login" action="${pageContext.request.contextPath}/ConsumidorServlet/Registro" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nombre" id="fname" name="fname"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Apellido" id="lname" name="lname"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Rut" id="rut" name="rut" />
                        </div>
                        <div class="form-group">
                            <input type="date" class="form-control" placeholder="Fecha Nacimiento" id="nac" name="nac"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Telefono" id="fono" name="fono"/>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control" placeholder="Correo" id="email" name="mail"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Contraseña" id="psw" name="psw"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Confirme Contraseña" id="confirm" name="confirm"/>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" id='chkTerminos' value="1"/>Estoy de acuerdo con los términos y condiciones
                        </div>
                        <div class="form-group">
                            <input type="checkbox" id='chkCorreos' value="1"/>Deseo recibir correos con ofertas
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Registrarse</button>
                        </div>
                    </form>
                    <p class="botto-text"> Sistema AURA</p><br/>
                    <a href="${pageContext.request.contextPath}/LoginServlet?action=LoginC">ya tienes cuenta? ingresa aquí</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
