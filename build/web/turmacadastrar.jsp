<%@ page import="dao.Dao, dao.TurmasDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
  
<%
    int turma_numero = Integer.parseInt(request.getParameter("numero"));
    int curso_id = Integer.parseInt(request.getParameter("curso"));
    int i = TurmasDao.cadastrarTurma(turma_numero, curso_id);
    
    if(i>0){
        response.sendRedirect("turmascontrolar.jsp?pag=1");
    }else{
        response.sendRedirect("turmacadastrar-erro.jsp");        
    }
%>
