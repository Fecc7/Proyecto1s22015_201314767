/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

/**
 *
 * @author Francis
 */
public class Nodo {
    EstacionClave.EstacionClave objeto=null;
    EstacionGeneral.EstacionGeneral objeto2=null;
    Nodo siguiente=null,anterior=null;
    
    public Nodo(EstacionClave.EstacionClave objeto){
    this.objeto=objeto;
    }
    
    public Nodo(EstacionGeneral.EstacionGeneral objeto2){
    this.objeto2=objeto2;
    }

    public EstacionClave.EstacionClave getObjeto() {
        return objeto;
    }

    public void setObjeto(EstacionClave.EstacionClave objeto) {
        this.objeto = objeto;
    }

    public EstacionGeneral.EstacionGeneral getObjeto2() {
        return objeto2;
    }

    public void setObjeto2(EstacionGeneral.EstacionGeneral objeto2) {
        this.objeto2 = objeto2;
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
