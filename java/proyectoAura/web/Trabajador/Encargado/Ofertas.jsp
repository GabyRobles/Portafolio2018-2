
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Ofertas</title>
         
        <style>
            <%@include file="../../css/trabajadorStyle.css" %>
        </style>
    </head>
    <body>
            <div class="row">
                <div class="col-sm-3">
                    <%@include file="../../Plantillas/MenuTrabajador.jspf" %>
                </div>
                <div class="col-sm-9 col-sm-offset-1">
                    <%@include file="../../Plantillas/NavbarTrabajador.jspf" %>
                    <h1>Ofertas</h1>
                    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/OfertaServlet?action=Crear">Nueva Oferta</a>
                    <br/><br/>
                    <table class="table table-bordered table-hover" >
                        <thead class="thead-light">
                        <th scope="col">ID</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Categoria</th>
                        <th scope="col">Fecha de Inicio</th>
                        <th scope="col">Fecha de Termino</th>
                        <th scope="col">Opciones</th>
                        </thead >
                        <tbody>
                            <c:forEach items="${ofertas}" var="oferta">
                                <tr>
                                    <td scope="row">${oferta.getIdOferta()}</td>
                                    <td scope="row">${oferta.getNombre()}</td>
                                    <td scope="row">${oferta.getTipoOferta()}</td>
                                    <td scope="row">${oferta.getFechaIni()}</td>
                                    <td scope="row">${oferta.getFechaTerm()}</td>
                                    <td scope="row"><a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/OfertaServlet?action=Editar&idOferta=${oferta.getIdOferta()}">Editar</a>
                                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/OfertaServlet?action=Eliminar&idOferta=${oferta.getIdOferta()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

    </body>
</html>
