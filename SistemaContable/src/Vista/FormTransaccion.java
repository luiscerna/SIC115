package Vista;

//importando librerias
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FormTransaccion extends javax.swing.JFrame {
 
    public FormTransaccion() {
        initComponents();
        inicializarColumnasTablaTransacciones(); //para inicializar el formato de la tableTransacciones 
    }

    //Metodo para inicializar las columnas de la tabla
    private void inicializarColumnasTablaTransacciones()
    {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();
        
        for(int i=0; i<4; i++)
        {
            TableColumn col= new TableColumn(i);
            
            switch(i){
                case 0:
                    col.setHeaderValue("Codigo");
                    break;
                case 1:
                    col.setHeaderValue("Nombre");
                    break;
                case 2:
                    col.setHeaderValue("Debe");
                    break;
                case 3:
                    col.setHeaderValue("Haber");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        tableTransacciones.setColumnModel(tColumnModel);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNumPartida = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblConceptoGeneral = new javax.swing.JLabel();
        txtConceptoGeneral = new javax.swing.JTextField();
        lblNumCuenta = new javax.swing.JLabel();
        txtNumCuenta = new javax.swing.JTextField();
        btnCatalogo = new javax.swing.JButton();
        radCargo = new javax.swing.JRadioButton();
        radAbono = new javax.swing.JRadioButton();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        lblNumPartidaVal = new javax.swing.JLabel();
        lblFechaVal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTransacciones = new javax.swing.JTable();
        lblTotales = new javax.swing.JLabel();
        lblTotalDebe = new javax.swing.JLabel();
        lblTotalHaber = new javax.swing.JLabel();
        lblDiferencia = new javax.swing.JLabel();
        lblDiferenciaVal = new javax.swing.JLabel();
        btnBorrarLinea = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaccion");

        lblNumPartida.setText("Numero de Partida:");

        lblFecha.setText("Fecha:");

        lblConceptoGeneral.setText("Concepto general:");

        lblNumCuenta.setText("No de Cuenta:");

        btnCatalogo.setText("Catalogo");

        radCargo.setText("Cargo");

        radAbono.setText("Abono");

        lblValor.setText("Valor:");

        btnOK.setText("OK");

        lblNumPartidaVal.setText("Valor del numero de partida");

        lblFechaVal.setText("Valor de la fecha de transaccion");

        tableTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableTransacciones);

        lblTotales.setText("Totales");

        lblTotalDebe.setText("$ Total Debe");

        lblTotalHaber.setText("$ Total Haber");

        lblDiferencia.setText("Diferencia");

        lblDiferenciaVal.setText("$ Valor Diferencia");

        btnBorrarLinea.setText("Borrar linea");

        btnGuardar.setText("Guardar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumPartida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumPartidaVal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFechaVal)
                        .addGap(118, 118, 118))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblConceptoGeneral)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConceptoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNumCuenta)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCatalogo)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radCargo)
                                    .addComponent(radAbono))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblValor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOK)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBorrarLinea)
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotales)
                                    .addComponent(lblDiferencia))
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTotalDebe)
                                        .addGap(85, 85, 85)
                                        .addComponent(lblTotalHaber))
                                    .addComponent(lblDiferenciaVal)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 63, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(btnGuardar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumPartida)
                    .addComponent(lblFecha)
                    .addComponent(lblNumPartidaVal)
                    .addComponent(lblFechaVal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConceptoGeneral)
                    .addComponent(txtConceptoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNumCuenta)
                                .addComponent(btnCatalogo)
                                .addComponent(radCargo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radAbono)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnOK)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotales)
                    .addComponent(lblTotalDebe)
                    .addComponent(lblTotalHaber)
                    .addComponent(btnBorrarLinea))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiferencia)
                    .addComponent(lblDiferenciaVal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FormTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarLinea;
    private javax.swing.JButton btnCatalogo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnOK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConceptoGeneral;
    private javax.swing.JLabel lblDiferencia;
    private javax.swing.JLabel lblDiferenciaVal;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaVal;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JLabel lblNumPartida;
    private javax.swing.JLabel lblNumPartidaVal;
    private javax.swing.JLabel lblTotalDebe;
    private javax.swing.JLabel lblTotalHaber;
    private javax.swing.JLabel lblTotales;
    private javax.swing.JLabel lblValor;
    private javax.swing.JRadioButton radAbono;
    private javax.swing.JRadioButton radCargo;
    private javax.swing.JTable tableTransacciones;
    private javax.swing.JTextField txtConceptoGeneral;
    private javax.swing.JTextField txtNumCuenta;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
