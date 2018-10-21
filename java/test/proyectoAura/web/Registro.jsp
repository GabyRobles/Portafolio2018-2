<%-- 
    Document   : Registro
    Created on : 11-10-2018, 14:49:29
    Author     : nico_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Usuario</title>
    </head>
    <body>
     <h1>Mis Ofertas</h1>
    <form action="${pageContext.request.contextPath}/ConsumidorServlet/Registro" method="post">
        <input type="text" placeholder="Nombre" id="fname" name="fname"/>
        <input type="text" placeholder="Apellido" id="lname" name="lname"/><br/>
        <input type="text" placeholder="Rut" id="rut" name="rut" />
        <input type="date" placeholder="Fecha Nacimiento" id="nac" name="nac"/><br/>
        <input type="text" placeholder="Telefono" id="fono" name="fono"/><br/>
        <input type="email" placeholder="Correo" id="mail" name="mail"/><br/>
        <input type="password" placeholder="Contraseña" id="psw" name="psw"/><br/>
        <input type="password" placeholder="Confirme Contraseña" id="confirm" name="confirm"/><br/>
        <input type="checkbox" id='chkTerminos' value="1"/>Estoy de acuerdo con los términos y condiciones<br/>
        <input type="checkbox" id='chkCorreos' value="1"/>Deseo recibir correos con ofertas<br/>
        <input type="submit" value="Crear usuario"/>
    </form><br/>
    <a href="${pageContext.request.contextPath}/LoginServlet?action=LoginC">ya tienes cuenta? ingresa aquí</a>
    </body>
</html>
