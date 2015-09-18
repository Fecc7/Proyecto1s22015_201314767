<%-- 
    Document   : Login
    Created on : 06-sep-2015, 12:35:35
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Entrar</title>
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
        <body id="pageLogin" onload="BL()">
		<div class="extra">
			<div class="main">
<!--==============================header=================================-->
				<header>
                                    <br>
                                        <nav>
						<ul id="menu" class="menu">
							<li class="active"><a href="Inicio.jsp">Home</a></li>
                                                        <li class="last" id="PestañaLogin"><a  href="Login.jsp">Entrar</a></li>
						</ul>
                                        </nav>
					</header>
<!--==============================content================================-->
    
    <br>
    <br>
    <br>
    <br>
    <form action="Login.jsp">
        
     
     
            <select name="TipoUsuario">
                <option>Administrador</option>
                <option>Chofer</option>
                <option>Estacion Clave</option>
                <option>Estacion General</option>
            </select><br>
            <span class="text-form">ID/Correo: </span><input id="Correo" type="text" name="ID_Correo" value="" /><br>
            <span class="text-form">Contraseña: </span><input type="password" name="password" value="" /><br>
            <br>
            <input class="button" id="BotonLogin" type="submit" value="Entrar" onClick="document.reset()"/>
                   <%-- start web service invocation --%><hr/>
    <%
    try {
	ws.WSP1_Service service = new ws.WSP1_Service();
	ws.WSP1 port = service.getWSP1Port();
	
	 // TODO initialize WS operation arguments here
	java.lang.String arg0 = request.getParameter("ID_Correo");
	java.lang.String arg1 = request.getParameter("password");
        java.lang.String arg2 = request.getParameter("TipoUsuario");
        if(arg0!=null && arg1!=null && arg2!=null){
        int numero=0;
	// TODO process result here
        boolean result=false;   
        boolean isnumero=false;
	try{
        numero=Integer.parseInt(arg0);
        isnumero=true;
        }catch(NumberFormatException nfe){
        isnumero=false;
        }
        if(arg2!=null){
        if(arg2.equals("Administrador")){
        result = port.loginAdministrador(arg0, arg1);
        }
        else if(arg2.equals("Chofer")){
        if(isnumero==true){
        result=port.loginChofer(numero, arg1);
        }
        }
        else if(arg2.equals("Estacion Clave")){
        if(isnumero==true){
        result=port.loginEstacionClave(numero, arg1);
        }   
        }
        else if(arg2.equals("Estacion General")){
        if(isnumero==true){
        result=port.loginEstacionGeneral(numero, arg1);
        }
        }
        }
        if(result==false){
	out.println(arg2 + " " + arg0+" "+arg1+" Result = "+result);}
        else{
        out.println(arg2 + " " + arg0+" "+arg1+" Result = "+result);    
        response.sendRedirect("Administrador.jsp");
        }}
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
                         

    

        </form>
	</body>
</html>
