<%@page import="dao.EventosDao"%>
<%@ page import="dao.Dao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
  
<%
    String data = request.getParameter("date");
    String hora = request.getParameter("time");
    
    int i = EventosDao.cadastrarEvento(data, hora);
    
    if(i>0){
        response.sendRedirect("eventoscontrolar.html");
    }else{
        response.sendRedirect("eventoscadastrar-erro.jsp");        
    }
%>
