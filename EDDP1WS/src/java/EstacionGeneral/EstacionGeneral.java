/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionGeneral;

/**
 *
 * @author Francis
 */
public class EstacionGeneral {
    int id;
    String nombre=null,contraseña=null;

    public EstacionGeneral(int id,String nombre,String contraseña){
    this.id=id;
    this.nombre=nombre;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
