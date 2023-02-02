package co.edu.unicauca.distribuidos.proyecto_api_rest_cliente.services;

import java.util.List;

import co.edu.unicauca.distribuidos.proyecto_api_rest_cliente.models.Cliente;

public interface IClienteService {
    
    public List<Cliente> findAll();
    public Cliente findById(Integer id);
    public Cliente save(Cliente cliente);
    public Cliente update(Integer id, Cliente cliente);
    public boolean delete(Integer id);
}
