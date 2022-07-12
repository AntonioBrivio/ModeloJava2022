<html>
<head>
<title>Usuário Cadastrar</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/form.css">
</head>
<body>
    
    
<%
    
String texto = request.getParameter("date");
String data = texto.substring(0, 10);
String hora = texto.substring(11, 19);
        
%>
<form name="formAdd" id="formAdd" method="post" action="eventocadastrarcodigo.jsp">
    Data: <input type="text" name="date" value="<%=data%>" readonly><br>
    Hora: <input type="text" name="time" value="<%=hora%>" readonly><br>
    Usuário: <input type="text" name="title" id="title" value="" readonly>
    <input type="submit" value="Confirmar">
</form>

</body>
</html>