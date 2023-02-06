package co.edu.unicauca.distribuidos.cliente_subasta.services;

import co.edu.unicauca.distribuidos.cliente_subasta.models.ProductoEntity;

public class RefreshThread extends Thread {
    private int code;
    private ProductoService objProductoServices;
    
    public RefreshThread(int code, ProductoService objProductoServices) {
        this.code = code;
        this.objProductoServices = objProductoServices;
    }
    
    @Override
    public void run() {
        while (true) {
            ProductoEntity producto = objProductoServices.consultarProducto(code);
            System.out.println("Refrescando...");
            System.out.println("Code: " + producto.getCode());
            System.out.println("Nombre: " + producto.getName());
            System.out.println("Value: " + producto.getInitValue());
            System.out.println("State: " + producto.getState());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

