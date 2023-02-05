package co.edu.unicauca.distribuidos.cliente_subasta.services;

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

import co.edu.unicauca.distribuidos.cliente_subasta.models.*;

public class ClienteService {
    private String endPoint;
    private Client objClientePeticiones;

    public ClienteService(){
        this.endPoint="http://127.0.0.1:8084/clientes/";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public boolean verificarlogin(String username,String password){
        boolean bandera=false;
        if(consultarCliente(username)!=null){
            Cliente  objCliente=consultarCliente(username);
            if(objCliente.getUsuario().equals(username)&&objCliente.getClave().equals(password)){
            bandera = true;
            }else{
            bandera=false;
            }
        }else{
            bandera = false;
        }
        return bandera;
    }

    public Cliente consultarCliente(String username){
        Cliente  objCliente=null;	
		
		WebTarget target = this.objClientePeticiones.target(this.endPoint+username);
		
		Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);	
		
		// objCliente = objPeticion.get(Cliente.class);
		Response respuesta = objPeticion.get();

        if (respuesta.getStatus() == HttpStatus.OK.value()) {
            objCliente = respuesta.readEntity(Cliente.class);
        } else if (respuesta.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            System.out.println("El cliente no fue encontrado");
        } else {
            // Manejar otro tipo de errores
        }
		return objCliente;
    }

    //revisar
    public ProductoEntity crearProducto(ProductoEntity objProductoRegis){
        ProductoEntity objProducto=null;
		
		WebTarget target = this.objClientePeticiones.target(this.endPoint);	    
		
	    Entity<ProductoEntity> data = Entity.entity(objProductoRegis, MediaType.APPLICATION_JSON_TYPE);
	    
	    Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);
	    
	    objProducto = objPeticion.post(data, ProductoEntity.class);		
	    
		return objProducto;
    }

    public List<Cliente> listarClientes(){
        List<Cliente> listaCli=null;			
		
		WebTarget target = this.objClientePeticiones.target(this.endPoint);
		
		Builder objPeticion=target.request(MediaType.APPLICATION_JSON);
		
		listaCli = objPeticion.get(new GenericType<List<Cliente>>() {});	
		
		return listaCli;    
    }

    public List<ProductoEntity> listarProductos(){
        List<ProductoEntity> productos=null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        productos = objPeticion.get(new GenericType<List<ProductoEntity>>(){});
        return productos;
    }

    public Cliente registrarCliente(Cliente objCliente){
        Cliente  objManager=null;
		
		WebTarget target = this.objClientePeticiones.target(this.endPoint);	    
		
	    Entity<Cliente> data = Entity.entity(objCliente, MediaType.APPLICATION_JSON_TYPE);
	    
	    Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);
	    
	    objManager = objPeticion.post(data, Cliente.class);		
	    
		return objManager;
    }
}
