    <%
       String acesso = (String) request.getSession().getAttribute("acesso");
 
        if (!acesso.equals("Admin")) {
            response.sendRedirect("principal.jsp");
        }
    %>
