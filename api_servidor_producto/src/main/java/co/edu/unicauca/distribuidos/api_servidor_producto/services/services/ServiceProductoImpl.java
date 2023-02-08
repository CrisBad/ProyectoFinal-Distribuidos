package co.edu.unicauca.distribuidos.api_servidor_producto.services.services;

import co.edu.unicauca.distribuidos.api_servidor_producto.models.ProductoEntity;
import co.edu.unicauca.distribuidos.api_servidor_producto.repositories.ProductoRepository;
import co.edu.unicauca.distribuidos.api_servidor_producto.services.DTO.ProductoDTO;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceProductoImpl implements IServiceProducto {

    //Inyeccion de dependencias
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductoDTO createProduct(ProductoDTO producto) {
        ProductoEntity objEntity = this.modelMapper.map(producto,ProductoEntity.class);
        ProductoEntity objProductoEntity = this.productoRepository.save(objEntity);
        ProductoDTO productoDTO = this.modelMapper.map(objProductoEntity,ProductoDTO.class);
        return productoDTO;
    }

    @Override
    public List<ProductoDTO> findAll() {
        List<ProductoEntity> listadoEntity = this.productoRepository.findAll();
        List<ProductoDTO> listadoDTO = this.modelMapper.map(listadoEntity,new TypeToken<List<ProductoDTO>>(){}.getType());
        return listadoDTO;
    }

    @Override
    public List<ProductoDTO> findAllByState() {
        List<ProductoEntity> listadoEntity = this.productoRepository.findAllByEstate();
        List<ProductoDTO> listadoDTO = this.modelMapper.map(listadoEntity,new TypeToken<List<ProductoDTO>>(){}.getType());
        return listadoDTO;
    }

    @Override
    public ProductoDTO findById(int code) {
        ProductoEntity objEntity = this.productoRepository.findByID(code);
        ProductoDTO objDTO = this.modelMapper.map(objEntity,ProductoDTO.class);
        return objDTO;
    }

    @Override
    public ProductoDTO update(int code, ProductoDTO producto) {
        ProductoEntity productoEntity = this.modelMapper.map(producto,ProductoEntity.class);
        ProductoEntity productoEntityUpdate = this.productoRepository.update(code,productoEntity);
        ProductoDTO productoDTO = this.modelMapper.map(productoEntityUpdate,ProductoDTO.class);
        return productoDTO;
    }

    @Override
    public boolean delete(int code) {
        return this.productoRepository.delete(code);
    }

    @Override
    public ProductoDTO updateValue(int code, long valor) {
        // ProductoEntity productoEntity = this.modelMapper.map(findById(code),ProductoEntity.class);
        ProductoEntity productoEntityUpdate = this.productoRepository.updateValue(code,valor);
        ProductoDTO productoDTO = this.modelMapper.map(productoEntityUpdate,ProductoDTO.class);
        return productoDTO;
    }
}
