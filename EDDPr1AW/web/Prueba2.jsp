<%-- 
    Document   : Prueba2
    Created on : 17-sep-2015, 19:57:58
    Author     : Francis
--%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" lang="es-es">
<title>Leer archivo de imagen</title>

<style>
div {
margin-top: 30px;
border: solid 1px black;
padding: 5px;
width: 1000px;
height: 1000px;
background: lightyellow;
background-size: 100%;
background-repeat: no-repeat;
text-align: center;
}
</style>

<script>

function processFiles(files) {

var file = files[0];

var reader = new FileReader();

reader.onload = function (e) {
// Cuando éste evento se dispara, los datos están ya disponibles.
// Se trata de copiarlos a una área <div> en la página.
var output = document.getElementById("fileOutput");
fileOutput.style.backgroundImage = "url('" + e.target.result + "')";
//fileOutput.style.backgroundImage = "url('" +"C:\\Users\\Francis\\Pictures\\Sumador_Restador_3_bits.png"+ "')";
alert(e.target.result);
imagenaa.href=e.target.result;
};
reader.readAsDataURL(file);
}

</script>
</head>

<body>
<input id="fileInput" type="file" size="50" onchange="processFiles(this.files)">
<div id="fileOutput"></div>
<a href="C:/Users/Francis/Pictures/Sumador_Restador_3_bits.png" download="Reporte2Mayo2010">
Descargar Archivo
</a>
<a href="images/ArbolAdministrador.jpg" download="Reporte2Mayo2010">
Descargar Archivo
</a>
<a id="imagenaa" href="images/ArbolAdministrador.jpg" target="_blank" onclick="window.open(this.href, this.target, 'width=500, height=500'); return false;">TEXTO_IMAGEN</a>
<img src="images/ArbolAdministrador.jpg" width="208" height="60" alt="ArbolAdministrador"/>

</body>
</html> 