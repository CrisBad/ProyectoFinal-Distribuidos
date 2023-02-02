package co.edu.unicauca.distribuidos.proyecto_api_rest_cliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.proyecto_api_rest_cliente.models.Cliente;
import co.edu.unicauca.distribuidos.proyecto_api_rest_cliente.repositories.UsuarioRepository;

@Service
public class ClienteServiceImpl implements IClienteService {
    
    @Autowired
    private UsuarioRepository servicioAccesoBaseDatos;

    @Override
    public List<Cliente> findAll(){
        return this.servicioAccesoBaseDatos.findAll();
    }

    @Override
    public Cliente findById(Integer id){
        return this.servicioAccesoBaseDatos.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return this.servicioAccesoBaseDatos.save(cliente);
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        return this.servicioAccesoBaseDatos.update(id, cliente);
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }

    
}
