package Administrador;

public final class ArbolAVL {


    Nodo raiz=null;
    public ArbolAVL(){
    raiz=null; 
    }    

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public void Agregar(Administrador administrador){
    setRaiz(Insertar(administrador,getRaiz()));
    }
    
    public boolean Buscar(Nodo raiz,String correo,String contraseña){
    boolean r=false;
    if(raiz!=null){
    if(raiz.getAdministrador().getCorreo().equals(correo)){
    if(raiz.getAdministrador().getContraseña().equals(contraseña)){
        r=true;
    }}
    else if(correo.compareTo(raiz.getAdministrador().getCorreo())<0){
    r=Buscar(raiz.getHijoIzq(),correo,contraseña);
    }
    else{
    r=Buscar(raiz.getHijoDer(),correo,contraseña);
    }}
    return r;
    }
    
    public Nodo RotarIzq(Nodo raiz){
    Nodo aux=raiz.getHijoIzq();
    raiz.setHijoIzq(aux.getHijoDer());
    aux.setHijoDer(raiz);
    return aux;
    }
    public Nodo RotarDer(Nodo raiz){
    Nodo aux=raiz.getHijoDer();
    raiz.setHijoDer(aux.getHijoIzq());
    aux.setHijoIzq(raiz);
    return aux;
    }
    public Nodo RotarDobleIzq(Nodo raiz){
    raiz.setHijoIzq(RotarDer(raiz.getHijoIzq()));
    return RotarIzq(raiz);
    }
    public Nodo RotarDobleDer(Nodo raiz){
    raiz.setHijoDer(RotarIzq(raiz.getHijoDer()));
    return RotarDer(raiz);
    }
    public Nodo Insertar(Administrador administrador,Nodo raiz){
    String correoad="";
    String correoadri="";
    String correoadrd="";
    if(raiz==null){
    raiz=new Nodo(administrador);
    System.out.println("Insertado " + administrador.getCorreo());
    }
    else{
    correoad=administrador.getCorreo();
    correoadri=raiz.getAdministrador().getCorreo();
    correoadrd=raiz.getAdministrador().getCorreo();
    int opcion1=correoad.compareTo(correoadri);
    int opcion2=correoad.compareTo(correoadrd);
    if(opcion1<0){
    raiz.setHijoIzq(Insertar(administrador,raiz.getHijoIzq()));
    int hizq=Nodo.Altura(raiz.getHijoIzq())+1;
    int hder=Nodo.Altura(raiz.getHijoDer())+1;
    System.out.println(raiz.getAdministrador().getCorreo()+" hijo izq "+hizq);
    System.out.println(raiz.getAdministrador().getCorreo()+" hijo der "+hder);
    if(((hizq)-(hder))==2){
      String dato=administrador.getCorreo();
      String datoizq=raiz.getHijoIzq().getAdministrador().getCorreo();
     if(dato.compareTo(datoizq)<0){
     System.out.println(administrador.getCorreo()+" Caso 1");
     raiz=RotarIzq(raiz);
     }
     else{
        System.out.println(administrador.getCorreo()+" Caso 2");
        raiz=RotarDobleIzq(raiz);
     }
    }
    }
    else if(opcion2>0){
    raiz.setHijoDer(Insertar(administrador,raiz.getHijoDer()));   
    int hizq=Nodo.Altura(raiz.getHijoIzq())+1;
    int hder=Nodo.Altura(raiz.getHijoDer())+1;
    System.out.println(raiz.getAdministrador().getCorreo()+" hijo izq "+hizq);
    System.out.println(raiz.getAdministrador().getCorreo()+" hijo der "+hder);
    if(((-hizq)+(hder))==2){
      String dato=administrador.getCorreo();
      String datoder=raiz.getHijoDer().getAdministrador().getCorreo();
    if(dato.compareTo(datoder)>0){
    System.out.println(administrador.getCorreo()+" Caso 3");
    raiz=RotarDer(raiz);
    }else{
    System.out.println(administrador.getCorreo()+" Caso 4");
    raiz=RotarDobleDer(raiz);
    }
    }
    }
    }
    
    
    return raiz;    
    }
}
