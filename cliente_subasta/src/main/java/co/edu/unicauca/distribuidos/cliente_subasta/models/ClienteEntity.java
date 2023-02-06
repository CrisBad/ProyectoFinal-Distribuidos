package co.edu.unicauca.distribuidos.cliente_subasta.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor
public class ClienteEntity {
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String usuario;
    private String clave;

    public ClienteEntity(){}

}
