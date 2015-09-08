<%-- 
    Document   : CrearAdmi
    Created on : 07-sep-2015, 19:02:13
    Author     : Francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<title>Crear Administrador</title>
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
    
<form action="CrearAdmi.jsp">
        <%-- start web service invocation --%><hr/>
    <%
    try {
	WebService.WSP1_Service service = new WebService.WSP1_Service();
	WebService.WSP1 port = service.getWSP1Port();
	 // TODO initialize WS operation arguments here
	java.lang.String arg0 = request.getParameter("Correo");
	java.lang.String arg1 = request.getParameter("password");
	// TODO process result here
	boolean result = port.agregarAdministrador(arg0, arg1);
	out.println("Result = "+arg0+" "+arg1);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    <span class="text-form">Correo: </span><input type="text" name="Correo" value="" />
    <br><span class="text-form">Contraseña</span><input type="password" name="password" value="" />
    <br><input type="submit" value="Agregar" />
        <%-- start web service invocation --%><hr/>
    <%
    try {
	WebService.WSP1_Service service = new WebService.WSP1_Service();
	WebService.WSP1 port = service.getWSP1Port();
	port.dibujarAVLAdmi();
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

</form>    
    </body>
</html>
