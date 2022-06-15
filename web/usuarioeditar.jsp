<%@ page import="dao.Dao, dao.UsuariosDao"%>
<jsp:useBean id="u" class="classes.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%@include file="acessoadm.jsp"%>

<%
    int i = UsuariosDao.editarUsuario(u);

    if(i>0){
        response.sendRedirect("usuarioscontrolar.jsp?pag=1");
    }else{
        response.sendRedirect("usuarioexcluir-erro.jsp");        
    }

%>
