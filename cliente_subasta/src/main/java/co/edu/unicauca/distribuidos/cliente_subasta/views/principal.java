package co.edu.unicauca.distribuidos.cliente_subasta.views;
import java.util.Scanner;
import co.edu.unicauca.distribuidos.cliente_subasta.services.*;
public class principal {
    public static void main(String[] args) {
		
		ClienteService objClienteServices= new ClienteService();
		//System.out.println("\n eliminando un cliente");
        //Boolean bandera= objClienteServices.eliminarCliente(2);
	    try (Scanner objScanneer = new Scanner (System.in)) {
            System.out.print("Ingrese el nombre de usuario : ");
            String user=objScanneer.nextLine();
            System.out.print("Ingrese la clave: ");
            String password=objScanneer.nextLine();

            boolean result = objClienteServices.verificarlogin(user, password);
            System.out.println(result);
        }
    }
}
