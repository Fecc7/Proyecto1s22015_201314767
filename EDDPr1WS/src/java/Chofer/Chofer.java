/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chofer;

/**
 *
 * @author Francis
 */
public class Chofer {
    int id;
    String nombre=null;
    String apellido=null;
    String contraseña=null;
    public Chofer(int id,String nombre,String apellido,String contraseña){
    this.id=id;
    this.nombre=nombre;
    this.apellido=apellido;
    this.contraseña=contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
