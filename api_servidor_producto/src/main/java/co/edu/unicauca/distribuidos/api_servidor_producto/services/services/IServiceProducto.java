package co.edu.unicauca.distribuidos.api_servidor_producto.services.services;

import co.edu.unicauca.distribuidos.api_servidor_producto.services.DTO.ProductoDTO;
import java.util.List;

public interface IServiceProducto {
    //Registrar un producto
    public ProductoDTO createProduct(ProductoDTO admin);
    //Obtener todos los productos
    public List<ProductoDTO> findAll();
    //Obtener un producto por estado
    public List<ProductoDTO> findAllByState();
    //Obtener un producto especifico
    public ProductoDTO findById(int code);
    //Editar un producto
    public ProductoDTO update(int code, ProductoDTO product);
    //Actualizar el valor de un producto
    public ProductoDTO updateValue(int code, long valor);
    //Eliminar un producto
    public boolean delete (int code);
}
