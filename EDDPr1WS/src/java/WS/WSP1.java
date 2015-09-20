package WS;

import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@WebService(serviceName = "WSP1")
public class WSP1 {

    public static Bus.Lista listabus=new Bus.Lista();
    public static Administrador.ArbolAVL arboladministrador=new Administrador.ArbolAVL();
    public static Chofer.ArbolAVL arbolchofer=new Chofer.ArbolAVL();
    public static EstacionClave.ArbolAVL arbolestacionclave=new EstacionClave.ArbolAVL();
    public static EstacionGeneral.ArbolAVL arbolestaciongeneral=new EstacionGeneral.ArbolAVL();
    public static Asignacion.Lista asignaciones=new Asignacion.Lista();
    public static boolean administradoractivo=false;
    public static boolean estacionclaveactivo=false;
    public static boolean choferactivo=false;
    public static boolean estaciongeneralactivo=false;
    public static Ruta.Rutas rutas=new Ruta.Rutas();

    @WebMethod()
    public void ModificarAdmi(String correo,String contraseña,String correon,String contraseñan){
    Administrador.Nodo e=WSP1.arboladministrador.Buscar(WSP1.arboladministrador.getRaiz(), correo, contraseña);
    if(e!=null){
    EliminarAdministrador(correo);
    AgregarAdministrador(correon,contraseñan);
    }
    
    }
    
    @WebMethod()
    public void ModificarChofer(int id,int idn,String nombren,String apellidon,String contraseñan){
    Chofer.Nodo e=WSP1.arbolchofer.Buscar(WSP1.arbolchofer.getRaiz(), id);
    if(e!=null){
    EliminarChofer(id);
    AgregarChofer(idn,nombren,apellidon,contraseñan);
    }
    }
    
    @WebMethod()
    public void ModificarEstacion(int id, String tipo,int idn,String nombren,String contraseñan){
    if(tipo.equals("Estacion Clave")){
    EstacionClave.Nodo e=WSP1.arbolestacionclave.Buscar(WSP1.arbolestacionclave.getRaiz(), id);
    if(e!=null){
    EliminarEstacionClave(id);
    AgregarEstacionClave(idn,nombren,contraseñan);
    }
    }
    if(tipo.equals("Estacion General")){
    EstacionGeneral.Nodo e=WSP1.arbolestaciongeneral.Buscar(WSP1.arbolestaciongeneral.getRaiz(), id);
    if(e!=null){
    EliminarEstacionGeneral(id);
    AgregarEstacionGeneral(idn,nombren,contraseñan);
    }
    }
    }
        
    
    @WebMethod()
    public void GraficarBusesDeChofer(int id){
        
    String tipo="Buses De Chofer"+id;

    
   
    String nodos="digraph grafica { \n" +
" \n" +
"rankdir=TB; \n" +
" \n" +
"label= \""+tipo+"\"  \n" +
"nodesep=0.2 \n" +
"node [shape=record];\n" +
"\n" +
"subgraph g{\n";
    int x=0;
    
    for(Asignacion.Nodo i=WSP1.asignaciones.getInicio();i!=null;i=i.getSiguiente()){
    if(i.getObjeto().getChofer().getChofer().getId()==id){
    nodos+="node"+x+"[label=\"<f0> "+x+"| Bus:"+i.getObjeto().getBus().getObjeto().getId()+"\"];\n";
    x++;
    }
    }
    x=0;
    for(Asignacion.Nodo i=WSP1.asignaciones.getInicio();i!=null;i=i.getSiguiente()){
    if(i.getObjeto().getChofer().getChofer().getId()==id){
    if(i.getSiguiente()!=null){
    nodos+="node"+x+"->node"+(x+1)+";\n";
    }    
    if(i.getAnterior()!=null){
    nodos+="node"+(x)+"->node"+(x-1)+";\n";
    }
    x++;    
    }}
    
    
    nodos+="}rank=same subgraph d{ \n" +
" }\n" +
"}";
FileWriter fichero=null;
    PrintWriter pw=null;
    try{
    fichero=new FileWriter("C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\lista.txt");
    //fichero=new FileWriter("/media/francis/D844D27F44D26034/Users/Francis/Mis documentos/GitHub/Proyecto1s22015_201314767/EDDPr1AW/web/images/lista.txt");        
    pw=new PrintWriter(fichero);
    pw.print(nodos);
    }
    catch(Exception e){

    }
    finally{
    try{
    if(null!=fichero){
    fichero.close();
    }
    }
    catch(Exception e){}
    }
try {
      
      String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
      
      String fileInputPath = "C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\lista.txt";
      //String fileInputPath="/media/francis/D844D27F44D26034/Users/Francis/Mis documentos/GitHub/Proyecto1s22015_201314767/EDDPr1AW/web/images/lista.txt";
      String fileOutputPath = "C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\jjjjj.jpg";
      //String fileOutputPath="/media/francis/D844D27F44D26034/Users/Francis/Mis documentos/GitHub/Proyecto1s22015_201314767/EDDPr1AW/web/images/"+tipo+".jpg";
      String tParam = "-Tjpg";
      String tOParam = "-o";
        
      String[] cmd = new String[5];
      cmd[0] = dotPath;
      cmd[1] = tParam;
      cmd[2] = fileInputPath;
      cmd[3] = tOParam;
      cmd[4] = fileOutputPath;
                  
      Runtime rt = Runtime.getRuntime();
      
      rt.exec( cmd );
      
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
    }
    }
    
    @WebMethod()
  public void EliminarAsignacion(String b,String r,int c,String ho,String hf,String date){
  Asignacion.Nodo i=WSP1.asignaciones.Buscar(b, r, c, ho, hf, date);
  if(i!=null){
  WSP1.asignaciones.Eliminar(i);
  }
  }
    
  @WebMethod()
  public void Asignar(String b,String r,String c,String ho,String hf,String date){
  Bus.Nodo bus=WSP1.listabus.Buscar(b);
  Ruta.Lista ruta=WSP1.rutas.Existe(r);
  Chofer.Nodo chofer=null;
  int numero=0;
  boolean isnumero=false;
  try{
        numero=Integer.parseInt(c);
        isnumero=true;
        chofer=WSP1.arbolchofer.Buscar(WSP1.arbolchofer.getRaiz(), numero);
        }catch(NumberFormatException nfe){
        isnumero=false;
        }
  if(ruta!=null){
  if(isnumero==true){
  if(bus==null){AgregarBus(b);}
  if(chofer==null){AgregarChofer(numero,"Chofer","chofer","chofer");}
  bus=WSP1.listabus.Buscar(b);
  chofer=WSP1.arbolchofer.Buscar(WSP1.arbolchofer.getRaiz(), numero); 
  chofer.getChofer().setContraseña("chofer@chofer.com");
  Asignacion.Asignacion nueva=new Asignacion.Asignacion(bus, ruta, chofer, ho, hf, date);
  WSP1.asignaciones.Agregar(nueva);
  }}
  }
 
    @WebMethod()
    public void AgregarEstacionRuta(String ruta,int estacion,String tipo){
    Ruta.Lista r=rutas.Existe(ruta);
    if(r!=null){
    if(tipo.equals("Estacion Clave")){
    EstacionClave.Nodo clave=WSP1.arbolestacionclave.Buscar(WSP1.arbolestacionclave.getRaiz(), estacion);
    if(clave!=null){
    r.Agregar(clave.getEstacionClave());
    }
    }
    else if(tipo.equals("Estacion General")){
    EstacionGeneral.Nodo general=WSP1.arbolestaciongeneral.Buscar(WSP1.arbolestaciongeneral.getRaiz(), estacion);
    if(general!=null){
    r.Agregar(general.getEstacionGeneral());
    }
    }
    }
    }
    
    @WebMethod
    public void AgregarRuta(String nombre){
    rutas.AgregarRuta(new Ruta.Lista(nombre));
    }
    
    @WebMethod
    public void EliminarEstacionRuta(String ruta,int estacion,String tipo){
    Ruta.Lista r=rutas.Existe(ruta);
    if(r!=null){
    Ruta.Nodo i=r.Buscar(estacion, tipo);
    if(i!=null){
    r.Eliminar(i);
    }
    }
    }
    
    @WebMethod 
    public void EliminarRuta(String nombre){
    rutas.Eliminar(nombre);
    }
    
    @WebMethod
    public void GraficarRuta(String ruta){
    Ruta.Lista r=rutas.Existe(ruta);
    if(r!=null){
    r.GraficarLista();
    }
    }
    
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