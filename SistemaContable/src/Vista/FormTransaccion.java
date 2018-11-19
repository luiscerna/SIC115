package Vista;

import Controlador.TransaccionControl;
import Modelo.AuxiliarTransaccion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FormTransaccion extends javax.swing.JFrame {
ArrayList <AuxiliarTransaccion> regTransacciones= new ArrayList<AuxiliarTransaccion>();
ArrayList <AuxiliarTransaccion> regDetalleGastoAdelantado= new ArrayList<AuxiliarTransaccion>();
ArrayList <AuxiliarTransaccion> regDetalleInteresesAcumulados= new ArrayList<AuxiliarTransaccion>();
ArrayList <AuxiliarTransaccion> regDetalleActivoFijo= new ArrayList<AuxiliarTransaccion>();

Double [] montoTransacciones= new Double[2];
Double [] montoDetalleGastoAdelantado= new Double[2];
Double [] montoDetalleInteresesAcumulados= new Double[2];
Double [] montoDetalleActivoFijo= new Double[2];

    /** Creates new form FormTransaccion */
    public FormTransaccion() {
        initComponents();
        inicializandoComponentes();
        tabDetalleGastoAdelantado.setEnabled(false);
    }
    
    //metodo para inicializar valores
    private void inicializandoComponentes()
    {
        //botones
        btnGuardarTrans.setEnabled(false);
        btnGuardarDGA.setEnabled(false);
        btnGuardarDIA.setEnabled(false);
        btnGuardarDAF.setEnabled(false);
        
        //radios
        radioCargoTrans.setSelected(true);
        radioCargoDGA.setSelected(true);
        radioCargoDIA.setSelected(true);
        radioCargoDAF.setSelected(true);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngpTransacciones = new javax.swing.ButtonGroup();
        btngpDetalleGastoAdelantado = new javax.swing.ButtonGroup();
        btngpDetalleInteresesAcumulados = new javax.swing.ButtonGroup();
        btngpDetalleActivoFijo = new javax.swing.ButtonGroup();
        panelesTransaccion = new javax.swing.JTabbedPane();
        tabTransacciones = new javax.swing.JPanel();
        lblNumPartidaTrans = new javax.swing.JLabel();
        lblValNumPartidaTrans = new javax.swing.JLabel();
        lblFechaTrans = new javax.swing.JLabel();
        lblValFechaTrans = new javax.swing.JLabel();
        lblConceptoGeneralTrans = new javax.swing.JLabel();
        txtConceptoGeneralTrans = new javax.swing.JTextField();
        lblNumCuentaTrans = new javax.swing.JLabel();
        txtNumCuentaTrans = new javax.swing.JTextField();
        btnCatalogoTrans = new javax.swing.JButton();
        panelTipoTrans = new javax.swing.JPanel();
        radioCargoTrans = new javax.swing.JRadioButton();
        radioAbonoTrans = new javax.swing.JRadioButton();
        lblMontoTrans = new javax.swing.JLabel();
        txtMontoTrans = new javax.swing.JTextField();
        btnRegistrarTrans = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTransacciones = new javax.swing.JTable();
        lblTotalesTrans = new javax.swing.JLabel();
        lblTotalDebeTrans = new javax.swing.JLabel();
        lblTotalHaberTrans = new javax.swing.JLabel();
        lblDiferenciaTrans = new javax.swing.JLabel();
        lblValDiferenciaHaberTrans = new javax.swing.JLabel();
        btnBorrarTrans = new javax.swing.JButton();
        btnGuardarTrans = new javax.swing.JButton();
        tabDetalleGastoAdelantado = new javax.swing.JPanel();
        lblValNumPartidaDGA = new javax.swing.JLabel();
        lblFechaDGA = new javax.swing.JLabel();
        lblValFechaDGA = new javax.swing.JLabel();
        lblConceptoGeneralDGA = new javax.swing.JLabel();
        txtConceptoGeneralDGA = new javax.swing.JTextField();
        lblNumCuentaDGA = new javax.swing.JLabel();
        txtNumCuentaDGA = new javax.swing.JTextField();
        btnCatalogoDGA = new javax.swing.JButton();
        panelTipoDGA = new javax.swing.JPanel();
        radioCargoDGA = new javax.swing.JRadioButton();
        radioAbonoDGA = new javax.swing.JRadioButton();
        lblMontoDGA = new javax.swing.JLabel();
        txtMontoDGA = new javax.swing.JTextField();
        btnRegistrarDGA = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDetalleGastosAdelantados = new javax.swing.JTable();
        lblTotalesDGA = new javax.swing.JLabel();
        lblTotalDebeDGA = new javax.swing.JLabel();
        lblTotalHaberDGA = new javax.swing.JLabel();
        lblDiferenciaDGA = new javax.swing.JLabel();
        lblValDiferenciaHaberDGA = new javax.swing.JLabel();
        btnBorrarDGA = new javax.swing.JButton();
        btnGuardarDGA = new javax.swing.JButton();
        lblNumPartidaDGA = new javax.swing.JLabel();
        tabDetalleInteresesAcumulados = new javax.swing.JPanel();
        lblNumPartidaDIA = new javax.swing.JLabel();
        lblValNumPartidaDIA = new javax.swing.JLabel();
        lblFechaDIA = new javax.swing.JLabel();
        lblValFechaDIA = new javax.swing.JLabel();
        lblConceptoGeneralDIA = new javax.swing.JLabel();
        txtConceptoGeneralDIA = new javax.swing.JTextField();
        lblNumCuentaDIA = new javax.swing.JLabel();
        txtNumCuentaDIA = new javax.swing.JTextField();
        btnCatalogoDIA = new javax.swing.JButton();
        panelTipoDIA = new javax.swing.JPanel();
        radioCargoDIA = new javax.swing.JRadioButton();
        radioAbonoDIA = new javax.swing.JRadioButton();
        lblMontoDIA = new javax.swing.JLabel();
        txtMontoDIA = new javax.swing.JTextField();
        btnRegistrarDIA = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDetalleInteresesAcumulados = new javax.swing.JTable();
        lblTotalesDIA = new javax.swing.JLabel();
        lblTotalDebeDIA = new javax.swing.JLabel();
        lblTotalHaberDIA = new javax.swing.JLabel();
        lblDiferenciaDIA = new javax.swing.JLabel();
        lblValDiferenciaHaberDIA = new javax.swing.JLabel();
        btnBorrarDIA = new javax.swing.JButton();
        btnGuardarDIA = new javax.swing.JButton();
        tabDetalleActivoFijo = new javax.swing.JPanel();
        lblNumPartidaDAF = new javax.swing.JLabel();
        lblValNumPartidaDAF = new javax.swing.JLabel();
        lblFechaDAF = new javax.swing.JLabel();
        lblValFechaDAF = new javax.swing.JLabel();
        lblConceptoGeneralDAF = new javax.swing.JLabel();
        txtConceptoGeneralDAF = new javax.swing.JTextField();
        lblNumCuentaDAF = new javax.swing.JLabel();
        txtNumCuentaDAF = new javax.swing.JTextField();
        btnCatalogoDAF = new javax.swing.JButton();
        panelTipoDAF = new javax.swing.JPanel();
        radioCargoDAF = new javax.swing.JRadioButton();
        radioAbonoDAF = new javax.swing.JRadioButton();
        lblMontoDAF = new javax.swing.JLabel();
        txtMontoDAF = new javax.swing.JTextField();
        btnRegistrarDAF = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableDetalleActivoFijo = new javax.swing.JTable();
        lblTotalesDAF = new javax.swing.JLabel();
        lblTotalDebeDAF = new javax.swing.JLabel();
        lblTotalHaberDAF = new javax.swing.JLabel();
        lblDiferenciaDAF = new javax.swing.JLabel();
        lblValDiferenciaHaberDAF = new javax.swing.JLabel();
        btnBorrarDAF = new javax.swing.JButton();
        btnGuardarDAF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNumPartidaTrans.setText("Numero de Partida:");

        lblValNumPartidaTrans.setText("Valor de numero de partida");

        lblFechaTrans.setText("Fecha:");

        lblValFechaTrans.setText("Valor de fecha");

        lblConceptoGeneralTrans.setText("Concepto General:");

        lblNumCuentaTrans.setText("Numero de Cuenta:");

        btnCatalogoTrans.setText("Catalogo");

        panelTipoTrans.setBorder(javax.swing.BorderFactory.createTitledBorder("tipo"));

        btngpTransacciones.add(radioCargoTrans);
        radioCargoTrans.setText("Cargo");

        btngpTransacciones.add(radioAbonoTrans);
        radioAbonoTrans.setText("Abono");

        javax.swing.GroupLayout panelTipoTransLayout = new javax.swing.GroupLayout(panelTipoTrans);
        panelTipoTrans.setLayout(panelTipoTransLayout);
        panelTipoTransLayout.setHorizontalGroup(
            panelTipoTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoTransLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTipoTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCargoTrans)
                    .addComponent(radioAbonoTrans))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelTipoTransLayout.setVerticalGroup(
            panelTipoTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoTransLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioCargoTrans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(radioAbonoTrans)
                .addContainerGap())
        );

        lblMontoTrans.setText("Monto:");

        btnRegistrarTrans.setText("Registrar");
        btnRegistrarTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarTransActionPerformed(evt);
            }
        });

        tableTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Cuenta", "Cuenta", "Debe", "Haber"
            }
        ));
        jScrollPane1.setViewportView(tableTransacciones);

        lblTotalesTrans.setText("Totales:");

        lblTotalDebeTrans.setText("Total Debe");

        lblTotalHaberTrans.setText("Total Haber");

        lblDiferenciaTrans.setText("Diferencia:");

        lblValDiferenciaHaberTrans.setText("Valor de la diferencia de Debe y Haber");

        btnBorrarTrans.setText("Borrar Linea de Registro");

        btnGuardarTrans.setText("Guardar y Finalizar");
        btnGuardarTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTransActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabTransaccionesLayout = new javax.swing.GroupLayout(tabTransacciones);
        tabTransacciones.setLayout(tabTransaccionesLayout);
        tabTransaccionesLayout.setHorizontalGroup(
            tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTransaccionesLayout.createSequentialGroup()
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(tabTransaccionesLayout.createSequentialGroup()
                                    .addComponent(lblConceptoGeneralTrans)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtConceptoGeneralTrans))
                                .addGroup(tabTransaccionesLayout.createSequentialGroup()
                                    .addComponent(lblNumPartidaTrans)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblValNumPartidaTrans)
                                    .addGap(134, 134, 134)
                                    .addComponent(lblFechaTrans)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblValFechaTrans)))
                            .addGroup(tabTransaccionesLayout.createSequentialGroup()
                                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMontoTrans)
                                    .addComponent(lblNumCuentaTrans))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumCuentaTrans, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(txtMontoTrans))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCatalogoTrans)
                                .addGap(50, 50, 50)
                                .addComponent(panelTipoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrarTrans))))
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnBorrarTrans)
                        .addGap(68, 68, 68)
                        .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarTrans)
                            .addGroup(tabTransaccionesLayout.createSequentialGroup()
                                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDiferenciaTrans)
                                    .addComponent(lblTotalesTrans))
                                .addGap(62, 62, 62)
                                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                                        .addComponent(lblTotalDebeTrans)
                                        .addGap(83, 83, 83)
                                        .addComponent(lblTotalHaberTrans))
                                    .addComponent(lblValDiferenciaHaberTrans))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        tabTransaccionesLayout.setVerticalGroup(
            tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTransaccionesLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumPartidaTrans)
                    .addComponent(lblValNumPartidaTrans)
                    .addComponent(lblFechaTrans)
                    .addComponent(lblValFechaTrans))
                .addGap(29, 29, 29)
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConceptoGeneralTrans)
                    .addComponent(txtConceptoGeneralTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumCuentaTrans)
                            .addComponent(txtNumCuentaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCatalogoTrans))
                        .addGap(18, 18, 18)
                        .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMontoTrans)
                            .addComponent(txtMontoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelTipoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnRegistrarTrans)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalesTrans)
                    .addComponent(lblTotalDebeTrans)
                    .addComponent(lblTotalHaberTrans))
                .addGap(39, 39, 39)
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiferenciaTrans)
                    .addComponent(lblValDiferenciaHaberTrans))
                .addGap(18, 18, 18)
                .addComponent(btnBorrarTrans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarTrans)
                .addGap(31, 31, 31))
        );

        panelesTransaccion.addTab("Transacciones", tabTransacciones);

        lblValNumPartidaDGA.setText("Valor de numero de partida");

        lblFechaDGA.setText("Fecha:");

        lblValFechaDGA.setText("Valor de fecha");

        lblConceptoGeneralDGA.setText("Concepto General:");

        lblNumCuentaDGA.setText("Numero de Cuenta:");

        btnCatalogoDGA.setText("Catalogo");

        panelTipoDGA.setBorder(javax.swing.BorderFactory.createTitledBorder("tipo"));

        btngpDetalleGastoAdelantado.add(radioCargoDGA);
        radioCargoDGA.setText("Cargo");

        btngpDetalleGastoAdelantado.add(radioAbonoDGA);
        radioAbonoDGA.setText("Abono");

        javax.swing.GroupLayout panelTipoDGALayout = new javax.swing.GroupLayout(panelTipoDGA);
        panelTipoDGA.setLayout(panelTipoDGALayout);
        panelTipoDGALayout.setHorizontalGroup(
            panelTipoDGALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoDGALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTipoDGALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCargoDGA)
                    .addComponent(radioAbonoDGA))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelTipoDGALayout.setVerticalGroup(
            panelTipoDGALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoDGALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioCargoDGA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(radioAbonoDGA)
                .addContainerGap())
        );

        lblMontoDGA.setText("Monto:");

        btnRegistrarDGA.setText("Registrar");
        btnRegistrarDGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDGAActionPerformed(evt);
            }
        });

        tableDetalleGastosAdelantados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Cuenta", "Cuenta", "Debe", "Haber"
            }
        ));
        jScrollPane2.setViewportView(tableDetalleGastosAdelantados);

        lblTotalesDGA.setText("Totales:");

        lblTotalDebeDGA.setText("Total Debe");

        lblTotalHaberDGA.setText("Total Haber");

        lblDiferenciaDGA.setText("Diferencia:");

        lblValDiferenciaHaberDGA.setText("Valor de la diferencia de Debe y Haber");

        btnBorrarDGA.setText("Borrar Linea de Registro");

        btnGuardarDGA.setText("Guardar y Finalizar");

        lblNumPartidaDGA.setText("Numero de Partida:");

        javax.swing.GroupLayout tabDetalleGastoAdelantadoLayout = new javax.swing.GroupLayout(tabDetalleGastoAdelantado);
        tabDetalleGastoAdelantado.setLayout(tabDetalleGastoAdelantadoLayout);
        tabDetalleGastoAdelantadoLayout.setHorizontalGroup(
            tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                                    .addComponent(lblConceptoGeneralDGA)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtConceptoGeneralDGA))
                                .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                                    .addComponent(lblNumPartidaDGA)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblValNumPartidaDGA)
                                    .addGap(134, 134, 134)
                                    .addComponent(lblFechaDGA)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblValFechaDGA)))
                            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMontoDGA)
                                    .addComponent(lblNumCuentaDGA))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumCuentaDGA, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(txtMontoDGA))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCatalogoDGA)
                                .addGap(50, 50, 50)
                                .addComponent(panelTipoDGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrarDGA))))
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnBorrarDGA)
                        .addGap(68, 68, 68)
                        .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarDGA)
                            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDiferenciaDGA)
                                    .addComponent(lblTotalesDGA))
                                .addGap(62, 62, 62)
                                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                                        .addComponent(lblTotalDebeDGA)
                                        .addGap(83, 83, 83)
                                        .addComponent(lblTotalHaberDGA))
                                    .addComponent(lblValDiferenciaHaberDGA))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        tabDetalleGastoAdelantadoLayout.setVerticalGroup(
            tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumPartidaDGA)
                    .addComponent(lblValNumPartidaDGA)
                    .addComponent(lblFechaDGA)
                    .addComponent(lblValFechaDGA))
                .addGap(29, 29, 29)
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConceptoGeneralDGA)
                    .addComponent(txtConceptoGeneralDGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumCuentaDGA)
                            .addComponent(txtNumCuentaDGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCatalogoDGA))
                        .addGap(18, 18, 18)
                        .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMontoDGA)
                            .addComponent(txtMontoDGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelTipoDGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnRegistrarDGA)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalesDGA)
                    .addComponent(lblTotalDebeDGA)
                    .addComponent(lblTotalHaberDGA))
                .addGap(39, 39, 39)
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiferenciaDGA)
                    .addComponent(lblValDiferenciaHaberDGA))
                .addGap(18, 18, 18)
                .addComponent(btnBorrarDGA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarDGA)
                .addGap(31, 31, 31))
        );

        panelesTransaccion.addTab("Detalle Gasto Adelantado", tabDetalleGastoAdelantado);

        lblNumPartidaDIA.setText("Numero de Partida:");

        lblValNumPartidaDIA.setText("Valor de numero de partida");

        lblFechaDIA.setText("Fecha:");

        lblValFechaDIA.setText("Valor de fecha");

        lblConceptoGeneralDIA.setText("Concepto General:");

        lblNumCuentaDIA.setText("Numero de Cuenta:");

        btnCatalogoDIA.setText("Catalogo");

        panelTipoDIA.setBorder(javax.swing.BorderFactory.createTitledBorder("tipo"));

        btngpDetalleInteresesAcumulados.add(radioCargoDIA);
        radioCargoDIA.setText("Cargo");

        btngpDetalleInteresesAcumulados.add(radioAbonoDIA);
        radioAbonoDIA.setText("Abono");

        javax.swing.GroupLayout panelTipoDIALayout = new javax.swing.GroupLayout(panelTipoDIA);
        panelTipoDIA.setLayout(panelTipoDIALayout);
        panelTipoDIALayout.setHorizontalGroup(
            panelTipoDIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoDIALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTipoDIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCargoDIA)
                    .addComponent(radioAbonoDIA))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelTipoDIALayout.setVerticalGroup(
            panelTipoDIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoDIALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioCargoDIA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(radioAbonoDIA)
                .addContainerGap())
        );

        lblMontoDIA.setText("Monto:");

        btnRegistrarDIA.setText("Registrar");
        btnRegistrarDIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDIAActionPerformed(evt);
            }
        });

        tableDetalleInteresesAcumulados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Cuenta", "Cuenta", "Debe", "Haber"
            }
        ));
        jScrollPane3.setViewportView(tableDetalleInteresesAcumulados);

        lblTotalesDIA.setText("Totales:");

        lblTotalDebeDIA.setText("Total Debe");

        lblTotalHaberDIA.setText("Total Haber");

        lblDiferenciaDIA.setText("Diferencia:");

        lblValDiferenciaHaberDIA.setText("Valor de la diferencia de Debe y Haber");

        btnBorrarDIA.setText("Borrar Linea de Registro");

        btnGuardarDIA.setText("Guardar y Finalizar");

        javax.swing.GroupLayout tabDetalleInteresesAcumuladosLayout = new javax.swing.GroupLayout(tabDetalleInteresesAcumulados);
        tabDetalleInteresesAcumulados.setLayout(tabDetalleInteresesAcumuladosLayout);
        tabDetalleInteresesAcumuladosLayout.setHorizontalGroup(
            tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                                    .addComponent(lblConceptoGeneralDIA)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtConceptoGeneralDIA))
                                .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                                    .addComponent(lblNumPartidaDIA)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblValNumPartidaDIA)
                                    .addGap(134, 134, 134)
                                    .addComponent(lblFechaDIA)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblValFechaDIA)))
                            .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMontoDIA)
                                    .addComponent(lblNumCuentaDIA))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumCuentaDIA, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(txtMontoDIA))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCatalogoDIA)
                                .addGap(50, 50, 50)
                                .addComponent(panelTipoDIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrarDIA))))
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnBorrarDIA)
                        .addGap(68, 68, 68)
                        .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarDIA)
                            .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDiferenciaDIA)
                                    .addComponent(lblTotalesDIA))
                                .addGap(62, 62, 62)
                                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                                        .addComponent(lblTotalDebeDIA)
                                        .addGap(83, 83, 83)
                                        .addComponent(lblTotalHaberDIA))
                                    .addComponent(lblValDiferenciaHaberDIA))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        tabDetalleInteresesAcumuladosLayout.setVerticalGroup(
            tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumPartidaDIA)
                    .addComponent(lblValNumPartidaDIA)
                    .addComponent(lblFechaDIA)
                    .addComponent(lblValFechaDIA))
                .addGap(29, 29, 29)
                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConceptoGeneralDIA)
                    .addComponent(txtConceptoGeneralDIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumCuentaDIA)
                            .addComponent(txtNumCuentaDIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCatalogoDIA))
                        .addGap(18, 18, 18)
                        .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMontoDIA)
                            .addComponent(txtMontoDIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelTipoDIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnRegistrarDIA)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalesDIA)
                    .addComponent(lblTotalDebeDIA)
                    .addComponent(lblTotalHaberDIA))
                .addGap(39, 39, 39)
                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiferenciaDIA)
                    .addComponent(lblValDiferenciaHaberDIA))
                .addGap(18, 18, 18)
                .addComponent(btnBorrarDIA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarDIA)
                .addGap(31, 31, 31))
        );

        panelesTransaccion.addTab("Detalle Intereses Acumulados", tabDetalleInteresesAcumulados);

        lblNumPartidaDAF.setText("Numero de Partida:");

        lblValNumPartidaDAF.setText("Valor de numero de partida");

        lblFechaDAF.setText("Fecha:");

        lblValFechaDAF.setText("Valor de fecha");

        lblConceptoGeneralDAF.setText("Concepto General:");

        lblNumCuentaDAF.setText("Numero de Cuenta:");

        btnCatalogoDAF.setText("Catalogo");

        panelTipoDAF.setBorder(javax.swing.BorderFactory.createTitledBorder("tipo"));

        btngpDetalleActivoFijo.add(radioCargoDAF);
        radioCargoDAF.setText("Cargo");

        btngpDetalleActivoFijo.add(radioAbonoDAF);
        radioAbonoDAF.setText("Abono");

        javax.swing.GroupLayout panelTipoDAFLayout = new javax.swing.GroupLayout(panelTipoDAF);
        panelTipoDAF.setLayout(panelTipoDAFLayout);
        panelTipoDAFLayout.setHorizontalGroup(
            panelTipoDAFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoDAFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTipoDAFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioCargoDAF)
                    .addComponent(radioAbonoDAF))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelTipoDAFLayout.setVerticalGroup(
            panelTipoDAFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoDAFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioCargoDAF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(radioAbonoDAF)
                .addContainerGap())
        );

        lblMontoDAF.setText("Monto:");

        btnRegistrarDAF.setText("Registrar");
        btnRegistrarDAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDAFActionPerformed(evt);
            }
        });

        tableDetalleActivoFijo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Cuenta", "Cuenta", "Debe", "Haber"
            }
        ));
        jScrollPane4.setViewportView(tableDetalleActivoFijo);

        lblTotalesDAF.setText("Totales:");

        lblTotalDebeDAF.setText("Total Debe");

        lblTotalHaberDAF.setText("Total Haber");

        lblDiferenciaDAF.setText("Diferencia:");

        lblValDiferenciaHaberDAF.setText("Valor de la diferencia de Debe y Haber");

        btnBorrarDAF.setText("Borrar Linea de Registro");

        btnGuardarDAF.setText("Guardar y Finalizar");

        javax.swing.GroupLayout tabDetalleActivoFijoLayout = new javax.swing.GroupLayout(tabDetalleActivoFijo);
        tabDetalleActivoFijo.setLayout(tabDetalleActivoFijoLayout);
        tabDetalleActivoFijoLayout.setHorizontalGroup(
            tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                                    .addComponent(lblConceptoGeneralDAF)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtConceptoGeneralDAF))
                                .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                                    .addComponent(lblNumPartidaDAF)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblValNumPartidaDAF)
                                    .addGap(134, 134, 134)
                                    .addComponent(lblFechaDAF)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblValFechaDAF)))
                            .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMontoDAF)
                                    .addComponent(lblNumCuentaDAF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumCuentaDAF, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(txtMontoDAF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCatalogoDAF)
                                .addGap(50, 50, 50)
                                .addComponent(panelTipoDAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrarDAF))))
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnBorrarDAF)
                        .addGap(68, 68, 68)
                        .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarDAF)
                            .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDiferenciaDAF)
                                    .addComponent(lblTotalesDAF))
                                .addGap(62, 62, 62)
                                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                                        .addComponent(lblTotalDebeDAF)
                                        .addGap(83, 83, 83)
                                        .addComponent(lblTotalHaberDAF))
                                    .addComponent(lblValDiferenciaHaberDAF))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        tabDetalleActivoFijoLayout.setVerticalGroup(
            tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumPartidaDAF)
                    .addComponent(lblValNumPartidaDAF)
                    .addComponent(lblFechaDAF)
                    .addComponent(lblValFechaDAF))
                .addGap(29, 29, 29)
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConceptoGeneralDAF)
                    .addComponent(txtConceptoGeneralDAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumCuentaDAF)
                            .addComponent(txtNumCuentaDAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCatalogoDAF))
                        .addGap(18, 18, 18)
                        .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMontoDAF)
                            .addComponent(txtMontoDAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelTipoDAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnRegistrarDAF)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalesDAF)
                    .addComponent(lblTotalDebeDAF)
                    .addComponent(lblTotalHaberDAF))
                .addGap(39, 39, 39)
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiferenciaDAF)
                    .addComponent(lblValDiferenciaHaberDAF))
                .addGap(18, 18, 18)
                .addComponent(btnBorrarDAF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarDAF)
                .addGap(31, 31, 31))
        );

        panelesTransaccion.addTab("Detalle Activo Fijo", tabDetalleActivoFijo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelesTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelesTransaccion)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTransActionPerformed
        //obtenido valores de los campos
        try{
            String conceptoGeneral= txtConceptoGeneralTrans.getText();
            String codigoCuenta= txtNumCuentaTrans.getText();
            String monto= txtMontoTrans.getText();
            
            TransaccionControl.agregarElementoTabla(conceptoGeneral,codigoCuenta,"Prueba",monto, radioCargoTrans.isSelected(), tableTransacciones, regTransacciones);
            TransaccionControl.calcularTotalesYDiferencia(montoTransacciones, regTransacciones, lblTotalDebeTrans, lblTotalHaberTrans, lblValDiferenciaHaberTrans);
            TransaccionControl.validadorPartidaDoble(montoTransacciones, btnGuardarTrans);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error!\nCampos vacios o con formatos erroneos");
        }
    }//GEN-LAST:event_btnRegistrarTransActionPerformed

    private void btnGuardarTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarTransActionPerformed

    private void btnRegistrarDGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDGAActionPerformed
        //obtenido valores de los campos
        try{
            String conceptoGeneral= txtConceptoGeneralDGA.getText();
            String codigoCuenta= txtNumCuentaDGA.getText();
            String monto= txtMontoDGA.getText();
            
            TransaccionControl.agregarElementoTabla(conceptoGeneral,codigoCuenta,"Prueba",monto, radioCargoDGA.isSelected(), tableDetalleGastosAdelantados, regDetalleGastoAdelantado);
            TransaccionControl.calcularTotalesYDiferencia(montoDetalleGastoAdelantado, regDetalleGastoAdelantado, lblTotalDebeDGA, lblTotalHaberDGA, lblValDiferenciaHaberDGA);
            TransaccionControl.validadorPartidaDoble(montoDetalleGastoAdelantado, btnGuardarDGA);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error!\nCampos vacios o con formatos erroneos");
        }
    }//GEN-LAST:event_btnRegistrarDGAActionPerformed

    private void btnRegistrarDIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDIAActionPerformed
        //obtenido valores de los campos
        try{
            String conceptoGeneral= txtConceptoGeneralDIA.getText();
            String codigoCuenta= txtNumCuentaDIA.getText();
            String monto= txtMontoDIA.getText();
            
            TransaccionControl.agregarElementoTabla(conceptoGeneral,codigoCuenta,"Prueba",monto, radioCargoDIA.isSelected(), tableDetalleInteresesAcumulados, regDetalleInteresesAcumulados);
            TransaccionControl.calcularTotalesYDiferencia(montoDetalleInteresesAcumulados, regDetalleInteresesAcumulados, lblTotalDebeDIA, lblTotalHaberDIA, lblValDiferenciaHaberDIA);
            TransaccionControl.validadorPartidaDoble(montoDetalleInteresesAcumulados, btnGuardarDIA);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error!\nCampos vacios o con formatos erroneos");
        }
    }//GEN-LAST:event_btnRegistrarDIAActionPerformed

    private void btnRegistrarDAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDAFActionPerformed
        //obtenido valores de los campos
        try{
            String conceptoGeneral= txtConceptoGeneralDAF.getText();
            String codigoCuenta= txtNumCuentaDAF.getText();
            String monto= txtMontoDAF.getText();
            
            TransaccionControl.agregarElementoTabla(conceptoGeneral,codigoCuenta,"Prueba",monto, radioCargoDAF.isSelected(), tableDetalleActivoFijo, regDetalleActivoFijo);
            TransaccionControl.calcularTotalesYDiferencia(montoDetalleActivoFijo, regDetalleActivoFijo, lblTotalDebeDAF, lblTotalHaberDAF, lblValDiferenciaHaberDAF);
            TransaccionControl.validadorPartidaDoble(montoDetalleActivoFijo, btnGuardarDAF);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error!\nCampos vacios o con formatos erroneos");
        }
    }//GEN-LAST:event_btnRegistrarDAFActionPerformed

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
    private javax.swing.JButton btnBorrarDAF;
    private javax.swing.JButton btnBorrarDGA;
    private javax.swing.JButton btnBorrarDIA;
    private javax.swing.JButton btnBorrarTrans;
    private javax.swing.JButton btnCatalogoDAF;
    private javax.swing.JButton btnCatalogoDGA;
    private javax.swing.JButton btnCatalogoDIA;
    private javax.swing.JButton btnCatalogoTrans;
    private javax.swing.JButton btnGuardarDAF;
    private javax.swing.JButton btnGuardarDGA;
    private javax.swing.JButton btnGuardarDIA;
    private javax.swing.JButton btnGuardarTrans;
    private javax.swing.JButton btnRegistrarDAF;
    private javax.swing.JButton btnRegistrarDGA;
    private javax.swing.JButton btnRegistrarDIA;
    private javax.swing.JButton btnRegistrarTrans;
    private javax.swing.ButtonGroup btngpDetalleActivoFijo;
    private javax.swing.ButtonGroup btngpDetalleGastoAdelantado;
    private javax.swing.ButtonGroup btngpDetalleInteresesAcumulados;
    private javax.swing.ButtonGroup btngpTransacciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblConceptoGeneralDAF;
    private javax.swing.JLabel lblConceptoGeneralDGA;
    private javax.swing.JLabel lblConceptoGeneralDIA;
    private javax.swing.JLabel lblConceptoGeneralTrans;
    private javax.swing.JLabel lblDiferenciaDAF;
    private javax.swing.JLabel lblDiferenciaDGA;
    private javax.swing.JLabel lblDiferenciaDIA;
    private javax.swing.JLabel lblDiferenciaTrans;
    private javax.swing.JLabel lblFechaDAF;
    private javax.swing.JLabel lblFechaDGA;
    private javax.swing.JLabel lblFechaDIA;
    private javax.swing.JLabel lblFechaTrans;
    private javax.swing.JLabel lblMontoDAF;
    private javax.swing.JLabel lblMontoDGA;
    private javax.swing.JLabel lblMontoDIA;
    private javax.swing.JLabel lblMontoTrans;
    private javax.swing.JLabel lblNumCuentaDAF;
    private javax.swing.JLabel lblNumCuentaDGA;
    private javax.swing.JLabel lblNumCuentaDIA;
    private javax.swing.JLabel lblNumCuentaTrans;
    private javax.swing.JLabel lblNumPartidaDAF;
    private javax.swing.JLabel lblNumPartidaDGA;
    private javax.swing.JLabel lblNumPartidaDIA;
    private javax.swing.JLabel lblNumPartidaTrans;
    private javax.swing.JLabel lblTotalDebeDAF;
    private javax.swing.JLabel lblTotalDebeDGA;
    private javax.swing.JLabel lblTotalDebeDIA;
    private javax.swing.JLabel lblTotalDebeTrans;
    private javax.swing.JLabel lblTotalHaberDAF;
    private javax.swing.JLabel lblTotalHaberDGA;
    private javax.swing.JLabel lblTotalHaberDIA;
    private javax.swing.JLabel lblTotalHaberTrans;
    private javax.swing.JLabel lblTotalesDAF;
    private javax.swing.JLabel lblTotalesDGA;
    private javax.swing.JLabel lblTotalesDIA;
    private javax.swing.JLabel lblTotalesTrans;
    private javax.swing.JLabel lblValDiferenciaHaberDAF;
    private javax.swing.JLabel lblValDiferenciaHaberDGA;
    private javax.swing.JLabel lblValDiferenciaHaberDIA;
    private javax.swing.JLabel lblValDiferenciaHaberTrans;
    private javax.swing.JLabel lblValFechaDAF;
    private javax.swing.JLabel lblValFechaDGA;
    private javax.swing.JLabel lblValFechaDIA;
    private javax.swing.JLabel lblValFechaTrans;
    private javax.swing.JLabel lblValNumPartidaDAF;
    private javax.swing.JLabel lblValNumPartidaDGA;
    private javax.swing.JLabel lblValNumPartidaDIA;
    private javax.swing.JLabel lblValNumPartidaTrans;
    private javax.swing.JPanel panelTipoDAF;
    private javax.swing.JPanel panelTipoDGA;
    private javax.swing.JPanel panelTipoDIA;
    private javax.swing.JPanel panelTipoTrans;
    private javax.swing.JTabbedPane panelesTransaccion;
    private javax.swing.JRadioButton radioAbonoDAF;
    private javax.swing.JRadioButton radioAbonoDGA;
    private javax.swing.JRadioButton radioAbonoDIA;
    private javax.swing.JRadioButton radioAbonoTrans;
    private javax.swing.JRadioButton radioCargoDAF;
    private javax.swing.JRadioButton radioCargoDGA;
    private javax.swing.JRadioButton radioCargoDIA;
    private javax.swing.JRadioButton radioCargoTrans;
    private javax.swing.JPanel tabDetalleActivoFijo;
    private javax.swing.JPanel tabDetalleGastoAdelantado;
    private javax.swing.JPanel tabDetalleInteresesAcumulados;
    private javax.swing.JPanel tabTransacciones;
    private javax.swing.JTable tableDetalleActivoFijo;
    private javax.swing.JTable tableDetalleGastosAdelantados;
    private javax.swing.JTable tableDetalleInteresesAcumulados;
    private javax.swing.JTable tableTransacciones;
    private javax.swing.JTextField txtConceptoGeneralDAF;
    private javax.swing.JTextField txtConceptoGeneralDGA;
    private javax.swing.JTextField txtConceptoGeneralDIA;
    private javax.swing.JTextField txtConceptoGeneralTrans;
    private javax.swing.JTextField txtMontoDAF;
    private javax.swing.JTextField txtMontoDGA;
    private javax.swing.JTextField txtMontoDIA;
    private javax.swing.JTextField txtMontoTrans;
    private javax.swing.JTextField txtNumCuentaDAF;
    private javax.swing.JTextField txtNumCuentaDGA;
    private javax.swing.JTextField txtNumCuentaDIA;
    private javax.swing.JTextField txtNumCuentaTrans;
    // End of variables declaration//GEN-END:variables

}
