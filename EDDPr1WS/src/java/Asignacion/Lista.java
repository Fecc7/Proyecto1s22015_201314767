package Asignacion;

    public class Lista {
 
    Nodo inicio=null;
    Nodo ultimo=null;
    
   
    public void Agregar(Asignacion o){
    if(Buscar(o.getBus(),o.getRuta(),o.getChofer(),o.getHo(),o.getHf(),o.getFecha())==null){    
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
    getInicio();
    }
    
    
    
    public Nodo Buscar(Bus.Nodo bus, Ruta.Lista ruta, Chofer.Nodo chofer, String ho, String hf, String fecha){
    Nodo resultado=null;
    for(Nodo i=getInicio();i!=null;i=i.getSiguiente()){
    if(i.getObjeto().comparar(bus.getObjeto().getId(), ruta.getNombre(), chofer.getChofer().getId(), ho, hf, fecha)==true){
    resultado=i;
    }
    }
    return resultado;
    }
   
    public Nodo Buscar(String bus,String ruta,int chofer,String ho,String hf,String fecha){
    Nodo resultado=null;
    for(Nodo i=getInicio();i!=null;i=i.getSiguiente()){
    if(i.getObjeto().getBus().getObjeto().getId().equals(bus) && i.getObjeto().getRuta().getNombre().equals(ruta) && i.getObjeto().getChofer().getChofer().getId()==chofer && i.getObjeto().getHo().equals(ho) && i.getObjeto().getHf().equals(hf) && i.getObjeto().getFecha().equals(fecha)){
    resultado=i;
    }
    }
    return resultado;
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
}
