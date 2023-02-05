package co.edu.unicauca.distribuidos.api_servidor_login.services.services;

import co.edu.unicauca.distribuidos.api_servidor_login.models.AdminEntity;
import co.edu.unicauca.distribuidos.api_servidor_login.repositories.AdminRepository;
import co.edu.unicauca.distribuidos.api_servidor_login.services.DTO.AdminDTO;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService{
    //INYECCION DE DEPENDENCIAS
    @Autowired
    private AdminRepository adminRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdminDTO save(AdminDTO admin) {
        AdminEntity objEntity = this.modelMapper.map(admin,AdminEntity.class);
        AdminEntity objClienteEntity = this.adminRepositorio.save(objEntity);
        AdminDTO AdminDTO = this.modelMapper.map(objClienteEntity,AdminDTO.class);
        return AdminDTO;
    }

    @Override
    public List<AdminDTO> findAll() {
        List<AdminEntity> lstEntity = this.adminRepositorio.findAll();
        List<AdminDTO> lstDTO = this.modelMapper.map(lstEntity,new TypeToken<List<AdminDTO>>(){}.getType());
        return lstDTO;
    }

    @Override
    public AdminDTO findById(String usuario) {
        AdminEntity objEntity = this.adminRepositorio.findByID(usuario);
        AdminDTO objDTO = this.modelMapper.map(objEntity,AdminDTO.class);
        return objDTO;
    }

    @Override
    public AdminDTO update(String usuario, AdminDTO admin) {
        AdminEntity adminEntity = this.modelMapper.map(admin,AdminEntity.class);
        AdminEntity adminEntityActualizado = this.adminRepositorio.update(usuario,adminEntity);
        AdminDTO AdminDTO = this.modelMapper.map(adminEntityActualizado,AdminDTO.class);
        return AdminDTO;
    }

    @Override
    public boolean delete(String usuario) {
        return this.adminRepositorio.delete(usuario);
    }

    @Override
    public boolean verifyLogin(String usuario, String clave) {
        return this.adminRepositorio.verifyProfile(usuario,clave);
    }
}
