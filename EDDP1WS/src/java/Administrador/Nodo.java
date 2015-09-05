package Administrador;

public class Nodo {

    Administrador administrador;
    Nodo hijoIzq=null,hijoDer=null;
    int alturaizq=0,alturader=0,fe=0;
    public Nodo(Administrador nuevo){
    administrador=nuevo;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }
    public boolean equilibrio(){
    boolean equilibrio=true;
    int fe=alturader-alturaizq;
    if(fe<(-1) || fe>1){
    equilibrio=false;
    }
    return equilibrio;
    }
    public static int Altura(Nodo raiz){
        if(raiz==null){
        return -1;
        }else{
        if(raiz.getHijoDer()!=null && raiz.getHijoIzq()!=null){
        int c=1+Altura(raiz.getHijoIzq());
        raiz.setAlturaizq(c);
        int d=1+Altura(raiz.getHijoDer());
        raiz.setAlturader(d);
        int a=0;
        int i=raiz.getAlturaizq(),de=raiz.getAlturader();
        if(i!=de){
        if(i>de){
        a= i;
        }
        else{
        a=de;
        }
        }
        else{
        a=i;
        }
        System.out.println(raiz.getAdministrador().getCorreo()+" "+raiz.getFe());
        return a;
        }
        else if(raiz.getHijoDer()!=null){
        int a=Altura(raiz.getHijoDer());
        raiz.setAlturader(1+a);    
        System.out.println(raiz.getAdministrador().getCorreo()+" "+raiz.getFe());
        return raiz.getAlturader();
        }
        else if(raiz.getHijoIzq()!=null){
        int a=Altura(raiz.getHijoIzq());    
        raiz.setAlturaizq(1+a);    
        System.out.println(raiz.getAdministrador().getCorreo()+" "+raiz.getFe());
        return raiz.getAlturaizq();
        }
        else{
        //setAlturaizq(0);
        //setAlturader(0);
        System.out.println(raiz.getAdministrador().getCorreo()+" "+raiz.getFe());
        return 0;
        }     } 
        }
    public int getAlturaizq() {
        return alturaizq;
    }

    public void setAlturaizq(int alturaizq) {
        this.alturaizq = alturaizq;
    }

    public int getAlturader() {
        return alturader;
    }

    public void setAlturader(int alturader) {
        this.alturader = alturader;
    }

    public int getFe() {
        fe=getAlturader()-getAlturaizq();
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }
    
 }
