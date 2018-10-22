<% if (session.getAttribute("usuario") != null) {
        response.sendRedirect("Encargado/Home.jsp");
    }%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
    </head>
    <body>
        <div class="main">
            <div class="row" style=" height: 100%; width: 100% ;position: fixed">
                <div class="col-md-6" style="background: linear-gradient(0deg, rgb(8, 6, 157) 0%, rgb(0, 10, 80) 60%)"></div>
                <div class="col-md-6" style="text-align: center; align-items: center">
                    <div style="margin-top: 15%">
                    <img class="logo" src="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png" height="100"/>
                    <h1>Mis Ofertas</h1>
                        <form action="${pageContext.request.contextPath}/LoginServlet/Trabajador" method="post">
                            <center>
                                <div class="form-group" style="width: 70%">
                                    <input class="form-control" type="email" placeholder="Correo" id="email" name="email"/>
                                </div>
                                <div class="form-group" style="width: 70%">
                                    <input class="form-control" type="password" placeholder="Contraseña" id="psw" name="psw"/>
                                </div>
                                <a href="#">olvide mi contraseña</a><br/>
                                <button type="submit" class="btn btn-primary">Iniciar Sesión.</button>
                            </center>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
