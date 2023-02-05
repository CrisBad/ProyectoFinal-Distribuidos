package co.edu.unicauca.distribuidos.api_servidor_login.repositories;

import co.edu.unicauca.distribuidos.api_servidor_login.models.ClienteEntity;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {
    private List<ClienteEntity> listaDeClientes;

    public ClienteRepository(){
        this.listaDeClientes = new ArrayList <ClienteEntity>();
        cargarClientes();
    }

    public List<ClienteEntity> findAll(){
        System.out.println("Invocando a listar todos");
        return this.listaDeClientes;
    }

    public ClienteEntity findByID(String usuario){
        System.out.println("Invocando a consultar cliente");
        ClienteEntity objCliente=null;
        for (ClienteEntity client : listaDeClientes) {
            if(client.getUsuario().equals(usuario)){
                objCliente=client;
                break;
            }
        }
        return objCliente;
    }

    public ClienteEntity save(ClienteEntity cliente){
        System.out.println("Invocando a guardar cliente");
        ClienteEntity objClient = null;
        if(this.listaDeClientes.add(cliente)){
            objClient=cliente;
        }
        return objClient;
    }

    public ClienteEntity update (String usuario, ClienteEntity cliente){
        System.out.println("Invocando a actualizar cliente");
        ClienteEntity objCliente = null;
        for (int i = 0; i < this.listaDeClientes.size(); i++) {
            if(this.listaDeClientes.get(i).getUsuario().equals(usuario)){
                this.listaDeClientes.set(i,cliente);
                objCliente=cliente;
                break;
            }
        }
        return objCliente;
    }

    public boolean delete (String usuario){
        System.out.println("Invocando a eliminar cliente");
        boolean flag = false;
        for (int i = 0; i < this.listaDeClientes.size(); i++) {
            if(this.listaDeClientes.get(i).getUsuario().equals(usuario)){
                this.listaDeClientes.remove(i);
                flag=true;
                break;
            }
        }
        return flag;
    }

    public boolean verifyProfile(String usuario, String clave){
        System.out.println("Invocando a verificar iniciar sesion");
        boolean flag = false;
        for (ClienteEntity cliente : listaDeClientes) {
            if(cliente.getUsuario().equals(usuario) && cliente.getClave().equals(clave)){
                flag=true;
            }
        }
        return flag;
    }

    private void cargarClientes()
    {
        ClienteEntity objCliente1= new ClienteEntity("Juan", "Perez", "juan@unicauca.edu.co", "13123112", "jperez", "123");
        this.listaDeClientes.add(objCliente1);
        ClienteEntity objCliente2= new ClienteEntity("Catalina", "Lopez", "catalina@unicauca.edu.co", "75634212", "clopez", "1234");
        this.listaDeClientes.add(objCliente2);
    }
}
