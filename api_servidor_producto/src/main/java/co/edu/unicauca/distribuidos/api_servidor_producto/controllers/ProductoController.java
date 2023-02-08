package co.edu.unicauca.distribuidos.api_servidor_producto.controllers;

import co.edu.unicauca.distribuidos.api_servidor_producto.services.DTO.ProductoDTO;
import co.edu.unicauca.distribuidos.api_servidor_producto.services.services.IServiceProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductoController {
    
    @Autowired
    private IServiceProducto serviceProducto;
    

    @GetMapping("/")
    @ResponseBody
    public List<ProductoDTO> findAll(){
        return this.serviceProducto.findAll();
    }

    @GetMapping("/{code}")
    @ResponseBody
    public ProductoDTO findById(@PathVariable int code){
        return serviceProducto.findById(code);
    }

    @PostMapping("/")
    @ResponseBody
    public ProductoDTO create(@RequestBody ProductoDTO producto){
        return this.serviceProducto.createProduct(producto);
    }

    @GetMapping("/state")
    public List<ProductoDTO> findAllByState(){
        return this.serviceProducto.findAllByState();
    }

    @PutMapping("/{code}")
    @ResponseBody
    public ProductoDTO update(@RequestBody ProductoDTO producto, @PathVariable int code){
        ProductoDTO objProducto = null;
        ProductoDTO productoActual = this.serviceProducto.findById(code);
        if(productoActual != null){
            objProducto = this.serviceProducto.update(code,producto);
        }
        return objProducto;
    }

    @DeleteMapping("/{code}")
    @ResponseBody
    public boolean delete (@PathVariable int code){
        boolean bandera = false;
        ProductoDTO actual = this.serviceProducto.findById(code);
        if(actual != null){
            bandera = this.serviceProducto.delete(code);
        }
        return bandera;
    }

    @PostMapping("/oferta/{code}/{valor}")
    @ResponseBody
    public ProductoDTO updateValue(@PathVariable int code, @PathVariable long valor){
        // System.out.println("Entro al controller");
        ProductoDTO objProducto = null;
        ProductoDTO productoActual = this.serviceProducto.findById(code);
        if(productoActual != null){
            objProducto = this.serviceProducto.updateValue(code, valor);
        }
        return objProducto;
    }
}
