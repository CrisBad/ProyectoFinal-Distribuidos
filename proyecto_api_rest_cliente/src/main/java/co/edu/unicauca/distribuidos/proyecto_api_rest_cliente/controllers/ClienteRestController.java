package co.edu.unicauca.distribuidos.proyecto_api_rest_cliente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.proyecto_api_rest_cliente.services.IClienteService;
import co.edu.unicauca.distribuidos.proyecto_api_rest_cliente.models.Cliente;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
    
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Integer id){
        Cliente objCliente = null;
        objCliente = clienteService.findById(id);
        return objCliente;
    }

    @PostMapping("/clientes")
    public Cliente create(@RequestBody Cliente cliente){
        Cliente objCliente = null;
        objCliente = clienteService.save(cliente);
        return objCliente;
    }

    @PutMapping("/clientes/{id}")
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Integer id){
        Cliente objCliente = null;
        Cliente clienteActual = clienteService.findById(id);
        if(clienteActual!=null){
            objCliente = clienteService.update(id, cliente);
        }
        return objCliente;
    }

    @DeleteMapping("/clientes/{id}")
    public Boolean delete(@PathVariable Integer id){
        Boolean bandera=false;
        Cliente clienteActual = clienteService.findById(id);
        if(clienteActual!=null){
            bandera = clienteService.delete(id);
        }
        return bandera;
    }
}
