    <%
       //L� dados da sess�o
       String usuario = (String) request.getSession().getAttribute("usuario");
 
       //Se n�o h� sess�o, usu�rio n�o logou, retorna para o login
        if (usuario == null) {
            response.sendRedirect("index.jsp");
        }
    %>