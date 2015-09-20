/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Francis
 */
public class Lista {
 
    Nodo inicio=null;
    Nodo ultimo=null;
    String nombre="";
   
    public Lista(String nombre){
    this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void Agregar(EstacionClave.EstacionClave o){
    if(Buscar(o.getId(),"Estacion Clave")==null){    
    Nodo nuevo =new Nodo(o);
    if(inicio==null){
    inicio=nuevo;
    ultimo=nuevo;
    }
    else{
     Nodo auxiliar = null;
    for(Nodo i=inicio;i!=null;i=i.siguiente){
    auxiliar=i;
    }
    auxiliar.setSiguiente(nuevo);
    nuevo.setAnterior(auxiliar);
    ultimo=nuevo;
    }}
    }
    
    public void Agregar(EstacionGeneral.EstacionGeneral o){
    if(Buscar(o.getId(),"Estacion General")==null){    
    Nodo nuevo =new Nodo(o);
    if(inicio==null){
    inicio=nuevo;
    ultimo=nuevo;
    }
    else{
    Nodo auxiliar = null;
    for(Nodo i=inicio;i!=null;i=i.siguiente){
    auxiliar=i;
    }
    auxiliar.setSiguiente(nuevo);
    nuevo.setAnterior(auxiliar);
    ultimo=nuevo;
    }}
    }
    
    public Nodo Buscar(int id,String tipo){
    Nodo resultado=null;
    Nodo resultado2=null;
    for(Nodo i=getInicio();i!=null;i=i.getSiguiente()){
        if(tipo.equals("Estacion Clave")){
                if(i.getObjeto()!=null){
                if(i.getObjeto().getId()==id){
                    resultado=i;
                } }
        }else{
                if(i.getObjeto2()!=null){
                if(i.getObjeto2().getId()==id){
                resultado2=i;  }}
        }    
    }
    if(tipo.equals("Estacion Clave")){
    return resultado;
    }
    else{
    return resultado2;
    }
    }
    
    
    public void Eliminar(Nodo n){
     if(n!=null){
     if(getInicio()==n && getUltimo()==n){
     setInicio(null);
     setUltimo(null);
     }   
     else if(getInicio()==n){
     setInicio(getInicio().getSiguiente());
     getInicio().setAnterior(null);
     }
     else if(getUltimo()==n){
     setUltimo(getUltimo().getAnterior());
     getUltimo().setSiguiente(null);
     }
     else{
     Nodo aux = inicio;
     Nodo ant = null;
     for (Nodo i=aux;i!=null;i=i.getSiguiente()){
     if(i==n){
     if(ant !=null){
     ant.setSiguiente(i.getSiguiente());
     i.getSiguiente().setAnterior(ant);
     }
     }
     ant=i;
     }
     }
     }
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }
    
    public void GraficarLista(){
    String tipo=nombre;
    Nodo inicio=null;
    inicio=this.getInicio();
   
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
    
    for(Nodo i=this.getInicio();i!=null;i=i.getSiguiente()){
    if(i.getObjeto()!=null){    
    nodos+="node"+x+"[label=\"<f0> "+x+"|"+i.getObjeto().getId()+"\"];\n";
    x++;
    }
    else if(i.getObjeto2()!=null){
    nodos+="node"+x+"[label=\"<f0> "+x+"|"+i.getObjeto2().getId()+"\"];\n";
    x++;
    }
    
    }
    x=0;
    
    for(Nodo i=this.getInicio();i!=null;i=i.getSiguiente()){
    if(i.getSiguiente()!=null){
    nodos+="node"+x+"->node"+(x+1)+";\n";
    }    
    if(i.getAnterior()!=null){
    nodos+="node"+(x)+"->node"+(x-1)+";\n";
    }
    x++;
    }
    
    
    nodos+="}rank=same subgraph d{ \n" +
" }\n" +
"}";
FileWriter fichero=null;
    PrintWriter pw=null;
    try{
    fichero=new FileWriter("C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\Ruta.txt");
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
      
      String fileInputPath = "C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\Ruta.txt";
      //String fileInputPath="/media/francis/D844D27F44D26034/Users/Francis/Mis documentos/GitHub/Proyecto1s22015_201314767/EDDPr1AW/web/images/lista.txt";
      String fileOutputPath = "C:\\Users\\Francis\\Documents\\GitHub\\Proyecto1s22015_201314767\\EDDPr1AW\\web\\images\\Ruta.jpg";
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
}
