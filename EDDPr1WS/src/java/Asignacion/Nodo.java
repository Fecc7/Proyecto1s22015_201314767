/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignacion;

/**
 *
 * @author Francis
 */
public class Nodo {
    Asignacion objeto;
    Nodo siguiente=null,anterior=null;
    
    public Nodo(Asignacion objeto){
    this.objeto=objeto;
    
    }

    public Asignacion getObjeto() {
        return objeto;
    }

    public void setObjeto(Asignacion objeto) {
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

