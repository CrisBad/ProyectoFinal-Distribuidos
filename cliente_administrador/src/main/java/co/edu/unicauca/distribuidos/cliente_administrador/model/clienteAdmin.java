package co.edu.unicauca.distribuidos.cliente_administrador.model;
import java.util.Date;
public class clienteAdmin {
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;

    public clienteAdmin(){
        
    }
    public clienteAdmin(String nombre, String apellido, String usuario, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.clave = clave;
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
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String username) {
        this.usuario = username;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String password) {
        this.clave = password;
    }
    
    

}
