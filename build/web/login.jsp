<%@page import="classes.Usuario"%>
<%@ page import="dao.Dao, dao.UsuariosDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="u" class="classes.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
    
<%
    //Lê valores do formulário
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");
    
    //Envia os valores para o Dao e recebe o resultado da consulta
    Usuario usuario = UsuariosDao.logar(email, senha);
    
    //Verifica se algum usuário foi encontrado
    if(usuario!=null){
        //Cria sessão e redireciona para a tela principal
        request.getSession().setAttribute("usuario", usuario.getNome());
        request.getSession().setAttribute("acesso", usuario.getAcesso());    
        response.sendRedirect("principal.jsp");
        
        //Redireciona erros para a tela de login
    }else{
        response.sendRedirect("index.jsp");
    }
%>