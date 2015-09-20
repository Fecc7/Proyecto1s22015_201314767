<%-- 
    Document   : ModificarEstacionClave
    Created on : 15-sep-2015, 12:24:36
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
				<li class="active"><a href="Administrador.jsp">Home</a></li>
				<li id="PestañaLogin"><a  href="Inicio.jsp">Cerrar Sesion</a></li>
				</ul>
                                </nav>
                        </header><br><br>
        <form action="CrearEstacion.jsp">
        <span class="text-form">Tipo de Estaccion: </span><select name="TipoEstacion">
        <option>Clave</option>
        <option>General</option>
        </select><br><br><br>
        <span class="text-form">Id:</span><input type="text" name="Id" value="" /><br>
        <span class="text-form">Id nuevo:</span><input type="text" name="IdEstacion" value="" /><br>
        <span class="text-form">contraseña nueva: </span><input type="password" name="password" value="" /><br>
        <span class="text-form">Nombre nuevo: </span><input type="text" name="Nombre" value="" /><br>
        <input type="submit" value="Agregar" />
            <%-- start web service invocation --%><hr/>
    <%
    try {
	ws.WSP1_Service service = new ws.WSP1_Service();
	ws.WSP1 port = service.getWSP1Port();
	 // TODO initialize WS operation arguments here
	int arg0 = 0;
        int id=0;
	java.lang.String arg1 = request.getParameter("password");
	java.lang.String arg2 = request.getParameter("Nombre");
        java.lang.String tipo= request.getParameter("TipoEstacion");
        int numero=0;
        int numero2=0;
        boolean isnumero=false;
        try{
        numero=Integer.parseInt(request.getParameter("IdEstacion"));
        numero2=Integer.parseInt(request.getParameter("Id"));
        isnumero=true;
        }catch(NumberFormatException nfe){
        isnumero=false;
        }
        if(isnumero==true && arg1!=null && arg2!=null && tipo!=null){
        arg0=numero;
        id=numero2;
        if(tipo.equals("Clave")){
        port.modificarEstacion(id, "Estacion Clave", arg0, arg2, arg1);
        }else{
        port.modificarEstacion(id, "Estacion General", arg0, arg2, arg1);
        }
        }
        out.println(tipo+arg0+arg1+arg2);
	// TODO process result here
	
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    
    </form>
    </div></div>        

    
    </body>
</html>
