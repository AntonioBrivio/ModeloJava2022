<%@ page import="dao.Dao, dao.UsuariosDao"%>
<jsp:useBean id="u" class="classes.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
    
<%
    int i = UsuariosDao.excluirUsuario(u);
    response.sendRedirect("usuarioscontrolar.jsp?pag=1");
%>