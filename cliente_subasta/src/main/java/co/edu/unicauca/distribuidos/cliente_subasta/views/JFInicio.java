package co.edu.unicauca.distribuidos.cliente_subasta.views;

import co.edu.unicauca.distribuidos.cliente_subasta.models.ProductoEntity;
import co.edu.unicauca.distribuidos.cliente_subasta.models.State;
import co.edu.unicauca.distribuidos.cliente_subasta.services.ProductoService;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JFInicio extends javax.swing.JFrame {

    private javax.swing.JTable tblProductos;
    private DefaultTableModel model;
    private ProductoService objProductoServices;
    //private JFOferta frmOferta;
    
    public JFInicio() {
        objProductoServices = new ProductoService();
        //frmOferta = new JFOferta();
        iniciarComponentes();
        setVisible(true);
    }
    
    public void iniciarComponentes(){
        initComponents();
        setTitle("Interfaz Cliente Subasta - Inicio");
        centerFrameOnScreen(this);
        tblProductos = new JTable();
        tblProductos.setEnabled(false);
        model = new DefaultTableModel(new Object[] {"Codigo", "Nombre", "Valor", "Estado"}, 0);
        jScrollPane1.setViewportView(tblProductos);
        cargarProductos();
    }
    
    public void cargarProductos(){
        limpiarTabla();
        for (ProductoEntity p : objProductoServices.listarProductos()) {
            model.addRow(new Object[] {p.getCode(), p.getName(), p.getInitValue(), p.getState()});
        }
        tblProductos.setModel(model);
    }
    
    public void filtrarProductos(String filtro){
        limpiarTabla();
        for (ProductoEntity p : objProductoServices.listarProductos()) {
            if(filtro.equals("en subasta") && p.getState() == State.En_Subasta){
                model.addRow(new Object[] {p.getCode(), p.getName(), p.getInitValue(), p.getState()});
            }else if(filtro.equals("no esta en subasta") && p.getState() != State.En_Subasta){
                model.addRow(new Object[] {p.getCode(), p.getName(), p.getInitValue(), p.getState()});
            }
        }
        tblProductos.setModel(model);
    }

    public void limpiarTabla(){
        int filas = model.getRowCount()-1;
        for (int i = filas; i >= 0; i--) {
            model.removeRow(i);
        }
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setName("PanelBg"); // NOI18N

        jScrollPane1.setName("ScrollProductos"); // NOI18N

        jButton1.setText("En subasta");
        jButton1.setName("btnEnSubasta"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("No subasta");
        jButton2.setName("btnNoSubasta"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setName("txtCodigo"); // NOI18N

        jButton3.setText("Consultar");
        jButton3.setName("btnConsultar"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton1)
                        .addGap(45, 45, 45)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(29, 29, 29))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!jTextField1.getText().equals("")) {
            try {
                int code = Integer.parseInt(jTextField1.getText());
                ProductoEntity objProducto = objProductoServices.consultarProducto(code);
                if (objProducto!=null) {
                    if (objProducto.getState() == State.En_Subasta) {
                        JFOferta frmOferta = new JFOferta();
                        frmOferta.setCode(code);
                        Thread hiloAlterno = new Thread(frmOferta);
                        hiloAlterno.start();
                    }else{
                        JOptionPane.showMessageDialog(null, "El producto no se encuentra en subasta", "Consultar producto", JOptionPane.WARNING_MESSAGE);
                        String datos = "Código: " + objProducto.getCode() + 
                                        "\nNombre: " + objProducto.getName() + 
                                        "\nValor: " + objProducto.getInitValue() + 
                                        "\nEstado: "+ objProducto.getState();
                        JOptionPane.showMessageDialog(null, datos, "Consultar producto", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (NumberFormatException e) {
                
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero", "Consultar producto", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //filtrar por productos en subasta
        filtrarProductos("en subasta");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //filtrar por productos que no están en subasta
        filtrarProductos("no esta en subasta");
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
