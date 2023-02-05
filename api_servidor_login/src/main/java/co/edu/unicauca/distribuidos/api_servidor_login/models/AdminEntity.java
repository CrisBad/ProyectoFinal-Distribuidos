package co.edu.unicauca.distribuidos.api_servidor_login.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor
public class AdminEntity {

    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;

    public AdminEntity(){}
}
