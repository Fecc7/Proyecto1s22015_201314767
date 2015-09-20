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
public class Asignacion {
 Bus.Nodo bus;
 Ruta.Lista ruta;
 Chofer.Nodo chofer;
 String ho,hf,fecha;

    public Asignacion(Bus.Nodo bus, Ruta.Lista ruta, Chofer.Nodo chofer, String ho, String hf, String fecha) {
        this.bus = bus;
        this.ruta = ruta;
        this.chofer = chofer;
        this.ho = ho;
        this.hf = hf;
        this.fecha = fecha;
    }

    public Bus.Nodo getBus() {
        return bus;
    }

    public void setBus(Bus.Nodo bus) {
        this.bus = bus;
    }

    public Ruta.Lista getRuta() {
        return ruta;
    }

    public void setRuta(Ruta.Lista ruta) {
        this.ruta = ruta;
    }

    public Chofer.Nodo getChofer() {
        return chofer;
    }

    public void setChofer(Chofer.Nodo chofer) {
        this.chofer = chofer;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getHf() {
        return hf;
    }

    public void setHf(String hf) {
        this.hf = hf;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public boolean comparar(String bus,String ruta,int chofer,String ho,String hf,String fecha){
    boolean i=false;
        if(this.bus.getObjeto().getId().equals(bus) && this.ruta.getNombre().equals(ruta) && this.chofer.getChofer().getId()== chofer && this.ho.equals(ho) && this.hf.equals(hf) && this.fecha.equals(fecha)){
        i=true;
        }
    return i;
    }
 
}
