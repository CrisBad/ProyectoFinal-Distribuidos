package co.edu.unicauca.distribuidos.cliente_subasta.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.http.HttpStatus;

import co.edu.unicauca.distribuidos.cliente_subasta.models.ClienteEntity;

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
            ClienteEntity  objCliente=consultarCliente(username);
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

    public ClienteEntity consultarCliente(String username){
        ClienteEntity  objCliente=null;	
		
		WebTarget target = this.objClientePeticiones.target(this.endPoint+username);
		
		Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);	
		
		// objCliente = objPeticion.get(Cliente.class);
		Response respuesta = objPeticion.get();

        if (respuesta.getStatus() == HttpStatus.OK.value()) {
            objCliente = respuesta.readEntity(ClienteEntity.class);
        } else if (respuesta.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            System.out.println("El cliente no fue encontrado");
        } else {
            // Manejar otro tipo de errores
        }
		return objCliente;
    }

    //revisar
    public ClienteEntity registrarCliente(ClienteEntity objProductoRegis){
        ClienteEntity objProducto=null;
		
		WebTarget target = this.objClientePeticiones.target(this.endPoint);	    
		
        Entity<ClienteEntity> data = Entity.entity(objProductoRegis, MediaType.APPLICATION_JSON_TYPE);
        
        Builder objPeticion=target.request(MediaType.APPLICATION_JSON_TYPE);
        
        objProducto = objPeticion.post(data, ClienteEntity.class);		

		return objProducto;
    }

}
