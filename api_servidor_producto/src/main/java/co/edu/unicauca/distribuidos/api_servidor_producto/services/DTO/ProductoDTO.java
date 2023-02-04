package co.edu.unicauca.distribuidos.api_servidor_producto.services.DTO;

import co.edu.unicauca.distribuidos.api_servidor_producto.models.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductoDTO {
    
    private int code;
    private String name;
    private long initValue;
    private State state;

    public ProductoDTO() {
    }
}
