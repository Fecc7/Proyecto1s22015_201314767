<%-- 
    Document   : CrearChofer
    Created on : 09-sep-2015, 11:28:23
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<title>Crear Chofer</title>
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
        
    <br><br><br><form name="FormularioCrearEstacion">
        <span class="text-form">Id:</span><input type="text" name="IdChofer" value="" /><br>
        <span class="text-form">contraseña: </span><input type="password" name="password" value="" /><br>
        <span class="text-form">Nombre:</span><input type="text" name="NombreChofer" value="" /><br>
        <span class="text-form">Apellido:</span><input type="text" name="ApellidoChofer" value="" /><br>
        <input type="submit" value="Agregar" />
    
    <%
    try {
	ws.WSP1_Service service = new ws.WSP1_Service();
	ws.WSP1 port = service.getWSP1Port();
	 // TODO initialize WS operation arguments here
        int numero=0;
        boolean isnumero=false;
        int arg0 = 0;
        java.lang.String arg1 = request.getParameter("NombreChofer");
	java.lang.String arg2 = request.getParameter("ApellidoChofer");
	java.lang.String arg3 = request.getParameter("password");
        if(arg1!=null && arg2!=null && arg3!=null){
        try{
        numero=Integer.parseInt(request.getParameter("IdChofer"));
        isnumero=true;
        }catch(NumberFormatException nfe){
        isnumero=false;
        }
        
	if(isnumero==true){
        arg0 = numero;
        boolean result = port.agregarChofer(arg0, arg1, arg2, arg3);
	out.println("Result = "+result);
        }
        }
        out.println(arg0+arg1+arg2+arg3);
           } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
        
        
	
	// TODO process result here
	
    %>
    

    </form>
    </div></div>        
    </body>
</html>
