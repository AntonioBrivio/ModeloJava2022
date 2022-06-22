<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Dao, dao.UsuariosDao, classes.Usuario, java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tabela.css">
        <link href="css/grafico.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/padrao.css" rel="stylesheet" type="text/css"/>
        <script src="./scripts/filtrar.js"></script>
        <title>Relatório de Usuários</title>
    </head>
    <body>
        
            <%@include file="acessoadm.jsp"%>
        
            <div class="topnav">
                <%@include file="menu.jsp"%>
            </div>
            <div class="content">        
            <%
                
                List<Usuario> list = UsuariosDao.getRelatorio();
                request.setAttribute("list", list);
               
                int[] valores = UsuariosDao.getRelatorioUsuarios();
                request.setAttribute("valores", valores);
                

            %>
        
            <h1>Relatório de Usuários</h1>
            
            		<input type="text" id="filtrarnomes" onkeyup="filtrar('filtrarnomes', 1)" placeholder="Busca de nomes">
			<input type="text" id="filtraremails" onkeyup="filtrar('filtraremails', 2)" placeholder="Busca de emails">

            <table id="myTable">
            <tr><th>Id</th><th>Nome</th><th>Email</th><th>Acesso</th></tr>
                <c:forEach items="${list}" var="usuario">
                <tr>
                    <td>${usuario.getId()}</td>
                    <td>${usuario.getNome()}</td>
                    <td>${usuario.getEmail()}</td>               
                    <td>${usuario.getAcesso()}</td> 
          
                </tr>
                </c:forEach>
            </table>
 
            <div class="grafico">
                <canvas id="myChart"></canvas>
                <p>Distribuição de Usuários:</p>
                <p>Administrador: <%=valores[0]%></p>
                <p>Comum: <%=valores[1]%></p>
            </div>

            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js
            "></script>

    <script type="text/javascript">
        var ctx = document.getElementById("myChart");
        var valores = [<%=valores[0]%>, <%=valores[1]%>];
        var tipos = ["ADM", "Comum"];

        var myChart = new Chart(ctx, {
          type: "pie",
          data: {
            labels: tipos,
            datasets: [
              {
                label: "Usuarios",
                data: valores,
                backgroundColor: [
                  "rgba(255, 99, 132, 0.2)",
                  "rgba(54, 162, 235, 0.2)",
                  "rgba(255, 206, 86, 0.2)",
                  "rgba(75, 192, 192, 0.2)",
                  "rgba(153, 102, 255, 0.2)",
                ]
              }
            ]
          }
        }); 
    </script>           
    </div>

    <div class="footer">
        <%@include file="rodape.jsp"%>
    </div>
    </body>
</html>

