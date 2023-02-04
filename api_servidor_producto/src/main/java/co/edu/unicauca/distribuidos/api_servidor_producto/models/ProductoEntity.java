package co.edu.unicauca.distribuidos.api_servidor_producto.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductoEntity {
    
    private int code;
    private String name;
    private long initValue;
    private State state;
    
    public ProductoEntity() {
    }
}
