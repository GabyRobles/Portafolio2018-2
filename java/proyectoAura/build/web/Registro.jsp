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
        <script src="https://ajax.googleapis.com/ajax/libs/dojo/1.13.0/dojo/dojo.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Usuario</title>
        <style>
            <%@include file="css/style.css" %>
        </style>
    </head>
    <body class="main">
        <div class="container">
            <div class="login-form">
                <div class="main-div">
                    <div class="panel">
                        <h2>Mis Ofertas</h2>
                    </div>
                    <form action="${pageContext.request.contextPath}/ConsumidorServlet/Registro" method="post" class="needs-validation"  data-toggle="validator" role="form" novalidate>
                        <div class="form-group">
                            <input type="text" class="form-control" id="validationDefault01" placeholder="Nombre" name="fname" required/>
                            <div class="invalid-feedback">
                            Ingrese primer nombre.
                          </div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="validationDefault02" placeholder="Apellido" name="lname" required/>
                            <div class="invalid-feedback">
                            Ingrese apellido.
                          </div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="validationDefault03" placeholder="Rut"  name="rut" required/>
                            <div class="invalid-feedback">
                            Ingrese correo válido.
                          </div>
                        </div>
                        <div class="form-group">
                            <input type="date" class="form-control" placeholder="Fecha Nacimiento" id="nac" name="nac" required/>
                            <div class="invalid-feedback">
                            Seleccione una fecha válida.
                          </div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="validationDefault04" placeholder="Telefono"  name="fono"  required/>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control" id="validationDefaultUsername" placeholder="Correo" name="mail"  aria-describedby="inputGroupPrepend" required/>
                         <div class="invalid-feedback">
                            Ingrese correo válido.
                          </div>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="pass1" placeholder="Contraseña"  name="psw"  required/>
                            <div class="invalid-feedback">
                            Contraseña requerida.
                          </div>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Confirme Contraseña" id="pass2" data-match="#pass1" data-match-error="Las contraseñas no son iguales" name="confirm"  required/>
                            <div class="help-block with-errors"></div>
                            <div class="invalid-feedback">
                            Contraseña Requerida.
                          </div>
                        </div>
                        <div class="form-group">
                            <input class="form-check-input" type="checkbox" id='invalidCheck1' value="1" id="invalidCheck" required/>Estoy de acuerdo con los términos y condiciones
                            <div class="invalid-feedback">
                            Debes aceptar antes de seguir.
                          </div>
                        </div>
                        <div class="form-group">
                            <input class="form-check-input" type="checkbox" id='invalidCheck2' value="1"/>Deseo recibir correos con ofertas
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Registrarse</button>
                        </div>
                    </form>
<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>  
<!--
<script>
    if(pass1.value != pass2.value ){
        
    }
</script>   
-->
                           
                    <p class="botto-text"> Sistema AURA</p><br/>
                    <a href="${pageContext.request.contextPath}/LoginServlet?action=LoginC">ya tienes cuenta? ingresa aquí</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
