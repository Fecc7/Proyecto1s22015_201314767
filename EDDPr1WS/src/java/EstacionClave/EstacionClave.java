package EstacionClave;


public class EstacionClave {
    int id;
    String contraseña=null,nombre=null;
    
    public EstacionClave(int id,String contraseña,String nombre){
    this.id=id;
    this.contraseña=contraseña;
    this.nombre=nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
