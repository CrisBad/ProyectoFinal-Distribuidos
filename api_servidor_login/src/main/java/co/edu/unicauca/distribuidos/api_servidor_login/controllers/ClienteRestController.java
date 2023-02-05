package main.java.co.edu.unicauca.distribuidos.api_servidor_login.controllers;

import main.java.co.edu.unicauca.distribuidos.api_servidor_login.services.DTO.ClienteDTO;
import main.java.co.edu.unicauca.distribuidos.api_servidor_login.services.services.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("clientes")
public class ClienteRestController {
    //INYECCION DE DEPENDENCIAS
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/")
    @ResponseBody
    public List<ClienteDTO> findAll(){
        return this.clienteService.findAll();
    }

    @GetMapping("/{usuario}")
    @ResponseBody
    public ClienteDTO findById(@PathVariable String usuario){
        return clienteService.findById(usuario);
    }

    @PostMapping("/")
    @ResponseBody
    public ClienteDTO create(@Valid @RequestBody ClienteDTO cliente){
        return this.clienteService.save(cliente);
    }

    @PutMapping("/{usuario}")
    @ResponseBody
    public ClienteDTO update(@RequestBody ClienteDTO cliente, @PathVariable String usuario){
        ClienteDTO objCliente = null;
        ClienteDTO clienteActual = this.clienteService.findById(usuario);
        if(clienteActual != null){
            objCliente = this.clienteService.update(usuario,cliente);
        }
        return objCliente;
    }

    @DeleteMapping("/{usuario}")
    @ResponseBody
    public boolean delete (@PathVariable String usuario){
        boolean flag = false;
        ClienteDTO clienteActual = this.clienteService.findById(usuario);
        if(clienteActual != null){
            flag = this.clienteService.delete(usuario);
        }
        return flag;
    }
}
