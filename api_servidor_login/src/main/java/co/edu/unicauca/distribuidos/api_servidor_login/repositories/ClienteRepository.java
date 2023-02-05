package main.java.co.edu.unicauca.distribuidos.api_servidor_login.repositories;

import main.java.co.edu.unicauca.distribuidos.api_servidor_login.models.ClienteEntity;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {
    private List<ClienteEntity> listaDeClientes;

    public ClienteRepository(){
        this.listaDeClientes = new ArrayList <ClientEntity>();
        cargarClientes();
    }

    public List<ClientEntity> findAll(){
        System.out.println("Invocando a listar todos");
        return this.listaDeClientes;
    }

    public ClientEntity findByID(String usuario){
        System.out.println("Invocando a consultar cliente");
        ClientEntity objCliente=null;
        for (ClientEntity client : listaDeClientes) {
            if(client.getUsuario().equals(usuario)){
                objCliente=client;
                break;
            }
        }
        return objCliente;
    }

    public ClientEntity save(ClientEntity cliente){
        System.out.println("Invocando a guardar cliente");
        ClientEntity objClient = null;
        if(this.listaDeClientes.add(cliente)){
            objClient=cliente;
        }
        return objClient;
    }

    public ClientEntity update (String usuario, ClientEntity cliente){
        System.out.println("Invocando a actualizar cliente");
        ClientEntity objCliente = null;
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
        for (ClientEntity cliente : listaDeClientes) {
            if(cliente.getUsuario().equals(usuario) && cliente.getClave().equals(clave)){
                flag=true;
            }
        }
        return flag;
    }

    private void cargarClientes()
    {
        ClientEntity objCliente1= new ClientEntity("Juan", "Perez", "juan@unicauca.edu.co", "13123112", "jperez", "123");
        this.listaDeClientes.add(objCliente1);
        ClientEntity objCliente2= new ClientEntity("Catalina", "Lopez", "catalina@unicauca.edu.co", "75634212", "clopez", "1234");
        this.listaDeClientes.add(objCliente2);
    }
}
