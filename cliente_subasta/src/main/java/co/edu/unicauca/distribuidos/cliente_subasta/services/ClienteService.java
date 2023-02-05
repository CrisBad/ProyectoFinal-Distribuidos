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
        if(consultarAdmin(username)!=null){
            clienteAdmin  objClientAdmin=consultarAdmin(username);
            if(objClientAdmin.getUsuario().equals(username)&&objClientAdmin.getClave().equals(password)){
            bandera = true;
            }else{
            bandera=false;
            }
        }else{
            bandera = false;
        }
        return bandera;
    }

    public clienteAdmin consultarAdmin(String username){
        clienteAdmin  objClientAdmin=null;	
		
		WebTarget target = this.objClientePeticiones.target(this.endPoint+username);
		
		Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);	
		
		// objClientAdmin = objPeticion.get(clienteAdmin.class);
		Response respuesta = objPeticion.get();

        if (respuesta.getStatus() == HttpStatus.OK.value()) {
            objClientAdmin = respuesta.readEntity(clienteAdmin.class);
        } else if (respuesta.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            System.out.println("El administrador no fue encontrado");
        } else {
            // Manejar otro tipo de errores
        }
		return objClientAdmin;
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

    public List<clienteAdmin> listarAdmins(){
        List<clienteAdmin> listaAdm=null;			
		
		WebTarget target = this.objClientePeticiones.target(this.endPoint);
		
		Builder objPeticion=target.request(MediaType.APPLICATION_JSON);
		
		listaAdm = objPeticion.get(new GenericType<List<clienteAdmin>>() {});	
		
		return listaAdm;    
    }

    public List<ProductoEntity> listarProductos(){
        List<ProductoEntity> productos=null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        productos = objPeticion.get(new GenericType<List<ProductoEntity>>(){});
        return productos;
    }

    public clienteAdmin registrarAdmin(clienteAdmin objAdmin){
        clienteAdmin  objManager=null;
		
		WebTarget target = this.objClientePeticiones.target(this.endPoint);	    
		
	    Entity<clienteAdmin> data = Entity.entity(objAdmin, MediaType.APPLICATION_JSON_TYPE);
	    
	    Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);
	    
	    objManager = objPeticion.post(data, clienteAdmin.class);		
	    
		return objManager;
    }
}
