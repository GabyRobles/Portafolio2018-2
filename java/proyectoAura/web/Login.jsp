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
            #Login
            .panel h2{ color:#444444; font-size:18px; margin:0 0 8px 0;}
            .panel p { color:#777777; font-size:14px; margin-bottom:30px; line-height:24px;}
            .login-form .form-control {
                background: #f7f7f7 none repeat scroll 0 0;
                border: 1px solid #d4d4d4;
                border-radius: 4px;
                font-size: 14px;
                height: 50px;
                line-height: 50px;
            }
            .main-div {
                background: #ffffff none repeat scroll 0 0;
                border-radius: 2px;
                margin: 10px auto 30px;
                max-width: 38%;
                padding: 50px 70px 70px 71px;
            }

            .login-form .form-group {
                margin-bottom:10px;
            }
            .login-form{ text-align:center;}
            .forgot a {
                color: #777777;
                font-size: 14px;
                text-decoration: underline;
            }
            .login-form  .btn.btn-primary {
                background: #f0ad4e none repeat scroll 0 0;
                border-color: #f0ad4e;
                color: #ffffff;
                font-size: 14px;
                width: 100%;
                height: 50px;
                line-height: 50px;
                padding: 0;
            }
            .links {
                text-align: left; margin-bottom:30px;
            }
            .botto-text {
                color: #ffffff;
                font-size: 14px;
                margin: auto;
            }
            .login-form .btn.btn-primary.reset {
                background: #ff9900 none repeat scroll 0 0;
            }
            .back { text-align: left; margin-top:10px;}
            .back a {color: #444444; font-size: 13px;text-decoration: none;}
        </style>
    </head>
    <body id="LoginForm">
        <div class="container">
            <div class="login-form">
                <div class="main-div">
                    <div class="panel">
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
                    </form>
                </div>
                <p class="botto-text"> Sistema AURA</p><br/>
                <a href="${pageContext.request.contextPath}/LoginServlet?action=LoginT">Sesión Empleado</a>
            </div>
        </div>
    </div>
</body>
<footer>
</footer>
</html>
