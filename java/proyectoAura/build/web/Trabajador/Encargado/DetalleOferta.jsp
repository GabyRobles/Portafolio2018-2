<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <title>Crear Oferta</title>
    </head>

    <c:if test="${param.oferta != null}">
        <h1 class="display-4 text-secondary" >Editar Oferta</h1>

        <form action="${pageContext.request.contextPath}/OfertaServlet/Editar" method="post">
        </c:if>
        <c:if test="${param.oferta == null}">
            <h1 class="display-4 text-secondary" >Crear Oferta</h1>
            <form action="${pageContext.request.contextPath}/OfertaServlet/Crear" method="post">
            </c:if>

            <div class="form-row">        
                <div class="form-group col-md-6">
                    <c:if test="${param.oferta == null}"><label  class="text-muted" >ID</label> <br/><input type="text" class="form-control" name="idProducto" placeholder="Id Producto" /></c:if>
                    <c:if test="${param.oferta != null}"><label  class="text-muted">ID</label> <br/><input type="text" class="form-control" name="idProducto" value="${param.ofertaID}" /></c:if>
                    </div>

                    <div class="form-group col-md-6">
                    <c:if test="${param.oferta == null}"><label  class="text-muted">Nombre Oferta</label><br/><input type="text" class="form-control" name="nombreOferta" placeholder="nombre" /></c:if>
                    <c:if test="${param.oferta != null}"><label  class="text-muted">Nombre Oferta</label><br/><input type="text" class="form-control" name="nombreOferta" value="${param.oNombre}"/></c:if>
                    </div>
                </div>


                <div class="form-row">
                    <div class="form-group col-md-6">
                    <c:if test="${param.oferta == null}"><label  class="text-muted">Categoría</label> <br/><input type="text" class="form-control" name="idCat" placeholder="id Categoria"/></c:if>
                    <c:if test="${param.oferta != null}"><label  class="text-muted">Categoría</label> <br/><input type="text" class="form-control" name="idCat" value="${param.oCategoria}" /></c:if>
                    </div>

                    <div class="form-group col-md-6">
                    <c:if test="${param.oferta == null}"><label  class="text-muted">Tipo Oferta</label> <br/><input type="text" class="form-control" name="tipo" placeholder="Tipo Oferta" /></c:if>
                    <c:if test="${param.oferta != null}"><label  class="text-muted">Tipo Oferta</label> <br/><input type="text" class="form-control" name="tipo" value="${param.oTipo}" /></c:if>
                    </div>
                </div>


            <c:if test="${param.oferta == null}"><label  class="text-muted">Imagen Oferta</label> <br/><input type="text" class="form-control" name="imagenURL" placeholder="imagen" /></c:if>
            <c:if test="${param.oferta != null}"><label  class="text-muted">Imagen Oferta</label> <br/><input type="text" class="form-control" name="imagenURL" value="${param.oImagen}" /></c:if>

            <c:if test="${param.oferta == null}"><label  class="text-muted">Precio</label> <br/><input type="number" name="precio" class="form-control" placeholder="precio"/></c:if>
            <c:if test="${param.oferta != null}"><label  class="text-muted">Precio</label> <br/><input type="number" name="precio" class="form-control" value="${param.oPrecio}"/></c:if>

            <c:if test="${param.oferta == null}"><input type="hidden" name="idEncargado" value="${usuario.getIdTrabajador()}"/></c:if>
            <c:if test="${param.oferta != null}"><input type="hidden" name="idEncargado" value="${param.oIdTrab}"/></c:if>

            <c:if test="${param.oferta == null}">  
                <label  class="text-muted">Sucursal</label> <br/>
                <select name="cbSucurcales" class="form-control">
                    <c:forEach items="${sucursales}" var="sucursal">                   
                        <option value="${sucursal.getIdSucursal()}">${sucursal.getNombre()}</option>
                    </c:forEach>
                </select></c:if>
            <c:if test="${param.oferta != null}">         
                <label  class="text-muted">Sucursal</label> <br/>
                <input type="text" name="imagenURL" class="form-control" value="${param.oSucursal}" />
            </c:if>


            <div class="form-row"> 
                <div class="form-group col-md-6">
                    <c:if test="${param.oferta == null}"><label  class="text-muted">Fecha Inicio Oferta</label> <br/><input type="date" class="form-control" name="fechaIni" placeholder="Fecha de inicio" /></c:if>
                    <c:if test="${param.oferta != null}"><label  class="text-muted">Fecha Inicio Oferta</label><br/><input type="date" class="form-control" name="fechaIni" value="${param.oFechaI}" /></c:if>
                    </div>
                    <div class="form-group col-md-6">
                    <c:if test="${param.oferta == null}"><label  class="text-muted">Fecha Término Oferta</label><br/><input type="date" class="form-control" name="fechaTerm" placeholder="Fecha de termino" /></c:if>
                    <c:if test="${param.oferta != null}"><label  class="text-muted">Fecha Término Oferta</label> <br/><input type="date" class="form-control" name="fechaTerm" placeholder="${param.oFechaT}" /></c:if>
                    </div>
                </div>
            <c:if test="${param.oferta == null}"><input type="submit" class="btn btn-primary" value="Crear"/></c:if>
            <c:if test="${param.oferta != null}"><input type="submit" class="btn btn-warning" value="Actualizar"/></c:if>
            <button class="btn btn-secondary">Limpiar</button>
        </form>
        

</html>
