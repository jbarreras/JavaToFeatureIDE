package uniandes.cupi2.numeroMvc.interfaz.romano;


/** 
 * Panel Vista-Controlador de la visualización Tipo Romano.
 */
public class PanelRomano extends javax.swing.JPanel implements java.awt.event.ActionListener , java.util.Observer {
    /** 
     * Constante de serialización.
     */
    private static final long serialVersionUID = 6027780429950087974L;
    
    /** 
     * Constante para la acción del botón anterior.
     */
    private static final java.lang.String ANTERIOR = "Anterior";
    
    /** 
     * Constante para la acción del botón siguiente.
     */
    private static final java.lang.String SIGUIENTE = "Siguiente";
    
    /** 
     * Valores de las letras.
     */
    private static int[] numeros = new int[]{ 1000 , 900 , 500 , 400 , 100 , 90 , 50 , 40 , 10 , 9 , 5 , 4 , 1 };
    
    /** 
     * Letras de los números romanos.
     */
    private static java.lang.String[] letras = new java.lang.String[]{ "M" , "CM" , "D" , "CD" , "C" , "XC" , "L" , "XL" , "X" , "IX" , "V" , "IV" , "I" };
    
    /** 
     * Modelo: Número que se está modificando.
     */
    private uniandes.cupi2.numeroMvc.mundo.Numero numero;
    
    /** 
     * Vista: Visualización del Número en Romano.
     */
    private javax.swing.JLabel etiquetaNumero;
    
    /** 
     * Control: Botón Siguiente.
     */
    private javax.swing.JButton botonSiguiente;
    
    /** 
     * Control: Botón de Anterior.
     */
    private javax.swing.JButton botonAnterior;
    
    /** 
     * Constructor del panel.
     * @param num Número a visualizar.
     */
    public PanelRomano(uniandes.cupi2.numeroMvc.mundo.Numero num) {
        numero = num;
        setLayout(new java.awt.BorderLayout());
        setSize(261 ,106);
        etiquetaNumero = new javax.swing.JLabel();
        etiquetaNumero.setText("###");
        etiquetaNumero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNumero.setForeground(java.awt.Color.BLACK);
        etiquetaNumero.setFont(new java.awt.Font("Times New Roman" , java.awt.Font.BOLD , 24));
        botonAnterior = new javax.swing.JButton();
        botonAnterior.setText(ANTERIOR);
        botonAnterior.setActionCommand(ANTERIOR);
        botonAnterior.addActionListener(this);
        botonSiguiente = new javax.swing.JButton();
        botonSiguiente.setText(SIGUIENTE);
        botonSiguiente.setActionCommand(SIGUIENTE);
        botonSiguiente.addActionListener(this);
        javax.swing.JPanel panelControl = new javax.swing.JPanel();
        panelControl.setLayout(new java.awt.BorderLayout());
        panelControl.add(botonSiguiente ,java.awt.BorderLayout.EAST);
        panelControl.add(botonAnterior ,java.awt.BorderLayout.WEST);
        add(etiquetaNumero ,java.awt.BorderLayout.CENTER);
        add(panelControl ,java.awt.BorderLayout.SOUTH);
        numero.addObserver(this);
        etiquetaNumero.setText(darRomano(numero.darNumero()));
    }
    
    /** 
     * Método llamado por JAVA al salir el panel de la vista del usuario.
     */
    public void removeNotify() {
        numero.deleteObserver(this);
    }
    
    /** 
     * Vista: Retorna el número en representación romana.
     * @param num Número a convertir.
     * @return Representación en números romanos del número ingresado.
     */
    public java.lang.String darRomano(int num) {
        if (num <= 0) {
            return "Numero <= 0!";
        } else if (num > 3999) {
            return "Numero > 3999!";
        } 
        java.lang.String romano = "";
        int numeroActual = num;
        for (int i = 0 ; i < (uniandes.cupi2.numeroMvc.interfaz.romano.PanelRomano.numeros.length) ; i++) {
            while (numeroActual >= (uniandes.cupi2.numeroMvc.interfaz.romano.PanelRomano.numeros[i])) {
                romano += uniandes.cupi2.numeroMvc.interfaz.romano.PanelRomano.letras[i];
                numeroActual -= uniandes.cupi2.numeroMvc.interfaz.romano.PanelRomano.numeros[i];
            }
        }
        return romano;
    }
    
    /** 
     * Control: Resta 1 al número visualizado.
     */
    public void anterior() {
        numero.cambiarNumero(((numero.darNumero()) - 1));
    }
    
    /** 
     * Control: Suma 1 al número visualizado.
     */
    public void siguiente() {
        numero.cambiarNumero(((numero.darNumero()) + 1));
    }
    
    /** 
     * Vista: Recibe la notificación de cambio de valor del número.
     */
    public void update(java.util.Observable sender, java.lang.Object num) {
        java.lang.Integer numero = ((java.lang.Integer)(num));
        etiquetaNumero.setText(darRomano(numero.intValue()));
    }
    
    /** 
     * Manejo de los eventos de los botones.
     * @param e Acción que generó el evento.
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        java.lang.String comando = e.getActionCommand();
        if (ANTERIOR.equals(comando))
            anterior();
        else if (SIGUIENTE.equals(comando))
            siguiente();
        
    }
    
}

