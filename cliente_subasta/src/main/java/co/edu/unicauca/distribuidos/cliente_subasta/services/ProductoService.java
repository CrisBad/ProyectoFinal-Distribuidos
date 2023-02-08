package co.edu.unicauca.distribuidos.cliente_subasta.services;

import java.util.List;

// import javax.swing.text.html.parser.Entity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.http.HttpStatus;

import co.edu.unicauca.distribuidos.cliente_subasta.models.ProductoEntity;
//import co.edu.unicauca.distribuidos.cliente_subasta.models.State;

public class ProductoService {
    private String endPoint;
    private Client objProductoPeticiones;

    public ProductoService(){
        this.endPoint="http://127.0.0.1:8085/productos/";
        this.objProductoPeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public ProductoEntity consultarProducto(int code){
        ProductoEntity  objProducto=null;	
		
		WebTarget target = this.objProductoPeticiones.target(this.endPoint+code);
		
		Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);	
		
		// objClientAdmin = objPeticion.get(Cliente.class);
		Response respuesta = objPeticion.get();

        if (respuesta.getStatus() == HttpStatus.OK.value()) {
            objProducto = respuesta.readEntity(ProductoEntity.class);
        } else if (respuesta.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            System.out.println("El producto no fue encontrado");
        } else {
            // Manejar otro tipo de errores
        }
		return objProducto;
    }
    
    public List<ProductoEntity> listarProductos(){
        List<ProductoEntity> productos=null;
        WebTarget target = this.objProductoPeticiones.target(this.endPoint);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        productos = objPeticion.get(new GenericType<List<ProductoEntity>>(){});
        return productos;
    }

    public ProductoEntity actualizarValor(int id, long valor)
    {
        ProductoEntity objCliente = null;
        WebTarget target = this.objProductoPeticiones.target(this.endPoint + "oferta/" + id + "/" + valor);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = objPeticion.post(Entity.entity("", MediaType.APPLICATION_JSON_TYPE));
        if (response.getStatus() == 200) {
            objCliente = response.readEntity(ProductoEntity.class);
        }
        return objCliente;
    }

}
