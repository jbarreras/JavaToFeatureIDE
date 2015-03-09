package uniandes.cupi2.numeroMvc.interfaz.color;


/** 
 * Panel Vista-Controlador de la visualización Tipo Color.
 */
public class PanelColor extends javax.swing.JPanel implements java.awt.event.ActionListener , java.util.Observer {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = 164393480331818959L;
    
    /** 
     * Constante para la acción del botón de selecciónar color.
     */
    private static final java.lang.String SELECCIONAR_COLOR = "Seleccionar Color";
    
    /** 
     * Modelo: Numero que se está visualizando.
     */
    private uniandes.cupi2.numeroMvc.mundo.Numero numero;
    
    /** 
     * Vista: Visualización del Color.
     */
    private javax.swing.JLabel etiquetaNumero;
    
    /** 
     * Control: Botón de envío de el cambio de número.
     */
    private javax.swing.JButton botonCambiar;
    
    /** 
     * Constructor del panel.
     * @param num Número a visualizar.
     */
    public PanelColor(uniandes.cupi2.numeroMvc.mundo.Numero num) {
        numero = num;
        setLayout(new java.awt.BorderLayout());
        setSize(261 ,106);
        etiquetaNumero = new javax.swing.JLabel();
        etiquetaNumero.setText("");
        etiquetaNumero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNumero.setForeground(new java.awt.Color(128 , 130 , 159));
        etiquetaNumero.setFont(new java.awt.Font("Tahoma" , java.awt.Font.BOLD , 24));
        etiquetaNumero.setOpaque(true);
        botonCambiar = new javax.swing.JButton();
        botonCambiar.setText(SELECCIONAR_COLOR);
        botonCambiar.setActionCommand(SELECCIONAR_COLOR);
        botonCambiar.addActionListener(this);
        javax.swing.JPanel panelControl = new javax.swing.JPanel();
        panelControl.setLayout(new java.awt.BorderLayout());
        panelControl.add(botonCambiar ,java.awt.BorderLayout.CENTER);
        add(etiquetaNumero ,java.awt.BorderLayout.CENTER);
        add(panelControl ,java.awt.BorderLayout.SOUTH);
        numero.addObserver(this);
        etiquetaNumero.setBackground(new java.awt.Color(numero.darNumero()));
    }
    
    /** 
     * Método llamado por JAVA al salir el panel de la vista del usuario.
     */
    public void removeNotify() {
        numero.deleteObserver(this);
    }
    
    /** 
     * Control: Selecciona un color y modifica el número.
     */
    public void cambiarColor() {
        java.awt.Color nuevoColor = javax.swing.JColorChooser.showDialog(this ,"Seleccione el color" ,etiquetaNumero.getBackground());
        if (nuevoColor != null)
            numero.cambiarNumero((16777216 + (nuevoColor.getRGB())));
        
    }
    
    /** 
     * Vista: Recibe la notificación de cambio de valor del número.
     */
    public void update(java.util.Observable sender, java.lang.Object num) {
        java.lang.Integer numero = ((java.lang.Integer)(num));
        etiquetaNumero.setBackground(new java.awt.Color(numero.intValue()));
    }
    
    /** 
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        java.lang.String comando = e.getActionCommand();
        if (SELECCIONAR_COLOR.equals(comando))
            cambiarColor();
        
    }
    
}

