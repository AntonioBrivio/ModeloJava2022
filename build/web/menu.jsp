<head>
<meta charset="utf-8">
</head>
<body>
<ul>
  <li><a href="principal.jsp">Principal</a></li>
  <li><a href="turmascontrolar.jsp">Turmas</a></li>

    <%
      String adm = (String) request.getSession().getAttribute("acesso");
 
       if (adm.equals("Admin")) {
          %>
            
<li class='dropdown'><a href='javascript:void(0)' class='dropbtn'>Usu�rios</a>
<div class='dropdown-content'><a href='usuariosrelatorio.jsp'>Relat�rio de Usu�rios</a><a href='usuarioscontrolar.jsp?pag=1'>Controlar Usu�rios</a><a href='usuariocadastrarform.jsp'>Cadastrar Usu�rio</a></div></li>
            
            <%
          
        }
   %>  
  

 <li class="dropdown" style="float:right">
     <a href="javascript:void(0)" class="dropbtn">Usu�rio: <%=request.getSession().getAttribute("usuario")%></a>
    <div class="dropdown-content">
      <a href="#">Alterar Dados</a>
      <a href="#">Alterar Senha</a>
      <a href="deslogar.jsp">Deslogar</a>
    </div>
  </li>

</ul>

</body>