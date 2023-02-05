package co.edu.unicauca.distribuidos.cliente_administrador.vista;
import java.util.Scanner;

import co.edu.unicauca.distribuidos.cliente_administrador.model.ProductoEntity;
import co.edu.unicauca.distribuidos.cliente_administrador.model.clienteAdmin;
import co.edu.unicauca.distribuidos.cliente_administrador.servicio.adminClientServices;
public class main_ {
    
    public static void main(String[] args) {
		
		adminClientServices objClienteServices= new adminClientServices();
		
	    //System.out.println("\n eliminando un cliente");
	    //Boolean bandera= objClienteServices.eliminarCliente(2);
        Scanner objScanneer = new Scanner (System.in);
        System.out.println("Ingrese el nombre de usuario : ");
        String user=objScanneer.nextLine();
        System.out.println("Ingrese la clave: ");
        String password=objScanneer.nextLine();

        boolean result = objClienteServices.verificarlogin(user, password);
        System.out.println(result);

        // System.out.println("-----------------------------------");
        // List<ProductoEntity> listaDeProductos= objClienteServices.listarProductos();

        //     for (ProductoEntity producto : listaDeProductos) {
        //              imprimirProducto(producto);
        //      }


	    
	    // System.out.println("\n listando clientes que contiene el cliente eliminado");
        //     List<clienteAdmin> listaDeClientes= objClienteServices.listarAdmins();

        //     for (clienteAdmin cliente : listaDeClientes) {
        //             imprimirCliente(cliente);
        //     }
	
	}
    private static void imprimirCliente(clienteAdmin objCliente)
	{
		System.out.println(objCliente.getUsuario()+" -- "+objCliente.getNombre()+" -- "+objCliente.getApellido());
		//System.out.println(objCliente.getNombre());
		//System.out.println(objCliente.getApellido());

	}
    private static void imprimirProducto(ProductoEntity objProd)
	{
		System.out.println(objProd.getName());
		//System.out.println(objCliente.getNombre());
		//System.out.println(objCliente.getApellido());

	}
}
