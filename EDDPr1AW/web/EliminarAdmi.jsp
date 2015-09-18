<%-- 
    Document   : EliminarAdmi
    Created on : 15-sep-2015, 12:16:40
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        	<title>Eliminar</title>
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
<br><br><br>
<form action="EliminarAdmi.jsp">
<span class="text-form">Elemento a Eliminar:</span><select name="Tipo">
    <option>Administrador</option>
    <option>Chofer</option>
    <option>Estacion Clave</option>
    <option>Estacion General</option>
    <option>Bus</option>
</select>
<br><br><br>
<span class="text-form">ID/Correo:</span><input type="text" name="ID" value="" />
<br>
<input type="submit" value="Eliminar" />
    <%-- start web service invocation --%><hr/>
    <%
    try {
	ws.WSP1_Service service = new ws.WSP1_Service();
	ws.WSP1 port = service.getWSP1Port();
	 // TODO initialize WS operation arguments here
	int numero=0;
        boolean isnumero=false;
        int arg0 = 0;
        java.lang.String arg1=request.getParameter("ID");
        java.lang.String tipo=request.getParameter("Tipo");
        if(arg1!=null){
        try{
        numero=Integer.parseInt(request.getParameter("ID"));
        isnumero=true;
        arg0=numero;
        }catch(NumberFormatException nfe){
        isnumero=false;
        }
        if(tipo.equals("Administrador")){
        port.eliminarAdministrador(arg1);
        }
        else if(tipo.equals("Chofer") && isnumero==true){
        port.eliminarChofer(arg0);
        }
        else if(tipo.equals("Estacion Clave") && isnumero==true){
        port.eliminarEstacionClave(arg0);
        }
        else if(tipo.equals("Estacion General") && isnumero==true){
        port.eliminarEstacionGeneral(arg0);
        }else if(tipo.equals("Bus") && isnumero==true){
            if(arg1!=null){port.eliminarBus(arg1);}
        }
        }
        out.println(arg1+arg0);
	
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

</form>

            </div></div>
    </body>
</html>
