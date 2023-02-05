package co.edu.unicauca.distribuidos.api_servidor_login.repositories;

import co.edu.unicauca.distribuidos.api_servidor_login.models.AdminEntity;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminRepository {
    private List<AdminEntity> listaDeAdmins;

    public AdminRepository(){
        this.listaDeAdmins = new ArrayList <AdminEntity>();
        cargarAdministradores();
    }

    public List<AdminEntity> findAll(){
        System.out.println("Invocando a listar todos los administradores");
        return this.listaDeAdmins;
    }

    public AdminEntity findByID(String usuario){
        System.out.println("Invocando a consultar admin");
        AdminEntity objAdmin=null;
        for (AdminEntity admin : listaDeAdmins) {
            if(admin.getUsuario().equals(usuario)){
                objAdmin=admin;
                break;
            }
        }
        return objAdmin;
    }

    public AdminEntity save(AdminEntity admin){
        System.out.println("Invocando a guardar admin");
        AdminEntity objAdmin = null;
        if(this.listaDeAdmins.add(admin)){
            objAdmin=admin;
        }
        return objAdmin;
    }

    public AdminEntity update (String usuario, AdminEntity admin){
        System.out.println("Invocando a actualizar admin");
        AdminEntity objAdmin = null;
        for (int i = 0; i < this.listaDeAdmins.size(); i++) {
            if(this.listaDeAdmins.get(i).getUsuario().equals(usuario)){
                this.listaDeAdmins.set(i,admin);
                objAdmin=admin;
                break;
            }
        }
        return objAdmin;
    }

    public boolean delete (String usuario){
        System.out.println("Invocando a eliminar admin");
        boolean flag = false;
        for (int i = 0; i < this.listaDeAdmins.size(); i++) {
            if(this.listaDeAdmins.get(i).getUsuario().equals(usuario)){
                this.listaDeAdmins.remove(i);
                flag=true;
                break;
            }
        }
        return flag;
    }

    public boolean verifyProfile(String usuario, String clave){
        System.out.println("Invocando a verificar iniciar sesion");
        boolean flag = false;
        for (AdminEntity cliente : listaDeAdmins) {
            if(cliente.getUsuario().equals(usuario) && cliente.getClave().equals(clave)){
                flag=true;
            }
        }
        return flag;
    }

    private void cargarAdministradores()
    {
        AdminEntity objAdmin1= new AdminEntity("Andrea", "Lopez", "adnrea", "miclave");
        this.listaDeAdmins.add(objAdmin1);
        AdminEntity objAdmin2= new AdminEntity("Daniel", "Cisneros","dcisneros", "otraclave");
        this.listaDeAdmins.add(objAdmin2);

    }
}
