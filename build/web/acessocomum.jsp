    <%
       String usuario = (String) request.getSession().getAttribute("usuario");
 
        if (usuario == null) {
            response.sendRedirect("index.jsp");
        }
    %>