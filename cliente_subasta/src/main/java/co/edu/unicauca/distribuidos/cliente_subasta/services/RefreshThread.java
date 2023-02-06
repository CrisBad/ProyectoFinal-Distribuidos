package co.edu.unicauca.distribuidos.cliente_subasta.services;

import java.util.concurrent.TimeUnit;

public class RefreshThread extends Thread{
    public void run() {
        while (true) {
            // Llame al método que realiza la consulta al servicio web
            int code=0;
            refrescarInfoProductos(code);
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                // Maneje la excepción si es necesario
                e.printStackTrace();
            }
        }
    }
    
    private void refrescarInfoProductos(int code) {
        // Aquí debe incluir el código para consultar el servicio web
    }
}
