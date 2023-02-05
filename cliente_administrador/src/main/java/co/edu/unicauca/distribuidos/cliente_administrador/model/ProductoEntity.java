package co.edu.unicauca.distribuidos.cliente_administrador.model;

public class ProductoEntity {
     
    private int code;
    private String name;
    private long initValue;
    private State state;
    
    public ProductoEntity() {
    }

    public ProductoEntity(int code, String name, long initValue, State state) {
        this.code = code;
        this.name = name;
        this.initValue = initValue;
        this.state = state;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getInitValue() {
        return initValue;
    }

    public void setInitValue(long initValue) {
        this.initValue = initValue;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    
}
