<%-- 
    Document   : Administrador
    Created on : 07-sep-2015, 18:20:34
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<title>Administrador</title>
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
                                        <br>
                                        <span class="text-form">Crear</span>
                                        <br>
                                        <nav>
						<ul id="menu" class="menu">
							<li><a href="CrearAdmi.jsp">Administrador</a></li>
							<li><a href="CrearEstacion.jsp">Estacion</a></li>
							<li><a href="CrearChofer.jsp">Chofer</a></li>
                                                        <li><a href="CrearBus.jsp">Bus</a></li>
                                                        <li><a href="CrearRuta.jsp">Ruta</a></li>
						</ul>
                                        </nav>
                                        <br>
                                        <span class="text-form">Eliminar</span>
                                        <br>
                                        <nav>
						<ul id="menu" class="menu">
                                                        <li><a href="EliminarAdmi.jsp">Eliminar Elemento</a></li>
						</ul>
                                        </nav>
                                        <br>
                                        <span class="text-form">Modificar</span>
                                        <br>
                                        <nav>
						<ul id="menu" class="menu">
                                                        <li><a href="ModificarAdmi.jsp">Administrador</a></li>
							<li><a href="ModificarEstacion.jsp">Estacion</a></li>
							<li><a href="ModificarChofer.jsp">Chofer</a></li>
                                                        <li><a href="ModificarBus.jsp">Bus</a></li>
						</ul>
                                        </nav>
                                        <br>
                                        <span class="text-form">Imagen Arbol</span>
                                        <br>                  
    <%
    try {
	ws.WSP1_Service service = new ws.WSP1_Service();
	ws.WSP1 port = service.getWSP1Port();
	port.dibujarArboles();
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
                                        <nav>
						<ul id="menu" class="menu">
                                                        <li><a href="ArbolAdmi.jsp">Administrador</a></li>
							<li><a href="ArbolEstacion.jsp">Estacion</a></li>
							<li><a href="ArbolChofer.jsp">Chofer</a></li>
                                                        <li><a href="ArbolBus.jsp">Bus</a></li>
						</ul>
                                        </nav>
                                            <form action="Administrador.jsp">   
                                            <div class="wrapper p4">
						<ul class="list-services">
                                                        <li><input class="button" type="submit" value="Cargar Archivo" name="Agregar" /></li>
						</ul>
                                            </div>    
                                        </form>
					</header>
    </div></div>
            </body>
</html>
