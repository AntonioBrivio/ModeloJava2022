<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="servlet.Login, dao.Dao, dao.UsuariosDao, classes.Usuario, java.util.*"%>
<%
          request.getSession().invalidate();
        response.sendRedirect("index.jsp");
%>