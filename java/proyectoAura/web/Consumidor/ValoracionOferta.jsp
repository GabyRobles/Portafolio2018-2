<%-- 
    Document   : ValoracionOferta
    Created on : 22-oct-2018, 13:49:23
    Author     : solita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Valoración de Ofertas</title>
    </head>
    <body>
        <div id="main-div">
            <div class="estrellitas">

            </div>
            <div class="valoracion-form">
                <form action="${pageContext.request.contextPath}/ValoracionServlet/ValoracionOferta" class="needs-validation" id="formValoracion">
                    <div class="form-control">
                        <label for="imgInput">Agregar Imagen</label>
                        <input type="file" class="form-control-file" id="imgInput">
                    </div>
                    <div class="form-group">
                        <div id="input-type" class="row">
                            <div class="col-sm-6">
                                <label class="radio-inline">
                                    <input name="valoracion" id="input-type-mala" value="1" type="radio"/>Mala
                                </label>
                            </div>
                            <div class="col-sm-6">
                                <label class="radio-inline">
                                    <input name="valoracion" id="input-type-buena" value="2" type="radio"/>Buena
                                </label>
                            </div>
                            <div class="col-sm-6">
                                <label class="radio-inline">
                                    <input name="valoracion" id="input-type-excelente" value="3" type="radio" checked/>Excelente
                                </label>
                            </div>                                
                        </div
                    </div>
                    <div class="dropdown" id="sucursalddl">
                        Selecciona sucursal:
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Sucursal
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                </form>
            </div>
        </div>
    </body>
</html>
