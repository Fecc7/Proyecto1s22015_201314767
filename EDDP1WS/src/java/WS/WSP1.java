package WS;

import Administrador.ArbolAVL;
import Bus.Lista;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.swing.ImageIcon;

@WebService(serviceName = "WSP1")
public class WSP1 {

    public static Bus.Lista listabus=new Bus.Lista();
    public static Administrador.ArbolAVL arboladmi=new Administrador.ArbolAVL();
    public static boolean admiactivo=false;
    
    @WebMethod()
    public String Agregarbus(int id){
    Bus.Bus b=new Bus.Bus(id);
    WSP1.listabus.Agregar(b);
    return "";
    }

    @WebMethod()
    public boolean UsuarioAdmiActivo(){
    boolean a=false;
    a=WSP1.admiactivo;
    return a;
    }
    
    @WebMethod()
    public String mostrarlistabuses(){
    String e="";
    for(Bus.Nodo i=WSP1.listabus.getInicio();i!=null;i=i.getSiguiente()){
    e+=", "+i.getObjeto().getId();
    }
    return e;
    }
    
    @WebMethod()
    public Bus.Lista getListaBus(){
    WSP1.listabus=new Bus.Lista();    
    return WSP1.listabus;
    }
    
    @WebMethod()
    public boolean LoginAdmi(String correo,String contraseña){
    WSP1.admiactivo=WSP1.arboladmi.Buscar(WSP1.arboladmi.getRaiz(), correo, contraseña);
    System.out.println("dakjflñkdkajfldadjfla");
    return WSP1.admiactivo;
    }
    
    @WebMethod()
    public void CerrarSesion(){
    WSP1.admiactivo=false;
    }
    
    @WebMethod()
    public boolean AgregarAdministrador(String correo,String contraseña){
    WSP1.arboladmi.Agregar(new Administrador.Administrador(correo, contraseña));
    return false;    
    }
    
    @WebMethod()
    public void EliminarAdministrador(String correo){
    WSP1.arboladmi.EliminarNodo(correo);
    }
    
    @WebMethod()
    public String DibujarArbol(){
        String a="";
        a=WSP1.arboladmi.RecorrerPreOrden(WSP1.arboladmi.getRaiz(), null);
    return a;
    }
    
    @WebMethod()
    public void DibujarAVLAdmi(){
    WSP1.arboladmi.CrearImagenArbol();
    }
    
    
    
}
