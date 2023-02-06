package co.edu.unicauca.distribuidos.cliente_administrador.vista;
import java.util.Scanner;
import java.util.List;
import co.edu.unicauca.distribuidos.cliente_administrador.model.ProductoEntity;

import co.edu.unicauca.distribuidos.cliente_administrador.model.*;
import co.edu.unicauca.distribuidos.cliente_administrador.servicio.*;
public class main_ {
    
    public static void main(String[] args) {

		ProductoEntity objProducto = new ProductoEntity();
		adminClientServices objClienteServices= new adminClientServices();
        adminClienteServicesProducts objClientSProducts = new adminClienteServicesProducts();
		//System.out.println("\n eliminando un cliente");
        //Boolean bandera= objClienteServices.eliminarCliente(2);
	    try (Scanner objScanneer = new Scanner (System.in)) {
            System.out.print("Ingrese el nombre de usuario : ");
            String user=objScanneer.nextLine();
            System.out.print("Ingrese la clave: ");
            String password=objScanneer.nextLine();

            boolean result = objClienteServices.verificarlogin(user, password);
            System.out.println(result);

            System.out.println("-----------------------------------");
        List<ProductoEntity> listaDeProductos= objClientSProducts.listarProductos();

            for (ProductoEntity producto : listaDeProductos) {
                     imprimirProducto(producto);
             }

        System.out.println("----Registrar producto a a ofertar-------------------");
            //Scanner objScanneerr = new Scanner (System.in);

            System.out.println("Codigo producto: ");
            int codigo=objScanneer.nextInt();
            objScanneer.nextLine();
            System.out.println("nombre producto: ");
            String nameP = objScanneer.nextLine();
            System.out.println("valor inicial: ");
            int initVal = objScanneer.nextInt();
            
            objProducto.setCode(codigo);
            objProducto.setName(nameP);
            objProducto.setInitValue(initVal);
            objProducto.setState(State.En_Subasta);
	    ProductoEntity resultRProduct = objClientSProducts.registrarProducto(objProducto);

        System.out.println("-------------------list2----------------");
        List<ProductoEntity> listaDeProductoss= objClientSProducts.listarProductos();

            for (ProductoEntity producto : listaDeProductoss) {
                     imprimirProducto(producto);
             }
        }

        
        
	    // System.out.println("\n listando clientes que contiene el cliente eliminado");
        //     List<clienteAdmin> listaDeClientes= objClienteServices.listarAdmins();

        //     for (clienteAdmin cliente : listaDeClientes) {
        //             imprimirCliente(cliente);
        //     }
	
	}
    /* 
    private static void imprimirCliente(clienteAdmin objCliente)
	{
		System.out.println(objCliente.getUsuario()+" -- "+objCliente.getNombre()+" -- "+objCliente.getApellido());
		//System.out.println(objCliente.getNombre());
		//System.out.println(objCliente.getApellido());

	}*/
    private static void imprimirProducto(ProductoEntity objProd)
	{
		System.out.println(objProd.getName()+"|"+objProd.getCode()+"|"+objProd.getInitValue());
		//System.out.println(objCliente.getNombre());
		//System.out.println(objCliente.getApellido());

	}
    
}
