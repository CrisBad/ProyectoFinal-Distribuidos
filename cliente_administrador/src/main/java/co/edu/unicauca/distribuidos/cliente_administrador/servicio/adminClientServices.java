package co.edu.unicauca.distribuidos.cliente_administrador.servicio;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

import co.edu.unicauca.distribuidos.cliente_administrador.model.clienteAdmin;
import co.edu.unicauca.distribuidos.cliente_administrador.model.ProductoEntity;
//import co.edu.unicauca.distribuidos.api_servidor_producto.models.ProductoEntity; 

public class adminClientServices {
    private String endPoint;
    private Client objClientePeticiones;

    public adminClientServices(){
        this.endPoint="http://127.0.0.1:8085/admins/";
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
		
		objClientAdmin = objPeticion.get(clienteAdmin.class);
		
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
