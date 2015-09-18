package WS;

import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@WebService(serviceName = "WSP1")
public class WSP1 {

    public static Bus.Lista listabus=new Bus.Lista();
    public static Administrador.ArbolAVL arboladministrador=new Administrador.ArbolAVL();
    public static Chofer.ArbolAVL arbolchofer=new Chofer.ArbolAVL();
    public static EstacionClave.ArbolAVL arbolestacionclave=new EstacionClave.ArbolAVL();
    public static EstacionGeneral.ArbolAVL arbolestaciongeneral=new EstacionGeneral.ArbolAVL();
    public static boolean administradoractivo=false;
    public static boolean estacionclaveactivo=false;
        public static boolean choferactivo=false;
    public static boolean estaciongeneralactivo=false;
        
    @WebMethod()
    public void DibujarArboles(){
    WSP1.arboladministrador.CrearImagenArbol();
    WSP1.arbolchofer.CrearImagenArbol();
    WSP1.arbolestacionclave.CrearImagenArbol();
    WSP1.arbolestaciongeneral.CrearImagenArbol();
    WSP1.listabus.GraficarLista();
    }
    
    @WebMethod()
    public boolean UsuarioAdministradorActivo(){
    return WSP1.administradoractivo;
    }

    @WebMethod()
    public boolean isEstacionclaveactivo() {
        return WSP1.estacionclaveactivo;
    }

    @WebMethod()
    public boolean isChoferactivo() {
        return WSP1.choferactivo;
    }

    @WebMethod()
    public boolean isEstaciongeneralactiva() {
        return WSP1.estaciongeneralactivo;
    }
    
    @WebMethod()
    public boolean LoginAdministrador(String correo,String contraseña){
    if(correo!=null && contraseña!=null && WSP1.arboladministrador.getRaiz()!=null){
    Administrador.Nodo i=WSP1.arboladministrador.Buscar(WSP1.arboladministrador.getRaiz(), correo, contraseña);
    if(i!=null){
    WSP1.administradoractivo=true;
    }else{
    WSP1.administradoractivo=false;
    }
    }
    return WSP1.administradoractivo;
    }
    
    @WebMethod()
    public boolean LoginChofer(int id,String contraseña){
    if(contraseña!=null && WSP1.arbolchofer.getRaiz()!=null){
    Chofer.Nodo i=WSP1.arbolchofer.Buscar(WSP1.arbolchofer.getRaiz(), id, contraseña);
    if(i!=null){
    WSP1.choferactivo=true;
    }else{
    WSP1.choferactivo=false;
    }
    }
    return WSP1.choferactivo;
    }

	@WebMethod()
	public boolean LoginEstacionClave(int id, String contraseña){
	if(contraseña!=null && WSP1.arbolestacionclave.getRaiz()!=null){
	EstacionClave.Nodo i=WSP1.arbolestacionclave.Buscar(WSP1.arbolestacionclave.getRaiz(),id,contraseña);
	if(i!=null){
	WSP1.estacionclaveactivo=true;
	}else{
	WSP1.estacionclaveactivo=false;
	}
	}
	return WSP1.estacionclaveactivo;
	}

	@WebMethod()
	public boolean LoginEstacionGeneral(int id, String contraseña){
	if(contraseña!=null && WSP1.arbolestaciongeneral.getRaiz()!=null){
	EstacionGeneral.Nodo i=WSP1.arbolestaciongeneral.Buscar(WSP1.arbolestaciongeneral.getRaiz(),id,contraseña);
	if(i!=null){
	WSP1.estaciongeneralactivo=true;
	}else{
	WSP1.estaciongeneralactivo=false;
	}
	}
	return WSP1.estaciongeneralactivo;
	}
    
    @WebMethod()
    public void CerrarSesion(){
    WSP1.administradoractivo=false;
    WSP1.choferactivo=false;
    WSP1.estacionclaveactivo=false;
    WSP1.estaciongeneralactivo=false;
    }
    
    @WebMethod()
    public boolean AgregarAdministrador(String correo,String contraseña){
    if(correo!=null && contraseña!=null){
    WSP1.arboladministrador.setRaiz(WSP1.arboladministrador.Insertar(new Administrador.Administrador(correo,contraseña), WSP1.arboladministrador.getRaiz()));
    WSP1.arboladministrador.CrearImagenArbol();
    return true;
    }    
    else{
    WSP1.arboladministrador.CrearImagenArbol();    
    return false;    }
    }
    
    @WebMethod()
    public boolean AgregarChofer(int id,String nombre,String apellido,String contraseña){
    Chofer.Chofer ch=new Chofer.Chofer(id, nombre, apellido, contraseña);
    if(nombre!=null && apellido!=null && contraseña!=null){
    WSP1.arbolchofer.Agregar(ch);
    WSP1.arbolchofer.CrearImagenArbol();
    return true;
    }
    else{
    WSP1.arbolchofer.CrearImagenArbol();
    return false;
    }
    }

    @WebMethod()
    public boolean AgregarEstacionClave(int id,String nombre,String contraseña){
    EstacionClave.EstacionClave ch=new EstacionClave.EstacionClave(id, nombre, contraseña);
    if(nombre!=null && contraseña!=null){
    WSP1.arbolestacionclave.Agregar(ch);
    WSP1.arbolestacionclave.CrearImagenArbol();
    return true;
    }
    else{
    WSP1.arbolestacionclave.CrearImagenArbol();
    return false;
    }
    }

    @WebMethod()
    public boolean AgregarEstacionGeneral(int id,String nombre,String contraseña){
    EstacionGeneral.EstacionGeneral ch=new EstacionGeneral.EstacionGeneral(id, nombre, contraseña);
    if(nombre!=null && contraseña!=null){
    WSP1.arbolestaciongeneral.Agregar(ch);
    WSP1.arbolestaciongeneral.CrearImagenArbol();
    return true;
    }
    else{
    WSP1.arbolestaciongeneral.CrearImagenArbol();
    return false;
    }
    }
    
    @WebMethod()
    public boolean AgregarBus(String id){
    Bus.Bus nuevo=new Bus.Bus(id);
    WSP1.listabus.Agregar(nuevo);
    WSP1.listabus.OrdenarBurbuja();
    WSP1.listabus.GraficarLista();
    return true;
    }
    
    @WebMethod()
    public void EliminarAdministrador(String correo){
    if(correo!=null){
    WSP1.arboladministrador.EliminarNodo(correo);
    }
    WSP1.arboladministrador.CrearImagenArbol();
    }
    
    @WebMethod()
    public void EliminarChofer(int id){
    WSP1.arbolchofer.EliminarNodo(id);
    WSP1.arbolchofer.CrearImagenArbol();
    }

    @WebMethod()
    public void EliminarEstacionClave(int id){
    WSP1.arbolestacionclave.EliminarNodo(id);
    WSP1.arbolestacionclave.CrearImagenArbol();
    }

    @WebMethod()
    public void EliminarEstacionGeneral(int id){
    WSP1.arbolestaciongeneral.EliminarNodo(id);
    WSP1.arbolestaciongeneral.CrearImagenArbol();
    }
    
    @WebMethod()
    public void EliminarBus(String id){
    WSP1.listabus.Eliminar(WSP1.listabus.Buscar(id));
    WSP1.listabus.GraficarLista();
    }
    
}