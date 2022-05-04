<%@ page import="dao.Dao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="u" class="classes.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
    
<%
    int i = Dao.cadastrarUsuario(u);
    
    if(i>0){
        response.sendRedirect("usuarioscontrolar.jsp?pag=1");
    }else{
        response.sendRedirect("usuariocadastrar-erro.jsp");        
    }
%>