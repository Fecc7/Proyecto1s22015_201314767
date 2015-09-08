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
                    <%-- start web service invocation --%><hr/>
    <%
    try {
	WebService.WSP1_Service service = new WebService.WSP1_Service();
	WebService.WSP1 port = service.getWSP1Port();
        // TODO process result here
	boolean result = port.usuarioAdmiActivo();
	//out.println("Resultjajajajajajajajaja = "+result);
        if (result==true){
        out.println("<script language=JavaScript>   function BL(){ document.getElementById(\"PestañaLogin\").style.display=\"none\";document.getElementById(\"PestañaCerrar\").style.display=\"initial\";}</script>");
        }else{
        out.println("<script language=JavaScript>   function BL(){ document.getElementById(\"PestañaLogin\").style.display=\"initial\";document.getElementById(\"PestañaCerrar\").style.display=\"none\";}</script>");
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
			<div class="main">
<!--==============================header=================================-->
				<header>
                                        <br>
                                        <nav>
						<ul id="menu" class="menu">
							<li class="active"><a href="Inicio.jsp">Home</a></li>
                                                        <li id="PestañaLogin"><a  href="Login.jsp">Entrar</a></li>
                                                        <li id="PestañaCerrar"><a  href="Inicio.jsp">Cerrar sesion</a></li>
                                                        <li><a href="support.html" >Support</a></li>
							<li><a href="downloads.html">Downloads</a></li>
							<li class="last"><a href="contacts.html">Contacts</a></li>
						</ul>
                                            
                                        </nav>
                                            <form action="Login.jsp">
                                            <div class="wrapper p4">
						<ul class="list-services">
							<li><a href="#">Site Map</a></li>
							<li><a href="#">Help</a></li>
							<li><a href="#">FAQs</a></li>
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
<!--==============================content================================-->
    
    <form action="Login.jsp">
    
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	WebService.WSP1_Service service = new WebService.WSP1_Service();
	WebService.WSP1 port = service.getWSP1Port();
	// TODO process result here
	java.lang.String result = port.dibujarArbol();
        out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	WebService.WSP1_Service service = new WebService.WSP1_Service();
	WebService.WSP1 port = service.getWSP1Port();
	 // TODO initialize WS operation arguments here
	java.lang.String arg0 = request.getParameter("ID_Correo");
	java.lang.String arg1 = request.getParameter("password");
        java.lang.String arg2 = request.getParameter("TipoUsuario");
	// TODO process result here
	boolean result = port.loginAdmi(arg0, arg1);
	out.println(arg2 + " " + arg0+" "+arg1+" Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    
            <select name="TipoUsuario">
                <option>Administrador</option>
                <option>Chofer</option>
                <option>Estacion</option>
            </select><br>
            <span class="text-form">ID/Correo: </span><input id="Correo" type="text" name="ID_Correo" value="" /><br>
            <span class="text-form">Contraseña: </span><input type="password" name="password" value="" /><br>
            <br>
            <input class="button" id="BotonLogin" type="submit" value="Entrar" onClick="document.reset()"/>
                                         

    

        </form>
	</body>
</html>
