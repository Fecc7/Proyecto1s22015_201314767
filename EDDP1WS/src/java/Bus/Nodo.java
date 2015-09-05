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
public class Nodo {
    Bus objeto;
    Nodo siguiente=null,anterior=null;
    
    public Nodo(Bus objeto){
    this.objeto=objeto;
    
    }

    public Bus getObjeto() {
        return objeto;
    }

    public void setObjeto(Bus objeto) {
        this.objeto = objeto;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
}
