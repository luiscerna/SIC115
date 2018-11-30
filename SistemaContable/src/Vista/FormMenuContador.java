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

        jPanel1 = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnPlanilla = new javax.swing.JButton();
        btnLibroMayor = new javax.swing.JButton();
        btnTransaccion = new javax.swing.JButton();
        btnEstadosF = new javax.swing.JButton();
        btnEstadosCostos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblBienvenida.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        lblBienvenida.setText("Bienvenido \"Nombre Usuario\"");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N
        jLabel1.setText("Logo aqui");

        btnCerrarSesion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnPlanilla.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        btnPlanilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonpanill.jpg"))); // NOI18N
        btnPlanilla.setBorder(null);
        btnPlanilla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlanilla.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonplanill_press.jpg"))); // NOI18N
        btnPlanilla.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonplanill_press.jpg"))); // NOI18N

        btnLibroMayor.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        btnLibroMayor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonLibM.jpg"))); // NOI18N
        btnLibroMayor.setBorder(null);
        btnLibroMayor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibroMayor.setFocusPainted(false);
        btnLibroMayor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonlibM_press.jpg"))); // NOI18N
        btnLibroMayor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonlibM_press.jpg"))); // NOI18N
        btnLibroMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibroMayorActionPerformed(evt);
            }
        });

        btnTransaccion.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        btnTransaccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botontransa.jpg"))); // NOI18N
        btnTransaccion.setBorder(null);
        btnTransaccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTransaccion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonTransa_press.jpg"))); // NOI18N
        btnTransaccion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonTransa_press.jpg"))); // NOI18N
        btnTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaccionActionPerformed(evt);
            }
        });

        btnEstadosF.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        btnEstadosF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonEstadosf.jpg"))); // NOI18N
        btnEstadosF.setAutoscrolls(true);
        btnEstadosF.setBorder(null);
        btnEstadosF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstadosF.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonEstadosF_press.jpg"))); // NOI18N
        btnEstadosF.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonEstadosF_press.jpg"))); // NOI18N

        btnEstadosCostos.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        btnEstadosCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btonEstadosCos.jpg"))); // NOI18N
        btnEstadosCostos.setToolTipText("");
        btnEstadosCostos.setBorder(null);
        btnEstadosCostos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstadosCostos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btonEstadosCos_press.jpg"))); // NOI18N
        btnEstadosCostos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btonEstadosCos_press.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEstadosF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLibroMayor)
                            .addComponent(btnPlanilla))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEstadosCostos)
                .addGap(256, 256, 256))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrarSesion)
                    .addComponent(lblBienvenida))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnEstadosF)
                        .addGap(43, 43, 43)
                        .addComponent(btnTransaccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnLibroMayor)
                        .addGap(53, 53, 53)
                        .addComponent(btnPlanilla)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstadosCostos)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private javax.swing.JPanel jPanel1;
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
