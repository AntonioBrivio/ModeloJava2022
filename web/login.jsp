<%@page import="classes.Usuario"%>
<%@ page import="dao.Dao, dao.UsuariosDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="u" class="classes.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
    
<%
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");
    Usuario usuario = UsuariosDao.logar(email, senha);
    if(usuario!=null){
        request.getSession().setAttribute("usuario", usuario.getNome());
        request.getSession().setAttribute("acesso", usuario.getAcesso());    
        response.sendRedirect("principal.jsp");
    }
%>