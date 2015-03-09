package uniandes.cupi2.numeroMvc.interfaz.color;


/** 
 * Panel Vista-Controlador de la visualizaci�n Tipo Color.
 */
public class PanelColor extends javax.swing.JPanel implements java.awt.event.ActionListener , java.util.Observer {
    /** 
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = 164393480331818959L;
    
    /** 
     * Constante para la acci�n del bot�n de selecci�nar color.
     */
    private static final java.lang.String SELECCIONAR_COLOR = "Seleccionar Color";
    
    /** 
     * Modelo: Numero que se est� visualizando.
     */
    private uniandes.cupi2.numeroMvc.mundo.Numero numero;
    
    /** 
     * Vista: Visualizaci�n del Color.
     */
    private javax.swing.JLabel etiquetaNumero;
    
    /** 
     * Control: Bot�n de env�o de el cambio de n�mero.
     */
    private javax.swing.JButton botonCambiar;
    
    /** 
     * Constructor del panel.
     * @param num N�mero a visualizar.
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
     * M�todo llamado por JAVA al salir el panel de la vista del usuario.
     */
    public void removeNotify() {
        numero.deleteObserver(this);
    }
    
    /** 
     * Control: Selecciona un color y modifica el n�mero.
     */
    public void cambiarColor() {
        java.awt.Color nuevoColor = javax.swing.JColorChooser.showDialog(this ,"Seleccione el color" ,etiquetaNumero.getBackground());
        if (nuevoColor != null)
            numero.cambiarNumero((16777216 + (nuevoColor.getRGB())));
        
    }
    
    /** 
     * Vista: Recibe la notificaci�n de cambio de valor del n�mero.
     */
    public void update(java.util.Observable sender, java.lang.Object num) {
        java.lang.Integer numero = ((java.lang.Integer)(num));
        etiquetaNumero.setBackground(new java.awt.Color(numero.intValue()));
    }
    
    /** 
     * Manejo de los eventos de los botones
     * @param e Acci�n que gener� el evento.
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        java.lang.String comando = e.getActionCommand();
        if (SELECCIONAR_COLOR.equals(comando))
            cambiarColor();
        
    }
    
}

