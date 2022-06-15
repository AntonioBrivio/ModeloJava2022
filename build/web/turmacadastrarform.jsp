<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.CursosDao, classes.Curso, java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Cadastrar Usuários</title>
<meta charset="UTF-8">
<link href="css/form.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    
            <%
                
                List<Curso> list = CursosDao.getCursos();
                request.setAttribute("list", list);
                
            %>
    
	<form action="turmacadastrar.jsp" method="post">
            <h3>Cadastrar Turma</h3>
            <input type="text" name="numero" placeholder="Número da turma..." required>		
            <select name="curso" required>
                <option value="">Selecione um curso</option>             
                <c:forEach items="${list}" var="curso">
                    <option value="${curso.getId()}">${curso.getNome()}</option> 
                </c:forEach>
            </select>

            <input type="submit" value="Enviar">
	</form>
</body>
</html>

