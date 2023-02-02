package co.edu.unicauca.cliente.cliente_rest.vista;

//import java.util.Date;

import co.edu.unicauca.cliente.cliente_rest.servicios.ClienteServices;
import co.edu.unicauca.cliente.cliente_rest.models.Cliente;

public class Menu {
    
    public static void main(String[] args) {
        ClienteServices objClienteServices = new ClienteServices();
        
        System.out.println("consultando un cliente con id 1");
        Cliente objClienteConsultado = objClienteServices.consultarCliente(1);
        imprimirCliente(objClienteConsultado);
    }

    
	private static void imprimirCliente(Cliente objCliente)
	{
		System.out.println(objCliente.getId());
		System.out.println(objCliente.getNombre());
		System.out.println(objCliente.getApellido());
		System.out.println(objCliente.getEmail());
		System.out.println(objCliente.getCreateAt());
	}
}
