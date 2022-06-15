<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.TurmasDao, classes.Turma, java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tabela.css">
        <link href="css/grafico.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/padrao.css" rel="stylesheet" type="text/css"/>
        <title>Lista de Turmas</title>
    </head>
    <body>
    
        <%@include file="acessocomum.jsp"%>        
        
            <div class="topnav">
                <%@include file="menu.jsp"%>
            </div>
            <div class="content">        
            <%
                
                List<Turma> list = TurmasDao.getTurmas();
                request.setAttribute("list", list);
                
            %>
        
            <h1>Lista de Turmas</h1>
            <table>
            <tr><th>Id</th><th>Número</th><th>Curso</th><th colspan="2">Ações</td></tr>
                <c:forEach items="${list}" var="turma">
                <tr>
                    <td>${turma.getId()}</td>
                    <td><a href="alunoscontrolar.jsp?turma=${turma.getId()}">${turma.getNumero()}</a></td>
                    <td>${turma.getCurso().getNome()}</td>
                    <td><a href="turmaeditarform.jsp?id=${turma.getId()}"><img src="./imagens/editar.png" alt="Editar Usuário"></a></td>          
                </tr>
                </c:forEach>
            </table>
  
            <a href="turmacadastrarform.jsp"><img src="./imagens/incluir.png" alt="Incluir Usuário"></a>
          
    </div>

    <div class="footer">
        <%@include file="rodape.jsp"%>
    </div>
    </body>
</html>
