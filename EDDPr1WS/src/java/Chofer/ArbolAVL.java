/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chofer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public final class ArbolAVL {

    Nodo raiz=null;
    public ArbolAVL(){
    
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
    salida="raiz: "+actual.getChofer().getId()+"\n";
    }else{
    if(Padre.getHijoIzq()==actual){
    salida=Padre.getChofer().getId() +" Izq --> "+actual.getChofer().getId()+"\n" ;
    }
    else if(Padre.getHijoDer()==actual){
    salida=Padre.getChofer().getId() +" Der --> "+actual.getChofer().getId()+"\n" ;
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
    
    public void Agregar(Chofer chofer){
    setRaiz(Insertar(chofer,getRaiz()));
    }
    
    public Nodo Buscar(Nodo raiz,int id,String contraseña){
    Nodo r=null;
    System.out.println("Metodo Buscar");
    if(raiz!=null){
        System.out.println("Entro");
        System.out.println(raiz.getChofer().getId());
        System.out.println(id);
    if(raiz.getChofer().getId()==(id) && raiz.getChofer().getContraseña().equals(contraseña)){
    r=raiz;
    }else{
    if(id<raiz.getChofer().getId()){
    r=Buscar(raiz.getHijoIzq(),id,contraseña);
    }else{
    r=Buscar(raiz.getHijoDer(),id,contraseña);
    }}}
    return r;
    }
    
    public Nodo Buscar(Nodo raiz,int id){
    Nodo r=null;
    System.out.println("Metodo Buscar");
    if(raiz!=null){
        System.out.println("Entro");
        System.out.println(raiz.getChofer().getId());
        System.out.println(id);
    if(raiz.getChofer().getId()==(id)){
    r=raiz;
    }else{
    if(id<raiz.getChofer().getId()){
    r=Buscar(raiz.getHijoIzq(),id);
    }else{
    r=Buscar(raiz.getHijoDer(),id);
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
    public Nodo Insertar(Chofer chofer,Nodo raiz){
    int idad;
    int idadri;
    int idadrd;
    if(raiz==null){
    raiz=new Nodo(chofer);
    System.out.println("Insertado " + chofer.getId());
    }
    else{
    idad=chofer.getId();
    idadri=raiz.getChofer().getId();
    idadrd=raiz.getChofer().getId();
    /*int opcion1=idad.compareTo(idadri);
    int opcion2=idad.compareTo(idadrd);*/
    if(chofer.getId()<raiz.getChofer().getId()){
    raiz.setHijoIzq(Insertar(chofer,raiz.getHijoIzq()));
    int hizq=Nodo.Altura(raiz.getHijoIzq())+1;
    int hder=Nodo.Altura(raiz.getHijoDer())+1;
    System.out.println(raiz.getChofer().getId()+" hijo izq "+hizq);
    System.out.println(raiz.getChofer().getId()+" hijo der "+hder);
    if(((hizq)-(hder))==2){
      /*String dato=chofer.getId();
      String datoizq=raiz.getHijoIzq().getChofer().getId();*/
     if(chofer.getId()<raiz.getHijoIzq().getChofer().getId()){
     System.out.println(chofer.getId()+" Caso 1");
     raiz=RotarIzq(raiz);
     }
     else{
        System.out.println(chofer.getId()+" Caso 2");
        raiz=RotarDobleIzq(raiz);
     }
    }
    }
    else if(chofer.getId()>raiz.getChofer().getId()){
    raiz.setHijoDer(Insertar(chofer,raiz.getHijoDer()));   
    int hizq=Nodo.Altura(raiz.getHijoIzq())+1;
    int hder=Nodo.Altura(raiz.getHijoDer())+1;
    System.out.println(raiz.getChofer().getId()+" hijo izq "+hizq);
    System.out.println(raiz.getChofer().getId()+" hijo der "+hder);
    if(((-hizq)+(hder))==2){
      /*String dato=chofer.getId();
      String datoder=raiz.getHijoDer().getChofer().getId();*/
    if(chofer.getId()>raiz.getHijoDer().getChofer().getId()){
    System.out.println(chofer.getId()+" Caso 3");
    raiz=RotarDer(raiz);
    }else{
    System.out.println(chofer.getId()+" Caso 4");
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
    
    public void EliminarNodo(int id){
    this.setRaiz(Eliminar(getRaiz(),id));
    this.setRaiz(EquilibrarTrasEliminar(getRaiz(),id));
    }
    public Nodo Eliminar(Nodo raiz,int id){
    Nodo i=null;
    if(raiz!=null){
    if(raiz.getChofer().getId()==(id)){
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
    i.setHijoIzq(EquilibrarTrasEliminar(i.getHijoIzq(),i.getChofer().getId()));
    } } 
    else{
    if(id<raiz.getChofer().getId()){
    if(raiz.getHijoIzq()!=null){
    raiz.setHijoIzq(Eliminar(raiz.getHijoIzq(),id));   
    i=EquilibrarTrasEliminar(raiz,id);
    //i=raiz;
    }else{
    i=raiz;
    }
    }else{
    if(raiz.getHijoDer()!=null){
    raiz.setHijoDer(Eliminar(raiz.getHijoDer(),id));
    i=EquilibrarTrasEliminar(raiz,id);
    //i=raiz;
    }
    else{
    i=raiz;
    } }  }  }
    return i;
    }
public Nodo EquilibrarTrasEliminar(Nodo raiz,int id){
    if(raiz!=null){
    int hizq=Nodo.Altura(raiz.getHijoIzq())+1;
    int hder=Nodo.Altura(raiz.getHijoDer())+1;
    if(((hizq)-(hder))==2){
      //String dato=id;
      //String datoizq=raiz.getHijoIzq().getChofer().getId();
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
      //String dato=id;
      //String datoder=raiz.getHijoDer().getChofer().getId();
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
       
    if(raiz.getChofer().getId()==(id)){
    System.out.println("Nodo Existente revisar");
    }else{
    if(id<(raiz.getChofer().getId())){
    if(raiz.getHijoIzq()!=null){raiz.setHijoIzq(EquilibrarTrasEliminar(raiz.getHijoIzq(),id));}
    }else{
    if(raiz.getHijoDer()!=null){raiz.setHijoDer(EquilibrarTrasEliminar(raiz.getHijoDer(),id));}
    }}}
    return raiz;
    }
    public void EliminarChofer(int id){
    this.setRaiz(Eliminar(getRaiz(),id));
    this.setRaiz(EquilibrarTrasEliminar(getRaiz(),id));
    }
    
    public String CodigoGrapvhiz(Nodo actual, Nodo Padre,int numero){
    String salida="";
   
    if(actual!=null){
    int na=actual.getChofer().getId();
    if(na<0){na=na*(-1);}
    
    if(Padre==null){
    salida+="nodo"+(na)+" [ label =\""+actual.getChofer().getId()+","+actual.getChofer().getNombre()+","+actual.getChofer().getContraseña()+"\"];\n";
    numero++;
    }else{
    int np=Padre.getChofer().getId();    
    if(np<0){np=np*(-1);}
    if(Padre.getHijoIzq()==actual){
    salida+="nodo"+(na)+" [ label =\""+actual.getChofer().getId()+","+actual.getChofer().getNombre()+","+actual.getChofer().getContraseña()+"\"];\n";   
    salida+="nodo"+(np) +" -> nodo"+(na)+";\n" ;
    numero++;
    }
    else if(Padre.getHijoDer()==actual){
    salida+="nodo"+(na)+" [ label =\""+actual.getChofer().getId()+","+actual.getChofer().getNombre()+","+actual.getChofer().getContraseña()+"\"];\n";   
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
        String ruta = "C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\ArbolChofer.txt";
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
      
      String fileInputPath = "C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\ArbolChofer.txt";
      String fileOutputPath = "C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\ArbolChofer.jpg";
      
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
