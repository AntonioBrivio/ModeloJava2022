    <%
       //L� dados da sess�o 
       String acesso = (String) request.getSession().getAttribute("acesso");
       
       //Verifica se o acesso � de administrador
        if (!acesso.equals("Admin")) {
            response.sendRedirect("principal.jsp");
        }
    %>
