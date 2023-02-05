package main.java.co.edu.unicauca.distribuidos.api_servidor_login.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor
public class ClienteEntity {
    @NotEmpty
    @NotNull
    @Size(min = 5,max = 50)
    private String nombre;

    @NotEmpty
    @NotNull
    @Size(min = 5,max = 50)
    private String apellido;

    @Email
    @NotNull
    private String email;

    @NotEmpty
    @NotNull
    // @Size(min = 10)
    // @Phone
    @Pattern(regexp = "[5][0-10]{9}")
    private String telefono;

    @NotEmpty
    @NotNull
    @Size(min = 10,max = 20)
    private String usuario;

    @NotEmpty
    @NotNull
    @Size(min = 10,max = 20)
    private String clave;

    public ClienteEntity (){}
}
