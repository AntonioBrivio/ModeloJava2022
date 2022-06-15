<%@ page import="dao.Dao, dao.UsuariosDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="u" class="classes.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%@include file="acessoadm.jsp"%>

<%
    int i = UsuariosDao.cadastrarUsuario(u);
    
    if(i>0){
        response.sendRedirect("usuarioscontrolar.jsp?pag=1");
    }else{
        response.sendRedirect("usuariocadastrar-erro.jsp");        
    }
%>