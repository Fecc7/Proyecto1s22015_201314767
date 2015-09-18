<%-- 
    Document   : Prueba
    Created on : 17-sep-2015, 18:36:33
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" lang="es-es">
<title>Leer archivo de texto</title>

<style>
div {
margin-top: 30px;
border: solid 1px black;
padding: 5px;
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
output.textContent = e.target.result;
archivotxt.value=e.target.result;
archivotxt.value
;
};
reader.readAsText(file);

}

</script>
</head>

<body>
    <form action="Prueba.jsp">
    <input name="ffff" id="fileInput" type="file" size="50" onchange="processFiles(this.files)">
<div id="fileOutput" name="fileaa">fffff</div>
<input id="archivotxt" type="text" name="texto" value="" />
<br>
<br>
<%
    try {
 
	java.lang.String texto=request.getParameter("texto");
        java.lang.String[] lista=texto.split(" ");
	out.println(lista[0]);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>    
    <input type="submit" value="Agregar" />
    </form>    

   

</body>
</html> 
