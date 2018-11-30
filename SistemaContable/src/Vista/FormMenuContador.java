/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paola
 */
public class FormMenuContador extends javax.swing.JFrame {
    private String usuario;
    private int idUsuario;
    private String nombre;
    private String apellido;
    
    /** Creates new form FormMenu */
    public FormMenuContador() {
        initComponents();
        this.setLocationRelativeTo(null);//Para que se muestre al centro de la pantalla
    }
    
    public void mnsjBienvenida(){
        this.lblBienvenida.setText("Bienvenid@ "+ this.nombre);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEstadosCostos = new javax.swing.JButton();
        btnEstadosF = new javax.swing.JButton();
        btnTransaccion = new javax.swing.JButton();
        btnLibroMayor = new javax.swing.JButton();
        btnPlanilla = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEstadosCostos.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        btnEstadosCostos.setText("Estados de costos de Produccion");

        btnEstadosF.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        btnEstadosF.setText("Estados Financieros");

        btnTransaccion.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        btnTransaccion.setText("Registrar Transaccion");
        btnTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaccionActionPerformed(evt);
            }
        });

        btnLibroMayor.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        btnLibroMayor.setText("Libro Mayor");
        btnLibroMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibroMayorActionPerformed(evt);
            }
        });

        btnPlanilla.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        btnPlanilla.setText("Planilla");

        btnCerrarSesion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Paola\\Downloads\\SIC\\PROYECTO SIC\\proyecto\\SIC115\\SistemaContable\\src\\Imagenes\\logo.png")); // NOI18N
        jLabel1.setText("Logo aqui");

        lblBienvenida.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        lblBienvenida.setText("Bienvenido \"Nombre Usuario\"");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnEstadosCostos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEstadosF)
                            .addComponent(btnTransaccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblBienvenida)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLibroMayor)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCerrarSesion)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPlanilla)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarSesion)
                    .addComponent(lblBienvenida))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnEstadosF)
                        .addGap(86, 86, 86)
                        .addComponent(btnTransaccion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnLibroMayor)
                        .addGap(95, 95, 95)
                        .addComponent(btnPlanilla)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEstadosCostos)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here
        Login inicio=new Login();
        this.setVisible(false);
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccionActionPerformed
        try {
            FormTransaccion form=new FormTransaccion(); //REEMPLAZAR POR EL OTRO FORM DE MOTO
            form.setApellido(this.apellido);
            form.setNombre(this.nombre);
            form.setIdUsuario(this.idUsuario);
            form.setUsuario(this.usuario);
            form.setVisible(true);
            this.dispose();
            this.setEnabled(false);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(FormMenuContador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnTransaccionActionPerformed

    private void btnLibroMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibroMayorActionPerformed
        try {
            LibroMayorDialog formMayor= new LibroMayorDialog(this,true);
            this.setVisible(false);
            formMayor.setVisible(true);
            this.setVisible(true);        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(FormMenuContador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLibroMayorActionPerformed

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
            java.util.logging.Logger.getLogger(FormMenuContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenuContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenuContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenuContador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenuContador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEstadosCostos;
    private javax.swing.JButton btnEstadosF;
    private javax.swing.JButton btnLibroMayor;
    private javax.swing.JButton btnPlanilla;
    private javax.swing.JButton btnTransaccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBienvenida;
    // End of variables declaration//GEN-END:variables
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
