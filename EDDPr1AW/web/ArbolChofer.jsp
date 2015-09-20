<%-- 
    Document   : ArbolChofer
    Created on : 15-sep-2015, 12:19:25
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <title>Arbol Chofer</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
		<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
		<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">
		<script src="js/jquery-1.6.3.min.js" type="text/javascript"></script>
		<script src="js/cufon-yui.js" type="text/javascript"></script>
		<script src="js/cufon-replace.js" type="text/javascript"></script>
		<script src="js/Mate_400.font.js" type="text/javascript"></script>
		<script src="js/FF-cash.js" type="text/javascript"></script>
		<script src="js/tms-0.3.js" type="text/javascript"></script>
		<script src="js/tms_presets.js" type="text/javascript"></script>
		<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="extra">
            <div class="main">
                <br><br><br>
<!--==============================header=================================-->
			<header>
                                <br>
                                <nav>
				<ul id="menu" class="menu">
				<li class="active"><a href="Administrador.jsp">Home</a></li>
				<li id="PestañaLogin"><a  href="Inicio.jsp">Cerrar Sesion</a></li>
				</ul>
                                </nav>
                        </header>
    <form action="ArbolChofer.jsp">
    <br>
        <br>
              <script>

function processFiles(files) {

var file = files[0];

var reader = new FileReader();

reader.onload = function (e) {
// Cuando éste evento se dispara, los datos están ya disponibles.
// Se trata de copiarlos a una área <div> en la página.
var output = document.getElementById("fileOutput");
//fileOutput.style.backgroundImage = "url('" + e.target.result + "')";
//fileOutput.style.backgroundImage = "url('" +"C:\\Users\\Francis\\Pictures\\Sumador_Restador_3_bits.png"+ "')";
//alert(e.target.result);
imagenaa.href=e.target.result;
};
reader.readAsDataURL(file);
}

</script>

<input id="fileInput" type="file" size="50" onchange="processFiles(this.files)">
<a id="imagenaa" href="images/ArbolAdministrador.jpg" target="_blank" onclick="window.open(this.href, this.target, 'width=500, height=500'); return false;">Ver Imagen</a>
        
    </form>

            </div></div>
        

    </body>
</html>
