package uniandes.cupi2.numeroMvc.interfaz.numero;


/** 
 * Panel Vista-Controlador de la visualización Tipo Decimal.
 */
public class PanelNumero extends javax.swing.JPanel implements java.awt.event.ActionListener , java.util.Observer {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = 8638090313032173271L;
    
    /** 
     * Constante para la acción del botón de cambiar número.
     */
    private static final java.lang.String CAMBIAR = "Cambiar";
    
    /** 
     * Modelo: Número que se está modificando.
     */
    private uniandes.cupi2.numeroMvc.mundo.Numero numero;
    
    /** 
     * Vista: Visualización del Número.
     */
    private javax.swing.JLabel etiquetaNumero;
    
    /** 
     * Control: Botón de envío de el cambio de número.
     */
    private javax.swing.JButton botonCambiar;
    
    /** 
     * Control: Campo de texto para el cambio de número.
     */
    private javax.swing.JTextField textoNumero;
    
    /** 
     * Constructor del panel.
     * @param num Número a visualizar.
     */
    public PanelNumero(uniandes.cupi2.numeroMvc.mundo.Numero num) {
        numero = num;
        setLayout(new java.awt.BorderLayout());
        setSize(261 ,106);
        etiquetaNumero = new javax.swing.JLabel();
        etiquetaNumero.setText("###");
        etiquetaNumero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNumero.setForeground(new java.awt.Color(128 , 130 , 159));
        etiquetaNumero.setFont(new java.awt.Font("Tahoma" , java.awt.Font.BOLD , 24));
        botonCambiar = new javax.swing.JButton();
        botonCambiar.setText(CAMBIAR);
        botonCambiar.setActionCommand(CAMBIAR);
        botonCambiar.addActionListener(this);
        textoNumero = new javax.swing.JTextField();
        javax.swing.JPanel panelControl = new javax.swing.JPanel();
        panelControl.setLayout(new java.awt.BorderLayout());
        panelControl.add(botonCambiar ,java.awt.BorderLayout.EAST);
        panelControl.add(textoNumero ,java.awt.BorderLayout.CENTER);
        add(etiquetaNumero ,java.awt.BorderLayout.CENTER);
        add(panelControl ,java.awt.BorderLayout.SOUTH);
        numero.addObserver(this);
        etiquetaNumero.setText(java.lang.Integer.toString(numero.darNumero()));
    }
    
    /** 
     * Método llamado por JAVA al salir el panel de la vista del usuario.
     */
    public void removeNotify() {
        numero.deleteObserver(this);
    }
    
    /** 
     * Control: Reemplaza el número visualizado con el número escrito en el campo de texto.
     */
    public void modificarNumero() {
        try {
            int nuevoNumero = java.lang.Integer.parseInt(textoNumero.getText());
            numero.cambiarNumero(nuevoNumero);
        } catch (java.lang.NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this ,"El número especificado es inválido" ,"Error" ,javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** 
     * Vista: Recibe la notificación de cambio de valor del número.
     */
    public void update(java.util.Observable sender, java.lang.Object num) {
        java.lang.Integer numero = ((java.lang.Integer)(num));
        textoNumero.setText("");
        etiquetaNumero.setText(numero.toString());
    }
    
    /** 
     * Manejo de los eventos de los botones.
     * @param e Acción que generó el evento.
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        java.lang.String comando = e.getActionCommand();
        if (CAMBIAR.equals(comando))
            modificarNumero();
        
    }
    
}

