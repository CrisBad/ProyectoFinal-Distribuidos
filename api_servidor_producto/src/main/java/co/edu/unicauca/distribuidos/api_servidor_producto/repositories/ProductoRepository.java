package co.edu.unicauca.distribuidos.api_servidor_producto.repositories;

import co.edu.unicauca.distribuidos.api_servidor_producto.models.State;
import co.edu.unicauca.distribuidos.api_servidor_producto.models.ProductoEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository {
    private ArrayList<ProductoEntity> listadoProducto;

    public ProductoRepository(){
        this.listadoProducto = new ArrayList <ProductoEntity>();
        cargarDatos();
    }

    public List<ProductoEntity> findAll(){
        System.out.println("Invocando a listar todos");
        return this.listadoProducto;
    }
    
    public List<ProductoEntity> findAllByEstate(){

        System.out.println("Invocando a listar dependiendo del estado");
        List<ProductoEntity> listadoAux = this.listadoProducto;
        for (int i = 0; i < listadoAux.size() ; i++) {
            if(listadoAux.get(i).getState().equals(State.Pendiente)){
                listadoAux.remove(i);
            }
        }
        return listadoAux;
    }

    public ProductoEntity findByEstate(){
        System.out.println("Invocando a consultar producto por estado");
        ProductoEntity objProduct=null;
        for (ProductoEntity product : listadoProducto) {
            if(product.getState().equals(State.En_Subasta)){
                objProduct=product;
                break;
            }
        }

        return objProduct;
    }

    public ProductoEntity findByID(int code){
        System.out.println("Invocando a consultar producto");
        ProductoEntity objProduct=null;
        for (ProductoEntity product : listadoProducto) {
            if(product.getCode() == code){
                objProduct=product;
                break;
            }
        }

        return objProduct;
    }

    public ProductoEntity save(ProductoEntity product){
        System.out.println("Invocando a guardar producto");
        ProductoEntity objProduct = null;
        if(this.listadoProducto.add(product)){
            objProduct=product;
        }

        return objProduct;
    }

    public ProductoEntity update (int code, ProductoEntity product){
        System.out.println("Invocando a actualizar producto");
        ProductoEntity objProduct = null;

        for (int i = 0; i < this.listadoProducto.size(); i++) {
            if(this.listadoProducto.get(i).getCode() == code){
                this.listadoProducto.set(i,product);
                objProduct=product;
                break;
            }
        }
        return objProduct;
    }

    public boolean delete (int code){
        System.out.println("Invocando a eliminar producto");
        boolean bandera = false;

        for (int i = 0; i < this.listadoProducto.size(); i++) {
            if(this.listadoProducto.get(i).getCode() == code){
                this.listadoProducto.remove(i);
                bandera=true;
                break;
            }
        }
        return bandera;
    }

    private void cargarDatos(){
        ProductoEntity producto1 = new ProductoEntity(1,"patineta",55000,State.En_Subasta);
        this.listadoProducto.add(producto1);
        ProductoEntity producto2 = new ProductoEntity(2,"motocicleta",2300000,State.Pendiente);
        this.listadoProducto.add(producto2);
    }
}
