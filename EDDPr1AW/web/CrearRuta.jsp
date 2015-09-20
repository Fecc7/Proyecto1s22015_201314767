<%-- 
    Document   : CrearRuta
    Created on : 18-sep-2015, 13:50:26
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <title>Crear Ruta</title>
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
                                <li><a  href="AgregarEstaciones.jsp">Agregar Estaciones</a></li>
                                <li><a  href="EliminarEstaciones.jsp">Eliminar Estaciones</a></li>
                                <li><a  href="EliminarRuta.jsp">Eliminar Ruta</a></li>
                                <li><a  href="ImagenRuta.jsp">Imagen Ruta</a></li>
				<li><a  href="Inicio.jsp">Cerrar Sesion</a></li>
				</ul>
                                </nav>
                        </header>
        
<br><br><br>
<form action="CrearRuta.jsp">
        <span class="text-form">Nombre: </span><input type="text" name="Id" value="" />
        <br>
        <input type="submit" value="Agregar" />
            <%-- start web service invocation --%><hr/>
    <%
    try {
	ws.WSP1_Service service = new ws.WSP1_Service();
	ws.WSP1 port = service.getWSP1Port();
	 // TODO initialize WS operation arguments here
	java.lang.String arg0 = request.getParameter("Id");
        if(arg0!=null){
	port.agregarRuta(arg0);}
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
</form>
            </div></div>    


    </body>
</html>
