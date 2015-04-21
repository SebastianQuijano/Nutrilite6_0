package Interfaces;

import Conexion.Conexion;
import Conexion.FabricaConexion;
import DAO.FabricaDAO;
import Excepciones.ExcepcionRegistro;
import Objetos.ObjetoAlimento;
import Objetos.ObjetoAlimentoDieta;
import Objetos.ObjetoCliente;
import Objetos.ObjetoDiaDieta;
import Objetos.ObjetoEstado;
import Objetos.ObjetoMacronutrientes;
import Objetos.ObjetoMedidaFecha;
import Objetos.ObjetoMedidas;
import Objetos.ObjetoPais;
import Objetos.ObjetoSocio;
import Objetos.ObjetoTipoAlimento;
import Utilidades.CrearGraficaPDF;
import Utilidades.CrearPDF;
import Utilidades.GenerarGrafica;
import Utilidades.ListaPreguntas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class Administrador extends javax.swing.JFrame {

    private ObjetoSocio socio;
    private FabricaDAO fabricaDAO;
    private Conexion conexion;
    private final String urlDBHSQL = "data/Nutrilite.log";
    private ObjetoCliente cliente;
    private ObjetoMedidas medidas;
    private ObjetoEstado estado;
    private ObjetoPais pais;
    private ArrayList<ObjetoPais> listaPaises = null;
    private ArrayList<ObjetoEstado> listaEstados = null;
    private ArrayList<ObjetoMedidaFecha> listaMedidas;
    private ArrayList<Double> listaMedidasAux;
    private int contadorPreguntas;
    private int contadorRespuestas;
    private int contadorCuestionarioGlobal;
    private int tamanoPregEstiloVida;
    private JFreeChart chart;
    private ChartPanel chartPanel;
    
    private int filasel;
    private int calorias;
    private int contadorDiaVer = 0;
    private DefaultTableModel modeloTablaAlimentos;
    private DefaultTableModel modeloTablaDieta;
    private String desayuno = "Usted debe seleccionar 4 desayunos";
    private String refrigerio1 = "Usted debe seleccionar 4 Refrigerio1";
    private String refrigerio2 = "Usted debe seleccionar 4 Refrigerio2";
    private String almuerzo = "Usted debe seleccionar 4 almuerzo";
    private String cena = "Usted debe seleccionar 4 cena";
    private final String[] titulosAlimentos = {"Nombre","Porción","Calorías"};
    private final String[] titulosDieta = {"Comida","Cantidad","Nombre","Porción","Calorías"};
    private String [] ponerDiaDieta = new String[5];
    private ArrayList<ObjetoMacronutrientes> macronutrientes = null;
    private ArrayList<ObjetoTipoAlimento> tipoAlimento = null;
    private ArrayList<ObjetoAlimento> arregloAlimentos = null;
    private ArrayList<ObjetoDiaDieta> arregloDiaDieta = null;
    private String [] alimento = new String[3];

    /**
     * Creates new form Prueba
     */
    public Administrador(ObjetoSocio socio, FabricaDAO fabricaDAO, Conexion conexion) {

        initComponents();
        Estilo.tema();
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setResizable(false);
        ButtonGroup grupoRadios = new ButtonGroup();
        grupoRadios.add(radioFAgregar);
        grupoRadios.add(radioMAgregar);

        this.socio = socio;
        this.conexion = conexion;
        this.fabricaDAO = fabricaDAO;

        ButtonGroup grupoRadiosMedidas = new ButtonGroup();
        grupoRadiosMedidas.add(rbAlturaMedidas);
        grupoRadiosMedidas.add(rbCaderaMedidas);
        grupoRadiosMedidas.add(rbCuelloMedidas);
        grupoRadiosMedidas.add(rbMunecaMedidas);
        grupoRadiosMedidas.add(rbPechoMedidas);
        grupoRadiosMedidas.add(rbPesoMedidas);
        grupoRadiosMedidas.add(rbCinturaMedidas);

        panelAgregarCliente.setVisible(false);
        panelVer.setVisible(false);
        panelCuestionario.setVisible(false);
        panelPerfil.setVisible(false);
        panelSocio.setVisible(false);
        panelPrincipal.setVisible(true);
        panelIrCuestionario.setVisible(false);
        panelAlimentos.setVisible(false);
        panelCambiarContrasena.setVisible(false);
        panelMedidas.setVisible(false);
        panelIrDieta.setVisible(false);
        panelDieta.setVisible(false);
        panelInfoSocio.setVisible(false);
        panelVerTodos.setVisible(false);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                salirActionPerformed(null);
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        panelAgregarCliente = new javax.swing.JPanel();
        AgregarDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        radioMAgregar = new javax.swing.JRadioButton();
        radioFAgregar = new javax.swing.JRadioButton();
        cboxPaisAgregar = new javax.swing.JComboBox();
        cboxEstadoAgregar = new javax.swing.JComboBox();
        txtNombreAgregar = new javax.swing.JTextField();
        txtAPAgregar = new javax.swing.JTextField();
        txtAMAgregar = new javax.swing.JTextField();
        txtFNAgregar = new javax.swing.JTextField();
        txtDirAgregar = new javax.swing.JTextField();
        txtTelAgregar = new javax.swing.JTextField();
        txtCorreoAgregar = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        AgregarMedidas = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCinturaAgregar = new javax.swing.JTextField();
        txtMunecaAgregar = new javax.swing.JTextField();
        txtPechoAgregar = new javax.swing.JTextField();
        txtCaderaAgregar = new javax.swing.JTextField();
        txtAlturaAgregar = new javax.swing.JTextField();
        txtPesoAgregar = new javax.swing.JTextField();
        txtFechaAgregar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txtCuelloAgregar = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        btnGuardarAgregar = new javax.swing.JButton();
        btnCancelarAgregar = new javax.swing.JButton();
        avisoAgregarCliente = new javax.swing.JLabel();
        panelVer = new javax.swing.JPanel();
        VerDatos = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cboxEstadoCliente2 = new javax.swing.JComboBox();
        txtDirVer = new javax.swing.JTextField();
        txtTelVer = new javax.swing.JTextField();
        txtCorreoVer = new javax.swing.JTextField();
        lblSexoVer = new javax.swing.JLabel();
        lblPaisVer = new javax.swing.JLabel();
        lblNombreVer = new javax.swing.JLabel();
        lblAPVer = new javax.swing.JLabel();
        lblAMVer = new javax.swing.JLabel();
        lblFNVer = new javax.swing.JLabel();
        btnVerMedidas = new javax.swing.JButton();
        btnEditarVer = new javax.swing.JButton();
        btnCancelarVer = new javax.swing.JButton();
        btnEliminarVer = new javax.swing.JButton();
        btnGuardarVer = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        txtNCCliente = new javax.swing.JTextField();
        btnBuscarVer = new javax.swing.JButton();
        panelCuestionario = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        L1 = new javax.swing.JLabel();
        L2 = new javax.swing.JLabel();
        L3 = new javax.swing.JLabel();
        L4 = new javax.swing.JLabel();
        L5 = new javax.swing.JLabel();
        R1 = new javax.swing.JCheckBox();
        R2 = new javax.swing.JCheckBox();
        R3 = new javax.swing.JCheckBox();
        R4 = new javax.swing.JCheckBox();
        R5 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel72 = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        btnCancelarCuestionario = new javax.swing.JButton();
        panelPerfil = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        lblNombrePerfil = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        lblAPPerfil = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        lblFNPerfil = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        lblAMPerfil = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        lblSexoPerfil = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        lblPaisPerfil = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        lblCambiarPass = new javax.swing.JLabel();
        btnCancelarPerfil = new javax.swing.JButton();
        btnEditaPerfil = new javax.swing.JButton();
        btnGuardarPerfil = new javax.swing.JButton();
        avisoPerfil = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        txtDirPerfil = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtCorreoPerfil = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        cboxEstadoPerfil = new javax.swing.JComboBox();
        txtTelPerfil = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        panelIrCuestionario = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        txtClienteCuest = new javax.swing.JTextField();
        btnAceptarCuest = new javax.swing.JButton();
        btnCancelarCuest = new javax.swing.JButton();
        panelSocio = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        txtNumSocio = new javax.swing.JTextField();
        btnAgregarSocio = new javax.swing.JButton();
        btnCancelarSocio = new javax.swing.JButton();
        btnVerSocio = new javax.swing.JButton();
        btnVerTodosSocio = new javax.swing.JButton();
        panelAlimentos = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        txtNombreAlimentos = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        txtPorcion = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        txtCalorias = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        cboxTipoAlimentos = new javax.swing.JComboBox();
        btnGuardarAlimentos = new javax.swing.JButton();
        btnCancelarAlimentos = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        panelCambiarContrasena = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        btnGuardarCambios = new javax.swing.JButton();
        btnCancelarCambiarContrasena = new javax.swing.JButton();
        txtActualPass = new javax.swing.JPasswordField();
        txtNuevoPass = new javax.swing.JPasswordField();
        txtRepetirPass = new javax.swing.JPasswordField();
        jLabel70 = new javax.swing.JLabel();
        panelMedidas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        lblCuelloMedidas = new javax.swing.JLabel();
        lblCinturaMedidas = new javax.swing.JLabel();
        lblMunecaMedidas = new javax.swing.JLabel();
        lblPechoMedidas = new javax.swing.JLabel();
        lblCaderaMedidas = new javax.swing.JLabel();
        lblAlturaMedidas = new javax.swing.JLabel();
        lblPesoMedidas = new javax.swing.JLabel();
        lblFechaMedidas = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        VerMedidas1 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        txtCinturaVer1 = new javax.swing.JTextField();
        txtMunecaVer1 = new javax.swing.JTextField();
        txtPechoVer1 = new javax.swing.JTextField();
        txtCaderaVer1 = new javax.swing.JTextField();
        txtAlturaVer1 = new javax.swing.JTextField();
        txtPesoVer1 = new javax.swing.JTextField();
        txtFechaVer1 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        txtCuelloVer1 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        btnEditarMedidas = new javax.swing.JButton();
        btnGuardarMedidas = new javax.swing.JButton();
        btnCancelarMedidas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        rbCuelloMedidas = new javax.swing.JRadioButton();
        rbPechoMedidas = new javax.swing.JRadioButton();
        rbAlturaMedidas = new javax.swing.JRadioButton();
        rbCinturaMedidas = new javax.swing.JRadioButton();
        rbCaderaMedidas = new javax.swing.JRadioButton();
        rbPesoMedidas = new javax.swing.JRadioButton();
        rbMunecaMedidas = new javax.swing.JRadioButton();
        jLabel71 = new javax.swing.JLabel();
        exportarPDF = new javax.swing.JButton();
        panelIrDieta = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        txtDietas = new javax.swing.JTextField();
        btnAceptarIrDieta = new javax.swing.JButton();
        btnCancelarIrDieta = new javax.swing.JButton();
        panelDieta = new javax.swing.JPanel();
        cboComida = new javax.swing.JComboBox();
        cboMacronutrientes = new javax.swing.JComboBox();
        cboTipoAlimento = new javax.swing.JComboBox();
        lblInformacionDieta = new javax.swing.JLabel();
        btnAgregarDieta = new javax.swing.JButton();
        btnDiaAnterior = new javax.swing.JButton();
        btnDiaSiguiente = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardarDieta = new javax.swing.JButton();
        btnCancelarDieta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlimentos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAlimentosDieta = new javax.swing.JTable();
        spnCantidad = new javax.swing.JSpinner();
        lblDiaSemana = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        panelInfoSocio = new javax.swing.JPanel();
        btnCancelarInfoSocio = new javax.swing.JButton();
        btnEliminarSocio = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        lblFNSocio = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        lblSexoSocio = new javax.swing.JLabel();
        lblPaisSocio = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        lblDireccionSocio = new javax.swing.JLabel();
        lblTelSocio = new javax.swing.JLabel();
        lblCorreoSocio = new javax.swing.JLabel();
        lblNombreSocio = new javax.swing.JLabel();
        lblEstadoSocio = new javax.swing.JLabel();
        lblAPSocio = new javax.swing.JLabel();
        lblAMSocio = new javax.swing.JLabel();
        panelVerTodos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        btnVer = new javax.swing.JButton();
        btnCancelarVerTodos = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuNuevo = new javax.swing.JMenu();
        menuCliente = new javax.swing.JMenu();
        agregar = new javax.swing.JMenuItem();
        ver = new javax.swing.JMenuItem();
        cuestionario = new javax.swing.JMenuItem();
        dieta = new javax.swing.JMenuItem();
        menuHerramientas = new javax.swing.JMenu();
        menuAlimentos = new javax.swing.JMenu();
        agregarAlimento = new javax.swing.JMenuItem();
        verAlimentos = new javax.swing.JMenuItem();
        socios = new javax.swing.JMenuItem();
        menuPerfil = new javax.swing.JMenu();
        verPerfil = new javax.swing.JMenuItem();
        menuDescargar = new javax.swing.JMenu();
        descargarDB = new javax.swing.JMenuItem();
        subirDB = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAgregarCliente.setPreferredSize(new java.awt.Dimension(800, 580));

        AgregarDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 1, true), "Datos Personales "), "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("*Nombre(s):");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("*Apellido Paterno:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Apellido Materno:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("*Fecha de nacimiento:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("*Dirección:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Teléfono:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("*Correo electrónico:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("*Sexo:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("*País");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("*Estado");

        radioMAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioMAgregar.setText("Maculino");

        radioFAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        radioFAgregar.setText("Femenino");

        cboxPaisAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboxPaisAgregar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxPaisAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxPaisAgregarActionPerformed(evt);
            }
        });

        cboxEstadoAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboxEstadoAgregar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtNombreAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombreAgregar.setText("txtNombreAgregar");

        txtAPAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAPAgregar.setText("txtAPAgregar");

        txtAMAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAMAgregar.setText("txtAMAgregar");

        txtFNAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFNAgregar.setText("txtFNAgregar");

        txtDirAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDirAgregar.setText("txtDirAgregar");

        txtTelAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelAgregar.setText("txtTelAgregar");

        txtCorreoAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCorreoAgregar.setText("txtCorreoAgregar");
        txtCorreoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoAgregarActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel81.setText("dd/mm/aaaa");

        javax.swing.GroupLayout AgregarDatosLayout = new javax.swing.GroupLayout(AgregarDatos);
        AgregarDatos.setLayout(AgregarDatosLayout);
        AgregarDatosLayout.setHorizontalGroup(
            AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregarDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgregarDatosLayout.createSequentialGroup()
                        .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addGap(19, 19, 19)
                        .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(txtAPAgregar)))
                    .addGroup(AgregarDatosLayout.createSequentialGroup()
                        .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(AgregarDatosLayout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(AgregarDatosLayout.createSequentialGroup()
                                    .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(19, 19, 19)))
                            .addGroup(AgregarDatosLayout.createSequentialGroup()
                                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(19, 19, 19)))
                        .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AgregarDatosLayout.createSequentialGroup()
                                .addComponent(radioMAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioFAgregar))
                            .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCorreoAgregar)
                                .addComponent(txtAMAgregar)
                                .addComponent(txtDirAgregar)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgregarDatosLayout.createSequentialGroup()
                                    .addComponent(txtFNAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtTelAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboxPaisAgregar, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboxEstadoAgregar, javax.swing.GroupLayout.Alignment.LEADING, 0, 136, Short.MAX_VALUE))))))
        );
        AgregarDatosLayout.setVerticalGroup(
            AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregarDatosLayout.createSequentialGroup()
                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAPAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAMAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFNAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81))
                .addGap(18, 18, 18)
                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDirAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCorreoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMAgregar)
                    .addComponent(radioFAgregar)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboxPaisAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AgregarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboxEstadoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AgregarMedidas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 1, true), "Medidas"), "Medidas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Cintura:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Muñeca:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Pecho:");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Cadera:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Altura:");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Peso:");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("*Fecha:");

        txtCinturaAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtMunecaAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtPechoAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtCaderaAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtAlturaAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtPesoAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtFechaAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("cm.");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("cm.");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("cm.");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("cm.");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("cm.");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setText("Kg.");

        jLabel75.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel75.setText("dd/mm/aaaa");

        jLabel64.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel64.setText("Cuello:");

        txtCuelloAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel65.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel65.setText("cm.");

        javax.swing.GroupLayout AgregarMedidasLayout = new javax.swing.GroupLayout(AgregarMedidas);
        AgregarMedidas.setLayout(AgregarMedidasLayout);
        AgregarMedidasLayout.setHorizontalGroup(
            AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregarMedidasLayout.createSequentialGroup()
                .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AgregarMedidasLayout.createSequentialGroup()
                        .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AgregarMedidasLayout.createSequentialGroup()
                                .addComponent(txtMunecaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19))
                            .addGroup(AgregarMedidasLayout.createSequentialGroup()
                                .addComponent(txtPechoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20))
                            .addGroup(AgregarMedidasLayout.createSequentialGroup()
                                .addComponent(txtCaderaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21))
                            .addGroup(AgregarMedidasLayout.createSequentialGroup()
                                .addComponent(txtAlturaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22))
                            .addGroup(AgregarMedidasLayout.createSequentialGroup()
                                .addComponent(txtPesoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24))
                    .addGroup(AgregarMedidasLayout.createSequentialGroup()
                        .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75)
                            .addComponent(txtFechaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AgregarMedidasLayout.createSequentialGroup()
                                .addComponent(txtCuelloAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel65))
                            .addGroup(AgregarMedidasLayout.createSequentialGroup()
                                .addComponent(txtCinturaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AgregarMedidasLayout.setVerticalGroup(
            AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregarMedidasLayout.createSequentialGroup()
                .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(txtCuelloAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addGap(18, 18, 18)
                .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCinturaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMunecaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtPechoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCaderaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtAlturaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPesoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(AgregarMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtFechaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24))
        );

        btnGuardarAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardarAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardarAgregar.setText("Guardar");
        btnGuardarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAgregarActionPerformed(evt);
            }
        });

        btnCancelarAgregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarAgregar.setText("Cancelar");
        btnCancelarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAgregarActionPerformed(evt);
            }
        });

        avisoAgregarCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        avisoAgregarCliente.setForeground(new java.awt.Color(255, 0, 0));
        avisoAgregarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avisoAgregarCliente.setText("jLabel61");

        javax.swing.GroupLayout panelAgregarClienteLayout = new javax.swing.GroupLayout(panelAgregarCliente);
        panelAgregarCliente.setLayout(panelAgregarClienteLayout);
        panelAgregarClienteLayout.setHorizontalGroup(
            panelAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarClienteLayout.createSequentialGroup()
                .addGroup(panelAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAgregarClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AgregarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AgregarMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAgregarClienteLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(avisoAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAgregarClienteLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(btnGuardarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnCancelarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        panelAgregarClienteLayout.setVerticalGroup(
            panelAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AgregarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AgregarMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(avisoAgregarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAgregarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        panelVer.setPreferredSize(new java.awt.Dimension(630, 600));

        VerDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 51), 1, true), "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setText("Nombre(s):");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setText("Apellido Paterno:");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setText("Apellido Materno:");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel28.setText("Fecha de nacimiento:");

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setText("Dirección:");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setText("Teléfono:");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setText("Correo electrónico:");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel32.setText("Sexo:");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setText("País:");

        jLabel34.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel34.setText("Estado:");

        cboxEstadoCliente2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboxEstadoCliente2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDirVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDirVer.setEnabled(false);

        txtTelVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelVer.setEnabled(false);

        txtCorreoVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCorreoVer.setEnabled(false);

        lblSexoVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSexoVer.setText("lblSexoVer");

        lblPaisVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPaisVer.setText("lblPaisVer");

        lblNombreVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombreVer.setText("lblNombreVer");

        lblAPVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAPVer.setText("lblAPVer");

        lblAMVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAMVer.setText("lblAMVer");

        lblFNVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFNVer.setText("lblFNVer");

        btnVerMedidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVerMedidas.setText("Ver Medidas");
        btnVerMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMedidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VerDatosLayout = new javax.swing.GroupLayout(VerDatos);
        VerDatos.setLayout(VerDatosLayout);
        VerDatosLayout.setHorizontalGroup(
            VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerDatosLayout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(VerDatosLayout.createSequentialGroup()
                        .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnVerMedidas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VerDatosLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblNombreVer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(lblAPVer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAMVer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFNVer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(VerDatosLayout.createSequentialGroup()
                                        .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPaisVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblSexoVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(cboxEstadoCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(VerDatosLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDirVer, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCorreoVer, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                        .addComponent(txtTelVer)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        VerDatosLayout.setVerticalGroup(
            VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerDatosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblNombreVer)
                    .addComponent(jLabel32)
                    .addComponent(lblSexoVer))
                .addGap(18, 18, 18)
                .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblAPVer)
                    .addComponent(jLabel33)
                    .addComponent(lblPaisVer))
                .addGap(18, 18, 18)
                .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblAMVer)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lblFNVer)
                    .addComponent(cboxEstadoCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtTelVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtCorreoVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(VerDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtDirVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btnVerMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        btnEditarVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditarVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnEditarVer.setText("Editar");
        btnEditarVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVerActionPerformed(evt);
            }
        });

        btnCancelarVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarVer.setText("Cancelar");
        btnCancelarVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVerActionPerformed(evt);
            }
        });

        btnEliminarVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEliminarVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono.eliminar.png"))); // NOI18N
        btnEliminarVer.setText("Eliminar");
        btnEliminarVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVerActionPerformed(evt);
            }
        });

        btnGuardarVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardarVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardarVer.setText("Guardar");
        btnGuardarVer.setEnabled(false);
        btnGuardarVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVerActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel73.setText("Nombre completo:");

        txtNCCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnBuscarVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/find.png"))); // NOI18N
        btnBuscarVer.setText("Buscar");
        btnBuscarVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVerLayout = new javax.swing.GroupLayout(panelVer);
        panelVer.setLayout(panelVerLayout);
        panelVerLayout.setHorizontalGroup(
            panelVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerLayout.createSequentialGroup()
                .addGroup(panelVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelVerLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(VerDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelVerLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel73)
                            .addGap(29, 29, 29)
                            .addComponent(txtNCCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscarVer, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelVerLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnEditarVer, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnGuardarVer, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnEliminarVer, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnCancelarVer, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelVerLayout.setVerticalGroup(
            panelVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(txtNCCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarVer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarVer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarVer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarVer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarVer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        titulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Estilo de vida");

        L1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        L1.setText("1");

        L2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        L2.setText("2");

        L3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        L3.setText("3");

        L4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        L4.setText("4");

        L5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        L5.setText("5");

        R1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        R1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1ActionPerformed(evt);
            }
        });

        R2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        R3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        R3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3ActionPerformed(evt);
            }
        });

        R4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        R4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4ActionPerformed(evt);
            }
        });

        R5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(0, 153, 0));

        jLabel72.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel72.setText("Marcar la casilla en caso de que la respuesta sea \"Si\".");

        btnSiguiente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnCancelarCuestionario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarCuestionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarCuestionario.setText("Cancelar");
        btnCancelarCuestionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCuestionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCuestionarioLayout = new javax.swing.GroupLayout(panelCuestionario);
        panelCuestionario.setLayout(panelCuestionarioLayout);
        panelCuestionarioLayout.setHorizontalGroup(
            panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelCuestionarioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuestionarioLayout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addContainerGap(336, Short.MAX_VALUE))
                    .addGroup(panelCuestionarioLayout.createSequentialGroup()
                        .addGroup(panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCuestionarioLayout.createSequentialGroup()
                                .addGroup(panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(L4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(L3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(L2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(L5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(L1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(R1)
                                    .addComponent(R2)
                                    .addComponent(R3)
                                    .addComponent(R4)
                                    .addComponent(R5)))
                            .addGroup(panelCuestionarioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))))
            .addGroup(panelCuestionarioLayout.createSequentialGroup()
                .addGroup(panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuestionarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancelarCuestionario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuestionarioLayout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCuestionarioLayout.setVerticalGroup(
            panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuestionarioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel72)
                .addGap(18, 18, 18)
                .addGroup(panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(panelCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarCuestionario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 93, 0)));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel49.setText("Nombre(s): ");

        lblNombrePerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombrePerfil.setText("lblNombrePerfil");

        jLabel50.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel50.setText("Apellido Paterno: ");

        lblAPPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAPPerfil.setText("lblAPPerfil");

        jLabel52.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel52.setText("Fecha de Nacimiento: ");

        lblFNPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFNPerfil.setText("lblFNPerfil");

        jLabel51.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel51.setText("Apellido Materno: ");

        lblAMPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAMPerfil.setText("lblAMPerfil");

        jLabel59.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel59.setText("Sexo: ");

        lblSexoPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSexoPerfil.setText("lblSexoPerfil");

        jLabel57.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel57.setText("Pais:");

        lblPaisPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPaisPerfil.setText("lblPaisPerfil");

        jLabel54.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel54.setText("Contraseña: ");

        lblCambiarPass.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblCambiarPass.setForeground(new java.awt.Color(0, 0, 255));
        lblCambiarPass.setText("Cambiar contraseña.");
        lblCambiarPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCambiarPassMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPaisPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblFNPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCambiarPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(lblAMPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAPPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSexoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNombrePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(lblNombrePerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAPPerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(lblAMPerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(lblCambiarPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(lblFNPerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(lblSexoPerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(lblPaisPerfil))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelarPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarPerfil.setText("Cancelar");
        btnCancelarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPerfilActionPerformed(evt);
            }
        });

        btnEditaPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditaPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnEditaPerfil.setText("Editar");

        btnGuardarPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardarPerfil.setText("Guardar");
        btnGuardarPerfil.setEnabled(false);
        btnGuardarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPerfilActionPerformed(evt);
            }
        });

        avisoPerfil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        avisoPerfil.setForeground(new java.awt.Color(255, 0, 0));
        avisoPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avisoPerfil.setText("jLabel62");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 93, 0)));

        jLabel53.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel53.setText("Dirección: ");

        txtDirPerfil.setEditable(false);
        txtDirPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDirPerfil.setText("Direccion");
        txtDirPerfil.setEnabled(false);

        jLabel56.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel56.setText("Correo electrónico: ");

        txtCorreoPerfil.setEditable(false);
        txtCorreoPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCorreoPerfil.setText("Correo");
        txtCorreoPerfil.setEnabled(false);

        jLabel58.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel58.setText("Estado:");

        cboxEstadoPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboxEstadoPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtTelPerfil.setEditable(false);
        txtTelPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelPerfil.setText("Telefono");
        txtTelPerfil.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel60.setText("Teléfono: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxEstadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoPerfil)
                    .addComponent(txtDirPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txtDirPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtCorreoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(txtTelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(cboxEstadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPerfilLayout = new javax.swing.GroupLayout(panelPerfil);
        panelPerfil.setLayout(panelPerfilLayout);
        panelPerfilLayout.setHorizontalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPerfilLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPerfilLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPerfilLayout.createSequentialGroup()
                                .addComponent(btnEditaPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnGuardarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnCancelarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(avisoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPerfilLayout.setVerticalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(avisoPerfil)
                .addGap(18, 18, 18)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditaPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jLabel121.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel121.setText("Nombre Cliente:");

        txtClienteCuest.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtClienteCuest.setText("txtClienteCuest");

        btnAceptarCuest.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAceptarCuest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tick.png"))); // NOI18N
        btnAceptarCuest.setText("Aceptar");
        btnAceptarCuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarCuestActionPerformed(evt);
            }
        });

        btnCancelarCuest.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarCuest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarCuest.setText("Cancelar");
        btnCancelarCuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCuestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelIrCuestionarioLayout = new javax.swing.GroupLayout(panelIrCuestionario);
        panelIrCuestionario.setLayout(panelIrCuestionarioLayout);
        panelIrCuestionarioLayout.setHorizontalGroup(
            panelIrCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIrCuestionarioLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel121)
                .addGap(44, 44, 44)
                .addComponent(txtClienteCuest, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(panelIrCuestionarioLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(btnAceptarCuest, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarCuest, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelIrCuestionarioLayout.setVerticalGroup(
            panelIrCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIrCuestionarioLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelIrCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121)
                    .addComponent(txtClienteCuest, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelIrCuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarCuest, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarCuest, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panelSocio.setPreferredSize(new java.awt.Dimension(600, 300));

        jLabel120.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel120.setText("Número de Socio:");

        txtNumSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnAgregarSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAgregarSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        btnAgregarSocio.setText("Agregar");
        btnAgregarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSocioActionPerformed(evt);
            }
        });

        btnCancelarSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarSocio.setText("Cancelar");
        btnCancelarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSocioActionPerformed(evt);
            }
        });

        btnVerSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVerSocio.setText("Ver");
        btnVerSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSocioActionPerformed(evt);
            }
        });

        btnVerTodosSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVerTodosSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/find.png"))); // NOI18N
        btnVerTodosSocio.setText("Ver todos");
        btnVerTodosSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosSocioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSocioLayout = new javax.swing.GroupLayout(panelSocio);
        panelSocio.setLayout(panelSocioLayout);
        panelSocioLayout.setHorizontalGroup(
            panelSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSocioLayout.createSequentialGroup()
                .addGroup(panelSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSocioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgregarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerTodosSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSocioLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel120)
                        .addGap(33, 33, 33)
                        .addComponent(txtNumSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelSocioLayout.setVerticalGroup(
            panelSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSocioLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(txtNumSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerTodosSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel77.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel77.setText("Nombre del alimento:");

        txtNombreAlimentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombreAlimentos.setText("txtNombreAlimentos");

        jLabel78.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel78.setText("Porción:");

        txtPorcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPorcion.setText("jTextField2");

        jLabel79.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel79.setText("Calorias:");

        txtCalorias.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCalorias.setText("jTextField3");

        jLabel80.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel80.setText("Tipo de alimento:");

        cboxTipoAlimentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboxTipoAlimentos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardarAlimentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardarAlimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardarAlimentos.setText("Guardar");

        btnCancelarAlimentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarAlimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarAlimentos.setText("Cancelar");
        btnCancelarAlimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlimentosActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 0, 0));
        jLabel63.setText("jLabel63");

        javax.swing.GroupLayout panelAlimentosLayout = new javax.swing.GroupLayout(panelAlimentos);
        panelAlimentos.setLayout(panelAlimentosLayout);
        panelAlimentosLayout.setHorizontalGroup(
            panelAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlimentosLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(panelAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77)
                    .addComponent(jLabel78)
                    .addComponent(jLabel79)
                    .addComponent(jLabel80))
                .addGap(48, 48, 48)
                .addGroup(panelAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreAlimentos)
                    .addComponent(txtCalorias)
                    .addComponent(txtPorcion, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(cboxTipoAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
            .addGroup(panelAlimentosLayout.createSequentialGroup()
                .addGroup(panelAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlimentosLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnGuardarAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnCancelarAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAlimentosLayout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel63)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAlimentosLayout.setVerticalGroup(
            panelAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlimentosLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(txtNombreAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(panelAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(txtPorcion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panelAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79))
                .addGap(35, 35, 35)
                .addGroup(panelAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxTipoAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel63)
                .addGap(26, 26, 26)
                .addGroup(panelAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jLabel55.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel55.setText("Contraseña actual:");

        jLabel68.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel68.setText("Nueva contraseña:");

        jLabel69.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel69.setText("Repetir contraseña nueva:");

        btnGuardarCambios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardarCambios.setText("Guardar Cambios");

        btnCancelarCambiarContrasena.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarCambiarContrasena.setText("Cancelar");
        btnCancelarCambiarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCambiarContrasenaActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 0, 0));
        jLabel70.setText("jLabel70");

        javax.swing.GroupLayout panelCambiarContrasenaLayout = new javax.swing.GroupLayout(panelCambiarContrasena);
        panelCambiarContrasena.setLayout(panelCambiarContrasenaLayout);
        panelCambiarContrasenaLayout.setHorizontalGroup(
            panelCambiarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCambiarContrasenaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelCambiarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCambiarContrasenaLayout.createSequentialGroup()
                        .addGroup(panelCambiarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68)
                            .addComponent(jLabel55))
                        .addGap(58, 58, 58)
                        .addGroup(panelCambiarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtActualPass, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtNuevoPass)))
                    .addGroup(panelCambiarContrasenaLayout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addGap(18, 18, 18)
                        .addComponent(txtRepetirPass)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCambiarContrasenaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCambiarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCambiarContrasenaLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCambiarContrasenaLayout.createSequentialGroup()
                        .addComponent(btnGuardarCambios)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarCambiarContrasena)))
                .addGap(75, 75, 75))
        );
        panelCambiarContrasenaLayout.setVerticalGroup(
            panelCambiarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCambiarContrasenaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelCambiarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtActualPass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCambiarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(txtNuevoPass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCambiarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRepetirPass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCambiarContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarCambiarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)), "Medidas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel99.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel99.setText("Muñeca:");

        jLabel100.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel100.setText("Cuello:");

        jLabel101.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel101.setText("Pecho:");

        jLabel102.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel102.setText("Altura:");

        jLabel103.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel103.setText("Cadera:");

        jLabel104.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel104.setText("Cintura:");

        jLabel105.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel105.setText("Fecha:");

        jLabel106.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel106.setText("Peso:");

        lblCuelloMedidas.setText("jLabel107");

        lblCinturaMedidas.setText("jLabel108");

        lblMunecaMedidas.setText("jLabel109");

        lblPechoMedidas.setText("jLabel110");

        lblCaderaMedidas.setText("jLabel111");

        lblAlturaMedidas.setText("jLabel112");

        lblPesoMedidas.setText("jLabel113");

        lblFechaMedidas.setText("jLabel114");

        jLabel98.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel98.setText("cm.");

        jLabel89.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel89.setText("cm.");

        jLabel90.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel90.setText("cm.");

        jLabel91.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel91.setText("cm.");

        jLabel92.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel92.setText("cm.");

        jLabel93.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel93.setText("cm.");

        jLabel94.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel94.setText("Kg.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCuelloMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCinturaMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMunecaMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPechoMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCaderaMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAlturaMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPesoMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel98)
                            .addComponent(jLabel90)
                            .addComponent(jLabel91)
                            .addComponent(jLabel89)
                            .addComponent(jLabel92)
                            .addComponent(jLabel93)
                            .addComponent(jLabel94)))
                    .addComponent(lblFechaMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel100)
                            .addComponent(lblCuelloMedidas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel104)
                            .addComponent(lblCinturaMedidas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(lblMunecaMedidas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel101)
                            .addComponent(lblPechoMedidas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel103)
                            .addComponent(lblCaderaMedidas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel102)
                            .addComponent(lblAlturaMedidas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel106)
                            .addComponent(lblPesoMedidas)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel89))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel90)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel91)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel93)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel94)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(lblFechaMedidas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        VerMedidas1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 1, true), "Nuevas medidas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel82.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel82.setText("Cintura:");

        jLabel83.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel83.setText("Muñeca:");

        jLabel84.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel84.setText("Pecho:");

        jLabel85.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel85.setText("Cadera:");

        jLabel86.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel86.setText("Altura:");

        jLabel87.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel87.setText("Peso:");

        jLabel88.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel88.setText("Fecha:");

        txtCinturaVer1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCinturaVer1.setEnabled(false);

        txtMunecaVer1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMunecaVer1.setEnabled(false);

        txtPechoVer1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPechoVer1.setEnabled(false);

        txtCaderaVer1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCaderaVer1.setEnabled(false);

        txtAlturaVer1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAlturaVer1.setEnabled(false);

        txtPesoVer1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPesoVer1.setEnabled(false);

        txtFechaVer1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFechaVer1.setEnabled(false);

        jLabel96.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel96.setText("dd/mm/aaaa");

        jLabel97.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel97.setText("Cuello:");

        txtCuelloVer1.setEditable(false);
        txtCuelloVer1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel107.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel107.setText("cm.");

        jLabel108.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel108.setText("cm.");

        jLabel109.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel109.setText("cm.");

        jLabel110.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel110.setText("cm.");

        jLabel111.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel111.setText("cm.");

        jLabel112.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel112.setText("cm.");

        jLabel113.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel113.setText("Kg.");

        javax.swing.GroupLayout VerMedidas1Layout = new javax.swing.GroupLayout(VerMedidas1);
        VerMedidas1.setLayout(VerMedidas1Layout);
        VerMedidas1Layout.setHorizontalGroup(
            VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerMedidas1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerMedidas1Layout.createSequentialGroup()
                        .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, VerMedidas1Layout.createSequentialGroup()
                                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFechaVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(VerMedidas1Layout.createSequentialGroup()
                                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCuelloVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCinturaVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMunecaVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPechoVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCaderaVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAlturaVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPesoVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel107, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel108, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel110, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel112, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel113, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(31, 31, 31)))
                        .addComponent(jLabel95)
                        .addContainerGap())
                    .addGroup(VerMedidas1Layout.createSequentialGroup()
                        .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jLabel97, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VerMedidas1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel96)
                .addGap(41, 41, 41))
        );
        VerMedidas1Layout.setVerticalGroup(
            VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VerMedidas1Layout.createSequentialGroup()
                .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(txtCuelloVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107))
                .addGap(8, 8, 8)
                .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(txtCinturaVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(txtMunecaVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109))
                .addGap(8, 8, 8)
                .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(txtPechoVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel110))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(txtCaderaVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(txtAlturaVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(txtPesoVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel113))
                .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VerMedidas1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel95))
                    .addGroup(VerMedidas1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(VerMedidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaVer1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel96)
                .addContainerGap())
        );

        btnEditarMedidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditarMedidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnEditarMedidas.setText("Editar");

        btnGuardarMedidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardarMedidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardarMedidas.setText("Guardar");

        btnCancelarMedidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarMedidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarMedidas.setText("Cancelar");
        btnCancelarMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMedidasActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)), "Gráfica", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        rbCuelloMedidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbCuelloMedidas.setText("Cuello");
        rbCuelloMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCuelloMedidasActionPerformed(evt);
            }
        });

        rbPechoMedidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbPechoMedidas.setText("Pecho");
        rbPechoMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPechoMedidasActionPerformed(evt);
            }
        });

        rbAlturaMedidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbAlturaMedidas.setText("Altura");
        rbAlturaMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAlturaMedidasActionPerformed(evt);
            }
        });

        rbCinturaMedidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbCinturaMedidas.setText("Cintura");
        rbCinturaMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCinturaMedidasActionPerformed(evt);
            }
        });

        rbCaderaMedidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbCaderaMedidas.setText("Cadera");
        rbCaderaMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCaderaMedidasActionPerformed(evt);
            }
        });

        rbPesoMedidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbPesoMedidas.setText("Peso");
        rbPesoMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPesoMedidasActionPerformed(evt);
            }
        });

        rbMunecaMedidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbMunecaMedidas.setText("Muñeca");
        rbMunecaMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMunecaMedidasActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel71.setText("Elija la gráfica que desee ver.");

        exportarPDF.setText("Exportar");
        exportarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMedidasLayout = new javax.swing.GroupLayout(panelMedidas);
        panelMedidas.setLayout(panelMedidasLayout);
        panelMedidasLayout.setHorizontalGroup(
            panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VerMedidas1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMedidasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCancelarMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarMedidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardarMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMedidasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rbMunecaMedidas)
                                    .addComponent(rbCuelloMedidas, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbCinturaMedidas, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(37, 37, 37)
                                .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbPechoMedidas)
                                    .addComponent(rbCaderaMedidas))
                                .addGap(42, 42, 42)
                                .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelMedidasLayout.createSequentialGroup()
                                        .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbAlturaMedidas)
                                            .addComponent(rbPesoMedidas))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(exportarPDF))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelMedidasLayout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(jLabel71)
                                .addContainerGap(128, Short.MAX_VALUE))))
                    .addGroup(panelMedidasLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelMedidasLayout.setVerticalGroup(
            panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedidasLayout.createSequentialGroup()
                .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMedidasLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71)
                            .addComponent(btnEditarMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMedidasLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnGuardarMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnCancelarMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMedidasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbCuelloMedidas)
                                    .addComponent(rbPechoMedidas)
                                    .addComponent(rbAlturaMedidas))
                                .addGap(22, 22, 22)
                                .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbCinturaMedidas)
                                    .addComponent(rbCaderaMedidas)
                                    .addComponent(rbPesoMedidas))
                                .addGap(21, 21, 21)
                                .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbMunecaMedidas)
                                    .addComponent(exportarPDF))
                                .addGap(11, 11, 11))))
                    .addGroup(panelMedidasLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMedidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VerMedidas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 59, Short.MAX_VALUE))
        );

        jLabel122.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel122.setText("Nombre Cliente:");

        txtDietas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDietas.setText("txtDietas");

        btnAceptarIrDieta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAceptarIrDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tick.png"))); // NOI18N
        btnAceptarIrDieta.setText("Aceptar");
        btnAceptarIrDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarIrDietaActionPerformed(evt);
            }
        });

        btnCancelarIrDieta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarIrDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarIrDieta.setText("Cancelar");
        btnCancelarIrDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarIrDietaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelIrDietaLayout = new javax.swing.GroupLayout(panelIrDieta);
        panelIrDieta.setLayout(panelIrDietaLayout);
        panelIrDietaLayout.setHorizontalGroup(
            panelIrDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIrDietaLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel122)
                .addGap(44, 44, 44)
                .addComponent(txtDietas, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(panelIrDietaLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(btnAceptarIrDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarIrDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelIrDietaLayout.setVerticalGroup(
            panelIrDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIrDietaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelIrDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel122)
                    .addComponent(txtDietas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelIrDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarIrDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarIrDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        cboComida.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboComida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una comida", "Desayuno", "Refrigerio 1", "Almuerzo", "Refrigerio 2", "Cena" }));
        cboComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboComidaActionPerformed(evt);
            }
        });

        cboMacronutrientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboMacronutrientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMacronutrientesActionPerformed(evt);
            }
        });

        cboTipoAlimento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboTipoAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoAlimentoActionPerformed(evt);
            }
        });

        lblInformacionDieta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblInformacionDieta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInformacionDieta.setText("Seleccione...");

        btnAgregarDieta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAgregarDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        btnAgregarDieta.setText("Agregar");
        btnAgregarDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDietaActionPerformed(evt);
            }
        });

        btnDiaAnterior.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDiaAnterior.setText("Día Anterior");
        btnDiaAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiaAnteriorActionPerformed(evt);
            }
        });

        btnDiaSiguiente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDiaSiguiente.setText("Día Siguiente");
        btnDiaSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiaSiguienteActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono.eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardarDieta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardarDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardarDieta.setText("Guardar");
        btnGuardarDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDietaActionPerformed(evt);
            }
        });

        btnCancelarDieta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarDieta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarDieta.setText("Cancelar");
        btnCancelarDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDietaActionPerformed(evt);
            }
        });

        tblAlimentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblAlimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAlimentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblAlimentos);

        tblAlimentosDieta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblAlimentosDieta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblAlimentosDieta);

        spnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantidadStateChanged(evt);
            }
        });

        lblDiaSemana.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDiaSemana.setText("Lunes");

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setText("Cantidad:");

        jLabel36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel36.setText("Comida");

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setText("Macronutriente");

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setText("Tipo de Alimento");

        javax.swing.GroupLayout panelDietaLayout = new javax.swing.GroupLayout(panelDieta);
        panelDieta.setLayout(panelDietaLayout);
        panelDietaLayout.setHorizontalGroup(
            panelDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDietaLayout.createSequentialGroup()
                .addGroup(panelDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDietaLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jLabel38))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDietaLayout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(jLabel36)
                            .addGap(54, 54, 54))
                        .addGroup(panelDietaLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(panelDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboComida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboMacronutrientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelDietaLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel37)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(panelDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDietaLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelarDieta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDiaSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDiaAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDietaLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(lblInformacionDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDiaSemana)
                .addGap(277, 277, 277))
        );
        panelDietaLayout.setVerticalGroup(
            panelDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDietaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblDiaSemana)
                .addGroup(panelDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDietaLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panelDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(panelDietaLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboComida, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMacronutrientes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelDietaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblInformacionDieta)
                .addGap(18, 18, 18)
                .addGroup(panelDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDietaLayout.createSequentialGroup()
                        .addComponent(btnDiaAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnDiaSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(btnCancelarDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        btnCancelarInfoSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarInfoSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarInfoSocio.setText("Cancelar");
        btnCancelarInfoSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarInfoSocioActionPerformed(evt);
            }
        });

        btnEliminarSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEliminarSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono.eliminar.png"))); // NOI18N
        btnEliminarSocio.setText("Eliminar");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 93, 0), 1, true), "Información de Socio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 93, 0))); // NOI18N
        jPanel5.setAlignmentX(0.1F);
        jPanel5.setPreferredSize(new java.awt.Dimension(700, 298));

        jLabel61.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel61.setText("Apellido Paterno: ");

        jLabel62.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel62.setText("Apellido Materno: ");

        jLabel66.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel66.setText("Fecha de Nacimiento: ");

        jLabel67.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel67.setText("Dirección: ");

        jLabel74.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel74.setText("Correo electrónico: ");

        jLabel76.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel76.setText("Pais:");

        jLabel114.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel114.setText("Estado:");

        lblFNSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFNSocio.setText("lblFNSocio");

        jLabel115.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel115.setText("Nombre(s): ");

        lblSexoSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSexoSocio.setText("lblSexoSocio");

        lblPaisSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPaisSocio.setText("lblPaisSocio");

        jLabel116.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel116.setText("Sexo: ");

        jLabel117.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel117.setText("Teléfono: ");

        lblDireccionSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDireccionSocio.setText("lblDireccionSocio");

        lblTelSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTelSocio.setText("lblTelSocio");

        lblCorreoSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCorreoSocio.setText("lblTelSocio");

        lblNombreSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNombreSocio.setText("lblNombreSocio");

        lblEstadoSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEstadoSocio.setText("lblEstadoSocio");

        lblAPSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAPSocio.setText("lblAPSocio");

        lblAMSocio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAMSocio.setText("lblAMSocio");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel61)
                                .addComponent(jLabel115))
                            .addGap(45, 45, 45)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblAPSocio)
                                    .addGap(162, 162, 162)
                                    .addComponent(jLabel62)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblAMSocio))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel76)
                                        .addComponent(lblNombreSocio))
                                    .addGap(18, 18, 18)
                                    .addComponent(lblPaisSocio)
                                    .addGap(77, 77, 77)
                                    .addComponent(jLabel114)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblEstadoSocio))))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel67)
                                .addComponent(jLabel66)
                                .addComponent(jLabel74))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblDireccionSocio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                                    .addComponent(jLabel117)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblTelSocio))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCorreoSocio)
                                        .addComponent(lblFNSocio))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel116)
                        .addGap(26, 26, 26)
                        .addComponent(lblSexoSocio)))
                .addGap(74, 74, 74))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(lblNombreSocio))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(lblAPSocio)
                    .addComponent(jLabel62)
                    .addComponent(lblAMSocio))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(lblFNSocio))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(lblDireccionSocio)
                    .addComponent(jLabel117)
                    .addComponent(lblTelSocio))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(lblCorreoSocio))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(lblSexoSocio)
                    .addComponent(jLabel76)
                    .addComponent(lblPaisSocio)
                    .addComponent(jLabel114)
                    .addComponent(lblEstadoSocio))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelInfoSocioLayout = new javax.swing.GroupLayout(panelInfoSocio);
        panelInfoSocio.setLayout(panelInfoSocioLayout);
        panelInfoSocioLayout.setHorizontalGroup(
            panelInfoSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoSocioLayout.createSequentialGroup()
                .addGroup(panelInfoSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoSocioLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(btnEliminarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnCancelarInfoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInfoSocioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInfoSocioLayout.setVerticalGroup(
            panelInfoSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoSocioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(panelInfoSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarInfoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jTable2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Número de socio", "Nombre"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jLabel39.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel39.setText("Seleccione el socio y de click en 'Ver' para visualizar su información.");

        btnVer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnCancelarVerTodos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelarVerTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        btnCancelarVerTodos.setText("Cancelar");
        btnCancelarVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVerTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVerTodosLayout = new javax.swing.GroupLayout(panelVerTodos);
        panelVerTodos.setLayout(panelVerTodosLayout);
        panelVerTodosLayout.setHorizontalGroup(
            panelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerTodosLayout.createSequentialGroup()
                .addGroup(panelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVerTodosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelVerTodosLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelVerTodosLayout.setVerticalGroup(
            panelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerTodosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        menuNuevo.setText("Nuevo");

        menuCliente.setText("Cliente");
        menuCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        menuCliente.add(agregar);

        ver.setText("Ver");
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        menuCliente.add(ver);

        menuNuevo.add(menuCliente);

        cuestionario.setText("Cuestionario");
        cuestionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuestionarioActionPerformed(evt);
            }
        });
        menuNuevo.add(cuestionario);

        dieta.setText("Dieta");
        dieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dietaActionPerformed(evt);
            }
        });
        menuNuevo.add(dieta);

        menuBar.add(menuNuevo);

        menuHerramientas.setText("Herramientas");

        menuAlimentos.setText("Alimentos");
        menuAlimentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        agregarAlimento.setText("Agregar alimento");
        agregarAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAlimentoActionPerformed(evt);
            }
        });
        menuAlimentos.add(agregarAlimento);

        verAlimentos.setText("Ver alimentos");
        verAlimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAlimentosActionPerformed(evt);
            }
        });
        menuAlimentos.add(verAlimentos);

        menuHerramientas.add(menuAlimentos);

        socios.setText("Socios");
        socios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sociosActionPerformed(evt);
            }
        });
        menuHerramientas.add(socios);

        menuBar.add(menuHerramientas);

        menuPerfil.setText("Perfil");
        menuPerfil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        verPerfil.setText("Ver perfil");
        verPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPerfilActionPerformed(evt);
            }
        });
        menuPerfil.add(verPerfil);

        menuBar.add(menuPerfil);

        menuDescargar.setText("Respaldo");

        descargarDB.setText("Descargar de la red");
        menuDescargar.add(descargarDB);

        subirDB.setText("Subir a la red");
        menuDescargar.add(subirDB);

        menuBar.add(menuDescargar);

        menuSalir.setText("Salir");

        salir.setText("Pa juera");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        menuSalir.add(salir);

        menuBar.add(menuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(panelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(519, Short.MAX_VALUE)
                    .addComponent(panelVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelCuestionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 304, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelIrCuestionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelIrDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 305, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelCambiarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelInfoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 281, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelCuestionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 130, Short.MAX_VALUE)
                    .addComponent(panelIrCuestionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 130, Short.MAX_VALUE)
                    .addComponent(panelIrDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 802, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelCambiarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelInfoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPerfilActionPerformed

    }//GEN-LAST:event_btnGuardarPerfilActionPerformed

    private void btnCancelarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPerfilActionPerformed
        setSize(600, 400);
        setLocationRelativeTo(null);
        menuBar.setVisible(true);
        panelPerfil.setVisible(false);
        panelPrincipal.setVisible(true);
    }//GEN-LAST:event_btnCancelarPerfilActionPerformed

    private void R1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_R1ActionPerformed

    private void R3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_R3ActionPerformed

    private void R4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_R4ActionPerformed

    private void btnCancelarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSocioActionPerformed
        setSize(600, 400);
        setLocationRelativeTo(null);
        menuBar.setVisible(true);
        panelSocio.setVisible(false);
        panelPrincipal.setVisible(true);
    }//GEN-LAST:event_btnCancelarSocioActionPerformed

    private void btnAceptarCuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarCuestActionPerformed
        String nombre = txtClienteCuest.getText();
        if (nombre.equals("")) {
            return;
        }
        try {
            cliente = fabricaDAO.getClienteDAO().verCliente(nombre, socio.getIdSocio());
            if (cliente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró al cliente");
                return;
            }
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Aplicar cuestionario a\n"
                    + cliente.getNombre() + " " + cliente.getApellidoPaterno() + " "
                    + cliente.getApellidoMaterno() + "?",
                    "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                contadorCuestionarioGlobal = 1;
                contadorPreguntas = 0;
                contadorRespuestas = 0;
                ListaPreguntas.vaciarRespuestasCuestionario();
                moverPreguntas(ListaPreguntas.getEstiloDeVida(cliente.getSexo().charAt(0), 21));
                tamanoPregEstiloVida = ListaPreguntas.getEstiloDeVida(cliente.getSexo().charAt(0), 21).length;
                int[] respuestasCicloDeVida = ListaPreguntas.getRespuestasCicloDeVida(cliente.getSexo().charAt(0), 21);
                for (int i = 0; i < respuestasCicloDeVida.length; i++) {
                    ListaPreguntas.marcarRespuestasCuestionario(respuestasCicloDeVida[i]);
                }
                titulo.setText("Estilo de vida");
                setSize(650, 450);
                setLocationRelativeTo(null);
                menuBar.setVisible(false);
                panelCuestionario.setVisible(true);
                panelIrCuestionario.setVisible(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Hubo un error de conexion o no se encontró al cliente");
        }
    }//GEN-LAST:event_btnAceptarCuestActionPerformed

    private void btnCancelarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAgregarActionPerformed
        setSize(600, 400);
        setLocationRelativeTo(null);
        menuBar.setVisible(true);
        panelAgregarCliente.setVisible(false);
        panelPrincipal.setVisible(true);
    }//GEN-LAST:event_btnCancelarAgregarActionPerformed

    private void btnCancelarCuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCuestActionPerformed
        setSize(600, 400);
        setLocationRelativeTo(null);
        menuBar.setVisible(true);
        panelPrincipal.setVisible(true);
        panelIrCuestionario.setVisible(false);
    }//GEN-LAST:event_btnCancelarCuestActionPerformed

    private void btnCancelarAlimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlimentosActionPerformed
        setSize(600, 400);
        setLocationRelativeTo(null);
        menuBar.setVisible(true);
        panelPrincipal.setVisible(true);
        panelAlimentos.setVisible(false);
    }//GEN-LAST:event_btnCancelarAlimentosActionPerformed

    private void txtCorreoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoAgregarActionPerformed

    private void btnCancelarCuestionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCuestionarioActionPerformed
        setSize(600, 400);
        menuBar.setVisible(true);
        setLocationRelativeTo(null);
        panelPrincipal.setVisible(true);
        panelCuestionario.setVisible(false);
    }//GEN-LAST:event_btnCancelarCuestionarioActionPerformed

    private void btnAgregarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSocioActionPerformed
        try {
            fabricaDAO.getSocioDAO().darDeAlta(Integer.parseInt(txtNumSocio.getText()));
            JOptionPane.showMessageDialog(this, "Usuario dado de alta");
            panelSocio.setVisible(false);
            txtNumSocio.setText("");
            panelPrincipal.setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de conexion");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un numero de socio valido");
        }
    }//GEN-LAST:event_btnAgregarSocioActionPerformed

    private void lblCambiarPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCambiarPassMouseClicked
        setSize(420, 290);
        setLocationRelativeTo(null);
        panelPerfil.setVisible(false);
        menuBar.setVisible(false);
        panelCambiarContrasena.setVisible(true);

    }//GEN-LAST:event_lblCambiarPassMouseClicked

    private void btnCancelarCambiarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCambiarContrasenaActionPerformed
        setSize(850, 500);
        setLocationRelativeTo(null);
        panelPerfil.setVisible(true);
        menuBar.setVisible(false);
        panelCambiarContrasena.setVisible(false);
    }//GEN-LAST:event_btnCancelarCambiarContrasenaActionPerformed

    private void btnCancelarVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVerActionPerformed
        if (btnGuardarVer.isEnabled()) {
            txtDirVer.setEnabled(false);
            txtTelVer.setEnabled(false);
            txtCorreoVer.setEnabled(false);
            cboxEstadoCliente2.setEnabled(false);
            btnBuscarVerActionPerformed(evt);
            
            return;
        }
        setSize(600, 400);
        setLocationRelativeTo(null);
        menuBar.setVisible(true);
        panelVer.setVisible(false);
        panelPrincipal.setVisible(false);
    }//GEN-LAST:event_btnCancelarVerActionPerformed

    private void btnVerMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMedidasActionPerformed
        setSize(800, 600);
        setLocationRelativeTo(null);
        panelMedidas.setVisible(true);
        menuBar.setVisible(false);
        panelVer.setVisible(false);
        lblCuelloMedidas.setText(medidas.getCuello() + "");
        lblCinturaMedidas.setText(medidas.getCintura() + "");
        lblMunecaMedidas.setText(medidas.getMuneca() + "");
        lblPechoMedidas.setText(medidas.getPecho() + "");
        lblCaderaMedidas.setText(medidas.getCadera() + "");
        lblAlturaMedidas.setText(medidas.getAltura() + "");
        lblPesoMedidas.setText(medidas.getPeso() + "");
        lblFechaMedidas.setText(medidas.getFecha() + "");
        jPanel2.removeAll();
        rbCuelloMedidas.setSelected(true);
    }//GEN-LAST:event_btnVerMedidasActionPerformed

    private void btnCancelarMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMedidasActionPerformed
        setSize(630, 600);
        setLocationRelativeTo(null);
        panelVer.setVisible(true);
        menuBar.setVisible(false);
        panelMedidas.setVisible(false);
    }//GEN-LAST:event_btnCancelarMedidasActionPerformed

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        setSize(650, 620);
        menuBar.setVisible(false);
        setLocationRelativeTo(null);
        panelVer.setVisible(true);
        panelAgregarCliente.setVisible(false);
        panelCuestionario.setVisible(false);
        panelPerfil.setVisible(false);
        panelSocio.setVisible(false);
        panelPrincipal.setVisible(false);
        panelIrCuestionario.setVisible(false);
        panelAlimentos.setVisible(false);
        limpiarVerCliente();
    }//GEN-LAST:event_verActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
//        [800, 580]
        setSize(600, 570);
        menuBar.setVisible(false);
        setLocationRelativeTo(null);
        panelAgregarCliente.setVisible(true);
        panelVer.setVisible(false);
        panelCuestionario.setVisible(false);
        panelPerfil.setVisible(false);
        panelSocio.setVisible(false);
        panelPrincipal.setVisible(false);
        panelIrCuestionario.setVisible(false);
        panelAlimentos.setVisible(false);
        limpiarAgregarCliente();
        try {
            if (listaPaises == null) {
                listaPaises = fabricaDAO.getPaisDAO().verPaisesPorNombre();
            }
            for (ObjetoPais pais : listaPaises) {
                cboxPaisAgregar.addItem(pais.getNombre());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Cerrar sesion?",
                "Confirmacion", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                fabricaDAO = null;
                conexion.desconectar();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexion");
            }
            Login.main(null);
            this.dispose();
        }
    }//GEN-LAST:event_salirActionPerformed

    private void cuestionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuestionarioActionPerformed
        setSize(550, 200);
        setLocationRelativeTo(null);
        menuBar.setVisible(false);
        panelCuestionario.setVisible(false);
        panelAgregarCliente.setVisible(false);
        panelVer.setVisible(false);
        panelPerfil.setVisible(false);
        panelSocio.setVisible(false);
        panelPrincipal.setVisible(false);
        panelIrCuestionario.setVisible(true);
        panelAlimentos.setVisible(false);
        txtClienteCuest.setText("");
    }//GEN-LAST:event_cuestionarioActionPerformed

    private void verAlimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAlimentosActionPerformed

    }//GEN-LAST:event_verAlimentosActionPerformed

    private void agregarAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAlimentoActionPerformed
        setSize(550, 450);
        menuBar.setVisible(false);
        setLocationRelativeTo(null);
        panelCuestionario.setVisible(false);
        panelAgregarCliente.setVisible(false);
        panelVer.setVisible(false);
        panelPerfil.setVisible(false);
        panelSocio.setVisible(false);
        panelPrincipal.setVisible(false);
        panelIrCuestionario.setVisible(false);
        panelAlimentos.setVisible(true);
    }//GEN-LAST:event_agregarAlimentoActionPerformed

    private void sociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sociosActionPerformed
        setSize(600, 300);
        setLocationRelativeTo(null);
        menuBar.setVisible(false);
        panelVer.setVisible(false);
        panelAgregarCliente.setVisible(false);
        panelCuestionario.setVisible(false);
        panelPerfil.setVisible(false);
        panelSocio.setVisible(true);
        panelPrincipal.setVisible(false);
        panelIrCuestionario.setVisible(false);
        panelAlimentos.setVisible(false);
    }//GEN-LAST:event_sociosActionPerformed

    private void verPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPerfilActionPerformed
//        [764, 294]
        setSize(775, 350);
        menuBar.setVisible(false);
        setLocationRelativeTo(null);
        panelPerfil.setVisible(true);
        panelAgregarCliente.setVisible(false);
        panelVer.setVisible(false);
        panelCuestionario.setVisible(false);
        panelSocio.setVisible(false);
        panelPrincipal.setVisible(false);
        panelIrCuestionario.setVisible(false);
        avisoPerfil.setText("");
        try {
            llenarPerfil();
        } catch (SQLException e) {
            e.printStackTrace();
            avisoPerfil.setText("Posible error de conexion");
        }
    }//GEN-LAST:event_verPerfilActionPerformed

    private void btnGuardarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAgregarActionPerformed
        try {
            validarCliente();
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de querer subir el nuevo cliente?",
                    "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                guardarCliente();
                guardarMedidas();
                JOptionPane.showMessageDialog(this, "Cliente subido con exito");
                limpiarAgregarCliente();
            }
        } catch (SQLException e) {
            avisoAgregarCliente.setText("Hubo un error en la conexion");
            e.printStackTrace();
        } catch (ExcepcionRegistro e) {
            avisoAgregarCliente.setText(e.getMessage());
        } catch (NumberFormatException e) {
            avisoAgregarCliente.setText("Error en las medidas");
        }
    }//GEN-LAST:event_btnGuardarAgregarActionPerformed

    private void cboxPaisAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxPaisAgregarActionPerformed
        int index = cboxPaisAgregar.getSelectedIndex();
        try {
            listaEstados = fabricaDAO.getEstadoDAO().verEstadosPorPais(listaPaises.get(index - 1).getId());
            cboxEstadoAgregar.setModel(new DefaultComboBoxModel(new String[]{"Seleccione Estado"}));
            for (ObjetoEstado estado : listaEstados) {
                cboxEstadoAgregar.addItem(estado.getNombre());
            }
        } catch (SQLException e) {
            System.out.println("Error en cargar los estados. (cboxPaisAgregarActionPerformed)");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            cboxEstadoAgregar.setModel(new DefaultComboBoxModel(new String[]{"Seleccione Estado"}));
        }
    }//GEN-LAST:event_cboxPaisAgregarActionPerformed

    private void btnBuscarVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVerActionPerformed
        String nombre = txtNCCliente.getText();
        if (nombre.equals("")) {
            return;
        }
        try {
            cliente = fabricaDAO.getClienteDAO().verCliente(nombre, socio.getIdSocio());
            if (cliente != null) {
                medidas = fabricaDAO.getMedidasDAO().verUltimaMedidaCliente(cliente.getIdCliente());
                verDatosCliente();
                btnEditarVer.setEnabled(true);
                btnEliminarVer.setEnabled(true);
                btnGuardarVer.setEnabled(false);
                btnVerMedidas.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado");
                limpiarVerCliente();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Posible error de conexion");
        }
    }//GEN-LAST:event_btnBuscarVerActionPerformed

    private void btnEditarVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVerActionPerformed
        btnGuardarVer.setEnabled(true);
        btnEditarVer.setEnabled(false);
        btnEliminarVer.setEnabled(false);
        btnVerMedidas.setEnabled(false);

        txtDirVer.setEnabled(true);
        txtTelVer.setEnabled(true);
        txtCorreoVer.setEnabled(true);
        cboxEstadoCliente2.setEnabled(true);

        try {
            listaEstados = fabricaDAO.getEstadoDAO().verEstadosPorPais(pais.getId());
            cboxEstadoCliente2.setModel(new DefaultComboBoxModel(new String[]{"Seleccione Estado"}));
            int select = 0;
            for (int i = 0; i < listaEstados.size(); i++) {
                if (listaEstados.get(i).getId() == estado.getId()) {
                    select = i;
                }
                cboxEstadoCliente2.addItem(listaEstados.get(i).getNombre());
            }
            cboxEstadoCliente2.setSelectedIndex(select + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditarVerActionPerformed

    private void btnGuardarVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVerActionPerformed

        try {
            validarGuardarVerCliente();
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de querer actualizar este cliente?",
                    "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                guardarVerCliente();
                JOptionPane.showMessageDialog(this, "Cliente actualizado");
                btnBuscarVerActionPerformed(evt);
                txtDirVer.setEnabled(false);
                txtTelVer.setEnabled(false);
                txtCorreoVer.setEnabled(false);
                cboxEstadoCliente2.setEnabled(false);
            }
        } catch (ExcepcionRegistro e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se pudieron cambiar los cambios:\nPosible error de conexion");
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnGuardarVerActionPerformed

    private void btnEliminarVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarVerActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (contadorCuestionarioGlobal == 1) {
            comprobarRespuestaEstiloDeVida(ListaPreguntas.getRespuestasEstiloDeVida());
            if (contadorPreguntas == tamanoPregEstiloVida) {
                contadorPreguntas = 0;
                contadorRespuestas = 0;
                contadorCuestionarioGlobal = 2;
            }
        } else if (contadorCuestionarioGlobal == 2) {
            comprobarRespuestasHabitosAlimenticios(ListaPreguntas.getRespuestasHabitosAlimenticios());
            if (contadorPreguntas == ListaPreguntas.getHabitosAlimenticios().length) {
                contadorPreguntas = 0;
                contadorRespuestas = 0;
                contadorCuestionarioGlobal = 3;
            }
        }
        if (contadorCuestionarioGlobal == 1) {
            moverPreguntas(ListaPreguntas.getEstiloDeVida(cliente.getSexo().charAt(0), 21));
        } else if (contadorCuestionarioGlobal == 2) {
            titulo.setText("Habitos Alimenticios");
            moverPreguntas(ListaPreguntas.getHabitosAlimenticios());
        } else {
            JOptionPane.showMessageDialog(this, "Termino cuestionario");
            btnCancelarCuestionarioActionPerformed(evt);
            int[] respuestas = ListaPreguntas.getRespuestasCuestionario();
            for (int i = 0; i < respuestas.length; i++) {
                System.out.print(respuestas[i] + "  ");
            }
        }
        R1.setSelected(false);
        R2.setSelected(false);
        R3.setSelected(false);
        R4.setSelected(false);
        R5.setSelected(false);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void rbCuelloMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCuelloMedidasActionPerformed
        graficar("CUELLO");
    }//GEN-LAST:event_rbCuelloMedidasActionPerformed

    private void rbPechoMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPechoMedidasActionPerformed
        graficar("PECHO");
    }//GEN-LAST:event_rbPechoMedidasActionPerformed

    private void rbAlturaMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAlturaMedidasActionPerformed
        graficar("ALTURA");
    }//GEN-LAST:event_rbAlturaMedidasActionPerformed

    private void rbCinturaMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCinturaMedidasActionPerformed
        graficar("CINTURA");
    }//GEN-LAST:event_rbCinturaMedidasActionPerformed

    private void rbCaderaMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCaderaMedidasActionPerformed
        graficar("CADERA");
    }//GEN-LAST:event_rbCaderaMedidasActionPerformed

    private void rbPesoMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPesoMedidasActionPerformed
        graficar("PESO");
    }//GEN-LAST:event_rbPesoMedidasActionPerformed

    private void rbMunecaMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMunecaMedidasActionPerformed
        graficar("MUNECA");
    }//GEN-LAST:event_rbMunecaMedidasActionPerformed

    private void exportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarPDFActionPerformed
        try {
            CrearGraficaPDF.generarImagen(socio.getNombreCompleto(), cliente.getNombreCompleto(), chart);
            JOptionPane.showMessageDialog(this, "PDF exportado con exito");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Por favor genere una grafica");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Existe un documento abierto con el mismo nombre");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Ninguna grafica creada");
        } 
    }//GEN-LAST:event_exportarPDFActionPerformed

    private void dietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dietaActionPerformed
        setSize(550, 200);
        setLocationRelativeTo(null);
        menuBar.setVisible(false);
        panelCuestionario.setVisible(false);
        panelAgregarCliente.setVisible(false);
        panelVer.setVisible(false);
        panelPerfil.setVisible(false);
        panelSocio.setVisible(false);
        panelPrincipal.setVisible(false);
        panelIrDieta.setVisible(true);
        panelAlimentos.setVisible(false);
        txtDietas.setText("");
    }//GEN-LAST:event_dietaActionPerformed

    private void btnAceptarIrDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarIrDietaActionPerformed
        String nombre = txtDietas.getText();
        if (nombre.equals("")) {
            return;
        }
        try {
            cliente = fabricaDAO.getClienteDAO().verCliente(nombre, socio.getIdSocio());
            if (cliente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró al cliente");
                return;
            }
            medidas = fabricaDAO.getMedidasDAO().verUltimaMedidaCliente(cliente.getIdCliente());
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Aplicar cuestionario a\n"
                    + cliente.getNombreCompleto() + "?",
                    "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                configCboMacronutrientes();
                modeloTablaDieta = new DefaultTableModel(null, titulosDieta);
                configLblDiaSemana();
                llenarArregloDiaDieta();
                spnCantidad.setValue(1);
                setSize(1200, 450);
                setLocationRelativeTo(null);
                menuBar.setVisible(false);
                panelDieta.setVisible(true);
                panelIrDieta.setVisible(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Hubo un error de conexion o no se encontró al cliente");
        }
        
        
    }//GEN-LAST:event_btnAceptarIrDietaActionPerformed

    private void btnCancelarIrDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarIrDietaActionPerformed
        setSize(600, 400);
        setLocationRelativeTo(null);
        menuBar.setVisible(true);
        panelPrincipal.setVisible(true);
        panelIrDieta.setVisible(false);
    }//GEN-LAST:event_btnCancelarIrDietaActionPerformed

    private void cboComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboComidaActionPerformed
        // TODO add your handling code here:
        avisoDieta(cboComida.getSelectedIndex());
    }//GEN-LAST:event_cboComidaActionPerformed

    private void cboMacronutrientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMacronutrientesActionPerformed
        // TODO add your handling code here:
        int index = macronutrientes.get(cboMacronutrientes.getSelectedIndex()).getIdMacronutrientes();
        cboTipoAlimento.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Tipo de Alimento"}));
        configCboTipoAlimento(index);
    }//GEN-LAST:event_cboMacronutrientesActionPerformed

    private void cboTipoAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoAlimentoActionPerformed
        // TODO add your handling code here:
        int idCbo = cboTipoAlimento.getSelectedIndex();
        if (idCbo > 0) {
            int index = tipoAlimento.get(cboTipoAlimento.getSelectedIndex()-1).getIdTipoAlimento();
            modeloTablaAlimentos = new DefaultTableModel(null, titulosAlimentos);
            llenarTablaAlimentos(index, modeloTablaAlimentos);
            tblAlimentos.setModel(modeloTablaAlimentos);
        }

    }//GEN-LAST:event_cboTipoAlimentoActionPerformed

    private void btnAgregarDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDietaActionPerformed
        // TODO add your handling code here:
        filasel = tblAlimentos.getSelectedRow();
        int cant = Integer.parseInt(spnCantidad.getValue().toString());
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún alimento", "Error", 0);
        } else {
            if (cboComida.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(null, "Seleccione una comida", "Error", 0);
            }else{
                agregarAlimentoADieta(filasel, cant);
            }
        }
    }//GEN-LAST:event_btnAgregarDietaActionPerformed

    private void btnDiaAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiaAnteriorActionPerformed
        // TODO add your handling code here:
        diaAnterior();
        configLblDiaSemana();
        //        verSemana();

    }//GEN-LAST:event_btnDiaAnteriorActionPerformed

    private void btnDiaSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiaSiguienteActionPerformed
        diaSiguiente();
        configLblDiaSemana();
//                verSemana();
    }//GEN-LAST:event_btnDiaSiguienteActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        filasel = tblAlimentosDieta.getSelectedRow();
        if (filasel == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún alimento", "Error", 0);
        } else {
            modeloTablaDieta.removeRow(filasel);
            tblAlimentosDieta.setModel(modeloTablaDieta);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDietaActionPerformed
        // TODO add your handling code here:
        int seleccion = JOptionPane.showOptionDialog(
            this, // Componente padre
            "Está a punto de guardar la dieta de la semana ¿Desea continuar?", //Mensaje
            "Seleccione una opción", // Título
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null, // null para icono por defecto.
            new Object[]{"Si", "No"}, // null para YES, NO y CANCEL
            "Si");
        if (seleccion != -1) {
            if ((seleccion + 1) == 1) {
                // PRESIONO SI
                String sexo;
                if (cliente.getSexo().equals("F")) 
                    sexo = "Femenino";
                else 
                    sexo = "Masculino";
                CrearPDF crearPDF = new CrearPDF(arregloDiaDieta);
                crearPDF.createPdf();
                crearPDF.editarPDF("10/04/2015", socio.getNombreCompleto(), cliente.getNombreCompleto(), 22, sexo, medidas.getPecho(), (float) 17.2);
                JOptionPane.showMessageDialog(this, "Dieta creada con éxito");
                setSize(600, 400);
                setLocationRelativeTo(null);
                menuBar.setVisible(true);
                panelPrincipal.setVisible(true);
                panelDieta.setVisible(false);
            }else{
                //PRESIONO NO
            }
        }
    }//GEN-LAST:event_btnGuardarDietaActionPerformed

    private void spnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCantidadStateChanged
        // TODO add your handling code here
        if (spnCantidad.getValue().toString().equals("0")) {
            spnCantidad.setValue(spnCantidad.getNextValue());
            JOptionPane.showMessageDialog(null, "No se puede poner esa cantidad", "Error", 0);
        }
    }//GEN-LAST:event_spnCantidadStateChanged

    private void btnCancelarDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDietaActionPerformed
        setSize(600, 400);
        setLocationRelativeTo(null);
        menuBar.setVisible(true);
        panelPrincipal.setVisible(true);
        panelDieta.setVisible(false);
    }//GEN-LAST:event_btnCancelarDietaActionPerformed

    private void btnVerSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSocioActionPerformed
//        panelVerSocio.setVisible(false);
        panelInfoSocio.setVisible(true);
        setSize(820, 450);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_btnVerSocioActionPerformed

    private void btnVerTodosSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosSocioActionPerformed
//        panelVerSocio.setVisible(false);
//        panelVerTodos.setVisible(true);
//        setSize(560, 450);
//        setLocationRelativeTo(null);
    }//GEN-LAST:event_btnVerTodosSocioActionPerformed

    private void btnCancelarInfoSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarInfoSocioActionPerformed
        panelInfoSocio.setVisible(false);
//        panelVerSocio.setVisible(true);
        setSize(550, 200);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCancelarInfoSocioActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        panelVerTodos.setVisible(false);
        panelInfoSocio.setVisible(true);
        setSize(820, 450);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnCancelarVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVerTodosActionPerformed
        panelVerTodos.setVisible(false);
//        panelVerSocio.setVisible(true);
        setSize(550, 200);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCancelarVerTodosActionPerformed

    public void setAdminVisible(boolean isVisible) {
        menuHerramientas.setVisible(isVisible);
    }

    public void setDescargarEneable(boolean isEneable) {
        menuDescargar.setEnabled(isEneable);
    }

    private void generarDBHSQL() throws SQLException, ClassNotFoundException {
        File archivo = new File(urlDBHSQL);
        if (!archivo.exists()) {
            Conexion conexionTemporal = FabricaConexion.getConexionHSQL();
            FabricaDAO fabricaTemporal = new FabricaDAO(conexionTemporal);
            fabricaTemporal.getEstuturaDAO().crearTablas();
            fabricaTemporal.getEstuturaDAO().crearRelaciones();
            fabricaTemporal = null;
            conexionTemporal.desconectar();
            conexionTemporal = null;
        }
    }

    private void validarCliente() throws ExcepcionRegistro {
        if (txtNombreAgregar.getText().equals("")) {
            throw new ExcepcionRegistro("Escriba un nombre");
        }
        if (txtAPAgregar.getText().equals("")) {
            throw new ExcepcionRegistro("Escriba un apellido");
        }
        if (txtFNAgregar.getText().length() != 10) {
            throw new ExcepcionRegistro("Fecha de nacimiento invalida");
        }
        if (txtDirAgregar.getText().equals("")) {
            throw new ExcepcionRegistro("Escriba una direccion valida");
        }
        if (txtCorreoAgregar.getText().equals("")) {
            throw new ExcepcionRegistro("Escriba una direccion de correo valida");
        }
        if ((!radioMAgregar.isSelected()) && (!radioFAgregar.isSelected())) {
            throw new ExcepcionRegistro("Seleccione su sexo");
        }
        if (cboxPaisAgregar.getSelectedIndex() == 0) {
            throw new ExcepcionRegistro("Seleccione un pais");
        }
        if (cboxEstadoAgregar.getSelectedIndex() == 0) {
            throw new ExcepcionRegistro("Seleccione un estado");
        }
        if (txtFechaAgregar.getText().length() != 10) {
            throw new ExcepcionRegistro("Escriba una fecha valida: dd/mm/aaaa");
        }
    }

    private void guardarCliente() throws SQLException {
        cliente = new ObjetoCliente();
        cliente.setIdCliente(fabricaDAO.getClienteDAO().obtenerNuevaIdCliente(socio.getIdSocio()));
        cliente.setNombre(txtNombreAgregar.getText());
        cliente.setApellidoPaterno(txtAPAgregar.getText());
        cliente.setApellidoMaterno(txtAMAgregar.getText());
        cliente.setNombreCompleto();
        cliente.setFechaNacimiento(txtFNAgregar.getText());
        cliente.setDireccion(txtDirAgregar.getText());
        if (radioMAgregar.isSelected()) {
            cliente.setSexo("M");
        } else {
            cliente.setSexo("F");
        }
        cliente.setTelefono(txtTelAgregar.getText());
        cliente.setCorreo(txtCorreoAgregar.getText());
        int index = cboxEstadoAgregar.getSelectedIndex() - 1;
        cliente.setIdEstado(listaEstados.get(index).getId());
        cliente.setIdSocio(socio.getIdSocio());
        fabricaDAO.getClienteDAO().agregarCliente(cliente);
    }

    private void guardarMedidas() throws SQLException, NumberFormatException {
        medidas = new ObjetoMedidas();
        medidas.setCuello(Double.parseDouble(txtCuelloAgregar.getText()));
        medidas.setCintura(Double.parseDouble(txtCinturaAgregar.getText()));
        medidas.setMuneca(Double.parseDouble(txtMunecaAgregar.getText()));
        medidas.setPecho(Double.parseDouble(txtPechoAgregar.getText()));
        medidas.setCadera(Double.parseDouble(txtCaderaAgregar.getText()));
        medidas.setAltura(Double.parseDouble(txtAlturaAgregar.getText()));
        medidas.setPeso(Double.parseDouble(txtPesoAgregar.getText()));
        medidas.setFecha(txtFechaAgregar.getText());
        medidas.setIdCliente(cliente.getIdCliente());
        fabricaDAO.getMedidasDAO().agregarMedida(medidas);
    }

    private void limpiarAgregarCliente() {
        txtNombreAgregar.setText("");
        txtAPAgregar.setText("");
        txtAMAgregar.setText("");
        txtFNAgregar.setText("");
        txtDirAgregar.setText("");
        txtTelAgregar.setText("");
        txtCorreoAgregar.setText("");
        txtCuelloAgregar.setText("0.0");
        txtCinturaAgregar.setText("0.0");
        txtMunecaAgregar.setText("0.0");
        txtPechoAgregar.setText("0.0");
        txtCaderaAgregar.setText("0.0");
        txtAlturaAgregar.setText("0.0");
        txtPesoAgregar.setText("0.0");
        txtFechaAgregar.setText("");
        cboxPaisAgregar.setModel(new DefaultComboBoxModel(new String[]{"Seleccione Pais"}));
        cboxEstadoAgregar.setModel(new DefaultComboBoxModel(new String[]{"Seleccione Estado"}));
        avisoAgregarCliente.setText("");
    }

    private void limpiarVerCliente() {
        lblNombreVer.setText("");
        lblAPVer.setText("");
        lblAMVer.setText("");
        lblFNVer.setText("");
        lblSexoVer.setText("");
        lblPaisVer.setText("");

        cboxEstadoCliente2.setModel(new DefaultComboBoxModel(new String[]{""}));
        cboxEstadoCliente2.setEnabled(false);

        txtNCCliente.setText("");
        txtDirVer.setText("");
        txtDirVer.setEnabled(false);
        txtTelVer.setText("");
        txtTelVer.setEnabled(false);
        txtCorreoVer.setText("");
        txtCorreoVer.setEnabled(false);

        btnEditarVer.setEnabled(false);
        btnEliminarVer.setEnabled(false);
        btnGuardarVer.setEnabled(false);
        btnVerMedidas.setEnabled(false);
    }

    private void verDatosCliente() throws SQLException {
        lblNombreVer.setText(cliente.getNombre());
        lblAPVer.setText(cliente.getApellidoPaterno());
        lblAMVer.setText(cliente.getApellidoMaterno());
        lblFNVer.setText(cliente.getFechaNacimiento());
        lblSexoVer.setText(cliente.getSexo());

        estado = fabricaDAO.getEstadoDAO().verEstado(cliente.getIdEstado());
        cboxEstadoCliente2.setModel(new DefaultComboBoxModel(new String[]{estado.getNombre()}));
        pais = fabricaDAO.getPaisDAO().verPais(estado.getIdPais());
        lblPaisVer.setText(pais.getNombre());

        txtDirVer.setText(cliente.getDireccion());
        txtTelVer.setText(cliente.getTelefono());
        txtCorreoVer.setText(cliente.getCorreo());
    }

    private void validarGuardarVerCliente() throws SQLException, ExcepcionRegistro {
        if (txtDirVer.getText().equals("")) {
            throw new ExcepcionRegistro("Escriba una direccion");
        }
        if (txtTelVer.getText().equals("")) {
            throw new ExcepcionRegistro("Escriba un telefono");
        }
        if (txtCorreoVer.getText().equals("")) {
            throw new ExcepcionRegistro("Escriba un correo");
        }
        if (cboxEstadoCliente2.getSelectedIndex() == 0) {
            throw new ExcepcionRegistro("Seleccione un estado");
        }
    }

    private void guardarVerCliente() throws SQLException {
        cliente.setDireccion(txtDirVer.getText());
        cliente.setTelefono(txtTelVer.getText());
        cliente.setCorreo(txtCorreoVer.getText());
        int index = cboxEstadoCliente2.getSelectedIndex() - 1;
        cliente.setIdEstado(listaEstados.get(index).getId());

        fabricaDAO.getClienteDAO().modificarClienteVer(cliente);
    }

    private void moverPreguntas(String[] preguntas) {
        if (contadorPreguntas < preguntas.length) {
            L1.setText(preguntas[contadorPreguntas]);
            R1.setVisible(true);
            contadorPreguntas++;
        } else {
            L1.setText("");
            R1.setVisible(false);
        }
        if (contadorPreguntas < preguntas.length) {
            L2.setText(preguntas[contadorPreguntas]);
            R2.setVisible(true);
            contadorPreguntas++;
        } else {
            L2.setText("");
            R2.setVisible(false);
        }
        if (contadorPreguntas < preguntas.length) {
            L3.setText(preguntas[contadorPreguntas]);
            R3.setVisible(true);
            contadorPreguntas++;
        } else {
            L3.setText("");
            R3.setVisible(false);
        }
        if (contadorPreguntas < preguntas.length) {
            L4.setText(preguntas[contadorPreguntas]);
            R4.setVisible(true);
            contadorPreguntas++;
        } else {
            L4.setText("");
            R4.setVisible(false);
        }
        if (contadorPreguntas < preguntas.length) {
            L5.setText(preguntas[contadorPreguntas]);
            R5.setVisible(true);
            contadorPreguntas++;
        } else {
            L5.setText("");
            R5.setVisible(false);
        }
    }

    private void comprobarRespuestaEstiloDeVida(int[][] respuestas) {
        if (R1.isSelected() && (contadorRespuestas < respuestas.length)) {
            System.out.println("R1 seleccionado");
            for (int i = 0; i < respuestas[contadorRespuestas].length; i++) {
                ListaPreguntas.marcarRespuestasCuestionario(respuestas[contadorRespuestas][i]);
            }
        }
        contadorRespuestas++;
        if (R2.isSelected() && (contadorRespuestas < respuestas.length)) {
            System.out.println("R2 seleccionado");
            for (int i = 0; i < respuestas[contadorRespuestas].length; i++) {
                ListaPreguntas.marcarRespuestasCuestionario(respuestas[contadorRespuestas][i]);
            }
        }
        contadorRespuestas++;
        if (R3.isSelected() && (contadorRespuestas < respuestas.length)) {
            System.out.println("R3 seleccionado");
            for (int i = 0; i < respuestas[contadorRespuestas].length; i++) {
                ListaPreguntas.marcarRespuestasCuestionario(respuestas[contadorRespuestas][i]);
            }
        }
        contadorRespuestas++;
        if (R4.isSelected() && (contadorRespuestas < respuestas.length)) {
            System.out.println("R4 seleccionado");
            for (int i = 0; i < respuestas[contadorRespuestas].length; i++) {
                ListaPreguntas.marcarRespuestasCuestionario(respuestas[contadorRespuestas][i]);
            }
        }
        contadorRespuestas++;
        if (R5.isSelected() && (contadorRespuestas < respuestas.length)) {
            System.out.println("R5 seleccionado");
            for (int i = 0; i < respuestas[contadorRespuestas].length; i++) {
                ListaPreguntas.marcarRespuestasCuestionario(respuestas[contadorRespuestas][i]);
            }
        }
        contadorRespuestas++;
    }

    private void comprobarRespuestasHabitosAlimenticios(int[][] respuestas) {
        int isSelected;
        int tamano;
        if (contadorRespuestas < respuestas.length) {
            if (R1.isSelected()) {
                isSelected = 1;
            } else {
                isSelected = 0;
            }
            tamano = respuestas[contadorRespuestas].length - 1;
            if (isSelected == respuestas[contadorRespuestas][tamano]) {
                System.out.println("R1 entro");
                for (int i = 0; i < tamano; i++) {
                    ListaPreguntas.marcarRespuestasCuestionario(respuestas[contadorRespuestas][i]);
                }
            }
        }
        contadorRespuestas++;
        if (contadorRespuestas < respuestas.length) {
            if (R2.isSelected()) {
                isSelected = 1;
            } else {
                isSelected = 0;
            }
            tamano = respuestas[contadorRespuestas].length - 1;
            if (isSelected == respuestas[contadorRespuestas][tamano]) {
                System.out.println("R2 entro");
                for (int i = 0; i < tamano; i++) {
                    ListaPreguntas.marcarRespuestasCuestionario(respuestas[contadorRespuestas][i]);
                }
            }
        }
        contadorRespuestas++;
        if (contadorRespuestas < respuestas.length) {
            if (R3.isSelected()) {
                isSelected = 1;
            } else {
                isSelected = 0;
            }
            tamano = respuestas[contadorRespuestas].length - 1;
            if (isSelected == respuestas[contadorRespuestas][tamano]) {
                System.out.println("R3 entro");
                for (int i = 0; i < tamano; i++) {
                    ListaPreguntas.marcarRespuestasCuestionario(respuestas[contadorRespuestas][i]);
                }
            }
        }
        contadorRespuestas++;
        if (contadorRespuestas < respuestas.length) {
            if (R4.isSelected()) {
                isSelected = 1;
            } else {
                isSelected = 0;
            }
            tamano = respuestas[contadorRespuestas].length - 1;
            if (isSelected == respuestas[contadorRespuestas][tamano]) {
                System.out.println("R4 entro");
                for (int i = 0; i < tamano; i++) {
                    ListaPreguntas.marcarRespuestasCuestionario(respuestas[contadorRespuestas][i]);
                }
            }
        }
        contadorRespuestas++;
        if (contadorRespuestas < respuestas.length) {
            if (R5.isSelected()) {
                isSelected = 1;
            } else {
                isSelected = 0;
            }
            tamano = respuestas[contadorRespuestas].length - 1;
            if (isSelected == respuestas[contadorRespuestas][tamano]) {
                System.out.println("R5 entro");
                for (int i = 0; i < tamano; i++) {
                    ListaPreguntas.marcarRespuestasCuestionario(respuestas[contadorRespuestas][i]);
                }
            }
        }
        contadorRespuestas++;
    }

    private void llenarPerfil() throws SQLException {
        lblNombrePerfil.setText(socio.getNombre());
        lblAPPerfil.setText(socio.getApellidoPaterno());
        lblAMPerfil.setText(socio.getApellidoMaterno());
        lblFNPerfil.setText(socio.getFechaNacimiento());
        lblSexoPerfil.setText(socio.getSexo());

        estado = fabricaDAO.getEstadoDAO().verEstado(socio.getIdEstado());
        cboxEstadoPerfil.setModel(new DefaultComboBoxModel(new String[]{estado.getNombre()}));
        pais = fabricaDAO.getPaisDAO().verPais(estado.getIdPais());
        lblPaisPerfil.setText(pais.getNombre());

        txtDirPerfil.setText(socio.getDireccion());
        txtDirPerfil.setEnabled(false);
        txtTelPerfil.setText(socio.getTelefono());
        txtTelPerfil.setEnabled(false);
        txtCorreoPerfil.setText(socio.getCorreo());
        txtCorreoPerfil.setEnabled(false);

        cboxEstadoPerfil.setEnabled(false);
    }

    private void graficar(String tipoMedida) {
        try {
            listaMedidas = fabricaDAO.getMedidasDAO().verMedidasPorId(tipoMedida, cliente.getIdCliente());
            if (listaMedidas == null) {
                JOptionPane.showMessageDialog(this, "El cliente no tiene medidas o no existe");
                return;
            }
            String leyenda = listaMedidas.get(0).getFecha() + " - " + listaMedidas.get(listaMedidas.size() - 1).getFecha();
            listaMedidasAux = new ArrayList<>();
            for (int i = 0; i < listaMedidas.size(); i++) {
                listaMedidasAux.add(listaMedidas.get(i).getMedida());
            }
            chart = GenerarGrafica.graficaLinea(tipoMedida, leyenda, listaMedidasAux);
            chartPanel = new ChartPanel(chart);
            chartPanel.setBounds(0, 0, jPanel2.getWidth(), jPanel2.getHeight());
            jPanel2.removeAll();
            jPanel2.add(chartPanel);
            jPanel2.repaint();
            jPanel2.validate();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Posible error en los datos o en la conexion");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Posible error de conexion");
        }
    }
    
    public void configLblDiaSemana(){
        switch(contadorDiaVer){
            case 0: lblDiaSemana.setText("Lunes");
                break;
            case 1: lblDiaSemana.setText("Martes");
                break;
            case 2:
                lblDiaSemana.setText("Miércoles");
                break;
            case 3:
                lblDiaSemana.setText("Jueves");
                break;
            case 4:
                lblDiaSemana.setText("Viernes");
                break;
            case 5:
                lblDiaSemana.setText("Sábado");
                break;
            case 6:
                lblDiaSemana.setText("Domingo");
                break;
        }
    }
    
    private void configCboMacronutrientes(){
        
        try {
            macronutrientes = fabricaDAO.getMacronutrientesDAO().verMacronutrientes();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Posible error de conexion: " + ex.getMessage());
//            Logger.getLogger(Dietas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i <macronutrientes.size(); i++) {
            cboMacronutrientes.addItem(macronutrientes.get(i).getNombre());
        }
    }
    
    private void llenarArregloDiaDieta(){
         arregloDiaDieta = new ArrayList();
        for (int i = 0; i < 7; i++) {
            ObjetoDiaDieta obj = new ObjetoDiaDieta();
            arregloDiaDieta.add(obj);
            
        }
    }
    
    private void configCboTipoAlimento(int idMacronutriente){
        try {
            tipoAlimento = fabricaDAO.getTipoAlimentoDAO().verTipoAlimentoDeMacronutriente(idMacronutriente);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Posible error de conexion: " + ex.getMessage());
//            Logger.getLogger(Dietas.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < tipoAlimento.size(); i++) {
            cboTipoAlimento.addItem(tipoAlimento.get(i).getNombre());
        }
    }
    
    private void llenarTablaAlimentos(int idTipoAlimento, DefaultTableModel modeloTablaAlimentos){
        try {
            arregloAlimentos = fabricaDAO.getAlimentoDAO().verAlimentosDeTipoAlimentos(idTipoAlimento);
        } catch (SQLException e) {
            System.out.println(e);
        }
        for (int i = 0; i < arregloAlimentos.size(); i++) {
            alimento[0] = arregloAlimentos.get(i).getNombre();
            alimento[1] = arregloAlimentos.get(i).getPorcion() + " " + arregloAlimentos.get(i).getMedida();
            alimento[2] = arregloAlimentos.get(i).getCalorias()+"";
            
            modeloTablaAlimentos.addRow(alimento);
            tblAlimentos.setModel(modeloTablaAlimentos);

        }
    }
    
    private void agregarAlimentoADieta(int id, int cantidad){
//        modeloTablaAlimentos = (DefaultTableModel) tblAlimentos.getModel();
        String [] alimentoADieta = new String[5];
        
       
        alimentoADieta[0] = cboComida.getSelectedItem().toString();
         alimentoADieta[1] = ""+ cantidad;
        for (int i = 0; i < modeloTablaAlimentos.getColumnCount(); i++) {
            alimentoADieta[i+2] = (String) modeloTablaAlimentos.getValueAt(id, i);
        }
        modeloTablaDieta.addRow(alimentoADieta);
        tblAlimentosDieta.setModel(modeloTablaDieta);
    }

    private void avisoDieta(int index){
        switch(index){
            case 1: lblInformacionDieta.setText(desayuno);
                break;
            case 2: lblInformacionDieta.setText(refrigerio1);
                break;
            case 3: lblInformacionDieta.setText(almuerzo);
                break;
            case 4: lblInformacionDieta.setText(refrigerio2);
                break;
            case 5: lblInformacionDieta.setText(cena);
                break;
        }
    }
    
    private void guardarDiaDieta(){
        if (modeloTablaDieta.getRowCount()!=0) {
            
            arregloDiaDieta.get(contadorDiaVer).limpiarDesayuno();
            arregloDiaDieta.get(contadorDiaVer).limpiarRefrigerio1();
            arregloDiaDieta.get(contadorDiaVer).limpiarAlmuerzo();
            arregloDiaDieta.get(contadorDiaVer).limpiarRefrigerio2();
            arregloDiaDieta.get(contadorDiaVer).limpiarCena();
            
            for (int i = 0; i < modeloTablaDieta.getRowCount(); i++) {
                ObjetoAlimentoDieta alimentoDieta = new ObjetoAlimentoDieta();
                alimentoDieta.setComida(modeloTablaDieta.getValueAt(i, 0).toString());
                alimentoDieta.setCantidad(Integer.parseInt(modeloTablaDieta.getValueAt(i, 1).toString()));
                alimentoDieta.setNombre(modeloTablaDieta.getValueAt(i, 2).toString());
                alimentoDieta.setPorcion(modeloTablaDieta.getValueAt(i, 3).toString());
                alimentoDieta.setCalorias(modeloTablaDieta.getValueAt(i, 4).toString());
                
                if (alimentoDieta.getComida().equals("Desayuno")) {
                    arregloDiaDieta.get(contadorDiaVer).setDesayuno(alimentoDieta);
                }else{
                    if (alimentoDieta.getComida().equals("Refrigerio 1")) {
                         arregloDiaDieta.get(contadorDiaVer).setRefrigerio1(alimentoDieta);
                    }else{
                        if (alimentoDieta.getComida().equals("Refrigerio 2")) {
                             arregloDiaDieta.get(contadorDiaVer).setRefrigerio2(alimentoDieta);
                        }else{
                            if (alimentoDieta.getComida().equals("Almuerzo")) {
                                 arregloDiaDieta.get(contadorDiaVer).setAlmuerzo(alimentoDieta);
                            }else{
                                if (alimentoDieta.getComida().equals("Cena")) {
                                     arregloDiaDieta.get(contadorDiaVer).setCena(alimentoDieta);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void diaSiguiente(){
        if ((contadorDiaVer+1) < 7) {
          guardarDiaDieta();
          contadorDiaVer++;
          ponerDiaDietaEnTabla();
        }else{
            JOptionPane.showMessageDialog(null, "Ya ha creado 7 dias", "Error", 0);
        }
    }
    
    private void ponerDiaDietaEnTabla(){
        modeloTablaDieta = new DefaultTableModel(null, titulosDieta);
        for (int j = 0; j < arregloDiaDieta.get(contadorDiaVer).getDesayuno().size(); j++) {
                ponerDiaDieta[0] = (arregloDiaDieta.get(contadorDiaVer).getDesayuno().get(j).getComida());
                ponerDiaDieta[1] = (""+arregloDiaDieta.get(contadorDiaVer).getDesayuno().get(j).getCantidad());
                ponerDiaDieta[2] = (arregloDiaDieta.get(contadorDiaVer).getDesayuno().get(j).getNombre());
                ponerDiaDieta[3] = (arregloDiaDieta.get(contadorDiaVer).getDesayuno().get(j).getPorcion());
                ponerDiaDieta[4] = (arregloDiaDieta.get(contadorDiaVer).getDesayuno().get(j).getCalorias());
                modeloTablaDieta.addRow(ponerDiaDieta);
            }
            for (int j = 0; j < arregloDiaDieta.get(contadorDiaVer).getRefrigerio1().size(); j++) {
                ponerDiaDieta[0] = (arregloDiaDieta.get(contadorDiaVer).getRefrigerio1().get(j).getComida());
                ponerDiaDieta[1] = (""+arregloDiaDieta.get(contadorDiaVer).getRefrigerio1().get(j).getCantidad());
                ponerDiaDieta[2] = (arregloDiaDieta.get(contadorDiaVer).getRefrigerio1().get(j).getNombre());
                ponerDiaDieta[3] = (arregloDiaDieta.get(contadorDiaVer).getRefrigerio1().get(j).getPorcion());
                ponerDiaDieta[4] = (arregloDiaDieta.get(contadorDiaVer).getRefrigerio1().get(j).getCalorias());
                modeloTablaDieta.addRow(ponerDiaDieta);
            }
            for (int j = 0; j < arregloDiaDieta.get(contadorDiaVer).getAlmuerzo().size(); j++) {
                ponerDiaDieta[0] = (arregloDiaDieta.get(contadorDiaVer).getAlmuerzo().get(j).getComida());
                ponerDiaDieta[1] = (""+arregloDiaDieta.get(contadorDiaVer).getAlmuerzo().get(j).getCantidad());
                ponerDiaDieta[2] = (arregloDiaDieta.get(contadorDiaVer).getAlmuerzo().get(j).getNombre());
                ponerDiaDieta[3] = (arregloDiaDieta.get(contadorDiaVer).getAlmuerzo().get(j).getPorcion());
                ponerDiaDieta[4] = (arregloDiaDieta.get(contadorDiaVer).getAlmuerzo().get(j).getCalorias());
                modeloTablaDieta.addRow(ponerDiaDieta);
            }
            for (int j = 0; j < arregloDiaDieta.get(contadorDiaVer).getRefrigerio2().size(); j++) {
                ponerDiaDieta[0] = (arregloDiaDieta.get(contadorDiaVer).getRefrigerio2().get(j).getComida());
                ponerDiaDieta[1] = (""+arregloDiaDieta.get(contadorDiaVer).getRefrigerio2().get(j).getCantidad());
                ponerDiaDieta[2] = (arregloDiaDieta.get(contadorDiaVer).getRefrigerio2().get(j).getNombre());
                ponerDiaDieta[3] = (arregloDiaDieta.get(contadorDiaVer).getRefrigerio2().get(j).getPorcion());
                ponerDiaDieta[4] = (arregloDiaDieta.get(contadorDiaVer).getRefrigerio2().get(j).getCalorias());
                modeloTablaDieta.addRow(ponerDiaDieta);
            }
            for (int j = 0; j < arregloDiaDieta.get(contadorDiaVer).getCena().size(); j++) {
                ponerDiaDieta[0] = (arregloDiaDieta.get(contadorDiaVer).getCena().get(j).getComida());
                ponerDiaDieta[1] = (""+arregloDiaDieta.get(contadorDiaVer).getCena().get(j).getCantidad());
                ponerDiaDieta[2] = (arregloDiaDieta.get(contadorDiaVer).getCena().get(j).getNombre());
                ponerDiaDieta[3] = (arregloDiaDieta.get(contadorDiaVer).getCena().get(j).getPorcion());
                ponerDiaDieta[4] = (arregloDiaDieta.get(contadorDiaVer).getCena().get(j).getCalorias());
                modeloTablaDieta.addRow(ponerDiaDieta);
            }
            tblAlimentosDieta.setModel(modeloTablaDieta);
    }
    
    private void verSemana(){
        
        //Este for se mueve en los dias de la dieta.
        for (int i = 0; i < arregloDiaDieta.size(); i++) {
            //Desayuno
            for (int j = 0; j < arregloDiaDieta.get(i).getDesayuno().size(); j++) {
                System.out.print("  Cantidad: "+arregloDiaDieta.get(i).getDesayuno().get(j).getCantidad());
                System.out.print("  Nombre: "+arregloDiaDieta.get(i).getDesayuno().get(j).getNombre());
                System.out.print("  Porcion: "+arregloDiaDieta.get(i).getDesayuno().get(j).getPorcion());
            }
            for (int j = 0; j < arregloDiaDieta.get(i).getRefrigerio1().size(); j++) {
            //Refrigerio 1    
                System.out.print("  Cantidad: "+arregloDiaDieta.get(i).getRefrigerio1().get(j).getCantidad());
                System.out.print("  Nombre: "+arregloDiaDieta.get(i).getRefrigerio1().get(j).getNombre());
                System.out.print("  Porcion: "+arregloDiaDieta.get(i).getRefrigerio1().get(j).getPorcion());
            }
            for (int j = 0; j < arregloDiaDieta.get(i).getAlmuerzo().size(); j++) {
            //Almuerzo
                System.out.print("  Cantidad: "+arregloDiaDieta.get(i).getAlmuerzo().get(j).getCantidad());
                System.out.print("  Nombre: "+arregloDiaDieta.get(i).getAlmuerzo().get(j).getNombre());
                System.out.print("  Porcion: "+arregloDiaDieta.get(i).getAlmuerzo().get(j).getPorcion());
            }
            for (int j = 0; j < arregloDiaDieta.get(i).getRefrigerio2().size(); j++) {
            //Refrigerio 2
                System.out.print("  Cantidad: "+arregloDiaDieta.get(i).getRefrigerio2().get(j).getCantidad());
                System.out.print("  Nombre: "+arregloDiaDieta.get(i).getRefrigerio2().get(j).getNombre());
                System.out.print("  Porcion: "+arregloDiaDieta.get(i).getRefrigerio2().get(j).getPorcion());
            }
            for (int j = 0; j < arregloDiaDieta.get(i).getCena().size(); j++) {
                //Cena
                System.out.print("  Cantidad: "+arregloDiaDieta.get(i).getCena().get(j).getCantidad());
                System.out.print("  Nombre: "+arregloDiaDieta.get(i).getCena().get(j).getNombre());
                System.out.print("  Porcion: "+arregloDiaDieta.get(i).getCena().get(j).getPorcion());
            }
        }
    }
    
    private void diaAnterior(){
        if (contadorDiaVer > 0) {
            guardarDiaDieta();
            contadorDiaVer--;
            ponerDiaDietaEnTabla();
        }else{
            JOptionPane.showMessageDialog(null, "No hay día anterior", "Error", 0);
        }
    }

    /**
     *
     */
    public static void correr(ObjetoSocio socio, FabricaDAO fabricaDAO, Conexion conexion) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador(socio, fabricaDAO, conexion).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AgregarDatos;
    private javax.swing.JPanel AgregarMedidas;
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel L5;
    private javax.swing.JCheckBox R1;
    private javax.swing.JCheckBox R2;
    private javax.swing.JCheckBox R3;
    private javax.swing.JCheckBox R4;
    private javax.swing.JCheckBox R5;
    private javax.swing.JPanel VerDatos;
    private javax.swing.JPanel VerMedidas1;
    private javax.swing.JMenuItem agregar;
    private javax.swing.JMenuItem agregarAlimento;
    private javax.swing.JLabel avisoAgregarCliente;
    private javax.swing.JLabel avisoPerfil;
    private javax.swing.JButton btnAceptarCuest;
    private javax.swing.JButton btnAceptarIrDieta;
    private javax.swing.JButton btnAgregarDieta;
    private javax.swing.JButton btnAgregarSocio;
    private javax.swing.JButton btnBuscarVer;
    private javax.swing.JButton btnCancelarAgregar;
    private javax.swing.JButton btnCancelarAlimentos;
    private javax.swing.JButton btnCancelarCambiarContrasena;
    private javax.swing.JButton btnCancelarCuest;
    private javax.swing.JButton btnCancelarCuestionario;
    private javax.swing.JButton btnCancelarDieta;
    private javax.swing.JButton btnCancelarInfoSocio;
    private javax.swing.JButton btnCancelarIrDieta;
    private javax.swing.JButton btnCancelarMedidas;
    private javax.swing.JButton btnCancelarPerfil;
    private javax.swing.JButton btnCancelarSocio;
    private javax.swing.JButton btnCancelarVer;
    private javax.swing.JButton btnCancelarVerTodos;
    private javax.swing.JButton btnDiaAnterior;
    private javax.swing.JButton btnDiaSiguiente;
    private javax.swing.JButton btnEditaPerfil;
    private javax.swing.JButton btnEditarMedidas;
    private javax.swing.JButton btnEditarVer;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarSocio;
    private javax.swing.JButton btnEliminarVer;
    private javax.swing.JButton btnGuardarAgregar;
    private javax.swing.JButton btnGuardarAlimentos;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnGuardarDieta;
    private javax.swing.JButton btnGuardarMedidas;
    private javax.swing.JButton btnGuardarPerfil;
    private javax.swing.JButton btnGuardarVer;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVer;
    private javax.swing.JButton btnVerMedidas;
    private javax.swing.JButton btnVerSocio;
    private javax.swing.JButton btnVerTodosSocio;
    private javax.swing.JComboBox cboComida;
    private javax.swing.JComboBox cboMacronutrientes;
    private javax.swing.JComboBox cboTipoAlimento;
    private javax.swing.JComboBox cboxEstadoAgregar;
    private javax.swing.JComboBox cboxEstadoCliente2;
    private javax.swing.JComboBox cboxEstadoPerfil;
    private javax.swing.JComboBox cboxPaisAgregar;
    private javax.swing.JComboBox cboxTipoAlimentos;
    private javax.swing.JMenuItem cuestionario;
    private javax.swing.JMenuItem descargarDB;
    private javax.swing.JMenuItem dieta;
    private javax.swing.JButton exportarPDF;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblAMPerfil;
    private javax.swing.JLabel lblAMSocio;
    private javax.swing.JLabel lblAMVer;
    private javax.swing.JLabel lblAPPerfil;
    private javax.swing.JLabel lblAPSocio;
    private javax.swing.JLabel lblAPVer;
    private javax.swing.JLabel lblAlturaMedidas;
    private javax.swing.JLabel lblCaderaMedidas;
    private javax.swing.JLabel lblCambiarPass;
    private javax.swing.JLabel lblCinturaMedidas;
    private javax.swing.JLabel lblCorreoSocio;
    private javax.swing.JLabel lblCuelloMedidas;
    private javax.swing.JLabel lblDiaSemana;
    private javax.swing.JLabel lblDireccionSocio;
    private javax.swing.JLabel lblEstadoSocio;
    private javax.swing.JLabel lblFNPerfil;
    private javax.swing.JLabel lblFNSocio;
    private javax.swing.JLabel lblFNVer;
    private javax.swing.JLabel lblFechaMedidas;
    private javax.swing.JLabel lblInformacionDieta;
    private javax.swing.JLabel lblMunecaMedidas;
    private javax.swing.JLabel lblNombrePerfil;
    private javax.swing.JLabel lblNombreSocio;
    private javax.swing.JLabel lblNombreVer;
    private javax.swing.JLabel lblPaisPerfil;
    private javax.swing.JLabel lblPaisSocio;
    private javax.swing.JLabel lblPaisVer;
    private javax.swing.JLabel lblPechoMedidas;
    private javax.swing.JLabel lblPesoMedidas;
    private javax.swing.JLabel lblSexoPerfil;
    private javax.swing.JLabel lblSexoSocio;
    private javax.swing.JLabel lblSexoVer;
    private javax.swing.JLabel lblTelSocio;
    private javax.swing.JMenu menuAlimentos;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuDescargar;
    private javax.swing.JMenu menuHerramientas;
    private javax.swing.JMenu menuNuevo;
    private javax.swing.JMenu menuPerfil;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JPanel panelAgregarCliente;
    private javax.swing.JPanel panelAlimentos;
    private javax.swing.JPanel panelCambiarContrasena;
    private javax.swing.JPanel panelCuestionario;
    private javax.swing.JPanel panelDieta;
    private javax.swing.JPanel panelInfoSocio;
    private javax.swing.JPanel panelIrCuestionario;
    private javax.swing.JPanel panelIrDieta;
    private javax.swing.JPanel panelMedidas;
    private javax.swing.JPanel panelPerfil;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSocio;
    private javax.swing.JPanel panelVer;
    private javax.swing.JPanel panelVerTodos;
    private javax.swing.JRadioButton radioFAgregar;
    private javax.swing.JRadioButton radioMAgregar;
    private javax.swing.JRadioButton rbAlturaMedidas;
    private javax.swing.JRadioButton rbCaderaMedidas;
    private javax.swing.JRadioButton rbCinturaMedidas;
    private javax.swing.JRadioButton rbCuelloMedidas;
    private javax.swing.JRadioButton rbMunecaMedidas;
    private javax.swing.JRadioButton rbPechoMedidas;
    private javax.swing.JRadioButton rbPesoMedidas;
    private javax.swing.JMenuItem salir;
    private javax.swing.JMenuItem socios;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JMenuItem subirDB;
    private javax.swing.JTable tblAlimentos;
    private javax.swing.JTable tblAlimentosDieta;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtAMAgregar;
    private javax.swing.JTextField txtAPAgregar;
    private javax.swing.JPasswordField txtActualPass;
    private javax.swing.JTextField txtAlturaAgregar;
    private javax.swing.JTextField txtAlturaVer1;
    private javax.swing.JTextField txtCaderaAgregar;
    private javax.swing.JTextField txtCaderaVer1;
    private javax.swing.JTextField txtCalorias;
    private javax.swing.JTextField txtCinturaAgregar;
    private javax.swing.JTextField txtCinturaVer1;
    private javax.swing.JTextField txtClienteCuest;
    private javax.swing.JTextField txtCorreoAgregar;
    private javax.swing.JTextField txtCorreoPerfil;
    private javax.swing.JTextField txtCorreoVer;
    private javax.swing.JTextField txtCuelloAgregar;
    private javax.swing.JTextField txtCuelloVer1;
    private javax.swing.JTextField txtDietas;
    private javax.swing.JTextField txtDirAgregar;
    private javax.swing.JTextField txtDirPerfil;
    private javax.swing.JTextField txtDirVer;
    private javax.swing.JTextField txtFNAgregar;
    private javax.swing.JTextField txtFechaAgregar;
    private javax.swing.JTextField txtFechaVer1;
    private javax.swing.JTextField txtMunecaAgregar;
    private javax.swing.JTextField txtMunecaVer1;
    private javax.swing.JTextField txtNCCliente;
    private javax.swing.JTextField txtNombreAgregar;
    private javax.swing.JTextField txtNombreAlimentos;
    private javax.swing.JPasswordField txtNuevoPass;
    private javax.swing.JTextField txtNumSocio;
    private javax.swing.JTextField txtPechoAgregar;
    private javax.swing.JTextField txtPechoVer1;
    private javax.swing.JTextField txtPesoAgregar;
    private javax.swing.JTextField txtPesoVer1;
    private javax.swing.JTextField txtPorcion;
    private javax.swing.JPasswordField txtRepetirPass;
    private javax.swing.JTextField txtTelAgregar;
    private javax.swing.JTextField txtTelPerfil;
    private javax.swing.JTextField txtTelVer;
    private javax.swing.JMenuItem ver;
    private javax.swing.JMenuItem verAlimentos;
    private javax.swing.JMenuItem verPerfil;
    // End of variables declaration//GEN-END:variables
}
