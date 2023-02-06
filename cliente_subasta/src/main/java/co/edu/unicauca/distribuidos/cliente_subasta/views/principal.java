package co.edu.unicauca.distribuidos.cliente_subasta.views;

import java.util.Scanner;
//import java.util.List;

import co.edu.unicauca.distribuidos.cliente_subasta.services.ClienteService;
import co.edu.unicauca.distribuidos.cliente_subasta.services.ProductoService;
import co.edu.unicauca.distribuidos.cliente_subasta.services.RefreshThread;
import co.edu.unicauca.distribuidos.cliente_subasta.models.ProductoEntity;
public class principal {
    public static void main(String[] args) {
		pruebaInterfaz();
        // pruebaConsola();
    }

    public static void pruebaInterfaz(){
        JFrameSubasta objFr = new JFrameSubasta();
        Thread hiloAlterno = new Thread(objFr);
        hiloAlterno.start();
    }

    public static void pruebaConsola(){
        ClienteService objClienteServices= new ClienteService();
		ProductoService objProductoServices= new ProductoService();

        try (Scanner objScanner = new Scanner (System.in)) {
            System.out.print("Ingrese el nombre de usuario : ");
            String user=objScanner.nextLine();
            System.out.print("Ingrese la clave: ");
            String password=objScanner.nextLine();
            boolean result = objClienteServices.verificarlogin(user, password);
            System.out.println(result);

            System.out.print("Ingrese el code del producto : ");
            int code = objScanner.nextInt();
            ProductoEntity producto = objProductoServices.consultarProducto(code);
            System.out.println(producto.getName());

        }

        System.out.println("Productos");
        for (ProductoEntity p : objProductoServices.listarProductos()) {
            System.out.println("Nombre: " + p.getName());
            System.out.println("Estado: " + p.getState());
        }
        
        RefreshThread objRefreshThread = new RefreshThread(2, objProductoServices);
        objRefreshThread.start();
    }
}
