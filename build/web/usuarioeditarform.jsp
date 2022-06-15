<%@ page import="dao.Dao, dao.UsuariosDao, classes.Usuario, java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/form.css" rel="stylesheet" type="text/css"/>
        <title>Editar Usuário</title>
    </head>
    <body>
        
        <%@include file="acessoadm.jsp"%>
        
        <%
            String id = request.getParameter("id");
            Usuario usuario = UsuariosDao.getUsuarioById(Integer.parseInt(id));
        %>
        <form action="usuarioeditar.jsp" method="post">
            <h3>Editar Usuário Id: <%=usuario.getId()%></h3>
            <input type="hidden" name="id" value="<%=usuario.getId()%>">
            <input type="text" name="nome" value="<%=usuario.getNome()%>" placeholder="Seu nome..." required>		
            <input type="email" name="email" value="<%=usuario.getEmail()%>" placeholder="Seu e-mail..." required>	     
        <% if (usuario.getAcesso().equals("Admin")){%>
            <input type="radio" name="acesso" value="Comum" required><label>Comum</label>
            <input type="radio" name="acesso" value="Admin" checked="true"><label>Admin</label>        
        <%}else{%>
            <input type="radio" name="acesso" value="Comum" required checked="true"><label>Comum</label>
            <input type="radio" name="acesso" value="Admin"><label>Admin</label>        
        <%}%>       
            <input type="submit" value="Editar">
        </form>
    </body>
</html>
