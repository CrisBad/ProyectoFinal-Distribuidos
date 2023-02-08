package co.edu.unicauca.distribuidos.cliente_administrador.vista;
import javax.swing.JOptionPane;

import co.edu.unicauca.distribuidos.cliente_administrador.model.*;
import co.edu.unicauca.distribuidos.cliente_administrador.servicio.adminClienteServicesProducts;
public class FrmRegistrar_Producto extends javax.swing.JFrame{
    /**
     * Creates new form FrmRegistrar_Producto
     */
    public FrmRegistrar_Producto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtRPCodigo = new javax.swing.JTextField();
        txtRPNombre = new javax.swing.JTextField();
        ttRPValorI = new javax.swing.JTextField();
        CbxEstado = new javax.swing.JComboBox<>();
        btnCrearProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Sitka Small", 3, 14)); // NOI18N
        jLabel1.setText("Registro de Productos");

        jLabel2.setText("Codigo: ");

        jLabel3.setText("Nombre: ");

        jLabel4.setText("Valor Inicial");

        jLabel5.setText("Estado: ");

        CbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En_Subasta", "No_Subasta", "Pendiente", "Vendido" }));

        btnCrearProducto.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnCrearProducto.setText("Crear");
        btnCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRPCodigo)
                    .addComponent(txtRPNombre)
                    .addComponent(ttRPValorI)
                    .addComponent(CbxEstado, 0, 100, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRPCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ttRPValorI, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        registrar_Producto();
        this.dispose();
        FrmInicio panel = new FrmInicio();
        panel.setVisible(true);
    }                                                
    /*private void ItemsEstado(){
        for(State state : State.values()){
            this.CbxEstado.addItem(state);
        }
    }*/

    private void registrar_Producto(){
        try{
        adminClienteServicesProducts objProductService = new adminClienteServicesProducts();
        int item =  this.CbxEstado.getSelectedIndex();
        ProductoEntity objProduct = new ProductoEntity();
        switch(item){
            case 0:
                objProduct.setCode(Integer.parseInt(this.txtRPCodigo.getText()));
                objProduct.setName(this.txtRPNombre.getText());
                objProduct.setInitValue(Long.parseLong(this.ttRPValorI.getText()));
                objProduct.setState(State.En_Subasta);
                break;
            case 1:
                objProduct.setCode(Integer.parseInt(this.txtRPCodigo.getText()));
                objProduct.setName(this.txtRPNombre.getText());
                objProduct.setInitValue(Long.parseLong(this.ttRPValorI.getText()));
                objProduct.setState(State.No_Subasta);
                break;
            case 2:
                objProduct.setCode(Integer.parseInt(this.txtRPCodigo.getText()));
                objProduct.setName(this.txtRPNombre.getText());
                objProduct.setInitValue(Long.parseLong(this.ttRPValorI.getText()));
                objProduct.setState(State.Pendiente);
                break;
            case 3:
                objProduct.setCode(Integer.parseInt(this.txtRPCodigo.getText()));
                objProduct.setName(this.txtRPNombre.getText());
                objProduct.setInitValue(Long.parseLong(this.ttRPValorI.getText()));
                objProduct.setState(State.Vendido);
                break;
        }
        if(objProduct!=null){
            if(objProductService.registrarProducto(objProduct)!=null){
                JOptionPane.showMessageDialog(this, "Se registro el producto");
            }else{   
                JOptionPane.showMessageDialog(this, "NO fue poisible registrar el producto");
            }
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Datos Invalidos");
    }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistrar_Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> CbxEstado;
    private javax.swing.JButton btnCrearProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField ttRPValorI;
    private javax.swing.JTextField txtRPCodigo;
    private javax.swing.JTextField txtRPNombre;
    // End of variables declaration        
}
