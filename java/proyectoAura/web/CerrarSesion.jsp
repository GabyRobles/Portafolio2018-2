<%
    session.invalidate();//cierra la sesión
    response.sendRedirect("Login.jsp");//redirecciona
%>