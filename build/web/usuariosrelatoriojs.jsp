<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tabela.css">
        <link href="css/grafico.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/padrao.css" rel="stylesheet" type="text/css"/>
        <script src="./scripts/filtrar.js"></script>
        <title>Gr�fico de Usu�rios</title>
    </head>
    <body>
        
            <%@include file="acessoadm.jsp"%>
        
            <div class="topnav">
                <%@include file="menu.jsp"%>
            </div>
            <div class="content">        
        
            <h1>Gr�fico de Usu�rios</h1>
 
            <div class="grafico">
                <canvas id="myChart"></canvas>
            </div>

            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js
            "></script>  
            <script src="scripts/usuariosgrafico.js" type="text/javascript"></script>
    </div>

    <div class="footer">
        <%@include file="rodape.jsp"%>
    </div>
    </body>
</html>

