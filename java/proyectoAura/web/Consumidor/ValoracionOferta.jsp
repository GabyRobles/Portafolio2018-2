<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Valoración de Ofertas</title>
    </head>
    <body>
        <div id="main-div">
            <div id="estrellitas">

            </div>
            <div id="div-form-val">
                <form action="${pageContext.request.contextPath}/ValoracionServlet/ValoracionOferta" class="needs-validation" id="formValoracion">
                    <div class="form-control">
                        <label for="imgInput">Agregar Imagen</label>
                        <input type="file" class="form-control-file" id="imgInput">
                    </div>
                    <div class="form-group" id="div-val">
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
                    <div class="form-group" id="div-suc">
                        <label for="cbSucursales">Seleccione Sucursal:</label>
                        <select name="cbSucurcales">
                            <c:forEach items="${sucursales}" var="sucursal">
                                <option value="${sucursal.getIdSucursal()}">${sucursal.getNombre()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-inline">
                        <label for="cbSucursales">Seleccione Sucursal:</label>
                        <select name="cbSucurcales">
                            <c:forEach items="${ofertas}" var="oferta">
                                <option value="${oferta.getOferta()}">${oferta.getNombre()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                </div>
            </form>
        </div>
    </div>
</body>
</html>
