package main.java.co.edu.unicauca.distribuidos.api_servidor_login.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter 
@Setter 
@AllArgsConstructor
public class AdminEntity {
    @Size(min = 5, max = 50)
    private String nombre;
    @Size(min = 5, max = 50)
    private String apellido;
    @Size(min = 10, max = 20)
    private String usuario;
    @Size(min = 10, max = 20)
    private String clave;

    public AdminEntity(){}
}
