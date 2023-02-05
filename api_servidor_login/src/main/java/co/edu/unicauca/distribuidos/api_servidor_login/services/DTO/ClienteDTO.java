package co.edu.unicauca.distribuidos.api_servidor_login.services.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

    public ClienteDTO(){}
}
