<%-- 
    Document   : CrearEstacion
    Created on : 08-sep-2015, 9:19:11
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<title>Crear Estacion</title>
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
							<li class="active"><a href="Inicio.jsp">Home</a></li>
							<li id="PestañaLogin"><a  href="Login.jsp">Entrar</a></li>
                                                        <li class="last"><a href="contacts.html">Contacts</a></li>
						</ul>
                                        </nav>
                                            <form action="Administrador.jsp">
                                            <div class="wrapper p4">
						<ul class="list-services">
                                			<li><a href="CrearAdmi.jsp">Crear Administrador</a></li>
							<li><a href="CrearEstacion.jsp">Crear Estacion</a></li>
							<li><a href="#">FAQs</a></li>
                                                        <li><a href="#">FAQs</a></li>
                                                        <li><a href="#">FAQs</a></li>
                                                        <li><a href="#">FAQs</a></li>
                                                        <li><a href="#">FAQs</a></li>
                                                        <li><input class="button" type="submit" value="Agregar" name="Agregar" /></li>
						</ul>
                                            </div>
                                    </form>
				</header>   
    <form name="FormularioCrearEstacion">
            <span class="text-form">Tipo de Estaccion: </span><select name="TipoEstacion">
            <option>Clave</option>
            <option>General</option>
        </select><br>
        <span class="text-form"></span><input type="text" name="IdEstacion" value="" /><br>
        <span class="text-form">contraseña: </span><input type="text" name="Contraseñae" value="" /><br>
    </form>
</div></div>
    </body>
</html>
