package main.java.co.edu.unicauca.distribuidos.api_servidor_login.services.services;

import main.java.co.edu.unicauca.distribuidos.api_servidor_login.services.DTO.ClienteDTO;

import java.util.List;

public interface IClienteService {
    //Registrar cliente
    public ClienteDTO save(ClienteDTO cliente);
    //Listar todos los clientes
    public List<ClienteDTO> findAll();
    //Consultar un cliente
    public ClienteDTO findById(String usuario);
    //Editar un cliente
    public ClienteDTO update(String usuario, ClienteDTO cliente);
    //Eliminar un cliente
    public boolean delete (String usuario);
    //METODO QUE ME PERMITE CONSULTAR LOGIN
    public boolean verifyLogin(String usuario, String clave);
}
