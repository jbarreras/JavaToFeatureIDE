package uniandes.cupi2.numeroMvc.interfaz.notas;


/** 
 * Panel Vista-Controlador de la visualizaci�n Tipo Nota Musical.
 */
public class PanelNotas extends javax.swing.JPanel implements java.awt.event.ActionListener , java.util.Observer {
    /** 
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = 8169100775679594866L;
    
    /** 
     * Constante para la acci�n del bot�n de seleccionar nota.
     */
    private static final java.lang.String CAMBIAR = "Seleccionar Nota";
    
    /** 
     * Constante para la acci�n del bot�n de tocar nota.
     */
    private static final java.lang.String TOCAR = "Tocar";
    
    /** 
     * Modelo: N�mero que se est� modificando.
     */
    private uniandes.cupi2.numeroMvc.mundo.Numero numero;
    
    /** 
     * Vista: Visualizaci�n de la Nota Musical.
     */
    private javax.swing.JLabel etiquetaNumero;
    
    /** 
     * Control: Bot�n de env�o de el cambio nota.
     */
    private javax.swing.JButton botonCambiar;
    
    /** 
     * Bot�n para tocar la nota
     */
    private javax.swing.JButton botonTocar;
    
    /** 
     * Constructor del panel
     * @param num N�mero a visualizar
     */
    public PanelNotas(uniandes.cupi2.numeroMvc.mundo.Numero num) {
        numero = num;
        setLayout(new java.awt.BorderLayout());
        setSize(261 ,106);
        etiquetaNumero = new javax.swing.JLabel();
        etiquetaNumero.setText("###");
        etiquetaNumero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNumero.setForeground(new java.awt.Color(128 , 130 , 159));
        etiquetaNumero.setFont(new java.awt.Font("Tahoma" , java.awt.Font.BOLD , 12));
        botonCambiar = new javax.swing.JButton();
        botonCambiar.setText(CAMBIAR);
        botonCambiar.setActionCommand(CAMBIAR);
        botonCambiar.addActionListener(this);
        botonTocar = new javax.swing.JButton();
        botonTocar.setText(TOCAR);
        botonTocar.setActionCommand(TOCAR);
        botonTocar.addActionListener(this);
        javax.swing.JPanel panelControl = new javax.swing.JPanel();
        panelControl.setLayout(new java.awt.BorderLayout());
        panelControl.add(botonCambiar ,java.awt.BorderLayout.CENTER);
        panelControl.add(botonTocar ,java.awt.BorderLayout.EAST);
        add(etiquetaNumero ,java.awt.BorderLayout.CENTER);
        add(panelControl ,java.awt.BorderLayout.SOUTH);
        numero.addObserver(this);
        etiquetaNumero.setText((((("Frecuencia Musical: " + (darNota(numero.darNumero()))) + " (") + (numero.darNumero())) + ")"));
    }
    
    /** 
     * M�todo llamado por JAVA al salir el panel de la vista del usuario.
     */
    public void removeNotify() {
        numero.deleteObserver(this);
    }
    
    /** 
     * Control: Reemplaza el n�mero visualizado con el n�mero representado por la nota ingresada por el usuario.
     */
    public void cambiarNota() {
        java.lang.Object[] notas = new java.lang.Object[]{ "Do" , "Re" , "Mi" , "Fa" , "Sol" , "La" , "Si" };
        java.lang.String nota = ((java.lang.String)(javax.swing.JOptionPane.showInputDialog(this ,"Nota" ,"Nota" ,javax.swing.JOptionPane.QUESTION_MESSAGE ,null ,notas ,"Do")));
        if (nota != null) {
            int numeroNota = 0;
            if ("Do".equals(nota))
                numeroNota = 50;
            else if ("Re".equals(nota))
                numeroNota = 52;
            else if ("Mi".equals(nota))
                numeroNota = 54;
            else if ("Fa".equals(nota))
                numeroNota = 55;
            else if ("Sol".equals(nota))
                numeroNota = 57;
            else if ("La".equals(nota))
                numeroNota = 59;
            else if ("Si".equals(nota))
                numeroNota = 61;
            
            numero.cambiarNumero(numeroNota);
        } 
    }
    
    /** 
     * Vista: Toca la nota equivalente al n�mero visualizado.
     */
    public void tocarNota() {
        uniandes.cupi2.numeroMvc.interfaz.notas.ReproductorNota.tocarNota(darNota(numero.darNumero()) ,0);
    }
    
    /** 
     * Vista: Retorna la nota que se representa con un n�mero.
     * @param numero N�mero a representar.
     * @return Nota representada por el n�mero ingresado.
     */
    public int darNota(int numero) {
        int nota = (numero % 100) + 10;
        return nota;
    }
    
    /** 
     * Vista: Recibe la notificaci�n de cambio de valor del n�mero.
     */
    public void update(java.util.Observable sender, java.lang.Object num) {
        java.lang.Integer numero = ((java.lang.Integer)(num));
        etiquetaNumero.setText((((("Frecuencia Musical: " + (darNota(numero.intValue()))) + " (") + (numero.intValue())) + ")"));
        tocarNota();
    }
    
    /** 
     * Manejo de los eventos de los botones.
     * @param e Acci�n que gener� el evento.
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        java.lang.String comando = e.getActionCommand();
        if (CAMBIAR.equals(comando))
            cambiarNota();
        
    }
    
}

