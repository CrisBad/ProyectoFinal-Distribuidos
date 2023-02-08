package co.edu.unicauca.distribuidos.cliente_subasta.views;

import co.edu.unicauca.distribuidos.cliente_subasta.models.ProductoEntity;
import co.edu.unicauca.distribuidos.cliente_subasta.services.ProductoService;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFOferta extends javax.swing.JFrame implements Runnable {

    private ProductoService objProductoServices;
    private int code;
    private boolean running = true;
    
    public void setCode(int code){
        this.code = code;
    }
    
    public JFOferta() {
        objProductoServices = new ProductoService();
        iniciarComponentes();
    }

    @Override
    public void run() {
        // código a ejecutar en el hilo alterno
        while (running) {
            System.out.println("Refreshing...");
            listarProducto();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    /* Liberar memoria: terminar el hilo y establecer referencias a null */
    @Override
    public void dispose() {
        running = false;
        super.dispose();
        jLabel8 = null;
        jLabel2 = null;
        jLabel4 = null;
        jLabel6 = null;
        objProductoServices = null;
    }

    public void iniciarComponentes() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Interfaz Cliente Subasta - Consultar");
        limpiarTxt();
        centerFrameOnScreen(this);
        setVisible(true);
    }

    public static void centerFrameOnScreen(JFrame frame) {
        int width = frame.getWidth();
        int height = frame.getHeight();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int x = (screenWidth - width) / 2;
        int y = (screenHeight - height) / 2;
        frame.setLocation(x, y);
    }

    public void limpiarTxt() {
        jLabel8.setText("");
        jLabel2.setText("");
        jLabel4.setText("");
        jLabel6.setText("");
    }

    public void listarProducto() {
        ProductoEntity objProducto = objProductoServices.consultarProducto(code);
        jLabel8.setText(Integer.toString(code));
        jLabel2.setText(objProducto.getName());
        //NumberFormat formatter = NumberFormat.getInstance();
        //String formattedValue = formatter.format(objProducto.getInitValue());
        jLabel6.setText(Long.toString(objProducto.getInitValue()));

        jLabel4.setText(objProducto.getState().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setName("PanelBg"); // NOI18N

        jLabel1.setText("Nombre:");
        jLabel1.setName(""); // NOI18N

        jLabel2.setText("jLabel2");
        jLabel2.setName("lblNombre"); // NOI18N

        jLabel3.setText("Estado:");
        jLabel3.setName(""); // NOI18N

        jLabel4.setText("jLabel4");
        jLabel4.setName("lblEstado"); // NOI18N

        jLabel5.setText("Valor:");
        jLabel5.setName(""); // NOI18N

        jLabel6.setText("jLabel6");
        jLabel6.setName("lblValor"); // NOI18N

        jLabel7.setText("Código:");
        jLabel7.setName(""); // NOI18N

        jLabel8.setText("jLabel8");
        jLabel8.setName("lblCodigo"); // NOI18N

        jTextField1.setName("txtOferta"); // NOI18N

        jButton1.setText("Pujar");
        jButton1.setName("btnOferta"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jButton1)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!jTextField1.getText().equals("")) {
            try {
                long oferta = Long.parseLong(jTextField1.getText());
                //long oferta = Long.parseLong(jTextField1.getText().replaceAll(",",""));
                //System.out.println("Codigo: " + codigo + " Oferta: " + oferta);
                if(oferta>Long.parseLong(jLabel6.getText())){
                    int codigo = Integer.parseInt(jLabel8.getText());
                    ProductoEntity objProducto = objProductoServices.actualizarValor(codigo, oferta);
                    if(objProducto!=null){
                        JOptionPane.showMessageDialog(null, "Oferta realizada correctamente", "Realizar oferta", JOptionPane.INFORMATION_MESSAGE);
                        jTextField1.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "La oferta debe ser mayor a la actual", "Realizar oferta", JOptionPane.WARNING_MESSAGE);
                    jTextField1.setText("");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero", "Realizar oferta", JOptionPane.ERROR_MESSAGE);
                jTextField1.setText("");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
