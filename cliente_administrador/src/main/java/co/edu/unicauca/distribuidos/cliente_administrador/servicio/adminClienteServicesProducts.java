package co.edu.unicauca.distribuidos.cliente_administrador.servicio;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.http.HttpStatus;

import co.edu.unicauca.distribuidos.cliente_administrador.model.ProductoEntity;
import co.edu.unicauca.distribuidos.cliente_administrador.model.State;

public class adminClienteServicesProducts {

    private String endPoint;
    private Client objClientePeticiones;

    public adminClienteServicesProducts() {
        this.endPoint = "http://127.0.0.1:8085/productos/";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public List<ProductoEntity> listarProductos(){
        List<ProductoEntity> productos=null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        productos = objPeticion.get(new GenericType<List<ProductoEntity>>(){});
        return productos;
    }
    
    public ProductoEntity registrarProducto(ProductoEntity objProducto){
        ProductoEntity  objProdu=null;
		
		WebTarget target = this.objClientePeticiones.target(this.endPoint);	    
		
	    Entity<ProductoEntity> data = Entity.entity(objProducto, MediaType.APPLICATION_JSON_TYPE);
	    
	    Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);
	    
	    objProdu = objPeticion.post(data, ProductoEntity.class);		
	    
		return objProdu;
    }

    public ProductoEntity AbrirSubastaProducto(int code){
        ProductoEntity objProducto=null;	
        WebTarget target = this.objClientePeticiones.target(this.endPoint+code);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);	
        Response respuesta = objPeticion.get();
    
        if (respuesta.getStatus() == HttpStatus.OK.value()) {
            objProducto = respuesta.readEntity(ProductoEntity.class);
            objProducto.setState(State.En_Subasta);
    
            // Actualizar el estado en el servidor
            Response respuestaActualizacion = objPeticion.put(Entity.json(objProducto));
            if (respuestaActualizacion.getStatus() != HttpStatus.OK.value()) {
                System.out.println("Error al actualizar el estado del producto");
            }
        } else if (respuesta.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            System.out.println("El producto no fue encontrado");
        } else {
            // Manejar otro tipo de errores
        }
        return objProducto;
    }

    public ProductoEntity CerrarSubastaProducto(int code){
        ProductoEntity objProducto=null;	
        WebTarget target = this.objClientePeticiones.target(this.endPoint+code);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);	
        Response respuesta = objPeticion.get();
    
        if (respuesta.getStatus() == HttpStatus.OK.value()) {
            objProducto = respuesta.readEntity(ProductoEntity.class);
            objProducto.setState(State.No_Subasta);
    
            // Actualizar el estado en el servidor
            Response respuestaActualizacion = objPeticion.put(Entity.json(objProducto));
            if (respuestaActualizacion.getStatus() != HttpStatus.OK.value()) {
                System.out.println("Error al actualizar el estado del producto");
            }
        } else if (respuesta.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            System.out.println("El producto no fue encontrado");
        } else {
            // Manejar otro tipo de errores
        }
        return objProducto;
    }
}
