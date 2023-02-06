package co.edu.unicauca.distribuidos.cliente_administrador.vista;

public class Menu {
    public static void main(String[] args) {
        //ClienteServices objClienteServices = new ClienteServices();
        
		login lg = new login();
		lg.setVisible(true);

        //System.out.println("consultando un cliente con id 1");
        //Cliente objClienteConsultado = objClienteServices.consultarCliente(1);
        //imprimirCliente(objClienteConsultado);
    }
}
