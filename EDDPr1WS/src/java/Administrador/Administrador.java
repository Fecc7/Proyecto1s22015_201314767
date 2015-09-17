package Administrador;

public class Administrador {

    String correo="";
    String contraseña="";
    public Administrador(String correo,String contraseña){
    this.correo=correo;
    this.contraseña=contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}

