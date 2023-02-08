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
    @NotNull(message = "{user.name.empty}")
    @Size(min = 5,max = 50, message = "La cantidad de caracteres del nombre deber estar entre 5 y 50")
    private String nombre;

    @NotEmpty
    @NotNull
    @Size(min = 5,max = 50, message = "La cantidad de caracteres del apellido deber estar entre 5 y 50")
    private String apellido;

    @Email(message = "Debe seguir un formato adecuado")
    @NotNull
    private String email;

    @NotEmpty
    @NotNull
    // @Size(min = 10)
    // @Phone
    @Pattern(message = "El teléfono debe empezar por 5 y tener 10 dígitos",regexp = "[5][0-9]{9}")
    private String telefono;

    @NotEmpty
    @NotNull
    @Size(min = 10,max = 20, message = "La cantidad de caracteres del usuario deber estar entre 10 y 20")
    private String usuario;

    @NotEmpty
    @NotNull
    @Size(min = 10,max = 20, message = "La cantidad de caracteres de la contraseña deber estar entre 10 y 20")
    private String clave;

    public ClienteDTO(){}
}
