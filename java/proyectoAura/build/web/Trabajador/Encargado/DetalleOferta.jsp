<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Oferta</title>
    </head>
    
        <c:if test="${param.oferta != null}">
            <h1>Editar Oferta</h1>
            <form action="${pageContext.request.contextPath}/OfertaServlet/Editar" method="post">
        </c:if>
        <c:if test="${param.oferta == null}">
            <h1>Crear Oferta</h1>
            <form action="${pageContext.request.contextPath}/OfertaServlet/Crear" method="post">
        </c:if>
        <c:if test="${param.oferta == null}"><input type="text" name="nombreOferta" placeholder="nombre" /></c:if>
        <c:if test="${param.oferta != null}"><input type="text" name="nombreOferta" value="${param.oNombre}"</c:if>
        <br/>
        <c:if test="${param.oferta == null}"><input type="text" name="idProducto" placeholder="Id Producto" /></c:if>
        <c:if test="${param.oferta != null}"><input type="text" name="idProducto" value="${param.ofertaID}" /></c:if>
        <br/>
        <c:if test="${param.oferta == null}"><input type="text" name="idCat" placeholder="id Categoria"/></c:if>
        <c:if test="${param.oferta != null}"><input type="text" name="idCat" value="${param.oCategoria}" /></c:if>
        <br/>
        <c:if test="${param.oferta == null}"><input type="text" name="tipo" placeholder="Tipo Oferta" /></c:if>
        <c:if test="${param.oferta != null}"><input type="text" name="tipo" value="${param.oTipo}" /></c:if>
        <br/>
        <c:if test="${param.oferta == null}"><input type="text" name="imagenURL" placeholder="imagen" /></c:if>
        <c:if test="${param.oferta != null}"><input type="text" name="imagenURL" value="${param.oImagen}" /></c:if>
        <br/>
        <c:if test="${param.oferta == null}"><input type="number" name="precio" placeholder="precio"/></c:if>
        <c:if test="${param.oferta != null}"><input type="number" name="precio" value="${param.oPrecio}"/></c:if>
        <br/>
        <c:if test="${param.oferta == null}"><input type="hidden" name="idEncargado" value="${usuario.getIdTrabajador()}"/></c:if>
        <c:if test="${param.oferta != null}"><input type="hidden" name="idEncargado" value="${param.oIdTrab}"/></c:if>
        <br/>
        <c:if test="${param.oferta == null}">  
            <select name="cbSucurcales">
                <c:forEach items="${sucursales}" var="sucursal">
                    <option value="${sucursal.getIdSucursal()}">${sucursal.getNombre()}</option>
                </c:forEach>
            </select></c:if>
        <c:if test="${param.oferta != null}">
            <input type="text" name="imagenURL" value="${param.oSucursal}" />
        </c:if>
        <br/>
        <c:if test="${param.oferta == null}"><input type="date" name="fechaIni" placeholder="Fecha de inicio" /></c:if>
        <c:if test="${param.oferta != null}"><input type="date" name="fechaIni" value="${param.oFechaI}" /></c:if>
        <br/>
        <c:if test="${param.oferta == null}"><input type="date" name="fechaTerm" placeholder="Fecha de termino" /></c:if>
        <c:if test="${param.oferta != null}"><input type="date" name="fechaTerm" placeholder="${param.oFechaT}" /></c:if>
        <br/>
        <c:if test="${param.oferta == null}"><input type="submit" value="Crear"/></c:if>
        <c:if test="${param.oferta != null}"><input type="submit" value="Actualizar"/></c:if>
        </form>
        <button>Limpiar</button>
</html>
