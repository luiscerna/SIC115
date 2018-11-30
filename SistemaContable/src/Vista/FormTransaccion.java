package Vista;

import Controlador.TransaccionControl;
import Modelo.AuxiliarTransaccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class FormTransaccion extends javax.swing.JFrame {

   
    //Datos del usuario actual
    private String usuario;
    private int idUsuario;
    private String nombre;
    private String apellido;
    
    //Arreglo de objetos auxiliares para capturar datos de formularios
ArrayList <AuxiliarTransaccion> regTransacciones= new ArrayList<AuxiliarTransaccion>();
ArrayList <AuxiliarTransaccion> regDetalleGastoAdelantado= new ArrayList<AuxiliarTransaccion>();
ArrayList <AuxiliarTransaccion> regDetalleInteresesAcumulados= new ArrayList<AuxiliarTransaccion>();
ArrayList <AuxiliarTransaccion> regDetalleActivoFijo= new ArrayList<AuxiliarTransaccion>();

    //Montos debe y haber de cada tipo de transaccion
Double [] montoTransacciones= new Double[2];
Double [] montoDetalleGastoAdelantado= new Double[2];
Double [] montoDetalleInteresesAcumulados= new Double[2];
Double [] montoDetalleActivoFijo= new Double[2];

//Monto Total de Transaccion
double montoTotal =0;

//Enlace con la Capa Control
TransaccionControl control;

//variable de contexto para capturar nombre
String nombreCuentaActual="";
String categoria="";
int tipoRegistro; //este atributo es para identificar el tipo de transaccion y habilitar formulario

//Valores que determinaran si se debe calcular iva y que tipo de iva
boolean esCompra;
Double [] IVA= new Double[2];

//variable booleana que controlara si se ingreso unicamente en el campo del codigo o se se uso el boton catalogo
boolean usoBoton= false;

    /** Creates new form FormTransaccion */
    public FormTransaccion(String categoria,int tipo) throws SQLException {
        initComponents();
        control=new TransaccionControl();
        inicializandoComponentes();
        inicializandoPestañas(tipo);
        this.categoria=categoria;
        this.tipoRegistro=tipo;
        this.esCompra= (categoria=="Compra");
        this.IVA[0]=0.00;
        this.IVA[1]=0.00;
    }
    public FormTransaccion()throws SQLException {
        initComponents();
        control=new TransaccionControl();
        inicializandoComponentes();
    }
    
    //Metodo de inicializacion de Pestañas
    private void inicializandoPestañas(int tipo)
    {
        //inicializando las pestañas a desabilitado
        panelesTransaccion.setEnabledAt(0,false);
        panelesTransaccion.setEnabledAt(1,false);
        panelesTransaccion.setEnabledAt(2,false);
        panelesTransaccion.setEnabledAt(3,false);
        
        switch(tipo)
        {
            case 0:
                panelesTransaccion.setEnabledAt(0,true);
                panelesTransaccion.setSelectedIndex(0);
                break;
            case 1:
                panelesTransaccion.setEnabledAt(1,true);
                panelesTransaccion.setSelectedIndex(1);
                break;
            case 2:
                panelesTransaccion.setEnabledAt(1,true);
                panelesTransaccion.setSelectedIndex(1);
                break;
            case 3:
                panelesTransaccion.setEnabledAt(1,true);
                panelesTransaccion.setSelectedIndex(1);
                break;
            case 4:
                panelesTransaccion.setEnabledAt(2,true);
                panelesTransaccion.setSelectedIndex(2);
                break;
            case 5:
                panelesTransaccion.setEnabledAt(2,true);
                panelesTransaccion.setSelectedIndex(2);
                break;
            case 6:
                panelesTransaccion.setEnabledAt(3,true);
                panelesTransaccion.setSelectedIndex(3);
                break;
            case 7:
                panelesTransaccion.setEnabledAt(3,true);
                panelesTransaccion.setSelectedIndex(3);
                break;    
        }
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
        
        //fechas
        lblValFechaTrans.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        lblValFechaDGA.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        lblValFechaDIA.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        lblValFechaDAF.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        
        //numPardida's
        lblValNumPartidaTrans.setText(Integer.toString(control.siguienteNumPartida()));
        lblValNumPartidaDGA.setText(Integer.toString(control.siguienteNumPartida()));
        lblValNumPartidaDIA.setText(Integer.toString(control.siguienteNumPartida()));
        lblValNumPartidaDAF.setText(Integer.toString(control.siguienteNumPartida()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngpTransacciones = new javax.swing.ButtonGroup();
        btngpDetalleGastoAdelantado = new javax.swing.ButtonGroup();
        btngpDetalleInteresesAcumulados = new javax.swing.ButtonGroup();
        btngpDetalleActivoFijo = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
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
        checkIVATransaccion = new javax.swing.JCheckBox();
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
        jPanel3 = new javax.swing.JPanel();
        txtValorTotal = new javax.swing.JTextField();
        lblValorTotal = new javax.swing.JLabel();
        lblMesesPagados = new javax.swing.JLabel();
        txtMesesPagados = new javax.swing.JTextField();
        checkIVADGA = new javax.swing.JCheckBox();
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
        jPanel2 = new javax.swing.JPanel();
        txtTasaAnual = new javax.swing.JTextField();
        lblTasaAnual = new javax.swing.JLabel();
        lblValorPresente1 = new javax.swing.JLabel();
        txtValorPresenteDIA = new javax.swing.JTextField();
        checkIVADIA = new javax.swing.JCheckBox();
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
        jPanel1 = new javax.swing.JPanel();
        txtValorSalvamento = new javax.swing.JTextField();
        lblValorSalvamento = new javax.swing.JLabel();
        txtVidaUtil = new javax.swing.JTextField();
        lblVidaUtil = new javax.swing.JLabel();
        lblValorPresente = new javax.swing.JLabel();
        txtValorPresente = new javax.swing.JTextField();
        checkIVADAF = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(136, 175, 174));

        lblNumPartidaTrans.setText("Numero de Partida:");

        lblValNumPartidaTrans.setText("Valor de numero de partida");

        lblFechaTrans.setText("Fecha:");

        lblValFechaTrans.setText("Valor de fecha");

        lblConceptoGeneralTrans.setText("Concepto General:");

        lblNumCuentaTrans.setText("Numero de Cuenta:");

        btnCatalogoTrans.setText("Catalogo");
        btnCatalogoTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoTransActionPerformed(evt);
            }
        });

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
                    .addComponent(radioAbonoTrans)
                    .addComponent(radioCargoTrans))
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
        btnBorrarTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTransActionPerformed(evt);
            }
        });

        btnGuardarTrans.setText("Guardar y Finalizar");
        btnGuardarTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTransActionPerformed(evt);
            }
        });

        checkIVATransaccion.setText("Calcular IVA");

        javax.swing.GroupLayout tabTransaccionesLayout = new javax.swing.GroupLayout(tabTransacciones);
        tabTransacciones.setLayout(tabTransaccionesLayout);
        tabTransaccionesLayout.setHorizontalGroup(
            tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTransaccionesLayout.createSequentialGroup()
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnBorrarTrans)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDiferenciaTrans))
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalesTrans)))
                .addGap(46, 46, 46)
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addComponent(lblTotalDebeTrans)
                        .addGap(57, 57, 57)
                        .addComponent(lblTotalHaberTrans))
                    .addComponent(lblValDiferenciaHaberTrans))
                .addGap(116, 116, 116))
            .addGroup(tabTransaccionesLayout.createSequentialGroup()
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lblNumPartidaTrans)
                        .addGap(7, 7, 7)
                        .addComponent(lblValNumPartidaTrans)
                        .addGap(150, 150, 150)
                        .addComponent(lblFechaTrans)
                        .addGap(17, 17, 17)
                        .addComponent(lblValFechaTrans))
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lblConceptoGeneralTrans)
                        .addGap(10, 10, 10)
                        .addComponent(txtConceptoGeneralTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumCuentaTrans)
                            .addGroup(tabTransaccionesLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(lblMontoTrans)))
                        .addGap(6, 6, 6)
                        .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumCuentaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMontoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabTransaccionesLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnCatalogoTrans))
                            .addGroup(tabTransaccionesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkIVATransaccion)))
                        .addGap(35, 35, 35)
                        .addComponent(panelTipoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(btnRegistrarTrans))
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(btnGuardarTrans)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        tabTransaccionesLayout.setVerticalGroup(
            tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTransaccionesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumPartidaTrans)
                    .addComponent(lblValNumPartidaTrans)
                    .addComponent(lblFechaTrans)
                    .addComponent(lblValFechaTrans))
                .addGap(26, 26, 26)
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConceptoGeneralTrans)
                    .addComponent(txtConceptoGeneralTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addComponent(lblNumCuentaTrans)
                        .addGap(36, 36, 36)
                        .addComponent(lblMontoTrans))
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addComponent(txtNumCuentaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkIVATransaccion)))
                    .addComponent(btnCatalogoTrans)
                    .addComponent(panelTipoTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnRegistrarTrans)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTotalDebeTrans, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblTotalesTrans))
                    .addComponent(lblTotalHaberTrans))
                .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnBorrarTrans))
                    .addGroup(tabTransaccionesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(tabTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValDiferenciaHaberTrans)
                            .addComponent(lblDiferenciaTrans))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnGuardarTrans)
                .addGap(23, 23, 23))
        );

        panelesTransaccion.addTab("Transacciones", tabTransacciones);

        lblValNumPartidaDGA.setText("Valor de numero de partida");

        lblFechaDGA.setText("Fecha:");

        lblValFechaDGA.setText("Valor de fecha");

        lblConceptoGeneralDGA.setText("Concepto General:");

        lblNumCuentaDGA.setText("Numero de Cuenta:");

        btnCatalogoDGA.setText("Catalogo");
        btnCatalogoDGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoDGAActionPerformed(evt);
            }
        });

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
        btnBorrarDGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDGAActionPerformed(evt);
            }
        });

        btnGuardarDGA.setText("Guardar y Finalizar");
        btnGuardarDGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDGAActionPerformed(evt);
            }
        });

        lblNumPartidaDGA.setText("Numero de Partida:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Detalle Gasto Adelantado"));

        lblValorTotal.setText("Valor Total:");

        lblMesesPagados.setText("Meses Pagados:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(lblValorTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(37, 37, 37))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(lblMesesPagados)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtMesesPagados, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(358, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorTotal)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMesesPagados)
                        .addComponent(txtMesesPagados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        checkIVADGA.setText("Calcular IVA");

        javax.swing.GroupLayout tabDetalleGastoAdelantadoLayout = new javax.swing.GroupLayout(tabDetalleGastoAdelantado);
        tabDetalleGastoAdelantado.setLayout(tabDetalleGastoAdelantadoLayout);
        tabDetalleGastoAdelantadoLayout.setHorizontalGroup(
            tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblNumPartidaDGA)
                .addGap(10, 10, 10)
                .addComponent(lblValNumPartidaDGA)
                .addGap(134, 134, 134)
                .addComponent(lblFechaDGA)
                .addGap(18, 18, 18)
                .addComponent(lblValFechaDGA))
            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblConceptoGeneralDGA)
                .addGap(10, 10, 10)
                .addComponent(txtConceptoGeneralDGA, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumCuentaDGA)
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblMontoDGA)))
                .addGap(10, 10, 10)
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumCuentaDGA, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoDGA, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnCatalogoDGA))
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(checkIVADGA)))
                .addGap(36, 36, 36)
                .addComponent(panelTipoDGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarDGA))
            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addComponent(btnBorrarDGA)
                        .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTotalesDGA)
                                    .addComponent(lblDiferenciaDGA))
                                .addGap(47, 47, 47)
                                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                                        .addComponent(lblTotalDebeDGA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTotalHaberDGA))
                                    .addComponent(lblValDiferenciaHaberDGA)))
                            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnGuardarDGA, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        tabDetalleGastoAdelantadoLayout.setVerticalGroup(
            tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumPartidaDGA)
                    .addComponent(lblValNumPartidaDGA)
                    .addComponent(lblFechaDGA)
                    .addComponent(lblValFechaDGA))
                .addGap(11, 11, 11)
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblConceptoGeneralDGA))
                    .addComponent(txtConceptoGeneralDGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblNumCuentaDGA)
                        .addGap(26, 26, 26)
                        .addComponent(lblMontoDGA))
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtNumCuentaDGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoDGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkIVADGA)))
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnCatalogoDGA))
                    .addComponent(panelTipoDGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnRegistrarDGA)))
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnBorrarDGA))
                    .addGroup(tabDetalleGastoAdelantadoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalesDGA)
                            .addComponent(lblTotalDebeDGA)
                            .addComponent(lblTotalHaberDGA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabDetalleGastoAdelantadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiferenciaDGA)
                            .addComponent(lblValDiferenciaHaberDGA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarDGA)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        panelesTransaccion.addTab("Detalle Gasto Adelantado", tabDetalleGastoAdelantado);

        lblNumPartidaDIA.setText("Numero de Partida:");

        lblValNumPartidaDIA.setText("Valor de numero de partida");

        lblFechaDIA.setText("Fecha:");

        lblValFechaDIA.setText("Valor de fecha");

        lblConceptoGeneralDIA.setText("Concepto General:");

        lblNumCuentaDIA.setText("Numero de Cuenta:");

        btnCatalogoDIA.setText("Catalogo");
        btnCatalogoDIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoDIAActionPerformed(evt);
            }
        });

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
        btnBorrarDIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDIAActionPerformed(evt);
            }
        });

        btnGuardarDIA.setText("Guardar y Finalizar");
        btnGuardarDIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDIAActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Interes Acumulado"));

        lblTasaAnual.setText("Tasa Anual:");

        lblValorPresente1.setText("Valor Presente:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(lblTasaAnual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTasaAnual, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addGap(37, 37, 37))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(lblValorPresente1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtValorPresenteDIA, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(358, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTasaAnual)
                    .addComponent(txtTasaAnual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblValorPresente1)
                        .addComponent(txtValorPresenteDIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        checkIVADIA.setText("Calcular IVA");

        javax.swing.GroupLayout tabDetalleInteresesAcumuladosLayout = new javax.swing.GroupLayout(tabDetalleInteresesAcumulados);
        tabDetalleInteresesAcumulados.setLayout(tabDetalleInteresesAcumuladosLayout);
        tabDetalleInteresesAcumuladosLayout.setHorizontalGroup(
            tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCatalogoDIA)
                                    .addComponent(checkIVADIA))
                                .addGap(44, 44, 44)
                                .addComponent(panelTipoDIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrarDIA))))
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnBorrarDIA)
                        .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                                        .addComponent(lblTotalesDIA)
                                        .addGap(84, 84, 84)
                                        .addComponent(lblTotalDebeDIA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTotalHaberDIA))
                                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                                        .addComponent(lblDiferenciaDIA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblValDiferenciaHaberDIA)))
                                .addGap(74, 74, 74))
                            .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardarDIA)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabDetalleInteresesAcumuladosLayout.setVerticalGroup(
            tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumPartidaDIA)
                    .addComponent(lblValNumPartidaDIA)
                    .addComponent(lblFechaDIA)
                    .addComponent(lblValFechaDIA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                            .addComponent(txtMontoDIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkIVADIA)))
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelTipoDIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnRegistrarDIA)))
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnBorrarDIA))
                    .addGroup(tabDetalleInteresesAcumuladosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalesDIA)
                            .addComponent(lblTotalDebeDIA)
                            .addComponent(lblTotalHaberDIA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabDetalleInteresesAcumuladosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiferenciaDIA)
                            .addComponent(lblValDiferenciaHaberDIA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarDIA)))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Datos de Intereses Acumulado");

        panelesTransaccion.addTab("Detalle Intereses Acumulados", tabDetalleInteresesAcumulados);

        tabDetalleActivoFijo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblNumPartidaDAF.setText("Numero de Partida:");

        lblValNumPartidaDAF.setText("Valor de numero de partida");

        lblFechaDAF.setText("Fecha:");

        lblValFechaDAF.setText("Valor de fecha");

        lblConceptoGeneralDAF.setText("Concepto General:");

        lblNumCuentaDAF.setText("Numero de Cuenta:");

        btnCatalogoDAF.setText("Catalogo");
        btnCatalogoDAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoDAFActionPerformed(evt);
            }
        });

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
        tableDetalleActivoFijo.setName(""); // NOI18N
        jScrollPane4.setViewportView(tableDetalleActivoFijo);

        lblTotalesDAF.setText("Totales:");

        lblTotalDebeDAF.setText("Total Debe");

        lblTotalHaberDAF.setText("Total Haber");

        lblDiferenciaDAF.setText("Diferencia:");

        lblValDiferenciaHaberDAF.setText("Valor de la diferencia de Debe y Haber");

        btnBorrarDAF.setText("Borrar Linea de Registro");
        btnBorrarDAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDAFActionPerformed(evt);
            }
        });

        btnGuardarDAF.setText("Guardar y Finalizar");
        btnGuardarDAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDAFActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Detalle Activo Fijo"));

        lblValorSalvamento.setText("Valor de Salvamento:");

        lblVidaUtil.setText("Vida Util:");

        lblValorPresente.setText("Valor Presente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblValorPresente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValorPresente, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(lblValorSalvamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValorSalvamento, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblVidaUtil)
                        .addGap(18, 18, 18)
                        .addComponent(txtVidaUtil, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorPresente)
                    .addComponent(txtValorPresente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorSalvamento)
                    .addComponent(txtValorSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVidaUtil)
                    .addComponent(txtVidaUtil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        checkIVADAF.setText("Calcular IVA");

        javax.swing.GroupLayout tabDetalleActivoFijoLayout = new javax.swing.GroupLayout(tabDetalleActivoFijo);
        tabDetalleActivoFijo.setLayout(tabDetalleActivoFijoLayout);
        tabDetalleActivoFijoLayout.setHorizontalGroup(
            tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(lblNumPartidaDAF)
                            .addGap(10, 10, 10)
                            .addComponent(lblValNumPartidaDAF)
                            .addGap(134, 134, 134)
                            .addComponent(lblFechaDAF)
                            .addGap(18, 18, 18)
                            .addComponent(lblValFechaDAF))
                        .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(lblConceptoGeneralDAF)
                            .addGap(10, 10, 10)
                            .addComponent(txtConceptoGeneralDAF, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNumCuentaDAF)
                                .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(lblMontoDAF)))
                            .addGap(10, 10, 10)
                            .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNumCuentaDAF, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMontoDAF, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(btnCatalogoDAF))
                                .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(checkIVADAF)))
                            .addGap(18, 18, 18)
                            .addComponent(panelTipoDAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnRegistrarDAF))
                        .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                            .addGap(268, 268, 268)
                            .addComponent(lblTotalesDAF)
                            .addGap(61, 61, 61)
                            .addComponent(lblTotalDebeDAF)
                            .addGap(84, 84, 84)
                            .addComponent(lblTotalHaberDAF))
                        .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(btnBorrarDAF)
                            .addGap(58, 58, 58)
                            .addComponent(lblDiferenciaDAF)
                            .addGap(61, 61, 61)
                            .addComponent(lblValDiferenciaHaberDAF))
                        .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                            .addGap(229, 229, 229)
                            .addComponent(btnGuardarDAF))))
                .addGap(14, 14, 14))
        );
        tabDetalleActivoFijoLayout.setVerticalGroup(
            tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumPartidaDAF)
                    .addComponent(lblValNumPartidaDAF)
                    .addComponent(lblFechaDAF)
                    .addComponent(lblValFechaDAF))
                .addGap(18, 18, 18)
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblConceptoGeneralDAF))
                    .addComponent(txtConceptoGeneralDAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblNumCuentaDAF)
                        .addGap(26, 26, 26)
                        .addComponent(lblMontoDAF))
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtNumCuentaDAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoDAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkIVADAF)))
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnCatalogoDAF))
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelTipoDAF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnRegistrarDAF)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalesDAF)
                    .addComponent(lblTotalDebeDAF)
                    .addComponent(lblTotalHaberDAF))
                .addGap(2, 2, 2)
                .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrarDAF)
                    .addGroup(tabDetalleActivoFijoLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(tabDetalleActivoFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDiferenciaDAF)
                            .addComponent(lblValDiferenciaHaberDAF))))
                .addGap(6, 6, 6)
                .addComponent(btnGuardarDAF))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Detalle de Activo Fijo");

        panelesTransaccion.addTab("Detalle Activo Fijo", tabDetalleActivoFijo);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(panelesTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panelesTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTransActionPerformed
        //obtenido valores de los campos
        try{
            String conceptoGeneral= txtConceptoGeneralTrans.getText();
            String codigoCuenta= txtNumCuentaTrans.getText();
            String monto= txtMontoTrans.getText();
            
            //Validando si hay IVA o no
            if(checkIVATransaccion.isSelected())
            {
                //validando si uso txtBox o Boton de catologo
                if(usoBoton)
                    control.agregarElementoTablaIVA(conceptoGeneral,codigoCuenta,nombreCuentaActual,monto, radioCargoTrans.isSelected(), tableTransacciones, regTransacciones,esCompra,IVA);
                else
                    control.agregarElementoTablaCampoIVA(conceptoGeneral,codigoCuenta,monto, radioCargoTrans.isSelected(), tableTransacciones, regTransacciones,esCompra,IVA);
                control.incluirIVATotal(IVA,regTransacciones,tableTransacciones);
            }
            else
            {
                //validando si uso txtBox o Boton de catologo
                if(usoBoton)
                    control.agregarElementoTabla(conceptoGeneral,codigoCuenta,nombreCuentaActual,monto, radioCargoTrans.isSelected(), tableTransacciones, regTransacciones);
                else
                    control.agregarElementoTablaCampo(conceptoGeneral,codigoCuenta,monto, radioCargoTrans.isSelected(), tableTransacciones, regTransacciones);
            }
            control.calcularTotalesYDiferencia(montoTransacciones, regTransacciones, lblTotalDebeTrans, lblTotalHaberTrans, lblValDiferenciaHaberTrans);
            control.validadorPartidaDoble(montoTransacciones, btnGuardarTrans);
            
            //restableciendo valor de nombre cuenta actual
            nombreCuentaActual="";
            usoBoton=false;
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,"Error!\nCampos vacios o con formatos erroneos");
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnRegistrarTransActionPerformed

    private void btnGuardarTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTransActionPerformed
        // TODO add your handling code here:
        control.registrarTransaccion(4, 0, new Date() , txtConceptoGeneralTrans.getText(), Integer.parseInt(lblValNumPartidaTrans.getText()), Double.parseDouble(lblTotalDebeTrans.getText().substring(1)), regTransacciones);
    }//GEN-LAST:event_btnGuardarTransActionPerformed

    private void btnRegistrarDGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDGAActionPerformed
         //obtenido valores de los campos
        try{
            String conceptoGeneral= txtConceptoGeneralDGA.getText();
            String codigoCuenta= txtNumCuentaDGA.getText();
            String monto= txtMontoDGA.getText();
            
            if(checkIVADGA.isSelected())
            {
                if(usoBoton)
                    control.agregarElementoTablaIVA(conceptoGeneral,codigoCuenta,nombreCuentaActual,monto, radioCargoDGA.isSelected(), tableDetalleGastosAdelantados, regDetalleGastoAdelantado, esCompra, IVA);
                else
                    control.agregarElementoTablaCampoIVA(conceptoGeneral,codigoCuenta,monto, radioCargoDGA.isSelected(), tableDetalleGastosAdelantados, regDetalleGastoAdelantado,esCompra,IVA);
                control.incluirIVATotal(IVA,regDetalleGastoAdelantado,tableDetalleGastosAdelantados);
            }
            else
            {
                if(usoBoton)
                    control.agregarElementoTabla(conceptoGeneral,codigoCuenta,nombreCuentaActual,monto, radioCargoDGA.isSelected(), tableDetalleGastosAdelantados, regDetalleGastoAdelantado);
                else
                    control.agregarElementoTablaCampo(conceptoGeneral,codigoCuenta,monto, radioCargoDGA.isSelected(), tableDetalleGastosAdelantados, regDetalleGastoAdelantado);
            }
            
            
                
            control.calcularTotalesYDiferencia(montoDetalleGastoAdelantado, regDetalleGastoAdelantado, lblTotalDebeDGA, lblTotalHaberDGA, lblValDiferenciaHaberDGA);
            control.validadorPartidaDoble(montoDetalleGastoAdelantado, btnGuardarDGA);
            
            //restableciendo valor de nombre cuenta actual
            nombreCuentaActual="";
            usoBoton=false;
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
            
            
            if(checkIVADIA.isSelected())
            {
                //validando si uso txtBox o Boton de catologo
            if(usoBoton)
                control.agregarElementoTablaIVA(conceptoGeneral,codigoCuenta,nombreCuentaActual,monto, radioCargoDIA.isSelected(), tableDetalleInteresesAcumulados, regDetalleInteresesAcumulados,esCompra,IVA);
            else
                control.agregarElementoTablaCampoIVA(conceptoGeneral,codigoCuenta,monto, radioCargoDIA.isSelected(), tableDetalleInteresesAcumulados, regDetalleInteresesAcumulados,esCompra,IVA);
            control.incluirIVATotal(IVA,regDetalleInteresesAcumulados,tableDetalleInteresesAcumulados);
            }
            else
            {
                //validando si uso txtBox o Boton de catologo
            if(usoBoton)
                control.agregarElementoTabla(conceptoGeneral,codigoCuenta,nombreCuentaActual,monto, radioCargoDIA.isSelected(), tableDetalleInteresesAcumulados, regDetalleInteresesAcumulados);
            else
                control.agregarElementoTablaCampo(conceptoGeneral,codigoCuenta,monto, radioCargoDIA.isSelected(), tableDetalleInteresesAcumulados, regDetalleInteresesAcumulados);
            }

            control.calcularTotalesYDiferencia(montoDetalleInteresesAcumulados, regDetalleInteresesAcumulados, lblTotalDebeDIA, lblTotalHaberDIA, lblValDiferenciaHaberDIA);
            control.validadorPartidaDoble(montoDetalleInteresesAcumulados, btnGuardarDIA);
            
            //restableciendo valor de nombre cuenta actual
            nombreCuentaActual="";
            usoBoton=false;
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
            
            if(checkIVADAF.isSelected())
            {
                //validando si uso txtBox o Boton de catologo
                if(usoBoton)
                    control.agregarElementoTablaIVA(conceptoGeneral,codigoCuenta,nombreCuentaActual,monto, radioCargoDAF.isSelected(), tableDetalleActivoFijo, regDetalleActivoFijo,esCompra,IVA);
                else
                    control.agregarElementoTablaCampoIVA(conceptoGeneral,codigoCuenta,monto, radioCargoDAF.isSelected(), tableDetalleActivoFijo, regDetalleActivoFijo,esCompra,IVA);
                control.incluirIVATotal(IVA,regDetalleActivoFijo,tableDetalleActivoFijo);
            }
            else
            {
                //validando si uso txtBox o Boton de catologo
                if(usoBoton)
                    control.agregarElementoTablaIVA(conceptoGeneral,codigoCuenta,nombreCuentaActual,monto, radioCargoDIA.isSelected(), tableDetalleInteresesAcumulados, regDetalleInteresesAcumulados,esCompra,IVA);
                else
                    control.agregarElementoTablaCampoIVA(conceptoGeneral,codigoCuenta,monto, radioCargoDIA.isSelected(), tableDetalleInteresesAcumulados, regDetalleInteresesAcumulados,esCompra,IVA);
            }
            
            
            
            control.calcularTotalesYDiferencia(montoDetalleActivoFijo, regDetalleActivoFijo, lblTotalDebeDAF, lblTotalHaberDAF, lblValDiferenciaHaberDAF);
            control.validadorPartidaDoble(montoDetalleActivoFijo, btnGuardarDAF);
            
            //restableciendo valor de nombre cuenta actual
            nombreCuentaActual="";
            usoBoton=false;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error!\nCampos vacios o con formatos erroneos");
        }
    }//GEN-LAST:event_btnRegistrarDAFActionPerformed

    private void btnBorrarTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTransActionPerformed
        // TODO add your handling code here:
        control.eliminarFila(tableTransacciones,regTransacciones);
        control.calcularTotalesYDiferencia(montoTransacciones, regTransacciones, lblTotalDebeTrans, lblTotalHaberTrans, lblValDiferenciaHaberTrans);
        control.validadorPartidaDoble(montoTransacciones, btnGuardarTrans);
    }//GEN-LAST:event_btnBorrarTransActionPerformed

    private void btnBorrarDGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDGAActionPerformed
        // TODO add your handling code here:
        control.eliminarFila(tableDetalleGastosAdelantados,regDetalleGastoAdelantado);
        control.calcularTotalesYDiferencia(montoDetalleGastoAdelantado, regDetalleGastoAdelantado, lblTotalDebeDGA, lblTotalHaberDGA, lblValDiferenciaHaberDGA);
        control.validadorPartidaDoble(montoDetalleGastoAdelantado, btnGuardarDGA);
    }//GEN-LAST:event_btnBorrarDGAActionPerformed

    private void btnBorrarDIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDIAActionPerformed
        // TODO add your handling code here:
        control.eliminarFila(tableDetalleInteresesAcumulados,regDetalleInteresesAcumulados);
        control.calcularTotalesYDiferencia(montoDetalleInteresesAcumulados, regDetalleInteresesAcumulados, lblTotalDebeDIA, lblTotalHaberDIA, lblValDiferenciaHaberDIA);
        control.validadorPartidaDoble(montoDetalleInteresesAcumulados, btnGuardarDIA);
    }//GEN-LAST:event_btnBorrarDIAActionPerformed

    private void btnBorrarDAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDAFActionPerformed
        // TODO add your handling code here:
        control.eliminarFila(tableDetalleActivoFijo,regDetalleActivoFijo);
        control.calcularTotalesYDiferencia(montoDetalleActivoFijo, regDetalleActivoFijo, lblTotalDebeDAF, lblTotalHaberDAF, lblValDiferenciaHaberDAF);
        control.validadorPartidaDoble(montoDetalleActivoFijo, btnGuardarDAF);
    }//GEN-LAST:event_btnBorrarDAFActionPerformed

    private void btnCatalogoTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoTransActionPerformed
        try {
            // TODO add your handling code here:
            usoBoton=true;
            MostrarCatalogo catalogo= new MostrarCatalogo();
            catalogo.setVisible(true);
            catalogo.setLocationRelativeTo(this);
            
            catalogo.btnAceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtNumCuentaTrans.setText(catalogo.getCodCuenta());
                    nombreCuentaActual= catalogo.getNombreCuenta();
                    /*
                        Acá se debe hacer referencia en dónde se quiera mostrar el nombre de la cuenta
                        que se trajo: catalogo.getNombreCuenta();    devuelve un String
                    */
                    catalogo.dispose();
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(FormTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCatalogoTransActionPerformed

    private void btnGuardarDGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDGAActionPerformed
        // TODO add your handling code here:
        control.registrarTransaccion(4, 0, new Date() , txtConceptoGeneralDGA.getText(), Integer.parseInt(lblValNumPartidaDGA.getText()), Double.parseDouble(lblTotalDebeDGA.getText().substring(1)), regDetalleGastoAdelantado);
        control.registrarDetalleGastoA(Integer.parseInt(txtMesesPagados.getText()), Double.parseDouble(txtValorTotal.getText()));
    }//GEN-LAST:event_btnGuardarDGAActionPerformed

    private void btnCatalogoDAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoDAFActionPerformed
        try {
            // TODO add your handling code here:
            usoBoton=true;
            MostrarCatalogo catalogo= new MostrarCatalogo();
            catalogo.setVisible(true);
            catalogo.setLocationRelativeTo(this);
            
            catalogo.btnAceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtNumCuentaDAF.setText(catalogo.getCodCuenta());
                    nombreCuentaActual= catalogo.getNombreCuenta();
                    /*
                        Acá se debe hacer referencia en dónde se quiera mostrar el nombre de la cuenta
                        que se trajo: catalogo.getNombreCuenta();    devuelve un String
                    */
                    catalogo.dispose();
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(FormTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCatalogoDAFActionPerformed

    private void btnGuardarDAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDAFActionPerformed
        control.registrarTransaccion(4, 0, new Date() , txtConceptoGeneralDAF.getText(), Integer.parseInt(lblValNumPartidaDAF.getText()), Double.parseDouble(lblTotalDebeDAF.getText().substring(1)), regDetalleActivoFijo);
        control.registrarDetalleActivoF(Double.parseDouble(txtValorPresente.getText()), Double.parseDouble(txtValorSalvamento.getText()), Integer.parseInt(txtVidaUtil.getText()));
    }//GEN-LAST:event_btnGuardarDAFActionPerformed

    private void btnCatalogoDIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoDIAActionPerformed
            try {
            // TODO add your handling code here:
            usoBoton=true;
            MostrarCatalogo catalogo= new MostrarCatalogo();
            catalogo.setVisible(true);
            catalogo.setLocationRelativeTo(this);
            
            catalogo.btnAceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtNumCuentaDIA.setText(catalogo.getCodCuenta());
                    nombreCuentaActual= catalogo.getNombreCuenta();
                    /*
                        Acá se debe hacer referencia en dónde se quiera mostrar el nombre de la cuenta
                        que se trajo: catalogo.getNombreCuenta();    devuelve un String
                    */
                    catalogo.dispose();
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(FormTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCatalogoDIAActionPerformed

    private void btnGuardarDIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDIAActionPerformed
        // TODO add your handling code here:
        control.registrarTransaccion(4, 0, new Date() , txtConceptoGeneralDIA.getText(), Integer.parseInt(lblValNumPartidaDIA.getText()), Double.parseDouble(lblTotalDebeDIA.getText().substring(1)), regDetalleInteresesAcumulados);
        control.registrarDetalleInteresesAcum(Double.parseDouble(txtValorPresenteDIA.getText()), Double.parseDouble(txtTasaAnual.getText()));
    }//GEN-LAST:event_btnGuardarDIAActionPerformed

    private void btnCatalogoDGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoDGAActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            usoBoton=true;
            MostrarCatalogo catalogo= new MostrarCatalogo();
            catalogo.setVisible(true);
            catalogo.setLocationRelativeTo(this);
            
            catalogo.btnAceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtNumCuentaDGA.setText(catalogo.getCodCuenta());
                    nombreCuentaActual= catalogo.getNombreCuenta();
                    /*
                        Acá se debe hacer referencia en dónde se quiera mostrar el nombre de la cuenta
                        que se trajo: catalogo.getNombreCuenta();    devuelve un String
                    */
                    catalogo.dispose();
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(FormTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCatalogoDGAActionPerformed

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
                try {
                    new FormTransaccion().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormTransaccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
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
    private javax.swing.JCheckBox checkIVADAF;
    private javax.swing.JCheckBox checkIVADGA;
    private javax.swing.JCheckBox checkIVADIA;
    private javax.swing.JCheckBox checkIVATransaccion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JLabel lblMesesPagados;
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
    private javax.swing.JLabel lblTasaAnual;
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
    private javax.swing.JLabel lblValorPresente;
    private javax.swing.JLabel lblValorPresente1;
    private javax.swing.JLabel lblValorSalvamento;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JLabel lblVidaUtil;
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
    private javax.swing.JTextField txtMesesPagados;
    private javax.swing.JTextField txtMontoDAF;
    private javax.swing.JTextField txtMontoDGA;
    private javax.swing.JTextField txtMontoDIA;
    private javax.swing.JTextField txtMontoTrans;
    private javax.swing.JTextField txtNumCuentaDAF;
    private javax.swing.JTextField txtNumCuentaDGA;
    private javax.swing.JTextField txtNumCuentaDIA;
    private javax.swing.JTextField txtNumCuentaTrans;
    private javax.swing.JTextField txtTasaAnual;
    private javax.swing.JTextField txtValorPresente;
    private javax.swing.JTextField txtValorPresenteDIA;
    private javax.swing.JTextField txtValorSalvamento;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtVidaUtil;
    // End of variables declaration//GEN-END:variables

}
