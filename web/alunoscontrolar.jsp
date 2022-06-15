<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.AlunosDao, classes.Aluno, java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tabela.css">
        <link href="css/grafico.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/padrao.css" rel="stylesheet" type="text/css"/>
        <title>Lista de Alunos da Turma</title>
    </head>
    <body>
        
        <%@include file="acessocomum.jsp"%>   
        
            <div class="topnav">
                <%@include file="menu.jsp"%>
            </div>
            <div class="content">        
            <% 
                String turma = request.getParameter("turma");
                int turma_id = Integer.parseInt(turma);                 
                
                List<Aluno> list = AlunosDao.getAlunos(turma_id);
                request.setAttribute("list", list);               
            %>
        
            <h1>Lista de Alunos</h1>
            <table>
            <tr><th>Id</th><th>Número</th><th colspan="2">Ações</td></tr>
                <c:forEach items="${list}" var="aluno">
                <tr>
                    <td>${aluno.getId()}</td>
                    <td>${aluno.getNome()}</td>
                    <td><a href="alunoeditarform.jsp?id=${aluno.getId()}"><img src="./imagens/editar.png" alt="Editar Usuário"></a></td>          
                </tr>
                </c:forEach>
            </table>
  
            <a href="alunocadastrarform.html"><img src="./imagens/incluir.png" alt="Incluir Usuário"></a>
          
    </div>

    <div class="footer">
        <%@include file="rodape.jsp"%>
    </div>
    </body>
</html>
