
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
        <link rel="shortcut icon" href="https://s3.amazonaws.com/proyectoaura-storage/img/Logo+Empresa.png">
         
        <style>
            <%@include file="../../css/trabajadorStyle.css" %>
        </style>
    </head>
    <body>
            <div class="row">
                <div class="col-sm-2">
                    <%@include file="../../Plantillas/MenuTrabajador.jspf" %>
                </div>
                <div class="col-sm-10 col-sm-offset-1">
                    <%@include file="../../Plantillas/NavbarTrabajador.jspf" %>
                    <div class="contenedorTituloNuevo">
                        <a class="tituloOferta">Ofertas</a>
                        
                        <!--Boton Nuevo-->
                        <a id="btnNuevaOferta" class="btn btn-primary btn-lg" href="#modalOferta">Nueva</a>
                        <!--Modal-->
                        <div id="modalOferta" class="modalDialog">
                            <div>
                                <a href="" title="close" class="close">X</a>
                                <%@include file="../../Trabajador/Encargado/DetalleOferta.jsp" %>
                            </div>
                        </div>
                    </div>
                    
                    <table class="table table-bordered table-hover" >
                        <thead class="thead-light">
                        <th scope="col">ID</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Categoría</th>
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
                                    <td scope="row" class="ofertaInicio">${oferta.getFechaIni()}</td>
                                    <td scope="row" class="ofertaTermino">${oferta.getFechaTerm()}</td>
                                    <td scope="row"><a class="BotonEditar" href="${pageContext.request.contextPath}/OfertaServlet?action=Editar&idOferta=${oferta.getIdOferta()}">Editar</a>
                                        <a class="botonEliminar" href="${pageContext.request.contextPath}/OfertaServlet?action=Eliminar&idOferta=${oferta.getIdOferta()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

    </body>
</html>
