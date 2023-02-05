package co.edu.unicauca.distribuidos.api_servidor_login.services.services;

import co.edu.unicauca.distribuidos.api_servidor_login.services.DTO.AdminDTO;

import java.util.List;

public interface IAdminService {
    //Registrar admin
    public AdminDTO save(AdminDTO admin);
    //Listar todos los admins
    public List<AdminDTO> findAll();
    //Consultar un admin
    public AdminDTO findById(String usuario);
    //Editar un admin
    public AdminDTO update(String usuario, AdminDTO admin);
    //Eliminar un admin
    public boolean delete (String usuario);
    //METODO QUE ME PERMITE CONSULTAR LOGIN
    public boolean verifyLogin(String usuario, String clave);
}
