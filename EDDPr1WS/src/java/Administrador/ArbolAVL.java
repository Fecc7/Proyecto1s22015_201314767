package Administrador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public final class ArbolAVL {

    Nodo raiz=null;
    public ArbolAVL(){
    Agregar(new Administrador("francischic@gmail.com","123"));
    }    

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    public String RecorrerPreOrden(Nodo actual, Nodo Padre){
    String salida=null;
    if(actual!=null){
    if(Padre==null){
    salida="raiz: "+actual.getAdministrador().getCorreo()+"\n";
    }else{
    if(Padre.getHijoIzq()==actual){
    salida=Padre.getAdministrador().getCorreo() +" Izq --> "+actual.getAdministrador().getCorreo()+"\n" ;
    }
    else if(Padre.getHijoDer()==actual){
    salida=Padre.getAdministrador().getCorreo() +" Der --> "+actual.getAdministrador().getCorreo()+"\n" ;
    }
    }
    if(actual.getHijoIzq()!=null){
    salida+=RecorrerPreOrden(actual.getHijoIzq(),actual);
    }
    if(actual.getHijoDer()!=null){
    salida+=RecorrerPreOrden(actual.getHijoDer(),actual);
    }
    }
    return salida;
    }
    
    public void Agregar(Administrador administrador){
    setRaiz(Insertar(administrador,getRaiz()));
    }
    
    public Nodo Buscar(Nodo raiz,String correo,String contraseña){
    Nodo r=null;
    System.out.println("Metodo Buscar");
    if(raiz!=null){
        System.out.println("Entro");
        System.out.println(raiz.getAdministrador().getCorreo());
        System.out.println(correo);
    if(raiz.getAdministrador().getCorreo().equals(correo) && raiz.getAdministrador().getContraseña().equals(contraseña)){
    r=raiz;
    }else{
    if(correo.compareTo(raiz.getAdministrador().getCorreo())<0){
    r=Buscar(raiz.getHijoIzq(),correo,contraseña);
    }else{
    r=Buscar(raiz.getHijoDer(),correo,contraseña);
    }}}
    return r;
    }
    
    public Nodo RotarIzq(Nodo raiz){
    Nodo aux=raiz.getHijoIzq();
    raiz.setHijoIzq(aux.getHijoDer());
    aux.setHijoDer(raiz);
    return aux;
    }
    public Nodo RotarDer(Nodo raiz){
    Nodo aux=raiz.getHijoDer();
    raiz.setHijoDer(aux.getHijoIzq());
    aux.setHijoIzq(raiz);
    return aux;
    }
    public Nodo RotarDobleIzq(Nodo raiz){
    raiz.setHijoIzq(RotarDer(raiz.getHijoIzq()));
    return RotarIzq(raiz);
    }
    public Nodo RotarDobleDer(Nodo raiz){
    raiz.setHijoDer(RotarIzq(raiz.getHijoDer()));
    return RotarDer(raiz);
    }
    public Nodo Insertar(Administrador administrador,Nodo raiz){
    String correoad="";
    String correoadri="";
    String correoadrd="";
    if(raiz==null){
    raiz=new Nodo(administrador);
    System.out.println("Insertado " + administrador.getCorreo());
    }
    else{
    correoad=administrador.getCorreo();
    correoadri=raiz.getAdministrador().getCorreo();
    correoadrd=raiz.getAdministrador().getCorreo();
    int opcion1=correoad.compareTo(correoadri);
    int opcion2=correoad.compareTo(correoadrd);
    if(opcion1<0){
    raiz.setHijoIzq(Insertar(administrador,raiz.getHijoIzq()));
    int hizq=Nodo.Altura(raiz.getHijoIzq())+1;
    int hder=Nodo.Altura(raiz.getHijoDer())+1;
    System.out.println(raiz.getAdministrador().getCorreo()+" hijo izq "+hizq);
    System.out.println(raiz.getAdministrador().getCorreo()+" hijo der "+hder);
    if(((hizq)-(hder))==2){
      String dato=administrador.getCorreo();
      String datoizq=raiz.getHijoIzq().getAdministrador().getCorreo();
     if(dato.compareTo(datoizq)<0){
     System.out.println(administrador.getCorreo()+" Caso 1");
     raiz=RotarIzq(raiz);
     }
     else{
        System.out.println(administrador.getCorreo()+" Caso 2");
        raiz=RotarDobleIzq(raiz);
     }
    }
    }
    else if(opcion2>0){
    raiz.setHijoDer(Insertar(administrador,raiz.getHijoDer()));   
    int hizq=Nodo.Altura(raiz.getHijoIzq())+1;
    int hder=Nodo.Altura(raiz.getHijoDer())+1;
    System.out.println(raiz.getAdministrador().getCorreo()+" hijo izq "+hizq);
    System.out.println(raiz.getAdministrador().getCorreo()+" hijo der "+hder);
    if(((-hizq)+(hder))==2){
      String dato=administrador.getCorreo();
      String datoder=raiz.getHijoDer().getAdministrador().getCorreo();
    if(dato.compareTo(datoder)>0){
    System.out.println(administrador.getCorreo()+" Caso 3");
    raiz=RotarDer(raiz);
    }else{
    System.out.println(administrador.getCorreo()+" Caso 4");
    raiz=RotarDobleDer(raiz);
    }
    }
    }
    }
    
    
    return raiz;    
    }
    
    public Nodo HijoMasDerecha(Nodo raiz,Nodo Padre){
    Nodo hijo=null;
    if(raiz.getHijoDer()==null){
    if(raiz.getHijoIzq()!=null && Padre.getHijoIzq()!=raiz){
    Padre.setHijoDer(raiz.getHijoIzq());
    raiz.setHijoIzq(null);
    }else if(raiz.getHijoIzq()==null){
    if(Padre.getHijoDer()==raiz){
    Padre.setHijoDer(null);}
    }
    else if(raiz.getHijoIzq()!=null && Padre.getHijoIzq()==raiz){
    Padre.setHijoIzq(raiz.getHijoIzq());
    raiz.setHijoIzq(null);
    }
    hijo=raiz;
    }else{
    hijo=HijoMasDerecha(raiz.getHijoDer(),raiz);
    }
    return hijo;
    }
    public Nodo HijoMasIzquierda(Nodo raiz,Nodo Padre){
    Nodo hijo=null;
    if(raiz.getHijoIzq()==null){
    if(raiz.getHijoDer()!=null){
    Padre.setHijoIzq(raiz.getHijoDer());
    raiz.setHijoDer(null);
    }    
    hijo=raiz;
    }else{
    hijo=HijoMasIzquierda(raiz.getHijoIzq(),raiz);
    }
    return hijo;
    }
    
    public void EliminarNodo(String correo){
    this.setRaiz(Eliminar(getRaiz(),correo));
    this.setRaiz(EquilibrarTrasEliminar(getRaiz(),correo));
    }
    public Nodo Eliminar(Nodo raiz,String correo){
    Nodo i=null;
    if(raiz!=null){
    if(raiz.getAdministrador().getCorreo().equals(correo)){
    if(raiz.getHijoDer()==null && raiz.getHijoIzq()==null){
    i=null;
    }
    else if(raiz.getHijoDer()!=null && raiz.getHijoIzq()==null){
    i=raiz.getHijoDer();
    }
    else if(raiz.getHijoDer()==null && raiz.getHijoIzq()!=null){
    i=raiz.getHijoIzq();
    }
    else if(raiz.getHijoDer()!=null && raiz.getHijoIzq()!=null){
    Nodo aux=HijoMasDerecha(raiz.getHijoIzq(),raiz);
    Nodo aux2=raiz;
    if(aux!=raiz.getHijoIzq()){
    aux.setHijoIzq(raiz.getHijoIzq());}
    aux.setHijoDer(raiz.getHijoDer());
    i= aux;
    i.setHijoIzq(EquilibrarTrasEliminar(i.getHijoIzq(),i.getAdministrador().getCorreo()));
    
    } } 
    else{
    if(correo.compareTo(raiz.getAdministrador().getCorreo())<0){
    if(raiz.getHijoIzq()!=null){
    raiz.setHijoIzq(Eliminar(raiz.getHijoIzq(),correo));   
    i=EquilibrarTrasEliminar(raiz,correo);
    //i=raiz;
    }else{
    i=raiz;
    }
    }else{
    if(raiz.getHijoDer()!=null){
    raiz.setHijoDer(Eliminar(raiz.getHijoDer(),correo));
    i=EquilibrarTrasEliminar(raiz,correo);
    //i=raiz;
    }
    else{
    i=raiz;
    } }  }  }
    //i=EquilibrarTrasEliminar(i,correo);
    return i;
    }
public Nodo EquilibrarTrasEliminar(Nodo raiz,String correo){
    if(raiz!=null){
    int hizq=Nodo.Altura(raiz.getHijoIzq())+1;
    int hder=Nodo.Altura(raiz.getHijoDer())+1;
    if(((hizq)-(hder))==2){
      String dato=correo;
      String datoizq=raiz.getHijoIzq().getAdministrador().getCorreo();
     //if(dato.compareTo(datoizq)<0){
     //raiz=RotarIzq(raiz);
     //}
     //else{
     //raiz=RotarDobleIzq(raiz);
     //}
      if(raiz.getHijoIzq().getHijoIzq()!=null){
      raiz=RotarIzq(raiz);
      }
      else{
      raiz=RotarDobleIzq(raiz);
      }
    }
    if(((-hizq)+(hder))==2){
      String dato=correo;
      String datoder=raiz.getHijoDer().getAdministrador().getCorreo();
    //if(dato.compareTo(datoder)>0){
    //raiz=RotarDer(raiz);
    //}else{
    //raiz=RotarDobleDer(raiz);
    //}
    if(raiz.getHijoDer().getHijoDer()!=null){
    raiz=RotarDer(raiz);
    }
    else{
    raiz=RotarDobleDer(raiz);
    }
    }
       
    if(raiz.getAdministrador().getCorreo().equals(correo)){
    System.out.println("Nodo Existente revisar");
    }else{
    if(correo.compareTo(raiz.getAdministrador().getCorreo())<0){
    if(raiz.getHijoIzq()!=null){raiz.setHijoIzq(EquilibrarTrasEliminar(raiz.getHijoIzq(),correo));}
    }else{
    if(raiz.getHijoDer()!=null){raiz.setHijoDer(EquilibrarTrasEliminar(raiz.getHijoDer(),correo));}
    }}}
    return raiz;
    }
    public void EliminarAdministrador(String correo){
    this.setRaiz(Eliminar(getRaiz(),correo));
    this.setRaiz(EquilibrarTrasEliminar(getRaiz(),correo));
    }
    
    public String CodigoGrapvhiz(Nodo actual, Nodo Padre,int numero){
    String salida="";
   
    if(actual!=null){
    int na=actual.getAdministrador().getCorreo().hashCode();
    if(na<0){na=na*(-1);}
    
    if(Padre==null){
    salida+="nodo"+(na)+" [ label =\""+actual.getAdministrador().getCorreo()+","+actual.getAdministrador().getContraseña()+"\"];\n";
    numero++;
    }else{
    int np=Padre.getAdministrador().getCorreo().hashCode();    
    if(np<0){np=np*(-1);}
    if(Padre.getHijoIzq()==actual){
    salida+="nodo"+(na)+" [ label =\""+actual.getAdministrador().getCorreo()+","+actual.getAdministrador().getContraseña()+"\"];\n";   
    salida+="nodo"+(np) +" -> nodo"+(na)+";\n" ;
    numero++;
    }
    else if(Padre.getHijoDer()==actual){
    salida+="nodo"+(na)+" [ label =\""+actual.getAdministrador().getCorreo()+","+actual.getAdministrador().getContraseña()+"\"];\n";   
    salida+="nodo"+(np)+" -> nodo"+(na)+";\n" ;
    numero++;
    }
    }
    if(actual.getHijoIzq()!=null){
    salida+=CodigoGrapvhiz(actual.getHijoIzq(),actual,numero);
    }
    if(actual.getHijoDer()!=null){
    salida+=CodigoGrapvhiz(actual.getHijoDer(),actual,numero);
    }
    }
    return salida;
    }
    
    public void CrearImagenArbol(){
    try {
        String codigo="digraph grafica{\n" +
        "rankdir=TB;\n" +
        "node [shape = record, style=filled, fillcolor=seashell2];";
        codigo+=CodigoGrapvhiz(getRaiz(),null,0);
        codigo+="\n}";
        String ruta = "C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\ArbolAdministrador.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(codigo);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(codigo);
        }
        bw.close();
        
      String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
      
      String fileInputPath = "C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\ArbolAdministrador.txt";
      String fileOutputPath = "C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\ArbolAdministrador.jpg";
      
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
    }
    }
}
