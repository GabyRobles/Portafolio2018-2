<%
    session.invalidate();//cierra la sesi�n
    response.sendRedirect("Login.jsp");//redirecciona
%>