/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

import java.util.ArrayList;

/**
 *
 * @author Francis
 */
public class Rutas {
    ArrayList<Lista> nuevo=new ArrayList<>();
    
    public void AgregarRuta(Lista a){
    if(Existe(a.nombre)==null){
    nuevo.add(a);
    }
    }
    
    public Lista Existe(String nombre){
    Lista e=null;
    for(Lista a:nuevo){
    if(a.nombre.equals(nombre)){
    e=a;
    }
    }
    return e;
    }
    
    public void Eliminar(String nombre){
    Lista e=null;
    for(Lista a:nuevo){
    if(a.nombre.equals(nombre)){
    e=a;
    }
    }
    if(e!=null){
    nuevo.remove(e);}
    }
    
}
