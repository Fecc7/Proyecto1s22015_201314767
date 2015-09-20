<%-- 
    Document   : AgregarEstaciones
    Created on : 18-sep-2015, 17:58:10
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <title>Agregar Estacion</title>
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
                                <li><a href="CrearRuta.jsp">Crear Ruta</a></li>
                                <li><a  href="EliminarEstaciones.jsp">Eliminar Estaciones</a></li>
                                <li><a  href="EliminarRuta.jsp">Eliminar Ruta</a></li>
                                <li><a  href="ImagenRuta.jsp">Imagen Ruta</a></li>
				<li><a  href="Inicio.jsp">Cerrar Sesion</a></li>
				</ul>
                                </nav>
                        </header>
<br><br><br>
<form action="AgregarEstaciones.jsp">
<span class="text-form">Tipo Estacion: </span><select name="Tipo">
    <option>Estacion Clave</option>
    <option>Estacion General</option>
</select>
<br><br>
<span class="text-form">ID: </span><input type="text" name="Id" value="" />
<br><br>
<span class="text-form">Nombre Ruta: </span><input type="text" name="Nombre" value="" />
<input type="submit" value="Agregar" />
    <%
    try {
	ws.WSP1_Service service = new ws.WSP1_Service();
	ws.WSP1 port = service.getWSP1Port();
	 // TODO initialize WS operation arguments here
        java.lang.String arg0 = request.getParameter("Nombre");
	int arg1 = 0;
	java.lang.String arg2 = request.getParameter("Tipo");
        int numero=0;
        boolean isnumero=false;
        try{
        numero=Integer.parseInt(request.getParameter("Id"));
        isnumero=true;
        arg1=numero;
        }catch(NumberFormatException nfe){
        isnumero=false;
        }
        if(arg0!=null && arg2!=null && isnumero==true){
        port.agregarEstacionRuta(arg0, arg1, arg2);
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>

    
</form>


            </div></div>
    </body>
</html>
