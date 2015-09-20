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
var output2 = document.getElementById("archivotxt");
output2.textContent=e.target.result;
//archivotxt.value=e.target.result;
;
};
reader.readAsText(file);

}

</script>
</head>

<body>
    <form action="Prueba.jsp">
    <input name="ffff" id="fileInput" type="file" size="50" onchange="processFiles(this.files)">
<div id="fileOutput" name="fileaa"></div>
<textarea id="archivotxt" name="texto" rows="10" cols="10">
</textarea>
<br>
<br>

    <%
    try {
	ws.WSP1_Service service = new ws.WSP1_Service();
	ws.WSP1 port = service.getWSP1Port();
	 // TODO initialize WS operation arguments here
	java.lang.String texto=request.getParameter("texto");
        java.lang.String[] salto=texto.split("\n");
        
	for(java.lang.String i:salto){
            java.lang.String[] lista=i.split(",");
            if(lista.length==6){
            port.asignar(lista[0], lista[1], lista[2], lista[3], lista[4], lista[5]);
            }
            for(java.lang.String j:lista){
            out.println(j+"<br>");
            
            }
        }
       
	
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>

 

    <input type="submit" value="Agregar" />
    </form>    

   

</body>
</html> 
