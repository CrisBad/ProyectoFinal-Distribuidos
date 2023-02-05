package main.java.co.edu.unicauca.distribuidos.api_servidor_login.services.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
// import lombok.experimental.FieldNameConstants;

@Getter 
@Setter 
@AllArgsConstructor
public class ClienteDTO {
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
    @Size(min = 10)
    @Phone
    private String telefono;

    @NotEmpty
    @NotNull
    @Size(min = 10,max = 20)
    private String usuario;

    @NotEmpty
    @NotNull
    @Size(min = 10,max = 20)
    private String clave;

    public ClienteDTO(){}
}
