/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

/**
 *
 * @author Francis
 */
public class Lista {
 
    Nodo inicio=null;
    Nodo ultimo=null;
    int q;
    
    public void Añadir(Bus b){
    Nodo nuevo=new Nodo(b);
    setInicio(nuevo);
    }
    
    public void MMMMM(int q){
    this.q=q;
    }
    public void Agregar(Bus o){
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
    }
    }
    
    public void Eliminar(Nodo n){
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
    
    
}
