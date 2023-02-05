package co.edu.unicauca.distribuidos.api_servidor_login.services.services;

import co.edu.unicauca.distribuidos.api_servidor_login.models.ClienteEntity;
import co.edu.unicauca.distribuidos.api_servidor_login.repositories.ClienteRepository;
import co.edu.unicauca.distribuidos.api_servidor_login.services.DTO.ClienteDTO;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{
    //INYECCION DE DEPENDENCIAS
    @Autowired
    private ClienteRepository clienteRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteDTO save(ClienteDTO cliente) {
        ClienteEntity objEntity = this.modelMapper.map(cliente,ClienteEntity.class);
        ClienteEntity objClienteEntity = this.clienteRepositorio.save(objEntity);
        ClienteDTO ClienteDTO = this.modelMapper.map(objClienteEntity,ClienteDTO.class);
        return ClienteDTO;
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<ClienteEntity> lstEntity = this.clienteRepositorio.findAll();
        List<ClienteDTO> lstDTO = this.modelMapper.map(lstEntity,new TypeToken<List<ClienteDTO>>(){}.getType());
        return lstDTO;
    }

    @Override
    public ClienteDTO findById(String usuario) {
        ClienteEntity objEntity = this.clienteRepositorio.findByID(usuario);
        ClienteDTO objDTO = this.modelMapper.map(objEntity,ClienteDTO.class);
        return objDTO;
    }

    @Override
    public ClienteDTO update(String usuario, ClienteDTO cliente) {
        ClienteEntity clienteEntity = this.modelMapper.map(cliente,ClienteEntity.class);
        ClienteEntity clientEntityActualizado = this.clienteRepositorio.update(usuario,clienteEntity);
        ClienteDTO ClienteDTO = this.modelMapper.map(clientEntityActualizado,ClienteDTO.class);
        return ClienteDTO;
    }

    @Override
    public boolean delete(String usuario) {
        return this.clienteRepositorio.delete(usuario);
    }

    @Override
    public boolean verifyLogin(String usuario, String clave) {
        return this.clienteRepositorio.verifyProfile(usuario,clave);
    }
}
